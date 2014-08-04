package com.pos.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pos.dao.inter.OrderInterface;
import com.pos.helper.Helper;
import com.pos.model.Order;

public class OrderImplemantation implements OrderInterface {

	public int save(Order order) {

		SessionFactory session = Helper.getSessionFactory();
		Session sess = session.openSession();
		sess.beginTransaction();

		sess.save(order);
		
		sess.getTransaction().commit();
		sess.close();

		return order.getId();
	}

	@Override
	public void updateOrder(Order order) {
		SessionFactory session = Helper.getSessionFactory();
		Session sess = session.openSession();
		sess.beginTransaction();

		Order orderUpdate = (Order) sess.load(Order.class, order.getId());

		orderUpdate.setAmount(order.getAmount());
		orderUpdate.setClient(order.getClient());
		orderUpdate.setComment(order.getComment());
		orderUpdate.setDateDeliverd(order.getDateDeliverd());
		orderUpdate.setDateIssued(order.getDateIssued());
		orderUpdate.setItem(order.getItem());
		orderUpdate.setStatus(order.getStatus());

		sess.save(orderUpdate);
		sess.beginTransaction().commit();

		sess.close();
	}
	

	public void delete(int id) {

		SessionFactory session = Helper.getSessionFactory();
		Session sess = session.openSession();

		sess.beginTransaction();

		Order order = (Order) sess.load(Order.class, id);

		sess.delete(order);
		sess.getTransaction().commit();

		sess.close();

	}
	public Order getOrderById(int id) {

		SessionFactory session = Helper.getSessionFactory();
		Session sess = session.openSession();

		sess.beginTransaction();

		Order order = (Order) sess.load(Order.class, id);

		
		return order;

	
	}

}
