package com.pos.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pos.dao.inter.ClientInterface;
import com.pos.helper.Helper;
import com.pos.model.Client;

public class ClientImplementation implements ClientInterface {

	@Override
	public void saveClient(Client client) {
		SessionFactory session = Helper.getSessionFactory();
		Session sess = session.openSession();
		sess.beginTransaction();
		sess.save(client);
		sess.getTransaction().commit();
		sess.close();

	}

	public String save(Client client) {

		SessionFactory session = Helper.getSessionFactory();
		Session sess = session.openSession();
		sess.beginTransaction();

		sess.save(client);

		sess.getTransaction().commit();
		sess.close();

		return client.getIdNum();
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
	public List<Client> view() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client getClientById(String idNum) {
		boolean isFound = false;
		SessionFactory session = Helper.getSessionFactory();
		Session sess = session.openSession();

		sess.beginTransaction();

		Client client = (Client) sess.load(Client.class, idNum);

		sess.close();

		if (client != null) {
			isFound = true;
		}

		return client;
	}

	@Override
	public List<Client> search(String x) {
		SessionFactory session = Helper.getSessionFactory();
		Session sess = session.openSession();
		String y = x;
		boolean isFound = false;
		sess.beginTransaction();

		org.hibernate.Query query = sess.createQuery("from Client Where idNum="
				+ y);

		List<Client> list = query.list();
		for (Client s : list) {
			if (s.getIdNum() == y) {
				isFound = true;

			}
		}

		return list;
	}

}
