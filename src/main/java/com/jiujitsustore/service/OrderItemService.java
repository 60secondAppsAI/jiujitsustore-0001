package com.jiujitsustore.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.jiujitsustore.domain.OrderItem;
import com.jiujitsustore.dto.OrderItemDTO;
import com.jiujitsustore.dto.OrderItemSearchDTO;
import com.jiujitsustore.dto.OrderItemPageDTO;
import com.jiujitsustore.dto.OrderItemConvertCriteriaDTO;
import com.jiujitsustore.service.GenericService;
import com.jiujitsustore.dto.common.RequestDTO;
import com.jiujitsustore.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface OrderItemService extends GenericService<OrderItem, Integer> {

	List<OrderItem> findAll();

	ResultDTO addOrderItem(OrderItemDTO orderItemDTO, RequestDTO requestDTO);

	ResultDTO updateOrderItem(OrderItemDTO orderItemDTO, RequestDTO requestDTO);

    Page<OrderItem> getAllOrderItems(Pageable pageable);

    Page<OrderItem> getAllOrderItems(Specification<OrderItem> spec, Pageable pageable);

	ResponseEntity<OrderItemPageDTO> getOrderItems(OrderItemSearchDTO orderItemSearchDTO);
	
	List<OrderItemDTO> convertOrderItemsToOrderItemDTOs(List<OrderItem> orderItems, OrderItemConvertCriteriaDTO convertCriteria);

	OrderItemDTO getOrderItemDTOById(Integer orderItemId);







}





