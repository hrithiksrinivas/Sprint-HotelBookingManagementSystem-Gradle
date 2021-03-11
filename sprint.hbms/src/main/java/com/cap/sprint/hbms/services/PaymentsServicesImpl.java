package com.cap.sprint.hbms.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.sprint.hbms.entities.BookingDetails;
import com.cap.sprint.hbms.entities.Hotel;
import com.cap.sprint.hbms.entities.Payments;
import com.cap.sprint.hbms.entities.RoomDetails;
import com.cap.sprint.hbms.repos.IPaymentsRepository;
import com.cap.sprint.hbms.services_interfaces.IPaymentsService;

@Service
public class PaymentsServicesImpl implements IPaymentsService
{
	@Autowired
	IPaymentsRepository paymentRepository;
	
	
	
	@Autowired
	BookingDetailsServicesImpl bookingDetailsServicesImpl;
	
	@Transactional
	public Payments addPayment(Payments payment)
	{
		Optional <BookingDetails> bd= bookingDetailsServicesImpl.viewBookingDetails(payment.getBookingDetails().getBookingId());
		
		payment.setBookingDetails(bd.get());
		paymentRepository.save(payment);
			return payment;
	}
	
	public Optional<Payments> viewPayments(int paymentId)
	{
			Optional<Payments> payments = paymentRepository.findById(paymentId);
			return payments;
	}
	


}