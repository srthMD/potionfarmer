package ro.srth.potionfarmer.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import ro.srth.potionfarmer.Mod;

public final class BlockStateProvider extends net.minecraftforge.client.model.generators.BlockStateProvider {
    public BlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Mod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {}

    private void genBlock(RegistryObject<Block> obj){
       simpleBlockWithItem(obj.get(), cubeAll(obj.get()));
    }
}
