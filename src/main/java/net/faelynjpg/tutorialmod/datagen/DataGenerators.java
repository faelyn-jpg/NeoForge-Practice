package net.faelynjpg.tutorialmod.datagen;

import net.faelynjpg.tutorialmod.TutorialMod;


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

@EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD)

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
       event.createProvider(ModModelProvider::new);
       BlockTagsProvider blockTagsProvider = event.createProvider(ModBlockTagProvider::new);
        event.createProvider((output, lookupProvider) ->  new ModItemTagProvider(
                output, lookupProvider, blockTagsProvider.contentsGetter()
        ));
    }

}
