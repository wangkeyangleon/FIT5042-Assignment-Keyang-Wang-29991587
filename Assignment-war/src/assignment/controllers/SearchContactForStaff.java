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
@Named("searchContactForStaff")
public class SearchContactForStaff {
	private boolean showForm = true;
	private CustomerContact customerContact;
	ContactApplicationForStaff application;
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

	public ContactApplicationForStaff getApplication() {
		return application;
	}

	public void setApplication(ContactApplicationForStaff application) {
		this.application = application;
	}

	public int getSearcheByInt() {
		return searcheByInt;
	}

	public void setSearcheByInt(int searcheByInt) {
		this.searcheByInt = searcheByInt;
	}

	public SearchContactForStaff() {
		ELContext context = FacesContext.getCurrentInstance().getELContext();
		application = (ContactApplicationForStaff) FacesContext.getCurrentInstance().getApplication().getELResolver()
				.getValue(context, null, "contactApplicationForStaff");
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
