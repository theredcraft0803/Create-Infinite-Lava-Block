package de.trc.create_infinite_lava_block.events;

import de.trc.create_infinite_lava_block.Constants;
import de.trc.create_infinite_lava_block.blocks.ModBlocks;
import de.trc.create_infinite_lava_block.items.ModItems;

import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

public class LavaSteelBucketClickEvent{

    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {

        Level level = event.getLevel();
        if (level.isClientSide) return;

        ItemStack heldItem = event.getItemStack();
        if (heldItem.getItem() != ModItems.LAVA_STEEL_BUCKET.get()) return;

        BlockPos pos = event.getPos();
        Player player = event.getEntity();

        Block block = event.getLevel().getBlockState(pos).getBlock();
        if (block != ModBlocks.INACTIVE_INFINITE_LAVA_BLOCK.get()) return;

        if (player instanceof ServerPlayer serverPlayer) {
            AdvancementHolder advancement = serverPlayer.server.getAdvancements().get(ResourceLocation.fromNamespaceAndPath(Constants.MODID, "make_infinite_lava_block"));

            if (advancement != null) {
                serverPlayer.getAdvancements().award(advancement, "used_item");
            }
        }

        level.setBlock(pos, ModBlocks.INFINITE_LAVA_BLOCK.get().defaultBlockState(), 3);

        SoundEvent sound = SoundEvents.BUCKET_EMPTY_LAVA;
        SoundSource source = SoundSource.PLAYERS;

        event.getEntity().level().playSound(null, pos, sound, source, 1.0F, 1.0F);

        heldItem.shrink(1);
        event.setCanceled(true);
    }
}
