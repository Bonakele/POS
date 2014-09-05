package com.pos.dao.inter;

import java.rmi.RemoteException;
import java.util.List;

import com.pos.model.Client;

public interface ClientInterface {
	public String saveClient(Client client) throws RemoteException;
	public Client getClientById(String idNum);
	List<Client> getAllClients();

}
