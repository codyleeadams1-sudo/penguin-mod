# Penguin Pet Mod (Fabric) — Minecraft 1.21.11

GitHub-ready Fabric mod project. Import this folder into a GitHub repository, then build with Java 21 and Gradle.

## Build
1. Install Java 21 (JDK).
2. Open this project in IntelliJ IDEA or use a terminal.
3. Run `./gradlew build` (Windows: `gradlew.bat build`).
4. The mod JAR will be in `build/libs/`.

## Dependencies
- Fabric Loader and Fabric API
- Client: Entity Texture Features (ETF) and Entity Model Features (EMF), both for Minecraft 1.21.11.
  EMF depends on ETF. They are client-side enhancements; don't require them on a dedicated server.

## Current project status
This repository is a starter implementation, not yet the full feature-complete mod requested. It includes the mod entrypoint, metadata, Gradle setup, and a GitHub Actions build workflow. The complete penguin entity, custom GUI/inventory, combat, AI, models, textures, animations, and sounds still need to be implemented and tested against the exact 1.21.11 Fabric API.

## GitHub
Create a new repository, extract this ZIP, then commit and push the contents of this folder (not the ZIP itself).
