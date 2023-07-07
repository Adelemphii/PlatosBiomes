package me.adelemphii.platosbiomes.datagen;

import me.adelemphii.platosbiomes.PlatosBiomes;
import me.adelemphii.platosbiomes.block.ModBlocks;
import me.adelemphii.platosbiomes.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, PlatosBiomes.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        this.saplingItem(ModBlocks.EBONY_SAPLING);
        this.trapdoorItem("aracara_trapdoor");
        this.simpleItem(ModItems.ARACARA_SIGN);
        this.fenceInventory("aracara_fence", modLoc("block/aracara_planks"));
        this.fenceInventory("aracara_fence_gate", modLoc("block/aracara_planks"));
        this.buttonInventory("aracara_button", modLoc("block/aracara_planks"));
        this.slab("aracara_slab", modLoc("block/aracara_planks"),
                modLoc("block/aracara_planks"), modLoc("block/aracara_planks"));
        this.pressurePlate("aracara_pressure_plate", modLoc("block/aracara_planks"));
        this.stairs("aracara_stairs", modLoc("block/aracara_planks"),
                modLoc("block/aracara_planks"), modLoc("block/aracara_planks"));
    }

    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated"))
                .texture("layer0", new ResourceLocation(PlatosBiomes.MODID, "block/" + item.getId().getPath()));
    }

    private ItemModelBuilder trapdoorItem(String name) {
        return this.withExistingParent(name, modLoc("block/" + name + "_bottom"));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated"))
                    .texture("layer0", new ResourceLocation(PlatosBiomes.MODID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld"))
                .texture("layer0", new ResourceLocation(PlatosBiomes.MODID, "item/" + item.getId().getPath()));
    }
}
