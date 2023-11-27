package com.ratingservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ratingservice.entity.Rating;
import com.ratingservice.service.RatingService;

import java.util.List;

@RestController
@RequestMapping("/ratings/")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> saveRating(@RequestBody Rating rating) {
        Rating savedRating = ratingService.save(rating);
        return new ResponseEntity<>(savedRating, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings() {
        List<Rating> ratings = ratingService.getAllRating();
        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }

    @GetMapping("/byUserId/{userId}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable Integer userId) {
        List<Rating> ratings = ratingService.getratingByuserId(userId);
        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }

    @GetMapping("/byHotelId/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable Integer hotelId) {
        List<Rating> ratings = ratingService.getratingByHotelId(hotelId);
        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }

    // You can add more methods for other CRUD operations or additional functionality

}
