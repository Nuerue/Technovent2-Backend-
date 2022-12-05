package com.Technovento_Nunez.tms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Technovento_Nunez.tms.Entity.CustomerEntity;


public interface CustomerRepository extends JpaRepository<CustomerEntity,Integer>{
	CustomerEntity findByUsername(String username);
}
