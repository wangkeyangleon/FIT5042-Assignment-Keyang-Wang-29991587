package assignment.controllers;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import assignment.repository.entities.Customer;
import assignment.repository.entities.CustomerContact;
import assignment.repository.entities.Staffgroup;

/**
 * @author:Keyang Wang
 * @version:
 * @create time：28 Sep 2020 4:42:09 pm
 * @desc:
 */
@RequestScoped
@Named(value = "staff")
public class Staff implements Serializable {
	private int staffId;
	private String staffFname;
	private String staffLname;
	private Date staffBirthdate;
	private String staffCity;
	private String staffStreet;
	private String staffState;
	private BigDecimal staffPostcode;
	private String staffEmail;
	private BigDecimal staffPhone;
	private String staffPassword;
	private String staffType;
	private String staffGender;

	private CustomerContact customerContact;
	private int customerContactId;
	private Customer customer;
	private int customerId;
	private Staffgroup staffgroup;
	private int staffGroupId;
	private Set<assignment.repository.entities.Staff> staffs;

	public Staff() {

	}

	public Staff(int staffId, String staffFname, String staffLname, Date staffBirthdate, String staffCity,
			String staffStreet, String staffState, BigDecimal staffPostcode, String staffEmail, BigDecimal staffPhone,
			String staffPassword, String staffType, String staffGender, CustomerContact customerContact,
			Customer customer, Staffgroup staffgroup) {
		super();
		this.staffId = staffId;
		this.staffFname = staffFname;
		this.staffLname = staffLname;
		this.staffBirthdate = staffBirthdate;
		this.staffCity = staffCity;
		this.staffStreet = staffStreet;
		this.staffState = staffState;
		this.staffPostcode = staffPostcode;
		this.staffEmail = staffEmail;
		this.staffPhone = staffPhone;
		this.staffPassword = staffPassword;
		this.staffType = staffType;
		this.staffGender = staffGender;
		this.customerContact = customerContact;
		this.customer = customer;
		this.staffgroup = staffgroup;
	}

	public Staffgroup getStaffgroup() {
		return staffgroup;
	}

	public void setStaffgroup(Staffgroup staffgroup) {
		this.staffgroup = staffgroup;
	}

	public long getStaffGroupId() {
		return staffGroupId;
	}

	public void setStaffGroupId(int staffGroupId) {
		this.staffGroupId = staffGroupId;
	}

	public long getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getStaffFname() {
		return staffFname;
	}

	public void setStaffFname(String staffFname) {
		this.staffFname = staffFname;
	}

	public String getStaffLname() {
		return staffLname;
	}

	public void setStaffLname(String staffLname) {
		this.staffLname = staffLname;
	}

	public Date getStaffBirthdate() {
		return staffBirthdate;
	}

	public void setStaffBirthdate(Date staffBirthdate) {
		
		this.staffBirthdate = staffBirthdate;
	}

	public String getStaffCity() {
		return staffCity;
	}

	public void setStaffCity(String staffCity) {
		this.staffCity = staffCity;
	}

	public String getStaffStreet() {
		return staffStreet;
	}

	public void setStaffStreet(String staffStreet) {
		this.staffStreet = staffStreet;
	}

	public String getStaffState() {
		return staffState;
	}

	public void setStaffState(String staffState) {
		this.staffState = staffState;
	}

	public BigDecimal getStaffPostcode() {
		return staffPostcode;
	}

	public void setStaffPostcode(BigDecimal staffPostcode) {
		this.staffPostcode = staffPostcode;
	}

	public String getStaffEmail() {
		return staffEmail;
	}

	public void setStaffEmail(String staffEmail) {
		this.staffEmail = staffEmail;
	}

	public BigDecimal getStaffPhone() {
		return staffPhone;
	}

	public void setStaffPhone(BigDecimal staffPhone) {
		this.staffPhone = staffPhone;
	}

	public String getStaffPassword() {
		return staffPassword;
	}

	public void setStaffPassword(String staffPassword) {
		this.staffPassword = staffPassword;
	}

	public String getStaffType() {
		return staffType;
	}

	public void setStaffType(String staffType) {
		this.staffType = staffType;
	}

	public String getStaffGender() {
		return staffGender;
	}

	public void setStaffGender(String staffGender) {
		this.staffGender = staffGender;
	}

	public CustomerContact getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(CustomerContact customerContact) {
		this.customerContact = customerContact;
	}

	public long getCustomerContactId() {
		return customerContactId;
	}

	public void setCustomerContactId(int customerContactId) {
		this.customerContactId = customerContactId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Set<assignment.repository.entities.Staff> getStaffs() {
		return staffs;
	}

	public void setStaffs(Set<assignment.repository.entities.Staff> staffs) {
		this.staffs = staffs;
	}

	@Override
	public String toString() {
		return "Staff [staffId=" + staffId + ", staffAccount=" + ", staffFname=" + staffFname + ", staffLname="
				+ staffLname + ", staffBirthdate=" + staffBirthdate + ", staffCity=" + staffCity + ", staffStreet="
				+ staffStreet + ", staffState=" + staffState + ", staffPostcode=" + staffPostcode + ", staffEmail="
				+ staffEmail + ", staffPhone=" + staffPhone + ", staffPassword=" + staffPassword + ", staffType="
				+ staffType + ", staffGender=" + staffGender + ", customerContact=" + customerContact + ", customer="
				+ customer + ", staffGroup=" + staffgroup + "]";
	}

}
