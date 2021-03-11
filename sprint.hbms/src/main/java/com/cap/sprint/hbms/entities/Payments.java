package com.cap.sprint.hbms.entities;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "Details about Payment During Booking")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class, 
		property = "paymentId")
public class Payments {
	@Id
	@SequenceGenerator(name="payment_sequence",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "payment_sequence")
	@ApiModelProperty(notes = "Hotel id for a booking")
	private int paymentId;
	
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name ="booking_id")
	@ApiModelProperty(notes = "Booking Details Of User")
	private BookingDetails bookingDetails;
	
	@OneToOne(mappedBy = "payments", cascade = CascadeType.PERSIST)
	//@JoinColumn(name="transaction_id",insertable = false)
	@ApiModelProperty(notes = "Transactions Details Of User")
	private Transactions transactions;
	
	
	
	

	public int getPaymentId() {
		return paymentId;
	}



	public BookingDetails getBookingDetails() {
		return bookingDetails;
	}



	public void setBookingDetails(BookingDetails bookingDetails) {
		this.bookingDetails = bookingDetails;
	}

	


public Payments(int paymentId, BookingDetails bookingDetails) {
		super();
		this.paymentId = paymentId;
		this.bookingDetails = bookingDetails;
	}



	public Transactions getTransaction() {
		return transactions;
	}



	public void setTransaction(Transactions transactions) {
		this.transactions = transactions;
	}



	public Payments(BookingDetails bookingDetails, Transactions transactions) {
		super();
		this.bookingDetails = bookingDetails;
		this.transactions = transactions;
	}
	
	public Payments() {
		
	}



public Payments(BookingDetails bookingDetails) {
	super();
	this.bookingDetails = bookingDetails;
}
	
	



	@Override
	public String toString() {
		return "Payments [paymentId=" + paymentId + ", bookingDetails=" + bookingDetails + ", transactions=" + transactions
				+ "]";
	}

}