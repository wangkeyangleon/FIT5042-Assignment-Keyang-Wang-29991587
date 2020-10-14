package assignment.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import assignment.repository.entities.Staff;

/**
 * @author:Keyang Wang
 * @version:
 * @create time：29 Sep 2020 10:58:41 am
 * @desc:
 */
@Named(value = "staffController")
@RequestScoped
public class StaffController {
	private int staffId;
	private Staff staff;

	public StaffController() {
		staffId = Integer.valueOf(
				FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("staffId"));
		staff = getStaff();
	}

	public Staff getStaff() {
		// TODO Auto-generated method stub
		if (staff == null) {
			ELContext context = FacesContext.getCurrentInstance().getELContext();
			StaffApplication application = (StaffApplication) FacesContext.getCurrentInstance().getApplication()
					.getELResolver().getValue(context, null, "staffApplication");
			return application.getStaffs().get(--staffId);
		}
		return staff;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

}
