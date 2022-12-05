package com.Technovento_Nunez.tms.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Technovento_Nunez.tms.Entity.InventoryEntity;
import com.Technovento_Nunez.tms.Repository.InventoryRepository;



@Service
public class InventoryService {
	@Autowired
	InventoryRepository irepo;
	//Read all records from tbl_course
	
    public List<InventoryEntity> getAllItem(){
        return irepo.findAll();
    }
//C - Create or insert a course record
    public InventoryEntity insertItems(InventoryEntity item) {
        return irepo.save(item);
    }
//R - Read or search course record by Code
    public InventoryEntity findByItemName(String item) {
        if (irepo.findByItemname(item) != null)
            return irepo.findByItemname(item);
        else
            return null;
    } 
  //U - Update a course record
    public InventoryEntity putItem(int id,InventoryEntity newItemDetails) throws Exception{
    	InventoryEntity item = new InventoryEntity();
    	try {
    		item = irepo.findById(id).get();
    		item.setItemname(newItemDetails.getItemname());
    		item.setItemprice(newItemDetails.getItemprice());
    		item.setQuantity(newItemDetails.getQuantity());
    		item.setItemdescription(newItemDetails.getItemdescription());
    	
    		
    		return irepo.save(item);
    		
    	}catch(NoSuchElementException nex){
    		throw new Exception("ID number "+id+" does not exist!");
    	}
    	
    }
  //D - Delete a course record
    public String deleteItem(int id) {
        String msg;
        if(irepo.findById(id) != null) {
        	irepo.deleteById(id); //find the id number of the student to be deleted
            msg = "Item ID Number: " + id + " was successfully deleted!";
        } else {
            msg = "Item ID Number: " + id + " was NOT found!";
        }
        
        return msg;
    }
}
