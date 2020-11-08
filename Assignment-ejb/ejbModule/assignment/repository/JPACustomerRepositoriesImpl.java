package assignment.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import assignment.repositories.CustomerRepositories;
import assignment.repository.entities.Customer;
import assignment.repository.entities.IndustryType;
import assignment.repository.entities.Staff;

/**
 * @author:Keyang Wang
 * @version:
 * @create time：22 Sep 2020 2:49:53 pm
 * @desc:
 */
@Stateless
public class JPACustomerRepositoriesImpl implements CustomerRepositories {

	@PersistenceContext(unitName = "Assignment-ejbPU")
	private EntityManager entityManager;

	@Override
	public void addCustomer(Customer customer) throws Exception {
		// TODO Auto-generated method stub
		String s = customer.getIndustryType().getIndustryType();
		javax.persistence.Query query = entityManager.createNamedQuery(IndustryType.GET_ALL_QUERY_NAME1);
		query.setParameter(1, s);
		List<IndustryType> list = query.getResultList();
		List<Customer> customers = entityManager.createNamedQuery(Customer.GET_ALL_QUERY_NAME).getResultList();
		customer.setCusId(customers.get(0).getCusId() + 1);
		customer.setIndustryType(list.get(0));
		entityManager.persist(customer);
		entityManager.flush();
	}

	@Override
	public Customer searchCustomer(int id) throws Exception {
		// TODO Auto-generated method stub
		Customer customer = entityManager.find(Customer.class, id);
//		customer.getTag();
//		customer.getCusName();
		return customer;
	}

	@Override
	public List<Customer> getAllCustomers() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("!! i am impl before");
		return entityManager.createNamedQuery(Customer.GET_ALL_QUERY_NAME).getResultList();
	}

	@Override
	public void removeCustomer(int customerId) throws Exception {
		// TODO Auto-generated method stub
		Customer customer = this.searchCustomer(customerId);
		if (customer != null) {
			entityManager.remove(customer);
		}

	}

	@Override
	public void editCustomer(Customer customer) throws Exception {
		// TODO Auto-generated method stub
		try {
			String s = customer.getIndustryType().getIndustryType();
			javax.persistence.Query query = entityManager.createNamedQuery(IndustryType.GET_ALL_QUERY_NAME1);
			query.setParameter(1, s);
			List<IndustryType> list = query.getResultList();
			customer.setIndustryType(list.get(0));
			entityManager.merge(customer);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public List<IndustryType> getAllIndustryTypes() throws Exception {
		// TODO Auto-generated method stub
		return entityManager.createNamedQuery(IndustryType.GET_ALL_QUERY_NAME).getResultList();
	}

	@Override
	public List<Customer> searchCustomersByName(String name) throws Exception {
		// use the Criteria API
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery query = criteriaBuilder.createQuery(Customer.class);
		Root<Customer> root = query.from(Customer.class);
//		query.select(root).where(criteriaBuilder.like(root.get("cusName").as(String.class), name));
		//filtering entity instance
		Predicate predicate = criteriaBuilder.like(root.get("cusName"),"%"+name+"%");
		//store the criteria in the criteria query
		query.where(predicate);
		//type-safe query for entityManager
		TypedQuery typedQuery = entityManager.createQuery(query);
//		List<Customer> customers = entityManager.createQuery(query).getResultList();
		//return the results to the caller
		return typedQuery.getResultList();
	}
	

	@Override
	public List<Customer> getAllCustomersByStaff(Staff staff) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("StaffId:" + staff);
		System.out.println("Start loading2...");
		javax.persistence.Query query = entityManager.createNamedQuery(Customer.GET_ALL_QUERY_NAME2);
		query.setParameter(1, staff);
		List<Customer> list = query.getResultList();
		System.out.println("!!!!!i am size"+list.size());
		return list;
	}

}
