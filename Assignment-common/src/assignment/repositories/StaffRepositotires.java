package assignment.repositories;

import java.util.List;

import assignment.repository.entities.Staff;
import assignment.repository.entities.Staffgroup;

/**
 * @author:Keyang Wang
 * @version:
 * @create time：23 Sep 2020 1:44:39 pm
 * @desc:
 */
public interface StaffRepositotires {
	public void addStaff(Staff staff) throws Exception;

	public Staff searchStaff(int id) throws Exception;

	public List<Staff> getAllStaffs() throws Exception;

	public void removeStaff(int staffId) throws Exception;

	public void editStaff(Staff staff) throws Exception;
	
	public List<Staff> combineSearch(String keyString) throws Exception;

}
