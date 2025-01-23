package com.jiujitsustore.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.jiujitsustore.domain.Staff;
import com.jiujitsustore.dto.StaffDTO;
import com.jiujitsustore.dto.StaffSearchDTO;
import com.jiujitsustore.dto.StaffPageDTO;
import com.jiujitsustore.dto.StaffConvertCriteriaDTO;
import com.jiujitsustore.service.GenericService;
import com.jiujitsustore.dto.common.RequestDTO;
import com.jiujitsustore.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface StaffService extends GenericService<Staff, Integer> {

	List<Staff> findAll();

	ResultDTO addStaff(StaffDTO staffDTO, RequestDTO requestDTO);

	ResultDTO updateStaff(StaffDTO staffDTO, RequestDTO requestDTO);

    Page<Staff> getAllStaffs(Pageable pageable);

    Page<Staff> getAllStaffs(Specification<Staff> spec, Pageable pageable);

	ResponseEntity<StaffPageDTO> getStaffs(StaffSearchDTO staffSearchDTO);
	
	List<StaffDTO> convertStaffsToStaffDTOs(List<Staff> staffs, StaffConvertCriteriaDTO convertCriteria);

	StaffDTO getStaffDTOById(Integer staffId);







}





