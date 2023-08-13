package ro.srth.potionfarmer.datagen;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import ro.srth.potionfarmer.block.PomegranateShrub;
import ro.srth.potionfarmer.registry.BlockRegistry;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.add(BlockRegistry.POMEGRANATE_SHRUB.get(), (block -> noDrop()));
        this.add(BlockRegistry.PARSNIP_CROP.get(), (block -> noDrop()));
        this.add(BlockRegistry.JALAPENO_CROP.get(), (block -> noDrop()));
        this.add(BlockRegistry.BELL_PEPPER_CROP.get(), (block -> noDrop()));
        this.add(BlockRegistry.ORANGE_HABANERO_CROP.get(), (block -> noDrop()));
        this.add(BlockRegistry.CAYENNE_CROP.get(), (block -> noDrop()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BlockRegistry.Blocks.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
