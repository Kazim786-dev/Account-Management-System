

public class Customer {

	String Name;
	String email;
	String phoneNo;
	String CNIC;
	String address;
	String sex;
	
	public Customer(String Name, String email, String phoneNo, String NID, String address, String sex )
	{
		this.Name = Name;
		this.email = email;
		this.phoneNo = phoneNo;
		this.CNIC = NID;
		this.address = address;
		this.sex = sex;
	}
    


	
	public String toString()
	{
		return  Name + "\n" + "\n" + email + "\n"
				+ phoneNo + "\n" + CNIC + "\n" + address + "\n" + sex
				+ "\n";
	}
}
