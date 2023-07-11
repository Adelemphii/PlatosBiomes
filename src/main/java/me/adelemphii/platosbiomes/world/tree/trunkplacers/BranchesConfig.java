package me.adelemphii.platosbiomes.world.tree.trunkplacers;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

/**
 * Source originates from Twilight Forest Source Code
 * @link <a href="https://github.com/TeamTwilight/twilightforest/blob/1.19.4-Biome_Source_Refactor/src/main/java/twilightforest/world/components/feature/trees/treeplacers/BranchesConfig.java">Link</a>
 */
public class BranchesConfig {
    public static final Codec<BranchesConfig> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.intRange(0, 16).fieldOf("count_minimum").forGetter(o -> o.branchCount),
                    Codec.intRange(0, 16).fieldOf("random_add_count").orElse(0).forGetter(o -> o.randomAddBranches),
                    Codec.intRange(1, 50).fieldOf("length").forGetter(o -> o.length),
                    Codec.intRange(0, 20).fieldOf("random_add_length").orElse(0).forGetter(o -> o.randomAddLength),
                    // Yaw - Float between 0 and 1 for the angle, where 0 is 0 degrees, .5 is 180 degrees and 1 and 360 degrees.
                    Codec.doubleRange(0, 0.5).fieldOf("spacing_yaw").orElse(0.3d).forGetter(o -> o.spacingYaw),
                    // Tilt - Float between 0 and 1 where 0 is straight up, 0.5 is straight out and 1 is straight down.
                    Codec.doubleRange(0, 1).fieldOf("downwards_pitch").orElse(0.2d).forGetter(o -> o.downwardsPitch)
            ).apply(instance, BranchesConfig::new)
    );

    private final int branchCount;
    private final int randomAddBranches;
    private final int length;
    private final int randomAddLength;
    private final double spacingYaw;
    private final double downwardsPitch;

    public BranchesConfig(int branchCount, int randomAddBranches, int length, int randomAddLength, double spacingYaw, double downwardsPitch) {
        this.branchCount = branchCount;
        this.randomAddBranches = randomAddBranches;
        this.length = length;
        this.randomAddLength = randomAddLength;
        this.spacingYaw = spacingYaw;
        this.downwardsPitch = downwardsPitch;
    }

    public BranchesConfig(int branchCount, int length) {
        this.branchCount = branchCount;
        this.randomAddBranches = 0;
        this.length = length;
        this.randomAddLength = 0;
        this.spacingYaw = 0.3d;
        this.downwardsPitch = 0.2d;
    }

    public int getBranchCount() {
        return branchCount;
    }

    public int getRandomAddBranches() {
        return randomAddBranches;
    }

    public int getLength() {
        return length;
    }

    public int getRandomAddLength() {
        return randomAddLength;
    }

    public double getDownwardsPitch() {
        return downwardsPitch;
    }

    public double getSpacingYaw() {
        return spacingYaw;
    }
}
