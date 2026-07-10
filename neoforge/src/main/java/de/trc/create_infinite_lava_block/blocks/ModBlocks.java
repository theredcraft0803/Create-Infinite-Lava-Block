package de.trc.create_infinite_lava_block.blocks;

import de.trc.create_infinite_lava_block.Constants;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(Constants.MODID);

    public static final DeferredBlock<Block> INFINITE_LAVA_BLOCK =
            BLOCKS.register("infinite_lava_block",
                    () -> new InfiniteLavaBlock(
                            BlockBehaviour.Properties.of()
                                    .strength(2.0f)
                                    .requiresCorrectToolForDrops()
                                    .lightLevel(state -> 15)
                    )
            );

    public static final DeferredBlock<Block> INACTIVE_INFINITE_LAVA_BLOCK =
            BLOCKS.register("inactive_infinite_lava_block",
                    () -> new InactiveInfiniteLavaBlock(
                            BlockBehaviour.Properties.of()
                                    .strength(2.0f)
                                    .requiresCorrectToolForDrops()
                                    .lightLevel(state -> 5)
                    )
            );

    public static final DeferredBlock<Block> SMALL_BRASS_BEAM =
            BLOCKS.register("small_brass_beam",
                    () -> new SmallBrassBeam(
                            BlockBehaviour.Properties.of()
                                    .strength(2.0f)
                                    .requiresCorrectToolForDrops()
                    )
            );

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
