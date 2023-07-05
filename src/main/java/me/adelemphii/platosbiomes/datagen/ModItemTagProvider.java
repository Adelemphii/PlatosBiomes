package me.adelemphii.platosbiomes.datagen;

import me.adelemphii.platosbiomes.PlatosBiomes;
import me.adelemphii.platosbiomes.utility.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> tagLookupCompletableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, tagLookupCompletableFuture, PlatosBiomes.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.copy(ModTags.Blocks.ARACARA_LOGS, ModTags.Items.ARACARA_LOGS);
        this.copy(ModTags.Blocks.ARACARA_WOOD, ModTags.Items.ARACARA_WOOD);
    }
}
