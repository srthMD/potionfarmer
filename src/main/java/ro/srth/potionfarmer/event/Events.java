package ro.srth.potionfarmer.event;


import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TippedArrowItem;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import ro.srth.potionfarmer.registry.EffectRegistry;
import ro.srth.potionfarmer.registry.ItemRegistry;
import ro.srth.potionfarmer.registry.PotionRegistry;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
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

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        final int villagerLevel1 = 1;
        final int villagerLevel2 = 2;
        final int villagerLevel3 = 3;
        VillagerProfession profession = event.getType();
        if(profession == VillagerProfession.FARMER) {

            ThreadLocalRandom random = ThreadLocalRandom.current();

            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ItemRegistry.PARSNIP.get(), random.nextInt(4,8));
            ItemStack stack1 = new ItemStack(ItemRegistry.POMEGRANATE.get(), random.nextInt(2,4));
            ItemStack stack2 = new ItemStack(ItemRegistry.IRON_PARSNIP.get(), random.nextInt(1,3));
            ItemStack stack3 = new ItemStack(ItemRegistry.GLISTERING_POMEGRANATE.get(), random.nextInt(1,4));

            ItemStack stack4 = new ItemStack(ItemRegistry.BELL_PEPPER_SEEDS.get(), random.nextInt(3,6));
            ItemStack stack5 = new ItemStack(ItemRegistry.JALAPENO_SEEDS.get(), random.nextInt(2,3));
            ItemStack stack6 = new ItemStack(ItemRegistry.CAYENNE_SEEDS.get(), random.nextInt(1,2));
            ItemStack stack7 = new ItemStack(ItemRegistry.ORANGE_HABANERO_SEEDS.get(), 1);

            ItemStack stack8 = new ItemStack(ItemRegistry.BELL_PEPPER.get(), 10);

            trades.get(villagerLevel1).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, stack.getCount()+4), stack,10,4,0.05F));
            trades.get(villagerLevel2).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, stack1.getCount()+2), stack1,10,5,0.05F));
            trades.get(villagerLevel3).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, stack2.getCount()+5), stack2,4,15,0.1F));
            trades.get(villagerLevel3).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, stack3.getCount()+5), stack3,4,20,0.1F));

            trades.get(villagerLevel1).add((trader, rand) -> new MerchantOffer(stack8, new ItemStack(Items.EMERALD, 8), 16, 5, 0.05F));

            trades.get(villagerLevel1).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, stack.getCount()+1), stack4,12,2,0.05F));
            trades.get(villagerLevel2).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, stack1.getCount()+2), stack5,8,5,0.1F));
            trades.get(villagerLevel3).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, stack2.getCount()+4), stack6,4,15,0.175F));
            trades.get(villagerLevel3).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, stack3.getCount()+10), stack7,2,30,0.3F));
        }
    }
}
