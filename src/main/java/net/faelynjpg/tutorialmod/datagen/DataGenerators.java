package net.faelynjpg.tutorialmod.datagen;

import net.faelynjpg.tutorialmod.datagen.atlases.ModAtlasesProvider;
import net.faelynjpg.tutorialmod.datagen.equipment.ModEquipmentAssetProvider;
import net.faelynjpg.tutorialmod.datagen.loot.ModBlockLootTable;
import net.faelynjpg.tutorialmod.datagen.models.ModModelProvider;
import net.faelynjpg.tutorialmod.datagen.recipe.ModRecipeProvider;
import net.faelynjpg.tutorialmod.datagen.tags.ModItemTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.LootTableProvider;

import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.jetbrains.annotations.NotNull;


import java.util.List;
import java.util.Set;

import static net.faelynjpg.tutorialmod.TutorialMod.MOD_ID;

@EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD)

public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {

       event.createProvider((output, lookupProvider) -> new LootTableProvider(
               output, Set.of(),
               List.of(new LootTableProvider.SubProviderEntry(ModBlockLootTable::new, LootContextParamSets.BLOCK)),
               lookupProvider));
       event.createProvider((output, lookupProvider) -> new RecipeProvider.Runner(output, lookupProvider) {
           @Override
           public @NotNull String getName() {
               return "";
           }
           @Override
           protected @NotNull RecipeProvider createRecipeProvider(HolderLookup.@NotNull Provider provider, @NotNull RecipeOutput output) {
               return new ModRecipeProvider(provider, output);
           }
       } );
       event.createProvider(ModDataMapProvider::new);
        event.createProvider(ModLanguageProvider::new);
       event.createProvider(ModAtlasesProvider::new);
        event.createProvider(ModDatapackProvider::new);
       event.createProvider(ModEquipmentAssetProvider::new);
       event.createProvider(ModModelProvider::new);
       BlockTagsProvider blockTagsProvider = event.createProvider(ModBlockTagProvider::new);
        event.createProvider((output, lookupProvider) ->  new ModItemTagProvider(
                output, lookupProvider, blockTagsProvider.contentsGetter()
        ));


    }

}
