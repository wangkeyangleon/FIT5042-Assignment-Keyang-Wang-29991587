package assignment.mbeans;

import java.io.Serializable;
import java.security.Principal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;

import assignment.repositories.CustomerContactRepositories;
import assignment.repositories.CustomerRepositories;
import assignment.repositories.StaffRepositotires;
import assignment.repository.entities.Customer;
import assignment.repository.entities.CustomerContact;
import assignment.repository.entities.Staff;

/**
 * @author:Keyang Wang
 * @version:
 * @create time：23 Sep 2020 6:29:45 pm
 * @desc:
 */
@ManagedBean(name = "customerContactManagedBean")
@SessionScoped
public class CustomerContactManagedBean implements Serializable {
	@EJB
	CustomerContactRepositories customerContactRepositories;
	@EJB
	CustomerRepositories customerRepositories;
	@EJB
	StaffRepositotires staffRepositotires;
	
//	CustomerManagedBean customerManagedBean;
	private Customer customer;
	private Principal principal;
	private Staff staff;

//	create a new instance of customerContactManagedBean
	public CustomerContactManagedBean() {
		// TODO Auto-generated constructor stub
		staff = getStaff();
	}

	public Principal getPrincipal() {
		return principal;
	}

	public void setPrincipal(Principal principal) {
		this.principal = principal;
	}

	public Staff getStaff() {
		if (staff == null) {
			principal = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
			if (principal != null) {
				try {
					staff = staffRepositotires.searchStaff(Integer.parseInt(principal.getName()));
					System.out.println("****manged bean staff "+staff.getStaffFname());
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Customer getCustomer() {

		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<CustomerContact> getAllCustomerContacts() {
		try {
			List<CustomerContact> customerContacts = customerContactRepositories.getAllCustomerContacts();
			return customerContacts;
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;

	}

	public List<CustomerContact> getContactsByStaff() {
		try {
			System.out.println("*****managed bean contact");
//			System.out.println("***** staff "+staff.getStaffCity());
//			System.out.println("### 1 contact mangedBean staff: "+customerManagedBean.getStaff().getStaffId());
			List<CustomerContact> list = customerContactRepositories.getCustomerContactsByStaff(staff);
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}

	public List<CustomerContact> getContactsByCustomer() {
		try {
			List<CustomerContact> customerContacts = customerContactRepositories
					.getCustomerContactsByCustomer(customer);
			return customerContacts;
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}

	public List<Customer> getAllCustomers() {
		try {
			System.out.println("!! i am get all customers");
			return customerRepositories.getAllCustomers();
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}
	
	public List<Customer> getCustomersByStaff()
	{
		try {
//			System.out.println("### contact mangedBean staff: "+customerManagedBean.getStaff().getStaffId());
			return customerRepositories.getAllCustomersByStaff(staff);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	
	public List<Staff> getAllStaffs() {
		try {
			return staffRepositotires.getAllStaffs();
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;

	}

	public CustomerContact searchCustomerContact(int id) {
		try {
			return customerContactRepositories.searchCustomerContact(id);
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}

	public void removeCustomerContact(int customerContactId) {
		try {
			customerContactRepositories.removeCustomerContact(customerContactId);
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	public void editCustomerContact(CustomerContact customerContact) {
		try {
			int long1 = customerContact.getCustomer().getCusId();

			Customer customer = customerRepositories.searchCustomer(long1);
//			customer.setCusId(long1); 		

			customerContact.setCustomer(customer);
			customerContactRepositories.editCustomerContact(customerContact);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Customer contact has been updated successfully!"));
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	public void addCustomerContact(assignment.controllers.CustomerContact loalCustomerContact) {
//		convert this new customer contact which is the local customer contact to entity customer contact
		CustomerContact customerContact = convertCustomerContactToEntity(loalCustomerContact);
		try {
			customerContactRepositories.addCustomerContact(customerContact);
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	private CustomerContact convertCustomerContactToEntity(assignment.controllers.CustomerContact loalCustomerContact) {
		// TODO Auto-generated method stub
//		entity
		CustomerContact customerContact = new CustomerContact();
		customerContact.setConCity(loalCustomerContact.getConCity());
		customerContact.setConEmail(loalCustomerContact.getConEmail());
		customerContact.setConFname(loalCustomerContact.getConFname());
		customerContact.setConGender(loalCustomerContact.getConGender());
		customerContact.setConLname(loalCustomerContact.getConLname());
		customerContact.setConPhone(loalCustomerContact.getConPhone());
		customerContact.setConPostcode(loalCustomerContact.getConPostcode());
		customerContact.setConState(loalCustomerContact.getConState());
		customerContact.setConStreet(loalCustomerContact.getConStreet());
		String cusName = loalCustomerContact.getCusName();
		Customer customer = new Customer();
		customer.setCusName(cusName);
		customerContact.setCustomer(customer);
		Staff staff = new Staff();
		staff.setStaffId(loalCustomerContact.getStaffId());
		customerContact.setStaff(staff);
		return customerContact;
	}

}
