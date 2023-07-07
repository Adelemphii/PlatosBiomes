package me.adelemphii.platosbiomes.datagen;

import me.adelemphii.platosbiomes.PlatosBiomes;
import me.adelemphii.platosbiomes.block.ModBlocks;
import me.adelemphii.platosbiomes.item.ModItems;
import me.adelemphii.platosbiomes.utility.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> tagLookupCompletableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, tagLookupCompletableFuture, PlatosBiomes.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        this.copy(ModTags.Blocks.ARACARA_LOGS, ModTags.Items.ARACARA_LOGS);
        this.copy(ModTags.Blocks.ARACARA_WOOD, ModTags.Items.ARACARA_WOOD);

        addToMinecraftTags();
    }

    private void addToMinecraftTags() {
        this.tag(ItemTags.LOGS)
                .add(ModBlocks.ARACARA_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_ARACARA_LOG.get().asItem())
                .add(ModBlocks.ARACARA_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_ARACARA_WOOD.get().asItem());
        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.ARACARA_PLANKS.get().asItem());
        this.tag(ItemTags.FENCES)
                .add(ModBlocks.ARACARA_FENCE.get().asItem());
        this.tag(ItemTags.SIGNS)
                .add(ModBlocks.ARACARA_SIGN.get().asItem())
                .add(ModBlocks.ARACARA_WALL_SIGN.get().asItem());
        this.tag(ItemTags.SIGNS)
                .add(ModItems.ARACARA_SIGN.get());
        this.tag(ItemTags.SLABS)
                .add(ModBlocks.ARACARA_SLAB.get().asItem());
        this.tag(ItemTags.FENCES)
                .add(ModBlocks.ARACARA_FENCE.get().asItem());
        this.tag(ItemTags.FENCE_GATES);
        this.tag(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.ARACARA_PRESSURE_PLATE.get().asItem());
        this.tag(ItemTags.STAIRS)
                .add(ModBlocks.ARACARA_STAIRS.get().asItem());
        this.tag(ItemTags.WOODEN_STAIRS)
                .add(ModBlocks.ARACARA_STAIRS.get().asItem());
        this.tag(ItemTags.BUTTONS)
                .add(ModBlocks.ARACARA_BUTTON.get().asItem());
        this.tag(ItemTags.WOODEN_BUTTONS)
                .add(ModBlocks.ARACARA_BUTTON.get().asItem());
        this.tag(ItemTags.LEAVES)
                .add(ModBlocks.ARACARA_LEAVES.get().asItem());
        this.tag(ItemTags.SAPLINGS)
                .add(ModBlocks.ARACARA_SAPLING.get().asItem());
        this.tag(ItemTags.DOORS)
                .add(ModBlocks.ARACARA_DOOR.get().asItem());
        this.tag(ItemTags.WOODEN_DOORS)
                .add(ModBlocks.ARACARA_DOOR.get().asItem());
        this.tag(ItemTags.TRAPDOORS)
                .add(ModBlocks.ARACARA_TRAPDOOR.get().asItem());
        this.tag(ItemTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.ARACARA_TRAPDOOR.get().asItem());
    }
}
