package com.pos.dao.inter;

import java.util.List;

import com.pos.model.Client;

public interface ClientInterface {
	void saveClient(Client client);
	public String save(Client client);
	public Client getClientById(String idNum);
	void edit(int x);
	void delete(int x);
	List<Client> view();
	List<Client> search(String x);

}
