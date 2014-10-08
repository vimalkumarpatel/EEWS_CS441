package cs441.eews;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

import cs441.webapis.ApiRequestQuery;
import cs441.webapis.QueryQueueManager;

public class DataExtractor {

	static String token[] = {"LVUhzdydClLwzGQBDPnGwOchIVUtYOgR","flustgUZTSNxVISYiiuOFzWUZtRFfJEx"};

	@SuppressWarnings("deprecation")
	public static void main(String[] argv) {

		// reqQueues is the queue containing the ApiRequestQuery, i.e requests
		// to be made
		ArrayList<Queue<ApiRequestQuery>> reqQueues = null;
		QueryQueueManager qqm = null;// QueryQueueManager qqm is the queue
										// manager.

		reqQueues = new ArrayList<Queue<ApiRequestQuery>>();

		for (int cntToken = 0; cntToken < token.length; cntToken++) {
			reqQueues.add(new LinkedList<ApiRequestQuery>());
		}

		int noRegions = 216;

		Calendar start = Calendar.getInstance();
		start.setTime(new Date(2012 - 1900, 11, 01));
		Calendar end = Calendar.getInstance();
		end.setTime(new Date(2012 - 1900, 11, 31));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		for (; !start.after(end); start.add(Calendar.DATE, 1)) {
			Date current = start.getTime();
			for (int regCount = 1; regCount < noRegions; regCount++) {

				String uri = "http://localhost:8080/EEWS_weatherWebApp/RandomWeather?regionID="
						+ regCount + "&recorddate=" + sdf.format(current);

				try {

					URL url = new URL(uri);
					ApiRequestQuery apiQuery = new ApiRequestQuery();
					apiQuery.setUrl(url);
					reqQueues.get(regCount % token.length).add(apiQuery);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		qqm = new QueryQueueManager();
		qqm.setListOfQueue(reqQueues);
		qqm.executeQueues();

		for (Queue<ApiRequestQuery> r : reqQueues) {
			System.out.println("SIZE OF QUEUE == " + r.size());
		}
	}
}
