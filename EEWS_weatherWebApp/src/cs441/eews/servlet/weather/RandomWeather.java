package cs441.eews.servlet.weather;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RandomWeather")
public class RandomWeather extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RandomWeather() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String regionID = request.getParameter("regionID");
		String recorddate = request.getParameter("recorddate");
		String resp = "{" + "'_id':'" + regionID + "_" + recorddate + "',"
				+ "'regionID':'" + regionID + "'," + "'recorddate':'"
				+ recorddate + "'," + "'minTemperature':'"
				+ Math.round((Math.random() * 999)) + "',"
				+ "'maxTemperature':'" + Math.round((Math.random() * 999))
				+ "'," + "'rainfall':'" + Math.round((Math.random() * 999))
				+ "'," + "'humidity':'" + Math.round((Math.random() * 100))
				+ "'" + "}";

		// response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		response.setContentType("text/plain");
		pw.println(resp);

	}

}
