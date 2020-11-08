package assignment.mbeans;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import assignment.repository.entities.Staff;

/**
 * @author:Keyang Wang
 * @version:
 * @create time：6 Nov 2020 5:25:40 pm
 * @desc:
 */
@Named("passwordBean")
@RequestScoped
public class PasswordBean implements Serializable {
	private final static Logger LOGGER = LoggerFactory.getLogger(PasswordBean.class);
	
	@Inject
	private Staff staff;
	private String passConfirm;

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public String getPassConfirm() {
		return passConfirm;
	}

	public void setPassConfirm(String passConfirm) {
		this.passConfirm = passConfirm;
	}
	public String successInfor() throws Exception
	{
		return "success";
	}

	public void validatePass(FacesContext context, UIComponent component, Object vObject) {
		if (!staff.getStaffPassword().equals(passConfirm)) {
			String meString = context.getApplication().evaluateExpressionGet(context, "password not match",
					String.class);
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,"worng","try again");
			throw new ValidatorException(facesMessage);

		}

	}

}
