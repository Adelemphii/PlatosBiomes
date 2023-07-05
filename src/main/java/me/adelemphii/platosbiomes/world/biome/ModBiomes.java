package me.adelemphii.platosbiomes.world.biome;

import me.adelemphii.platosbiomes.PlatosBiomes;
import me.adelemphii.platosbiomes.world.ModOverworldRegionPrimary;
import me.adelemphii.platosbiomes.world.ModSurfaceRuleData;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

// https://github.com/Glitchfiend/BiomesOPlenty/blob/BOP-1.19.4-17.3.x/src/main/java/biomesoplenty/init/ModBiomes.java
public class ModBiomes {

    public static void setupTerraBlender() {
        Regions.register(new ModOverworldRegionPrimary(2));

        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, PlatosBiomes.MODID, ModSurfaceRuleData.overworld());
    }

    public static void bootstrapBiomes(BootstapContext<Biome> context) {
        HolderGetter<ConfiguredWorldCarver<?>> carverGetter = context.lookup(Registries.CONFIGURED_CARVER);
        HolderGetter<PlacedFeature> placedFeatureGetter = context.lookup(Registries.PLACED_FEATURE);

        register(context, AdeModBiomes.VOLCANO, AdeOverworldBiomes.volcano(placedFeatureGetter, carverGetter));
    }

    private static void register(BootstapContext<Biome> context, ResourceKey<Biome> key, Biome biome) {
        context.register(key, biome);
    }
}
