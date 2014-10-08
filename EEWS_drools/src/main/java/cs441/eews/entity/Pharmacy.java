package cs441.eews.entity;
/**
 * @author Akshay Patil
 */
import cs441.eews.entity.interfaces.IPharmacy;

public class Pharmacy implements IPharmacy {
	private int pharmacyID;
	private int regionID;
	private int medicineID;
	private String pharmacyName;
	private int medicineQuantity;
	/* (non-Javadoc)
	 * @see cs441.eews.entity.IPharmacy#getPharmacyID()
	 */
	@Override
	public int getPharmacyID() {
		return pharmacyID;
	}
	/* (non-Javadoc)
	 * @see cs441.eews.entity.IPharmacy#getRegionID()
	 */
	@Override
	public int getRegionID() {
		return regionID;
	}
	/* (non-Javadoc)
	 * @see cs441.eews.entity.IPharmacy#getMedicineID()
	 */
	@Override
	public int getMedicineID() {
		return medicineID;
	}
	/* (non-Javadoc)
	 * @see cs441.eews.entity.IPharmacy#getPharmacyName()
	 */
	@Override
	public String getPharmacyName() {
		return pharmacyName;
	}
	/* (non-Javadoc)
	 * @see cs441.eews.entity.IPharmacy#getMedicineQuantity()
	 */
	@Override
	public int getMedicineQuantity() {
		return medicineQuantity;
	}
	public Pharmacy(int pharmacyID, int regionID, int medicineID,
			String pharmacyName, int medicineQuantity) {		
		this.pharmacyID = pharmacyID;
		this.regionID = regionID;
		this.medicineID = medicineID;
		this.pharmacyName = pharmacyName;
		this.medicineQuantity = medicineQuantity;
	}	
	/* (non-Javadoc)
	 * @see cs441.eews.entity.IPharmacy#toString()
	 */
	
	@Override
	public String toString() {
		return String.format("[P][id: %2d in region: %2d <%6d>:: %s", pharmacyID,regionID, medicineQuantity,pharmacyName);
	}
}
