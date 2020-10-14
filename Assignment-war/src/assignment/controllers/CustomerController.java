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
@Named(value = "customerController")
@RequestScoped
public class CustomerController {
	private int customerId;
	private Customer customer;

	public CustomerController() {
		customerId = Integer.valueOf(
				FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("customerId"));
		customer = getCustomer();
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Customer getCustomer() {
		if (customer == null) {
			ELContext context = FacesContext.getCurrentInstance().getELContext();
			CustomerApplication application = (CustomerApplication) FacesContext.getCurrentInstance().getApplication()
					.getELResolver().getValue(context, null, "customerApplication");
			return application.getCustomers().get(--customerId);

		}
		return customer;
	}

}
