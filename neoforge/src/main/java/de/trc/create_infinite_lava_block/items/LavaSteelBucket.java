package de.trc.create_infinite_lava_block.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class LavaSteelBucket {
    public static Item lavaSteelBucket() {
        return new Item(
                new Item.Properties()
                        .stacksTo(1)
                        .rarity(Rarity.RARE)
                        .fireResistant()
        );
    }
}
