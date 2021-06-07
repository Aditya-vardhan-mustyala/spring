package form_validation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import CustomValidators.CheckAddress;

public class Customer
{
	private String firstName;
	
	//@NotNull(message="required")
	@Size(min =1,message="length should be min 1")
	private String lastName;

	@CheckAddress(val="ind",message="should be from india")
	private String address;
	
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	
	

}
