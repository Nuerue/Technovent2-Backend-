package com.Technovento_Nunez.tms.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_payment")
public class PaymentEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int paymentid;
	private String paymentmethod;
	private int cash; 
	private int remainingpayment;
	
	public PaymentEntity() {}
	
	public int getPaymentid() {
		return paymentid;
	}
	public void setPaymentid(int paymentid) {
		this.paymentid = paymentid;
	}

	public String getPaymentmethod() {
		return paymentmethod;
	}
	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}
	public int getCash() {
		return cash;
	}
	public void setCash(int cash) {
		this.cash = cash;
	}
	public int getRemainingpayment() {
		return remainingpayment;
	}
	public void setRemainingpayment(int remainingpayment) {
		this.remainingpayment = remainingpayment;
	}


	
}
