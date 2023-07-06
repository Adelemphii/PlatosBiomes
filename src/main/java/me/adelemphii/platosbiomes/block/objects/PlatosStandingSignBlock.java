package me.adelemphii.platosbiomes.block.objects;

import me.adelemphii.platosbiomes.block.entity.objects.PlatosSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class PlatosStandingSignBlock extends StandingSignBlock {
    public PlatosStandingSignBlock(Properties p_56990_, WoodType p_56991_) {
        super(p_56990_, p_56991_);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new PlatosSignBlockEntity(blockPos, blockState);
    }
}
