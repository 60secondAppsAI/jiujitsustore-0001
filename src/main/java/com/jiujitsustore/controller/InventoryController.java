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

import com.jiujitsustore.domain.Inventory;
import com.jiujitsustore.dto.InventoryDTO;
import com.jiujitsustore.dto.InventorySearchDTO;
import com.jiujitsustore.dto.InventoryPageDTO;
import com.jiujitsustore.service.InventoryService;
import com.jiujitsustore.dto.common.RequestDTO;
import com.jiujitsustore.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/inventory")
@RestController
public class InventoryController {

	private final static Logger logger = LoggerFactory.getLogger(InventoryController.class);

	@Autowired
	InventoryService inventoryService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<Inventory> getAll() {

		List<Inventory> inventorys = inventoryService.findAll();
		
		return inventorys;	
	}

	@GetMapping(value = "/{inventoryId}")
	@ResponseBody
	public InventoryDTO getInventory(@PathVariable Integer inventoryId) {
		
		return (inventoryService.getInventoryDTOById(inventoryId));
	}

 	@RequestMapping(value = "/addInventory", method = RequestMethod.POST)
	public ResponseEntity<?> addInventory(@RequestBody InventoryDTO inventoryDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = inventoryService.addInventory(inventoryDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/inventorys")
	public ResponseEntity<InventoryPageDTO> getInventorys(InventorySearchDTO inventorySearchDTO) {
 
		return inventoryService.getInventorys(inventorySearchDTO);
	}	

	@RequestMapping(value = "/updateInventory", method = RequestMethod.POST)
	public ResponseEntity<?> updateInventory(@RequestBody InventoryDTO inventoryDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = inventoryService.updateInventory(inventoryDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
