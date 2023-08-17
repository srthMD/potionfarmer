package ro.srth.potionfarmer.registry;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ro.srth.potionfarmer.Mod;
import ro.srth.potionfarmer.block.ParsnipCrop;
import ro.srth.potionfarmer.block.PomegranateShrub;
import ro.srth.potionfarmer.block.pepper.BellPepperCrop;
import ro.srth.potionfarmer.block.pepper.CayenneCrop;
import ro.srth.potionfarmer.block.pepper.JalapenoCrop;
import ro.srth.potionfarmer.block.pepper.OrangeHabaneroCrop;

import java.util.function.Supplier;

public class BlockRegistry {
    public static final DeferredRegister<Block> Blocks = DeferredRegister.create(ForgeRegistries.BLOCKS, Mod.MOD_ID);

    public static final RegistryObject<Block> POMEGRANATE_SHRUB = register("pomegranate_shrub", () -> new PomegranateShrub(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.SWEET_BERRY_BUSH)));
    public static final RegistryObject<Block> PARSNIP_CROP = register("parsnip_crop", () -> new ParsnipCrop(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.CARROTS)));
    public static final RegistryObject<Block> BELL_PEPPER_CROP = register("bell_pepper_crop", () -> new BellPepperCrop(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.WHEAT)));
    public static final RegistryObject<Block> JALAPENO_CROP = register("jalapeno_crop", () -> new JalapenoCrop(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.WHEAT)));
    public static final RegistryObject<Block> CAYENNE_CROP = register("cayenne_crop", () -> new CayenneCrop(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.WHEAT)));
    public static final RegistryObject<Block> ORANGE_HABANERO_CROP = register("orange_habanero_crop", () -> new OrangeHabaneroCrop(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.WHEAT)));



    protected static <T extends Block> RegistryObject<Block> register(String name, boolean withItem, Supplier<T> sup){
        RegistryObject<Block> reg = Blocks.register(name, sup);
        if(withItem){
            registerItem(name, reg);
        }
        return reg;
    }

    protected static <T extends Block> RegistryObject<Block> register(String name, Supplier<T> sup){
        RegistryObject<Block> reg = Blocks.register(name, sup);
        return reg;
    }

    protected static <T extends Block> RegistryObject<Block> register(String name, boolean withItem, Supplier<T> sup, Item.Properties properties){
        RegistryObject<Block> reg = Blocks.register(name, sup);
        if(withItem){
            registerItem(name, reg, properties);
        }
        return reg;
    }

    private static <T extends Block> void registerItem(final String name, RegistryObject<Block> obj){
        ItemRegistry.Items.register(name, () -> new BlockItem(obj.get(), new Item.Properties()));
    }

    private static <T extends Block> void registerItem(final String name, RegistryObject<Block> obj, Item.Properties properties){
        ItemRegistry.Items.register(name, () -> new BlockItem(obj.get(), properties));
    }
}
