package com.doranco.factory;

import com.doranco.entity.uers.Client;
import com.doranco.interfaces.IUserAbstractFactory;

public class ClientFactory implements IUserAbstractFactory<Client> {

	@Override
	public Client createUser() {
		return new Client();
	}

}
