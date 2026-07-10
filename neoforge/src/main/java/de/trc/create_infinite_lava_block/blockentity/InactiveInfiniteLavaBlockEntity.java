package de.trc.create_infinite_lava_block.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class InactiveInfiniteLavaBlockEntity extends BlockEntity {

    public InactiveInfiniteLavaBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.INACTIVE_INFINITE_LAVA_BLOCK_BE.get(), pos, state);
    }
}
