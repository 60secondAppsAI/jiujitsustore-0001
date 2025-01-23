package com.jiujitsustore.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.jiujitsustore.domain.Supplier;
import com.jiujitsustore.dto.SupplierDTO;
import com.jiujitsustore.dto.SupplierSearchDTO;
import com.jiujitsustore.dto.SupplierPageDTO;
import com.jiujitsustore.dto.SupplierConvertCriteriaDTO;
import com.jiujitsustore.service.GenericService;
import com.jiujitsustore.dto.common.RequestDTO;
import com.jiujitsustore.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface SupplierService extends GenericService<Supplier, Integer> {

	List<Supplier> findAll();

	ResultDTO addSupplier(SupplierDTO supplierDTO, RequestDTO requestDTO);

	ResultDTO updateSupplier(SupplierDTO supplierDTO, RequestDTO requestDTO);

    Page<Supplier> getAllSuppliers(Pageable pageable);

    Page<Supplier> getAllSuppliers(Specification<Supplier> spec, Pageable pageable);

	ResponseEntity<SupplierPageDTO> getSuppliers(SupplierSearchDTO supplierSearchDTO);
	
	List<SupplierDTO> convertSuppliersToSupplierDTOs(List<Supplier> suppliers, SupplierConvertCriteriaDTO convertCriteria);

	SupplierDTO getSupplierDTOById(Integer supplierId);







}





