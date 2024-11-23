package bank;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CloseDAO {

	int k = 0;
	
	public  int  close(CustomerBean cb)
	{
		try
		{
			Connection con = DBConection.getCon();
			PreparedStatement ps =  con.prepareStatement("delete from  bankapplication where account=? and username=? and password=?");
			ps.setLong(1, cb.getAccount());
			ps.setString(2, cb.getUserName());
			ps.setString(3, cb.getPassword());
			k = ps.executeUpdate();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return  k;
	}
	
	
}
