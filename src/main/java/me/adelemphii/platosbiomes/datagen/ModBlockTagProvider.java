package me.adelemphii.platosbiomes.datagen;

import me.adelemphii.platosbiomes.PlatosBiomes;
import me.adelemphii.platosbiomes.block.ModBlocks;
import me.adelemphii.platosbiomes.utility.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {

    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                               @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, PlatosBiomes.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModTags.Blocks.ARACARA_LOGS)
                .add(ModBlocks.ARACARA_LOG.get())
                .add(ModBlocks.STRIPPED_ARACARA_LOG.get());
        this.tag(ModTags.Blocks.ARACARA_WOOD)
                .add(ModBlocks.ARACARA_WOOD.get())
                .add(ModBlocks.STRIPPED_ARACARA_WOOD.get());
    }
}
