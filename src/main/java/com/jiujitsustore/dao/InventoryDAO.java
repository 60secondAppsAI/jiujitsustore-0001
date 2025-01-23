package com.jiujitsustore.dao;

import java.util.List;

import com.jiujitsustore.dao.GenericDAO;
import com.jiujitsustore.domain.Inventory;





public interface InventoryDAO extends GenericDAO<Inventory, Integer> {
  
	List<Inventory> findAll();
	






}


