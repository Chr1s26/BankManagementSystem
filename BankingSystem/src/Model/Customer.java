package Model;

import java.sql.Timestamp;
import java.sql.Date;

public class Customer {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String address;
	private Date dateOfBirth;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	private Employee createdBy;
	private Employee updatedBy;
	
	public Customer() {
		
	}
	
	public Customer(int id, String firstName, String lastName, String email, String phoneNumber, String address,Date dateOfBirth) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
	}
	
	public Customer(String firstName, String lastName, String email, String phoneNumber, String address,Date dateOfBirth) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfirstName() {
		return firstName;
	}

	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getlastName() {
		return lastName;
	}

	public void setlastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getdateOfBirth() {
		return dateOfBirth;
	}

	public void setdateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Employee getcreatedBy() {
		return createdBy;
	}

	public void setcreatedBy(Employee createdBy) {
		this.createdBy = createdBy;
	}

	public Employee getupdatedBy() {
		return updatedBy;
	}

	public void setupdatedBy(Employee updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}


	public Timestamp getCreatedAt() {
		return createdAt;
	}

	@Override
	public String toString() {
		return firstName+" "+lastName;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
	    Customer customer = (Customer) obj;
	    return id == customer.id; 
	}

	
}
