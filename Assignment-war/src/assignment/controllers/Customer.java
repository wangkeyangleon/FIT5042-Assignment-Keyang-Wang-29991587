package assignment.controllers;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;

import assignment.repository.entities.IndustryType;
import assignment.repository.entities.Staff;

/**
 * @author:Keyang Wang
 * @version:
 * @create time：26 Sep 2020 8:22:11 pm
 * @desc:
 */
@RequestScoped
@Named(value = "customer")
public class Customer implements Serializable {
	private int cusId;
	private String cusName;
	private String cusStreet;
	private String cusCity;
	private String cusState;
	private BigDecimal cusPostcode;
	private BigDecimal cusPhone;
	private String cusEmail;
	private IndustryType industryType;
	private Staff staff;
	private Integer idustryTypeId;
	private String induType;
	private int staffId;
	private String staffFname;
	private String staffLname;
	private String staffPassword;
	private Date staffBirthDate;
	private String staffCity;
	private String staffStreet;
	private String staffState;
	private BigDecimal staffPostcode;
	private String staffType;
	private String staffEmail;
	private String staffGender;
	private BigDecimal staffPhone;

	private Set<assignment.repository.entities.Customer> customers;

	public Customer() {

	}

	public Customer(int cusId, String cusName, String cusStreet, String cusCity, String cusState,
			BigDecimal cusPostcode, BigDecimal cusPhone, String cusEmail, IndustryType industryType, Staff staff) {
		super();
		this.cusId = cusId;
		this.cusName = cusName;
		this.cusStreet = cusStreet;
		this.cusCity = cusCity;
		this.cusState = cusState;
		this.cusPostcode = cusPostcode;
		this.cusPhone = cusPhone;
		this.cusEmail = cusEmail;
		this.industryType = industryType;
		this.staff = staff;
	}

	public long getCusId() {
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

	public String getCusStreet() {
		return cusStreet;
	}

	public void setCusStreet(String cusStreet) {
		this.cusStreet = cusStreet;
	}

	public String getCusCity() {
		return cusCity;
	}

	public void setCusCity(String cusCity) {
		this.cusCity = cusCity;
	}

	public String getCusState() {
		return cusState;
	}

	public void setCusState(String cusState) {
		this.cusState = cusState;
	}

	public BigDecimal getCusPostcode() {
		return cusPostcode;
	}

	public void setCusPostcode(BigDecimal cusPostcode) {
		this.cusPostcode = cusPostcode;
	}

	public BigDecimal getCusPhone() {
		return cusPhone;
	}

	public void setCusPhone(BigDecimal cusPhone) {
		this.cusPhone = cusPhone;
	}

	public String getCusEmail() {
		return cusEmail;
	}

	public void setCusEmail(String cusEmail) {
		this.cusEmail = cusEmail;
	}

	public IndustryType getIndustryType() {
		return industryType;
	}

	public void setIndustryType(IndustryType industryType) {
		this.industryType = industryType;
	}

	public String getInduType() {
		return induType;
	}

	public void setInduType(String induType) {
		this.induType = induType;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public int getIdustryTypeId() {
		return idustryTypeId;
	}

	public void setIdustryTypeId(int idustryTypeId) {
		this.idustryTypeId = idustryTypeId;
	}

	public int getStaffId() {
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


	public Date getStaffBirthDate() {
		return staffBirthDate;
	}

	public void setStaffBirthDate(Date staffBirthDate) {
		this.staffBirthDate = staffBirthDate;
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

	public String getStaffType() {
		return staffType;
	}

	public void setStaffType(String staffType) {
		this.staffType = staffType;
	}

	public String getStaffEmail() {
		return staffEmail;
	}

	public void setStaffEmail(String staffEmail) {
		this.staffEmail = staffEmail;
	}

	public String getStaffGender() {
		return staffGender;
	}

	public void setStaffGender(String staffGender) {
		this.staffGender = staffGender;
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

	public Set<assignment.repository.entities.Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<assignment.repository.entities.Customer> customers) {
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "Customer [cusId=" + cusId + ", cusName=" + cusName + ", cusStreet=" + cusStreet + ", cusCity=" + cusCity
				+ ", cusState=" + cusState + ", cusPostcode=" + cusPostcode + ", cusPhone=" + cusPhone + ", cusEmail="
				+ cusEmail + ", industryType=" + industryType + ", staff=" + staff + "]";
	}

}
