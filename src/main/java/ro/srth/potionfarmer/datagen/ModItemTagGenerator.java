package ro.srth.potionfarmer.datagen;


import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import ro.srth.potionfarmer.Mod;
import ro.srth.potionfarmer.registry.ItemRegistry;
import ro.srth.potionfarmer.util.PotionFarmerTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {


    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, Mod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(PotionFarmerTags.Items.FOOD)
                .add(ItemRegistry.POMEGRANATE.get())
                .add(ItemRegistry.PARSNIP.get())
                .add(ItemRegistry.IRON_PARSNIP.get())
                .add(ItemRegistry.CAYENNE.get())
                .add(ItemRegistry.BELL_PEPPER.get())
                .add(ItemRegistry.ORANGE_HABANERO.get())
                .add(ItemRegistry.JALAPENO.get())
                .add(ItemRegistry.POMEGRANATE_SEEDS.get())
                .add(ItemRegistry.ORANGE_HABANERO_SEEDS.get())
                .add(ItemRegistry.CAYENNE_SEEDS.get())
                .add(ItemRegistry.BELL_PEPPER_SEEDS.get())
                .add(ItemRegistry.JALAPENO_SEEDS.get())
                .addTag(PotionFarmerTags.Items.FOOD);

        this.tag(Tags.Items.CROPS)
                .add(ItemRegistry.POMEGRANATE.get())
                .add(ItemRegistry.PARSNIP.get())
                .add(ItemRegistry.IRON_PARSNIP.get())
                .add(ItemRegistry.CAYENNE.get())
                .add(ItemRegistry.BELL_PEPPER.get())
                .add(ItemRegistry.ORANGE_HABANERO.get())
                .add(ItemRegistry.JALAPENO.get())
                .addTag(Tags.Items.CROPS);

        this.tag(PotionFarmerTags.Items.BREWABLES)
                .add(ItemRegistry.GLISTERING_POMEGRANATE.get())
                .add(ItemRegistry.IRON_PARSNIP.get())
                .add(ItemRegistry.PARSNIP.get())
                .add(ItemRegistry.CAYENNE.get())
                .add(ItemRegistry.ORANGE_HABANERO.get())
                .addTag(PotionFarmerTags.Items.BREWABLES);

        this.tag(PotionFarmerTags.Items.SEEDS)
                .add(ItemRegistry.POMEGRANATE_SEEDS.get())
                .add(ItemRegistry.ORANGE_HABANERO_SEEDS.get())
                .add(ItemRegistry.CAYENNE_SEEDS.get())
                .add(ItemRegistry.BELL_PEPPER_SEEDS.get())
                .add(ItemRegistry.JALAPENO_SEEDS.get())
                .addTag(PotionFarmerTags.Items.SEEDS);

        this.tag(PotionFarmerTags.Items.PEPPERS)
                .add(ItemRegistry.BELL_PEPPER.get())
                .add(ItemRegistry.JALAPENO.get())
                .add(ItemRegistry.CAYENNE.get())
                .add(ItemRegistry.ORANGE_HABANERO.get())
                .addTag(PotionFarmerTags.Items.PEPPERS);
    }
}