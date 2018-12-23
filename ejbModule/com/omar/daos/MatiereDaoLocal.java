package com.omar.daos;

import java.util.List;
import java.util.Optional;

import javax.ejb.Local;

import com.omar.entities.Matiere;
import com.omar.exceptions.DaoException;

@Local
public interface MatiereDaoLocal {
	Optional<Matiere> get(Long id);

	List<Matiere> getAll();

	void save(Matiere t) throws DaoException;

	void update(Matiere tOriginal, Matiere tModified) throws DaoException;

	void delete(Matiere t) throws DaoException;
}
