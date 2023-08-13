package ro.srth.potionfarmer.item.properties;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import ro.srth.potionfarmer.registry.EffectRegistry;

public class ModFoodProperties {
    public static final FoodProperties POMEGRANATE = new FoodProperties.Builder().nutrition(3).saturationMod(0.25F).build();
    public static final FoodProperties POMEGRANATE_SEEDS = new FoodProperties.Builder().nutrition(1).saturationMod(0.075F).fast().build();
    public static final FoodProperties IRON_PARSNIP =  new FoodProperties.Builder().nutrition(7).saturationMod(1F).build();

    public static final FoodProperties GLISTERING_POMEGRANATE = new FoodProperties.Builder().nutrition(2).saturationMod(0F)
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 60, 1), 1f)
            .build();

    public static final FoodProperties BELL_PEPPER =  new FoodProperties.Builder().nutrition(3).saturationMod(0.2F).build();

    public static final FoodProperties JALAPENO =  new FoodProperties.Builder().nutrition(2).saturationMod(0.05F)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 0), 1f)
            .build();

    public static final FoodProperties CAYENNE =  new FoodProperties.Builder().nutrition(2).saturationMod(0F)
            .effect(() -> new MobEffectInstance(EffectRegistry.SPICE_EFFECT.get(), 100, 1), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100, 0), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 100, 0), 1f)
            .build();

    public static final FoodProperties ORANGE_HABANERO =  new FoodProperties.Builder().nutrition(1).saturationMod(0F)
            .effect(() -> new MobEffectInstance(EffectRegistry.SPICE_EFFECT.get(), 180, 1), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 180, 1), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 180, 1), 1f)
            .build();

    public static final FoodProperties BELL_PEPPER_SEEDS =  new FoodProperties.Builder().nutrition(1).saturationMod(0F).fast().build();
    public static final FoodProperties JALAPENO_SEEDS =  new FoodProperties.Builder().nutrition(1).saturationMod(0F).fast()
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0), 1f)
            .build();

    public static final FoodProperties CAYENNE_SEEDS =  new FoodProperties.Builder().nutrition(1).saturationMod(0F).fast()
            .effect(() -> new MobEffectInstance(EffectRegistry.SPICE_EFFECT.get(), 140, 1), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 80, 0), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 80, 0), 1f)
            .build();

    public static final FoodProperties ORANGE_HABANERO_SEEDS =  new FoodProperties.Builder().nutrition(1).saturationMod(0F).fast()
            .effect(() -> new MobEffectInstance(EffectRegistry.SPICE_EFFECT.get(), 200, 1), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 140, 0), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 140, 0), 1f)
            .build();

}
