package assignment.mbeans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import assignment.repositories.CustomerRepositories;
import assignment.repositories.StaffRepositotires;
import assignment.repository.entities.Customer;
import assignment.repository.entities.IndustryType;
import assignment.repository.entities.Staff;
import sun.reflect.generics.tree.IntSignature;

/**
 * @author:Keyang Wang
 * @version:
 * @create time：26 Sep 2020 8:32:40 pm
 * @desc:
 */
@ManagedBean(name = "customerManagedBean")
@SessionScoped
public class CustomerManagedBean implements Serializable {
	@EJB
	CustomerRepositories customerRepositories;
	@EJB
	StaffRepositotires staffRepositotires;

	public CustomerManagedBean() {
	}

	public List<Customer> getAllCustomers() {
		try {
			List<Customer> customers = customerRepositories.getAllCustomers();
			return customers;
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}

//	public void addCustomer(Customer customer) {
//		try {
//			System.out.println("i am managed bean");
//			System.out.println("!!!!"+customer.getIndustryType().getIndustryType());
//			customerRepositories.addCustomer(customer);
//		} catch (Exception e) {
//			// TODO: handle exception
//			Logger.getLogger(CustomerContactManagedBean.class.getName()).log(Level.SEVERE, null, e);
//		}
//	}

	public Customer searchCustomerById(int customerId) {
		try {
			return customerRepositories.searchCustomer(customerId);
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}

	public void removeCustomer(int customerId) {
		try {
			customerRepositories.removeCustomer(customerId);
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, e);
		}

	}

	public List<IndustryType> getAllIndustryTypes() throws Exception {
		try {
			return customerRepositories.getAllIndustryTypes();
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}
	
	public List<Staff> getAllStaffs() throws Exception{
		try {
			return staffRepositotires.getAllStaffs();
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}

	public void editCustomer(Customer customer) {
		try {
			int id = customer.getStaff().getStaffId();
			Staff staff = staffRepositotires.searchStaff(id);
			customer.setStaff(staff);
			customerRepositories.editCustomer(customer);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Customer has been updated successfully"));
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	public void addCustomer(assignment.controllers.Customer localCustomer) {
		Customer customer = convertCustomerToEntity(localCustomer);
		try {
			customerRepositories.addCustomer(customer);
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	private Customer convertCustomerToEntity(assignment.controllers.Customer localCustomer) {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		customer.setCusName(localCustomer.getCusName());
		customer.setCusStreet(localCustomer.getCusStreet());
		customer.setCusCity(localCustomer.getCusCity());
		customer.setCusState(localCustomer.getCusState());
		customer.setCusPostcode(localCustomer.getCusPostcode());
		customer.setCusEmail(localCustomer.getCusEmail());
		customer.setCusPhone(localCustomer.getCusPhone());
		String typeString = localCustomer.getInduType();
//		int typeid = localCustomer.getIdustryTypeId();
//		System.out.println("i am managed bean type"+typeid);
//		System.out.println("i am managed bean type"+typeString);
		IndustryType industryType = new IndustryType();
//		industryType.setIndustryId(typeid);
		industryType.setIndustryType(typeString);
		customer.setIndustryType(industryType);
		int staffid = localCustomer.getStaffId();
		Staff staff = new Staff();
		staff.setStaffId(staffid);
		customer.setStaff(staff);
		return customer;
	}

}
