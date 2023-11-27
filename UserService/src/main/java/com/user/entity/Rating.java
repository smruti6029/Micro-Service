package com.user.entity;

public class Rating {
	
	private Integer id;
	
	private Integer userId;
	
	private Integer hotelId;
	
	private Integer rating;
	
	private String remark;
	
	private Hotel hotel;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getHotelId() {
		return hotelId;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rating(Integer id, Integer userId, Integer hotelId, Integer rating, String remark) {
		super();
		this.id = id;
		this.userId = userId;
		this.hotelId = hotelId;
		this.rating = rating;
		this.remark = remark;
	}
	
	

}
