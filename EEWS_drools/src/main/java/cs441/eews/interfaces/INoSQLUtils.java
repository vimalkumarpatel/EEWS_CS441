package cs441.eews.interfaces;

import cs441.eews.entity.interfaces.IWeather;

public interface INoSQLUtils {

	public abstract void insertJsonIntoDB(String dataBase,
			String collectionName, String jsonString);
	
	public abstract IWeather[] getAllWeatherInfo(int regionID)
			throws Exception;	
	

}