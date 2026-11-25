package dev.example.penguinpet;

import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

/** Penguin with top hat + suitcase. Texture: 64x64, box-UV. */
public class PenguinModel extends EntityModel<LivingEntityRenderState> {
    public static final EntityModelLayer LAYER =
            new EntityModelLayer(Identifier.of(PenguinPetMod.MOD_ID, "penguin"), "main");

    private final ModelPart waddle, head, flipperL, flipperR, footL, footR, suitcase;

    public PenguinModel(ModelPart root) {
        super(root);
        this.waddle = root.getChild("waddle");
        this.head = waddle.getChild("head");
        this.flipperL = waddle.getChild("flipper_l");
        this.flipperR = waddle.getChild("flipper_r");
        this.suitcase = waddle.getChild("suitcase");
        this.footL = root.getChild("foot_l");
        this.footR = root.getChild("foot_r");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData data = new ModelData();
        ModelPartData root = data.getRoot();

        // Everything that tilts when waddling hangs off this pivot (at the feet line, y=22).
        ModelPartData waddle = root.addChild("waddle", ModelPartBuilder.create(),
                ModelTransform.of(0f, 22f, 0f, 0f, 0f, 0f));

        waddle.addChild("body", ModelPartBuilder.create().uv(0, 0)
                .cuboid(-4f, -5f, -3f, 8f, 11f, 6f), ModelTransform.of(0f, -6f, 0f, 0f, 0f, 0f));

        ModelPartData head = waddle.addChild("head", ModelPartBuilder.create().uv(0, 18)
                .cuboid(-3f, -6f, -3f, 6f, 6f, 6f), ModelTransform.of(0f, -11f, 0f, 0f, 0f, 0f));
        head.addChild("beak", ModelPartBuilder.create().uv(30, 0)
                .cuboid(-1f, -3f, -5f, 2f, 1f, 2f), ModelTransform.of(0f, 0f, 0f, 0f, 0f, 0f));
        // Fancy top hat
        head.addChild("hat_brim", ModelPartBuilder.create().uv(0, 32)
                .cuboid(-4f, -7f, -4f, 8f, 1f, 8f), ModelTransform.of(0f, 0f, 0f, 0f, 0f, 0f));
        head.addChild("hat_crown", ModelPartBuilder.create().uv(0, 42)
                .cuboid(-3f, -12f, -3f, 6f, 5f, 6f), ModelTransform.of(0f, 0f, 0f, 0f, 0f, 0f));

        waddle.addChild("flipper_l", ModelPartBuilder.create().uv(40, 0)
                .cuboid(-1f, 0f, -2f, 1f, 7f, 4f), ModelTransform.of(-4f, -10f, 0f, 0f, 0f, 0f));
        waddle.addChild("flipper_r", ModelPartBuilder.create().uv(40, 0)
                .cuboid(0f, 0f, -2f, 1f, 7f, 4f), ModelTransform.of(4f, -10f, 0f, 0f, 0f, 0f));

        // Suitcase "backpack" (+Z is the penguin's back)
        ModelPartData suitcase = waddle.addChild("suitcase", ModelPartBuilder.create().uv(30, 20)
                .cuboid(-3f, -3f, 3f, 6f, 7f, 2f), ModelTransform.of(0f, -6f, 0f, 0f, 0f, 0f));
        suitcase.addChild("handle", ModelPartBuilder.create().uv(30, 30)
                .cuboid(-1f, -4f, 3f, 2f, 1f, 1f), ModelTransform.of(0f, 0f, 0f, 0f, 0f, 0f));

        root.addChild("foot_l", ModelPartBuilder.create().uv(30, 12)
                .cuboid(-2f, 0f, -3f, 3f, 2f, 5f), ModelTransform.of(-2f, 22f, 0f, 0f, 0f, 0f));
        root.addChild("foot_r", ModelPartBuilder.create().uv(30, 12)
                .cuboid(-1f, 0f, -3f, 3f, 2f, 5f), ModelTransform.of(2f, 22f, 0f, 0f, 0f, 0f));

        return TexturedModelData.of(data, 64, 64);
    }

    @Override
    public void setAngles(LivingEntityRenderState state) {
        super.setAngles(state);
        float swing = state.limbFrequency * 0.9f;
        float amp = Math.min(1.0f, state.limbAmplitudeMultiplier * 2.0f);

        // Goofy waddle: whole body rocks side to side, feet alternate, flippers flap
        waddle.roll = MathHelper.sin(swing) * 0.35f * amp;
        footL.pitch = MathHelper.sin(swing) * 0.8f * amp;
        footR.pitch = -MathHelper.sin(swing) * 0.8f * amp;
        flipperL.roll = -0.15f - Math.abs(MathHelper.cos(swing)) * 0.9f * amp;
        flipperR.roll = 0.15f + Math.abs(MathHelper.cos(swing)) * 0.9f * amp;

        // Idle: little head bob + flipper twitch, tilted head when standing
        head.roll = MathHelper.sin(state.age * 0.07f) * 0.12f;
        head.pitch = MathHelper.sin(state.age * 0.11f) * 0.06f;
        flipperL.roll += MathHelper.sin(state.age * 0.13f) * 0.05f;
        flipperR.roll -= MathHelper.sin(state.age * 0.13f) * 0.05f;
        suitcase.roll = -waddle.roll * 0.3f;
    }
}
