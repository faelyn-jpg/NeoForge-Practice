package net.faelynjpg.tutorialmod.trim;

import net.faelynjpg.tutorialmod.TutorialMod;
import net.faelynjpg.tutorialmod.item.ModItems;
import net.minecraft.Util;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.trim.TrimPattern;
import net.minecraft.world.item.equipment.trim.TrimPatterns;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModTrimPatterns extends TrimPatterns {
    public static final ResourceKey<TrimPattern> KAUPEN = ResourceKey.create(Registries.TRIM_PATTERN,
            ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "kaupen"));

    public static void bootstrap(BootstrapContext<TrimPattern> context) {
        register(context, ModItems.KAUPEN_SMITHING_TEMPLATE.get(), KAUPEN);
    }

    public static void register(BootstrapContext<TrimPattern> context, Item item, ResourceKey<TrimPattern> key) { TrimPattern trimpattern = new TrimPattern(
            key.location(),
            BuiltInRegistries.ITEM.wrapAsHolder(item),
            Component.translatable(Util.makeDescriptionId("trim_pattern", key.location())),
            false
    );
        context.register(key, trimpattern);
    }
}
