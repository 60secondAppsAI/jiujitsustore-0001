package com.jiujitsustore.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.jiujitsustore.domain.Shipment;
import com.jiujitsustore.dto.ShipmentDTO;
import com.jiujitsustore.dto.ShipmentSearchDTO;
import com.jiujitsustore.dto.ShipmentPageDTO;
import com.jiujitsustore.dto.ShipmentConvertCriteriaDTO;
import com.jiujitsustore.service.GenericService;
import com.jiujitsustore.dto.common.RequestDTO;
import com.jiujitsustore.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface ShipmentService extends GenericService<Shipment, Integer> {

	List<Shipment> findAll();

	ResultDTO addShipment(ShipmentDTO shipmentDTO, RequestDTO requestDTO);

	ResultDTO updateShipment(ShipmentDTO shipmentDTO, RequestDTO requestDTO);

    Page<Shipment> getAllShipments(Pageable pageable);

    Page<Shipment> getAllShipments(Specification<Shipment> spec, Pageable pageable);

	ResponseEntity<ShipmentPageDTO> getShipments(ShipmentSearchDTO shipmentSearchDTO);
	
	List<ShipmentDTO> convertShipmentsToShipmentDTOs(List<Shipment> shipments, ShipmentConvertCriteriaDTO convertCriteria);

	ShipmentDTO getShipmentDTOById(Integer shipmentId);







}





