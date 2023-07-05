package me.adelemphii.platosbiomes.datagen;

import me.adelemphii.platosbiomes.block.ModBlocks;
import me.adelemphii.platosbiomes.utility.ModTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        planksFromLogs(ModBlocks.ARACARA_PLANKS.get(), ModTags.Items.ARACARA_LOGS, consumer);

        woodFromLogs(consumer, ModBlocks.ARACARA_WOOD.get(), ModBlocks.ARACARA_LOG.get());
        woodFromLogs(consumer, ModBlocks.STRIPPED_ARACARA_WOOD.get(), ModBlocks.STRIPPED_ARACARA_LOG.get());

        planksFromLog(ModBlocks.EBONY_PLANKS.get(), ModBlocks.EBONY_LOG.get(), consumer);
    }

    private void planksFromLog(ItemLike result, ItemLike craftingItem, Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, result, 4)
                .requires(craftingItem)
                .group("planks")
                .unlockedBy("has_log", has(craftingItem))
                .save(consumer);
    }
    private void planksFromLogs(ItemLike result, TagKey<Item> itemTag, Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, result, 4)
                .requires(itemTag)
                .group("planks")
                .unlockedBy("has_log", has(itemTag))
                .save(consumer);
    }
}
