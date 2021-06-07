package json.demo;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Student 
{
	private int id;
	private String firstName;
	private String lastName;
	private boolean active;
	private Address address;
	private String[] languages;
	
	
	public Student() {}

	public Student(int id, String firstName, String lastName, boolean active) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.active = active;
	}

	
	
	public Student(int id, String firstName, String lastName, boolean active, Address address, String[] languages) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.active = active;
		this.address = address;
		this.languages = languages;
	}

	public String[] getLanguages() {
		return languages;
	}

	public void setLanguages(String[] lang) {
		this.languages = lang;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address add) {
		this.address= add;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", active=" + active
				+ ", address=" + address + ", languages=" + Arrays.toString(languages) + "]";
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	

}
