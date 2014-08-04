package com.pos.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pos.dao.inter.CashUpInterface;
import com.pos.helper.Helper;
import com.pos.model.CashUp;



public class CashUpImplementation implements CashUpInterface{
	
	public void saveCashUp(CashUp cashup) {
		SessionFactory session=Helper.getSessionFactory();
		Session sess=session.openSession();
		sess.beginTransaction();
		sess.save(cashup);
		sess.getTransaction().commit();
		sess.close();
		
	}


}
