package cs441.eews;
/**
 * @author Akshay Patil
 */
import java.sql.SQLException;

import cs441.eews.entity.Region;
import cs441.eews.entity.Weather;
import cs441.eews.entity.interfaces.IHealthOrganization;
import cs441.eews.interfaces.IMySQLUtils;


@SuppressWarnings("unused")
public class Test {
	
	public static void main(String[] args) throws SQLException {
		IMySQLUtils utils = MySQLUtils.getSingleton();
		IHealthOrganization r[] = utils.getAllHealthOrganizations(1);
		for(int i=0; i<r.length; i++){
			System.out.println(r[i]);
		}
		/*System.out.println(utils.getMedicine(1));*/
		utils.close();
	}
}
