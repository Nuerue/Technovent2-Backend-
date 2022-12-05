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

import com.Technovento_Nunez.tms.Entity.OrderEntity;
import com.Technovento_Nunez.tms.Service.OrderService;


@RestController
@RequestMapping("/order")
public class OrderController {
	  @Autowired
	    OrderService orderService;
	    //Create or insert an order record
	    @PostMapping("/postOrder")
	    public OrderEntity insertOrderItem(@RequestBody OrderEntity order) {
	        return orderService.insertOrderItem(order);
	    }

	    //Read all records
	    @GetMapping("/getAllOrder")
	    public List<OrderEntity> getAllOrder(){
	        return orderService.getAllOrder();
	    }

	    //Read a record by Orderitemname
	    @GetMapping("/getByOrderid")
	    public List<OrderEntity> findByOrderid(@RequestParam int orderid) {
	        return orderService.findByOrderid(orderid);
	    }
	    //Update a record
	    @PutMapping("/putOrder")
	    public OrderEntity putOrder(@RequestParam int orderid,    @RequestBody OrderEntity newOrderDetails) throws Exception {
	        return orderService.putOrder(orderid, newOrderDetails);
	    }

	    @DeleteMapping("deleteOrder/{orderid}")
	    public String deleteOrder(@PathVariable int orderid) {
	        return orderService.deleteOrder(orderid);
	    }
}
