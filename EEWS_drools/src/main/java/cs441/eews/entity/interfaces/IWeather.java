package cs441.eews.entity.interfaces;
/**
 * @author Akshay Patil
 */
import java.sql.Date;

public interface IWeather {
	public abstract int getRegionID();
	public abstract Date getRecordDate();
	public abstract double getMinTemperature(); //In Celsius
	public abstract double getMaxTemperature(); //In Celsius
	public abstract double getRainfall();       //In millimeters
	public abstract double getHumidity();
	public abstract String toString();
	public abstract double getAverageTemperature();
}