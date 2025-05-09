package net.faelynjpg.tutorialmod.datagen;

import net.faelynjpg.tutorialmod.block.ModBlocks;
import net.faelynjpg.tutorialmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModLanguageProvider extends LanguageProvider {
    public ModLanguageProvider(PackOutput output) {
        super(output, "tutorialmod", "en_us");
    }

    @Override
    protected void addTranslations() {
        this.addBlock(ModBlocks.BISMUTH_BLOCK, "Bismuth Block");
        this.addBlock(ModBlocks.BISMUTH_ORE, "Bismuth Ore");
        this.addBlock(ModBlocks.MAGIC_BLOCK, "Magic Block");
        this.addBlock(ModBlocks.BISMUTH_STAIRS, "Bismuth Stairs");
        this.addBlock(ModBlocks.BISMUTH_SLAB, "Bismuth Slab");
        this.addBlock(ModBlocks.BISMUTH_DEEPSLATE_ORE, "Bismuth Deepslate Ore");
        this.addBlock(ModBlocks.BISMUTH_BUTTON, "Bismuth Button");
        this.addBlock(ModBlocks.BISMUTH_PRESSURE_PLATE, "Bismuth Pressure Plate");
        this.addBlock(ModBlocks.BISMUTH_FENCE, "Bismuth Fence");
        this.addBlock(ModBlocks.BISMUTH_FENCE_GATE, "Bismuth Fence Gate");
        this.addBlock(ModBlocks.BISMUTH_WALL, "Bismuth Wall" );
        this.addBlock(ModBlocks.BISMUTH_DOOR, "Bismuth Door");
        this.addBlock(ModBlocks.BISMUTH_TRAPDOOR, "Bismuth Trapdoor");
        this.addBlock(ModBlocks.BISMUTH_LAMP, "Bismuth Lamp");
        this.addItem(ModItems.BISMUTH_SWORD, "Bismuth Sword");
        this.addItem(ModItems.BISMUTH_PICKAXE, "Bismuth Pickaxe");
        this.addItem(ModItems.BISMUTH_AXE, "Bismuth Axe");
        this.addItem(ModItems.BISMUTH_SHOVEL, "Bismuth Shovel");
        this.addItem(ModItems.BISMUTH_HOE, "Bismuth Hoe");

        this.addItem(ModItems.BISMUTH, "Bismuth");
        this.addItem(ModItems.RAW_BISMUTH, "Raw Bismuth");
        this.addItem(ModItems.CHISEL, "Chisel");
        this.addItem(ModItems.RADISH, "Radish");
        this.addItem(ModItems.FROSTFIRE_ICE, "Frostfire Ice");
        this.addItem(ModItems.STARLIGHT_ASHES, "Starlight Ashes");
        add("tooltip.tutorialmod.magic_block.tooltip", "This block is very §9magical!§r");
        add("tooltip.tutorialmod.chisel.shift_down","This item can chisel Blocks into Bricks");
        add("tooltip.tutorialmod.chisel","Press §eShift§r for more information");
        add("tooltip.tutorialmod.radish.tooltip","Tastes really great!");
        add("creativetab.tutorialmod.bismuth_items","Bismuth Items");
        add("creativetab.tutorialmod.bismuth_blocks","Bismuth Blocks");


    }
}
