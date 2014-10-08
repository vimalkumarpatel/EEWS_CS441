package cs441.eews.entity;
/**
 * @author Akshay Patil
 */
import cs441.eews.entity.interfaces.IRegion;

public class Region implements IRegion {
	private int regionID;
	private int population;
	private String country;
	private String state;	
	
	public Region(int regionID,  String country, String state, int population) {		
		this.regionID = regionID;
		this.population = population;
		this.country = country;
		this.state = state;
	}
	/* (non-Javadoc)
	 * @see cs441.eews.entity.IRegion#getPopulation()
	 */
	@Override
	public int getPopulation() {
		return population;
	}
	/* (non-Javadoc)
	 * @see cs441.eews.entity.IRegion#getRegionID()
	 */
	@Override
	public int getRegionID() {
		return regionID;
	}
	/* (non-Javadoc)
	 * @see cs441.eews.entity.IRegion#getState()
	 */
	@Override
	public String getState() {
		return state;
	}
	/* (non-Javadoc)
	 * @see cs441.eews.entity.IRegion#getCountry()
	 */
	@Override
	public String getCountry() {
		return country;
	}
	/* (non-Javadoc)
	 * @see cs441.eews.entity.IRegion#toString()
	 */
	
	@Override
	public String toString() {
		return String.format("[R][id:%d,%s/%s,n:%d]", regionID,state,country,population);
	}
}
