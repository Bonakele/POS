package com.pos.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pos.dao.inter.SalesInterface;
import com.pos.helper.Helper;
import com.pos.model.Sales;

public class SalesImplementation implements SalesInterface{

	@Override
	public void purchase(Sales sale) {

		SessionFactory session=Helper.getSessionFactory();
		Session sess=session.openSession();
		sess.beginTransaction();
		sess.saveOrUpdate(sale);
		sess.getTransaction().commit();
		sess.close();
		
	}

	@Override
	public void edit(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Sales> view() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sales> search(int x) {
		// TODO Auto-generated method stub
		return null;
	}

}
