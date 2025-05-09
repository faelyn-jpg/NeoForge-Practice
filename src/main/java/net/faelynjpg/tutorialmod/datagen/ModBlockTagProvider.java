package net.faelynjpg.tutorialmod.datagen;

import net.faelynjpg.tutorialmod.TutorialMod;
import net.faelynjpg.tutorialmod.block.ModBlocks;
import net.faelynjpg.tutorialmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, TutorialMod.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider lookupProvider) {
        tag(ModTags.Blocks.NEEDS_BISMUTH_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL);


        tag(ModTags.Blocks.INCORRECT_FOR_BISMUTH_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .remove(ModTags.Blocks.NEEDS_BISMUTH_TOOL);


        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.BISMUTH_BLOCK.get())
                .add(ModBlocks.BISMUTH_ORE.get())
                .add(ModBlocks.BISMUTH_DEEPSLATE_ORE.get())
                .add(ModBlocks.MAGIC_BLOCK.get())
                .add(ModBlocks.BISMUTH_SLAB.get())
                .add(ModBlocks.BISMUTH_STAIRS.get())
                .add(ModBlocks.BISMUTH_DOOR.get())
                .add(ModBlocks.BISMUTH_TRAPDOOR.get())
                .add(ModBlocks.BISMUTH_PRESSURE_PLATE.get())
                .add(ModBlocks.BISMUTH_BUTTON.get())
                .add(ModBlocks.BISMUTH_LAMP.get());
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.BISMUTH_FENCE.get());
        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.BISMUTH_DEEPSLATE_ORE.get())
                .add(ModBlocks.BISMUTH_BLOCK.get())
                .add(ModBlocks.BISMUTH_ORE.get())
                .add(ModBlocks.BISMUTH_DEEPSLATE_ORE.get())
                .add(ModBlocks.MAGIC_BLOCK.get())
                .add(ModBlocks.BISMUTH_SLAB.get())
                .add(ModBlocks.BISMUTH_STAIRS.get())
                .add(ModBlocks.BISMUTH_DOOR.get())
                .add(ModBlocks.BISMUTH_TRAPDOOR.get())
                .add(ModBlocks.BISMUTH_PRESSURE_PLATE.get())
                .add(ModBlocks.BISMUTH_FENCE.get())
                .add(ModBlocks.BISMUTH_BUTTON.get());

        tag(BlockTags.FENCES)
                .add(ModBlocks.BISMUTH_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.BISMUTH_FENCE_GATE.get());
        tag(BlockTags.WALLS).add(ModBlocks.BISMUTH_WALL.get());
        tag(BlockTags.DOORS).add(ModBlocks.BISMUTH_DOOR.get());
        tag(BlockTags.TRAPDOORS).add(ModBlocks.BISMUTH_TRAPDOOR.get());
    }
}
