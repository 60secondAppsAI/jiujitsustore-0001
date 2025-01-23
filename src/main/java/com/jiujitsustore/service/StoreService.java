package com.jiujitsustore.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.jiujitsustore.domain.Store;
import com.jiujitsustore.dto.StoreDTO;
import com.jiujitsustore.dto.StoreSearchDTO;
import com.jiujitsustore.dto.StorePageDTO;
import com.jiujitsustore.dto.StoreConvertCriteriaDTO;
import com.jiujitsustore.service.GenericService;
import com.jiujitsustore.dto.common.RequestDTO;
import com.jiujitsustore.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface StoreService extends GenericService<Store, Integer> {

	List<Store> findAll();

	ResultDTO addStore(StoreDTO storeDTO, RequestDTO requestDTO);

	ResultDTO updateStore(StoreDTO storeDTO, RequestDTO requestDTO);

    Page<Store> getAllStores(Pageable pageable);

    Page<Store> getAllStores(Specification<Store> spec, Pageable pageable);

	ResponseEntity<StorePageDTO> getStores(StoreSearchDTO storeSearchDTO);
	
	List<StoreDTO> convertStoresToStoreDTOs(List<Store> stores, StoreConvertCriteriaDTO convertCriteria);

	StoreDTO getStoreDTOById(Integer storeId);







}





