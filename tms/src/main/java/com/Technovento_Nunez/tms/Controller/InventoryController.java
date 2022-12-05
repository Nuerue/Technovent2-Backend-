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

import com.Technovento_Nunez.tms.Entity.InventoryEntity;
import com.Technovento_Nunez.tms.Service.InventoryService;



@RestController
@RequestMapping("/inventory")
public class InventoryController {
	
	@Autowired
    InventoryService invserv;
	
	
	 //printHelloStudent
    @GetMapping("/print")
    public String printHelloStudent() {
         return "Hello, Student!";
    }
    

    //Read
    @GetMapping("/displayAllItems")
    public List<InventoryEntity> getAllItems(){
        return invserv.getAllItem();
    }
    
  //Create or insert a item record
    @PostMapping("/postItem")
    public InventoryEntity insertItem(@RequestBody InventoryEntity item) {
        return invserv.insertItems(item);
    }
  
    //Read a record by itemName
    @GetMapping("/getByItemName")
    public InventoryEntity findByItemName(@RequestParam String itemname) {
        return invserv.findByItemName(itemname);
    }
    @PutMapping("/putItem")
    public InventoryEntity putItem(@RequestParam int id,    @RequestBody InventoryEntity newItemDetails) throws Exception {
        return invserv.putItem(id, newItemDetails);
    }
    
    @DeleteMapping("deleteItem/{id}")
    public String deleteItem(@PathVariable int id) {
        return invserv.deleteItem(id);
    }
}
