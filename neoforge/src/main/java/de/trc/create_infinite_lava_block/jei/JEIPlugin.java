package de.trc.create_infinite_lava_block.jei;

import de.trc.create_infinite_lava_block.Constants;
import de.trc.create_infinite_lava_block.ModCompat;
import de.trc.create_infinite_lava_block.items.ModItems;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import org.jetbrains.annotations.NotNull;

@JeiPlugin
public class JEIPlugin implements IModPlugin {

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(Constants.MODID, "jei_plugin");
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {

        if(!ModCompat.isJEILoaded()) return;

        registration.addIngredientInfo(
                new ItemStack(ModItems.INFINITE_LAVA_BLOCK_ITEM.get()),
                VanillaTypes.ITEM_STACK,
                Component.translatable("jei.plugin_create_infinite_lava_block.infinite_lava_block")
        );
    }
}
