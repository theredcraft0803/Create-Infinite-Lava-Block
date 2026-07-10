package de.trc.create_infinite_lava_block.items;

import net.minecraft.world.item.Item;

public class Steel {

    public static Item bucketSteelIngot() {
        return new Item(
                new Item.Properties()
                        .stacksTo(64)
        );
    }


    public static Item bucketIronDust() {
        return new Item(
                new Item.Properties()
                        .stacksTo(64)
        );
    }
}
