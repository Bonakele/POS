package com.pos.dao.inter;

import java.util.Date;
import java.util.List;

import com.pos.model.Sales;

public interface SalesInterface {

	public int saveSale(Sales sale);

	public Sales getSaleById(int id);

	public List<Sales> getAllSales();
	
	public Date exchangeDate();
}
