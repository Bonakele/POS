package com.pos.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="tblSales")
public class Sales implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int  sale_Id;
	@Column(name="Sale_paymentType")
	private String paymentType;
	@Column(name="Sale_totalAmount")
	private double totalAmount;
	@Column(name="Sale_amountPayed")
	private double amountPayed;
	@Column(name="Sale_change")
	private double change;
	@Column(name="Sale_date")
	private Date date=new Date();
	
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="Transactions",joinColumns = { 
			@JoinColumn(name = "sale_Id") }, 
			inverseJoinColumns = { @JoinColumn(name = "item_Id") })
	private List<Item> items;
	
	@ManyToOne
	@JoinColumn(name=" Cashier_Id")
	private Cashier cashier;
	
	public Sales() {
	
	}


	public Sales(int sale_Id, String paymentType, double totalAmount, Date date) {

		this.sale_Id = sale_Id;
		this.paymentType = paymentType;
		this.totalAmount = totalAmount;
		this.date = date;
	}



	public double getTotalAmount() {
		return totalAmount;
	}



	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}



	public Cashier getCashier() {
		return cashier;
	}



	public void setCashier(Cashier cashier) {
		this.cashier = cashier;
	}



	public int getSale_Id() {
		return sale_Id;
	}

	public void setSale_Id(int sale_Id) {
		this.sale_Id = sale_Id;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getAmountPayed() {
		return amountPayed;
	}


	public void setAmountPayed(double amountPayed) {
		this.amountPayed = amountPayed;
	}


	public double getChange() {
		return change;
	}


	public void setChange(double change) {
		this.change = change;
	}


	public List<Item> getItems() {
		return items;
	}


	public void setItems(List<Item> items) {
		this.items = items;
	}

	
	
	
}
