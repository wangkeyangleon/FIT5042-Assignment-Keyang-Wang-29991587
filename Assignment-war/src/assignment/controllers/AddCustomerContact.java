package assignment.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import assignment.mbeans.CustomerContactManagedBean;
import assignment.repository.entities.CustomerContact;

/**
 * @author:Keyang Wang
 * @version:
 * @create time：23 Sep 2020 6:31:00 pm
 * @desc: local customer contact managedbean can convert it to the entity
 */
@RequestScoped
@Named("addCustomerContact")
public class AddCustomerContact {
	@ManagedProperty(value = "customerContactManagedBean")
	CustomerContactManagedBean customerContactManagedBean;
	private boolean showForm = true;
	private CustomerContact customerContact;
	CustomerContactApplication app;

	public boolean isShowForm() {
		return showForm;
	}

	public CustomerContact getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(CustomerContact customerContact) {
		this.customerContact = customerContact;
	}

	public AddCustomerContact() {
		ELContext context = FacesContext.getCurrentInstance().getELContext();
		app = (CustomerContactApplication) FacesContext.getCurrentInstance().getApplication().getELResolver()
				.getValue(context, null, "customerContactApplication");
//		instantiate managebean
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		customerContactManagedBean = (CustomerContactManagedBean) FacesContext.getCurrentInstance().getApplication()
				.getELResolver().getValue(elContext, null, "customerContactManagedBean");

	}

	public void addCustomerContact(assignment.controllers.CustomerContact localCustomerContact) {
//		this is the local customer not entity
		try {
//			add this contact to db via EJB
			customerContactManagedBean.addCustomerContact(localCustomerContact);
//			refresh the list in contactApplication bean
			app.searchAllCustomerContact();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("customer contact has been added successfully"));

		} catch (Exception e) {
			// TODO: handle exception
		}
		showForm = true;
	}

}
