package ro.srth.potionfarmer;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
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

        BlockRegistry.Blocks.register(modEventBus);
        ItemRegistry.Items.register(modEventBus);
        LootModifierRegistry.Modifiers.register(modEventBus);
        EntityRegistry.Entities.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

   private void commonSetup(final FMLCommonSetupEvent event) {}

}
