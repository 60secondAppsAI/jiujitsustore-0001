package com.jiujitsustore.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.jiujitsustore.domain.Customer;
import com.jiujitsustore.dto.CustomerDTO;
import com.jiujitsustore.dto.CustomerSearchDTO;
import com.jiujitsustore.dto.CustomerPageDTO;
import com.jiujitsustore.dto.CustomerConvertCriteriaDTO;
import com.jiujitsustore.service.GenericService;
import com.jiujitsustore.dto.common.RequestDTO;
import com.jiujitsustore.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface CustomerService extends GenericService<Customer, Integer> {

	List<Customer> findAll();

	ResultDTO addCustomer(CustomerDTO customerDTO, RequestDTO requestDTO);

	ResultDTO updateCustomer(CustomerDTO customerDTO, RequestDTO requestDTO);

    Page<Customer> getAllCustomers(Pageable pageable);

    Page<Customer> getAllCustomers(Specification<Customer> spec, Pageable pageable);

	ResponseEntity<CustomerPageDTO> getCustomers(CustomerSearchDTO customerSearchDTO);
	
	List<CustomerDTO> convertCustomersToCustomerDTOs(List<Customer> customers, CustomerConvertCriteriaDTO convertCriteria);

	CustomerDTO getCustomerDTOById(Integer customerId);







}





