package com.pos.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pos.dao.inter.SalesInterface;
import com.pos.helper.Helper;
import com.pos.model.Item;
import com.pos.model.Order;
import com.pos.model.Sales;

public class SalesImplementation implements SalesInterface {

	SessionFactory session = Helper.getSessionFactory();

	@Override
	public int saveSale(Sales sale) {

		Session sess = session.openSession();
		sess.beginTransaction();
		sess.saveOrUpdate(sale);
		sess.getTransaction().commit();
		sess.close();

		return sale.getId();
	}

	public Sales getSaleById(int id) {

		Session sess = session.openSession();

		Query query = (Query) sess.getNamedQuery("Sales.ById");
		query.setInteger(0, id);
		Sales sales = (Sales) query.uniqueResult();
		sess.close();
		return sales;

	}
	
	public Sales getSaleByEmployee(int id) {

		Session sess = session.openSession();

		Query query = (Query) sess.getNamedQuery("Sales.ByCashier");
		query.setInteger(0, id);
		Sales sales = (Sales) query.uniqueResult();
		sess.close();
		return sales;

	}

	public List<Sales> getAllSales() {

		Session sess = session.openSession();

		Query query = (Query) sess.getNamedQuery("Sales.ByAllSales");
		List<Sales> list = query.list();
		sess.close();
		return list;
		
	
	}


	public Date exchangeDate() {
		Sales sales=new Sales();
		Calendar calendar=new GregorianCalendar();
		calendar.setTime(sales.getDate());
		calendar.add(Calendar.DATE,2);
		Date exchangeDate=calendar.getTime();
		return exchangeDate;
	}
	
	public double calculateChange(double totalAmount, double amountPayed){
		
		double change = totalAmount - amountPayed;
		
		return change;
		
	}
	
	public double calcTotalPrice(List<Item> amount){
		double totalAmount = 0;
		for(Item price : amount){
			totalAmount = totalAmount + price.getPrice();		
		}
		
		return totalAmount;
		
	}

	}
