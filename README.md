# Penguin Pet Mod

Fabric / Minecraft Java **1.21.11**, Java 21. Works alongside Entity Texture Features / Entity Model Features (optional).

## Build
- GitHub: push this folder to a repo -> Actions tab -> "Build Penguin Pet Mod" -> download the artifact.
- Local: install Gradle 9.2+ and run `gradle build`. Jar is in `build/libs/` (use the one WITHOUT `-sources`).
- Requires Fabric Loader 0.18.1+ and Fabric API for 1.21.11 in your mods folder.

## Test in-game
- `/summon penguinpet:penguin`
- `/give @s penguinpet:penguin_spawn_egg`
- Creative inventory -> Spawn Eggs tab -> **Penguin Egg**

## Status
Custom penguin model (top hat + suitcase, waddle animation) and egg texture. Wanders, looks at players, flees danger.
Taming, inventory GUI, babies and natural spawning are not implemented yet.

## v0.1.2 boot-crash fixes
- Item.Settings now has its registry key (1.21.2+ requirement) -> fixes crash on startup.
- Client entrypoint moved into the compiled source set (it was never packaged before).
- Default entity attributes registered (fixes crash when spawning).
- Spawn egg uses `Settings#spawnEgg`; colours moved to the item definition JSON (1.21.4+).
