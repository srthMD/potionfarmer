package ro.srth.potionfarmer.registry;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ro.srth.potionfarmer.Mod;
import ro.srth.potionfarmer.util.external.EPRecipie;

public class PotionRegistry {
    public static final DeferredRegister<Potion> Potions = DeferredRegister.create(ForgeRegistries.POTIONS, Mod.MOD_ID);

    public static final RegistryObject<Potion> SHORT_LIFE_STEAL_POTION = Potions.register("short_life_steal_potion", () -> new Potion(new MobEffectInstance(EffectRegistry.LIFE_STEAL.get(), 1800, 0)));
    public static final RegistryObject<Potion> LONG_LIFE_STEAL_POTION = Potions.register("long_life_steal_potion", () -> new Potion(new MobEffectInstance(EffectRegistry.LIFE_STEAL.get(), 3600, 0)));
    public static final RegistryObject<Potion> AMPLIFIED_LIFE_STEAL_POTION = Potions.register("amplified_life_steal_potion", () -> new Potion(new MobEffectInstance(EffectRegistry.LIFE_STEAL.get(), 800, 1)));

    public static final RegistryObject<Potion> SHORT_RESISTANCE_POTION = Potions.register("short_resistance_potion", () -> new Potion(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 400, 0)));
    public static final RegistryObject<Potion> LONG_RESISTANCE_POTION = Potions.register("long_resistance_potion", () -> new Potion(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 0)));
    public static final RegistryObject<Potion> AMPLIFIED_RESISTANCE_POTION = Potions.register("amplified_resistance_potion", () -> new Potion(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 300, 1)));

    public static final RegistryObject<Potion> SHORT_FIRE_RESISTANCE = Potions.register("short_fire_resistance_potion", () -> new Potion(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600, 0)));
    public static final RegistryObject<Potion> LONG_FIRE_RESISTANCE = Potions.register("long_fire_resistance_potion", () -> new Potion(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1500, 0)));

    public static void registerRecipies(){
        BrewingRecipeRegistry.addRecipe(new EPRecipie(net.minecraft.world.item.alchemy.Potions.AWKWARD, ItemRegistry.GLISTERING_POMEGRANATE.get(), PotionRegistry.SHORT_LIFE_STEAL_POTION.get()));
        BrewingRecipeRegistry.addRecipe(new EPRecipie(PotionRegistry.SHORT_LIFE_STEAL_POTION.get(), Items.REDSTONE, PotionRegistry.LONG_LIFE_STEAL_POTION.get()));
        BrewingRecipeRegistry.addRecipe(new EPRecipie(PotionRegistry.LONG_LIFE_STEAL_POTION.get(), Items.GLOWSTONE, PotionRegistry.AMPLIFIED_LIFE_STEAL_POTION.get()));

        BrewingRecipeRegistry.addRecipe(new EPRecipie(net.minecraft.world.item.alchemy.Potions.AWKWARD, ItemRegistry.IRON_PARSNIP.get(), PotionRegistry.AMPLIFIED_LIFE_STEAL_POTION.get()));
        BrewingRecipeRegistry.addRecipe(new EPRecipie(PotionRegistry.SHORT_RESISTANCE_POTION.get(), Items.REDSTONE, PotionRegistry.LONG_RESISTANCE_POTION.get()));
        BrewingRecipeRegistry.addRecipe(new EPRecipie(PotionRegistry.LONG_RESISTANCE_POTION.get(), Items.GLOWSTONE, PotionRegistry.AMPLIFIED_RESISTANCE_POTION.get()));

        BrewingRecipeRegistry.addRecipe(new EPRecipie(net.minecraft.world.item.alchemy.Potions.AWKWARD, ItemRegistry.CAYENNE.get(), PotionRegistry.SHORT_FIRE_RESISTANCE.get()));
        BrewingRecipeRegistry.addRecipe(new EPRecipie(net.minecraft.world.item.alchemy.Potions.AWKWARD, ItemRegistry.ORANGE_HABANERO.get(), PotionRegistry.LONG_FIRE_RESISTANCE.get()));
    }

}
