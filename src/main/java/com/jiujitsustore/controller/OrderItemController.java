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

import com.jiujitsustore.domain.OrderItem;
import com.jiujitsustore.dto.OrderItemDTO;
import com.jiujitsustore.dto.OrderItemSearchDTO;
import com.jiujitsustore.dto.OrderItemPageDTO;
import com.jiujitsustore.service.OrderItemService;
import com.jiujitsustore.dto.common.RequestDTO;
import com.jiujitsustore.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/orderItem")
@RestController
public class OrderItemController {

	private final static Logger logger = LoggerFactory.getLogger(OrderItemController.class);

	@Autowired
	OrderItemService orderItemService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<OrderItem> getAll() {

		List<OrderItem> orderItems = orderItemService.findAll();
		
		return orderItems;	
	}

	@GetMapping(value = "/{orderItemId}")
	@ResponseBody
	public OrderItemDTO getOrderItem(@PathVariable Integer orderItemId) {
		
		return (orderItemService.getOrderItemDTOById(orderItemId));
	}

 	@RequestMapping(value = "/addOrderItem", method = RequestMethod.POST)
	public ResponseEntity<?> addOrderItem(@RequestBody OrderItemDTO orderItemDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = orderItemService.addOrderItem(orderItemDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/orderItems")
	public ResponseEntity<OrderItemPageDTO> getOrderItems(OrderItemSearchDTO orderItemSearchDTO) {
 
		return orderItemService.getOrderItems(orderItemSearchDTO);
	}	

	@RequestMapping(value = "/updateOrderItem", method = RequestMethod.POST)
	public ResponseEntity<?> updateOrderItem(@RequestBody OrderItemDTO orderItemDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = orderItemService.updateOrderItem(orderItemDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
