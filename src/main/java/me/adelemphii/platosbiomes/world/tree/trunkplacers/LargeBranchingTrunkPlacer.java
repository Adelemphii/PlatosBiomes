package me.adelemphii.platosbiomes.world.tree.trunkplacers;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import me.adelemphii.platosbiomes.utility.ModFeatureUtils;
import me.adelemphii.platosbiomes.utility.VoxelBresenhamIterator;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BiConsumer;

public class LargeBranchingTrunkPlacer extends TrunkPlacer {
    public static final Codec<LargeBranchingTrunkPlacer> CODEC = RecordCodecBuilder.create(instance ->
            trunkPlacerParts(instance).and(instance.group(
                    BranchesConfig.CODEC.fieldOf("branch_config").forGetter(o -> o.branchesConfig),
                    Codec.BOOL.fieldOf("perpendicular_branches").forGetter(o -> o.perpendicularBranches),
                    Codec.intRange(0, 24).fieldOf("branch_start_offset_down").forGetter(o -> o.branchDownwardOffset)
            )).apply(instance, LargeBranchingTrunkPlacer::new)
    );

    private final int minTreeHeight;
    private final int minRandHeight;
    private final int maxRandHeight;

    private final BranchesConfig branchesConfig;
    private final int branchDownwardOffset;
    private final boolean perpendicularBranches;

    // the max for all of these are hardcoded to be lower than I want, so I'm gonna make my own variables
    public LargeBranchingTrunkPlacer(int baseHeight, int randMinHeight, int randMaxHeight,
                                     BranchesConfig branchesConfig, boolean perpendicularBranches, int branchDownwardOffset) {
        super(32, 1, 24);
        this.minTreeHeight = 70;
        this.minRandHeight = 1;
        this.maxRandHeight = 30;

        this.branchesConfig = branchesConfig;
        this.perpendicularBranches = perpendicularBranches;
        this.branchDownwardOffset = branchDownwardOffset;
    }

    @Override
    protected @NotNull TrunkPlacerType<?> type() {
        return PlatosTrunkPlacerType.MEGA_STRAIGHT_TRUNK_PLACER.get();
    }

    public @NotNull List<FoliagePlacer.FoliageAttachment>
    placeTrunk(@NotNull LevelSimulatedReader levelReader, @NotNull BiConsumer<BlockPos, BlockState> blockSetter, @NotNull RandomSource random,
               int treeHeight, BlockPos blockPos, @NotNull TreeConfiguration config) {
        List<FoliagePlacer.FoliageAttachment> leafAttachments = new ArrayList<>();
        treeHeight = minTreeHeight + random.nextIntBetweenInclusive(minRandHeight, maxRandHeight);

        setDirtAt(levelReader, blockSetter, random, blockPos.below(), config);

        // Calculate the width range based on the tree height
        UniformInt widthRange = calculateWidth(treeHeight);
        int midHeight = treeHeight / 2;

        for (int i = 0; i < treeHeight; ++i) {
            // Calculate the current width for the given height
            int currentWidth = calculateCurrentWidth(widthRange, i, midHeight);

            BlockPos logPos = blockPos.above(i);
            boolean placed = this.placeLog(levelReader, blockSetter, random, logPos, config);

            List<BlockPos> sphereLayer = generateSphereLayer(logPos, currentWidth);
            for(BlockPos pos : sphereLayer) {
                this.placeLog(levelReader, blockSetter, random, pos, config);
            }

            if(!placed) {
                treeHeight = i;
                break;
            }
        }
        BlockPos pos = new BlockPos(blockPos.getX(), treeHeight, blockPos.getZ());
        this.placeLog(levelReader, blockSetter, random, pos, config);

        int numBranches = this.branchesConfig.getBranchCount() + random.nextInt(this.branchesConfig.getRandomAddBranches());
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        for (int b = 0; b < numBranches; b++) {
            float angleOffset = random.nextFloat();
            int heightOffset = random.nextInt(-5, 5);
            float tiltOffset = threadLocalRandom.nextFloat(0.2f);
            buildBranch(levelReader, blockSetter, blockPos, leafAttachments,
                    widthRange.getMinValue(),
                    treeHeight - this.branchDownwardOffset + heightOffset,
                    this.branchesConfig.getLength() + random.nextInt(this.branchesConfig.getRandomAddLength() + 1),
                    this.branchesConfig.getSpacingYaw() * b + angleOffset,
                    this.branchesConfig.getDownwardsPitch() + tiltOffset,
                    random, config);
        }

        return leafAttachments;
    }

