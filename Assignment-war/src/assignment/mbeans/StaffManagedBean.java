package assignment.mbeans;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.oracle.wls.shaded.org.apache.regexp.recompile;
import com.sun.xml.rpc.processor.modeler.j2ee.xml.javaIdentifierType;
import com.sun.xml.wss.impl.misc.HANonceManager.nonceCleanupTask;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import assignment.repositories.StaffRepositotires;
import assignment.repository.entities.Staff;

/**
 * @author:Keyang Wang
 * @version:
 * @create time：28 Sep 2020 5:12:41 pm
 * @desc:
 */
@ManagedBean(name = "staffManagedBean")
@SessionScoped
public class StaffManagedBean implements Serializable {
	@EJB
	StaffRepositotires staffRepositotires;

	public StaffManagedBean() {

	}

	public List<Staff> getAllStaffs() {
		try {
			List<Staff> staffs = staffRepositotires.getAllStaffs();
			return staffs;
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(StaffManagedBean.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}

//	public void addStaff(Staff staff) {
//		try {
//			staffRepositotires.addStaff(staff);
//		} catch (Exception e) {
//			// TODO: handle exception
//			Logger.getLogger(StaffManagedBean.class.getName()).log(Level.SEVERE,null,e);
//		}
//	}
	public Staff searchStaffById(int id) {
		try {
			return staffRepositotires.searchStaff(id);
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(StaffManagedBean.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;

	}

	public List<Staff> combineSearch(String keyString) {
		try {
			return staffRepositotires.combineSearch(keyString);
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(StaffManagedBean.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}

	public void removeStaff(int staffId) {
		try {
			staffRepositotires.removeStaff(staffId);
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(StaffManagedBean.class.getName()).log(Level.SEVERE, null, e);
		}

	}

	public void editStaff(Staff staff) {
		try {
			staffRepositotires.editStaff(staff);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Staff has been updated successfully"));
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(StaffManagedBean.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	public void addStaff(assignment.controllers.Staff localStaff) {
		Staff staff = convertStaffToEntity(localStaff);
		try {
			staffRepositotires.addStaff(staff);
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(StaffManagedBean.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	public byte[] getSHA(String input) throws NoSuchAlgorithmException {
//	        getInstance method is called with hashing SHA
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
		return messageDigest.digest(input.getBytes(StandardCharsets.UTF_8));
	}

	public String toHexString(byte[] hash) {
//	        convert byte array into signum representation
		BigInteger bigInteger = new BigInteger(1, hash);
//	        convert message digest into hex value
		StringBuilder stringBuilder = new StringBuilder(bigInteger.toString(16));

//	        pad with leading zeros
		while (stringBuilder.length() < 32) {
			stringBuilder.insert(0, '0');

		}
		return stringBuilder.toString();

	}

	private Staff convertStaffToEntity(assignment.controllers.Staff localStaff) {
		// TODO Auto-generated method stub
		String passwordString = localStaff.getStaffPassword();
		Staff staff = new Staff();
		java.util.Date birthDate = new java.util.Date();
		birthDate = localStaff.getStaffBirthdate();
		staff.setStaffBirthdate(birthDate);
		staff.setStaffFname(localStaff.getStaffFname());
		staff.setStaffLname(localStaff.getStaffLname());
		staff.setStaffGender(localStaff.getStaffGender());
		try {
			staff.setStaffPassword(toHexString(getSHA(passwordString)));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		staff.setStaffStreet(localStaff.getStaffStreet());
		staff.setStaffCity(localStaff.getStaffCity());
		staff.setStaffState(localStaff.getStaffState());
		staff.setStaffEmail(localStaff.getStaffEmail());
		staff.setStaffPhone(localStaff.getStaffPhone());
		staff.setStaffType(localStaff.getStaffType());
		staff.setStaffPostcode(localStaff.getStaffPostcode());
		return staff;

	}

}
