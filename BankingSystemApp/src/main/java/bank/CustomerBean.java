package bank;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CustomerBean implements Serializable{
	private long account;
	private String userName;
	private String  password;
	private long amount;
	private String address;
	private long phono;
	
	public CustomerBean()
	{
		
	}

	public long getAccount() {
		return account;
	}

	public void setAccount(long account) {
		this.account = account;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhono() {
		return phono;
	}

	public void setPhono(long phono) {
		this.phono = phono;
	}

	@Override
	public String toString() {
		return "CustomerBean [account=" + account + ", userName=" + userName + ", password=" + password + ", amount="
				+ amount + ", address=" + address + ", phono=" + phono + "]";
	}
	
	

}
