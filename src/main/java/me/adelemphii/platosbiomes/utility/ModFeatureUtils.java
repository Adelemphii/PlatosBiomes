package me.adelemphii.platosbiomes.utility;

import me.adelemphii.platosbiomes.PlatosBiomes;
import me.adelemphii.platosbiomes.world.ModConfiguredFeatures;
import me.adelemphii.platosbiomes.world.feature.ModMiscOverworldFeatures;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class ModFeatureUtils {

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        ModConfiguredFeatures.bootstrap(context);
        ModMiscOverworldFeatures.bootstrap(context);
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(PlatosBiomes.MODID, name));
    }

}
