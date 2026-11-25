# Penguin Pet Mod — summonable entity + Penguin Egg

Fabric / Minecraft Java 1.21.11, Java 21.

## Build
Run `gradle build` or import into IntelliJ IDEA. Output: `build/libs/`.

## Test in-game
- `/summon penguinpet:penguin`
- Search Creative inventory for **Penguin Egg** (black/white spawn egg).
- Or `/give @s penguinpet:penguin_spawn_egg`

## Important
This update registers the custom `penguinpet:penguin` entity and egg. To keep this focused on the spawn issue, the entity currently uses Minecraft's vanilla pig entity/rendering as a visible placeholder. It is summonable and the egg spawns it, but it is NOT yet the custom penguin model/AI/pet feature set. The egg has black/white tint colors and is added to the Spawn Eggs creative tab.
