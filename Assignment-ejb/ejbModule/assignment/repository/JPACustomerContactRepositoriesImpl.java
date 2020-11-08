package assignment.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.javaXmlTypeMappingType;

import assignment.repositories.CustomerContactRepositories;
import assignment.repository.entities.Customer;
import assignment.repository.entities.CustomerContact;
import assignment.repository.entities.Staff;

/**
 * @author:Keyang Wang
 * @version:
 * @create time：22 Sep 2020 2:50:18 pm
 * @desc:
 */
@Stateless
public class JPACustomerContactRepositoriesImpl implements CustomerContactRepositories {

	@PersistenceContext(unitName = "Assignment-ejbPU")
	private EntityManager entityManager;

	@Override
	public void addCustomerContact(CustomerContact customerContact) throws Exception {
		// TODO Auto-generated method stub
		String s = customerContact.getCustomer().getCusName();
		javax.persistence.Query query = entityManager.createNamedQuery(Customer.GET_ALL_QUERY_NAME1);
		query.setParameter(1, s);
		List<Customer> customer = query.getResultList();
		List<CustomerContact> customerContacts = entityManager.createNamedQuery(CustomerContact.GET_ALL_QUERY_NAME)
				.getResultList();
		customerContact.setConId(customerContacts.get(0).getConId() + 1);
		customerContact.setCustomer(customer.get(0));
		entityManager.persist(customerContact);
		entityManager.flush();

	}

	@Override
	public CustomerContact searchCustomerContact(int id) throws Exception {
		// TODO Auto-generated method stub
		CustomerContact customerContact = entityManager.find(CustomerContact.class, id);
//		customerContact.getConFname();
		return customerContact;
	}

	@Override
	public List<CustomerContact> getAllCustomerContacts() throws Exception {
		// TODO Auto-generated method stub

		return entityManager.createNamedQuery(CustomerContact.GET_ALL_QUERY_NAME).getResultList();
	}

	@Override
	public void removeCustomerContact(int customerContactId) throws Exception {
		// TODO Auto-generated method stub
		CustomerContact customerContact = entityManager.find(CustomerContact.class, customerContactId);
		System.err.println("jpa@@@ "+customerContact.getConFname() );
		if (customerContact != null) {
			entityManager.remove(customerContact);
		}

	}

	@Override
	public void editCustomerContact(CustomerContact customerContact) throws Exception {
		// TODO Auto-generated method stub
		try {
			entityManager.merge(customerContact);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public List<CustomerContact> getCustomerContactsByCustomer(Customer customer) throws Exception {
		// TODO Auto-generated method stub
		javax.persistence.Query query = entityManager.createNamedQuery(CustomerContact.GET_ALL_QUERY_NAME2);
		query.setParameter(1, customer);
		List<CustomerContact> list = query.getResultList();
		return list;
	}

	@Override
	public List<CustomerContact> getCustomerContactsByStaff(Staff staff) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("*****contact jpa");
		javax.persistence.Query query = entityManager.createNamedQuery(CustomerContact.GET_ALL_QUERY_NAME3);
		query.setParameter(1, staff);
		List<CustomerContact> list = query.getResultList();
		System.out.println("**** list size "+ list.size());
		return list;
	}

}
