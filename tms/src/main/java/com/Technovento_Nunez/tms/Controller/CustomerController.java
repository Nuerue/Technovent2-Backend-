package com.Technovento_Nunez.tms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Technovento_Nunez.tms.Entity.CustomerEntity;
import com.Technovento_Nunez.tms.Service.CustomerService;



@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerService cserv;
	
	//printHelloStudent
    @GetMapping("/print")
    public String printHelloStudent() {
         return "Hello, Student!";
    }
    

    //Read
    @GetMapping("/displayAllCustomer")
    public List<CustomerEntity> getAllCustomer(){
        return cserv.getAllCustomer();
    }
    
  //Create or insert a item record
    @PostMapping("/postCustomer")
    public CustomerEntity insertCustomer(@RequestBody CustomerEntity customer) {
        return cserv.insertCustomer(customer);
    }
  
    //Read a record by itemName
    @GetMapping("/getByUserName")
    public CustomerEntity findByUsername(@RequestParam String username) {
        return cserv.findByUsername(username);
    }
    @PutMapping("/putCustomer")
    public CustomerEntity putCustomer(@RequestParam int id,    @RequestBody CustomerEntity newItemDetails) throws Exception {
        return cserv.putCustomer(id, newItemDetails);
    }
    
    @DeleteMapping("deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable int id) {
        return cserv.deleteCustomer(id);
    }
}
