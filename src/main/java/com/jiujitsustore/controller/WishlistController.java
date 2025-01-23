package com.jiujitsustore.controller;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.ArrayList;


import com.jiujitsustore.util.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.Date;

import com.jiujitsustore.domain.Wishlist;
import com.jiujitsustore.dto.WishlistDTO;
import com.jiujitsustore.dto.WishlistSearchDTO;
import com.jiujitsustore.dto.WishlistPageDTO;
import com.jiujitsustore.service.WishlistService;
import com.jiujitsustore.dto.common.RequestDTO;
import com.jiujitsustore.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/wishlist")
@RestController
public class WishlistController {

	private final static Logger logger = LoggerFactory.getLogger(WishlistController.class);

	@Autowired
	WishlistService wishlistService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<Wishlist> getAll() {

		List<Wishlist> wishlists = wishlistService.findAll();
		
		return wishlists;	
	}

	@GetMapping(value = "/{wishlistId}")
	@ResponseBody
	public WishlistDTO getWishlist(@PathVariable Integer wishlistId) {
		
		return (wishlistService.getWishlistDTOById(wishlistId));
	}

 	@RequestMapping(value = "/addWishlist", method = RequestMethod.POST)
	public ResponseEntity<?> addWishlist(@RequestBody WishlistDTO wishlistDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = wishlistService.addWishlist(wishlistDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/wishlists")
	public ResponseEntity<WishlistPageDTO> getWishlists(WishlistSearchDTO wishlistSearchDTO) {
 
		return wishlistService.getWishlists(wishlistSearchDTO);
	}	

	@RequestMapping(value = "/updateWishlist", method = RequestMethod.POST)
	public ResponseEntity<?> updateWishlist(@RequestBody WishlistDTO wishlistDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = wishlistService.updateWishlist(wishlistDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
