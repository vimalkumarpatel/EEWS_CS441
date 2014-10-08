package cs441.eews.entity.interfaces;
/**
 * @author Akshay Patil
 */
public interface IHealthOrganization {
	public abstract int getHealthOrgID();
	public abstract int getRegionID();
	public abstract int getnStaff();
	public abstract int getnDoctors();
	public abstract int getnPatients();
	public abstract String getHealthOrgName();
	public abstract String toString();
}