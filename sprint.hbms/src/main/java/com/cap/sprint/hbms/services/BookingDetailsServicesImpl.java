package com.cap.sprint.hbms.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.sprint.hbms.entities.BookingDetails;
import com.cap.sprint.hbms.entities.Hotel;
import com.cap.sprint.hbms.entities.RoomDetails;
import com.cap.sprint.hbms.exceptions.NotFoundException;
import com.cap.sprint.hbms.repos.IBookingDetailsRepository;


@Service
public class BookingDetailsServicesImpl {
	
	@Autowired
	IBookingDetailsRepository iBookingDetailsRepository;
	
	@Autowired
	RoomDetailsServicesImpl roomDetailsServicesImpl;
	
	@Autowired
	HotelServicesImpl hotelServicesImpl;
	
	@Transactional
	public BookingDetails addBookingDetails(BookingDetails bd) {
		
		List<RoomDetails> rooms = new ArrayList<RoomDetails>();
		Optional<Hotel> hotel= hotelServicesImpl.viewHotel(bd.getHotel().getHotelId());
		
		for(RoomDetails rd : bd.getRoomDetailsList())
		{
	
			rooms.add(roomDetailsServicesImpl.findRoomDetails(rd.getRoomId()));
		
	
			
		}
		bd.setHotel(hotel.get());
		bd.setRoomDetailsList(rooms);
		return iBookingDetailsRepository.save(bd);
	
	}
	
				
// Update BookingDetails	
	@Transactional
	public BookingDetails updateBookingDetails(BookingDetails bd3) {
	
		BookingDetails updateBookingDetails=iBookingDetailsRepository.findByBookingId(bd3.getBookingId());

		if(bd3.getNoOfAdults()!=0)
		{updateBookingDetails.setNoOfAdults(bd3.getNoOfAdults());}
		if(bd3.getNoOfChildren()!=0)
		{updateBookingDetails.setNoOfChildren(bd3.getNoOfChildren());}
		
		
		return updateBookingDetails;
	}
		
// Delete BookingDetails	
			public void removeBookingDetails(int id) {
				Optional<BookingDetails> bd = iBookingDetailsRepository.findById(id);
				if(bd.isPresent())
					iBookingDetailsRepository.deleteById(id);
				
				else throw new NotFoundException("No Booking Details found with this id"+ id);
				
				}
	
			
			
// Show BookingDetails
			public Optional<BookingDetails> viewBookingDetails(int bookingId) {
				Optional<BookingDetails> findBookingDetails=iBookingDetailsRepository.findById(bookingId);
				System.out.println(findBookingDetails);
				return findBookingDetails;
			}
			
			
// Show All BookingDetails	
			public List<BookingDetails>viewBookingDetailsList(){
				List<BookingDetails>bookingdetails=iBookingDetailsRepository.findAll();
				return bookingdetails;
			}
			
}
	
	
	


