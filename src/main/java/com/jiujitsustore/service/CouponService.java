package com.jiujitsustore.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.jiujitsustore.domain.Coupon;
import com.jiujitsustore.dto.CouponDTO;
import com.jiujitsustore.dto.CouponSearchDTO;
import com.jiujitsustore.dto.CouponPageDTO;
import com.jiujitsustore.dto.CouponConvertCriteriaDTO;
import com.jiujitsustore.service.GenericService;
import com.jiujitsustore.dto.common.RequestDTO;
import com.jiujitsustore.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface CouponService extends GenericService<Coupon, Integer> {

	List<Coupon> findAll();

	ResultDTO addCoupon(CouponDTO couponDTO, RequestDTO requestDTO);

	ResultDTO updateCoupon(CouponDTO couponDTO, RequestDTO requestDTO);

    Page<Coupon> getAllCoupons(Pageable pageable);

    Page<Coupon> getAllCoupons(Specification<Coupon> spec, Pageable pageable);

	ResponseEntity<CouponPageDTO> getCoupons(CouponSearchDTO couponSearchDTO);
	
	List<CouponDTO> convertCouponsToCouponDTOs(List<Coupon> coupons, CouponConvertCriteriaDTO convertCriteria);

	CouponDTO getCouponDTOById(Integer couponId);







}





