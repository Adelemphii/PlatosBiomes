package me.adelemphii.platosbiomes;

import com.mojang.logging.LogUtils;
import me.adelemphii.platosbiomes.block.ModBlocks;
import me.adelemphii.platosbiomes.item.ModCreativeModeTabs;
import me.adelemphii.platosbiomes.item.ModItems;
import me.adelemphii.platosbiomes.world.biome.ModBiomes;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(PlatosBiomes.MODID)
public class PlatosBiomes {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "platosbiomes";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    public PlatosBiomes() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(ModBiomes::setupTerraBlender);
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {


        if(event.getTab() == ModCreativeModeTabs.PLATOS_BIOMES_TAB) {
            event.accept(ModBlocks.EBONY_LOG);
            event.accept(ModBlocks.EBONY_WOOD);
            event.accept(ModBlocks.EBONY_LEAVES);
            event.accept(ModBlocks.EBONY_PLANKS);
            event.accept(ModBlocks.STRIPPED_EBONY_LOG);
            event.accept(ModBlocks.STRIPPED_EBONY_WOOD);
            event.accept(ModBlocks.EBONY_SAPLING);

            event.accept(ModBlocks.ARACARA_LOG);
            event.accept(ModBlocks.ARACARA_WOOD);
            event.accept(ModBlocks.ARACARA_PLANKS);
            event.accept(ModBlocks.ARACARA_LEAVES);
        }
        if(event.getTab() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.EBONY_LOG);
            event.accept(ModBlocks.EBONY_WOOD);
            event.accept(ModBlocks.EBONY_LEAVES);
            event.accept(ModBlocks.EBONY_PLANKS);
            event.accept(ModBlocks.STRIPPED_EBONY_LOG);
            event.accept(ModBlocks.STRIPPED_EBONY_WOOD);
            event.accept(ModBlocks.EBONY_SAPLING);

            event.accept(ModBlocks.ARACARA_LOG);
            event.accept(ModBlocks.ARACARA_WOOD);
            event.accept(ModBlocks.ARACARA_PLANKS);
            event.accept(ModBlocks.ARACARA_LEAVES);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }
}
