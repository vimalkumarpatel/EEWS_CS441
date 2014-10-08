package cs441.eews;

import java.lang.reflect.Array;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.ArrayList;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.util.JSON;

import cs441.eews.entity.Weather;
import cs441.eews.entity.interfaces.IWeather;
import cs441.eews.interfaces.INoSQLUtils;

@SuppressWarnings("unused")
public class NoSQLUtils implements INoSQLUtils {

	private static INoSQLUtils noSqlDB = null;

	private Mongo mongo = null;
	private DB db = null;
	private String database = "eews";
	private String username = "root";
	private String password = "root";
	private String host = "localhost";
	private int port = 27017;

	private NoSQLUtils() {
		try {
			this.mongo = new Mongo(this.host, port);
			this.db = mongo.getDB(database);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertJsonIntoDB(String dataBase, String collectionName,
			String jsonString) {

		Mongo mongo = this.mongo;
		DB db = null;

		try {
			if (null != dataBase) {
				db = mongo.getDB(dataBase);
			} else {
				db = this.db;
			}
			DBCollection collection = db.getCollection(collectionName);
			// convert JSON to DBObject directly
			DBObject dbObject = (DBObject) JSON.parse(jsonString);
			collection.insert(dbObject);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public IWeather[] getAllWeatherInfo(int regionID) throws Exception {
		ArrayList<Weather> result = new ArrayList<Weather>();
		DBCollection coll = db.getCollection("weather");
		BasicDBObject query = new BasicDBObject("regionID",
				Integer.toString(regionID));
		DBCursor cursor = coll.find(query);

		try {
			while (cursor.hasNext()) {
				DBObject w = (BasicDBObject) cursor.next();
				System.out.println(w);
				Weather r = new Weather(
						Integer.parseInt(((String) w.get("regionID"))), 
						Date.valueOf((String) w.get("recorddate")), 
						Integer.parseInt(((String) w.get("minTemperature"))), 
						Integer.parseInt(((String) w.get("maxTemperature"))), 
						Integer.parseInt(((String) w.get("rainfall"))), 
						Double.parseDouble(((String) w.get("humidity"))));
				result.add(r);
			}
		} finally {
			cursor.close();
		}
		return result.toArray((Weather[]) Array.newInstance(Weather.class, 0));
	}

	public static synchronized INoSQLUtils getSingleton() {
		if (null == noSqlDB) {
			noSqlDB = new NoSQLUtils();
		}
		return noSqlDB;
	}

}
