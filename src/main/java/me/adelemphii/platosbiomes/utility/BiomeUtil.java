package me.adelemphii.platosbiomes.utility;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

public class BiomeUtil {

    @SafeVarargs
    public static ResourceKey<Biome> biomeOrFallback(Registry<Biome> biomeRegistry, ResourceKey<Biome>... biomes) {
        for (ResourceKey<Biome> key : biomes) {
            if (key == null)
                continue;

            return key;
        }

        throw new RuntimeException("Failed to find fallback for biome!");
    }
}
