package net.faelynjpg.tutorialmod.datagen;

import net.faelynjpg.tutorialmod.block.ModBlocks;
import net.faelynjpg.tutorialmod.item.ModItems;

import net.faelynjpg.tutorialmod.item.custom.ModEquipmentAssets;
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

        Block BISMUTH_BLOCK = ModBlocks.BISMUTH_BLOCK.get();
        blockModels.createTrivialCube(BISMUTH_BLOCK);
        blockModels.createTrivialCube(ModBlocks.BISMUTH_ORE.get());
        blockModels.createTrivialCube(ModBlocks.BISMUTH_DEEPSLATE_ORE.get());
        blockModels.createTrivialCube(ModBlocks.MAGIC_BLOCK.get());

        itemModels.generateFlatItem(ModItems.BISMUTH.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.RAW_BISMUTH.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ModItems.RADISH.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.STARLIGHT_ASHES.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.FROSTFIRE_ICE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.CHISEL.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.BISMUTH_SWORD.get() , ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.BISMUTH_PICKAXE.get() , ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.BISMUTH_AXE.get() , ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.BISMUTH_SHOVEL.get() , ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.BISMUTH_HOE.get() , ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.BISMUTH_HAMMER.get() , ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModels.generateTrimmableItem(ModItems.BISMUTH_HELMET.get(), ModEquipmentAssets.BISMUTH, "helmet", false);
        itemModels.generateTrimmableItem(ModItems.BISMUTH_CHESTPLATE.get(), ModEquipmentAssets.BISMUTH, "chestplate", false);
        itemModels.generateTrimmableItem(ModItems.BISMUTH_LEGGINGS.get(), ModEquipmentAssets.BISMUTH, "leggings", false);
        itemModels.generateTrimmableItem(ModItems.BISMUTH_BOOTS.get(), ModEquipmentAssets.BISMUTH, "boots", false);


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
