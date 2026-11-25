package dev.example.penguinpet;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.util.Identifier;

public class PenguinRenderer extends MobEntityRenderer<PenguinEntity, LivingEntityRenderState, PenguinModel> {
    private static final Identifier TEXTURE =
            Identifier.of(PenguinPetMod.MOD_ID, "textures/entity/penguin.png");

    public PenguinRenderer(EntityRendererFactory.Context context) {
        super(context, new PenguinModel(context.getPart(PenguinModel.LAYER)), 0.5f);
    }

    @Override
    public LivingEntityRenderState createRenderState() {
        return new LivingEntityRenderState();
    }

    @Override
    public Identifier getTexture(LivingEntityRenderState state) {
        return TEXTURE;
    }
}
