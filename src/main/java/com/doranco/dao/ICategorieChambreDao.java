package com.doranco.dao;

import java.util.List;

import com.doranco.entity.chambres.CategorieChambre;

public interface ICategorieChambreDao {

	CategorieChambre addCategorieChambre(CategorieChambre categorieChambre) throws Exception;
	CategorieChambre getCategorieChambreById(Long id) throws Exception;
	List<CategorieChambre> getCategoriesChambre() throws Exception;
	void updateCategorieChambre(CategorieChambre categorieChambre) throws Exception;
	void removeCategorieChambre(Long id) throws Exception;
}
