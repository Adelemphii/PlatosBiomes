package me.adelemphii.platosbiomes.block.objects;

import me.adelemphii.platosbiomes.block.entity.objects.PlatosSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class PlatosWallSignBlock extends WallSignBlock {
    public PlatosWallSignBlock(Properties p_58068_, WoodType p_58069_) {
        super(p_58068_, p_58069_);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new PlatosSignBlockEntity(blockPos, blockState);
    }
}
