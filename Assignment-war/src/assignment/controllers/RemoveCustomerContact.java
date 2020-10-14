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
 * @create time：23 Sep 2020 6:31:25 pm
 * @desc:
 */
@RequestScoped
@Named("removeCustomerContact")
public class RemoveCustomerContact {

	@ManagedProperty(value = "#{custmoerContactManagedBean}")
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

	public RemoveCustomerContact() {
		ELContext context = FacesContext.getCurrentInstance().getELContext();
		app = (CustomerContactApplication) FacesContext.getCurrentInstance().getApplication().getELResolver()
				.getValue(context, null, "customerContactApplication");
		app.updateCustomerContactList();
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		customerContactManagedBean = (CustomerContactManagedBean) FacesContext.getCurrentInstance().getApplication()
				.getELResolver().getValue(elContext, null, "customerContactManagedBean");

	}

	public void removeCustomerContact(int id) {
		try {
//			remove the contact from db via ejb
			customerContactManagedBean.removeCustomerContact(id);
//			refresh the list in the application bean
			app.searchAllCustomerContact();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Customer contact has been deleted successsfuly"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		showForm = true;

	}

}
