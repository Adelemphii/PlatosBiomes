package me.adelemphii.platosbiomes.item;

import me.adelemphii.platosbiomes.PlatosBiomes;
import me.adelemphii.platosbiomes.block.ModBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PlatosBiomes.MODID);

    public static final RegistryObject<Item> ARACARA_SIGN = ITEMS.register("aracara_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16),
                    ModBlocks.ARACARA_SIGN.get(), ModBlocks.ARACARA_WALL_SIGN.get()));

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
