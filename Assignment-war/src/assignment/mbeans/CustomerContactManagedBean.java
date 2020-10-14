package assignment.mbeans;

import java.io.Serializable;
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
import assignment.repository.entities.Customer;
import assignment.repository.entities.CustomerContact;

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

//	create a new instance of customerContactManagedBean
	public CustomerContactManagedBean() {
		// TODO Auto-generated constructor stub
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

//	public void addCustomerContact(CustomerContact customerContact) {
//		try {
//			customerContactRepositories.addCustomerContact(customerContact);
//		} catch (Exception e) {
//			// TODO: handle exception
//			Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
//		}
//	}

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
			System.out.println("!! i am cus id:"+long1);
			Customer customer = customerRepositories.searchCustomer(long1);
//			customer.setCusId(long1); 		
			System.out.println("pig dog:"+customer.getCusName());
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
		return customerContact;
	}

}
