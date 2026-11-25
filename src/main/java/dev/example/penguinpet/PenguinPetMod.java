package dev.example.penguinpet;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class PenguinPetMod implements ModInitializer {
    public static final String MOD_ID = "penguinpet";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final Identifier PENGUIN_ID = Identifier.of(MOD_ID, "penguin");
    public static final RegistryKey<EntityType<?>> PENGUIN_KEY =
            RegistryKey.of(RegistryKeys.ENTITY_TYPE, PENGUIN_ID);

    public static final EntityType<PenguinEntity> PENGUIN = Registry.register(
            Registries.ENTITY_TYPE,
            PENGUIN_ID,
            EntityType.Builder.create(PenguinEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.6f, 1.0f)
                    .build(PENGUIN_KEY)
    );

    public static final Item PENGUIN_EGG = Registry.register(
            Registries.ITEM,
            Identifier.of(MOD_ID, "penguin_spawn_egg"),
            new PenguinSpawnEggItem(new Item.Settings().maxCount(64))
    );

    @Override
    public void onInitialize() {
        FabricItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS)
                .register(entries -> entries.add(PENGUIN_EGG));
        LOGGER.info("Penguin entity and Penguin Egg registered!");
    }
}
