# Natural Reserve Simulation

## Description
This project simulates a natural environment where animals can move in a map made of biomes and eat the food that is present in that biome. Animals can die due to hunger or because they get eaten.<br>
The simulation ends once all animals die.

## Features
- **Biome Map**: The map is composed of various biomes, each with its unique characteristics.
- **Animals**: Animals can freely move around the map and interact with the environment.
- **Food**: Each biome has a specific type of food that animals can eat.
- **Life Cycle**: Animals can die of hunger if they don't find food or can be eaten by other animals.

## Bugs
-**Infinite Simulation**: It may happen that an animal stays alive forever if gets its food frequently
-**Index out of bound**: Sometimes the simulation stops with index out bound exception, but it rarely happens
