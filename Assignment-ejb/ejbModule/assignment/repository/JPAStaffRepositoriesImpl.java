package assignment.repository;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.javaXmlTypeMappingType;

import assignment.repositories.StaffRepositotires;
import assignment.repository.entities.Staff;
import assignment.repository.entities.Staffgroup;

/**
 * @author:Keyang Wang
 * @version:
 * @create time：28 Sep 2020 2:43:35 pm
 * @desc:
 */
@Stateless
public class JPAStaffRepositoriesImpl implements StaffRepositotires {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void addStaff(Staff staff) throws Exception {
		// TODO Auto-generated method stub
		List<Staff> staffs = entityManager.createNamedQuery(Staff.GET_ALL_QUERY_NAME).getResultList();
		staff.setStaffId(staffs.get(0).getStaffId() + 1);
		List<Staffgroup> staffgroups = entityManager.createNamedQuery(Staffgroup.GET_ALL_QUERY_NAME).getResultList();
		Staffgroup staffgroup = new Staffgroup();
		staffgroup.setId(staffgroups.get(0).getId() + 1);
		staffgroup.setStaffGroup("user");
		staffgroup.setStaffId(staff.getStaffId());
		entityManager.persist(staff);
		entityManager.persist(staffgroup);
//		List<Staffgroup> staffgroups =entityManager.createNamedQuery(Staffgroup.GET_ALL_QUERY_NAME).getResultList();
//		Staffgroup staffgroup = new Staffgroup();
//		staffgroup.setId(staffgroups.get(0).getId()+1);
//		staffgroup.setStaffAccount(staff.getStaffAccount());
//		staffgroup.setStaffGroup("normaluser");
//		entityManager.persist(staffgroups);
		entityManager.flush();

	}

	@Override
	public Staff searchStaff(int id) throws Exception {
		// TODO Auto-generated method stub
		Staff staff = entityManager.find(Staff.class, id);
		return staff;
	}

	@Override
	public List<Staff> getAllStaffs() throws Exception {
		// TODO Auto-generated method stub
		return entityManager.createNamedQuery(Staff.GET_ALL_QUERY_NAME).getResultList();
	}

	@Override
	public void removeStaff(int staffId) throws Exception {
		// TODO Auto-generated method stub
		Staff staff = entityManager.find(Staff.class, staffId);
		if (staff != null) {
			entityManager.remove(staff);

		}

	}

	@Override
	public void editStaff(Staff staff) throws Exception {
		// TODO Auto-generated method stub
		try {
			entityManager.merge(staff);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public List<Staff> combineSearch(String keyString) throws Exception {
		// TODO Auto-generated method stub
//		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		//return entities of type staff
//		CriteriaQuery query = criteriaBuilder.createQuery(Staff.class);
		//evaluate staff entity
//		Root<Staff> root = query.from(Staff.class);
//		Predicate predicate = criteriaBuilder.like(root.get("staffLname"), "%"+keyString+"%");
//		List<Predicate> list = new ArrayList<Predicate>();
//		query.where(predicate);
//		TypedQuery typedQuery = entityManager.createQuery(query);
		javax.persistence.Query query = entityManager.createNamedQuery(Staff.GET_ALL_QUERY_NAME1);	
		query.setParameter(1, keyString);
		List<Staff> staffs = query.getResultList();	
		return staffs;
	}

}
