package assignment.repository.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the STAFF database table.
 * 
 */
@Entity
@NamedQueries({ @NamedQuery(name = Staff.GET_ALL_QUERY_NAME, query = "SELECT s FROM Staff s order by s.staffId desc"),
		@NamedQuery(name = Staff.GET_ALL_QUERY_NAME1, query = "SELECT s FROM Staff s where s.staffId = ?1 or s.staffEmail = ?1 or s.staffPhone = ?1 or s.staffPostcode = ?1 or s.staffCity =?1 or s.staffFname = ?1 or s.staffGender=?1 or s.staffLname = ?1  or s.staffState = ?1 or s.staffStreet = ?1 or s.staffType = ?1 order by s.staffId desc")

})
public class Staff implements Serializable {
	public static final String GET_ALL_QUERY_NAME = "Staff.getAll";
	public static final String GET_ALL_QUERY_NAME1 = "Staff.getAllStaff";
	private int staffId;
	private Date staffBirthdate;
	private String staffCity;
	private String staffEmail;
	private String staffFname;
	private String staffGender;
	private String staffLname;
	private String staffPassword;
	private BigDecimal staffPhone;
	private BigDecimal staffPostcode;
	private String staffState;
	private String staffStreet;
	private String staffType;

	private List<Customer> customers;
	private List<CustomerContact> customerContacts;

	public Staff() {
	}

	public Staff(int staffId, Date staffBirthdate, String staffCity, String staffEmail, String staffFname,
			String staffGender, String staffLname, String staffPassword, BigDecimal staffPhone,
			BigDecimal staffPostcode, String staffState, String staffStreet, String staffType) {
		this.staffId = staffId;
		this.staffBirthdate = staffBirthdate;
		this.staffCity = staffCity;
		this.staffEmail = staffEmail;
		this.staffFname = staffFname;
		this.staffGender = staffGender;
		this.staffLname = staffLname;
		this.staffPassword = staffPassword;
		this.staffPhone = staffPhone;
		this.staffPostcode = staffPostcode;
		this.staffState = staffState;
		this.staffStreet = staffStreet;
		this.staffType = staffType;

	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "STAFF_ID")
	public int getStaffId() {
		return this.staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "STAFF_BIRTHDATE")
	@Past(message = "the date must be the past time")
	public Date getStaffBirthdate() {
		return this.staffBirthdate;
	}

	public void setStaffBirthdate(Date staffBirthdate) {
		this.staffBirthdate = staffBirthdate;
	}

	@Column(name = "STAFF_CITY")
	public String getStaffCity() {
		return this.staffCity;
	}

	public void setStaffCity(String staffCity) {
		this.staffCity = staffCity;
	}

	@Column(name = "STAFF_EMAIL")
	@Email(message = "please follow the email format")
	public String getStaffEmail() {
		return this.staffEmail;
	}

	public void setStaffEmail(String staffEmail) {
		this.staffEmail = staffEmail;
	}

	@Column(name = "STAFF_FNAME")
	public String getStaffFname() {
		return this.staffFname;
	}

	public void setStaffFname(String staffFname) {
		this.staffFname = staffFname;
	}

	@Column(name = "STAFF_GENDER")
	public String getStaffGender() {
		return this.staffGender;
	}

	public void setStaffGender(String staffGender) {
		this.staffGender = staffGender;
	}

	@Column(name = "STAFF_LNAME")
	public String getStaffLname() {
		return this.staffLname;
	}

	public void setStaffLname(String staffLname) {
		this.staffLname = staffLname;
	}

	@Column(name = "STAFF_PASSWORD")
	public String getStaffPassword() {
		return this.staffPassword;
	}

	public void setStaffPassword(String staffPassword) {
		this.staffPassword = staffPassword;
	}

	@Column(name = "STAFF_PHONE")
	public BigDecimal getStaffPhone() {
		return this.staffPhone;
	}

	public void setStaffPhone(BigDecimal staffPhone) {
		this.staffPhone = staffPhone;
	}

	@Column(name = "STAFF_POSTCODE")
	public BigDecimal getStaffPostcode() {
		return this.staffPostcode;
	}

	public void setStaffPostcode(BigDecimal staffPostcode) {
		this.staffPostcode = staffPostcode;
	}

	@Column(name = "STAFF_STATE")
	public String getStaffState() {
		return this.staffState;
	}

	public void setStaffState(String staffState) {
		this.staffState = staffState;
	}

	@Column(name = "STAFF_STREET")
	public String getStaffStreet() {
		return this.staffStreet;
	}

	public void setStaffStreet(String staffStreet) {
		this.staffStreet = staffStreet;
	}

	@Column(name = "STAFF_TYPE")
	public String getStaffType() {
		return this.staffType;
	}

	public void setStaffType(String staffType) {
		this.staffType = staffType;
	}

	// bi-directional many-to-one association to Customer

	@OneToMany(mappedBy = "staff", fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH, CascadeType.DETACH })
	public List<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Customer addCustomer(Customer customer) {
		getCustomers().add(customer);
		customer.setStaff(this);

		return customer;
	}

	public Customer removeCustomer(Customer customer) {
		getCustomers().remove(customer);
		customer.setStaff(null);

		return customer;
	}

	// bi-directional many-to-one association to CustomerContact
	@OneToMany(mappedBy = "staff", fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH, CascadeType.DETACH })
	public List<CustomerContact> getCustomerContacts() {
		return this.customerContacts;
	}

	public void setCustomerContacts(List<CustomerContact> customerContacts) {
		this.customerContacts = customerContacts;
	}

	public CustomerContact addCustomerContact(CustomerContact customerContact) {
		getCustomerContacts().add(customerContact);
		customerContact.setStaff(this);

		return customerContact;
	}

	public CustomerContact removeCustomerContact(CustomerContact customerContact) {
		getCustomerContacts().remove(customerContact);
		customerContact.setStaff(null);

		return customerContact;
	}

}