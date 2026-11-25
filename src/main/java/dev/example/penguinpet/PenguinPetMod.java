package dev.example.penguinpet;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class PenguinPetMod implements ModInitializer {
    public static final String MOD_ID = "penguinpet";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Penguin Pet Mod initialized. Waddle responsibly!");
    }
}
