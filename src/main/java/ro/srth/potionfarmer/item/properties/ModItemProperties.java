package ro.srth.potionfarmer.item.properties;

import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;

public class ModItemProperties {
    public static final Item.Properties BELL_PEPPER_SEEDS = new Item.Properties().food(ModFoodProperties.BELL_PEPPER_SEEDS);
    public static final Item.Properties JALAPENO_SEEDS = new Item.Properties().food(ModFoodProperties.JALAPENO_SEEDS);
    public static final Item.Properties CAYENNE_SEEDS = new Item.Properties().food(ModFoodProperties.CAYENNE_SEEDS);
    public static final Item.Properties ORANGE_HABANERO_SEEDS = new Item.Properties().food(ModFoodProperties.ORANGE_HABANERO_SEEDS);

    public static final Item.Properties BELL_PEPPER = new Item.Properties().food(ModFoodProperties.BELL_PEPPER);
    public static final Item.Properties JALAPENO = new Item.Properties().food(ModFoodProperties.JALAPENO);
    public static final Item.Properties CAYENNE = new Item.Properties().food(ModFoodProperties.CAYENNE);
    public static final Item.Properties ORANGE_HABANERO = new Item.Properties().food(ModFoodProperties.ORANGE_HABANERO);

    public static final Item.Properties POMEGRANATE_SEEDS = new Item.Properties().food(ModFoodProperties.POMEGRANATE_SEEDS);
    public static final Item.Properties POMEGRANATE = new Item.Properties().food(ModFoodProperties.POMEGRANATE);
    public static final Item.Properties GLISTERING_POMEGRANATE = new Item.Properties().food(ModFoodProperties.GLISTERING_POMEGRANATE);

    public static final Item.Properties POMEGRENADE = new Item.Properties().stacksTo(16);

    public static final Item.Properties PARSNIP = new Item.Properties().food(Foods.CARROT);
    public static final Item.Properties IRON_PARSNIP = new Item.Properties().food(ModFoodProperties.IRON_PARSNIP);

}
