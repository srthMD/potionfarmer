package ro.srth.potionfarmer.registry;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ro.srth.potionfarmer.Mod;
import ro.srth.potionfarmer.entity.PomegrenadeEntity;

public class EntityRegistry {

    public static final RegistryObject<EntityType<PomegrenadeEntity>> POMEGRENADE;

    public static final DeferredRegister<EntityType<?>> Entities = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Mod.MOD_ID);

    private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
        return Entities.register(registryname, () -> entityTypeBuilder.build(registryname));
    }

    static {
        POMEGRENADE = register("thrown_pomegrenade", EntityType.Builder.<PomegrenadeEntity>of(PomegrenadeEntity::new, MobCategory.MISC).fireImmune().sized(0.98F, 0.98F).clientTrackingRange(10).updateInterval(10));
    }
}
