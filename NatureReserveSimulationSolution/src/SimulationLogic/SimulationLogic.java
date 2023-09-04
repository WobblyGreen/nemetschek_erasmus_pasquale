package SimulationLogic;

import java.util.ArrayList;
import java.util.Arrays;

import Animals.Animal;
import Food.Food;

public class SimulationLogic {
	
	private ArrayList<Animal> animals;
	private Food[] foods;
	
	public SimulationLogic() {
		this.animals=generateAnimals();
		this.foods = Food.values();
	}
	
	public SimulationLogic(ArrayList<Animal> animals, Food[] foods) {
		this.animals=animals;
		this.foods = foods;
	}
	
	public void simulate() {
		feedAllAnimals();
	}
	private ArrayList<Animal> generateAnimals(){
		ArrayList<Animal> animals = new ArrayList<Animal>();
		
		ArrayList<Food> ZebraFood = new ArrayList<>();
		ZebraFood.addAll(Arrays.asList(Food.BANANA, Food.CALIFLOWER));
		
		ArrayList<Food> LionFood = new ArrayList<>();
		LionFood.addAll(Arrays.asList(Food.MEAT, Food.LAMB));
		
		animals.add(new Animal("Zebra", 2, ZebraFood));
		animals.add(new Animal("Lion", 3, LionFood));
		
		return animals;
	}
	
	private void feedAllAnimals() {
		final int ORDER = (int)(Math.pow(10, Math.log10(Food.values().length)));
		
		ArrayList<Integer> aliveTurns = new ArrayList<Integer>();
		ArrayList<Animal> deadAnimals = new ArrayList<Animal>();
		
		for(int i=1; !areAllAnimalsDead(); i++) {
			for(Animal animal : this.animals) {
				if(!animal.isAlive()) {
					if(!deadAnimals.contains(animal)) {
						aliveTurns.add(i);
						deadAnimals.add(animal);
					}
					continue;
				}
				Food f = Food.values()[(int)((Math.random()*ORDER)%Food.values().length)];
				animal.feed(f);
			}
			System.out.println("Turn No."+ i + "\n"+animals);
			
		}
		
	}
	
	private boolean areAllAnimalsDead() {
		for(Animal a:this.animals) {
			if(a.isAlive()) return false;
		}
		return true;
	}

}
