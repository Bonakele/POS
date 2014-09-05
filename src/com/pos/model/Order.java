package com.pos.model;

import java.io.Serializable;

import java.util.Date;
import java.util.HashSet;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@NamedQueries({
		@NamedQuery(name = "Order.ById", query = "from Order where id=? "),
		@NamedQuery(name = "Order.ByAllOrders", query = "from Order"),
		@NamedQuery(name = "Order.ByOrderAmount", query = "select sum(amount) from Order group by sysdate()"), })
// /*where dateIssued = current_date()*/
@Entity
@Table(name = "tblOrder")
@XmlRootElement(name = "Order")
@XmlAccessorType(XmlAccessType.FIELD)
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
	private Date dateIssued = new Date();
	@Column(name = "Order_DateDelivered")
	private Date dateDeliverd;
	@Column(name = "Order_Status")
	private String status;
	@Column(name = "Order_Comment")
	private String comment;

	@Column(name = "Order_Amount")
	private double amount;

	// Relationships
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Order_Item", joinColumns = { @JoinColumn(name = "Order_Id") }, inverseJoinColumns = { @JoinColumn(name = "Item_Id") })
	private Set<Item> item = new HashSet<Item>();;

	@ManyToOne
	@JoinColumn(name = "Client_Id")
	private Client client;

	@OneToOne
	@JoinColumn(name = "Sale_Id")
	private Sales sale;

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

	public Sales getSale() {
		return sale;
	}

	public void setSale(Sales sale) {
		this.sale = sale;
	}

}
