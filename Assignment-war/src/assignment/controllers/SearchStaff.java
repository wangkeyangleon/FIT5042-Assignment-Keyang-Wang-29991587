package assignment.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 * @author:Keyang Wang
 * @version:
 * @create time：29 Sep 2020 2:18:05 pm
 * @desc:
 */
@RequestScoped
@Named("searchStaff")
public class SearchStaff {
	private boolean showForm = true;
	private Staff staff;
	StaffApplication application;
	private int searchByInt;

	public boolean isShowForm() {
		return showForm;
	}

	public void setShowForm(boolean showForm) {
		this.showForm = showForm;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public StaffApplication getApplication() {
		return application;
	}

	public void setApplication(StaffApplication application) {
		this.application = application;
	}



	public int getSearchByInt() {
		return searchByInt;
	}

	public void setSearchByInt(int searchByInt) {
		this.searchByInt = searchByInt;
	}

	public SearchStaff() {
		ELContext context = FacesContext.getCurrentInstance().getELContext();
		application = (StaffApplication) FacesContext.getCurrentInstance().getApplication().getELResolver()
				.getValue(context, null, "staffApplication");
		application.updateStaffList();
	}

	public void searchStaffById(int staffId) {
		try {
			application.searchStaffById(staffId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		showForm = true;
	}

	public void searchAll() {
		try {
			application.searchAll();
		} catch (Exception e) {
			// TODO: handle exception
		}
		showForm = true;
	}

}
