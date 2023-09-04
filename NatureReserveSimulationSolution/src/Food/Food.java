package Food;

public abstract class Food {
	protected int energy;
	
	public Food(int energy) {
		this.energy=energy;
	}

	public int getEnergy() {
		return energy;
	}
	
	@Override
	public String toString() {
		return energy+"";
	}
	
}
