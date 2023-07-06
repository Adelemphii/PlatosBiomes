package me.adelemphii.platosbiomes.block.entity;

import me.adelemphii.platosbiomes.PlatosBiomes;
import me.adelemphii.platosbiomes.block.ModBlocks;
import me.adelemphii.platosbiomes.block.entity.objects.PlatosSignBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, PlatosBiomes.MODID);

    public static final RegistryObject<BlockEntityType<PlatosSignBlockEntity>> SIGN_BLOCK_ENTITIES =
            BLOCK_ENTITIES.register("sign_block_entity",
                    () -> BlockEntityType.Builder.of(PlatosSignBlockEntity::new,
                            ModBlocks.ARACARA_SIGN.get(), ModBlocks.ARACARA_WALL_SIGN.get())
                            .build(null));

    public static void register(IEventBus bus) {
        BLOCK_ENTITIES.register(bus);
    }
}
