package dev.example.penguinpet;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public final class PenguinPetModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(PenguinModel.LAYER, PenguinModel::getTexturedModelData);
        EntityRendererRegistry.register(PenguinPetMod.PENGUIN, PenguinRenderer::new);
    }
}
