package testCases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class DbConnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		String connectionstr="jdbc:mysql://ZAOMNSQL032Q1.za.omlac.net:3306/STA_FAS_OMUT_Public";
			String user="UTRead";
			String password="CustomUT1";
		
		
		Connection con=DriverManager.getConnection(connectionstr,user,password);
		Statement st=con.createStatement();
		st.executeQuery("Select * FROM DailyPrices");
	}

}