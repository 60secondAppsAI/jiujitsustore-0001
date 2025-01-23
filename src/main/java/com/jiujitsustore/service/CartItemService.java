package com.jiujitsustore.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.jiujitsustore.domain.CartItem;
import com.jiujitsustore.dto.CartItemDTO;
import com.jiujitsustore.dto.CartItemSearchDTO;
import com.jiujitsustore.dto.CartItemPageDTO;
import com.jiujitsustore.dto.CartItemConvertCriteriaDTO;
import com.jiujitsustore.service.GenericService;
import com.jiujitsustore.dto.common.RequestDTO;
import com.jiujitsustore.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface CartItemService extends GenericService<CartItem, Integer> {

	List<CartItem> findAll();

	ResultDTO addCartItem(CartItemDTO cartItemDTO, RequestDTO requestDTO);

	ResultDTO updateCartItem(CartItemDTO cartItemDTO, RequestDTO requestDTO);

    Page<CartItem> getAllCartItems(Pageable pageable);

    Page<CartItem> getAllCartItems(Specification<CartItem> spec, Pageable pageable);

	ResponseEntity<CartItemPageDTO> getCartItems(CartItemSearchDTO cartItemSearchDTO);
	
	List<CartItemDTO> convertCartItemsToCartItemDTOs(List<CartItem> cartItems, CartItemConvertCriteriaDTO convertCriteria);

	CartItemDTO getCartItemDTOById(Integer cartItemId);







}





