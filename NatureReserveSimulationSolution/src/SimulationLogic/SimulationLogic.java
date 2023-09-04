package SimulationLogic;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

import Animals.Animal;
import Food.Food;

import animalSubClasses.*;
import foodSubClasses.*;

public class SimulationLogic {
	
	private ArrayList<Animal> animals;
	private ArrayList<Food> foods;
	
	public SimulationLogic() {
		this.foods = new ArrayList<>(Arrays.asList(new Banana(2), new Califlower(4), new Chicken(3), new Lamb(5)));
		this.animals=generateAnimals();
	}
	
	public SimulationLogic(ArrayList<Animal> animals, ArrayList<Food> foods) {
		this.foods = foods;
		this.animals=animals;
	}
	
	public void simulate() {
		feedAllAnimals();
	}
	
	/**
	 * 
	 * @return
	 */
	private ArrayList<Animal> generateAnimals(){
		ArrayList<Animal> animals = new ArrayList<Animal>();
		System.out.println(this.foods);
		ArrayList<Food> ZebraFood = new ArrayList<>(Arrays.asList(foods.get(0), foods.get(1)));
		
		ArrayList<Food> LionFood = new ArrayList<>(Arrays.asList(foods.get(2), foods.get(3)));
		
		animals.add(new Zebra("Zebra", 2, ZebraFood));
		animals.add(new Lion("Lion", 3, LionFood));
		
		return animals;
	}
	
	private void feedAllAnimals() {
		//Constant that stores the 10 power of the length, this value will be used to offset the random between 0 and 1
		//e.g. if the array's length is 13 the constant is equal to 10
		final int POWER_OF_10 = (int)(Math.pow(10, (int)(Math.log10(this.foods.size())+1)));
		
		HashMap<Integer, Animal> animalsTurns = new HashMap<>();
		
		for(int turn=1; !areAllAnimalsDead(); turn++) {
			for(Animal animal : this.animals) {
				Food f = this.foods.get((int)((Math.random()*POWER_OF_10)%this.foods.size()));
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
