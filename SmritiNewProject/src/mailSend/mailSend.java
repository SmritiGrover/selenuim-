package mailSend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Before;

/**
* @author Smriti
* 
* 
* This class will Send the mail simultaneously using multi threading
*
*/
public class mailSend extends Thread{

	
	/* ---------------Database Connection--------------------*/
	public static Connection conn = null;
	public static PreparedStatement pstmt = null;
	public static ResultSet rs = null;
	public static int test = 0;
	public static String camp_state;
	public static String camp_id;
	static String  testEnv;
	private volatile boolean running = true;
	//create user 'smriti'@'localhost' identified by 'smritiPWD';
	//Use this command into database:GRANT ALL PRIVILEGES ON czentrix_campaign_manager.* TO 'smriti'@'192.168.1.57' identified by 'password';
	
	public static String url= "jdbc:mysql://192.168.1.57/czentrix_campaign_manager";
		
	//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"
	public static String db_driver = "com.mysql.jdbc.Driver";
	public static String db_un = "cz_user";
	public static String db_pw = "password";
	/* --------------------------------------------------------*/
	
	//Initially setting the flag as true
    
    private volatile boolean flag = true;
     
    //This method will set flag as false
     
    public void stopRunning()
    {
        this.flag = false;
    }
	
	public void run(){  
		int i=0;
		System.out.println("Thread is running...");  
		while (this.flag)
        {
			
            System.out.println("I am running...."+i+ "======");
            i++;
        }
         
        System.out.println("Stopped Running....");

		try{
			for(int i1=1;i1<5;i1++)
			{
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			System.out.println("come in database conection"+i1+"count");
			//Load mysql jdbc driver
			Class.forName(db_driver).newInstance();
			System.out.println(Class.forName(db_driver).newInstance());
			
			//Create Connection to DB
			conn = DriverManager.getConnection(url,db_un,db_pw);
			System.out.println("connection establish with " + conn);
			
			if(conn!=null) {
                System.out.println("Connected to the database");
            }else {
                System.out.println("Failed to connect to "+testEnv+" database");
            }
			//Query to Execute	
			
			String query = "insert into break_reasons (campaign_id , reason , allowed_time) values ('50' , 'BREAK' , '00:00:00')";
			
			String query1 = "select * from campaign where campaign_name='smriti_in'";
			
			//Create Statement Object			  
			Statement stmt = conn.createStatement();
			
			System.out.println(stmt +"statement");
			
			// Execute the SQL Query
			 int numRowsChanged = stmt.executeUpdate(query);
			System.out.println( numRowsChanged + "  test1 output");			
			ResultSet rs1= stmt.executeQuery(query1);
			while (rs1.next()){
        		String campaign_id = rs1.getString(1);								        
                String reason = rs1.getString(2);
                String allowed_time  = rs1.getString(3);
                System.out.println(campaign_id+"  "+reason+" " +allowed_time);
                 camp_id = campaign_id;
                camp_state = reason;
               
        }
			}	
		}catch(Exception e){
			System.out.println(e);
		  }
		}
	public static void main(String[] args)  {
		System.out.println("control comes here first");
		mailSend t1=new mailSend();  
		mailSend t2=new mailSend();
		t1.start();
		t2.start();
		
		
		t1.getState();
		System.out.println(t1.getState()+"first===========");
		System.out.println(t2.getState()+"second===========");
		
		try{
		//call stopRunning() method whenever you want to stop a thread  
		    t1.stopRunning();
		    System.out.println(t1.getState()+"first====Stop======");
		    t2.stopRunning();
		    System.out.println(t2.getState()+"second====Stop=======");
	}catch(Exception ex){}
	  
	}
}
