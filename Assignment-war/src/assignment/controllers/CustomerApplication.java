package assignment.controllers;

import java.util.ArrayList;

import javax.el.ELContext;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import assignment.mbeans.CustomerManagedBean;
import assignment.repository.entities.Customer;

/**
 * @author:Keyang Wang
 * @version:
 * @create time：27 Sep 2020 10:41:55 am
 * @desc:
 */
@Named(value = "customerApplication")
@ApplicationScoped
public class CustomerApplication {
	@ManagedProperty(value = "#{customerManagedBean}")
	CustomerManagedBean customerManagedBean;

	private ArrayList<Customer> customers;
	private boolean showForm = true;

	public CustomerApplication() {
		customers = new ArrayList<Customer>();
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		customerManagedBean = (CustomerManagedBean) FacesContext.getCurrentInstance().getApplication().getELResolver()
				.getValue(elContext, null, "customerManagedBean");
		updateCustomerList();
	}

	public void updateCustomerList() {
		// TODO Auto-generated method stub
		if (customers != null && customers.size() > 0) {

		} else {
			customers.clear();
			for (Customer customer : customerManagedBean.getAllCustomers()) {
				customers.add(customer);

			}
			setCustomers(customers);
		}
	}

	public void searchCustomerById(int customerId) {
		customers.clear();
		customers.add(customerManagedBean.searchCustomerById(customerId));
	}

	public void searchAll() {
		customers.clear();
		for (Customer customer : customerManagedBean.getAllCustomers()) {
			customers.add(customer);

		}
		setCustomers(customers);
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	public boolean isShowForm() {
		return showForm;
	}

}
