package de.trc.create_infinite_lava_block.items;

import de.trc.create_infinite_lava_block.blocks.ModBlocks;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class InactiveInfiniteLavaBlockItem {

    public static BlockItem infiniteLavaBlock() {

        return new BlockItem(
                ModBlocks.INACTIVE_INFINITE_LAVA_BLOCK.get(),
                new Item.Properties()
                        .rarity(Rarity.RARE)
        );
    }
}
