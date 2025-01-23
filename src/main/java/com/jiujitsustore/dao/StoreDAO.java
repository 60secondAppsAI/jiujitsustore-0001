package com.jiujitsustore.dao;

import java.util.List;

import com.jiujitsustore.dao.GenericDAO;
import com.jiujitsustore.domain.Store;





public interface StoreDAO extends GenericDAO<Store, Integer> {
  
	List<Store> findAll();
	






}


