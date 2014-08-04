package com.pos.model;

import java.io.Serializable;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="tblCashUp")
public class CashUp implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8504911008308436617L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CashUp_Id")
	private int id;
	@Column(name="CashUp_Date")
	private Date cDate=new Date();
	@Column(name="CashUp_Amount")
	private double amount;
	@Column(name="CashUp_Status")
	private String status;
	@Column(name="CashUp_Comments")
	private String comments;
	@Column(name="CashUp_RegisterAmount")
	private double registerAmount;
	@Column(name="CashUp_TotalCash")
	private double totalCashUp;
	@ManyToOne
	@JoinColumn(name="empId")
	private Cashier cashier;
	
	
//	@OneToOne
//	@PrimaryKeyJoinColumn
//	private Cashier cashier1;
	
	
	
	
	
	public CashUp() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public double getTotalCashUp() {
		return totalCashUp;
	}
	public void setTotalCashUp(double totalCashUp) {
		this.totalCashUp = totalCashUp;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getcDate() {
		return cDate;
	}
	public void setcDate(Date cDate) {
		this.cDate = cDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Cashier getCashier() {
	return cashier;
}
public void setCashier(Cashier cashier) {
	this.cashier = cashier;
	}
	public double getRegisterAmount() {
		return registerAmount;
	}
	public void setRegisterAmount(double registerAmount) {
		this.registerAmount = registerAmount;
	}
//	public Cashier getCashier1() {
//	return cashier1;
//}
//public void setCashier1(Cashier cashier1) {	
//	this.cashier1 = cashier1;
//	}


	
	
	

}
