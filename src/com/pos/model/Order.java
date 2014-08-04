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
@Table(name = "tblOrder")
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Order_Id")
	private int id;
	@Column(name = "Order_DateIssued")
	private Date dateIssued;
	@Column(name = "Order_DateDelivered")
	private Date dateDeliverd;
	@Column(name = "Order_Status")
	private String status;
	@Column(name = "Order_Comment")
	private String comment;
	
	@Column(name = "Order_Amount")
	private double amount;

	//Relationships
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="Order_Item",
	joinColumns={@JoinColumn(name="Order_Id")}, 
	inverseJoinColumns={@JoinColumn(name="Item_Id")})
	private Set<Item> item;
	
//	@ManyToMany(mappedBy="order", cascade = CascadeType.ALL)
//	private Set<Client> client;
	
	@ManyToOne
	@JoinColumn(name = "Client_Id")
	private Client client;

	public Order() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateIssued() {
		return dateIssued;
	}

	public void setDateIssued(Date dateIssued) {
		this.dateIssued = dateIssued;
	}

	public Date getDateDeliverd() {
		return dateDeliverd;
	}

	public void setDateDeliverd(Date dateDeliverd) {
		this.dateDeliverd = dateDeliverd;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	

//	public Set<Client> getClient() {
//		return client;
//	}
//
//	public void setClient(Set<Client> client) {
//		this.client = client;
//	}

	
}
