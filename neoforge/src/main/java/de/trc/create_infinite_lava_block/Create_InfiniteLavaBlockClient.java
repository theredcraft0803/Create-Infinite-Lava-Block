package de.trc.create_infinite_lava_block;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = Constants.MODID, value = Dist.CLIENT)
public class Create_InfiniteLavaBlockClient {

    @SubscribeEvent
    public static void onClientLoad(FMLClientSetupEvent event) {
        Constants.LOGGER.info("Create: Infinite Lava Block loaded client-side");
    }
}
