package com.example.nxtstayz.service;

import java.util.List;

import com.example.nxtstayz.model.Hotel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelJpaService extends JpaRepository<Hotel, Integer> {

    // Custom query method to find hotels by location
    List<Hotel> findByLocation(String location);

    // Custom query method to find hotels with a rating greater than or equal to a
    // given rating
    List<Hotel> findByRatingGreaterThanEqual(int rating);

    // Custom query method to find hotels with a name containing a certain keyword
    List<Hotel> findByHotelNameContaining(String keyword);

    // Add more custom query methods as needed based on your entity attributes
    // Example:
    // List<Hotel> findBySomeOtherAttribute(String attributeValue);
}
