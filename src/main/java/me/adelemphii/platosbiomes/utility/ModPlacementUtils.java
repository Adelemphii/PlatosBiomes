package me.adelemphii.platosbiomes.utility;

import me.adelemphii.platosbiomes.PlatosBiomes;
import me.adelemphii.platosbiomes.world.ModMiscOverworldPlacedFeatures;
import me.adelemphii.platosbiomes.world.ModTreePlacedFeatures;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ModPlacementUtils {

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        ModTreePlacedFeatures.bootstrap(context);
        ModMiscOverworldPlacedFeatures.bootstrap(context);
    }

    public static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(PlatosBiomes.MODID, name));
    }

}
