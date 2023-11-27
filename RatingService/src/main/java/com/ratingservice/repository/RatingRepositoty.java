package com.ratingservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ratingservice.entity.Rating;

@Repository
public interface RatingRepositoty extends JpaRepository<Rating, Integer>{
	
//	@Query(value = "SELECT * FROM rating_service WHERE user_id = :userId", nativeQuery = true)
	@Query(value = "SELECT r FROM Rating r WHERE userId = :userId")
    List<Rating> findByUserId(Integer userId);

    @Query(value = "SELECT * FROM rating_service WHERE hotel_id = :hotelId", nativeQuery = true)
    List<Rating> findByHotelId(Integer hotelId);

}
