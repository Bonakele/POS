package com.pos.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pos.dao.inter.ReturnItemInterface;
import com.pos.helper.Helper;
import com.pos.model.Order;
import com.pos.model.ReturnItem;

public class ReturnItemImplementation implements ReturnItemInterface {

	SessionFactory session = Helper.getSessionFactory();

	public int saveReturn(ReturnItem returnItem) {

		Session sess = session.openSession();
		sess.beginTransaction();

		sess.save(returnItem);

		sess.getTransaction().commit();
		sess.close();

		return returnItem.getId();
	}

	public ReturnItem getReturnById(int id) {

		Session sess = session.openSession();

		Query query = (Query) sess.getNamedQuery("ReturnItem.ById");
		query.setInteger(0, id);
		ReturnItem returnItem = (ReturnItem) query.uniqueResult();

		return returnItem;

	}

	public List<ReturnItem> getAllReturns() {

		Session sess = session.openSession();

		Query query = (Query) sess.getNamedQuery("ReturnItem.ByAllReturns");
		List<ReturnItem> list = query.list();

		return list;
	}
	
	

}
