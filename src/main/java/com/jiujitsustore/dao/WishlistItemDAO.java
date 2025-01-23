package com.jiujitsustore.dao;

import java.util.List;

import com.jiujitsustore.dao.GenericDAO;
import com.jiujitsustore.domain.WishlistItem;





public interface WishlistItemDAO extends GenericDAO<WishlistItem, Integer> {
  
	List<WishlistItem> findAll();
	






}


