package ro.srth.potionfarmer.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import ro.srth.potionfarmer.Mod;
import ro.srth.potionfarmer.registry.ItemRegistry;


public final class ItemModelProvider extends net.minecraftforge.client.model.generators.ItemModelProvider {
    public ItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Mod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        handheldItem(ItemRegistry.POMEGRANATE);
        handheldItem(ItemRegistry.POMEGRENADE);
        handheldItem(ItemRegistry.GLISTERING_POMEGRANATE);
        handheldItem(ItemRegistry.POMEGRANATE_SEEDS);
        handheldItem(ItemRegistry.PARSNIP);
        handheldItem(ItemRegistry.IRON_PARSNIP);
        handheldItem(ItemRegistry.BELL_PEPPER);
        handheldItem(ItemRegistry.CAYENNE);
        handheldItem(ItemRegistry.JALAPENO);
        handheldItem(ItemRegistry.ORANGE_HABANERO);
        handheldItem(ItemRegistry.BELL_PEPPER_SEEDS);
        handheldItem(ItemRegistry.JALAPENO_SEEDS);
        handheldItem(ItemRegistry.CAYENNE_SEEDS);
        handheldItem(ItemRegistry.ORANGE_HABANERO_SEEDS);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> obj){
        return withExistingParent(obj.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Mod.MOD_ID, "item/" + obj.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> obj){
        return withExistingParent(obj.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(Mod.MOD_ID, "item/" + obj.getId().getPath()));
    }
}
