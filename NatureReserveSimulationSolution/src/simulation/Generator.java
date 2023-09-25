package simulation;

import java.util.ArrayList;

import food.animals.Animal;
import food.animals.AnimalFactory;

import food.nonAnimals.Plant;
import food.nonAnimals.PlantFactory;

import biomes.BiomeFactory;
import biomes.Biome;
import food.Food;

public class Generator {
	private AnimalFactory animalFactory;
	private PlantFactory plantFactory; 
	private BiomeFactory biomeFactory;
	
	public Generator(AnimalFactory animalFactory, PlantFactory plantsFactory, BiomeFactory biomeFactory) {
		this.animalFactory=animalFactory;
		this.plantFactory=plantsFactory;
		this.biomeFactory=biomeFactory;
	};
	
	public double getRandom(int multiplier) {
		return Math.random()*multiplier;
	}
	
	public Animal generateRandomAnimal(ArrayList<String> supportedAnimals, int x, int y) {
		String animalName=supportedAnimals.get((int)getRandom(supportedAnimals.size()));
		return animalFactory.createAnimal(animalName, x, y);
	}
	
	public ArrayList<Animal> generateRandomAnimals(int num_of_animals_to_generate, ArrayList<String> supportedAnimals, int x, int y){
		ArrayList<Animal> randomAnimals = new ArrayList<Animal>();
		
		for (int i = 0; i < num_of_animals_to_generate; i++) {
			randomAnimals.add(generateRandomAnimal(supportedAnimals, x, y));
		}
		return randomAnimals;
	}
	
	public Plant generateRandomPlant(ArrayList<String> supportedPlants, int x, int y){
		String plantName=supportedPlants.get((int)getRandom(supportedPlants.size()));
		return plantFactory.createPlant(plantName, x, y);
	}
	
	public ArrayList<Plant> generateRandomPlants(int num_of_plants_to_generate, ArrayList<String> supportedPlants, int x, int y){
		ArrayList<Plant> randomPlants = new ArrayList<>();
		
		for (int i = 0; i < num_of_plants_to_generate; i++) {
			randomPlants.add(generateRandomPlant(supportedPlants, x, y));
		}
		
		return randomPlants;
	}
	
	public Food generateRandomFood(ArrayList<String> supportedAnimals, ArrayList<String> supportedPlants, int x, int y) {
		return (Math.random()>0.5 ? generateRandomAnimal(supportedAnimals, x, y) : generateRandomPlant(supportedPlants, x, y));
	}
	
	public Biome generateRandomBiome(int x, int y) {
		String biomeName=biomeFactory.getBiomeKey((int)getRandom(biomeFactory.getBiomeLength()));
		return biomeFactory.createBiome(biomeName, x, y);
	}
	
	public Biome[][] generateWorld(int num_of_rows, int num_of_cols) {
		Biome[][] world = new Biome[num_of_rows][num_of_cols];
		for(int i=0; i<num_of_rows; i++) {
			for(int j=0; j<num_of_cols; j++) {
				Biome biome = generateRandomBiome(j, i);
				ArrayList<Animal> animals = generateRandomAnimals((int)(biome.getMaxCapacity()*Math.random()), biome.getSupportedAnimals(), j, i);
				ArrayList<Plant> plants = generateRandomPlants((int)(biome.getMaxCapacity()*Math.random()), biome.getSupportedPlants(), j, i);
				
				biome.inhabitBiome(animals, plants);
				world[i][j]=biome;
			}
		}
		
		return world;
	}
}