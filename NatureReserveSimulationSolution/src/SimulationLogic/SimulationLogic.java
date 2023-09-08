package SimulationLogic;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

import Animals.*;
import Common.Eatable;
import Common.Generator;
import Food.*;
import animalSubClasses.*;
import foodSubClasses.*;

public class SimulationLogic {
	private ArrayList<Animal> animals;
	private Generator generator;
	
	public SimulationLogic() {
		this.generator=new Generator();
		this.animals=generator.generateRandomAnimals();
	}

	public SimulationLogic(ArrayList<Animal> animals) {
		this.animals=animals;
	}
	
	public void simulate() {
		feedAllAnimals();
	}
	
	private void feedAllAnimals() {
		HashMap<Integer, Animal> animalsTurns = new HashMap<>();
		
		for(int turn=1; !areAllAnimalsDead(); turn++) {
			for(Animal animal : this.animals) {
				if(Math.random()>0.5)
					animal.feed(generator.getRandomFood());
				
				else if(animal.isStarving())
					animal.starve();
				
				if(turn%3==0 && !animal.isStarving()) {
					animal.grow();
					animal.addFoodToDiet(generator.);
					
				}
				
				if(!animal.isAlive() && !animalsTurns.containsValue(animal))
					animalsTurns.put(turn, animal);		
			}
		}
		
		int minTurn = Collections.min(animalsTurns.keySet());
		int maxTurn = Collections.max(animalsTurns.keySet());
		
		System.out.println("\nLifespan statistics");
		System.out.println("- Minimum lived for " + minTurn +" turns\n"+ animalsTurns.get(minTurn));
		System.out.println("\n- Maximum lived for " + maxTurn +" turns\n"+ animalsTurns.get(maxTurn));
		System.out.println("\n- Average living of " + average(animalsTurns.keySet()) +" turns");
		
	}
	
	private void addFoodToDiet(Animal animal) {
		Eatable e;
		
		do {
			e = testingFood.get((int)(Math.random()*testingFood.size()));
		} while(e.getName().equals(animal.getName()));
		
		int newEnergy = e.getEnergy() + (int)(e.getEnergy()*Math.random());
		double newSize = e.getSize() + e.getSize()*Math.random();
		
		if(e instanceof Food) {
			Food f = (Food)(e.getDeepClone());
			f.setEnergy(newEnergy);
			f.setSize(newSize);
			animal.addFoodToDiet(f);
		}
		else {
			Animal a = (Animal)(e.getDeepClone());
			a.setEnergy(newEnergy);
			a.setSize(newSize);
			animal.addFoodToDiet(a);
		}
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