    private void buildBranch(LevelSimulatedReader levelReader, BiConsumer<BlockPos, BlockState> blockSetter, BlockPos pos,
                             List<FoliagePlacer.FoliageAttachment> leafBlocks,
                             int width, int height, double length, double angle, double tilt,
                             RandomSource random, TreeConfiguration config) {
        width = width / 2;
        BlockPos origin = pos.above(height);
        BlockPos destination = ModFeatureUtils.translate(origin, length, angle, tilt);

        // create solution here
        VoxelBresenhamIterator blocksBetween = new VoxelBresenhamIterator(origin, destination);
        for(BlockPos blockPos : blocksBetween) {
            placeCylinder(levelReader, blockSetter, blockPos, width, random, config, leafBlocks);
        }

        leafBlocks.add(new FoliagePlacer.FoliageAttachment(destination.above(width - 1), 0, false));
    }

    public UniformInt calculateWidth(int treeHeight) {
        int minWidth = (int) Math.ceil(treeHeight / 8.0);  // Minimum width based on a ratio of tree height
        int maxWidth = (int) Math.ceil(treeHeight / 4.0);  // Maximum width based on a different ratio

        return UniformInt.of(minWidth, maxWidth);
    }

    public int calculateCurrentWidth(UniformInt minMaxWidth, int currentHeight, int midHeight) {
        int minWidth = minMaxWidth.getMinValue();
        int maxWidth = minMaxWidth.getMaxValue();

        double ratio;
        if (currentHeight < midHeight) {
            ratio = 1.0 - ((double) currentHeight / (double) midHeight);
        } else {
            return minWidth;
        }

        return (int) Math.round(minWidth + (maxWidth - minWidth) * ratio);
    }

    public List<BlockPos> generateSphereLayer(BlockPos center, int width) {
        List<BlockPos> sphereLayer = new ArrayList<>();

        int radius = width / 2;
        for (int x = center.getX() - radius; x <= center.getX() + radius; x++) {
            for (int z = center.getZ() - radius; z <= center.getZ() + radius; z++) {
                double distanceSq = center.distSqr(new BlockPos(x, center.getY(), z));
                double radiusSq = radius * radius;

                if (distanceSq <= radiusSq) {
                    sphereLayer.add(new BlockPos(x, center.getY(), z));
                }
            }
        }
        return sphereLayer;
    }

    public List<BlockPos> generateWholeSphere(BlockPos center, int width) {
        List<BlockPos> sphereBlocks = new ArrayList<>();

        int radius = width / 2;
        for (int x = center.getX() - radius; x <= center.getX() + radius; x++) {
            for(int y = center.getY() - radius; y <= center.getY() + radius; y++) {
                for(int z = center.getZ() - radius; z <= center.getZ() + radius; z++) {
                    double distanceSq = center.distSqr(new BlockPos(x, y, z));
                    double radiusSq = radius * radius;

                    if(distanceSq <= radiusSq) {
                        sphereBlocks.add(new BlockPos(x, y, z));
                    }
                }
            }
        }
        return sphereBlocks;
    }

    public void placeCylinder(LevelSimulatedReader levelReader, BiConsumer<BlockPos, BlockState> blockSetter, BlockPos center, int width,
                              RandomSource random, TreeConfiguration config, List<FoliagePlacer.FoliageAttachment> leafBlocks) {

        // Iterate through each block position along the line segment
        BlockPos mutablePos = new BlockPos(center);
        List<BlockPos> sphereBlocks = generateWholeSphere(mutablePos, width);
        for(BlockPos blockPos : sphereBlocks) {
            placeLog(levelReader, blockSetter, random, blockPos, config);
        }
    }
}
