package net.faelynjpg.tutorialmod.item;

import net.faelynjpg.tutorialmod.TutorialMod;
import net.faelynjpg.tutorialmod.item.custom.*;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.minecraft.world.item.equipment.ArmorType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TutorialMod.MOD_ID);

    public static final DeferredItem<Item> BISMUTH = ITEMS.registerItem("bismuth", Item::new, new Item.Properties());
    public static final DeferredItem<Item> RAW_BISMUTH = ITEMS.registerItem("raw_bismuth", Item::new, new Item.Properties());

    public static final DeferredItem<Item> CHISEL = ITEMS.registerItem("chisel", ChiselItem::new, new Item.Properties().durability(32));

    public static final DeferredItem<Item> RADISH = ITEMS.registerItem("radish",
            (props) -> new Item(props) {
                @Override
                public void appendHoverText(@NotNull ItemStack stack,
                                            @NotNull TooltipContext context,
                                            @NotNull List<Component> tooltipComponents,
                                            @NotNull TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.tutorialmod.radish.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            },
            new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "radish")))
                    .food(ModFoodProperties.RADISH)
                    .component(
                            DataComponents.CONSUMABLE,
                            Consumable.builder()
                                    .consumeSeconds(2f)
                                    .animation(ItemUseAnimation.EAT)
                                    .hasConsumeParticles(false)
                                    .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 600), 0.35f))
                                    .build()
                    ));

    public static final DeferredItem<Item> FROSTFIRE_ICE = ITEMS.registerItem("frostfire_ice", (props) -> new FuelItem(props, 200), new Item.Properties()
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "frostfire_ice")))
    );

    public static final DeferredItem<Item> STARLIGHT_ASHES = ITEMS.registerItem("starlight_ashes", Item::new, new Item.Properties());

    public static final DeferredItem<SwordItem> BISMUTH_SWORD = ITEMS.registerItem("bismuth_sword", (props) ->
            new SwordItem(ModToolMaterials.BISMUTH, 5f, -2.4f, new Item.Properties()
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "bismuth_sword"))) ));

    public static final DeferredItem<PickaxeItem> BISMUTH_PICKAXE = ITEMS.registerItem("bismuth_pickaxe", (props) ->
            new PickaxeItem(ModToolMaterials.BISMUTH, 1.0f, -2.8f, new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "bismuth_pickaxe"))) ));

    public static final DeferredItem<ShovelItem> BISMUTH_SHOVEL = ITEMS.registerItem("bismuth_shovel", (props) ->
            new ShovelItem(ModToolMaterials.BISMUTH, 1.5f, -3.0f, new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "bismuth_shovel"))) ));
    public static final DeferredItem<AxeItem> BISMUTH_AXE = ITEMS.registerItem("bismuth_axe", (props) ->
            new AxeItem(ModToolMaterials.BISMUTH, 6f, -3.2f, new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "bismuth_axe"))) ));
    public static final DeferredItem<HoeItem> BISMUTH_HOE = ITEMS.registerItem("bismuth_hoe", (props) ->
            new HoeItem(ModToolMaterials.BISMUTH, 0f, -3.2f, new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "bismuth_hoe"))) ));
    public static final DeferredItem<HammerItem> BISMUTH_HAMMER = ITEMS.registerItem("bismuth_hammer", (props) ->
            new HammerItem(ModToolMaterials.BISMUTH, 7f, -3.5f, new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "bismuth_hammer"))) ));

    public static final DeferredItem<ArmorItem> BISMUTH_HELMET = ITEMS.registerItem("bismuth_helmet", (props) ->
            new ModArmorItem(ModArmorMaterials.BISMUTH_ARMOR_MATERIAL, ArmorType.HELMET, new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "bismuth_helmet")))
                    .durability(ArmorType.HELMET.getDurability(19))));

    public static final DeferredItem<ArmorItem> BISMUTH_CHESTPLATE = ITEMS.registerItem("bismuth_chestplate", (props) ->
            new ModArmorItem(ModArmorMaterials.BISMUTH_ARMOR_MATERIAL, ArmorType.CHESTPLATE, new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "bismuth_chestplate")))
                    .durability(ArmorType.CHESTPLATE.getDurability(19))));

    public static final DeferredItem<ArmorItem> BISMUTH_LEGGINGS = ITEMS.registerItem("bismuth_leggings", (props) ->
            new ModArmorItem(ModArmorMaterials.BISMUTH_ARMOR_MATERIAL, ArmorType.LEGGINGS, new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "bismuth_leggings")))
                    .durability(ArmorType.LEGGINGS.getDurability(19))));


    public static final DeferredItem<ArmorItem> BISMUTH_BOOTS = ITEMS.registerItem("bismuth_boots", (props) ->
            new ModArmorItem(ModArmorMaterials.BISMUTH_ARMOR_MATERIAL, ArmorType.BOOTS, new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "bismuth_boots")))
                    .durability(ArmorType.BOOTS.getDurability(19))));


    public static final DeferredItem<Item> BISMUTH_HORSE_ARMOR = ITEMS.registerItem("bismuth_horse_armor", props -> new AnimalArmorItem(ModArmorMaterials.BISMUTH_ARMOR_MATERIAL, AnimalArmorItem.BodyType.EQUESTRIAN,  props
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "bismuth_horse_armor")))
            .stacksTo(1)));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
