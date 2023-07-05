package me.adelemphii.platosbiomes.world.feature;

import me.adelemphii.platosbiomes.utility.ModFeatureUtils;
import net.minecraft.core.HolderSet;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.LakeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SpringConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.material.Fluids;

public class ModMiscOverworldFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRING_LAVA_VOLCANO = ModFeatureUtils.createKey("spring_lava_volcano");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LAVA_LAKE_VOLCANO = ModFeatureUtils.createKey("lava_lake_volcano");
    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {

        register(context, ModMiscOverworldFeatures.LAVA_LAKE_VOLCANO, Feature.LAKE,
                new LakeFeature.Configuration(BlockStateProvider.simple(Blocks.LAVA.defaultBlockState()),
                        BlockStateProvider.simple(Blocks.AIR.defaultBlockState())));

        register(context, ModMiscOverworldFeatures.SPRING_LAVA_VOLCANO, Feature.SPRING,
                new SpringConfiguration(Fluids.LAVA.defaultFluidState(), true, 4, 1,
                        HolderSet.direct(
                                Block::builtInRegistryHolder,
                                Blocks.BASALT,
                                Blocks.MAGMA_BLOCK,
                                Blocks.STONE, Blocks.GRANITE, Blocks.DIORITE, Blocks.ANDESITE)
                )
        );
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(
            BootstapContext<ConfiguredFeature<?, ?>> context,
            ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey,
            F feature,
            FC configuration) {
        context.register(configuredFeatureKey, new ConfiguredFeature<>(feature, configuration));
    }
}
