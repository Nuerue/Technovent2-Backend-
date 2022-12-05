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

import com.Technovento_Nunez.tms.Entity.ManagerEntity;
import com.Technovento_Nunez.tms.Service.ManagerService;

@RestController
@RequestMapping("/manager")
public class ManagerController {
	@Autowired
	ManagerService mserv;
	
	//printHelloStudent
    @GetMapping("/print")
    public String printHelloStudent() {
         return "Hello, Student!";
    }
    

    //Read
    @GetMapping("/displayAllManager")
    public List<ManagerEntity> getAllManager(){
        return mserv.getAllManager();
    }
    
  //Create or insert a item record
    @PostMapping("/postManager")
    public ManagerEntity insertManager(@RequestBody ManagerEntity customer) {
        return mserv.insertManager(customer);
    }
  
    //Read a record by itemName
    @GetMapping("/getByUserName")
    public ManagerEntity findByUsername(@RequestParam String username) {
        return mserv.findByUsername(username);
    }
    @PutMapping("/putManager")
    public ManagerEntity putManager(@RequestParam int id,    @RequestBody ManagerEntity newItemDetails) throws Exception {
        return mserv.putManager(id, newItemDetails);
    }
    
    @DeleteMapping("deleteManager/{id}")
    public String deleteManager(@PathVariable int id) {
        return mserv.deleteManager(id);
    }
}
