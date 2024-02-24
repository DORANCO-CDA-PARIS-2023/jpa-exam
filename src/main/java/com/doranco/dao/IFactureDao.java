package com.doranco.dao;

import java.util.List;
import com.doranco.entity.chambres.Facture;


public interface IFactureDao {

	Facture addFacture(Facture facture) throws Exception;
	Facture getFactureById(Long id) throws Exception;
	List<Facture> getFactures() throws Exception;
	void updateFacture(Facture facture) throws Exception;
	void removeFacture(Long id) throws Exception;
	
}
