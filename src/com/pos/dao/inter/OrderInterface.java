package com.pos.dao.inter;

import com.pos.model.Order;

public interface OrderInterface {
	public int save(Order order);
	public void updateOrder(Order order);
	public void delete(int id);
	public Order getOrderById(int id);
	

}
