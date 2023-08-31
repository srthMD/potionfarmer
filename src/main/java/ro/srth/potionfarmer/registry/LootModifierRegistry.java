package ro.srth.potionfarmer.registry;

import com.mojang.serialization.Codec;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ro.srth.potionfarmer.Mod;
import ro.srth.potionfarmer.loot.*;

public class LootModifierRegistry {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> Modifiers =
            DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Mod.MOD_ID);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> COMMON_SEED_MODIFIER =
            Modifiers.register("common_seed_modifier", CommonSeedModifier.CODEC);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> UNCOMMON_SEED_MODIFIER =
            Modifiers.register("uncommon_seed_modifier", UncommonSeedModifier.CODEC);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> RARE_SEED_MODIFIER =
            Modifiers.register("rare_seed_modifier", RareSeedModifier.CODEC);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> EXTRA_RARE_SEED_MODIFIER =
            Modifiers.register("extra_rare_seed_modifier", ExtraRareSeedModifier.CODEC);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> LEGENDARY_SEED_MODIFIER =
            Modifiers.register("legendary_seed_modifier", LegendarySeedModifier.CODEC);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> PARSNIP_MODIFIER =
            Modifiers.register("parsnip_modifier", ParsnipModifier.CODEC);

}
