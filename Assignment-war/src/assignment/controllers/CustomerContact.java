package assignment.controllers;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import assignment.repository.entities.Customer;
import assignment.repository.entities.Staff;

/**
 * @author:Keyang Wang
 * @version:
 * @create time：23 Sep 2020 6:30:06 pm
 * @desc: change this license header, choose license header in project
 *        properties
 */
@RequestScoped
@Named(value = "customerContact")
public class CustomerContact implements Serializable {

	private int conId;
	private String conFname;
	private String conLname;
	private String conGender;
	private String conStreet;
	private String conCity;
	private String conState;
	private BigDecimal conPostcode;
	private String conEmail;
	private BigDecimal conPhone;
	private Customer customer;
	private int cusId;
	private String cusName;
	private Staff staff;
	private int staffId;
	private Set<assignment.repository.entities.CustomerContact> customerContacts;

	public CustomerContact() {

	}

	public CustomerContact(int id, String conFname, String conLname, String conGender, String conStreet, String conCity,
			String conState, BigDecimal conPostcode, String conEmail, BigDecimal conPhone, Customer customer,
			Staff staff, Set<assignment.repository.entities.CustomerContact> customerContacts) {
		this.conId = id;
		this.conFname = conFname;
		this.conLname = conLname;
		this.conGender = conGender;
		this.conStreet = conStreet;
		this.conCity = conCity;
		this.conState = conState;
		this.conPostcode = conPostcode;
		this.conEmail = conEmail;
		this.conPhone = conPhone;
		this.customer = customer;
		this.staff = staff;
		this.customerContacts = customerContacts;
	}

	public int getConId() {
		return conId;
	}

	public void setConId(int conId) {
		this.conId = conId;
	}

	public String getConFname() {
		return conFname;
	}

	public void setConFname(String conFname) {
		this.conFname = conFname;
	}

	public String getConLname() {
		return conLname;
	}

	public void setConLname(String conLname) {
		this.conLname = conLname;
	}

	public String getConGender() {
		return conGender;
	}

	public void setConGender(String conGender) {
		this.conGender = conGender;
	}

	public String getConStreet() {
		return conStreet;
	}

	public void setConStreet(String conStreet) {
		this.conStreet = conStreet;
	}

	public String getConCity() {
		return conCity;
	}

	public void setConCity(String conCity) {
		this.conCity = conCity;
	}

	public String getConState() {
		return conState;
	}

	public void setConState(String conState) {
		this.conState = conState;
	}

	public BigDecimal getConPostcode() {
		return conPostcode;
	}

	public void setConPostcode(BigDecimal conPostcode) {
		this.conPostcode = conPostcode;
	}

	public String getConEmail() {
		return conEmail;
	}

	public void setConEmail(String conEmail) {
		this.conEmail = conEmail;
	}

	public BigDecimal getConPhone() {
		return conPhone;
	}

	public void setConPhone(BigDecimal conPhone) {
		this.conPhone = conPhone;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Set<assignment.repository.entities.CustomerContact> getCustomerContacts() {
		return customerContacts;
	}

	public void setCustomerContacts(Set<assignment.repository.entities.CustomerContact> customerContacts) {
		this.customerContacts = customerContacts;
	}
	

	public int getCusId() {
		return cusId;
	}

	public void setCusId(int cusId) {
		this.cusId = cusId;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	@Override
	public String toString() {
		return "CustomerContact [id=" + conId + ", conFname=" + conFname + ", conLname=" + conLname + ", conGender="
				+ conGender + ", conStreet=" + conStreet + ", conCity=" + conCity + ", conState=" + conState
				+ ", conPostcode=" + conPostcode + ", conEmail=" + conEmail + ", conPhone=" + conPhone + ", customer="
				+ customer + ", staff=" + staff + ", customerContacts=" + customerContacts + "]";
	}

}
