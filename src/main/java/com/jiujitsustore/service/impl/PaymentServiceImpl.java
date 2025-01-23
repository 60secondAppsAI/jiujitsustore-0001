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
import com.jiujitsustore.dao.PaymentDAO;
import com.jiujitsustore.domain.Payment;
import com.jiujitsustore.dto.PaymentDTO;
import com.jiujitsustore.dto.PaymentSearchDTO;
import com.jiujitsustore.dto.PaymentPageDTO;
import com.jiujitsustore.dto.PaymentConvertCriteriaDTO;
import com.jiujitsustore.dto.common.RequestDTO;
import com.jiujitsustore.dto.common.ResultDTO;
import com.jiujitsustore.service.PaymentService;
import com.jiujitsustore.util.ControllerUtils;





@Service
public class PaymentServiceImpl extends GenericServiceImpl<Payment, Integer> implements PaymentService {

    private final static Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);

	@Autowired
	PaymentDAO paymentDao;

	


	@Override
	public GenericDAO<Payment, Integer> getDAO() {
		return (GenericDAO<Payment, Integer>) paymentDao;
	}
	
	public List<Payment> findAll () {
		List<Payment> payments = paymentDao.findAll();
		
		return payments;	
		
	}

	public ResultDTO addPayment(PaymentDTO paymentDTO, RequestDTO requestDTO) {

		Payment payment = new Payment();

		payment.setPaymentId(paymentDTO.getPaymentId());


		payment.setPaymentDate(paymentDTO.getPaymentDate());


		payment.setAmount(paymentDTO.getAmount());


		LocalDate localDate = LocalDate.now();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		payment = paymentDao.save(payment);
		
		ResultDTO result = new ResultDTO();
		return result;
	}
	
	public Page<Payment> getAllPayments(Pageable pageable) {
		return paymentDao.findAll(pageable);
	}

	public Page<Payment> getAllPayments(Specification<Payment> spec, Pageable pageable) {
		return paymentDao.findAll(spec, pageable);
	}

	public ResponseEntity<PaymentPageDTO> getPayments(PaymentSearchDTO paymentSearchDTO) {
	
			Integer paymentId = paymentSearchDTO.getPaymentId(); 
    			String sortBy = paymentSearchDTO.getSortBy();
			String sortOrder = paymentSearchDTO.getSortOrder();
			String searchQuery = paymentSearchDTO.getSearchQuery();
			Integer page = paymentSearchDTO.getPage();
			Integer size = paymentSearchDTO.getSize();

	        Specification<Payment> spec = Specification.where(null);

			spec = ControllerUtils.andIfNecessary(spec, paymentId, "paymentId"); 
			
 			
			

		if (searchQuery != null && !searchQuery.isEmpty()) {
			spec = spec.and((root, query, cb) -> cb.or(

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

		Page<Payment> payments = this.getAllPayments(spec, pageable);
		
		//System.out.println(String.valueOf(payments.getTotalElements()) + " total ${classNamelPlural}, viewing page X of " + String.valueOf(payments.getTotalPages()));
		
		List<Payment> paymentsList = payments.getContent();
		
		PaymentConvertCriteriaDTO convertCriteria = new PaymentConvertCriteriaDTO();
		List<PaymentDTO> paymentDTOs = this.convertPaymentsToPaymentDTOs(paymentsList,convertCriteria);
		
		PaymentPageDTO paymentPageDTO = new PaymentPageDTO();
		paymentPageDTO.setPayments(paymentDTOs);
		paymentPageDTO.setTotalElements(payments.getTotalElements());
		return ResponseEntity.ok(paymentPageDTO);
	}

	public List<PaymentDTO> convertPaymentsToPaymentDTOs(List<Payment> payments, PaymentConvertCriteriaDTO convertCriteria) {
		
		List<PaymentDTO> paymentDTOs = new ArrayList<PaymentDTO>();
		
		for (Payment payment : payments) {
			paymentDTOs.add(convertPaymentToPaymentDTO(payment,convertCriteria));
		}
		
		return paymentDTOs;

	}
	
	public PaymentDTO convertPaymentToPaymentDTO(Payment payment, PaymentConvertCriteriaDTO convertCriteria) {
		
		PaymentDTO paymentDTO = new PaymentDTO();
		
		paymentDTO.setPaymentId(payment.getPaymentId());

	
		paymentDTO.setPaymentDate(payment.getPaymentDate());

	
		paymentDTO.setAmount(payment.getAmount());

	

		
		return paymentDTO;
	}

	public ResultDTO updatePayment(PaymentDTO paymentDTO, RequestDTO requestDTO) {
		
		Payment payment = paymentDao.getById(paymentDTO.getPaymentId());

		payment.setPaymentId(ControllerUtils.setValue(payment.getPaymentId(), paymentDTO.getPaymentId()));

		payment.setPaymentDate(ControllerUtils.setValue(payment.getPaymentDate(), paymentDTO.getPaymentDate()));

		payment.setAmount(ControllerUtils.setValue(payment.getAmount(), paymentDTO.getAmount()));



        payment = paymentDao.save(payment);
		
		ResultDTO result = new ResultDTO();
		return result;
	}

	public PaymentDTO getPaymentDTOById(Integer paymentId) {
	
		Payment payment = paymentDao.getById(paymentId);
			
		
		PaymentConvertCriteriaDTO convertCriteria = new PaymentConvertCriteriaDTO();
		return(this.convertPaymentToPaymentDTO(payment,convertCriteria));
	}







}
