package Interfaces;

public interface Eatable {
	public DietItem getDietItem();
	public String getName();
	public int getEnergy();
	public int getMaxEnergy();
	public double getSize();

	public void setEnergy(int energy);
	public void setSize(double size);
}
