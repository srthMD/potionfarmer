package ro.srth.potionfarmer.block;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CarrotBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.NotNull;
import ro.srth.potionfarmer.registry.ItemRegistry;

public class ParsnipCrop extends CarrotBlock {

    public ParsnipCrop(Properties pProperties) {
        super(pProperties);
    }

    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 7);

    @Override
    protected @NotNull ItemLike getBaseSeedId() {
        return ItemRegistry.PARSNIP.get();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(AGE);
    }

    @Override
    protected @NotNull IntegerProperty getAgeProperty() {
        return AGE;
    }

}
