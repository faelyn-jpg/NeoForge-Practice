package net.faelynjpg.tutorialmod.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.FuelValues;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FuelItem  extends Item {
    private int burnTime = 0;

    public FuelItem(Properties properties, int burnTime) {
        super(properties);
        this.burnTime = burnTime;
    }

    @Override
    public int getBurnTime(@NotNull ItemStack itemStack,
                           @Nullable RecipeType<?> recipeType,
                           @NotNull FuelValues fuelValues) {
        return this.burnTime;
    }
}
