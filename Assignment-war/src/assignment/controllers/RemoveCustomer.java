package assignment.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import assignment.mbeans.CustomerManagedBean;
import assignment.repository.entities.Customer;

/**
 * @author:Keyang Wang
 * @version:
 * @create time：27 Sep 2020 1:46:15 pm
 * @desc:
 */
@RequestScoped
@Named("removeCustomer")
public class RemoveCustomer {
	@ManagedProperty(value = "#{customerManagedBean}")
	CustomerManagedBean customerManagedBean;
	private boolean showForm = true;
	private Customer customer;
	CustomerApplication application;

	public boolean isShowForm() {
		return showForm;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public RemoveCustomer() {
		ELContext context = FacesContext.getCurrentInstance().getELContext();
		application = (CustomerApplication) FacesContext.getCurrentInstance().getApplication().getELResolver()
				.getValue(context, null, "customerApplication");
		application.updateCustomerList();
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		customerManagedBean = (CustomerManagedBean) FacesContext.getCurrentInstance().getApplication().getELResolver()
				.getValue(elContext, null, "customerManagedBean");
		
	}
	public void removeCustomer(int customerId) {
		try {
			customerManagedBean.removeCustomer(customerId);
			application.searchAll();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Customer has been deleted successfully"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		showForm = true;
	}
}
