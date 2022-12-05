package com.Technovento_Nunez.tms.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_order")
public class OrderEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int orderid;
	 private double total;
	 private int quantity;
	 
	 @ManyToOne
	 @JoinColumn(name ="itemid")
	 InventoryEntity inventory;
	 
	 @ManyToOne
	 @JoinColumn(name ="customerusername")
	 CustomerEntity customer;

	 
	 public OrderEntity() {}

	public OrderEntity(int orderid, double total, int quantity, InventoryEntity inventory, CustomerEntity customer) {
		super();
		this.orderid = orderid;
		this.total = total;
		this.quantity = quantity;
		this.inventory = inventory;
		this.customer = customer;
	}


	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public InventoryEntity getInventory() {
		return inventory;
	}

	public void setInventory(InventoryEntity inventory) {
		this.inventory = inventory;
	}
	
}
