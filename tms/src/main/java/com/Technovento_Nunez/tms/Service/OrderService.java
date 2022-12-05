package com.Technovento_Nunez.tms.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Technovento_Nunez.tms.Entity.OrderEntity;
import com.Technovento_Nunez.tms.Repository.InventoryRepository;
import com.Technovento_Nunez.tms.Repository.OrderRepository;


@Service
public class OrderService {
	@Autowired
	OrderRepository srepo;
	InventoryRepository irepo;
	
	//C - Create or insert an order record
	public OrderEntity insertOrderItem(OrderEntity order) {
		order.setTotal(order.getInventory().getItemprice() *order.getQuantity());
		return srepo.save(order);
	}	
	
	//R - Read all records from tbl_order
	public List<OrderEntity> getAllOrder(){
        return srepo.findAll();
    }
	
	//R - Read or search student record by order item name
	public List<OrderEntity>  findByOrderid(int orderid) {
		if (srepo.findByOrderid(orderid) != null)
			return srepo.findByOrderid(orderid);
		else
			return null;
	}
	//U - Update a order record
	public OrderEntity putOrder(int orderid, OrderEntity newOrderDetails) throws Exception{
		
		OrderEntity order = new OrderEntity();
		
		try {
			 //Search the ID number of an order
			order = srepo.findById(orderid).get();
			  
            //update the record
			order.setQuantity(newOrderDetails.getQuantity());
			order.setTotal(newOrderDetails.getInventory().getItemprice()*order.getQuantity());
			 //Save the information and return the value
			return srepo.save(order);
		}catch(NoSuchElementException nex) {
			 //throws an error if the id does not exist
			throw new Exception("Order ID Number "+ orderid + "does not exist");
		}
	}
		
		//D- Delete order record
		public String deleteOrder(int orderid) {
			String msg;
			if(srepo.findById(orderid) != null) {
				srepo.deleteById(orderid);//find the order id number of the customer to be deleted
				msg = "Order ID Number " + orderid + " is successfully deleted!";
			}
			else 
				msg = "Order ID Number" + orderid + "is NOT found!";
			return msg;
		}
}
