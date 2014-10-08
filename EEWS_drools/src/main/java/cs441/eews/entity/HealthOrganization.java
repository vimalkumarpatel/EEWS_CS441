package cs441.eews.entity;
/**
 * @author Akshay Patil
 */
import cs441.eews.entity.interfaces.IHealthOrganization;

public class HealthOrganization implements IHealthOrganization {
	private int healthOrgID;
	private int regionID;
	private int nStaff;
	private int nDoctors;
	private int nPatients;
	private String healthOrgName;

	public HealthOrganization(int healthOrgID, int regionID, int nStaff,
			int nDoctors, int nPatients, String healthOrgName) {
		this.healthOrgID = healthOrgID;
		this.regionID = regionID;
		this.nStaff = nStaff;
		this.nDoctors = nDoctors;
		this.nPatients = nPatients;
		this.healthOrgName = healthOrgName;
	}

	/* (non-Javadoc)
	 * @see cs441.eews.entity.IHealthOrganization#getHealthOrgID()
	 */
	@Override
	public int getHealthOrgID() {
		return healthOrgID;
	}

	/* (non-Javadoc)
	 * @see cs441.eews.entity.IHealthOrganization#getRegionID()
	 */
	@Override
	public int getRegionID() {
		return regionID;
	}

	/* (non-Javadoc)
	 * @see cs441.eews.entity.IHealthOrganization#getnStaff()
	 */
	@Override
	public int getnStaff() {
		return nStaff;
	}

	/* (non-Javadoc)
	 * @see cs441.eews.entity.IHealthOrganization#getnDoctors()
	 */
	@Override
	public int getnDoctors() {
		return nDoctors;
	}

	/* (non-Javadoc)
	 * @see cs441.eews.entity.IHealthOrganization#getnPatients()
	 */
	@Override
	public int getnPatients() {
		return nPatients;
	}

	/* (non-Javadoc)
	 * @see cs441.eews.entity.IHealthOrganization#getHealthOrgName()
	 */
	@Override
	public String getHealthOrgName() {
		return healthOrgName;
	}

	/* (non-Javadoc)
	 * @see cs441.eews.entity.IHealthOrganization#toString()
	 */
	
	@Override
	public String toString() {
		return String.format(
				"[H][id:%d in region:%d Doc:%3d Staff:%3d Capacity:%3d Name:%40s]",
				healthOrgID, regionID, nDoctors, nStaff, nPatients,
				healthOrgName);
	}
}
