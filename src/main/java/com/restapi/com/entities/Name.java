package com.restapi.com.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Name {
	public Name()
	{
		
	}
	public Name(String firstName, String middleName, String lastName) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name="FIRST_NAME", length=16)
	public String firstName;
	@Column(name="MIDDLE_NAME", length=16)
	public String middleName;
	@Column(name="LAST_NAME", length=16)
	public String lastName;
}
