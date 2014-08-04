package com.pos.dao.inter;

import java.util.List;

import com.pos.model.Sales;

public interface SalesInterface {

	void purchase(Sales sale);
	void edit(int x);
	void delete(int x);
	List<Sales> view();
	List<Sales> search(int x);
}
