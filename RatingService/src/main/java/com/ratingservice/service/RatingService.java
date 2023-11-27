package com.ratingservice.service;

import java.util.List;

import com.ratingservice.entity.Rating;

public interface RatingService {
	
	
	public Rating save(Rating rating);
	
	public List<Rating> getAllRating();
	
	public List<Rating> getratingByuserId(Integer userId);
	
	public List<Rating> getratingByHotelId(Integer hotelId);
	
	
	
	

}
