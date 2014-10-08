package cs441.eews;
/**
 * @author Akshay Patil
 */
public class Fetcher extends Thread {
	
	private String url;

	public Fetcher(String url){
		super("UpdateThread");
		this.url = url;		
	}
	
	public void run() {
		download(url);
	}
	public void download(String url){
		
	}
}
