package assignment.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import assignment.repository.entities.Customer;

/**
 * @author:Keyang Wang
 * @version:
 * @create time：27 Sep 2020 2:03:24 pm
 * @desc:
 */
@RequestScoped
@Named("searchCustomer")
public class SearchCustomer {
	private boolean showForm = true;
	private Customer customer;
	CustomerApplication application;
	private int searchByInt;
	private String searchByName;

	public boolean isShowForm() {
		return showForm;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getSearchByInt() {
		return searchByInt;
	}

	public void setSearchByInt(int searchByInt) {
		this.searchByInt = searchByInt;
	}

	public String getSearchByName() {
		return searchByName;
	}

	public void setSearchByName(String searchByName) {
		this.searchByName = searchByName;
	}

	public CustomerApplication getApplication() {
		return application;
	}

	public void setApplication(CustomerApplication application) {
		this.application = application;
	}

	public SearchCustomer() {
		ELContext context = FacesContext.getCurrentInstance().getELContext();
		application = (CustomerApplication) FacesContext.getCurrentInstance().getApplication().getELResolver()
				.getValue(context, null, "customerApplication");
		application.updateCustomerList();
	}

	public void searchCustomerById(int customerId) {
		try {
			application.searchCustomerById(customerId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		showForm = true;
	}

	public void searchCustomersByName(String name) {
		try {
			application.searchCutomersByName(name);
		} catch (Exception e) {
			// TODO: handle exception
		}
		showForm = true;

	}

	public void searchAll() {
		try {
			application.searchAll();
		} catch (Exception e) {
			// TODO: handle exception
		}
		showForm = true;
	}
//	public void getCustomerByStaff(String staffId)
//	{
//		try {
//			application.getCustomerBystaff(staffId);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		showForm =true;
//		
//	}

}
