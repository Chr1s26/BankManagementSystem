package Model;

import java.sql.Date;

public class Employee {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String encryptPassword;
	private String phoneNumber;
	private String position;
	private double salary;
	private Branch branch;
	private String LoginToken;
	private Date confirmedAt;
	
	public Employee() {
		
	}
	
	public Employee(int id, String firstName, String lastName, String email, String phoneNumber, String position,double salary,Branch branch,String encryptPassword) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.position = position;
		this.salary = salary;
		this.branch = branch;
		this.encryptPassword = encryptPassword;
	}
	
	public Employee(int id, String firstName, String lastName, String email, String phoneNumber, String position,double salary) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.position = position;
		this.salary = salary;
		
	}
	
	public Employee(String firstName, String lastName, String email, String phoneNumber, String position,double salary,Branch branch,String encryptPassword) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.position = position;
		this.salary = salary;
		this.branch = branch;
		this.encryptPassword = encryptPassword;
		
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public String getEncryptPassword() {
		return encryptPassword;
	}

	public void setEncryptPassword(String encryptPassword) {
		this.encryptPassword = encryptPassword;
	}

	public String getLoginToken() {
		return LoginToken;
	}

	public void setLoginToken(String loginToken) {
		LoginToken = loginToken;
	}

	public Date getConfirmedAt() {
		return confirmedAt;
	}
	
	public void setConfirmedAt(Date confirmedAt) {
		this.confirmedAt = confirmedAt;
	}
	
	public boolean isConfirmed() {
		return this.confirmedAt != null;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", position=" + position + ", salary=" + salary + ", branch="
				+ branch + "]";
	}
	
	
}
