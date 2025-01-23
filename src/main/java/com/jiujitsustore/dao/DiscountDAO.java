package com.jiujitsustore.dao;

import java.util.List;

import com.jiujitsustore.dao.GenericDAO;
import com.jiujitsustore.domain.Discount;





public interface DiscountDAO extends GenericDAO<Discount, Integer> {
  
	List<Discount> findAll();
	






}


