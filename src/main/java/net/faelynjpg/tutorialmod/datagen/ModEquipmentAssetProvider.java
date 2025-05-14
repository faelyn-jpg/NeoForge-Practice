package net.faelynjpg.tutorialmod.datagen;

import net.faelynjpg.tutorialmod.item.custom.ModEquipmentAssets;
import net.minecraft.client.data.models.EquipmentAssetProvider;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.equipment.EquipmentAsset;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;

public class ModEquipmentAssetProvider extends EquipmentAssetProvider {
    public ModEquipmentAssetProvider(PackOutput output) {
        super(output);
    }


    protected void registerModels(@NotNull BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> output) {
        super.registerModels(output);
        EquipmentClientInfo.Builder builder = EquipmentClientInfo.builder();
        ResourceLocation bismuthID = ResourceLocation.fromNamespaceAndPath("tutorialmod", "bismuth");

        builder.addHumanoidLayers(bismuthID);

        output.accept(ModEquipmentAssets.BISMUTH, builder.build());



    }
}
