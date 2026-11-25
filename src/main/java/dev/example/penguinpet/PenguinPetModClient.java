package dev.example.penguinpet;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.PigEntityRenderer;

public final class PenguinPetModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Placeholder renderer (vanilla pig look) until the custom penguin model is added.
        // Spawn egg colours are now defined in assets/penguinpet/items/penguin_spawn_egg.json
        // (ColorProviderRegistry.ITEM no longer exists in 1.21.4+).
        EntityRendererRegistry.register(PenguinPetMod.PENGUIN, PigEntityRenderer::new);
    }
}
