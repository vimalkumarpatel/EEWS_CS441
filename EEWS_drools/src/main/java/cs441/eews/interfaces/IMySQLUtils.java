package cs441.eews.interfaces;
/**
 * @author Akshay Patil
 */
import java.sql.SQLException;

import cs441.eews.entity.interfaces.IHealthOrganization;
import cs441.eews.entity.interfaces.IMedicine;
import cs441.eews.entity.interfaces.IPharmacy;
import cs441.eews.entity.interfaces.IRegion;
import cs441.eews.entity.interfaces.IWeather;


public interface IMySQLUtils {

	public abstract void close();

	public abstract IWeather[] getAllWeatherInfo(int regionID)
			throws SQLException;

	public abstract IRegion[] getAllRegions() throws SQLException;

	public abstract IPharmacy[] getAllPharmacies(int regionID)
			throws SQLException;

	public abstract IMedicine getMedicine(int medicineID) throws SQLException;

	public abstract IHealthOrganization[] getAllHealthOrganizations(int regionID)
			throws SQLException;

	public abstract void saveRegionEP();
}