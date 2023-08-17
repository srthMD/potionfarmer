package ro.srth.potionfarmer.datagen;

import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import ro.srth.potionfarmer.Mod;
import ro.srth.potionfarmer.registry.ItemRegistry;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

        //pomegrenade
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ItemRegistry.POMEGRENADE.get())
                .unlockedBy("has_pomegranate", inventoryTrigger(ItemPredicate.Builder.item().of(ItemRegistry.POMEGRANATE.get()).build()))

                .define('G', Tags.Items.GUNPOWDER)
                .define('P', ItemRegistry.POMEGRANATE.get())

                .pattern(" G ")
                .pattern("GPG")
                .pattern(" G ")

                .save(consumer);

        //glistering pomegranate
        ShapedRecipeBuilder.shaped(RecipeCategory.BREWING, ItemRegistry.GLISTERING_POMEGRANATE.get())
                .unlockedBy("has_pomegranate", inventoryTrigger(ItemPredicate.Builder.item().of(ItemRegistry.POMEGRANATE.get()).build()))

                .define('G', Tags.Items.INGOTS_GOLD)
                .define('N', Tags.Items.NUGGETS_GOLD)
                .define('P', ItemRegistry.POMEGRANATE.get())

                .pattern("NNN")
                .pattern("GPG")
                .pattern("NNN")

                .save(consumer);

        //pomegranate seeds
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ItemRegistry.POMEGRANATE_SEEDS.get())
                .unlockedBy("has_pomegranate", inventoryTrigger(ItemPredicate.Builder.item().of(ItemRegistry.POMEGRANATE.get()).build()))
                .requires(ItemRegistry.POMEGRANATE.get())
                .save(consumer);

        //iron parsnip
        ShapedRecipeBuilder.shaped(RecipeCategory.BREWING, ItemRegistry.IRON_PARSNIP.get())
                .unlockedBy("has_parsnip", inventoryTrigger(ItemPredicate.Builder.item().of(ItemRegistry.PARSNIP.get()).build()))

                .define('G', Tags.Items.INGOTS_IRON)
                .define('N', Tags.Items.NUGGETS_IRON)
                .define('P', ItemRegistry.PARSNIP.get())

                .pattern("NNN")
                .pattern("GPG")
                .pattern("NNN")

                .save(consumer);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ItemRegistry.BELL_PEPPER_SEEDS.get())
                .unlockedBy("has_bell_pepper", inventoryTrigger(ItemPredicate.Builder.item().of(ItemRegistry.BELL_PEPPER.get()).build()))
                .requires(ItemRegistry.BELL_PEPPER.get())
                .save(consumer);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ItemRegistry.JALAPENO_SEEDS.get())
                .unlockedBy("has_jalapeno", inventoryTrigger(ItemPredicate.Builder.item().of(ItemRegistry.JALAPENO.get()).build()))
                .requires(ItemRegistry.JALAPENO.get())
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ItemRegistry.CAYENNE_SEEDS.get())
                .unlockedBy("has_cayenne", inventoryTrigger(ItemPredicate.Builder.item().of(ItemRegistry.CAYENNE.get()).build()))
                .requires(ItemRegistry.CAYENNE.get())
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ItemRegistry.ORANGE_HABANERO_SEEDS.get())
                .unlockedBy("has_orange_habanero", inventoryTrigger(ItemPredicate.Builder.item().of(ItemRegistry.ORANGE_HABANERO.get()).build()))
                .requires(ItemRegistry.ORANGE_HABANERO.get())
                .save(consumer);


    }

    protected static void oreSmelting(Consumer<FinishedRecipe> p_250654_, List<ItemLike> p_250172_, RecipeCategory p_250588_, ItemLike p_251868_, float p_250789_, int p_252144_, String p_251687_) {
        oreCooking(p_250654_, RecipeSerializer.SMELTING_RECIPE, p_250172_, p_250588_, p_251868_, p_250789_, p_252144_, p_251687_, "_from_smelting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> p_250791_, RecipeSerializer<? extends AbstractCookingRecipe> p_251817_, List<ItemLike> p_249619_, RecipeCategory p_251154_, ItemLike p_250066_, float p_251871_, int p_251316_, String p_251450_, String p_249236_) {
        for(ItemLike itemlike : p_249619_) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), p_251154_, p_250066_, p_251871_, p_251316_, p_251817_).group(p_251450_)
                    .unlockedBy(getHasName(itemlike), has(itemlike)).save(p_250791_, new ResourceLocation(Mod.MOD_ID, getItemName(p_250066_)) + p_249236_ + "_" + getItemName(itemlike));
        }
    }

    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> p_249580_, RecipeCategory p_251203_, ItemLike p_251689_, RecipeCategory p_251376_, ItemLike p_248771_) {
        nineBlockStorageRecipes(p_249580_, p_251203_, p_251689_, p_251376_, p_248771_, getSimpleRecipeName(p_248771_), (String)null, getSimpleRecipeName(p_251689_), (String)null);
    }

    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> p_250423_, RecipeCategory p_250083_, ItemLike p_250042_,
                                                  RecipeCategory p_248977_, ItemLike p_251911_, String p_250475_, @Nullable String p_248641_,
                                                  String p_252237_, @Nullable String p_250414_) {
        ShapelessRecipeBuilder.shapeless(p_250083_, p_250042_, 9).requires(p_251911_).group(p_250414_).unlockedBy(getHasName(p_251911_), has(p_251911_))
                .save(p_250423_, new ResourceLocation(Mod.MOD_ID, p_252237_));
        ShapedRecipeBuilder.shaped(p_248977_, p_251911_).define('#', p_250042_).pattern("###").pattern("###").pattern("###").group(p_248641_)
                .unlockedBy(getHasName(p_250042_), has(p_250042_)).save(p_250423_, new ResourceLocation(Mod.MOD_ID, p_250475_));
    }
}
