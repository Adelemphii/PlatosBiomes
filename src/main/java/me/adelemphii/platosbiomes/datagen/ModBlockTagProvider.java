package me.adelemphii.platosbiomes.datagen;

import me.adelemphii.platosbiomes.PlatosBiomes;
import me.adelemphii.platosbiomes.block.ModBlocks;
import me.adelemphii.platosbiomes.utility.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {

    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                               @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, PlatosBiomes.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        this.tag(ModTags.Blocks.ARACARA_LOGS)
                .add(ModBlocks.ARACARA_LOG.get())
                .add(ModBlocks.STRIPPED_ARACARA_LOG.get());
        this.tag(ModTags.Blocks.ARACARA_WOOD)
                .add(ModBlocks.ARACARA_WOOD.get())
                .add(ModBlocks.STRIPPED_ARACARA_WOOD.get());

        addToMinecraftTags();
    }

    private void addToMinecraftTags() {
        this.tag(BlockTags.LOGS)
                .add(ModBlocks.ARACARA_LOG.get())
                .add(ModBlocks.STRIPPED_ARACARA_LOG.get())
                .add(ModBlocks.ARACARA_WOOD.get())
                .add(ModBlocks.STRIPPED_ARACARA_WOOD.get());
        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.ARACARA_PLANKS.get());
        this.tag(BlockTags.FENCES)
                .add(ModBlocks.ARACARA_FENCE.get());
        this.tag(BlockTags.SIGNS)
                .add(ModBlocks.ARACARA_SIGN.get())
                .add(ModBlocks.ARACARA_WALL_SIGN.get());
        this.tag(BlockTags.STANDING_SIGNS)
                .add(ModBlocks.ARACARA_SIGN.get());
        this.tag(BlockTags.WALL_SIGNS)
                .add(ModBlocks.ARACARA_WALL_SIGN.get());
        this.tag(BlockTags.STANDING_SIGNS)
                .add(ModBlocks.ARACARA_SIGN.get());
        this.tag(BlockTags.SLABS)
                .add(ModBlocks.ARACARA_SLAB.get());
        this.tag(BlockTags.FENCES)
                .add(ModBlocks.ARACARA_FENCE.get());
        this.tag(BlockTags.FENCE_GATES);
        this.tag(BlockTags.PRESSURE_PLATES)
                .add(ModBlocks.ARACARA_PRESSURE_PLATE.get());
        this.tag(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.ARACARA_PRESSURE_PLATE.get());
        this.tag(BlockTags.STAIRS)
                .add(ModBlocks.ARACARA_STAIRS.get());
        this.tag(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.ARACARA_STAIRS.get());
        this.tag(BlockTags.BUTTONS)
                .add(ModBlocks.ARACARA_BUTTON.get());
        this.tag(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks.ARACARA_BUTTON.get());
        this.tag(BlockTags.LEAVES)
                .add(ModBlocks.ARACARA_LEAVES.get());
        this.tag(BlockTags.SAPLINGS)
                .add(ModBlocks.ARACARA_SAPLING.get());
        this.tag(BlockTags.DOORS)
                .add(ModBlocks.ARACARA_DOOR.get());
        this.tag(BlockTags.WOODEN_DOORS)
                .add(ModBlocks.ARACARA_DOOR.get());
        this.tag(BlockTags.TRAPDOORS)
                .add(ModBlocks.ARACARA_TRAPDOOR.get());
        this.tag(BlockTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.ARACARA_TRAPDOOR.get());
    }
}
