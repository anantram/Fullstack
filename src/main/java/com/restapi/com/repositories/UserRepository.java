package com.restapi.com.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.restapi.com.entities.UserEntity;
import com.restapi.com.projections.UserListProjection;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

//    List<UserEntity> findByName(String lastName);
//    List<> findAllNames();
	
	List<UserListProjection> findBy();
	

}

