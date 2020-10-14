package assignment.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import assignment.repository.entities.CustomerContact;

/**
 * @author:Keyang Wang
 * @version:
 * @create time：23 Sep 2020 6:31:13 pm
 * @desc:
 */
@RequestScoped
@Named("searchCustomerContact")
public class SearchCustomerContact {
	private boolean showForm = true;
	private CustomerContact customerContact;
	CustomerContactApplication application;
	private int searcheByInt;

	public boolean isShowForm() {
		return showForm;
	}

	public void setShowForm(boolean showForm) {
		this.showForm = showForm;
	}

	public CustomerContact getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(CustomerContact customerContact) {
		this.customerContact = customerContact;
	}

	public CustomerContactApplication getApplication() {
		return application;
	}

	public void setApplication(CustomerContactApplication application) {
		this.application = application;
	}

	public int getSearcheByInt() {
		return searcheByInt;
	}

	public void setSearcheByInt(int searcheByInt) {
		this.searcheByInt = searcheByInt;
	}

	public SearchCustomerContact() {
		ELContext context = FacesContext.getCurrentInstance().getELContext();
		application = (CustomerContactApplication) FacesContext.getCurrentInstance().getApplication().getELResolver()
				.getValue(context, null, "customerContactApplication");
		application.updateCustomerContactList();
	}

	public void searchCustomerContactById(int id) {
		try {
			application.searchCustomerContact(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		showForm = true;
	}

	public void searchAll() {
		try {
			application.searchAllCustomerContact();
		} catch (Exception e) {
			// TODO: handle exception
		}
		showForm = true;
	}

}
