package de.trc.create_infinite_lava_block.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class UnfinishedLavaSteelBucket {

    public static Item unfinishedLavaSteelBucket() {
        return new Item(
                new Item.Properties()
                        .stacksTo(1)
                        .rarity(Rarity.UNCOMMON)
                        .fireResistant()
        );
    }
}
