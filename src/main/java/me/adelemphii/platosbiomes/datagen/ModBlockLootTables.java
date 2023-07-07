package me.adelemphii.platosbiomes.datagen;

import me.adelemphii.platosbiomes.block.ModBlocks;
import me.adelemphii.platosbiomes.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.EBONY_LOG.get());
        this.dropSelf(ModBlocks.EBONY_WOOD.get());
        this.dropSelf(ModBlocks.EBONY_PLANKS.get());
        this.dropSelf(ModBlocks.STRIPPED_EBONY_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_EBONY_LOG.get());
        this.dropSelf(ModBlocks.EBONY_SAPLING.get());
        this.add(ModBlocks.EBONY_LEAVES.get(),
                (block) -> createLeavesDrops(block, ModBlocks.EBONY_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.dropSelf(ModBlocks.ARACARA_LOG.get());
        this.dropSelf(ModBlocks.ARACARA_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_ARACARA_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_ARACARA_WOOD.get());
        this.dropSelf(ModBlocks.ARACARA_PLANKS.get());
        this.dropSelf(ModBlocks.ARACARA_SAPLING.get());
        this.add(ModBlocks.ARACARA_LEAVES.get(),
                (block) -> createLeavesDrops(block, ModBlocks.ARACARA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(ModBlocks.ARACARA_DOOR.get(), this::createDoorTable);
        this.dropSelf(ModBlocks.ARACARA_TRAPDOOR.get());
        this.dropSelf(ModBlocks.ARACARA_BUTTON.get());
        this.dropSelf(ModBlocks.ARACARA_FENCE.get());
        this.dropSelf(ModBlocks.ARACARA_FENCE_GATE.get());
        this.dropSelf(ModBlocks.ARACARA_SIGN.get());
        this.dropOther(ModBlocks.ARACARA_WALL_SIGN.get(), ModItems.ARACARA_SIGN.get());
        this.dropSelf(ModBlocks.ARACARA_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.ARACARA_SLAB.get());
        this.dropSelf(ModBlocks.ARACARA_STAIRS.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
