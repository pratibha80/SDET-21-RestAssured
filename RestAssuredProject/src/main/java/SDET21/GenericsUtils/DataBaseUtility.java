package SDET21.GenericsUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import com.mysql.cj.jdbc.Driver;

/**
 * This class contains generic methods to acces  database connection
 * @author Pratibha
 *
 */

public class DataBaseUtility {
	
	Connection con;
	ResultSet result;
	
	/**
	 * this method will get connection to databse
	 * @throws Throwable 
	 */
	
	public void connectToDB() throws Throwable
	{
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		con=DriverManager.getConnection(IPathConstant.dbURL,IPathConstant.dbUsername,IPathConstant.dbPassword);
	}
	
	/**
	 * this method will close the database connection
	 * @throws Throwable 
	 */
	
	public void closeDB() throws Throwable
	{
		con.close();
	}
	
	/**
	 * this method will execute select query and return the value
	 * @throws Throwable 
	 */
	
	public String executeQueryGetData(String query,int columnIndex,String expData) throws Throwable
	{
		Boolean flag=false;
		result=con.createStatement().executeQuery(query);
		while(result.next())
		{
			String actData =result.getString(columnIndex);
			if(actData.equalsIgnoreCase(expData))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println( expData+"data not verified in DB");
			return expData;
		}
		else
		{
			System.out.println(expData +"data not verified in DB");
			return "";
		}
		
	}

}
