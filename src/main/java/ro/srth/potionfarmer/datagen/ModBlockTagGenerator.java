package ro.srth.potionfarmer.datagen;


import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import ro.srth.potionfarmer.Mod;
import ro.srth.potionfarmer.registry.BlockRegistry;
import ro.srth.potionfarmer.util.PotionFarmerTags;

import java.util.concurrent.CompletableFuture;
public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Mod.MOD_ID, existingFileHelper);
    }
    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(PotionFarmerTags.Blocks.CROPS)
                .add(BlockRegistry.POMEGRANATE_SHRUB.get())
                .add(BlockRegistry.BELL_PEPPER_CROP.get())
                .add(BlockRegistry.JALAPENO_CROP.get())
                .add(BlockRegistry.CAYENNE_CROP.get())
                .add(BlockRegistry.ORANGE_HABANERO_CROP.get())
                .add(BlockRegistry.PARSNIP_CROP.get())
                .addTag(PotionFarmerTags.Blocks.CROPS);
    }
}