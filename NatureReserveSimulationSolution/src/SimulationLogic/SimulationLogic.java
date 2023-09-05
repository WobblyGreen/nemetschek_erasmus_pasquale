package SimulationLogic;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

import Animals.Animal;
import Animals.AnimalSpecies;
import Food.Food;
import Food.FoodName;
import animalSubClasses.*;
import foodSubClasses.*;

public class SimulationLogic {
	
	private ArrayList<Animal> animals;
	private ArrayList<Food> foods;
	
	public SimulationLogic() {
		this.animals=generateAnimals();
	}
	
	public SimulationLogic(ArrayList<Animal> animals, ArrayList<Food> foods) {
		this.foods = foods;
		this.animals=animals;
	}
	
	public void simulate() {
		feedAllAnimals();
	}
	

	private ArrayList<Animal> generateAnimals(){
		ArrayList<Animal> animals = new ArrayList<Animal>();
		
		ArrayList<FoodName> ZebraFood = new ArrayList<>(Arrays.asList(FoodName.BANANA, FoodName.CALIFLOWER));
		
		ArrayList<FoodName> LionFood = new ArrayList<>(Arrays.asList(FoodName.LAMB, FoodName.CHICKEN));
		
		animals.add(new Zebra(20, ZebraFood));
		animals.add(new Lion(30, LionFood));
		
		return animals;
	}
	
	private void feedAllAnimals() {
		HashMap<Integer, Animal> animalsTurns = new HashMap<>();
		
		for(int turn=1; !areAllAnimalsDead(); turn++) {
			for(Animal animal : this.animals) {
				Food f = this.foods.get((int)(Math.random()*foods.size()));
				animal.feed(f);
				
				if(!animal.isAlive()) {
					if(!animalsTurns.containsValue(animal)) {
						animalsTurns.put(turn, animal);
					}
				}
			}
		}
		
		int minTurn = Collections.min(animalsTurns.keySet());
		int maxTurn = Collections.max(animalsTurns.keySet());
		
		System.out.println("\nLifespan statistics");
		System.out.println("- Minimum lived for " + minTurn +" turns"+ animalsTurns.get(minTurn));
		System.out.println("\n- Maximum lived for " + maxTurn +" turns"+ animalsTurns.get(maxTurn));
		System.out.println("\n- Average living of " + average(animalsTurns.keySet()) +" turns");
		
	}
	
	private int average(Set<Integer> nums) {
		int sum = 0;
		for(int n : nums) sum+=n;
		return sum/nums.size();
		
	}
	
	private boolean areAllAnimalsDead() {
		for(Animal a:this.animals) {
			if(a.isAlive()) return false;
		}
		return true;
	}

}
