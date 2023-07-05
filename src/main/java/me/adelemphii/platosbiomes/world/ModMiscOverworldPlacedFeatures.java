package me.adelemphii.platosbiomes.world;

import me.adelemphii.platosbiomes.utility.ModPlacementUtils;
import me.adelemphii.platosbiomes.world.feature.ModMiscOverworldFeatures;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModMiscOverworldPlacedFeatures {
    public static final ResourceKey<PlacedFeature> SPRING_LAVA_VOLCANO = ModPlacementUtils.createKey("spring_lava_volcano");
    public static final ResourceKey<PlacedFeature> LAKE_LAVA_SURFACE_EXTRA = ModPlacementUtils.createKey("lake_lava_surface_extra");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatureGetter = context.lookup(Registries.CONFIGURED_FEATURE);

        final Holder<ConfiguredFeature<?, ?>> springLavaVolcano = configuredFeatureGetter.getOrThrow(ModMiscOverworldFeatures.SPRING_LAVA_VOLCANO);
        final Holder<ConfiguredFeature<?, ?>> lakeLava = configuredFeatureGetter.getOrThrow(ModMiscOverworldFeatures.LAVA_LAKE_VOLCANO);

        register(context, ModMiscOverworldPlacedFeatures.LAKE_LAVA_SURFACE_EXTRA, lakeLava,
                CountPlacement.of(15),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                BiomeFilter.biome()
        );
        register(context, ModMiscOverworldPlacedFeatures.SPRING_LAVA_VOLCANO, springLavaVolcano,
                List.of(CountPlacement.of(128),
                        InSquarePlacement.spread(),
                        PlacementUtils.FULL_RANGE,
                        BiomeFilter.biome()
                )
        );
    }

    protected static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> placedFeatureKey, Holder<ConfiguredFeature<?, ?>> configuredFeature, PlacementModifier... modifiers) {
        register(context, placedFeatureKey, configuredFeature, List.of(modifiers));
    }

    protected static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> placedFeatureKey, Holder<ConfiguredFeature<?, ?>> configuredFeature, List<PlacementModifier> modifiers) {
        context.register(placedFeatureKey, new PlacedFeature(configuredFeature, modifiers));
    }
}
