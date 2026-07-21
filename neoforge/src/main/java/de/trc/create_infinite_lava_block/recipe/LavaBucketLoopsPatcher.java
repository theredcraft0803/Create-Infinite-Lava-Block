package de.trc.create_infinite_lava_block.recipe;

import de.trc.create_infinite_lava_block.ModConfig;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.OnDatapackSyncEvent;
import com.simibubi.create.content.processing.sequenced.SequencedAssemblyRecipe;

import java.lang.reflect.Field;

public class LavaBucketLoopsPatcher {

    private static final ResourceLocation TARGET = ResourceLocation.fromNamespaceAndPath("create_infinite_lava_block", "lava_steel_bucket");

    @SubscribeEvent
    public static void onDatapackSync(OnDatapackSyncEvent event) {
        var server = event.getPlayerList().getServer();
        var recipeManager = server.getRecipeManager();

        for (RecipeHolder<?> holder : recipeManager.getRecipes()) {
            if (holder.id().equals(TARGET) && holder.value() instanceof SequencedAssemblyRecipe recipe) {
                setLoops(recipe, ModConfig.LAVA_BUCKET_LOOPS.get());
            }
        }
    }

    private static void setLoops(SequencedAssemblyRecipe recipe, int loops) {
        try {
            Field field = SequencedAssemblyRecipe.class.getDeclaredField("loops");
            field.setAccessible(true);
            field.setInt(recipe, loops);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException("Could not set 'loops' as a reflection", e);
        }
    }
}
