package HibernateMappingOneOne;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import HibernateManytoone.Course;

@Entity
@Table(name="instructor")
public class Instructor 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="instructor_id")
	private int instructorId;
	
	@Column(name="first_name")
	private String FirstName;
	
	@Column(name="last_name")
	private String LastName;
	
	@Column(name="email")
	private String email;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="instructor_details_id")
	private InstructorDetails instructorDetails;
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="instructor",cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.REFRESH})
	private List<Course> courses;
	
	
	
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Instructor() {}

	public Instructor(String firstName, String lastName, String email) {
		FirstName = firstName;
		LastName = lastName;
		this.email = email;
	}

	public Instructor(String firstName, String lastName, String email, InstructorDetails instructorDetails) {
		FirstName = firstName;
		LastName = lastName;
		this.email = email;
		this.instructorDetails = instructorDetails;
	}

	public int getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public InstructorDetails getInstructorDetails() {
		return instructorDetails;
	}

	public void setInstructorDetails(InstructorDetails instructorDetails) {
		this.instructorDetails = instructorDetails;
	}

	@Override
	public String toString() {
		return "Instructor [instructorId=" + instructorId + ", FirstName=" + FirstName + ", LastName=" + LastName
				+ ", email=" + email + ", instructorDetails=" + instructorDetails + "]";
	}
	
	
	
	
	
	
	

}
