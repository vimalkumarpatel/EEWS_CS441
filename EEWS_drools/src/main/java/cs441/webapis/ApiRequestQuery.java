package cs441.webapis;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiRequestQuery {

	private URL url = null;
	private String response = null;

	public String getResponse() {
		return response;
	}

	public ApiRequestQuery() {
		response = "";
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	public void sendGetRequestAndReadResponse() {
		try {
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/xml");
			InputStream inpStream = connection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(
					inpStream));
			String line = null;
			while ((line = br.readLine()) != null) {
				response = response + line;
			}
			br.close();
			inpStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(url.getQuery() + "-->" + response);
	}
}
