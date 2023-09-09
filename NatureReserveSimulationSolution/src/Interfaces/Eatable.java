package Interfaces;

public interface Eatable {
	public DietItem getDietItem();
	public String getName();
	public int getEnergy();
	public double getSize();

	public void setEnergy(int energy);
	public void setSize(double size);
}
