package assignment.controllers;

import java.util.ArrayList;

import javax.el.ELContext;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import assignment.mbeans.CustomerContactManagedBean;
import assignment.repository.entities.CustomerContact;

/**
 * @author:Keyang Wang
 * @version:
 * @create time：23 Sep 2020 6:30:50 pm
 * @desc: the class is a demonstration of how the app scope works, will be
 *        invoked in controller class
 */
@Named(value = "customerContactApplication")
@ApplicationScoped
public class CustomerContactApplication {
//	dependency injection of managed bean here so that we can use its methods
	@ManagedProperty(value = "#{customerContactManagedBean}")
	CustomerContactManagedBean customerContactManagedBean;

	private ArrayList<CustomerContact> customerContacts;
	private boolean showForm = true;

//	add some data from db to app
	public CustomerContactApplication() {
		customerContacts = new ArrayList<>();
//		instantiate customerContactManageBean
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		customerContactManagedBean = (CustomerContactManagedBean) FacesContext.getCurrentInstance().getApplication()
				.getELResolver().getValue(elContext, null, "customerContactManagedBean");
//		get customer contact from db
		updateCustomerContactList();

	}
// when loading, and after adding or deleting, the customer contact list need to be refreshed 	
	public void updateCustomerContactList() {
		// TODO Auto-generated method stub
		if (customerContacts!= null &&customerContacts.size()>0) {
			
		}
		else {
			customerContacts.clear();
			for (CustomerContact customerContact: customerContactManagedBean.getAllCustomerContacts()) {
				customerContacts.add(customerContact);
				
			}
			setCustomerContacts(customerContacts);
		}
	}
	public void searchCustomerContact(int customerContactId) {
		customerContacts.clear();
		customerContacts.add(customerContactManagedBean.searchCustomerContact(customerContactId));
	}
	public void searchAllCustomerContact() {
		customerContacts.clear();
		for (CustomerContact customerContact : customerContactManagedBean.getAllCustomerContacts()) {
			customerContacts.add(customerContact);
			
		}
		setCustomerContacts(customerContacts);
	}

	public ArrayList<CustomerContact> getCustomerContacts() {
		return customerContacts;
	}

	public void setCustomerContacts(ArrayList<CustomerContact> customerContacts) {
		this.customerContacts = customerContacts;
	}

	public boolean isShowForm() {
		return showForm;
	}

}
