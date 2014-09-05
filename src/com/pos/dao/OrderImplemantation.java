package com.pos.dao;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pos.dao.inter.OrderInterface;
import com.pos.helper.Helper;
import com.pos.model.Employee;
import com.pos.model.Item;
import com.pos.model.Order;

public class OrderImplemantation implements OrderInterface {

	SessionFactory session = Helper.getSessionFactory();

	public int saveOrder(Order order) {

		Session sess = session.openSession();
		sess.beginTransaction();

		sess.save(order);

		sess.getTransaction().commit();
		sess.close();

		return order.getId();
	}

	@Override
	public void updateOrder(Order order) {

		Session sess = session.openSession();
		sess.beginTransaction();

		sess.update(order);
		sess.getTransaction().commit();// gettransaction.commit

		sess.close();
	}

	public void deleteOrder(int id) {

		Session sess = session.openSession();

		sess.beginTransaction();

		Order order = (Order) sess.load(Order.class, id);

		sess.delete(order);
		sess.getTransaction().commit();

		sess.close();

	}

	public Order getOrderById(int id) {

		Session sess = session.openSession();

		Query query = (Query) sess.getNamedQuery("Order.ById");
		query.setInteger(0, id);
		Order order = (Order) query.uniqueResult();
		sess.close();

		return order;

	}

	public List<Order> getAllOrders() {

		Session sess = session.openSession();

		Query query = (Query) sess.getNamedQuery("Order.ByAllOrders");
		List<Order> list = query.list();
		sess.close();

		return list;

	}

	public double getTotalOrderAmount() {

		Session sess = session.openSession();

		Query query = (Query) sess.getNamedQuery("Order.ByOrderAmount");
		double amount = (double) query.uniqueResult();
		sess.close();
		return amount;
	}
	
	public List<Object[]> getItemByOrderId (int salesId) {
		
		Session sess = session.openSession();
		String HQL = "SELECT o.order_id,  oi.Item_Id FROM tblorder o JOIN order_item oi ON (o.order_id = oi.order_id) JOIN tblitem i ON (i.Item_Id = oi.Item_Id) WHERE o.order_id = ?";
		
		SQLQuery query = sess.createSQLQuery(HQL);
		query.setInteger(0, salesId);
		query.list();
		List<Object[]> list = query.list();
		
		for(Object[] arr : list){
			Item item = new Item();
			Order order = new Order();
			
			order.setId(Integer.parseInt(arr[0].toString()));
			
			item.setId(Integer.parseInt(arr[1].toString()));
			//item.setItemName(arr[2].toString());
			
			System.out.println(Arrays.toString(arr));
			System.out.println("Order Number is : " + order.getId());
			System.out.println("Item Number is : " + item.getId() );
			System.out.println("--------------------------------------------------------------------------");
		}
		sess.close();

		return list;

	}

}
