package com.pos.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;

@NamedNativeQuery(name = "Go.All", query = "Select * from order_stock where stock_id = 1", resultClass = Client.class)
@NamedNativeQueries({ @NamedNativeQuery(name = "Go.ByOrderedStock", query = "SELECT stock_id FROM order_stock os where order_id =?", resultClass = Client.class)
/* @NamedNativeQuery(name = "", query = ""), */})
@Entity
@Table(name = "tblClient")
public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 215025760455610260L;

	@Id
	@Column(name = "Client_Id")
	private String idNum;
	@Column(name = "Client_FirstName")
	private String firstName;
	@Column(name = "Client_Surname")
	private String surname;
	@Column(name = "Client_Email")
	@Email
	private String email;
	@Column(name = "Client_ContactNum")
	private String contactNum;
	@Column(name = "Client_ContactWork")
	private String contactWork;

	// Relationships

	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	private Set<Order> order;

	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	private Set<ReturnItem> returnItem;

	public Client() {
		// TODO Auto-generated constructor stub
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNum() {
		return contactNum;
	}

	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}

	public String getContactWork() {
		return contactWork;
	}

	public void setContactWork(String contactWork) {
		this.contactWork = contactWork;
	}

	public Set<Order> getOrder() {
		return order;
	}

	public void setOrder(Set<Order> order) {
		this.order = order;
	}

	public Set<ReturnItem> getReturnItem() {
		return returnItem;
	}

	public void setReturnItem(Set<ReturnItem> returnItem) {
		this.returnItem = returnItem;
	}

}
