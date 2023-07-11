package me.adelemphii.platosbiomes.world.tree.trunkplacers;

import me.adelemphii.platosbiomes.PlatosBiomes;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class PlatosTrunkPlacerType <P extends TrunkPlacer> {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACERS =
            DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, PlatosBiomes.MODID);


    public static final RegistryObject<TrunkPlacerType<?>> MEGA_WINDING_TRUNK_PLACER =
            TRUNK_PLACERS.register("mega_winding_trunk_placer",
                    () -> new TrunkPlacerType<>(MegaWindingTrunkPlacer.CODEC));

    public static final RegistryObject<TrunkPlacerType<?>> MEGA_STRAIGHT_TRUNK_PLACER =
            TRUNK_PLACERS.register("large_branching_trunk_placer",
                    () -> new TrunkPlacerType<>(LargeBranchingTrunkPlacer.CODEC));

    public static void register(IEventBus eventbus) {
        TRUNK_PLACERS.register(eventbus);
    }
}
