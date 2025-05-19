package net.faelynjpg.tutorialmod.datagen.models;

import net.faelynjpg.tutorialmod.item.ModItems;
import net.faelynjpg.tutorialmod.item.custom.ModEquipmentAssets;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.model.*;
import net.minecraft.resources.ResourceLocation;
import java.util.function.BiConsumer;

public class ModItemModelGenerator extends ItemModelGenerators {


    public ModItemModelGenerator(ItemModelOutput itemModelOutput, BiConsumer<ResourceLocation, ModelInstance> modelOutput) {
        super(itemModelOutput, modelOutput);
    }

    public void run(){
        generateFlatItem(ModItems.BISMUTH.get(), ModelTemplates.FLAT_ITEM);
        generateFlatItem(ModItems.RAW_BISMUTH.get(), ModelTemplates.FLAT_ITEM);

        generateFlatItem(ModItems.RADISH.get(), ModelTemplates.FLAT_ITEM);
        generateFlatItem(ModItems.STARLIGHT_ASHES.get(), ModelTemplates.FLAT_ITEM);
        generateFlatItem(ModItems.FROSTFIRE_ICE.get(), ModelTemplates.FLAT_ITEM);
        generateFlatItem(ModItems.CHISEL.get(), ModelTemplates.FLAT_ITEM);
        generateFlatItem(ModItems.BISMUTH_SWORD.get() , ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(ModItems.BISMUTH_PICKAXE.get() , ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(ModItems.BISMUTH_AXE.get() , ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(ModItems.BISMUTH_SHOVEL.get() , ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(ModItems.BISMUTH_HOE.get() , ModelTemplates.FLAT_HANDHELD_ITEM);
        generateFlatItem(ModItems.BISMUTH_HAMMER.get() , ModelTemplates.FLAT_HANDHELD_ITEM);

        generateTrimmableItem(ModItems.BISMUTH_HELMET.get(), ModEquipmentAssets.BISMUTH, "helmet", false);
        generateTrimmableItem(ModItems.BISMUTH_CHESTPLATE.get(), ModEquipmentAssets.BISMUTH, "chestplate", false);
        generateTrimmableItem(ModItems.BISMUTH_LEGGINGS.get(), ModEquipmentAssets.BISMUTH, "leggings", false);
        generateTrimmableItem(ModItems.BISMUTH_BOOTS.get(), ModEquipmentAssets.BISMUTH, "boots", false);

        generateFlatItem(ModItems.BISMUTH_HORSE_ARMOR.get(), ModelTemplates.FLAT_ITEM);
        generateFlatItem(ModItems.KAUPEN_SMITHING_TEMPLATE.get(), ModelTemplates.FLAT_ITEM);

    }

}
