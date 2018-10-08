package tests;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dataBaseConnection.Dbconnection;

public class NewClass extends Dbconnection{

	
	public NewClass() throws SQLException {
		super();
		String query = "select * from logged_in_users where user_name = 'adminrw'";
		//Create Statement Object			  
		Statement stmt = this.getConnection().createStatement();

		// Execute the SQL Query. Store results in ResultSet		
			ResultSet rs= stmt.executeQuery(query);	
		
			System.out.println(rs.getRow()  +"--------");
			while (rs.next()){
				System.out.println("coming in while");
		        		String user_id = rs.getString(1);								        
		                String user_name = rs.getString(2);
		                String first_name  = rs.getString(3);
		                String last_name = rs.getString(4);								        
		                String login_time = rs.getString(5);
		                String ip  = rs.getString(6);
		        		String last_login_time = rs.getString(7);								        
		                String last_activity_time = rs.getString(8);
		                String session_id  = rs.getString(9);
		                String last_updated  = rs.getString(10);
		                System. out.println(user_id+"  "+user_name+ "   "+session_id);	
		              
		        }
	}

	public static void main(String[] args) throws SQLException {
		 NewClass obj = new NewClass();
		 System.out.println("=======");
	}

}
