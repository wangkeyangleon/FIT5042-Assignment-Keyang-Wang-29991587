package assignment.repository.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.Length;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;

import java.math.BigDecimal;
import java.util.List;

/**
 * The persistent class for the CUSTOMER database table.
 * 
 */
@Entity
@NamedQueries({
		@NamedQuery(name = Customer.GET_ALL_QUERY_NAME, query = "SELECT c FROM Customer c order by c.cusId desc"),
		@NamedQuery(name = Customer.GET_ALL_QUERY_NAME1, query = "SELECT c FROM Customer c where c.cusName = ?1 order by c.cusId desc"),
		@NamedQuery(name = Customer.GET_ALL_QUERY_NAME2, query = "SELECT c FROM Customer c where c.staff =?1 order by c.cusId desc") })
public class Customer implements Serializable {
	public static final String GET_ALL_QUERY_NAME = "Customer.getAll";
	public static final String GET_ALL_QUERY_NAME1 = "Customer.getAllName";
	public static final String GET_ALL_QUERY_NAME2 = "Customer.getAllStaff";
	private int cusId;
	private String cusCity;
	private String cusEmail;
	private String cusName;
	private BigDecimal cusPhone;
	private BigDecimal cusPostcode;
	private String cusState;
	private String cusStreet;
	private IndustryType industryType;
	private Staff staff;
	private int staffId;
	private List<CustomerContact> customerContacts;

	public Customer() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "CUS_ID")
	public int getCusId() {
		return this.cusId;
	}

	public void setCusId(int cusId) {
		this.cusId = cusId;
	}

	@Column(name = "CUS_CITY")
	public String getCusCity() {
		return this.cusCity;
	}

	public void setCusCity(String cusCity) {
		this.cusCity = cusCity;
	}

	@Column(name = "CUS_EMAIL")
	@Email(message = "please follow the email format")
	public String getCusEmail() {
		return this.cusEmail;
	}

	public void setCusEmail(String cusEmail) {
		this.cusEmail = cusEmail;
	}

	@Column(name = "CUS_NAME")
	public String getCusName() {
		return this.cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	@Column(name = "CUS_PHONE")
	public BigDecimal getCusPhone() {
		return this.cusPhone;
	}

	public void setCusPhone(BigDecimal cusPhone) {
		this.cusPhone = cusPhone;
	}

	@Column(name = "CUS_POSTCODE")
	public BigDecimal getCusPostcode() {
		return this.cusPostcode;
	}

	public void setCusPostcode(BigDecimal cusPostcode) {
		this.cusPostcode = cusPostcode;
	}

	@Column(name = "CUS_STATE")
	public String getCusState() {
		return this.cusState;
	}

	public void setCusState(String cusState) {
		this.cusState = cusState;
	}

	@Column(name = "CUS_STREET")
	public String getCusStreet() {
		return this.cusStreet;
	}

	public void setCusStreet(String cusStreet) {
		this.cusStreet = cusStreet;
	}

	// bi-directional many-to-one association to IndustryType
	@ManyToOne
	@JoinColumn(name = "INDUSTRY_ID")
	public IndustryType getIndustryType() {
		return this.industryType;
	}

	public void setIndustryType(IndustryType industryType) {
		this.industryType = industryType;
	}

	// bi-directional many-to-one association to Staff
	@ManyToOne
	@JoinColumn(name = "STAFF_ID")
	public Staff getStaff() {
		return this.staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	// bi-directional many-to-one association to CustomerContact
	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER,cascade = {CascadeType.ALL,CascadeType.REMOVE})
	public List<CustomerContact> getCustomerContacts() {
		return this.customerContacts;
	}

	public void setCustomerContacts(List<CustomerContact> customerContacts) {
		this.customerContacts = customerContacts;
	}

	public CustomerContact addCustomerContact(CustomerContact customerContact) {
		getCustomerContacts().add(customerContact);
		customerContact.setCustomer(this);

		return customerContact;
	}

	public CustomerContact removeCustomerContact(CustomerContact customerContact) {
		getCustomerContacts().remove(customerContact);
		customerContact.setCustomer(null);

		return customerContact;
	}
//	@Column(name = "STAFF_ID")
//	public int getStaffId() {
//		return staffId;
//	}
//
//	public void setStaffId(int staffId) {
//		this.staffId = staffId;
//	}

}