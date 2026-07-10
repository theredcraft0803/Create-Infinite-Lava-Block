package de.trc.create_infinite_lava_block.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;

import org.jetbrains.annotations.NotNull;

public class InfiniteLavaBlockEntity extends BlockEntity {

    public InfiniteLavaBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.INFINITE_LAVA_BLOCK_BE.get(), pos, state);
    }

    public IFluidHandler getFluidHandler(Direction side) {
        return new InfiniteLavaFluidHandler(side);
    }

    private record InfiniteLavaFluidHandler(Direction side) implements IFluidHandler {

        @Override
            public int getTanks() {
                return 1;
            }

            @Override
            @NotNull
            public FluidStack getFluidInTank(int tank) {
                if (tank == 0) {
                    return new FluidStack(Fluids.LAVA, Integer.MAX_VALUE);
                }
                return FluidStack.EMPTY;
            }

            @Override
            public int getTankCapacity(int tank) {
                return tank == 0 ? Integer.MAX_VALUE : 0;
            }

            @Override
            public boolean isFluidValid(int tank, @NotNull FluidStack stack) {
                return tank == 0 && stack.getFluid() == Fluids.LAVA;
            }

            @Override
            public int fill(@NotNull FluidStack resource, @NotNull FluidAction action) {
                return 0;
            }

            @Override
            @NotNull
            public FluidStack drain(@NotNull FluidStack resource, @NotNull FluidAction action) {
                if (side != Direction.UP && side != Direction.DOWN) {
                    return FluidStack.EMPTY;
                }

                if (resource.getFluid() == Fluids.LAVA) {
                    return new FluidStack(Fluids.LAVA, resource.getAmount());
                }

                return FluidStack.EMPTY;
            }

            @Override
            @NotNull
            public FluidStack drain(int maxDrain, @NotNull FluidAction action) {
                if (side != Direction.UP && side != Direction.DOWN) {
                    return FluidStack.EMPTY;
                }

                return new FluidStack(Fluids.LAVA, maxDrain);
            }
        }
}
