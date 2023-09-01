package SimulationLogic;

import java.util.ArrayList;
import java.util.Arrays;

import Animals.Animal;
import Food.Food;

public class SimulationLogic {

	public static void main(String[] args) {
		ArrayList<Animal> animals = createAnimals();
		System.out.println(animals);
		
		feedAllAnimals(animals, 3);
	}
	
	private static ArrayList<Animal> createAnimals(){
		ArrayList<Animal> animals = new ArrayList<Animal>();
		
		ArrayList<Food> ZebraFood = new ArrayList<>();
		ZebraFood.addAll(Arrays.asList(Food.BANANA, Food.CALIFLOWER));
		
		ArrayList<Food> LionFood = new ArrayList<>();
		LionFood.addAll(Arrays.asList(Food.MEAT, Food.LAMB));
		
		animals.add(new Animal("Zebra", 10, ZebraFood));
		animals.add(new Animal("Lion", 7, LionFood));
		
		return animals;
	}
	
	private static void feedAllAnimals(ArrayList<Animal> animals, int turns) {
		final int ORDER = (int)(Math.pow(10, Math.log10(Food.values().length)));
		
		for(int i=0; ; i++) {
			for(Animal animal : animals) {
				Food f = Food.values()[(int)((Math.random()*ORDER)%Food.values().length)];
				animal.feed(f);
			}
			System.out.println("Turn No."+(i+1) + "\n"+animals);
			
		}
		
	}

}
