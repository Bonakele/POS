package com.pos.dao.inter;

import java.util.List;

import com.pos.model.Order;

public interface OrderInterface {
	public int saveOrder(Order order);
	public void updateOrder(Order order);
	public void deleteOrder(int id);
	public Order getOrderById(int id);
	public List<Order> getAllOrders();

}
