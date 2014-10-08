package cs441.eews.entity;
/**
 * @author Akshay Patil
 */
import cs441.eews.entity.interfaces.IMedicine;

public class Medicine implements IMedicine {
	private int medicineID;
	private String medicineName;
	/* (non-Javadoc)
	 * @see cs441.eews.entity.IMedicine#getMedicineID()
	 */
	@Override
	public int getMedicineID() {
		return medicineID;
	}
	/* (non-Javadoc)
	 * @see cs441.eews.entity.IMedicine#getMedicineName()
	 */
	@Override
	public String getMedicineName() {
		return medicineName;
	}
	public Medicine(int medicineID, String medicineName) {
		super();
		this.medicineID = medicineID;
		this.medicineName = medicineName;
	}
	/* (non-Javadoc)
	 * @see cs441.eews.entity.IMedicine#toString()
	 */
	
	@Override
	public String toString() {
		return String.format("[M][id: %d :: %s]", medicineID, medicineName);
	}
}
