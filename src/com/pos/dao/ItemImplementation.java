package com.pos.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pos.dao.inter.ItemInterface;
import com.pos.helper.Helper;
import com.pos.model.Item;
import com.pos.model.ReturnItem;

public class ItemImplementation implements ItemInterface {

	SessionFactory session = Helper.getSessionFactory();

	@Override
	public int saveItem(Item item) {

		Session sess = session.openSession();
		sess.beginTransaction();

		sess.saveOrUpdate(item);

		sess.getTransaction().commit();
		sess.close();

		return item.getId();
	}

	public Item getItemById(int id) {

		Session sess = session.openSession();

		Query query = (Query) sess.getNamedQuery("Item.ById");
		query.setInteger(0, id);
		Item item = (Item) query.uniqueResult();

		return item;

	}

	@Override
	public List<Item> getAllItems() {

		Session sess = session.openSession();

		Query query = (Query) sess.getNamedQuery("Item.ByAllItems");
		List<Item> list = query.list();

		return list;
	}
	
	
	public List<Item> getItemByTypeSizeColour(String type, String colour, String size) {

		Session sess = session.openSession();

		Query query = (Query) sess.getNamedQuery("Item.Return");
		query.setString(0, type);
		query.setString(0, colour);
		query.setString(0, size);
		List<Item> list = query.list();

		return list;

	}
	

	

}
