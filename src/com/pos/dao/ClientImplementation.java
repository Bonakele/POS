package com.pos.dao;

import java.rmi.RemoteException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.hql.ast.util.SessionFactoryHelper;

import com.pos.dao.inter.ClientInterface;
import com.pos.helper.Helper;
import com.pos.model.Client;
import com.xml_fx.services.SAIDValidator.SAIDValidatorSoapProxy;
import com.xml_fx.services.SAIDValidator.said_xsd.SaidType;

public class ClientImplementation implements ClientInterface {

	SessionFactory session = Helper.getSessionFactory();
	SAIDValidatorSoapProxy validate = new SAIDValidatorSoapProxy();

	public String saveClient(Client client) throws RemoteException {

		/*SaidType idNum = validate.validateIdString("", client.getIdNum());*/
	
		/*if(idNum.isValid()==true)
		{*/
			Session sess = session.openSession();
			sess.beginTransaction();

			sess.save(client);

			sess.getTransaction().commit();
			sess.close();
		/*}
		else {
			
			System.out.println("Uyishangane Ndoda");
			
		}
		*/
		

		return client.getIdNum();
	}
	
	public void updateClient(Client client){
		
		Session sess = session.openSession();
		sess.beginTransaction();

		sess.update(client);
		sess.getTransaction().commit();//gettransaction.commit

		sess.close();
	}


	@Override
	public Client getClientById(String idNum) {
		
	
		Session sess = session.openSession();

		Query query = (Query)sess.getNamedQuery("Client.ById");
		query.setString(0,idNum);
		Client client = (Client)query.uniqueResult();
		
		sess.close();

		return client;
	}

	@Override
	public List<Client> getAllClients() {
	
		Session sess = session.openSession();

		Query query = (Query) sess.getNamedQuery("Client.ByAllClients");
				

		List<Client> list = query.list();
	

		return list;
	}
	
	
}
