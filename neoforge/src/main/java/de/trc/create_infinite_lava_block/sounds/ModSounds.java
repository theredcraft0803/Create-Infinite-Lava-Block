package de.trc.create_infinite_lava_block.sounds;

import de.trc.create_infinite_lava_block.Constants;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModSounds {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(Registries.SOUND_EVENT, Constants.MODID);

    public static final Supplier<SoundEvent> SMALL_BRASS_BEAM_HIT =
            SOUNDS.register("small_brass_beam_hit", () ->
                    SoundEvent.createVariableRangeEvent(
                            ResourceLocation.fromNamespaceAndPath(Constants.MODID, "small_brass_beam_hit")));

    public static void register(IEventBus bus) {
        SOUNDS.register(bus);
    }
}
