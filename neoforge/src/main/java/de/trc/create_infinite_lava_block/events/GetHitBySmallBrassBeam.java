package de.trc.create_infinite_lava_block.events;

import de.trc.create_infinite_lava_block.items.ModItems;
import de.trc.create_infinite_lava_block.sounds.ModSounds;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

public class GetHitBySmallBrassBeam{

    public static void onSmallBrassBeamHit(LivingDamageEvent.Pre event) {

        if (!(event.getSource().getEntity() instanceof Player player)) return;

        if (player.getMainHandItem().is(ModItems.SMALL_BRASS_BEAM.get())) {

            event.setNewDamage(event.getNewDamage() + 1.0F);

            BlockPos pos = event.getEntity().blockPosition();
            SoundEvent sound = ModSounds.SMALL_BRASS_BEAM_HIT.get();
            SoundSource source = SoundSource.PLAYERS;

            event.getEntity().level().playSound(null, pos, sound, source, 1.0F, 1.0F);
        }
    }
}
