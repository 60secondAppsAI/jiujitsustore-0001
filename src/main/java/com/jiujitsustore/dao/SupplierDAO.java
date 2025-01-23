package com.jiujitsustore.dao;

import java.util.List;

import com.jiujitsustore.dao.GenericDAO;
import com.jiujitsustore.domain.Supplier;





public interface SupplierDAO extends GenericDAO<Supplier, Integer> {
  
	List<Supplier> findAll();
	






}


