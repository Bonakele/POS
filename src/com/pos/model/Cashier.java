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
@XmlRootElement(name = "Cashier")
@XmlAccessorType(XmlAccessType.FIELD)
@DiscriminatorValue("Cashier")
public class Cashier extends Employee implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2159513940081762246L;

	public Cashier() {
		super();
	}
	

}
