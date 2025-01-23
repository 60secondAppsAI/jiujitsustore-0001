package com.jiujitsustore.dao;

import java.util.List;

import com.jiujitsustore.dao.GenericDAO;
import com.jiujitsustore.domain.Coupon;





public interface CouponDAO extends GenericDAO<Coupon, Integer> {
  
	List<Coupon> findAll();
	






}


