package com.pos.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pos.dao.inter.ItemInterface;
import com.pos.helper.Helper;
import com.pos.model.Item;
import com.pos.model.ReturnItem;

public class ItemImplementation implements ItemInterface{

	@Override
	public void save(Item item) {
		SessionFactory session=Helper.getSessionFactory();
		Session sess=session.openSession();
		sess.beginTransaction();
		sess.saveOrUpdate(item);
		sess.getTransaction().commit();
		sess.close();
		
	}
	
	public Item getItemById(int id) {

		SessionFactory session = Helper.getSessionFactory();
		Session sess = session.openSession();

		sess.beginTransaction();

		Item item = (Item) sess.load(Item.class, id);

		return item;

	}
	
	@Override
	public int saveItem(Item item) {
		SessionFactory session = Helper.getSessionFactory();
		Session sess = session.openSession();
		sess.beginTransaction();

		sess.save(item);
		
		sess.getTransaction().commit();
		sess.close();

		return item.getId();
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
	public List<Item> view() {
		SessionFactory session=Helper.getSessionFactory();
		Session sess=session.openSession();
		
		sess.beginTransaction();
		
		org.hibernate.Query query=sess.createQuery("from Item");
        List<Item> list=query.list();
	
		return list;
	}

	@Override
	public Item getItem(int x) {
	
		SessionFactory session=Helper.getSessionFactory();
		Session sess=session.openSession();
		sess.beginTransaction();
		//org.hibernate.Query query=sess.createQuery(Item.class, x);
		Item item = (Item) sess.load(Item.class, x);
		
		/*Item item=(Item)query;	
		sess.close();*/
		
		return item;
	}

	
}
