//package ro.srth.potionfarmer.datagen;
//
//
//import net.minecraft.core.HolderLookup;
//import net.minecraft.core.RegistrySetBuilder;
//import net.minecraft.core.registries.Registries;
//import net.minecraft.data.PackOutput;
//import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
//
//import java.util.Collections;
//import java.util.concurrent.CompletableFuture;
//
//public class WorldGeneratorProvider extends DatapackBuiltinEntriesProvider {
//   public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
//           .add(Registries.CONFIGURED_FEATURE, ConfigFeatures::bootstrap)
//           .add(Registries.PLACED_FEATURE, PlacedFeatures::bootstrap);
//
//    public WorldGeneratorProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
//        super(output, registries, BUILDER, Collections.singleton(Mod.MODID));
//    }
//}