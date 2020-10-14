package assignment.repository.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the INDUSTRY_TYPE database table.
 * 
 */
@Entity
@Table(name="INDUSTRY_TYPE")
@NamedQueries({
	@NamedQuery(name = IndustryType.GET_ALL_QUERY_NAME,query="SELECT i FROM IndustryType i order by i.industryId desc"),
	@NamedQuery(name = IndustryType.GET_ALL_QUERY_NAME1,query="SELECT i FROM IndustryType i where i.industryType = ?1 order by i.industryId desc")
})
@NamedQuery(name="IndustryType.findAll", query="SELECT i FROM IndustryType i")
public class IndustryType implements Serializable {
	public static final String GET_ALL_QUERY_NAME = "IndustryType.getAll";
	public static final String GET_ALL_QUERY_NAME1 = "IndustryType.getIdByName";
	private int industryId;
	private String industryType;
	private List<Customer> customers;

	public IndustryType() {
	}


	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="INDUSTRY_ID")
	public int getIndustryId() {
		return this.industryId;
	}

	public void setIndustryId(int industryId) {
		this.industryId = industryId;
	}


	@Column(name="INDUSTRY_TYPE")
	public String getIndustryType() {
		return this.industryType;
	}

	public void setIndustryType(String industryType) {
		this.industryType = industryType;
	}


	//bi-directional many-to-one association to Customer
	@OneToMany(mappedBy="industryType", fetch=FetchType.EAGER)
	public List<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Customer addCustomer(Customer customer) {
		getCustomers().add(customer);
		customer.setIndustryType(this);

		return customer;
	}

	public Customer removeCustomer(Customer customer) {
		getCustomers().remove(customer);
		customer.setIndustryType(null);

		return customer;
	}

}