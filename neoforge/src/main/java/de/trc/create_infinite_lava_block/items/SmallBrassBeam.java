package de.trc.create_infinite_lava_block.items;

import de.trc.create_infinite_lava_block.blocks.ModBlocks;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class SmallBrassBeam{

    public static Item smallBrassBeam() {

        return new BlockItem(
                ModBlocks.SMALL_BRASS_BEAM.get(),
                new Item.Properties()
                        .rarity(Rarity.UNCOMMON)
        );
    }
}
