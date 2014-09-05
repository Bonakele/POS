package com.pos.dao.inter;

import java.util.List;

import com.pos.model.ReturnItem;

public interface ReturnItemInterface {
	public int saveReturn(ReturnItem returnItem);
	public ReturnItem getReturnById(int id);
	public List<ReturnItem> getAllReturns();
}
