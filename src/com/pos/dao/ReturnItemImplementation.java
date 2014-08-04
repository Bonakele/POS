package com.pos.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pos.dao.inter.ReturnItemInterface;
import com.pos.helper.Helper;
import com.pos.model.Order;
import com.pos.model.ReturnItem;

public class ReturnItemImplementation implements ReturnItemInterface {
	
	public int save(ReturnItem returnItem) {
		SessionFactory session = Helper.getSessionFactory();
		Session sess = session.openSession();
		sess.beginTransaction();

		// sess.save(item);
		sess.save(returnItem);

		sess.getTransaction().commit();
		sess.close();

		return returnItem.getId();
	}

	public ReturnItem getReturnById(int id) {

		SessionFactory session = Helper.getSessionFactory();
		Session sess = session.openSession();

		sess.beginTransaction();

		ReturnItem returnItem = (ReturnItem) sess.load(ReturnItem.class, id);

		return returnItem;

	}
	
	public List<ReturnItem> getAllReturns() {

		SessionFactory session = Helper.getSessionFactory();
		Session sess = session.openSession();

		sess.beginTransaction();

		org.hibernate.Query query = sess.createQuery("from ReturnItem");
		List<ReturnItem> list = query.list();

		return list;
	}
}
