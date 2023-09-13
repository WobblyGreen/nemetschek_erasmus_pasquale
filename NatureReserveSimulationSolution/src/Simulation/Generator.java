package Simulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

import Animals.Animal;
import Animals.AnimalSpecies;
import Animals.Carnivore;
import Animals.Herbivore;
import Animals.Omnivore;
import Interfaces.DietItem;
import Interfaces.Eatable;
import NonAnimal.*;
import animalSubClasses.*;

public class Generator {
	private ArrayList<AnimalSpecies> omnivores;
	private ArrayList<AnimalSpecies> carnivores;
	private ArrayList<AnimalSpecies> herbivores;
	
	public Generator() {
		this.carnivores= new ArrayList<>(Arrays.asList(AnimalSpecies.LION));
		this.herbivores=new ArrayList<>(Arrays.asList(AnimalSpecies.ZEBRA));
		
	};
	
	private Animal generateAnimal(AnimalSpecies animalSpecies) {
		Animal animal;
		
		final int MAX_ENERGY = (int)getRandom(10)+1;
		final ArrayList<DietItem> DIET = generateDiet(animalSpecies);
		final int SIZE = 1;
		
		if(carnivores.contains(animalSpecies)) {
			animal = new Carnivore(animalSpecies, MAX_ENERGY, SIZE, DIET);
		}
		else if(herbivores.contains(animalSpecies)) {
			animal = new Herbivore(animalSpecies, MAX_ENERGY, SIZE, DIET);
		}
		else {
			animal = new Omnivore(animalSpecies, MAX_ENERGY, SIZE, DIET);
		}
		return animal;
			
	}
	
	private ArrayList<DietItem> generateDiet(AnimalSpecies animalSpecies){
		ArrayList<DietItem> diet = new ArrayList<>();
		
		if(carnivores.contains(animalSpecies)) {
			diet.addAll(Arrays.asList(generateRandomAnimalSpecies(), generateRandomAnimalSpecies()));
		}
		else if(herbivores.contains(animalSpecies)) {
			diet.addAll(Arrays.asList(generateRandomVegeterianSpecies(), generateRandomVegeterianSpecies()));
		}
		else {
			diet.addAll(Arrays.asList(generateRandomVegeterianSpecies(), generateRandomAnimalSpecies()));
		}
		
		//removing duplicates
		LinkedHashSet<DietItem> lhs= new LinkedHashSet<>();
		lhs.addAll(diet);
		
		diet.clear();
		diet.addAll(lhs);
		
		return diet;
	}
	
	public double getRandom(int multiplier) {
		return Math.random()*multiplier;
	}
	
	public ArrayList<Animal> generateRandomAnimalArrayList(){
		ArrayList<Animal> animals = new ArrayList<>();
		
		animals.add(generateAnimal(AnimalSpecies.LION));
		animals.add(generateAnimal(AnimalSpecies.ZEBRA));
		
		return animals;
	}
	
	public ArrayList<Plants> generateRandomVeggieArrayList(){
		ArrayList<Plants> veggies = new ArrayList<>();
		int randomVeggiesLength = (int)getRandom(VegeterianSpecies.values().length+1);
		
		for(int i=0; i<randomVeggiesLength; i++) {
			veggies.add(generateVegeterianFood(generateRandomVegeterianSpecies()));
		}
		return veggies;
	}
	
	private Plants generateVegeterianFood(VegeterianSpecies vs) {
		return (new Plants(vs, (int)getRandom(5)+1, 1));
	}
	
	public Eatable generateRandomFood() {
		return (getRandom(1)>0.5 ? generateAnimal(generateRandomAnimalSpecies()) : generateVegeterianFood(generateRandomVegeterianSpecies()));
	}
	
	public DietItem generateRandomDietItem() {
		return (getRandom(1)>0.5 ? generateRandomAnimalSpecies() : generateRandomVegeterianSpecies());
	}
	
	private AnimalSpecies generateRandomAnimalSpecies() {
		return AnimalSpecies.values()[(int)getRandom(AnimalSpecies.values().length)];
	}
	
	private VegeterianSpecies generateRandomVegeterianSpecies() {
		return VegeterianSpecies.values()[(int)getRandom(VegeterianSpecies.values().length)];
	}
}
