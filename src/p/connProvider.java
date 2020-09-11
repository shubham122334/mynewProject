package p;
import java.sql.*;
public class connProvider {
	public static Connection getCon() {
		Connection con=null;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","iimt123");
		return con;
		}
		catch(Exception e)
		{
			System.out.println("Connection failed");
	
			return null;
		}
	}

}
