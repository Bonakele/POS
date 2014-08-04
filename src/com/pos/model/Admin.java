package com.pos.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tblEmployee")
@DiscriminatorValue("Admin")
public class Admin extends Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 594012923244995111L;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "Admin_EmpNum")
//	private int empNum;
	
//	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
//	private Set<ReturnItem> returnItem;

	
	
//	public int getEmpNum() {
//		return empNum;
//	}
//	public void setEmpNum(int empNum) {
//		this.empNum = empNum;
//	}
//	public Set<ReturnItem> getReturnItem() {
//		return returnItem;
//	}
//	public void setReturnItem(Set<ReturnItem> returnItem) {
//		this.returnItem = returnItem;
//	}
}
