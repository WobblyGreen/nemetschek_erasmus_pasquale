package food;

<<<<<<< HEAD
public abstract class Food {
	protected double size;
	protected int currentEnergy;
	protected int maxEnergy;
	protected FoodName name;
	
	
	public Food(FoodName name, double size, int currentEnergy, int maxEnergy) {
		this.currentEnergy = currentEnergy;
		this.maxEnergy = maxEnergy;
		this.name = name;
	}


	public double getSize() {
		return size;
	}


	public int getCurrentEnergy() {
		return currentEnergy;
	}


	public int getMaxEnergy() {
		return maxEnergy;
	}


=======
import events.Event;

public abstract class Food {
	protected FoodName name;
	protected double size;
	protected int currentEnergy;
	protected int maxEnergy;
	protected boolean alive;
	
	public Food(FoodName name, double size, int maxEnergy) {
		this.name = name;
		this.size = size;
		this.currentEnergy = maxEnergy;
		this.maxEnergy = maxEnergy;
		this.alive=true;
	}

>>>>>>> 6b9ad2c (Fixed inheritance between Animal, Plants and Food)
	public FoodName getName() {
		return name;
	}

<<<<<<< HEAD

	public void setCurrentEnergy(int currentEnergy) {
		this.currentEnergy=currentEnergy;
		
	}
=======
	public double getSize() {
		return size;
	}

	public int getCurrentEnergy() {
		return currentEnergy;
	}

	public int getMaxEnergy() {
		return maxEnergy;
	}
	
	public void setCurrentEnergy(int currentEnergy) {
		this.currentEnergy=currentEnergy;
	}
	
	public boolean isAlive() {
		return alive;
	}

	public int changeEnergy(int receivedEnergy) {
		int energyLeft = 0;
		currentEnergy+=receivedEnergy;
		
		if(currentEnergy<0) {
			energyLeft=currentEnergy;
			currentEnergy=0;
			die();
		}		
		
		else if(currentEnergy>maxEnergy) {
			energyLeft=currentEnergy-maxEnergy;
			currentEnergy=maxEnergy;
		}
		
		return energyLeft;
	}
	
	public Event die() {
		alive=false;
		return Event.DIE;
	}
	
	
	
	
>>>>>>> 6b9ad2c (Fixed inheritance between Animal, Plants and Food)
}
