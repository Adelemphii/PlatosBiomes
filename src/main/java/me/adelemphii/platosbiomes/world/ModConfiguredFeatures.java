package me.adelemphii.platosbiomes.world;

import me.adelemphii.platosbiomes.PlatosBiomes;
import me.adelemphii.platosbiomes.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.CherryFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.CherryTrunkPlacer;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> EBONY_KEY = registerKey("ebony");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        register(context, EBONY_KEY, Feature.TREE, ebony().build());
    }

    /**
     * Example Generation of Tree
     * @return Tree Configuration
     */
    private static TreeConfiguration.TreeConfigurationBuilder ebony() {
        return (new TreeConfiguration.TreeConfigurationBuilder(
                // Log Type
                BlockStateProvider.simple(ModBlocks.EBONY_LOG.get()),
                //                  baseHeight, randHeightA, randHeightB
                new CherryTrunkPlacer(7, 1, 0,
                        // Branch Count
                        new WeightedListInt(SimpleWeightedRandomList.<IntProvider>builder()
                                //                  branchHorizontalLength
                                .add(ConstantInt.of(1), 1)
                                .add(ConstantInt.of(2), 1)
                                .add(ConstantInt.of(3), 1)
                                .build()), UniformInt.of(2, 4),
                        // branchStartOffsetFromTop
                        UniformInt.of(-4, -3),
                        // branchEndOffsetFromTop
                        UniformInt.of(-1, 0)),
                // Leaves Type
                BlockStateProvider.simple(ModBlocks.EBONY_LEAVES.get()),
                new CherryFoliagePlacer(
                        // radius
                        ConstantInt.of(4),
                        // offset
                        ConstantInt.of(0),
                        // height
                        ConstantInt.of(5),
                        // wideBottomLayerHoleChance, cornerHoleChance, hangingLeavesChance, hangingLeavesExtensionChance
                                    0.25F,          0.5F, 0.16666667F, 0.33333334F),
                //                             limit    lowerSize   upperSize
                new TwoLayersFeatureSize(1, 0, 2)))
                .ignoreVines();
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(PlatosBiomes.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>>
    void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}
