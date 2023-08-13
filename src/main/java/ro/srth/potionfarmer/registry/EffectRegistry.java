package ro.srth.potionfarmer.registry;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ro.srth.potionfarmer.Mod;
import ro.srth.potionfarmer.effect.LifeStealEffect;
import ro.srth.potionfarmer.effect.SpiceEffect;

public class EffectRegistry {
    public static final DeferredRegister<MobEffect> Effects = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Mod.MOD_ID);

    public static final RegistryObject<MobEffect> LIFE_STEAL = Effects.register("life_steal", () -> new LifeStealEffect(MobEffectCategory.BENEFICIAL, 8000007));
    public static final RegistryObject<MobEffect> SPICE_EFFECT = Effects.register("spice_effect", () -> new SpiceEffect(MobEffectCategory.BENEFICIAL, 9920000));
}
