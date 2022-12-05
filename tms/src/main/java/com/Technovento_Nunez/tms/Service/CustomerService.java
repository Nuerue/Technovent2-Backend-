package com.Technovento_Nunez.tms.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Technovento_Nunez.tms.Entity.CustomerEntity;
import com.Technovento_Nunez.tms.Repository.CustomerRepository;



@Service
public class CustomerService {
	@Autowired
	CustomerRepository crepo;
	
//Read all records from tbl_course
	
    public List<CustomerEntity> getAllCustomer(){
        return crepo.findAll();
    }
//C - Create or insert a course record
    public CustomerEntity insertCustomer(CustomerEntity customer) {
        return crepo.save(customer);
    }
//R - Read or search course record by Code
    public CustomerEntity findByUsername(String username) {
        if (crepo.findByUsername(username) != null)
            return crepo.findByUsername(username);
        else
            return null;
    } 
  //U - Update a course record
    public CustomerEntity putCustomer(int id,CustomerEntity newItemDetails) throws Exception{
    	CustomerEntity item = new CustomerEntity();
    	try {
    		item = crepo.findById(id).get();
    		item.setUsername(newItemDetails.getUsername());
    		item.setFirstname(newItemDetails.getFirstname());
    		item.setLastname(newItemDetails.getLastname());
    		item.setPassword(newItemDetails.getPassword());
    		item.setAge(newItemDetails.getAge());
    		item.setAddress(newItemDetails.getAddress());
    		return crepo.save(item);
    		
    	}catch(NoSuchElementException nex){
    		throw new Exception("ID number "+id+" does not exist!");
    	}
    	
    }
  //D - Delete a course record
    public String deleteCustomer(int id) {
        String msg;
        if(crepo.findById(id) != null) {
        	crepo.deleteById(id); //find the id number of the student to be deleted
            msg = "Item ID Number: " + id + " was successfully deleted!";
        } else {
            msg = "Item ID Number: " + id + " was NOT found!";
        }
        
        return msg;
    }
	
}
