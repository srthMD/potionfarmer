package ro.srth.potionfarmer;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import ro.srth.potionfarmer.registry.*;


@net.minecraftforge.fml.common.Mod(Mod.MOD_ID)
public class Mod
{
    public static final String MOD_ID = "potionfarmer";

    public static final Logger log = LogUtils.getLogger();

    public Mod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);

        BlockRegistry.Blocks.register(modEventBus);
        ItemRegistry.Items.register(modEventBus);
        LootModifierRegistry.Modifiers.register(modEventBus);
        EntityRegistry.Entities.register(modEventBus);
        EffectRegistry.Effects.register(modEventBus);
        PotionRegistry.Potions.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }


    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(PotionRegistry::registerRecipies);
    }




    private void addCreative(BuildCreativeModeTabContentsEvent event){
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS){
            event.accept(ItemRegistry.GLISTERING_POMEGRANATE.get());
        } else if(event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS){
            event.accept(ItemRegistry.POMEGRANATE.get());
            event.accept(ItemRegistry.PARSNIP.get());
            event.accept(ItemRegistry.IRON_PARSNIP.get());
            event.accept(ItemRegistry.BELL_PEPPER.get());
            event.accept(ItemRegistry.BELL_PEPPER_SEEDS.get());
            event.accept(ItemRegistry.JALAPENO.get());
            event.accept(ItemRegistry.JALAPENO_SEEDS.get());
            event.accept(ItemRegistry.CAYENNE.get());
            event.accept(ItemRegistry.CAYENNE_SEEDS.get());
            event.accept(ItemRegistry.ORANGE_HABANERO.get());
            event.accept(ItemRegistry.ORANGE_HABANERO_SEEDS.get());
        } else if (event.getTabKey() == CreativeModeTabs.SEARCH) {
            ItemRegistry.Items.getEntries().forEach((item) -> {event.accept(item.get());});
        }
    }
}
