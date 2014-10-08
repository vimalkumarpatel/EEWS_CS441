package cs441.eews.entity.interfaces;
/**
 * @author Akshay Patil
 */
public interface IPharmacy {
	public abstract int getPharmacyID();
	public abstract int getRegionID();
	public abstract int getMedicineID();
	public abstract String getPharmacyName();
	public abstract int getMedicineQuantity();
	public abstract String toString();
}