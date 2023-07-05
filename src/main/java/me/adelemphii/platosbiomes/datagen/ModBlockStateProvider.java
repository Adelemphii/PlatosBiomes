package me.adelemphii.platosbiomes.datagen;

import me.adelemphii.platosbiomes.PlatosBiomes;
import me.adelemphii.platosbiomes.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, PlatosBiomes.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        // EBONY
        logBlock(((RotatedPillarBlock) ModBlocks.EBONY_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.EBONY_WOOD.get(),
                blockTexture(ModBlocks.EBONY_LOG.get()), blockTexture(ModBlocks.EBONY_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_EBONY_LOG.get(),
                new ResourceLocation(PlatosBiomes.MODID, "block/stripped_ebony_log"),
                new ResourceLocation(PlatosBiomes.MODID, "block/stripped_ebony_log_top"));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_EBONY_WOOD.get(),
                new ResourceLocation(PlatosBiomes.MODID, "block/stripped_ebony_log"),
                new ResourceLocation(PlatosBiomes.MODID, "block/stripped_ebony_log"));

        blockWithItem(ModBlocks.EBONY_LEAVES);
        blockWithItem(ModBlocks.EBONY_PLANKS);
        saplingBlock(ModBlocks.EBONY_SAPLING);

        simpleBlockItem(ModBlocks.EBONY_LOG.get(), models().withExistingParent("platosbiomes:ebony_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.EBONY_WOOD.get(), models().withExistingParent("platosbiomes:ebony_wood", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_EBONY_LOG.get(), models().withExistingParent("platosbiomes:stripped_ebony_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_EBONY_WOOD.get(), models().withExistingParent("platosbiomes:stripped_ebony_wood", "minecraft:block/cube_column"));

        // ARACARA
        logBlock((RotatedPillarBlock) ModBlocks.ARACARA_LOG.get());
        axisBlock((RotatedPillarBlock) ModBlocks.ARACARA_WOOD.get(),
                blockTexture(ModBlocks.ARACARA_LOG.get()), blockTexture(ModBlocks.ARACARA_LOG.get()));

        blockWithItem(ModBlocks.ARACARA_LEAVES);
        simpleBlockItem(ModBlocks.ARACARA_LOG.get(), models().withExistingParent("platosbiomes:aracara_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.ARACARA_WOOD.get(), models().withExistingParent("platosbiomes:aracara_wood", "minecraft:block/cube_column"));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(),
                        blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
}
