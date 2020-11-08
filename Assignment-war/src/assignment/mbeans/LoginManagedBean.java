package assignment.mbeans;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
* @author:Keyang Wang
* @version:
* @create time：25 Oct 2020 2:27:21 pm
* @desc:
*/

import java.security.Principal;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.NamedQueries;

import assignment.repositories.CustomerContactRepositories;
import assignment.repositories.CustomerRepositories;
import assignment.repositories.StaffRepositotires;
import assignment.repository.entities.Customer;
import assignment.repository.entities.CustomerContact;
import assignment.repository.entities.Staff;

@ManagedBean(name = "loginManagedBean")
@SessionScoped
public class LoginManagedBean {
	@EJB
	StaffRepositotires staffRepositotires;
	@EJB
	CustomerRepositories customerRepositories;
	@EJB
	CustomerContactRepositories contactRepositories;
	private Staff staff;
	private Principal principal;
	private ArrayList<Customer> customers;
	private ArrayList<CustomerContact> contacts;
	private String newPassword;
	private String confirmPassword;

	public LoginManagedBean() {
		customers = new ArrayList<Customer>();
		contacts = new ArrayList<CustomerContact>();
	}

	public Staff getStaff() {
		if (staff == null) {
			principal = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
			if (principal != null) {
				try {
					staff = staffRepositotires.searchStaff(Integer.parseInt(principal.getName()));
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}

		}
		return staff;
	}

	public byte[] getSHA(String input) throws NoSuchAlgorithmException {
//        getInstance method is called with hashing SHA
	MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
	return messageDigest.digest(input.getBytes(StandardCharsets.UTF_8));
}

public String toHexString(byte[] hash) {
//        convert byte array into signum representation
	BigInteger bigInteger = new BigInteger(1, hash);
//        convert message digest into hex value
	StringBuilder stringBuilder = new StringBuilder(bigInteger.toString(16));

//        pad with leading zeros
	while (stringBuilder.length() < 32) {
		stringBuilder.insert(0, '0');

	}
	return stringBuilder.toString();

}
	
	public void validatePassword() {
		if (!newPassword.equals(confirmPassword)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("two password not same, please try again!"));
		} else {
			try {
				if (confirmPassword != null) {
					staff.setStaffPassword(toHexString(getSHA(getConfirmPassword())));
					staffRepositotires.editStaff(staff);
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage("successfully change the password"));
				}

			} catch (Exception e) {
				// TODO: handle exception
				Logger.getLogger(LoginManagedBean.class.getName()).log(Level.SEVERE, null, e);
			}
		}

	}

	public void logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().invalidateSession();
		try {
			context.getExternalContext().redirect("../index.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Principal getPrincipal() {
		return principal;
	}

	public void setPrincipal(Principal principal) {
		this.principal = principal;
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	public ArrayList<CustomerContact> getContacts() {
		return contacts;
	}

	public void setContacts(ArrayList<CustomerContact> contacts) {
		this.contacts = contacts;
	}

}
