package com.hotel.service;

import java.util.List;

import com.hotel.entity.Hotel;

public interface HotelService {
	
	public Hotel save(Hotel hotel);
	
	public List<Hotel> getallHotel();
	
	public Hotel getbId(Integer id);

}
