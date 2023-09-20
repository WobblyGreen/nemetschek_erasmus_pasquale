package simulation;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Iterator;

import animalSubClasses.*;
import animals.Animal;
import animals.AnimalFactory;
import biomes.Biome;
import biomes.BiomeFactory;
import food.Food;
import nonAnimal.Plant;
import nonAnimal.PlantFactory;
import nonAnimalSubClasses.*;

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
	
	public Animal generateRandomAnimal(ArrayList<String> supportedAnimals) {
		String animalName=supportedAnimals.get((int)getRandom(supportedAnimals.size()));
		return animalFactory.createAnimal(animalName);
	}
	
	public ArrayList<Animal> generateRandomAnimals(int num_of_animals_to_generate, ArrayList<String> supportedAnimals){
		ArrayList<Animal> randomAnimals = new ArrayList<Animal>();
		
		for (int i = 0; i < num_of_animals_to_generate; i++) {
			randomAnimals.add(generateRandomAnimal(supportedAnimals));
		}
		return randomAnimals;
	}
	
	public Plant generateRandomPlant(ArrayList<String> supportedPlants){
		String plantName=supportedPlants.get((int)getRandom(supportedPlants.size()));
		return plantFactory.createPlant(plantName);
	}
	
	public ArrayList<Plant> generateRandomPlants(int num_of_plants_to_generate, ArrayList<String> supportedPlants){
		ArrayList<Plant> randomPlants = new ArrayList<>();
		
		for (int i = 0; i < num_of_plants_to_generate; i++) {
			randomPlants.add(generateRandomPlant(supportedPlants));
		}
		
		return randomPlants;
	}
	
	public Food generateRandomFood(ArrayList<String> supportedAnimals, ArrayList<String> supportedPlants) {
		return (Math.random()>0.5 ? generateRandomAnimal(supportedAnimals) : generateRandomPlant(supportedPlants));
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
				biome.inhabitBiome(generateRandomAnimals(3, biome.getSupportedAnimals()), generateRandomPlants(2, biome.getSupportedPlants()));
				world[i][j]=biome;
			}
		}
		
		return world;
	}
}