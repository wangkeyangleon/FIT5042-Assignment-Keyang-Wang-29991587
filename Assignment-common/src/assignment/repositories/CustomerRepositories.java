package assignment.repositories;

import java.util.List;

import assignment.repository.entities.Customer;
import assignment.repository.entities.IndustryType;
import assignment.repository.entities.Staff;

/**
 * @author:Keyang Wang
 * @version:
 * @create time：22 Sep 2020 2:37:46 pm
 * @desc:
 */
public interface CustomerRepositories {
	public void addCustomer(assignment.repository.entities.Customer customer) throws Exception;

	public Customer searchCustomer(int customerId) throws Exception;

	public List<Customer> getAllCustomers() throws Exception;

	public List<Customer> getAllCustomersByStaff(Staff staff) throws Exception;

	public void removeCustomer(int customerId) throws Exception;

	public void editCustomer(Customer customer) throws Exception;

	public List<IndustryType> getAllIndustryTypes() throws Exception;

	public List<Customer> searchCustomersByName(String name) throws Exception;

}
