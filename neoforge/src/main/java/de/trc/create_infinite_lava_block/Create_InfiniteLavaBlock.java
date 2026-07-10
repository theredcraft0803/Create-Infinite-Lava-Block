package de.trc.create_infinite_lava_block;

import de.trc.create_infinite_lava_block.blockentity.ModBlockEntities;
import de.trc.create_infinite_lava_block.blocks.ModBlocks;
import de.trc.create_infinite_lava_block.events.ModEvents;
import de.trc.create_infinite_lava_block.items.ModItems;
import de.trc.create_infinite_lava_block.sounds.ModSounds;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(Constants.MODID)
public class Create_InfiniteLavaBlock {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Constants.MODID);
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CREATE_INFINITE_LAVA_BLOCK_TAB =
            CREATIVE_MODE_TABS.register(Constants.MODID, () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.create_infinite_lava_block"))
                    .withTabsBefore(CreativeModeTabs.COMBAT)
                    .icon(() -> ModItems.INFINITE_LAVA_BLOCK_ITEM.get().getDefaultInstance())
                    .displayItems((parameters, output) -> {
                        ModItems.ITEMS.getEntries().forEach(item ->
                                output.accept(item.get())
                        );
                    }).build());

    public Create_InfiniteLavaBlock(IEventBus modEventBus, ModContainer modContainer) {

        modEventBus.addListener(this::commonSetup);

        modEventBus.addListener(de.trc.create_infinite_lava_block.blockentity.CapabilityRegistration::registerCapabilities);

        CREATIVE_MODE_TABS.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModSounds.register(modEventBus);

        ModEvents.register();
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        Constants.LOGGER.info("Create: Infinite Lava Block loaded common");
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        Constants.LOGGER.info("Create: Infinite Lava Block loaded server-side");
    }
}
