package assignment.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
* @author:Keyang Wang
* @version:
* @create time：23 Sep 2020 3:59:49 pm
* @desc:
*/
@Named(value = "titleController")
@RequestScoped
public class TitleController {
	private String pageTitle;
	public TitleController() {
		pageTitle = "AUSPrintings Pty Ltd";
	}
	public String getPageTitle() {
		return pageTitle;
	}
	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}
	
	
}
