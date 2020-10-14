package assignment.repository.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the STAFFGROUPS database table.
 * 
 */
@Entity
@Table(name = "STAFFGROUPS")
@NamedQueries({
		@NamedQuery(name = Staffgroup.GET_ALL_QUERY_NAME, query = "SELECT s FROM Staffgroup s order by s.id desc") })
public class Staffgroup implements Serializable {
	public static final String GET_ALL_QUERY_NAME = "Staffgroup.getAll";
	private int id;
	private String staffGroup;
	private int staffId;

	public Staffgroup() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "STAFF_GROUP")
	public String getStaffGroup() {
		return this.staffGroup;
	}

	public void setStaffGroup(String staffGroup) {
		this.staffGroup = staffGroup;
	}

	@Column(name = "STAFF_ID")
	public int getStaffId() {
		return this.staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

}