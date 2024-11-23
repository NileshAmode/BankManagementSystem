package bank;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateDAO {
	 
	int k=0;
	public int  update(CustomerBean cb)
	{
		try {
			Connection con = DBConection.getCon();
			PreparedStatement ps = con.prepareStatement("update bankapplication set balance= ? where account=? and username=?");
			ps.setLong(1, cb.getAmount());
			ps.setLong(2, cb.getAccount());
			ps.setString(3, cb.getUserName());
			k = ps.executeUpdate();
			
		}
		catch(Exception  e)
		{
			e.printStackTrace();
		}
		return  k;
	}
	
	

}
