package com.user.serviceImp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.entity.Hotel;
import com.user.entity.Rating;
import com.user.entity.User;
import com.user.repository.UserRepository;
import com.user.service.UserService;

@Service
public class UserServiceimp implements UserService {

	@Autowired
	private UserRepository userRepoistory;

	@Autowired
	private RestTemplate restTemplate;

	private static final Logger log = LoggerFactory.getLogger(UserServiceimp.class);

	@Override
	public User save(User user) {

		User save = userRepoistory.save(user);

		return save;
	}

	@Override
	public List<User> getAlluser() {

		List<User> users = userRepoistory.findAll();

		for(User u:users)
		{
			Rating[] forObject = restTemplate.getForObject("http://RATING-SERVICE/ratings/byUserId/" + u.getId(),
					Rating[].class);

			List<Rating> list = Arrays.stream(forObject).toList();

			List<Rating> ratings = list.stream().map(rating -> {

				ResponseEntity<Hotel> forEntity = restTemplate
						.getForEntity("http://HOTEL-SERVICE/hotel/" + rating.getHotelId(), Hotel.class);
				Hotel hotel = forEntity.getBody();
				rating.setHotel(hotel);

				return rating;
			}).collect(Collectors.toList());
			
			u.setRatings(ratings);
			
		}

		
		return users;
	}

	@Override
	public User getUserByid(Integer id) {

		User user = userRepoistory.findById(id).orElse(null);
		Rating[] forObject = restTemplate.getForObject("http://RATING-SERVICE/ratings/byUserId/" + user.getId(),
				Rating[].class);

		List<Rating> list = Arrays.stream(forObject).toList();

		List<Rating> ratings = list.stream().map(rating -> {

			ResponseEntity<Hotel> forEntity = restTemplate
					.getForEntity("http://HOTEL-SERVICE/hotel/" + rating.getHotelId(), Hotel.class);
			Hotel hotel = forEntity.getBody();
			rating.setHotel(hotel);

			return rating;
		}).collect(Collectors.toList());

		user.setRatings(ratings);

		log.info("{}", forObject);
		return user;
	}

}
