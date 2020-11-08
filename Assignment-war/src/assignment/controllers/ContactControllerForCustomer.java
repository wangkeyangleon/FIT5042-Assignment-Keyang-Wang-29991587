package assignment.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;
import javax.inject.Named;

import assignment.repository.entities.CustomerContact;

/**
 * @author:Keyang Wang
 * @version:
 * @create time：23 Sep 2020 6:30:33 pm
 * @desc:set the data to all the pages
 */

@Named(value = "customerContactControllerForUser")
@RequestScoped
public class ContactControllerForCustomer {
//	this id is the index for customer
	private int customerId;
	private int customerContactId;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getCustomerContactId() {
		return customerContactId;
	}

	public void setCustomerContactId(int customerContactId) {
		this.customerContactId = customerContactId;
	}

	private CustomerContact customerContact;

	public ContactControllerForCustomer() {
		customerContact = getCustomerContact();
		// assign contact via get param
		customerId = Integer.valueOf(
				FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("customerId"));
//		assign contact based on the id provided
		customerContact = getCustomerContact();

	}

	public CustomerContact getCustomerContact() {
		// TODO Auto-generated method stub
		if (customerContact == null) {
			// get application context bean contact application for customer
			ELContext elContext = FacesContext.getCurrentInstance().getELContext();
			ContactApplicationForCustomer application = (ContactApplicationForCustomer) FacesContext
					.getCurrentInstance().getApplication().getELResolver()
					.getValue(elContext, null, "contactApplicationForCustomer");
//			-1 conId since we +1 in JSF(to always have positive contact id)
			return application.getCustomerContacts().get(--customerId);
		}
		return customerContact;
	}

}
