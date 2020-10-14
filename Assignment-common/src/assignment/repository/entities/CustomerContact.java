package assignment.repository.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * The persistent class for the CUSTOMER_CONTACT database table.
 * 
 */
@Entity
@Table(name = "CUSTOMER_CONTACT")
@NamedQueries({
		@NamedQuery(name = CustomerContact.GET_ALL_QUERY_NAME, query = "SELECT c FROM CustomerContact c order by c.conId desc") })
public class CustomerContact implements Serializable {
	public static final String GET_ALL_QUERY_NAME = "CustomerContact.getAll";
	private int conId;
	private String conCity;
	private String conEmail;
	private String conFname;
	private String conGender;
	private String conLname;
	private BigDecimal conPhone;
	private BigDecimal conPostcode;
	private String conState;
	private String conStreet;
	private Customer customer;
	private Staff staff;

	public CustomerContact() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "CON_ID")
	public int getConId() {
		return this.conId;
	}

	public void setConId(int conId) {
		this.conId = conId;
	}

	@Column(name = "CON_CITY")
	public String getConCity() {
		return this.conCity;
	}

	public void setConCity(String conCity) {
		this.conCity = conCity;
	}

	@Column(name = "CON_EMAIL")
	public String getConEmail() {
		return this.conEmail;
	}

	public void setConEmail(String conEmail) {
		this.conEmail = conEmail;
	}

	@Column(name = "CON_FNAME")
	public String getConFname() {
		return this.conFname;
	}

	public void setConFname(String conFname) {
		this.conFname = conFname;
	}

	@Column(name = "CON_GENDER")
	public String getConGender() {
		return this.conGender;
	}

	public void setConGender(String conGender) {
		this.conGender = conGender;
	}

	@Column(name = "CON_LNAME")
	public String getConLname() {
		return this.conLname;
	}

	public void setConLname(String conLname) {
		this.conLname = conLname;
	}

	@Column(name = "CON_PHONE")
	public BigDecimal getConPhone() {
		return this.conPhone;
	}

	public void setConPhone(BigDecimal conPhone) {
		this.conPhone = conPhone;
	}

	@Column(name = "CON_POSTCODE")
	public BigDecimal getConPostcode() {
		return this.conPostcode;
	}

	public void setConPostcode(BigDecimal conPostcode) {
		this.conPostcode = conPostcode;
	}

	@Column(name = "CON_STATE")
	public String getConState() {
		return this.conState;
	}

	public void setConState(String conState) {
		this.conState = conState;
	}

	@Column(name = "CON_STREET")
	public String getConStreet() {
		return this.conStreet;
	}

	public void setConStreet(String conStreet) {
		this.conStreet = conStreet;
	}

	// bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name = "CUS_ID")
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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

}