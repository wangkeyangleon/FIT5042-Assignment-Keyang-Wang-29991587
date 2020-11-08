package assignment.controllers;

import java.util.ArrayList;

import javax.el.ELContext;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import assignment.mbeans.StaffManagedBean;
import assignment.repository.entities.Staff;

/**
 * @author:Keyang Wang
 * @version:
 * @create time：28 Sep 2020 5:53:35 pm
 * @desc:
 */
@Named(value = "staffApplication")
@ApplicationScoped
public class StaffApplication {
	@ManagedProperty(value = "staffManagedBean")
	StaffManagedBean staffManagedBean;

	private ArrayList<assignment.repository.entities.Staff> staffs;
	private boolean showForm = true;

	public ArrayList<assignment.repository.entities.Staff> getStaffs() {
		return staffs;
	}

	public void setStaffs(ArrayList<Staff> staffs) {
		this.staffs = staffs;
	}

	public boolean isShowForm() {
		return showForm;
	}

	public StaffApplication() {
		staffs = new ArrayList<Staff>();
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		staffManagedBean = (StaffManagedBean) FacesContext.getCurrentInstance().getApplication().getELResolver()
				.getValue(elContext, null, "staffManagedBean");
		updateStaffList();
	}

	public void updateStaffList() {
		// TODO Auto-generated method stub
		if (staffs != null && staffs.size() > 0) {

		} else {
			staffs.clear();
			for (assignment.repository.entities.Staff staff : staffManagedBean.getAllStaffs()) {
				staffs.add(staff);

			}
			setStaffs(staffs);
		}

	}

	public void searchStaffById(int staffId) {
		staffs.clear();
		staffs.add(staffManagedBean.searchStaffById(staffId));
	}
	
	public void combineSearch(String keyString) {
		staffs.clear();
//		for (Staff staff:staffManagedBean.combineSearch(keyString)) {
//			staffs.add(staff);
//			
//		}
		staffs.addAll(staffManagedBean.combineSearch(keyString));
	}

	public void searchAll() {
		staffs.clear();
		for (Staff staff : staffManagedBean.getAllStaffs()) {
			staffs.add(staff);
		}
		setStaffs(staffs);
	}

}
