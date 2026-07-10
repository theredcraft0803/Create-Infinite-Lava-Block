package de.trc.create_infinite_lava_block.blockentity;

import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;

public class CapabilityRegistration {

    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(
                Capabilities.FluidHandler.BLOCK,
                ModBlockEntities.INFINITE_LAVA_BLOCK_BE.get(),
                InfiniteLavaBlockEntity::getFluidHandler
        );
    }
}
