package net.faelynjpg.tutorialmod.datagen;

import net.faelynjpg.tutorialmod.block.ModBlocks;
import net.faelynjpg.tutorialmod.item.ModItems;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;

import net.minecraft.client.data.models.model.ModelTemplates;


import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

import static net.minecraft.client.data.models.BlockModelGenerators.createDoor;
import static net.minecraft.client.data.models.BlockModelGenerators.createOrientableTrapdoor;


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

        blockModels.familyWithExistingFullBlock(BISMUTH_BLOCK).stairs(ModBlocks.BISMUTH_STAIRS.get());
        blockModels.familyWithExistingFullBlock(BISMUTH_BLOCK).slab(ModBlocks.BISMUTH_SLAB.get());

        blockModels.familyWithExistingFullBlock(BISMUTH_BLOCK).pressurePlate(ModBlocks.BISMUTH_PRESSURE_PLATE.get());
        blockModels.familyWithExistingFullBlock(BISMUTH_BLOCK).button(ModBlocks.BISMUTH_BUTTON.get());

        blockModels.familyWithExistingFullBlock(BISMUTH_BLOCK).fence(ModBlocks.BISMUTH_FENCE.get());
        blockModels.familyWithExistingFullBlock(BISMUTH_BLOCK).fenceGate(ModBlocks.BISMUTH_FENCE_GATE.get());
        blockModels.familyWithExistingFullBlock(BISMUTH_BLOCK).wall(ModBlocks.BISMUTH_WALL.get());

        Block BISMUTH_DOOR = ModBlocks.BISMUTH_DOOR.get();
        TextureMapping bismuth_door_texturemapping = TextureMapping.door(BISMUTH_DOOR);
        blockModels.registerSimpleFlatItemModel(BISMUTH_DOOR.asItem());
        blockModels.blockStateOutput.accept(
                createDoor(ModBlocks.BISMUTH_DOOR.get(), ModelTemplates.DOOR_BOTTOM_LEFT.extend().renderType("minecraft:cutout").build().create(BISMUTH_DOOR, bismuth_door_texturemapping, blockModels.modelOutput), ModelTemplates.DOOR_BOTTOM_LEFT_OPEN.extend().renderType("minecraft:cutout").build().create(BISMUTH_DOOR, bismuth_door_texturemapping, blockModels.modelOutput), ModelTemplates.DOOR_BOTTOM_RIGHT.extend().renderType("minecraft:cutout").build().create(BISMUTH_DOOR, bismuth_door_texturemapping, blockModels.modelOutput), ModelTemplates.DOOR_BOTTOM_RIGHT_OPEN.extend().renderType("minecraft:cutout").build().create(BISMUTH_DOOR, bismuth_door_texturemapping, blockModels.modelOutput), ModelTemplates.DOOR_TOP_LEFT.extend().renderType("minecraft:cutout").build().create(BISMUTH_DOOR, bismuth_door_texturemapping, blockModels.modelOutput), ModelTemplates.DOOR_TOP_LEFT_OPEN.extend().renderType("minecraft:cutout").build().create(BISMUTH_DOOR, bismuth_door_texturemapping, blockModels.modelOutput),ModelTemplates.DOOR_TOP_RIGHT.extend().renderType("minecraft:cutout").build().create(BISMUTH_DOOR, bismuth_door_texturemapping, blockModels.modelOutput), ModelTemplates.DOOR_TOP_RIGHT_OPEN.extend().renderType("minecraft:cutout").build().create(BISMUTH_DOOR, bismuth_door_texturemapping, blockModels.modelOutput)));
        Block BISMUTH_TRAPDOOR = ModBlocks.BISMUTH_TRAPDOOR.get();

        TextureMapping bismuth_trapdoor_texturemapping = TextureMapping.defaultTexture(BISMUTH_TRAPDOOR);
        ResourceLocation bismuthtrapdoorresourcelocation = ModelTemplates.ORIENTABLE_TRAPDOOR_TOP.extend().renderType("minecraft:cutout").build().create(BISMUTH_TRAPDOOR, bismuth_trapdoor_texturemapping, blockModels.modelOutput);
        ResourceLocation bismuthtrapdoorresourcelocation1 = ModelTemplates.ORIENTABLE_TRAPDOOR_BOTTOM.extend().renderType("minecraft:cutout").build().create(BISMUTH_TRAPDOOR, bismuth_trapdoor_texturemapping, blockModels.modelOutput);
        ResourceLocation bismuthtrapdoorresourcelocation2 = ModelTemplates.ORIENTABLE_TRAPDOOR_OPEN.extend().renderType("minecraft:cutout").build().create(BISMUTH_TRAPDOOR, bismuth_trapdoor_texturemapping, blockModels.modelOutput);
        blockModels.registerSimpleItemModel(BISMUTH_TRAPDOOR, bismuthtrapdoorresourcelocation1);
        blockModels.blockStateOutput.accept(createOrientableTrapdoor(BISMUTH_TRAPDOOR, bismuthtrapdoorresourcelocation, bismuthtrapdoorresourcelocation1, bismuthtrapdoorresourcelocation2));

    }





}
