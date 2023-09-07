package Common;

public interface Eatable {
	public String getName();
	public int getEnergy();
	public double getSize();
	
	@Override
	public boolean equals(Object obj);
}
