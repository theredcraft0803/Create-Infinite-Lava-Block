package de.trc.create_infinite_lava_block;

import net.neoforged.fml.ModList;

public class ModCompat {

    public static boolean isJadeLoaded() {
        return ModList.get().isLoaded("jade");
    }

    public static boolean isJEILoaded() {
        return ModList.get().isLoaded("jei");
    }
}
