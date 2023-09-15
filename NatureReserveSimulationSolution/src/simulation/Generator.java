package simulation;

import java.util.ArrayList;
import java.util.Arrays;

import animalSubClasses.*;
import animals.Animal;
import food.Food;
import food.FoodName;
import nonAnimalSubClasses.*;

public class Generator {
	
	public Generator() {
	};
	
	public double getRandom(int multiplier) {
		return Math.random()*multiplier;
	}
	
	public ArrayList<Animal> generateRandomAnimals(){
		return new ArrayList<Animal>(Arrays.asList(new Lion(), new Zebra()));
	}
	
	public ArrayList<Food> generateRandomFoods(){
		ArrayList<Food> foods = new ArrayList<>();
		
		/*int numOfGeneratedFoods = (int)getRandom(5)+1;
		
		for(int i=0; i<numOfGeneratedFoods; i++) {
			foods.add(generateRandomFood());
		}*/
		foods.add(new Cauliflower());
		
		return foods;
	}
	
	public Food generateRandomFood() {
		FoodName foodToGenerate = FoodName.values()[(int)getRandom(FoodName.values().length)];
		Food generatedFood;
		
		switch(foodToGenerate) {
		case LION:
			generatedFood=generateLion();
			break;
		case ZEBRA:
			generatedFood=generateZebra();
			break;
		case CAULIFLOWER:
			generatedFood=generateCauliflower();
			break;
		case BANANA:
			generatedFood=generateBanana();
			break;
		default:
			generatedFood=null;
		}
		
		return generatedFood;
	}
	
	private Lion generateLion() {
		return new Lion();
	}
	private Zebra generateZebra() {
		return new Zebra();
	}
	private Cauliflower generateCauliflower() {
		return new Cauliflower();
	}
	private Banana generateBanana() {
		return new Banana();
	}
	
}
