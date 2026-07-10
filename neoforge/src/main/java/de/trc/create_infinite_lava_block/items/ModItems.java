package de.trc.create_infinite_lava_block.items;

import de.trc.create_infinite_lava_block.Constants;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(Constants.MODID);


    public static final DeferredItem<?> SMALL_BRASS_BEAM =
            ITEMS.register("small_brass_beam", SmallBrassBeam::smallBrassBeam);

    public static final DeferredItem<?> BUCKET_STEEL_INGOT =
            ITEMS.register("bucket_steel_ingot", Steel::bucketSteelIngot);

    public static final DeferredItem<?> BUCKET_IRON_DUST =
            ITEMS.register("bucket_iron_dust", Steel::bucketIronDust);

    public static final DeferredItem<?> EMPTY_STEEL_BUCKET =
            ITEMS.register("empty_steel_bucket", EmptySteelBucket::emptySteelBucket);

    public static final DeferredItem<?> UNFINISHED_LAVA_STEEL_BUCKET =
            ITEMS.register("unfinished_lava_steel_bucket", UnfinishedLavaSteelBucket::unfinishedLavaSteelBucket);

    public static final DeferredItem<?> LAVA_STEEL_BUCKET =
            ITEMS.register("lava_steel_bucket", LavaSteelBucket::lavaSteelBucket);

    public static final DeferredItem<?> INFINITE_LAVA_BLOCK_ITEM =
            ITEMS.register("infinite_lava_block", InfiniteLavaBlockItem::infiniteLavaBlock);

    public static final DeferredItem<?> INACTIVE_INFINITE_LAVA_BLOCK_ITEM =
            ITEMS.register("inactive_infinite_lava_block", InactiveInfiniteLavaBlockItem::infiniteLavaBlock);


    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
