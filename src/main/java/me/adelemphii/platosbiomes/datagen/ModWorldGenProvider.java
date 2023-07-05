package me.adelemphii.platosbiomes.datagen;

import me.adelemphii.platosbiomes.PlatosBiomes;
import me.adelemphii.platosbiomes.utility.ModFeatureUtils;
import me.adelemphii.platosbiomes.utility.ModPlacementUtils;
import me.adelemphii.platosbiomes.world.biome.ModBiomes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModWorldGenProvider extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ModFeatureUtils::bootstrap)
            .add(Registries.PLACED_FEATURE, ModPlacementUtils::bootstrap)
            .add(Registries.BIOME, ModBiomes::bootstrapBiomes);

    public ModWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(PlatosBiomes.MODID));
    }
}
