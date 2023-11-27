package com.ratingservice.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratingservice.entity.Rating;
import com.ratingservice.repository.RatingRepositoty;
import com.ratingservice.service.RatingService;

@Service
public class RatingServiceImp implements RatingService {
	
	@Autowired
	private RatingRepositoty ratingRepositoty;

	@Override
	public Rating save(Rating rating) {
		
		return ratingRepositoty.save(rating);
	}

	@Override
	public List<Rating> getAllRating() {
		return ratingRepositoty.findAll();
	}

	@Override
	public List<Rating> getratingByuserId(Integer userId) {
		 return ratingRepositoty.findByUserId(userId);
	}

	@Override
	public List<Rating> getratingByHotelId(Integer hotelId) {
		return ratingRepositoty.findByHotelId(hotelId);
	}

}
