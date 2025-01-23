package com.jiujitsustore.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.jiujitsustore.domain.Inventory;
import com.jiujitsustore.dto.InventoryDTO;
import com.jiujitsustore.dto.InventorySearchDTO;
import com.jiujitsustore.dto.InventoryPageDTO;
import com.jiujitsustore.dto.InventoryConvertCriteriaDTO;
import com.jiujitsustore.service.GenericService;
import com.jiujitsustore.dto.common.RequestDTO;
import com.jiujitsustore.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface InventoryService extends GenericService<Inventory, Integer> {

	List<Inventory> findAll();

	ResultDTO addInventory(InventoryDTO inventoryDTO, RequestDTO requestDTO);

	ResultDTO updateInventory(InventoryDTO inventoryDTO, RequestDTO requestDTO);

    Page<Inventory> getAllInventorys(Pageable pageable);

    Page<Inventory> getAllInventorys(Specification<Inventory> spec, Pageable pageable);

	ResponseEntity<InventoryPageDTO> getInventorys(InventorySearchDTO inventorySearchDTO);
	
	List<InventoryDTO> convertInventorysToInventoryDTOs(List<Inventory> inventorys, InventoryConvertCriteriaDTO convertCriteria);

	InventoryDTO getInventoryDTOById(Integer inventoryId);







}





