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
	@NamedQuery(name = "CashUp.ById", query = "from CashUp where id=? "),
	@NamedQuery(name = "CashUp.ByAllCashUps", query = "from CashUp"), })

@Entity
@Table(name="tblCashUp")
@XmlRootElement(name = "CashUp")
@XmlAccessorType(XmlAccessType.FIELD)
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
	private Date cashUpDate = new Date();
	@Column(name="CashUp_Amount")
	private double amount;
	@Column(name="CashUp_Status")
	private String status;
	@Column(name="CashUp_Comments")
	private String comments;
	@Column(name="CashUp_RegisterAmount")
	private double registerAmount;

	
	
	//Relationships
	
	@OneToMany(mappedBy="cashUp",cascade=CascadeType.ALL)
	private Set<Employee> employee = new HashSet<Employee>();
	
	@ManyToOne
	@JoinColumn(name = "OverallCashUp_Id")
	private OverallCashUp overallCashUp;
	
	@OneToOne
	@JoinColumn(name = "Sale_Id")
	private Sales sale;
	
	public CashUp() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCashUpDate() {
		return cashUpDate;
	}
	public void setCashUpDate(Date cashUpDate) {
		this.cashUpDate = cashUpDate;
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

	public double getRegisterAmount() {
		return registerAmount;
	}
	public void setRegisterAmount(double registerAmount) {
		this.registerAmount = registerAmount;
	}

	public Set<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(Set<Employee> employee) {
		this.employee = employee;
	}

	public Sales getSale() {
		return sale;
	}

	public void setSale(Sales sale) {
		this.sale = sale;
	}

	public OverallCashUp getOverallCashUp() {
		return overallCashUp;
	}

	public void setOverallCashUp(OverallCashUp overallCashUp) {
		this.overallCashUp = overallCashUp;
	}



	
	
	

}
