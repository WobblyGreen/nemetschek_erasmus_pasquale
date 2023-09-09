package Simulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

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
	
	private Animal generateAnimal(AnimalSpecies as) {
		Animal a;
		
		final int MAX_ENERGY = (int)getRandom(10)+1;
		final ArrayList<DietItem> DIET = generateDiet(as);
		final int SIZE = 1;
		
		if(carnivores.contains(as)) {
			a = new Carnivore(as, MAX_ENERGY, SIZE, DIET);
		}
		else if(herbivores.contains(as)) {
			a = new Herbivore(as, MAX_ENERGY, SIZE, DIET);
		}
		else if(omnivores.contains(as)) {
			a = new Omnivore(as, MAX_ENERGY, SIZE, DIET);
		}
		else {
			return null;
		}
		return a;
			
	}
	
	private ArrayList<DietItem> generateDiet(AnimalSpecies as){
		ArrayList<DietItem> diet = new ArrayList<>();
		
		if(carnivores.contains(as)) {
			diet.addAll(Arrays.asList(generateRandomAnimalSpecies(), generateRandomAnimalSpecies()));
		}
		else if(herbivores.contains(as)) {
			diet.addAll(Arrays.asList(generateRandomVegeterianSpecies(), generateRandomVegeterianSpecies()));
		}
		else if(omnivores.contains(as)) {
			diet.addAll(Arrays.asList(generateRandomVegeterianSpecies(), generateRandomAnimalSpecies()));
		}
		else {
			return null;
		}
		
		//removing duplicates
		LinkedHashSet<DietItem> lhs= new LinkedHashSet<>();
		lhs.addAll(diet);
		
		diet.clear();
		diet.addAll(lhs);
		
		return diet;
	}
	
	private double getRandom(int multiplier) {
		return Math.random()*multiplier;
	}
	
	public ArrayList<Animal> generateRandomAnimalArrayList(){
		ArrayList<Animal> animals = new ArrayList<>();
		
		animals.add(generateAnimal(AnimalSpecies.LION));
		animals.add(generateAnimal(AnimalSpecies.ZEBRA));
		
		return animals;
	}
	
	private VegeterianFood generateVegeterianFood(VegeterianSpecies vs) {
		return (new VegeterianFood(vs, (int)getRandom(5), 1));
	}
	
	public DietItem generateDietItem() {
		boolean veggieOrAnimal = getRandom(1)>0.5;
		DietItem di;
		if(veggieOrAnimal) {
			di=AnimalSpecies.values()[(int)getRandom(AnimalSpecies.values().length)];
		}
		else {
			di=VegeterianSpecies.values()[(int)getRandom(VegeterianSpecies.values().length)];
		}
		
		return di;
	}
	
	
	public Eatable generateRandomFood() {
		boolean veggieOrAnimal = getRandom(1)>0.5;
		return (veggieOrAnimal ? generateAnimal(generateRandomAnimalSpecies()) : generateVegeterianFood(generateRandomVegeterianSpecies()));
	}
	
	private AnimalSpecies generateRandomAnimalSpecies() {
		return AnimalSpecies.values()[(int)getRandom(AnimalSpecies.values().length)];
	}
	
	private VegeterianSpecies generateRandomVegeterianSpecies() {
		return VegeterianSpecies.values()[(int)getRandom(VegeterianSpecies.values().length)];
	}
}
