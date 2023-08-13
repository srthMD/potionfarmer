package ro.srth.potionfarmer.entity;

import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import ro.srth.potionfarmer.registry.EntityRegistry;
import ro.srth.potionfarmer.registry.ItemRegistry;

;

public class PomegrenadeEntity extends ThrowableItemProjectile {


    public PomegrenadeEntity(EntityType<? extends PomegrenadeEntity> pEntityType, Level pLevel) {
        super(EntityRegistry.POMEGRENADE.get(), pLevel);
    }


    public PomegrenadeEntity(double pX, double pY, double pZ, Level pLevel) {
        super(EntityRegistry.POMEGRENADE.get(), pX, pY, pZ, pLevel);
    }

    public PomegrenadeEntity(LivingEntity pShooter, Level pLevel) {
        super(EntityRegistry.POMEGRENADE.get(), pShooter, pLevel);
    }

    private ParticleOptions getParticle() {
        ItemStack itemstack = this.getItemRaw();
        return (ParticleOptions)(itemstack.isEmpty() ? ParticleTypes.ITEM : new ItemParticleOption(ParticleTypes.ITEM, itemstack));
    }

    public void handleEntityEvent(byte pId) {
        if (pId == 3) {
            ParticleOptions particleoptions = this.getParticle();

            for(int i = 0; i < 8; ++i) {
                this.level().addParticle(particleoptions, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
            }
        }
    }

    @Override
    protected void onHit(HitResult pResult) {
        super.onHit(pResult);
        if (!this.level().isClientSide) {
            this.level().explode(null, pResult.getLocation().x, pResult.getLocation().y, pResult.getLocation().z, 0.75f, Level.ExplosionInteraction.BLOCK);
        }
        this.discard();
    }

    byte current = 0;
    @Override
    public void tick() {
        super.tick();
        if(current >= 100){
            if (!this.level().isClientSide) {
                this.level().explode(null, this.getX(), this.getY(), this.getZ(), 0.75f, Level.ExplosionInteraction.BLOCK);
            }
            this.discard();
        }
        if(this.level().isClientSide){
            this.level().addParticle(ParticleTypes.SMOKE, this.getX(), this.getY() + 0.25D, this.getZ() + 0.1D, 0.0D, 0.0D, 0.0D);
        }
        current++;
    }

    @Override
    protected Item getDefaultItem() {
        return ItemRegistry.POMEGRENADE.get();
    }
}
