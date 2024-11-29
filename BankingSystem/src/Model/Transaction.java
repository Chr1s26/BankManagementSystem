package Model;

import java.sql.Timestamp;

public class Transaction {
	
	private int id;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	private Employee createdBy;
	private Employee updatedBy;
	
	public Transaction() {
	
	}
	
	public Transaction(int id, Employee createdBy,Employee updatedBy) {
		this.id = id;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}
	
	public Transaction(int id, Employee createdBy,Employee updatedBy,Timestamp createdAt,Timestamp updatedAt) {
		this.id = id;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Employee getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Employee createdBy) {
		this.createdBy = createdBy;
	}
	public Employee getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Employee updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public String toString() {
		return "TransactionId = "+id;
	}
	
	
}
