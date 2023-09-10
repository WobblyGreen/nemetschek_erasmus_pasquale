package Simulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

import Animals.Animal;
import Animals.AnimalSpecies;
import Interfaces.DietItem;
import Interfaces.Eatable;
import NonAnimal.VegeterianFood;
import animalSubClasses.Carnivore;
import animalSubClasses.Herbivore;

public class SimulationLogic {
	ArrayList<Animal> animals;
	ArrayList<VegeterianFood> veggies;
	Generator gen;
	
	public SimulationLogic() {
		this.gen=new Generator();
		this.animals=gen.generateRandomAnimalArrayList();
		this.veggies=gen.generateRandomVeggieArrayList();
	}
	
	public void simulate() {
		System.out.println("Starting simulation.\n");
		System.out.println("-Available animals:\n"+animals);
		System.out.println("-Available veggies:\n"+veggies);
		feedAllAnimals();
	}
	
	private void feedAllAnimals() {
		HashMap<Integer, Animal> animalLifes = new HashMap<>();
		ArrayList<Animal> toRemove = new ArrayList<>();
		
		for(int turn=1; !areAllAnimalsDeath() && !animals.isEmpty(); turn++) {
			System.out.print("\n---------- Day "+turn+" ----------");
			
			for(Animal animal:animals) {
				System.out.println("\n>>"+animal.getName()+" "+animal.getEnergy()+"/"+animal.getMaxEnergy());
				
				Eatable e = null;
				DietItem di = gen.generateRandomDietItem();
				if(di instanceof AnimalSpecies) {
					e=getAnimalReference(di);
					if(e==animal) e=null;
				}
				else if(di instanceof VegeterianFood) {
					e=getVeggieReference(di);
				}
				
				boolean didAnimalEat=animal.feed(e);
				
				if(!didAnimalEat) {
					animal.starve();
					System.out.println("_starving");
				}
				else
					System.out.println("_eats "+e.getName());
				
				if(turn%3==0 && !animal.isStarving()) {
					animal.grow();
					System.out.println("_grows up to "+animal.getSize());
					
					int dietLen = animal.getDiet().size();
					animal.addFoodToDiet(gen.generateRandomDietItem());
					
					if(dietLen<animal.getDiet().size())
						System.out.println("_added "+animal.getDiet().get(0)+" to diet");
				}
			}
			
			for(Animal a:toRemove) {
				animals.remove(a);
			}
		}
		
		int minLife = Collections.min(animalLifes.keySet());
		int maxLife = Collections.max(animalLifes.keySet());
		
		System.out.println("\nStatistic>>");
		System.out.println(">Minimum lived for " + minLife +" turns\n"+ animalLifes.get(minLife));
		System.out.println(">Maximum lived for " + maxLife +" turns\n"+ animalLifes.get(maxLife));
		System.out.println(">Average living of " + average(animalLifes.keySet()) +" turns");
	}
	
	private VegeterianFood getVeggieReference(DietItem di) {
		for(VegeterianFood vf:veggies) {
			if(vf.getDietItem().equals(di)) return vf;
		}
		
		return null;
	}
	
	private Animal getAnimalReference(DietItem di) {
		for(Animal a:animals) {
			if(a.getDietItem().equals(di)) return a;
		}
		
		return null;
	}
	
	private boolean areAllAnimalsDeath() {
		for(Animal a:animals) {
			if(a.isAlive()) return false;
		}
		return true;
	}
	
	private int average(Set<Integer> nums) {
		int sum = 0;
		for(int n : nums) sum+=n;
		return sum/nums.size();
		
	}
}
