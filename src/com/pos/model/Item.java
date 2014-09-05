package com.pos.model;

import java.io.Serializable;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@NamedQueries({
	@NamedQuery(name = "Item.ById", query = "from Item where id=? "),
	@NamedQuery(name = "Item.ByAllItems", query = "from Item"),
	@NamedQuery(name="Item.Return",query="from Item where colour=? and type=? and size=?"),})

@Entity
@Table(name = "tblItem")
@XmlRootElement(name = "Item")
@XmlAccessorType(XmlAccessType.FIELD)
public class Item implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8291037227273676189L;
	/**
	 * 
	 */


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Item_Id")
	private int id;
	@Column(name = "Item_Name")
	private String itemName;
	@Column(name = "Item_Desciption")
	private String description;
	@Column(name = "Item_QuantityInStock")
	private int quantityInStock;
	@Column(name = "Item_QuantityRequested")
	private int quantityRequested;
	@Column(name = "Item_Price")
	private double price;
	@Column(name = "Item_DiscountPerc")
	private double discountPerc;
	@Column(name = "Item_MarkDown")
	private double markDown;
	@Column(name="Item_Colour")
	private String colour;
	@Column(name = "Item_Type")
	private String type;
	@Column(name = "Item_Size")
	private String size;
	
	@Column(name = "Item_PriceAfterDiscMark")
	private double priceAfterDiscMark;
	
	
	
	@Transient
	private int[] ids;
	
	
	
	//Relationships
	@ManyToMany(mappedBy = "item", cascade = CascadeType.ALL)
	private Set<Sales> sales = new HashSet<Sales>();
	
	@ManyToMany( mappedBy = "item",cascade = CascadeType.ALL)
	private Set<Order> order = new HashSet<Order>();
	
	@ManyToMany( mappedBy = "item",cascade = CascadeType.ALL)
	private Set<ReturnItem> returnItem = new HashSet<ReturnItem>();

	/*@ManyToMany( mappedBy = "item",cascade = CascadeType.ALL)
	private Set<Exchange> exchange = new HashSet<Exchange>();
	*/
	public Item() {
		// TODO Auto-generated constructor stub
		quantityInStock=0;
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

	public int getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
	
	public int getQuantityRequested() {
		return quantityRequested;
	}

	public void setQuantityRequested(int quantityRequested) {
		this.quantityRequested = quantityRequested;
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

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public double getPriceAfterDiscMark() {
		return priceAfterDiscMark;
	}

	public void setPriceAfterDiscMark(double priceAfterDiscMark) {
		this.priceAfterDiscMark = priceAfterDiscMark;
	}

	public int[] getIds() {
		return ids;
	}

	public void setIds(int[] ids) {
		this.ids = ids;
	}

	public Set<Sales> getSales() {
		return sales;
	}

	public void setSales(Set<Sales> sales) {
		this.sales = sales;
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

	/*public Set<Exchange> getExchange() {
		return exchange;
	}

	public void setExchange(Set<Exchange> exchange) {
		this.exchange = exchange;
	}*/



	
}
