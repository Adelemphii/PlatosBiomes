package me.adelemphii.platosbiomes.world.biome;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import me.adelemphii.platosbiomes.PlatosBiomes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

import java.util.List;

public class PlatosModBiomes {

    private static final List<ResourceKey<Biome>> overworldBiomes = Lists.newArrayList();
    private static final List<ResourceKey<Biome>> allBiomes = Lists.newArrayList();

    public static final ResourceKey<Biome> VOLCANO = registerOverworld("volcano");
    public static final ResourceKey<Biome> BIG_ASS_JUNGLE = registerOverworld("big_ass_jungle");

    public static List<ResourceKey<Biome>> getOverworldBiomes() {
        return ImmutableList.copyOf(overworldBiomes);
    }

    public static List<ResourceKey<Biome>> getAllBiomes() {
        return ImmutableList.copyOf(allBiomes);
    }

    private static ResourceKey<Biome> registerOverworld(String name) {
        ResourceKey<Biome> key = ResourceKey.create(Registries.BIOME, new ResourceLocation(PlatosBiomes.MODID, name));
        overworldBiomes.add(key);
        allBiomes.add(key);
        return key;
    }

    private static ResourceKey<Biome> register(String name) {
        ResourceKey<Biome> key = ResourceKey.create(Registries.BIOME, new ResourceLocation(PlatosBiomes.MODID, name));
        allBiomes.add(key);
        return key;
    }
}
