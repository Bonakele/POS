package com.pos.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tblReturnItem")
public class ReturnItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5453676832429987690L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ReturnItem_Id")
	private int id;

	@Column(name = "ReturnItem_Reason")
	private String Reason;

	@Column(name = "ReturnItem_ReturnDate")
	private Date returnDate;

	@Column(name = "ReturnItem_Amount")
	private double returnAmount;

	// Relationships

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Returning_Employee", joinColumns = { @JoinColumn(name = "ReturnItem_Id") }, inverseJoinColumns = { @JoinColumn(name = "Employee_EmpNum") })
	private Set<Employee> employee;

//	@ManyToOne
//	@JoinColumn(name = "Cashier_EmpNum")
//	private Cashier cashier;
//
//	@ManyToOne
//	@JoinColumn(name = "Admin_EmpNum")
//	private Admin admin;

	@ManyToOne
	@JoinColumn(name = "Client_Id")
	private Client client;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Item_Return", joinColumns = { @JoinColumn(name = "ReturnItem_Id") }, inverseJoinColumns = { @JoinColumn(name = "Item_Id") })
	private Set<Item> item;

	public ReturnItem() {

		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReason() {
		return Reason;
	}

	public void setReason(String reason) {
		Reason = reason;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public double getReturnAmount() {
		return returnAmount;
	}

	public void setReturnAmount(double returnAmount) {
		this.returnAmount = returnAmount;
	}

	public Set<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(Set<Employee> employee) {
		this.employee = employee;
	}
	

//	public Cashier getCashier() {
//		return cashier;
//	}
//
//	public void setCashier(Cashier cashier) {
//		this.cashier = cashier;
//	}
//
//	public Admin getAdmin() {
//		return admin;
//	}
//
//	public void setAdmin(Admin admin) {
//		this.admin = admin;
//	}

	public Set<Item> getItem() {
		return item;
	}

	public void setItem(Set<Item> item) {
		this.item = item;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
