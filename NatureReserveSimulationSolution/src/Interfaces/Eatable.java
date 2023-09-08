package Interfaces;

public interface Eatable {
	public String getName();
	public int getEnergy();
	public double getSize();

	public void setEnergy(int energy);
	public void setSize(double size);
	
	
	@Override
	public boolean equals(Object obj);
}
