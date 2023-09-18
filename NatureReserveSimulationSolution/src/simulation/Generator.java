package simulation;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Iterator;

import animalSubClasses.*;
import animals.Animal;
import animals.AnimalFactory;
import food.Food;
import nonAnimal.Plant;
import nonAnimal.PlantFactory;
import nonAnimalSubClasses.*;

public class Generator {
	private AnimalFactory animalFactory;
	private PlantFactory plantFactory; 
	
	public Generator(AnimalFactory animalFactory, PlantFactory plantsFactory) {
		this.animalFactory=animalFactory;
		this.plantFactory=plantsFactory;
	};
	
	public double getRandom(int multiplier) {
		return Math.random()*multiplier;
	}
	
	public Animal generateRandomAnimal() {
		String animalName=animalFactory.getAnimalKey((int)getRandom(animalFactory.getAnimalLength()));
		return animalFactory.createAnimal(animalName);
	}
	
	public ArrayList<Animal> generateRandomAnimals(){
		ArrayList<Animal> randomAnimals = new ArrayList<Animal>();
		
		for (int i = 0; i < 3; i++) {
			randomAnimals.add(generateRandomAnimal());
		}
		return randomAnimals;
	}
	
	public Plant generateRandomPlant(){
		String plantName=plantFactory.getPlantKey((int)getRandom(plantFactory.getPlantLength()));
		return plantFactory.createPlant(plantName);
	}
	
	public ArrayList<Plant> generateRandomPlants(){
		ArrayList<Plant> randomPlants = new ArrayList<>();
		
		for (int i = 0; i < 2; i++) {
			randomPlants.add(generateRandomPlant());
		}
		
		return randomPlants;
	}
	
	public Food generateRandomFood() {
		return (Math.random()>0.5 ? generateRandomAnimal() : generateRandomPlant());
	}
}
