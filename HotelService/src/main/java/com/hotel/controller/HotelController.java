package com.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.entity.Hotel;
import com.hotel.service.HotelService;

@RestController
@RequestMapping("/hotel/")
public class HotelController {

	@Autowired
	private HotelService hotelService;

	@PostMapping("/save")
	public ResponseEntity<?> saveHotel(@RequestBody Hotel hotel) {
		Hotel save = hotelService.save(hotel);
		return ResponseEntity.ok(save);
	}

	
	@GetMapping("/all")
	public ResponseEntity<?> getallHotel() {
		return ResponseEntity.ok(hotelService.getallHotel());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getHotelbyid(@PathVariable Integer id) {
		return ResponseEntity.ok(hotelService.getbId(id));
	}
	
	
}
