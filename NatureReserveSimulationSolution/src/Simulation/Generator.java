package Simulation;

import java.util.ArrayList;

import AnimalSubClasses.*;
import NonAnimalSubClasses.*;
import food.Food;
import food.FoodName;

public class Generator {
	
	public Generator() {
	};
	
	public double getRandom(int multiplier) {
		return Math.random()*multiplier;
	}
	
	public ArrayList<Food> generateRandomFoods(){
		ArrayList<Food> foods = new ArrayList<>();
		
		int numOfGeneratedFoods = (int)getRandom(10)+1;
		
		for(int i=0; i<numOfGeneratedFoods; i++) {
			foods.add(generateRandomFood());
		}
		
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
