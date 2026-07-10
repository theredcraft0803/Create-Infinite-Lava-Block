package de.trc.create_infinite_lava_block.items;

import net.minecraft.world.item.Item;

public class EmptySteelBucket {

    public static Item emptySteelBucket() {
        return new Item(
                new Item.Properties()
                        .stacksTo(1)
                        .fireResistant()
        );
    }
}
