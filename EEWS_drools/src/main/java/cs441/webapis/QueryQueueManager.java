package cs441.webapis;

import java.util.ArrayList;
import java.util.Queue;

public class QueryQueueManager {

	ArrayList<Queue<ApiRequestQuery>> listOfQueus = null;
	ArrayList<Runnable> queueExecutors = null;

	public void setListOfQueue(ArrayList<Queue<ApiRequestQuery>> reqQueues) {
		listOfQueus = reqQueues;
	}

	public void executeQueues() {

		queueExecutors = new ArrayList<Runnable>();

		for (Queue<ApiRequestQuery> queue : listOfQueus) {
			QueueExecutorThread qet = new QueueExecutorThread();
			qet.setQueue(queue);

			Thread t = new Thread(qet);
			queueExecutors.add(t);
			t.start();
		}
	}

}
