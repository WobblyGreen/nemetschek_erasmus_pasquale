package SimulationLogic;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

import Animals.*;
import Common.Eatable;
import Food.*;
import animalSubClasses.*;
import foodSubClasses.*;

public class SimulationLogic {
	
	private ArrayList<Animal> animals;
	private ArrayList<Eatable> testingFood;
	
	public SimulationLogic() {
		this.animals=generateAnimalsIncludingOwnDiets();
		this.testingFood=generateTestingFood();
	}

	public SimulationLogic(ArrayList<Animal> animals) {
		this.animals=animals;
	}
	
	public void simulate() {
		feedAllAnimals();
	}

	private ArrayList<Animal> generateAnimalsIncludingOwnDiets(){
		ArrayList<Animal> animals = new ArrayList<Animal>();
		
		ArrayList<Eatable> ZebraFood = new ArrayList<>(Arrays.asList(new Banana(2), new Califlower(4)));
		ArrayList<Eatable> LionFood = new ArrayList<>(Arrays.asList(new Lamb(3), new Chicken(5)));
		
		//animals.add(new Zebra(20, ZebraFood));
		animals.add(new Lion(10, LionFood));
		
		return animals;
	}
	
	private ArrayList<Eatable> generateTestingFood() {
		ArrayList<Eatable> testingFood = new ArrayList<>();
		testingFood.addAll(Arrays.asList(new Zebra(1), new Banana(30)));
		/*
		for(AnimalSpecies as : AnimalSpecies.values()) {
			testingFood.add(new Animal(as, (int)(Math.random()*10)));
		}
		for(FoodName fn : FoodName.values()) {
			testingFood.add(new Food(fn, (int)(Math.random()*5)));
		}*/
		return testingFood;
	}
	
	private void feedAllAnimals() {
		HashMap<Integer, Animal> animalsTurns = new HashMap<>();
		
		for(int turn=1; !areAllAnimalsDead(); turn++) {
			for(Animal animal : this.animals) {
				Eatable e = this.testingFood.get((int)(Math.random()*testingFood.size()));
				animal.feed(e);
				
				System.out.println(animal);
				if(!animal.isAlive() && !animalsTurns.containsValue(animal)) {
					animalsTurns.put(turn, animal);
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
