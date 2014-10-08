package cs441.eews;
/**
 * @author Vimalkumar Patel
 */
 
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import cs441.eews.entity.EpidemicProbability;
import cs441.eews.entity.HealthOrganization;
import cs441.eews.entity.Medicine;
import cs441.eews.entity.Pharmacy;
import cs441.eews.entity.Region;
import cs441.eews.entity.Weather;
import cs441.eews.entity.interfaces.IHealthOrganization;
import cs441.eews.entity.interfaces.IMedicine;
import cs441.eews.entity.interfaces.IPharmacy;
import cs441.eews.entity.interfaces.IRegion;
import cs441.eews.entity.interfaces.IWeather;
import cs441.eews.interfaces.IMySQLUtils;


public class MySQLUtils implements IMySQLUtils {
	private static IMySQLUtils one;
	private Connection connection;
	private String database;
	private String username;
	private String password;
	private String host;
	private int port;

	public static synchronized IMySQLUtils getSingleton() {
		if (one == null)
			one = new MySQLUtils();
		return one;
	}

	private MySQLUtils() {
		connection = null;
		database = "ewsdb1";
		username = "root";
		password = "root";
		host = "127.0.0.1";
		port = 3306;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e1) {
			System.out.println(e1);
		}
		try {
			connection = (Connection) DriverManager.getConnection(String
					.format("jdbc:mysql://%s:%d/%s", host, port, database),
					username, password);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	/* (non-Javadoc)
	 * @see cs441.eews.IMySQLUtils#close()
	 */
	public void close() {
		if (connection != null)
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
	}

	/* (non-Javadoc)
	 * @see cs441.eews.IMySQLUtils#getAllWeatherInfo(int)
	 */
	public IWeather[] getAllWeatherInfo(int regionID) throws SQLException {
		ArrayList<Weather> result = new ArrayList<Weather>();
		Statement statement = (Statement) connection.createStatement();
		ResultSet ans = statement.executeQuery(String.format(
				"SELECT * from weather where regionid=%d;", regionID));
		
		
		
		
		
		
		
		while (ans.next()) {
			Weather r = new Weather(ans.getInt("regionID"),
					ans.getDate("recorddate"), ans.getInt("minTemperature"),
					ans.getInt("maxTemperature"), ans.getInt("rainfall"),
					ans.getDouble("humidity"));
			result.add(r);
		}
		return result.toArray((Weather[]) Array.newInstance(Weather.class, 0));
	}

	/* (non-Javadoc)
	 * @see cs441.eews.IMySQLUtils#getAllRegions()
	 */
	public IRegion[] getAllRegions() throws SQLException {
		ArrayList<Region> result = new ArrayList<Region>();

		Statement statement = (Statement) connection.createStatement();
		ResultSet ans = statement.executeQuery("SELECT * from region;");
		while (ans.next()) {
			Region r = new Region(ans.getInt("regionID"),
					ans.getString("country"), ans.getString("state"),
					ans.getInt("population"));
			result.add(r);
		}
		return result.toArray((Region[]) Array.newInstance(Region.class, 0));
	}

	/* (non-Javadoc)
	 * @see cs441.eews.IMySQLUtils#getAllPharmacies(int)
	 */
	public IPharmacy[] getAllPharmacies(int regionID) throws SQLException {
		ArrayList<Pharmacy> result = new ArrayList<Pharmacy>();
		Statement statement = (Statement) connection.createStatement();
		ResultSet ans = statement.executeQuery(String.format(
				"SELECT * from pharmacy where regionid=%d;", regionID));
		while (ans.next()) {
			Pharmacy r = new Pharmacy(ans.getInt("pharmacyID"),
					ans.getInt("regionID"), ans.getInt("medicineID"),
					ans.getString("pharmacyName"),
					ans.getInt("medicineQuantity"));
			result.add(r);
		}
		return result
				.toArray((Pharmacy[]) Array.newInstance(Pharmacy.class, 0));
	}

	/* (non-Javadoc)
	 * @see cs441.eews.IMySQLUtils#getMedicine(int)
	 */
	public IMedicine getMedicine(int medicineID) throws SQLException {
		IMedicine result = null;
		Statement statement = (Statement) connection.createStatement();
		ResultSet ans = statement.executeQuery(String.format(
				"SELECT * from medicine where medicineID=%d;", medicineID));
		if (ans.next())
			result = new Medicine(ans.getInt("medicineID"),
					ans.getString("medicineName"));
		return result;
	}

	/* (non-Javadoc)
	 * @see cs441.eews.IMySQLUtils#getAllHealthOrganizations(int)
	 */
	public IHealthOrganization[] getAllHealthOrganizations(int regionID)
			throws SQLException {
		ArrayList<HealthOrganization> result = new ArrayList<HealthOrganization>();
		Statement statement = (Statement) connection.createStatement();
		ResultSet ans = statement.executeQuery(String
				.format("SELECT * from healthorganization where regionid=%d;",
						regionID));
		while (ans.next()) {
			HealthOrganization r = new HealthOrganization(
					ans.getInt("healthOrgId"), ans.getInt("regionID"),
					ans.getInt("nStaff"), ans.getInt("nDoctors"),
					ans.getInt("nPatients"), ans.getString("healthOrgName"));
			result.add(r);
		}
		return result.toArray((HealthOrganization[]) Array.newInstance(
				HealthOrganization.class, 0));
	}
	
	
	public void saveRegionEP() {
		Map<Integer, Integer> regCnt = EpidemicProbability.getRegionCount();
		Map<Integer, Double> regEp = EpidemicProbability.getRegionEP();
		String updateQuery = "insert into epidemicprobability (regionId,epidemicprobability,count) values (";
		Iterator<Integer> it = regCnt.keySet().iterator();
		Statement stmt = null;
		
		
		try {

			stmt = (Statement) connection.createStatement();
			while (it.hasNext()) {
				String query = updateQuery;
				
				Integer regId = it.next();
				Double ep = regEp.get(regId);
				Integer cnt = regCnt.get(regId);

				query = query+regId+","+ep+","+cnt+")";
				System.out.println(query);
				stmt.executeUpdate(query);
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
