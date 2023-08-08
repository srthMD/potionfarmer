package ro.srth.potionfarmer.entity;

import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import ro.srth.potionfarmer.registry.EntityRegistry;

public class PomegrenadeEntity extends Snowball {

    public PomegrenadeEntity(EntityType<? extends Snowball> pEntityType, Level pLevel) {
        super(EntityRegistry.POMEGRENADE.get(), pLevel);
    }

    public PomegrenadeEntity(Level pLevel, LivingEntity pShooter) {
        super(pLevel, pShooter);
    }

    public PomegrenadeEntity(Level pLevel, double pX, double pY, double pZ) {
        super(pLevel, pX, pY, pZ);
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
            this.level().explode(null, pResult.getLocation().x, pResult.getLocation().y, pResult.getLocation().z, 1f, Level.ExplosionInteraction.BLOCK);
        }
    }

    byte current = 0;
    @Override
    public void tick() {
        super.tick();
        if(current <= 5){
            current = 0;
            this.level().addParticle(ParticleTypes.SMOKE, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
        }
        current++;
    }
}
