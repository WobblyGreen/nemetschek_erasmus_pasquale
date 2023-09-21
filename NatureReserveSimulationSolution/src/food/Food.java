package food;

import events.Event;

public abstract class Food {
	protected String name;
	protected double size;
	protected int currentEnergy;
	protected int maxEnergy;
	protected boolean alive;
	protected int x;
	protected int y;
	
	public Food(String name, double size, int maxEnergy, int x, int y) {
		this.name = name;
		this.size = size;
		this.currentEnergy = maxEnergy;
		this.maxEnergy = maxEnergy;
		this.alive=true;
		this.x=x;
		this.y=y;
	}

	public String getName() {
		return name;
	}

	public void setCurrentEnergy(int currentEnergy) {
		this.currentEnergy=currentEnergy;
		
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
	
	
	public boolean isAlive() {
		return alive;
	}

	public int changeEnergy(int receivedEnergy) {
		int energyLeft = 0;
		currentEnergy+=receivedEnergy;
		
		if(currentEnergy<=0) {
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
}