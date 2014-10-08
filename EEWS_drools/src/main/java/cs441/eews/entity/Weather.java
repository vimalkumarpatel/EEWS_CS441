package cs441.eews.entity;

import java.sql.Date;

import cs441.eews.entity.interfaces.IWeather;


public class Weather implements IWeather {
	private int regionID;
	private Date recordDate;
	private int minTemperature;
	private int maxTemperature;
	private int rainfall;
	private double humidity;

	public Weather(int regionID, Date recordDate, int minTemperature,
			int maxTemperature, int rainfall, double humidity) {
		this.regionID = regionID;
		this.recordDate = recordDate;
		this.minTemperature = minTemperature;
		this.maxTemperature = maxTemperature;
		this.rainfall = rainfall;
		this.humidity = humidity;
	}

	@Override
	public int getRegionID() {
		return regionID;
	}

	@Override
	public Date getRecordDate() {
		return recordDate;
	}

	@Override
	public double getMinTemperature() {
		return (double)minTemperature/10;
	}

	@Override
	public double getMaxTemperature() {
		return (double)maxTemperature/10;
	}

	@Override
	public double getRainfall() {
		return (double)rainfall/10;
	}

	@Override
	public double getHumidity() {
		return humidity;
	}

	@SuppressWarnings("deprecation")
	@Override
	public String toString() {

		String date = String.format("%2d-%2d-%4d", recordDate.getDate(),
				recordDate.getMonth() + 1, recordDate.getYear() + 1900)
				.replace(" ", "0");

		return String
				.format("[W][id:%d,\tTemp: %5d to %5d\tRain: %5d\tHumidity: %1.2f\tDate: ",
						regionID, minTemperature, maxTemperature, rainfall,
						humidity)
				+ date + "]";
	}

	@Override
	public double getAverageTemperature() {
		return (double)(minTemperature+maxTemperature)/2;
	}
}
