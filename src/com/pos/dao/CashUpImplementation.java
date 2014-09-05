package com.pos.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pos.dao.inter.CashUpInterface;
import com.pos.helper.Helper;
import com.pos.model.CashUp;


public class CashUpImplementation implements CashUpInterface {
	SessionFactory session = Helper.getSessionFactory();

	public int saveCashUp(CashUp cashup) {

		Session sess = session.openSession();
		sess.beginTransaction();
		sess.save(cashup);
		sess.getTransaction().commit();
		sess.close();

		return cashup.getId();
	}

	@Override
	public CashUp getCashUpById(int id) {

		Session sess = session.openSession();

		Query query = (Query) sess.getNamedQuery("CashUp.ById");
		query.setInteger(0, id);
		CashUp cashUp = (CashUp) query.uniqueResult();

		sess.close();

		return cashUp;
	}

	@Override
	public List<CashUp> getAllCashUps() {

		Session sess = session.openSession();

		Query query = (Query) sess.getNamedQuery("CashUp.ByAllCashUps");

		List<CashUp> list = query.list();

		return list;
	}
}
