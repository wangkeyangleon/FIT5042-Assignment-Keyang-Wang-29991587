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
 * @create time：29 Sep 2020 11:07:17 am
 * @desc:
 */
@RequestScoped
@Named("addStaff")
public class AddStaff {
	@ManagedProperty(value = "#{staffManagedBean}")
	StaffManagedBean staffManagedBean;
	private boolean showForm = true;
	private Staff staff;
	StaffApplication application;

	public AddStaff() {
		ELContext context = FacesContext.getCurrentInstance().getELContext();
		application = (StaffApplication) FacesContext.getCurrentInstance().getApplication().getELResolver()
				.getValue(context, null, "staffApplication");

		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		staffManagedBean = (StaffManagedBean) FacesContext.getCurrentInstance().getApplication().getELResolver()
				.getValue(elContext, null, "staffManagedBean");
	}

	public boolean isShowForm() {
		return showForm;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public void addStaff(Staff localStaff) {
		try {
			staffManagedBean.addStaff(localStaff);
			application.searchAll();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Staff has been added successfully"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		showForm = true;
	}

}
