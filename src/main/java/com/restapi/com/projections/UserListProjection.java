package com.restapi.com.projections;

public interface UserListProjection {
	NameSummary getName();
	
	interface NameSummary {
		    String getFirstName();
		    String getMiddleName();
		    String getLastName();
		  }
	
	Long getId();
}
