package bank;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DepositDAO {
	
	int k=0;
	public  int deposit(CustomerBean cb)
	{
		try
		{
			Connection con = DBConection.getCon();
			PreparedStatement ps= con.prepareStatement("update bankapplication set balance=? where account=?");
			ps.setLong(1, cb.getAmount());
			ps.setLong(2, cb.getAccount());
			k= ps.executeUpdate();
			
			
		}catch(Exception e)
		{
			k=0;
		}
		return k;
	}

}
