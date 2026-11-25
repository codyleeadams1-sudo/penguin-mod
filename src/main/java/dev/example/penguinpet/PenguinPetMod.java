package dev.example.penguinpet;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
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

    public static final Identifier PENGUIN_EGG_ID = Identifier.of(MOD_ID, "penguin_spawn_egg");
    public static final RegistryKey<Item> PENGUIN_EGG_KEY =
            RegistryKey.of(RegistryKeys.ITEM, PENGUIN_EGG_ID);

    // 1.21.2+: every Item.Settings MUST have its registry key set before the Item is constructed,
    // otherwise the game crashes during startup with "Item id not set".
    // 1.21.5+: spawn eggs get their entity type from Settings#spawnEgg, not by overriding methods.
    public static final Item PENGUIN_EGG = Registry.register(
            Registries.ITEM,
            PENGUIN_EGG_KEY,
            new SpawnEggItem(new Item.Settings()
                    .registryKey(PENGUIN_EGG_KEY)
                    .spawnEgg(PENGUIN))
    );

    @Override
    public void onInitialize() {
        // Without default attributes the game crashes the moment a penguin is created/spawned.
        FabricDefaultAttributeRegistry.register(PENGUIN, PigEntity.createPigAttributes());

        FabricItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS)
                .register(entries -> entries.add(PENGUIN_EGG));
        LOGGER.info("Penguin entity and Penguin Egg registered!");
    }
}
