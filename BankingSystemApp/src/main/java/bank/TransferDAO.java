package bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;

public class TransferDAO {

	CustomerBean cb =null;
	int k=0;
	int k1=0;
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
	public CustomerBean bal(long acc)
	{
		try
		{
			Connection con = DBConection.getCon();
			PreparedStatement ps= con.prepareStatement("select * from  bankapplication where account=?");
			ps.setLong(1, acc);
			
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
	
	public int  transfer(CustomerBean scb , CustomerBean rcb , long amount)
	{ 
		try
		{
			Connection con = DBConection.getCon();
			PreparedStatement ps= con.prepareStatement("update bankapplication set balance=? where account=?");
			con.setAutoCommit(false);
			Savepoint sp = con.setSavepoint();
			ps.setLong(1, scb.getAmount()-amount);
			ps.setLong(2, scb.getAccount());
			k= ps.executeUpdate();
			if (k>0)
			{
				ps.setLong(1, rcb.getAmount()+amount);
				ps.setLong(2, rcb.getAccount());
				k1  = ps.executeUpdate();
				if(k1>0)
				{
					k=1;
					con.commit();
				}
				else
				{
					con.rollback(sp);
				}
			}
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return k;
	}
	
}
