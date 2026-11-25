package dev.example.penguinpet;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.world.World;

/**
 * Temporary visible placeholder for the planned custom penguin model.
 * Uses PigEntity's vanilla renderer so the registered entity is visible in-game.
 */
public class PenguinEntity extends PigEntity {
    public PenguinEntity(EntityType<? extends PigEntity> entityType, World world) {
        super(entityType, world);
    }
}
