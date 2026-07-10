package de.trc.create_infinite_lava_block.events;

import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

public class ModEvents {

    public static void register() {
        NeoForge.EVENT_BUS.addListener(ModEvents::onRightClickBlock);
        NeoForge.EVENT_BUS.addListener(ModEvents::onSmallBrassBeamHit);
    }

    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        LavaSteelBucketClickEvent.onRightClickBlock(event);
    }

    public static void onSmallBrassBeamHit(LivingDamageEvent.Pre event) {
        GetHitBySmallBrassBeam.onSmallBrassBeamHit(event);
    }
}
