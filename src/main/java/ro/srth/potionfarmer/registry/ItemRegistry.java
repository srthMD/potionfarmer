package ro.srth.potionfarmer.registry;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ro.srth.potionfarmer.Mod;
import ro.srth.potionfarmer.item.Pomegrenade;

public class ItemRegistry {
    public static final DeferredRegister<Item> Items = DeferredRegister.create(ForgeRegistries.ITEMS, Mod.MOD_ID);

    //foods
    public static final RegistryObject<Item> POMEGRANATE = Items.register("pomegranate", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationMod(0.25F).build())));

    //misc
    public static final RegistryObject<Item> POMEGRENADE = Items.register("pomegrenade", () -> new Pomegrenade(new Item.Properties().stacksTo(16)));

}
