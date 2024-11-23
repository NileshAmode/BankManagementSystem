package bank;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConection {
	
	private final static String  driver="oracle.jdbc.driver.OracleDriver";
	private final static String  url="jdbc:oracle:thin:@localhost:1521:orcl";
    private  final  static String username = "nilesh";
    private final  static String pass="123";
    
    private static Connection con;
    private DBConection() {}
    
    static
    {
    	try
    	{
    	   Class.forName(driver);
    	   con = DriverManager.getConnection(url,username,pass);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
   public static Connection getCon()
   {
	   return con;
   }
    
}
