package de.trc.create_infinite_lava_block.jade;

import de.trc.create_infinite_lava_block.ModCompat;
import de.trc.create_infinite_lava_block.blocks.InactiveInfiniteLavaBlock;
import de.trc.create_infinite_lava_block.blocks.InfiniteLavaBlock;

import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

@WailaPlugin
public class JadePlugin implements IWailaPlugin {

    @Override
    public void registerClient(IWailaClientRegistration registration) {

        if (!ModCompat.isJadeLoaded()) return;

        registration.registerBlockComponent(InactiveTankTooltipProvider.INSTANCE, InactiveInfiniteLavaBlock.class);
        registration.registerBlockComponent(ActiveTankTooltipProvider.INSTANCE, InfiniteLavaBlock.class);
    }
}
