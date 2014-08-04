package com.pos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "tblEmployee")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Employee_Type", discriminatorType = DiscriminatorType.STRING)
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1234152722053402629L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Employee_EmpNum")
	private int empNum;

	@Column(name = "Employee_SAId")
	@NotNull
	private String SA_id;

	@Column(name = "Employee_Name")
	@NotNull
	private String firstName;

	@Column(name = "Employee_Surname")
	@NotNull
	private String surname;

	@Column(name = "Employee_Title")
	private String title;

	@Column(name = "Employee_TelNumberWork")
	@Length(min = 10, max = 10)
	// telNumberWork need to be 10 chars
	private String telNumberWork;

	@Column(name = "Employee_TelNumberMobile")
	@Length(min = 10, max = 10)
	// telNumberWork need to be 10 chars
	private String telNumberMobile;

	@Column(name = "Employee_Password")
	private String password;

	@Transient
	private String confirm_password;

	// Relationships
	@ManyToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private Set<ReturnItem> returnItem;
	
	@OneToMany(mappedBy="cashier",cascade=CascadeType.ALL)
	private List<Sales> sales;
	
	@OneToMany(mappedBy="cashier",cascade=CascadeType.ALL)
	private List<CashUp> cashUp=new ArrayList<CashUp>();

	public Employee() {

		// TODO Auto-generated constructor stub
	}

	public int getEmpNum() {
		return empNum;
	}

	public void setEmpNum(int empNum) {
		this.empNum = empNum;
	}

	public String getSA_id() {
		return SA_id;
	}

	public void setSA_id(String sA_id) {
		SA_id = sA_id;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTelNumberWork() {
		return telNumberWork;
	}

	public void setTelNumberWork(String telNumberWork) {
		this.telNumberWork = telNumberWork;
	}

	public String getTelNumberMobile() {
		return telNumberMobile;
	}

	public void setTelNumberMobile(String telNumberMobile) {
		this.telNumberMobile = telNumberMobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm_password() {
		return confirm_password;
	}

	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}

	public Set<ReturnItem> getReturnItem() {
		return returnItem;
	}

	public void setReturnItem(Set<ReturnItem> returnItem) {
		this.returnItem = returnItem;
	}

	public List<Sales> getSales() {
		return sales;
	}

	public void setSales(List<Sales> sales) {
		this.sales = sales;
	}

}
