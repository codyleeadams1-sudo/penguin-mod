package dev.example.penguinpet;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.PigEntityRenderer;

public final class PenguinPetModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(PenguinPetMod.PENGUIN, PigEntityRenderer::new);

        // Spawn egg layer 0 = base, layer 1 = spots.
        ColorProviderRegistry.ITEM.register(
                (stack, tintIndex) -> tintIndex == 0 ? 0x171717 : 0xF4F4F4,
                PenguinPetMod.PENGUIN_EGG
        );
    }
}
