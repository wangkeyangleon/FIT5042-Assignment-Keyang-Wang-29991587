package assignment.repositories;

import java.util.List;

import assignment.repository.entities.Customer;
import assignment.repository.entities.CustomerContact;
import assignment.repository.entities.Staff;

/**
* @author:Keyang Wang
* @version:
* @create time：22 Sep 2020 2:38:10 pm
* @desc:
*/
public interface CustomerContactRepositories {
	public void addCustomerContact(CustomerContact customerContact) throws Exception;

	public CustomerContact searchCustomerContact(int id) throws Exception;

	public List<CustomerContact> getAllCustomerContacts() throws Exception;

	public void removeCustomerContact(int customerContactId) throws Exception;

	public void editCustomerContact(CustomerContact customerContact) throws Exception;
	
	public List<CustomerContact> getCustomerContactsByCustomer(Customer customer) throws Exception;
	
	public List<CustomerContact> getCustomerContactsByStaff(Staff staff) throws Exception;
}
