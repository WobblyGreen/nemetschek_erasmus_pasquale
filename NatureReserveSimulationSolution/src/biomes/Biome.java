package biomes;

import java.util.ArrayList;

import animals.Animal;
import food.Food;
import nonAnimal.Plant;

public abstract class Biome {
	protected String name;
	protected double maxSizeCapacity;
	
	protected ArrayList<String> supportedAnimals;
	protected ArrayList<String> supportedPlants;
	
	protected ArrayList<Animal> currentLivingAnimals;
	protected ArrayList<Plant> currentLivingPlants;
	protected ArrayList<Food> allEatableItems;
	
	protected int x;
	protected int y;

	public Biome(String name, double maxSizeCapacity, ArrayList<String> supportedAnimals,
			ArrayList<String> supportedPlants, int x, int y) {
		this.name = name;
		this.maxSizeCapacity = maxSizeCapacity;
		this.supportedAnimals = supportedAnimals;
		this.supportedPlants = supportedPlants;
		this.x = x;
		this.y = y;
	}
	
	public void inhabitBiome(ArrayList<Animal> currentLivingAnimals, ArrayList<Plant> currentLivingPlants) {
		this.currentLivingAnimals=currentLivingAnimals;
		this.currentLivingPlants=currentLivingPlants;
		
		allEatableItems=new ArrayList<Food>();
		allEatableItems.addAll(currentLivingAnimals);
		allEatableItems.addAll(currentLivingPlants);
	}
	
	public void addAnimal(Animal animal) {
		this.currentLivingAnimals.add(animal);
		this.allEatableItems.add(animal);
	}
	
	public void removeAnimal(Animal animal) {
		this.currentLivingAnimals.remove(animal);
		this.allEatableItems.remove(animal);
	}
	
	public void regrowPlants() {
		for(Plant plant:currentLivingPlants) {
			plant.changeEnergy(plant.getCurrentEnergy() + (int)(Math.random()*(plant.getMaxEnergy()-plant.getCurrentEnergy())+1));
		}
	}

	public ArrayList<String> getSupportedAnimals() {
		return supportedAnimals;
	}

	public ArrayList<String> getSupportedPlants() {
		return supportedPlants;
	}

	public String getName() {
		return name;
	}

	public double getMaxSizeCapacity() {
		return maxSizeCapacity;
	}

	public ArrayList<Animal> getCurrentLivingAnimals() {
		return currentLivingAnimals;
	}

	public ArrayList<Plant> getCurrentLivingPlants() {
		return currentLivingPlants;
	}

	public ArrayList<Food> getAllEatableItems() {
		return allEatableItems;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	@Override
	public String toString() {
		return name.charAt(0)+"";
	}

	public String displayEnvironment() {
		return "("+x+";"+y+") "+name+" -> Animals:"+currentLivingAnimals+" <|> Plants:"+currentLivingPlants;
	}
}
