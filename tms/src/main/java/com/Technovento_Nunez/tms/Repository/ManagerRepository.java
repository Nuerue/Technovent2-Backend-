package com.Technovento_Nunez.tms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Technovento_Nunez.tms.Entity.ManagerEntity;

public interface ManagerRepository extends JpaRepository<ManagerEntity,Integer>{
	ManagerEntity findByUsername(String username);

}
