package assignment.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.New;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import assignment.mbeans.CustomerManagedBean;
import assignment.repository.entities.IndustryType;

/**
 * @author:Keyang Wang
 * @version:
 * @create time：27 Sep 2020 11:10:37 am
 * @desc:
 */
@RequestScoped
@Named("addCustomerForUser")
public class AddCustomerForUser {
	@ManagedProperty(value = "#{customerManagedBean}")
	CustomerManagedBean customerManagedBean;

	private boolean showForm = true;
	private Customer customer;
	CustomerApplicationForUser application;

	public boolean isShowForm() {
		return showForm;
	}

	public void setShowForm(boolean showForm) {
		this.showForm = showForm;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public AddCustomerForUser() {
		ELContext context = FacesContext.getCurrentInstance().getELContext();
		application = (CustomerApplicationForUser) FacesContext.getCurrentInstance().getApplication().getELResolver()
				.getValue(context, null, "customerApplicationForUser");
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		customerManagedBean = (CustomerManagedBean) FacesContext.getCurrentInstance().getApplication().getELResolver()
				.getValue(elContext, null, "customerManagedBean");
	}
	public void addCustomer(Customer localCustomer) {
		try {
			
			customerManagedBean.addCustomer(localCustomer);
			application.searchAll();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Customer has been added successfully"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		showForm = true;
		
	}
}
