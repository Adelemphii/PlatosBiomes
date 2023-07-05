package me.adelemphii.platosbiomes.world;

import com.mojang.datafixers.util.Pair;
import me.adelemphii.platosbiomes.PlatosBiomes;
import me.adelemphii.platosbiomes.world.biome.ModOverworldBiomeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

public class ModOverworldRegionPrimary extends Region {

    public static final ResourceLocation LOCATION = new ResourceLocation(PlatosBiomes.MODID, "overworld_primary");

    public ModOverworldRegionPrimary(int weight) {
        super(LOCATION, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        (new ModOverworldBiomeBuilder()).addBiomes(registry, mapper);
    }
}
