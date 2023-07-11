package me.adelemphii.platosbiomes.utility;

import me.adelemphii.platosbiomes.PlatosBiomes;
import me.adelemphii.platosbiomes.world.ModConfiguredFeatures;
import me.adelemphii.platosbiomes.world.feature.ModMiscOverworldFeatures;
import net.minecraft.core.BlockPos;
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

    /**
     * Moves distance along the vector.
     * <p>
     * This goofy function takes a float between 0 and 1 for the angle, where 0 is 0 degrees, .5 is 180 degrees and 1 and 360 degrees.
     * For the tilt, it takes a float between 0 and 1 where 0 is straight up, 0.5 is straight out and 1 is straight down.
     */
    public static BlockPos translate(BlockPos pos, double distance, double angle, double tilt) {
        double rangle = angle * 2.0D * Math.PI;
        double rtilt = tilt * Math.PI;

        return pos.offset(
                (int) Math.round(Math.sin(rangle) * Math.sin(rtilt) * distance),
                (int) Math.round(Math.cos(rtilt) * distance),
                (int) Math.round(Math.cos(rangle) * Math.sin(rtilt) * distance)
        );
    }
}
