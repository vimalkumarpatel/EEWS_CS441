/**
 * 
 */
package cs441.webapis;

import java.util.*;


import cs441.eews.NoSQLUtils;
import cs441.eews.interfaces.INoSQLUtils;

/**
 * @author "Vimalkumar Patel"
 *
 */
public class QueueExecutorThread implements Runnable{

	private Queue<ApiRequestQuery> queue;
	private ArrayList<String> stationList = new ArrayList<String>();
 
	private INoSQLUtils noSqlDB = NoSQLUtils.getSingleton();
	
	public void setQueue(Queue<ApiRequestQuery> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		for(ApiRequestQuery request : queue){
			request.sendGetRequestAndReadResponse();
			noSqlDB.insertJsonIntoDB(null,"weather",request.getResponse());
		}	
		System.out.println("TOTAL STATIONS FOUND FOR THREAD:"+stationList.size());
	}
}

