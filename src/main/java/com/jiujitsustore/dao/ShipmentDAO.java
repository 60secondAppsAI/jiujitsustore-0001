package com.jiujitsustore.dao;

import java.util.List;

import com.jiujitsustore.dao.GenericDAO;
import com.jiujitsustore.domain.Shipment;





public interface ShipmentDAO extends GenericDAO<Shipment, Integer> {
  
	List<Shipment> findAll();
	






}


