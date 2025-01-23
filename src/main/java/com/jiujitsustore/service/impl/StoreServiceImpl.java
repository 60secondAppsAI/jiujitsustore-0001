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
import com.jiujitsustore.dao.StoreDAO;
import com.jiujitsustore.domain.Store;
import com.jiujitsustore.dto.StoreDTO;
import com.jiujitsustore.dto.StoreSearchDTO;
import com.jiujitsustore.dto.StorePageDTO;
import com.jiujitsustore.dto.StoreConvertCriteriaDTO;
import com.jiujitsustore.dto.common.RequestDTO;
import com.jiujitsustore.dto.common.ResultDTO;
import com.jiujitsustore.service.StoreService;
import com.jiujitsustore.util.ControllerUtils;





@Service
public class StoreServiceImpl extends GenericServiceImpl<Store, Integer> implements StoreService {

    private final static Logger logger = LoggerFactory.getLogger(StoreServiceImpl.class);

	@Autowired
	StoreDAO storeDao;

	


	@Override
	public GenericDAO<Store, Integer> getDAO() {
		return (GenericDAO<Store, Integer>) storeDao;
	}
	
	public List<Store> findAll () {
		List<Store> stores = storeDao.findAll();
		
		return stores;	
		
	}

	public ResultDTO addStore(StoreDTO storeDTO, RequestDTO requestDTO) {

		Store store = new Store();

		store.setStoreId(storeDTO.getStoreId());


		store.setName(storeDTO.getName());


		store.setLocation(storeDTO.getLocation());


		LocalDate localDate = LocalDate.now();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		store = storeDao.save(store);
		
		ResultDTO result = new ResultDTO();
		return result;
	}
	
	public Page<Store> getAllStores(Pageable pageable) {
		return storeDao.findAll(pageable);
	}

	public Page<Store> getAllStores(Specification<Store> spec, Pageable pageable) {
		return storeDao.findAll(spec, pageable);
	}

	public ResponseEntity<StorePageDTO> getStores(StoreSearchDTO storeSearchDTO) {
	
			Integer storeId = storeSearchDTO.getStoreId(); 
 			String name = storeSearchDTO.getName(); 
 			String location = storeSearchDTO.getLocation(); 
 			String sortBy = storeSearchDTO.getSortBy();
			String sortOrder = storeSearchDTO.getSortOrder();
			String searchQuery = storeSearchDTO.getSearchQuery();
			Integer page = storeSearchDTO.getPage();
			Integer size = storeSearchDTO.getSize();

	        Specification<Store> spec = Specification.where(null);

			spec = ControllerUtils.andIfNecessary(spec, storeId, "storeId"); 
			
			spec = ControllerUtils.andIfNecessary(spec, name, "name"); 
			
			spec = ControllerUtils.andIfNecessary(spec, location, "location"); 
			

		if (searchQuery != null && !searchQuery.isEmpty()) {
			spec = spec.and((root, query, cb) -> cb.or(

             cb.like(cb.lower(root.get("location")), "%" + searchQuery.toLowerCase() + "%") 
             , cb.like(cb.lower(root.get("name")), "%" + searchQuery.toLowerCase() + "%") 
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

		Page<Store> stores = this.getAllStores(spec, pageable);
		
		//System.out.println(String.valueOf(stores.getTotalElements()) + " total ${classNamelPlural}, viewing page X of " + String.valueOf(stores.getTotalPages()));
		
		List<Store> storesList = stores.getContent();
		
		StoreConvertCriteriaDTO convertCriteria = new StoreConvertCriteriaDTO();
		List<StoreDTO> storeDTOs = this.convertStoresToStoreDTOs(storesList,convertCriteria);
		
		StorePageDTO storePageDTO = new StorePageDTO();
		storePageDTO.setStores(storeDTOs);
		storePageDTO.setTotalElements(stores.getTotalElements());
		return ResponseEntity.ok(storePageDTO);
	}

	public List<StoreDTO> convertStoresToStoreDTOs(List<Store> stores, StoreConvertCriteriaDTO convertCriteria) {
		
		List<StoreDTO> storeDTOs = new ArrayList<StoreDTO>();
		
		for (Store store : stores) {
			storeDTOs.add(convertStoreToStoreDTO(store,convertCriteria));
		}
		
		return storeDTOs;

	}
	
	public StoreDTO convertStoreToStoreDTO(Store store, StoreConvertCriteriaDTO convertCriteria) {
		
		StoreDTO storeDTO = new StoreDTO();
		
		storeDTO.setStoreId(store.getStoreId());

	
		storeDTO.setName(store.getName());

	
		storeDTO.setLocation(store.getLocation());

	

		
		return storeDTO;
	}

	public ResultDTO updateStore(StoreDTO storeDTO, RequestDTO requestDTO) {
		
		Store store = storeDao.getById(storeDTO.getStoreId());

		store.setStoreId(ControllerUtils.setValue(store.getStoreId(), storeDTO.getStoreId()));

		store.setName(ControllerUtils.setValue(store.getName(), storeDTO.getName()));

		store.setLocation(ControllerUtils.setValue(store.getLocation(), storeDTO.getLocation()));



        store = storeDao.save(store);
		
		ResultDTO result = new ResultDTO();
		return result;
	}

	public StoreDTO getStoreDTOById(Integer storeId) {
	
		Store store = storeDao.getById(storeId);
			
		
		StoreConvertCriteriaDTO convertCriteria = new StoreConvertCriteriaDTO();
		return(this.convertStoreToStoreDTO(store,convertCriteria));
	}







}
