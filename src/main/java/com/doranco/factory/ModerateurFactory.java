package com.doranco.factory;

import com.doranco.entity.uers.Moderateur;
import com.doranco.interfaces.IUserAbstractFactory;

public final class ModerateurFactory implements IUserAbstractFactory<Moderateur> {

	@Override
	public Moderateur createUser() {
		return new Moderateur();
	}
    
   

}
