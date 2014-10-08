package cs441.eews.entity.interfaces;
/**
 * @author Akshay Patil
 */
public interface IRegion {
	public abstract int getPopulation();
	public abstract int getRegionID();
	public abstract String getState();
	public abstract String getCountry();
	public abstract String toString();
}