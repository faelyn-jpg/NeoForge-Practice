package net.faelynjpg.tutorialmod.datagen.models;

import net.faelynjpg.tutorialmod.block.ModBlocks;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;

import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.model.ModelTemplates;


import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import static net.minecraft.client.data.models.BlockModelGenerators.*;


public class ModModelProvider extends ModelProvider {

    public ModModelProvider(PackOutput output) {
        super(output, "tutorialmod");
    }

    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {

        new ModItemModelGenerator(itemModels.itemModelOutput, itemModels.modelOutput).run();

        Block BISMUTH_BLOCK = ModBlocks.BISMUTH_BLOCK.get();
        blockModels.createTrivialCube(BISMUTH_BLOCK);
        blockModels.createTrivialCube(ModBlocks.BISMUTH_ORE.get());
        blockModels.createTrivialCube(ModBlocks.BISMUTH_DEEPSLATE_ORE.get());
        blockModels.createTrivialCube(ModBlocks.MAGIC_BLOCK.get());


        blockModels.familyWithExistingFullBlock(BISMUTH_BLOCK).stairs(ModBlocks.BISMUTH_STAIRS.get());
        blockModels.familyWithExistingFullBlock(BISMUTH_BLOCK).slab(ModBlocks.BISMUTH_SLAB.get());

        blockModels.familyWithExistingFullBlock(BISMUTH_BLOCK).pressurePlate(ModBlocks.BISMUTH_PRESSURE_PLATE.get());
        blockModels.familyWithExistingFullBlock(BISMUTH_BLOCK).button(ModBlocks.BISMUTH_BUTTON.get());

        blockModels.familyWithExistingFullBlock(BISMUTH_BLOCK).fence(ModBlocks.BISMUTH_FENCE.get());
        blockModels.familyWithExistingFullBlock(BISMUTH_BLOCK).fenceGate(ModBlocks.BISMUTH_FENCE_GATE.get());
        blockModels.familyWithExistingFullBlock(BISMUTH_BLOCK).wall(ModBlocks.BISMUTH_WALL.get());

        doorWithRenderType(blockModels, ModBlocks.BISMUTH_DOOR.get());
        trapdoorWithRenderType(blockModels, ModBlocks.BISMUTH_TRAPDOOR.get());
        customLamp(blockModels, ModBlocks.BISMUTH_LAMP.get());


    }


    private void doorWithRenderType(BlockModelGenerators blockModels, Block block) {
        TextureMapping texturemapping = TextureMapping.door(block);
        blockModels.registerSimpleFlatItemModel(block.asItem());
        blockModels.blockStateOutput.accept(
                createDoor(ModBlocks.BISMUTH_DOOR.get(), ModelTemplates.DOOR_BOTTOM_LEFT.extend().renderType("minecraft:cutout").build().create(block, texturemapping, blockModels.modelOutput),
                        ModelTemplates.DOOR_BOTTOM_LEFT_OPEN.extend().renderType("minecraft:cutout").build().create(block, texturemapping, blockModels.modelOutput),
                        ModelTemplates.DOOR_BOTTOM_RIGHT.extend().renderType("minecraft:cutout").build().create(block, texturemapping, blockModels.modelOutput),
                        ModelTemplates.DOOR_BOTTOM_RIGHT_OPEN.extend().renderType("minecraft:cutout").build().create(block, texturemapping, blockModels.modelOutput),
                        ModelTemplates.DOOR_TOP_LEFT.extend().renderType("minecraft:cutout").build().create(block, texturemapping, blockModels.modelOutput),
                        ModelTemplates.DOOR_TOP_LEFT_OPEN.extend().renderType("minecraft:cutout").build().create(block, texturemapping, blockModels.modelOutput),
                        ModelTemplates.DOOR_TOP_RIGHT.extend().renderType("minecraft:cutout").build().create(block, texturemapping, blockModels.modelOutput),
                        ModelTemplates.DOOR_TOP_RIGHT_OPEN.extend().renderType("minecraft:cutout").build().create(block, texturemapping, blockModels.modelOutput)));

    }

    private void trapdoorWithRenderType(BlockModelGenerators blockModels, Block block) {
        TextureMapping texturemapping = TextureMapping.defaultTexture(block);
        ResourceLocation resourcelocation = ModelTemplates.ORIENTABLE_TRAPDOOR_TOP.extend().renderType("minecraft:cutout").build().create(block, texturemapping, blockModels.modelOutput);
        ResourceLocation resourcelocation1 = ModelTemplates.ORIENTABLE_TRAPDOOR_BOTTOM.extend().renderType("minecraft:cutout").build().create(block, texturemapping, blockModels.modelOutput);
        ResourceLocation resourcelocation2 = ModelTemplates.ORIENTABLE_TRAPDOOR_OPEN.extend().renderType("minecraft:cutout").build().create(block, texturemapping, blockModels.modelOutput);
        blockModels.registerSimpleItemModel(block, resourcelocation1);
        blockModels.blockStateOutput.accept(createOrientableTrapdoor(block, resourcelocation, resourcelocation1, resourcelocation2));

    }

    private void customLamp(BlockModelGenerators blockModel, Block block) {
        ResourceLocation resourcelocation = TexturedModel.CUBE.create(block, blockModel.modelOutput);
        ResourceLocation resourcelocation1 = blockModel.createSuffixedVariant(block, "_on", ModelTemplates.CUBE_ALL, TextureMapping::cube);
        blockModel.blockStateOutput
                .accept(
                        MultiVariantGenerator.multiVariant(block)
                                .with(createBooleanModelDispatch(BlockStateProperties.LIT, resourcelocation1, resourcelocation))
                );
    }



}
