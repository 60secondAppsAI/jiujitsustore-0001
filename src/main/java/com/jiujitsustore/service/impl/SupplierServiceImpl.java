package com.jiujitsustore.service.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;



import com.jiujitsustore.dao.GenericDAO;
import com.jiujitsustore.service.GenericService;
import com.jiujitsustore.service.impl.GenericServiceImpl;
import com.jiujitsustore.dao.SupplierDAO;
import com.jiujitsustore.domain.Supplier;
import com.jiujitsustore.dto.SupplierDTO;
import com.jiujitsustore.dto.SupplierSearchDTO;
import com.jiujitsustore.dto.SupplierPageDTO;
import com.jiujitsustore.dto.SupplierConvertCriteriaDTO;
import com.jiujitsustore.dto.common.RequestDTO;
import com.jiujitsustore.dto.common.ResultDTO;
import com.jiujitsustore.service.SupplierService;
import com.jiujitsustore.util.ControllerUtils;





@Service
public class SupplierServiceImpl extends GenericServiceImpl<Supplier, Integer> implements SupplierService {

    private final static Logger logger = LoggerFactory.getLogger(SupplierServiceImpl.class);

	@Autowired
	SupplierDAO supplierDao;

	


	@Override
	public GenericDAO<Supplier, Integer> getDAO() {
		return (GenericDAO<Supplier, Integer>) supplierDao;
	}
	
	public List<Supplier> findAll () {
		List<Supplier> suppliers = supplierDao.findAll();
		
		return suppliers;	
		
	}

	public ResultDTO addSupplier(SupplierDTO supplierDTO, RequestDTO requestDTO) {

		Supplier supplier = new Supplier();

		supplier.setSupplierId(supplierDTO.getSupplierId());


		supplier.setName(supplierDTO.getName());


		supplier.setContactEmail(supplierDTO.getContactEmail());


		LocalDate localDate = LocalDate.now();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		supplier = supplierDao.save(supplier);
		
		ResultDTO result = new ResultDTO();
		return result;
	}
	
	public Page<Supplier> getAllSuppliers(Pageable pageable) {
		return supplierDao.findAll(pageable);
	}

	public Page<Supplier> getAllSuppliers(Specification<Supplier> spec, Pageable pageable) {
		return supplierDao.findAll(spec, pageable);
	}

	public ResponseEntity<SupplierPageDTO> getSuppliers(SupplierSearchDTO supplierSearchDTO) {
	
			Integer supplierId = supplierSearchDTO.getSupplierId(); 
 			String name = supplierSearchDTO.getName(); 
 			String contactEmail = supplierSearchDTO.getContactEmail(); 
 			String sortBy = supplierSearchDTO.getSortBy();
			String sortOrder = supplierSearchDTO.getSortOrder();
			String searchQuery = supplierSearchDTO.getSearchQuery();
			Integer page = supplierSearchDTO.getPage();
			Integer size = supplierSearchDTO.getSize();

	        Specification<Supplier> spec = Specification.where(null);

			spec = ControllerUtils.andIfNecessary(spec, supplierId, "supplierId"); 
			
			spec = ControllerUtils.andIfNecessary(spec, name, "name"); 
			
			spec = ControllerUtils.andIfNecessary(spec, contactEmail, "contactEmail"); 
			

		if (searchQuery != null && !searchQuery.isEmpty()) {
			spec = spec.and((root, query, cb) -> cb.or(

             cb.like(cb.lower(root.get("name")), "%" + searchQuery.toLowerCase() + "%") 
             , cb.like(cb.lower(root.get("contactEmail")), "%" + searchQuery.toLowerCase() + "%") 
		));}
		
		Sort sort = Sort.unsorted();
		if (sortBy != null && !sortBy.isEmpty() && sortOrder != null && !sortOrder.isEmpty()) {
			if (sortOrder.equalsIgnoreCase("asc")) {
				sort = Sort.by(sortBy).ascending();
			} else if (sortOrder.equalsIgnoreCase("desc")) {
				sort = Sort.by(sortBy).descending();
			}
		}
		Pageable pageable = PageRequest.of(page, size, sort);

		Page<Supplier> suppliers = this.getAllSuppliers(spec, pageable);
		
		//System.out.println(String.valueOf(suppliers.getTotalElements()) + " total ${classNamelPlural}, viewing page X of " + String.valueOf(suppliers.getTotalPages()));
		
		List<Supplier> suppliersList = suppliers.getContent();
		
		SupplierConvertCriteriaDTO convertCriteria = new SupplierConvertCriteriaDTO();
		List<SupplierDTO> supplierDTOs = this.convertSuppliersToSupplierDTOs(suppliersList,convertCriteria);
		
		SupplierPageDTO supplierPageDTO = new SupplierPageDTO();
		supplierPageDTO.setSuppliers(supplierDTOs);
		supplierPageDTO.setTotalElements(suppliers.getTotalElements());
		return ResponseEntity.ok(supplierPageDTO);
	}

	public List<SupplierDTO> convertSuppliersToSupplierDTOs(List<Supplier> suppliers, SupplierConvertCriteriaDTO convertCriteria) {
		
		List<SupplierDTO> supplierDTOs = new ArrayList<SupplierDTO>();
		
		for (Supplier supplier : suppliers) {
			supplierDTOs.add(convertSupplierToSupplierDTO(supplier,convertCriteria));
		}
		
		return supplierDTOs;

	}
	
	public SupplierDTO convertSupplierToSupplierDTO(Supplier supplier, SupplierConvertCriteriaDTO convertCriteria) {
		
		SupplierDTO supplierDTO = new SupplierDTO();
		
		supplierDTO.setSupplierId(supplier.getSupplierId());

	
		supplierDTO.setName(supplier.getName());

	
		supplierDTO.setContactEmail(supplier.getContactEmail());

	

		
		return supplierDTO;
	}

	public ResultDTO updateSupplier(SupplierDTO supplierDTO, RequestDTO requestDTO) {
		
		Supplier supplier = supplierDao.getById(supplierDTO.getSupplierId());

		supplier.setSupplierId(ControllerUtils.setValue(supplier.getSupplierId(), supplierDTO.getSupplierId()));

		supplier.setName(ControllerUtils.setValue(supplier.getName(), supplierDTO.getName()));

		supplier.setContactEmail(ControllerUtils.setValue(supplier.getContactEmail(), supplierDTO.getContactEmail()));



        supplier = supplierDao.save(supplier);
		
		ResultDTO result = new ResultDTO();
		return result;
	}

	public SupplierDTO getSupplierDTOById(Integer supplierId) {
	
		Supplier supplier = supplierDao.getById(supplierId);
			
		
		SupplierConvertCriteriaDTO convertCriteria = new SupplierConvertCriteriaDTO();
		return(this.convertSupplierToSupplierDTO(supplier,convertCriteria));
	}







}
