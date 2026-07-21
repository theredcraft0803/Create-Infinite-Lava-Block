package de.trc.create_infinite_lava_block;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ModConfig {
    public static final ModConfigSpec SPEC;
    public static final ModConfigSpec.IntValue LAVA_BUCKET_LOOPS;

    static {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
        builder.push("recipes");
        LAVA_BUCKET_LOOPS = builder
                .comment("Set how many buckets of lava should be needed to craft the create_infinite_lava_block:lava_steel_bucket")
                .defineInRange("lavaBucketLoops", 10000, 1, Integer.MAX_VALUE);
        builder.pop();
        SPEC = builder.build();
    }
}
