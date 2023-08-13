package ro.srth.potionfarmer.event;


import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import ro.srth.potionfarmer.registry.EffectRegistry;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;


@Mod.EventBusSubscriber(modid = ro.srth.potionfarmer.Mod.MOD_ID)
public class Events {
    @SubscribeEvent
    public static void onAttackWithLifeSteal(LivingAttackEvent event){
        if(!event.getEntity().level().isClientSide){
            LivingEntity attacker = (LivingEntity)event.getSource().getEntity();
            if(attacker == null){return;}

            AtomicBoolean hasEffect = new AtomicBoolean(false);
            AtomicInteger amplifier = new AtomicInteger(1);

            attacker.getActiveEffects().forEach((effect) -> {
                if(effect.getEffect().equals(EffectRegistry.LIFE_STEAL.get())){
                    hasEffect.set(true);
                    amplifier.set(effect.getAmplifier());
                }
            });

            if(hasEffect.get()){
                float dmg = event.getAmount();
                float toHeal = dmg*((float) (amplifier.get()+1)/10);

                attacker.heal(toHeal);
            }
        }
    }
}
