package com.doranco.dao;

import java.util.List;

import com.doranco.entity.chambres.Chambre;

public interface IChambreDao {

	Chambre addChambre(Chambre chambre) throws Exception;
	Chambre getChambreById(Long id) throws Exception;
	List<Chambre> getChambres() throws Exception;
	void updateChambre(Chambre chambre) throws Exception;
	void removeChambre(Long id) throws Exception;
}
