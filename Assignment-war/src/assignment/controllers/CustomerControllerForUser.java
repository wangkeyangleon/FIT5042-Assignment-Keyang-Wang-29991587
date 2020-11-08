package assignment.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import assignment.repository.entities.Customer;

/**
 * @author:Keyang Wang
 * @version:
 * @create time：27 Sep 2020 10:55:51 am
 * @desc:
 */
@Named(value = "customerControllerForUser")
@RequestScoped
public class CustomerControllerForUser {
	private int customerIdF;
	private Customer customer;

	public CustomerControllerForUser() {
		customerIdF = Integer.valueOf(
				FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("customerIdF"));
		customer = getCustomer();
	}

	public int getCustomerId() {
		return customerIdF;
	}

	public void setCustomerId(int customerId) {
		this.customerIdF = customerId;
	}

	public Customer getCustomer() {
		if (customer == null) {
			ELContext context = FacesContext.getCurrentInstance().getELContext();
			CustomerApplicationForUser application = (CustomerApplicationForUser) FacesContext.getCurrentInstance().getApplication()
					.getELResolver().getValue(context, null, "customerApplicationForUser");
			return application.getCustomers().get(--customerIdF);

		}
		return customer;
	}

}
