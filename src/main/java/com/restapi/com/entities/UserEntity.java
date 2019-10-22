package com.restapi.com.entities;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserEntity {
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	public UserEntity() {}
	
	public UserEntity(Long id, Name name, String gender, Location location) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.location = location;
	}

	
	
	
	@Embedded
	private Name name;
	@Embedded
	private Location location;
	private String email;
	private String phone;
	private String cell;
    private String gender;
}
