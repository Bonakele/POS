package com.pos.model;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "tblItem")
public class Item implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Item_Id")
	private int id;
	@Column(name = "Item_Name")
	private String itemName;
	@Column(name = "Item_Desciption")
	private String description;
	@Column(name = "Item_Quantity")
	private int quantity;
	@Column(name = "Item_Price")
	private double price;
	@Column(name = "Item_DiscountPerc")
	private double discountPerc;
	@Column(name = "Item_MarkDown")
	private double markDown;
	
	@Column(name = "Item_PriceAfterDiscMark")
	private double priceAfterDiscMark;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="Transactions",joinColumns = { 
			@JoinColumn(name = "item_Id") }, 
			inverseJoinColumns = { @JoinColumn(name = "sale_Id") })
	
	private List<Sales> salesList;
	
	//Relationships
	@ManyToMany( mappedBy = "item",cascade = CascadeType.ALL)
//	@JoinTable(name="Order_Item",
//	joinColumns={@JoinColumn(name="Order_Id")}, 
//	inverseJoinColumns={@JoinColumn(name="Item_Id")})
	private Set<Order> order;

	public Item() {
		// TODO Auto-generated constructor stub
	}

	public Set<Order> getOrder() {
		return order;
	}

	public void setOrder(Set<Order> order) {
		this.order = order;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscountPerc() {
		return discountPerc;
	}

	public void setDiscountPerc(double discountPerc) {
		this.discountPerc = discountPerc;
	}

	public double getMarkDown() {
		return markDown;
	}

	public void setMarkDown(double markDown) {
		this.markDown = markDown;
	}

	public double getPriceAfterDiscMark() {
		return priceAfterDiscMark;
	}

	public void setPriceAfterDiscMark(double priceAfterDiscMark) {
		this.priceAfterDiscMark = priceAfterDiscMark;
	}

	public List<Sales> getSalesList() {
		return salesList;
	}

	public void setSalesList(List<Sales> salesList) {
		this.salesList = salesList;
	}

	
}
