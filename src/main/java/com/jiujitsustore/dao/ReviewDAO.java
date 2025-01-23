package com.jiujitsustore.dao;

import java.util.List;

import com.jiujitsustore.dao.GenericDAO;
import com.jiujitsustore.domain.Review;





public interface ReviewDAO extends GenericDAO<Review, Integer> {
  
	List<Review> findAll();
	






}


