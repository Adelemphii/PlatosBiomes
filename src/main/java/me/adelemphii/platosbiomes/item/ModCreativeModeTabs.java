package me.adelemphii.platosbiomes.item;

import me.adelemphii.platosbiomes.PlatosBiomes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = PlatosBiomes.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
    public static CreativeModeTab PLATOS_BIOMES_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        PLATOS_BIOMES_TAB = event.registerCreativeModeTab(new ResourceLocation(PlatosBiomes.MODID, "platos_biomes_tab"),
                builder -> builder.icon(Items.AMETHYST_SHARD::getDefaultInstance)
                        .title(Component.translatable("creativemodetab.platos_biomes_tab"))
        );
    }
}
