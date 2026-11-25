package dev.example.penguinpet;

import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;

public final class PenguinSpawnEggItem extends SpawnEggItem {
    public PenguinSpawnEggItem(Settings settings) {
        super(settings);
    }

    @Override
    public EntityType<?> getEntityType(ItemStack stack) {
        return PenguinPetMod.PENGUIN;
    }

    @Override
    public boolean isOfSameEntityType(ItemStack stack, EntityType<?> type) {
        return type == PenguinPetMod.PENGUIN;
    }
}
