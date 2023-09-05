package Common;

public interface Eatable {
	public String getName();
	public int getEnergy();
	
	@Override
	public boolean equals(Object obj);
}
