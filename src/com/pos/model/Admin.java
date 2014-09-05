package com.pos.model;

import java.io.Serializable;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "tblEmployee")
@XmlRootElement(name = "Admin")
@XmlAccessorType(XmlAccessType.FIELD)
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
	

}
