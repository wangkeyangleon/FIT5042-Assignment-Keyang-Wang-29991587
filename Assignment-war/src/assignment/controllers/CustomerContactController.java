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

@Named(value = "customerContactController")
@RequestScoped
public class CustomerContactController {
//	this id is the index
	private int customerContactId;

	public int getCustomerContactId() {
		return customerContactId;
	}

	public void setCustomerContactId(int customerContactId) {
		this.customerContactId = customerContactId;
	}

	private CustomerContact customerContact;

	public CustomerContactController() {
//		assign customer contact identifier via GET param
		customerContactId = Integer
				.valueOf(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("customerContactId"));
//		assign customer contact based on the id provided
		customerContact = getCustomerContact();

	}

	public CustomerContact getCustomerContact() {
		// TODO Auto-generated method stub
		if (customerContact == null) {
//			get application context bean customer contact Application
			ELContext context = FacesContext.getCurrentInstance().getELContext();
			CustomerContactApplication application = (CustomerContactApplication) FacesContext.getCurrentInstance()
					.getApplication().getELResolver().getValue(context, null, "customerContactApplication");
//			-1 conId since we +1 in JSF(to always have positive contact id)
			return application.getCustomerContacts().get(--customerContactId);//this is index
		}
		return customerContact;
	}

}
