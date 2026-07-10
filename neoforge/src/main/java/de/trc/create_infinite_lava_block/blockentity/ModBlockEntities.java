package de.trc.create_infinite_lava_block.blockentity;

import de.trc.create_infinite_lava_block.Constants;
import de.trc.create_infinite_lava_block.blocks.ModBlocks;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, Constants.MODID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<InfiniteLavaBlockEntity>>
            INFINITE_LAVA_BLOCK_BE =
            BLOCK_ENTITIES.register("infinite_lava_block",
                    () -> BlockEntityType.Builder.of(
                            InfiniteLavaBlockEntity::new,
                            ModBlocks.INFINITE_LAVA_BLOCK.get()
                    ).build(null)
            );

    public static DeferredHolder<BlockEntityType<?>, BlockEntityType<InfiniteLavaBlockEntity>> INFINITE_LAVA_BLOCK_ENTITY = INFINITE_LAVA_BLOCK_BE;



    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<InactiveInfiniteLavaBlockEntity>>
            INACTIVE_INFINITE_LAVA_BLOCK_BE =
            BLOCK_ENTITIES.register("inactive_infinite_lava_block",
                    () -> BlockEntityType.Builder.of(
                            InactiveInfiniteLavaBlockEntity::new,
                            ModBlocks.INACTIVE_INFINITE_LAVA_BLOCK.get()
                    ).build(null)
            );

    public static DeferredHolder<BlockEntityType<?>, BlockEntityType<InactiveInfiniteLavaBlockEntity>> INACTIVE_INFINITE_LAVA_BLOCK_ENTITY = INACTIVE_INFINITE_LAVA_BLOCK_BE;

    public static void register(IEventBus bus) {
        BLOCK_ENTITIES.register(bus);
    }
}
