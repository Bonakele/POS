package com.pos.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;

@NamedQueries({
	@NamedQuery(name = "Client.ById", query = "from Client where idNum=? "),
	@NamedQuery(name = "Client.ByAllClients", query = "from Client"), })

@Entity
@Table(name = "tblClient")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 215025760455610260L;

	@Id
	@Column(name = "Client_Id")
	private String idNum;
	@Column(name = "Client_FirstName")
	private String firstName;
	@Column(name = "Client_Surname")
	private String surname;
	@Column(name = "Client_Email")
	@Email
	private String email;
	@Column(name = "Client_ContactNum")
	private String contactNum;
	@Column(name = "Client_ContactWork")
	private String contactWork;
	
	@Column(name = "Client_Password")
	private String password;

	@Transient
	private String confirm_password;

	// Relationships

	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<Order> order;

	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<ReturnItem> returnItem;

	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<Exchange> exchange;
	
	
	public Client() {
		// TODO Auto-generated constructor stub
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNum() {
		return contactNum;
	}

	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}

	public String getContactWork() {
		return contactWork;
	}

	public void setContactWork(String contactWork) {
		this.contactWork = contactWork;
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

	public Set<Exchange> getExchange() {
		return exchange;
	}

	public void setExchange(Set<Exchange> exchange) {
		this.exchange = exchange;
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
	
	

}
