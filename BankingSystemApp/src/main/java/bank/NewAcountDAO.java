package bank;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class NewAcountDAO {
	
	int k=0;
	CustomerBean cb = null;
	Connection  con ;
	public int register(CustomerBean cb)
	{
		try
		{
			 con= DBConection.getCon();
			CallableStatement cs = con.prepareCall("{call newaccount(?,?,?,?,?)}");
			cs.setString(1, cb.getUserName());
			cs.setString(2, cb.getPassword());
			cs.setLong(3, cb.getAmount());
			cs.setString(4, cb.getAddress());
			cs.setLong(5, cb.getPhono());
			k = cs.executeUpdate();
		}
		catch(Exception  e)
		{
			k=0;
		}
		return k;
	}
	
	
	public CustomerBean find(String s)
	{
		CustomerBean cb = null;

		try
		{ 
			System.out.println(s);
			Connection con = DBConection.getCon();
			 PreparedStatement ps = con.prepareStatement("SELECT * FROM BANKAPPLICATION WHERE USERNAME=?");
			 ps.setString(1, s);
			 ResultSet rs = ps.executeQuery();
//			 while(rs.next())
			 if(rs.next())
			 {
				 cb = new CustomerBean();
				 
				 cb.setAccount(rs.getLong(1));
				 cb.setUserName(rs.getString(2));
				 cb.setPassword(rs.getString(3));
				 cb.setAmount(rs.getLong(4));
				 cb.setAddress(rs.getString(5));
				 cb.setPhono(rs.getLong(6));
				 
				 //System.out.println(rs.getInt(1)+"  "+rs.getString(2));
			 }
			
			
		}
		catch(Exception  e)
		{
			e.printStackTrace();
		}
		return cb;
	}

}
