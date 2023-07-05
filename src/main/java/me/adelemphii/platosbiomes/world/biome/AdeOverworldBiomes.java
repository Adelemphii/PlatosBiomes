package me.adelemphii.platosbiomes.world.biome;

import me.adelemphii.platosbiomes.world.ModMiscOverworldPlacedFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import org.jetbrains.annotations.Nullable;

// https://github.com/Glitchfiend/BiomesOPlenty/blob/BOP-1.19.4-17.3.x/src/main/java/biomesoplenty/common/biome/BOPOverworldBiomes.java#L1285
public class AdeOverworldBiomes {
    @Nullable
    private static final Music NORMAL_MUSIC = null;
    private static final Music LUSH_MUSIC = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_JUNGLE_AND_FOREST);
    private static final Music CAVE_MUSIC = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_DRIPSTONE_CAVES);
    private static final Music MOUNTAIN_MUSIC = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_JAGGED_PEAKS);

    protected static int calculateSkyColor(float color)
    {
        float $$1 = color / 3.0F;
        $$1 = Mth.clamp($$1, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - $$1 * 0.05F, 0.5F + $$1 * 0.1F, 1.0F);
    }

    private static Biome biome(boolean hasPrecipitation, float temperature, float downfall, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder, @Nullable Music music)
    {
        return biome(hasPrecipitation, temperature, downfall, 4159204, 329011, spawnBuilder, biomeBuilder, music);
    }

    private static Biome biomeWithColorOverrides(boolean hasPrecipitation, float temperature, float downfall, int grassColor, int foliageColor, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder, @Nullable Music music)
    {
        return biomeWithColorOverrides(hasPrecipitation, temperature, downfall, 4159204, 329011, grassColor, foliageColor, spawnBuilder, biomeBuilder, music);
    }

    private static Biome biome(boolean hasPrecipitation, float temperature, float downfall, int waterColor, int waterFogColor, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder, @Nullable Music music)
    {
        return (new Biome.BiomeBuilder()).hasPrecipitation(hasPrecipitation).temperature(temperature).downfall(downfall).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(waterColor).waterFogColor(waterFogColor).fogColor(12638463).skyColor(calculateSkyColor(temperature)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(music).build()).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }

    private static Biome biome(boolean hasPrecipitation, float temperature, float downfall, int waterColor, int waterFogColor, int fogColor, int skyColor, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder, @Nullable Music music)
    {
        return (new Biome.BiomeBuilder()).hasPrecipitation(hasPrecipitation).temperature(temperature).downfall(downfall).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(waterColor).waterFogColor(waterFogColor).fogColor(fogColor).skyColor(skyColor).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(music).build()).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }

    private static Biome biomeWithColorOverrides(boolean hasPrecipitation, float temperature, float downfall, int waterColor, int waterFogColor, int grassColor, int foliageColor, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder, @Nullable Music music)
    {
        return (new Biome.BiomeBuilder()).hasPrecipitation(hasPrecipitation).temperature(temperature).downfall(downfall).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(waterColor).waterFogColor(waterFogColor).fogColor(12638463).grassColorOverride(grassColor).foliageColorOverride(foliageColor).skyColor(calculateSkyColor(temperature)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(music).build()).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }

    private static Biome biomeWithColorOverrides(boolean hasPrecipitation, float temperature, float downfall, int waterColor, int waterFogColor, int fogColor, int grassColor, int foliageColor, int skyColor, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder, @Nullable Music music)
    {
        return (new Biome.BiomeBuilder()).hasPrecipitation(hasPrecipitation).temperature(temperature).downfall(downfall).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(waterColor).waterFogColor(waterFogColor).fogColor(fogColor).grassColorOverride(grassColor).foliageColorOverride(foliageColor).skyColor(skyColor).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(music).build()).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }

    private static Biome biomeWithColorOverridesAndParticles(boolean hasPrecipitation, float temperature, float downfall, int waterColor, int waterFogColor, int fogColor, int grassColor, int foliageColor, int skyColor, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder, ParticleOptions particleOptions, float particleProbability, @Nullable Music music)
    {
        return (new Biome.BiomeBuilder()).hasPrecipitation(hasPrecipitation).temperature(temperature).downfall(downfall).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(waterColor).waterFogColor(waterFogColor).fogColor(fogColor).grassColorOverride(grassColor).foliageColorOverride(foliageColor).skyColor(skyColor).ambientParticle(new AmbientParticleSettings(particleOptions, particleProbability)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(music).build()).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }

    private static void addFeature(BiomeGenerationSettings.Builder builder, GenerationStep.Decoration step, ResourceKey<PlacedFeature> feature)
    {
        builder.addFeature(step, feature);
    }

    private static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder)
    {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);
    }

    private static void globalOverworldGenerationNoLavaLakes(BiomeGenerationSettings.Builder builder)
    {
        builder.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE);
        builder.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND);
        builder.addCarver(GenerationStep.Carving.AIR, Carvers.CANYON);
        builder.addFeature(GenerationStep.Decoration.LAKES, MiscOverworldPlacements.LAKE_LAVA_UNDERGROUND);

        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);
    }

    public static Biome volcano(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter)
    {
        // Mob spawns
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        // Biome features
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
        globalOverworldGeneration(biomeBuilder);
        addFeature(biomeBuilder, GenerationStep.Decoration.LAKES, ModMiscOverworldPlacedFeatures.LAKE_LAVA_SURFACE_EXTRA);
        addFeature(biomeBuilder, GenerationStep.Decoration.FLUID_SPRINGS, ModMiscOverworldPlacedFeatures.SPRING_LAVA_VOLCANO);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        addFeature(biomeBuilder, GenerationStep.Decoration.UNDERGROUND_ORES, MiscOverworldPlacements.DISK_GRAVEL);
        BiomeDefaultFeatures.addExtraEmeralds(biomeBuilder);
        BiomeDefaultFeatures.addInfestedStone(biomeBuilder);

        return biomeWithColorOverridesAndParticles(false, 0.95F, 0.3F, 4566514, 267827, 0x7F7F7F, 0x4A703B, 0x547D42, calculateSkyColor(0.95F), spawnBuilder, biomeBuilder, ParticleTypes.WHITE_ASH, 0.059046667F, MOUNTAIN_MUSIC);
    }
}
