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
import com.jiujitsustore.dao.StaffDAO;
import com.jiujitsustore.domain.Staff;
import com.jiujitsustore.dto.StaffDTO;
import com.jiujitsustore.dto.StaffSearchDTO;
import com.jiujitsustore.dto.StaffPageDTO;
import com.jiujitsustore.dto.StaffConvertCriteriaDTO;
import com.jiujitsustore.dto.common.RequestDTO;
import com.jiujitsustore.dto.common.ResultDTO;
import com.jiujitsustore.service.StaffService;
import com.jiujitsustore.util.ControllerUtils;





@Service
public class StaffServiceImpl extends GenericServiceImpl<Staff, Integer> implements StaffService {

    private final static Logger logger = LoggerFactory.getLogger(StaffServiceImpl.class);

	@Autowired
	StaffDAO staffDao;

	


	@Override
	public GenericDAO<Staff, Integer> getDAO() {
		return (GenericDAO<Staff, Integer>) staffDao;
	}
	
	public List<Staff> findAll () {
		List<Staff> staffs = staffDao.findAll();
		
		return staffs;	
		
	}

	public ResultDTO addStaff(StaffDTO staffDTO, RequestDTO requestDTO) {

		Staff staff = new Staff();

		staff.setStaffId(staffDTO.getStaffId());


		staff.setName(staffDTO.getName());


		staff.setPosition(staffDTO.getPosition());


		LocalDate localDate = LocalDate.now();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		staff = staffDao.save(staff);
		
		ResultDTO result = new ResultDTO();
		return result;
	}
	
	public Page<Staff> getAllStaffs(Pageable pageable) {
		return staffDao.findAll(pageable);
	}

	public Page<Staff> getAllStaffs(Specification<Staff> spec, Pageable pageable) {
		return staffDao.findAll(spec, pageable);
	}

	public ResponseEntity<StaffPageDTO> getStaffs(StaffSearchDTO staffSearchDTO) {
	
			Integer staffId = staffSearchDTO.getStaffId(); 
 			String name = staffSearchDTO.getName(); 
 			String position = staffSearchDTO.getPosition(); 
 			String sortBy = staffSearchDTO.getSortBy();
			String sortOrder = staffSearchDTO.getSortOrder();
			String searchQuery = staffSearchDTO.getSearchQuery();
			Integer page = staffSearchDTO.getPage();
			Integer size = staffSearchDTO.getSize();

	        Specification<Staff> spec = Specification.where(null);

			spec = ControllerUtils.andIfNecessary(spec, staffId, "staffId"); 
			
			spec = ControllerUtils.andIfNecessary(spec, name, "name"); 
			
			spec = ControllerUtils.andIfNecessary(spec, position, "position"); 
			

		if (searchQuery != null && !searchQuery.isEmpty()) {
			spec = spec.and((root, query, cb) -> cb.or(

             cb.like(cb.lower(root.get("name")), "%" + searchQuery.toLowerCase() + "%") 
             , cb.like(cb.lower(root.get("position")), "%" + searchQuery.toLowerCase() + "%") 
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

		Page<Staff> staffs = this.getAllStaffs(spec, pageable);
		
		//System.out.println(String.valueOf(staffs.getTotalElements()) + " total ${classNamelPlural}, viewing page X of " + String.valueOf(staffs.getTotalPages()));
		
		List<Staff> staffsList = staffs.getContent();
		
		StaffConvertCriteriaDTO convertCriteria = new StaffConvertCriteriaDTO();
		List<StaffDTO> staffDTOs = this.convertStaffsToStaffDTOs(staffsList,convertCriteria);
		
		StaffPageDTO staffPageDTO = new StaffPageDTO();
		staffPageDTO.setStaffs(staffDTOs);
		staffPageDTO.setTotalElements(staffs.getTotalElements());
		return ResponseEntity.ok(staffPageDTO);
	}

	public List<StaffDTO> convertStaffsToStaffDTOs(List<Staff> staffs, StaffConvertCriteriaDTO convertCriteria) {
		
		List<StaffDTO> staffDTOs = new ArrayList<StaffDTO>();
		
		for (Staff staff : staffs) {
			staffDTOs.add(convertStaffToStaffDTO(staff,convertCriteria));
		}
		
		return staffDTOs;

	}
	
	public StaffDTO convertStaffToStaffDTO(Staff staff, StaffConvertCriteriaDTO convertCriteria) {
		
		StaffDTO staffDTO = new StaffDTO();
		
		staffDTO.setStaffId(staff.getStaffId());

	
		staffDTO.setName(staff.getName());

	
		staffDTO.setPosition(staff.getPosition());

	

		
		return staffDTO;
	}

	public ResultDTO updateStaff(StaffDTO staffDTO, RequestDTO requestDTO) {
		
		Staff staff = staffDao.getById(staffDTO.getStaffId());

		staff.setStaffId(ControllerUtils.setValue(staff.getStaffId(), staffDTO.getStaffId()));

		staff.setName(ControllerUtils.setValue(staff.getName(), staffDTO.getName()));

		staff.setPosition(ControllerUtils.setValue(staff.getPosition(), staffDTO.getPosition()));



        staff = staffDao.save(staff);
		
		ResultDTO result = new ResultDTO();
		return result;
	}

	public StaffDTO getStaffDTOById(Integer staffId) {
	
		Staff staff = staffDao.getById(staffId);
			
		
		StaffConvertCriteriaDTO convertCriteria = new StaffConvertCriteriaDTO();
		return(this.convertStaffToStaffDTO(staff,convertCriteria));
	}







}
