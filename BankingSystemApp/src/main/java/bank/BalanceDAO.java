package bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BalanceDAO {

	CustomerBean cb =null;
	public CustomerBean bal(long acc,String uname,String pword)
	{
		try
		{
			Connection con = DBConection.getCon();
			PreparedStatement ps= con.prepareStatement("select * from  bankapplication where account=? and username=? and password=?");
			ps.setLong(1, acc);
			ps.setString(2, uname);
			ps.setString(3, pword);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				cb = new CustomerBean();
				cb.setAccount(rs.getLong(1));
				cb.setUserName(rs.getString(2));
				cb.setPassword(rs.getString(3));
				cb.setAmount(rs.getLong(4));
				cb.setAddress(rs.getString(5));
				cb.setPhono(rs.getLong(6));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return cb;
	}
	
}
