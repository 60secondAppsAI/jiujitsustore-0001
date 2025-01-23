package com.jiujitsustore.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.jiujitsustore.domain.Promotion;
import com.jiujitsustore.dto.PromotionDTO;
import com.jiujitsustore.dto.PromotionSearchDTO;
import com.jiujitsustore.dto.PromotionPageDTO;
import com.jiujitsustore.dto.PromotionConvertCriteriaDTO;
import com.jiujitsustore.service.GenericService;
import com.jiujitsustore.dto.common.RequestDTO;
import com.jiujitsustore.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface PromotionService extends GenericService<Promotion, Integer> {

	List<Promotion> findAll();

	ResultDTO addPromotion(PromotionDTO promotionDTO, RequestDTO requestDTO);

	ResultDTO updatePromotion(PromotionDTO promotionDTO, RequestDTO requestDTO);

    Page<Promotion> getAllPromotions(Pageable pageable);

    Page<Promotion> getAllPromotions(Specification<Promotion> spec, Pageable pageable);

	ResponseEntity<PromotionPageDTO> getPromotions(PromotionSearchDTO promotionSearchDTO);
	
	List<PromotionDTO> convertPromotionsToPromotionDTOs(List<Promotion> promotions, PromotionConvertCriteriaDTO convertCriteria);

	PromotionDTO getPromotionDTOById(Integer promotionId);







}





