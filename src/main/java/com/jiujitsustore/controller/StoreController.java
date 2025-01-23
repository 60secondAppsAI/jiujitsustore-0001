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

import com.jiujitsustore.domain.Store;
import com.jiujitsustore.dto.StoreDTO;
import com.jiujitsustore.dto.StoreSearchDTO;
import com.jiujitsustore.dto.StorePageDTO;
import com.jiujitsustore.service.StoreService;
import com.jiujitsustore.dto.common.RequestDTO;
import com.jiujitsustore.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/store")
@RestController
public class StoreController {

	private final static Logger logger = LoggerFactory.getLogger(StoreController.class);

	@Autowired
	StoreService storeService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<Store> getAll() {

		List<Store> stores = storeService.findAll();
		
		return stores;	
	}

	@GetMapping(value = "/{storeId}")
	@ResponseBody
	public StoreDTO getStore(@PathVariable Integer storeId) {
		
		return (storeService.getStoreDTOById(storeId));
	}

 	@RequestMapping(value = "/addStore", method = RequestMethod.POST)
	public ResponseEntity<?> addStore(@RequestBody StoreDTO storeDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = storeService.addStore(storeDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/stores")
	public ResponseEntity<StorePageDTO> getStores(StoreSearchDTO storeSearchDTO) {
 
		return storeService.getStores(storeSearchDTO);
	}	

	@RequestMapping(value = "/updateStore", method = RequestMethod.POST)
	public ResponseEntity<?> updateStore(@RequestBody StoreDTO storeDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = storeService.updateStore(storeDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
