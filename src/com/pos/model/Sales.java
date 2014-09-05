package com.pos.model;

import java.io.Serializable;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@NamedQueries({
		@NamedQuery(name = "Sales.ById", query = "from Sales where id=? "),
		@NamedQuery(name = "Sales.ByAllSales", query = "from Sales"),
		@NamedQuery(name = "Sales.ByCashierPerDay", query = "SELECT YEAR(date) as SalesYear, MONTH(date) as SalesMonth,DAY(date) as Salesday,SUM(totalAmount) AS TotalSales FROM Sales GROUP BY YEAR(date), MONTH(date) ORDER BY YEAR(date), MONTH(date)"), 
		/*@NamedQuery(name = "Sales.ByCashier", query = "SELECT employee, SUM(totalAmount), date FROM Sales WHERE employee = ?, GROUP BY DAY(date)")*/})
@Entity
@Table(name = "tblSales")
@XmlRootElement(name = "Sales")
@XmlAccessorType(XmlAccessType.FIELD)
public class Sales implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Sale_Id")
	private int id;
	@Column(name = "Sale_PaymentType")
	private String paymentType;
	@Column(name = "Sale_TotalAmount")
	private double totalAmount;
	@Column(name = "Sale_AmountPayed")
	private double amountPayed;
	@Column(name = "Sale_Change")
	private double change;
	@Column(name = "Sale_Date")
	private Date date = new Date();

	// Relationships
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "Item_Sales", joinColumns = { @JoinColumn(name = "Sale_Id") }, inverseJoinColumns = { @JoinColumn(name = "Item_Id") })
	private Set<Item> item = new HashSet<Item>();

	@ManyToOne
	@JoinColumn(name = "Employee_EmpNum")
	private Employee employee;

	@OneToMany
	private Set<ReturnItem> returnItem = new HashSet<ReturnItem>();

	@OneToOne(mappedBy = "sale", cascade = CascadeType.ALL)
	private Order order;
	
	@OneToOne(mappedBy = "sale", cascade = CascadeType.ALL)
	private CashUp cashUp;

	@OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
	private Set<Exchange> exchangeList =  new HashSet<Exchange>();
	
	public Sales() {

	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public CashUp getCashUp() {
		return cashUp;
	}

	public void setCashUp(CashUp cashUp) {
		this.cashUp = cashUp;
	}

	public Set<Item> getItem() {
		return item;
	}

	public void setItem(Set<Item> item) {
		this.item = item;
	}

	public Set<ReturnItem> getReturnItem() {
		return returnItem;
	}

	public void setReturnItem(Set<ReturnItem> returnItem) {
		this.returnItem = returnItem;
	}

	public Set<Exchange> getExchangeList() {
		return exchangeList;
	}

	public void setExchangeList(Set<Exchange> exchangeList) {
		this.exchangeList = exchangeList;
	}

	
	
	

}
