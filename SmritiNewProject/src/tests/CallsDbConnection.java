package tests;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dataBaseConnection.Dbconnection;

public class CallsDbConnection extends Dbconnection{
  
	public CallsDbConnection() throws SQLException {
		super();
		//this.getConnection();
		//Query to Execute	
		String query = "select * from logged_in_users where user_name = 'adminrw'";
		//Create Statement Object			  
		Statement stmt = this.getConnection().createStatement();

		// Execute the SQL Query. Store results in ResultSet		
			ResultSet rs= stmt.executeQuery(query);	
		
			System.out.println(query);
	}

	
	public static void main() {
		
	}

}

