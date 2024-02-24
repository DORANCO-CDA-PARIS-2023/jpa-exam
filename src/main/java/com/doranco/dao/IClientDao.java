package com.doranco.dao;

import java.util.List;

import com.doranco.entity.uers.Client;

public interface IClientDao {

	Client addClient(Client client) throws Exception;

	Client getClientById(Long id) throws Exception;

	List<Client> getClients() throws Exception;

	void updateClient(Client client) throws Exception;

	void removeClient(Long id) throws Exception;

}
