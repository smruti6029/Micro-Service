package com.hotel.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.entity.Hotel;
import com.hotel.repository.HotelRepository;
import com.hotel.service.HotelService;

@Service
public class HotelServiceImp implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Hotel save(Hotel hotel) {

		return hotelRepository.save(hotel);
		
	}

	@Override
	public List<Hotel> getallHotel() {
		// TODO Auto-generated method stub
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getbId(Integer id) {
		 Optional<Hotel> findById = hotelRepository.findById(id);
		 
		  return findById.orElse(null);
		 
	}

}
