package com.jiujitsustore.dao;

import java.util.List;

import com.jiujitsustore.dao.GenericDAO;
import com.jiujitsustore.domain.Customer;





public interface CustomerDAO extends GenericDAO<Customer, Integer> {
  
	List<Customer> findAll();
	






}


