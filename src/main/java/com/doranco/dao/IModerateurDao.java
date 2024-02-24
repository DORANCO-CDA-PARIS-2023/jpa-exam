package com.doranco.dao;

import java.util.List;

import com.doranco.entity.uers.Moderateur;

public interface IModerateurDao {

	Moderateur addModerateur(Moderateur moderateur) throws Exception;
	Moderateur getModerateurById(Long id) throws Exception;
	List<Moderateur> getModerateurs() throws Exception;
	void updateModerateur(Moderateur moderateur) throws Exception;
	void removeModerateur(Long id) throws Exception;
}
