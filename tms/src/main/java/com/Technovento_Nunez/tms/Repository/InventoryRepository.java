package com.Technovento_Nunez.tms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Technovento_Nunez.tms.Entity.InventoryEntity;

public interface InventoryRepository extends JpaRepository<InventoryEntity,Integer>{
	InventoryEntity findByItemname(String itemname);
}

