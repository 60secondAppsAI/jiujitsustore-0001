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

import com.jiujitsustore.domain.Shipment;
import com.jiujitsustore.dto.ShipmentDTO;
import com.jiujitsustore.dto.ShipmentSearchDTO;
import com.jiujitsustore.dto.ShipmentPageDTO;
import com.jiujitsustore.service.ShipmentService;
import com.jiujitsustore.dto.common.RequestDTO;
import com.jiujitsustore.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/shipment")
@RestController
public class ShipmentController {

	private final static Logger logger = LoggerFactory.getLogger(ShipmentController.class);

	@Autowired
	ShipmentService shipmentService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<Shipment> getAll() {

		List<Shipment> shipments = shipmentService.findAll();
		
		return shipments;	
	}

	@GetMapping(value = "/{shipmentId}")
	@ResponseBody
	public ShipmentDTO getShipment(@PathVariable Integer shipmentId) {
		
		return (shipmentService.getShipmentDTOById(shipmentId));
	}

 	@RequestMapping(value = "/addShipment", method = RequestMethod.POST)
	public ResponseEntity<?> addShipment(@RequestBody ShipmentDTO shipmentDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = shipmentService.addShipment(shipmentDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/shipments")
	public ResponseEntity<ShipmentPageDTO> getShipments(ShipmentSearchDTO shipmentSearchDTO) {
 
		return shipmentService.getShipments(shipmentSearchDTO);
	}	

	@RequestMapping(value = "/updateShipment", method = RequestMethod.POST)
	public ResponseEntity<?> updateShipment(@RequestBody ShipmentDTO shipmentDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = shipmentService.updateShipment(shipmentDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
