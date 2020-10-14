package assignment.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import assignment.mbeans.StaffManagedBean;

/**
 * @author:Keyang Wang
 * @version:
 * @create time：29 Sep 2020 11:15:38 am
 * @desc:
 */
@RequestScoped
@Named("removeStaff")
public class RemoveStaff {
	@ManagedProperty(value = "#{staffManagedBean}")
	StaffManagedBean staffManagedBean;

	private boolean showForm = true;
	private Staff staff;

	StaffApplication application;

	public boolean isShowForm() {
		return showForm;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public RemoveStaff() {
		ELContext context = FacesContext.getCurrentInstance().getELContext();
		application = (StaffApplication) FacesContext.getCurrentInstance().getApplication().getELResolver()
				.getValue(context, null, "staffApplication");
		application.updateStaffList();
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		staffManagedBean = (StaffManagedBean) FacesContext.getCurrentInstance().getApplication().getELResolver()
				.getValue(elContext, null, "staffManagedBean");

	}

	public void removeStaff(int staffId) {
		try {
			staffManagedBean.removeStaff(staffId);
			application.searchAll();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Staff has been deleted successfully"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		showForm = true;
	}

}
