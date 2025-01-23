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

import com.jiujitsustore.domain.Supplier;
import com.jiujitsustore.dto.SupplierDTO;
import com.jiujitsustore.dto.SupplierSearchDTO;
import com.jiujitsustore.dto.SupplierPageDTO;
import com.jiujitsustore.service.SupplierService;
import com.jiujitsustore.dto.common.RequestDTO;
import com.jiujitsustore.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/supplier")
@RestController
public class SupplierController {

	private final static Logger logger = LoggerFactory.getLogger(SupplierController.class);

	@Autowired
	SupplierService supplierService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<Supplier> getAll() {

		List<Supplier> suppliers = supplierService.findAll();
		
		return suppliers;	
	}

	@GetMapping(value = "/{supplierId}")
	@ResponseBody
	public SupplierDTO getSupplier(@PathVariable Integer supplierId) {
		
		return (supplierService.getSupplierDTOById(supplierId));
	}

 	@RequestMapping(value = "/addSupplier", method = RequestMethod.POST)
	public ResponseEntity<?> addSupplier(@RequestBody SupplierDTO supplierDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = supplierService.addSupplier(supplierDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/suppliers")
	public ResponseEntity<SupplierPageDTO> getSuppliers(SupplierSearchDTO supplierSearchDTO) {
 
		return supplierService.getSuppliers(supplierSearchDTO);
	}	

	@RequestMapping(value = "/updateSupplier", method = RequestMethod.POST)
	public ResponseEntity<?> updateSupplier(@RequestBody SupplierDTO supplierDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = supplierService.updateSupplier(supplierDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
