package com.cap.sprint.hbms.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cap.sprint.hbms.entities.Hotel;
import com.cap.sprint.hbms.entities.RoomDetails;

@Repository
public interface IRoomDetailsRepository extends JpaRepository<RoomDetails, Integer>{
	
	public RoomDetails findByRoomNo(String roomNo);
//	public Optional<RoomDetails> findByRoomNoAndRoomType(String roomNo, String roomType);

	public RoomDetails findByRoomId(int roomId);

//	public Hotel findByHotelname(String name);

}
