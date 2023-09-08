package Simulation;

import java.util.ArrayList;
import java.util.Arrays;

import Animals.Animal;
import Animals.AnimalSpecies;
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
	
	public ArrayList<Animal> generateRandomAnimals(){
		ArrayList<Animal> animals = new ArrayList<>();
		
		animals.add(generateAnimal(AnimalSpecies.LION));
		animals.add(generateAnimal(AnimalSpecies.ZEBRA));
		
		return animals;
	}
	
	private VegeterianFood generateVegeterian(VegeterianSpecies vs) {
		return (new VegeterianFood(vs, (int)getRandom(5), 1));
	}
	
	private Animal generateAnimal(AnimalSpecies as) {
		Animal a;
		
		if(carnivores.contains(as)) {
			a = new Carnivore(as, (int)getRandom(10), 1, generateDiet(as));
		}
		else if(herbivores.contains(as)) {
			a = new Herbivore(as, (int)getRandom(10), 1, generateDiet(as));
		}
		else if(omnivores.contains(as)) {
			a = new Omnivore(as, (int)getRandom(10), 1, generateDiet(as));
		}
		else {
			return null;
		}
		return a;
			
	}
	
	private ArrayList<DietItem> generateDiet(AnimalSpecies as){
		ArrayList<DietItem> diet = new ArrayList<>();
		
		if(carnivores.contains(as)) {
			diet.addAll(Arrays.asList(getRandomAnimalSpecies(), getRandomAnimalSpecies()));
		}
		else if(herbivores.contains(as)) {
			diet.addAll(Arrays.asList(getRandomVegeterianSpecies(), getRandomVegeterianSpecies()));
		}
		else if(omnivores.contains(as)) {
			diet.addAll(Arrays.asList(getRandomVegeterianSpecies(), getRandomAnimalSpecies()));
		}
		else {
			return null;
		}
		
		return diet;
	}
	
	private double getRandom(int multiplier) {
		return Math.random()*multiplier;
	}
	
	public Eatable getRandomFood() {
		boolean veggieOrAnimal = getRandom(1)>0.5;
		return (veggieOrAnimal ? generateAnimal(getRandomAnimalSpecies()) : generateVegeterian(getRandomVegeterianSpecies()));
	}
	
	private AnimalSpecies getRandomAnimalSpecies() {
		return AnimalSpecies.values()[(int)getRandom(AnimalSpecies.values().length)];
	}
	
	private VegeterianSpecies getRandomVegeterianSpecies() {
		return VegeterianSpecies.values()[(int)getRandom(VegeterianSpecies.values().length)];
	}
}
