package com.application.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.application.Entity.Hotel;
import com.application.Models.HotelModel;
import com.application.ServiceImplementaion.HotelManagementServiceImplementaion;

@RestController
public class HotelManagementController {
	
	@Autowired
	HotelManagementServiceImplementaion imp;
	
	@PutMapping(value = "/HavenHotel/Hotel/alter")
	private Hotel putHotel(@RequestBody HotelModel fields) throws Exception {
		Hotel modifyedHotel = imp.modifyHotel(fields);
		return modifyedHotel;
	}

	@PostMapping(value = "/HavenHotel/Hotel/create")
	private String postHotel(@RequestBody HotelModel fields) throws Exception {
		String createHotel = imp.createHotel(fields);
		return createHotel;
	}

	@GetMapping(value = "/HavenHotel/Hotel/retrieve")
	private Hotel getHotel(@RequestParam int hotelId) throws Exception {
		Hotel retrieveHotel = imp.retrieveHotel(hotelId);
		return retrieveHotel;
	}
	
	@GetMapping(value = "/HavenHotel/Hotel")
	private List<Hotel> getAllHotel() {
		List<Hotel> allHotel = imp.retrieveALLHotel();
		return allHotel;
	}
	
	@DeleteMapping(value = "/HavenHotel/Hotel/remove{hotelId}")
	private String deleteHotel(@PathVariable int hotelId) throws Exception {
		String removeHotel = imp.removeHotel(hotelId);
		return removeHotel;
	}
}
