package com.application.ServiceImplementaion;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.application.Entity.Hotel;
import com.application.Models.HotelModel;
import com.application.Repository.HotelManagementRepository;
import com.application.Service.HotelManagementService;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Component
public class HotelManagementServiceImplementaion implements HotelManagementService {

	@Autowired
	HotelManagementRepository repo;

	@Override
	public Hotel modifyHotel(HotelModel fields) throws Exception {
		Optional<Hotel> findById = repo.findById(fields.getHotelId());

		if (findById.isPresent() == true) {
			Hotel hotel = findById.get();
			if (fields.getHotelName() != null) {
				hotel.setHotelName(fields.getHotelName());
			}
			if (fields.getPhoneNumber() != 0) {
				hotel.setPhoneNumber(fields.getPhoneNumber());
			}
			if (fields.getEmailId() != null) {
				hotel.setEmailId(fields.getEmailId());
			}
			if (fields.getStateName() != null) {
				hotel.setStateName(fields.getStateName());
			}
			if (fields.getAreaName() != null) {
				hotel.setAreaName(fields.getAreaName());
			}
			if (fields.getStreetName() != null) {
				hotel.setStreetName(fields.getStreetName());
			}
			if (fields.getDistrictName() != null) {
				hotel.setDistrictName(fields.getDistrictName());
			}
			if (fields.getPincode() != 0) {
				hotel.setPincode(fields.getPincode());
			}
			if (fields.getGstNumber() != null) {
				hotel.setGstNumber(fields.getGstNumber());
			}
			if (fields.getOpenTime() != null) {
				hotel.setOpenTime(fields.getOpenTime());
			}
			if (fields.getOpenTime() != null) {
				hotel.setOpenTime(fields.getOpenTime());
			}
			Hotel save = repo.save(hotel);
			return save;
		} else {
			throw new EntityNotFoundException("hotel Id not found :" + fields.getHotelId());
		}
	}

	@Override
	public String createHotel(HotelModel fields) throws Exception {
		Optional<Hotel> findByDishName = repo.findByHotelName(fields.getHotelName());
		if (findByDishName.isPresent() == true) {
			throw new EntityExistsException("hotel already exist :" + fields.getHotelName());
		} else {
			Hotel hotel = new Hotel();
			hotel.setHotelName(fields.getHotelName());
			hotel.setAreaName(fields.getAreaName());
			hotel.setCloseTime(fields.getCloseTime());
			hotel.setDistrictName(fields.getDistrictName());
			hotel.setEmailId(fields.getEmailId());
			hotel.setGstNumber(fields.getGstNumber());
			hotel.setOpenTime(fields.getOpenTime());
			hotel.setPhoneNumber(fields.getPhoneNumber());
			hotel.setPincode(fields.getPincode());
			hotel.setStateName(fields.getStateName());
			hotel.setStreetName(fields.getStreetName());
			repo.save(hotel);
			return "hotel created successfully";
		}
	}

	@Override
	public Hotel retrieveHotel(int hotelId) throws Exception {
		Hotel byHotelName = repo.getByHotelId(hotelId);
		if (byHotelName == null) {
			throw new EntityNotFoundException("hotel not found");
		} else {
			return byHotelName;
		}
	}

	@Override
	public String removeHotel(int HotelId) throws Exception {
		repo.deleteById(HotelId);
		return "deleted";
	}

	@Override
	public List<Hotel> retrieveALLHotel() {
		List<Hotel> findAll = repo.findAll();
		return findAll;
	}

}
