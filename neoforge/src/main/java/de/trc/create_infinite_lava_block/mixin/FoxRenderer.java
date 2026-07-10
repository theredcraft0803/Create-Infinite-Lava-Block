package de.trc.create_infinite_lava_block.mixin;

import de.trc.create_infinite_lava_block.items.ModItems;

import net.minecraft.client.renderer.entity.layers.FoxHeldItemLayer;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomModelData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import org.jetbrains.annotations.NotNull;

@Mixin(FoxHeldItemLayer.class)
public class FoxRenderer {

    @ModifyVariable(method = "render*", at = @At("STORE"))

    private @NotNull ItemStack replaceFoxItem(ItemStack original) {

        if (original.is(ModItems.SMALL_BRASS_BEAM.get())) {
            ItemStack renderItem = new ItemStack(ModItems.SMALL_BRASS_BEAM.get());
            renderItem.set(DataComponents.CUSTOM_MODEL_DATA, new CustomModelData(1));
            return renderItem;
        }

        return original;
    }

    @Unique
    private boolean createInfiniteLavaBlock1_21_1$shouldReplace(ItemStack stack) {
        return stack.is(ModItems.SMALL_BRASS_BEAM.get());
    }
}
