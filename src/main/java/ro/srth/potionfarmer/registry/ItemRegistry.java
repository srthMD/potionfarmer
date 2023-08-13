package ro.srth.potionfarmer.registry;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ro.srth.potionfarmer.Mod;
import ro.srth.potionfarmer.item.Pomegrenade;
import ro.srth.potionfarmer.item.properties.ModFoodProperties;
import ro.srth.potionfarmer.item.properties.ModItemProperties;

public class ItemRegistry {
    public static final DeferredRegister<Item> Items = DeferredRegister.create(ForgeRegistries.ITEMS, Mod.MOD_ID);

    //foods
    public static final RegistryObject<Item> POMEGRANATE = Items.register("pomegranate", () -> new Item(ModItemProperties.POMEGRANATE));
    public static final RegistryObject<Item> PARSNIP = Items.register("parsnip", () -> new ItemNameBlockItem(BlockRegistry.PARSNIP_CROP.get(), ModItemProperties.PARSNIP));
    //also a potion ingredient but has a much better use case as a food due to its low duration for resistance pots
    public static final RegistryObject<Item> IRON_PARSNIP = Items.register("iron_parsnip", () -> new Item(ModItemProperties.IRON_PARSNIP));
    public static final RegistryObject<Item> BELL_PEPPER = Items.register("bell_pepper", () -> new Item(ModItemProperties.BELL_PEPPER));
    public static final RegistryObject<Item> JALAPENO = Items.register("jalapeno", () -> new Item(ModItemProperties.JALAPENO));
    public static final RegistryObject<Item> CAYENNE = Items.register("cayenne", () -> new Item(ModItemProperties.CAYENNE));
    public static final RegistryObject<Item> ORANGE_HABANERO = Items.register("orange_habanero", () -> new Item(ModItemProperties.ORANGE_HABANERO));

    //potion ingredients
    public static final RegistryObject<Item> GLISTERING_POMEGRANATE  = Items.register("glistering_pomegranate", () -> new Item(ModItemProperties.GLISTERING_POMEGRANATE));

    //seeds
    public static final RegistryObject<Item> POMEGRANATE_SEEDS = Items.register("pomegranate_seeds", () -> new ItemNameBlockItem(BlockRegistry.POMEGRANATE_SHRUB.get(), ModItemProperties.POMEGRANATE_SEEDS));
    public static final RegistryObject<Item> BELL_PEPPER_SEEDS = Items.register("bell_pepper_seeds", () -> new ItemNameBlockItem(BlockRegistry.BELL_PEPPER_CROP.get(), ModItemProperties.BELL_PEPPER_SEEDS));
    public static final RegistryObject<Item> JALAPENO_SEEDS = Items.register("jalapeno_seeds", () -> new ItemNameBlockItem(BlockRegistry.JALAPENO_CROP.get(), ModItemProperties.JALAPENO_SEEDS));
    public static final RegistryObject<Item> CAYENNE_SEEDS = Items.register("cayenne_seeds", () -> new ItemNameBlockItem(BlockRegistry.CAYENNE_CROP.get(), ModItemProperties.CAYENNE_SEEDS));
    public static final RegistryObject<Item> ORANGE_HABANERO_SEEDS = Items.register("orange_habanero_seeds", () -> new ItemNameBlockItem(BlockRegistry.ORANGE_HABANERO_CROP.get(),ModItemProperties.ORANGE_HABANERO_SEEDS));

    //misc
    public static final RegistryObject<Item> POMEGRENADE = Items.register("pomegrenade", () -> new Pomegrenade(ModItemProperties.POMEGRENADE));

}
