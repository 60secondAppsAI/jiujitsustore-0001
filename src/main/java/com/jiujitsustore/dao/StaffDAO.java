package com.jiujitsustore.dao;

import java.util.List;

import com.jiujitsustore.dao.GenericDAO;
import com.jiujitsustore.domain.Staff;





public interface StaffDAO extends GenericDAO<Staff, Integer> {
  
	List<Staff> findAll();
	






}


