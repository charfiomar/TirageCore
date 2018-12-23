package com.omar.daos;

import java.util.List;
import java.util.Optional;

import javax.ejb.Local;

import com.omar.entities.Enseignant;
import com.omar.exceptions.DaoException;

@Local
public interface EnseignantDaoLocal {
	
	Optional<Enseignant> get(Long id);

	List<Enseignant> getAll();

	void save(Enseignant t) throws DaoException;

	void update(Enseignant tOriginal, Enseignant tModified) throws DaoException;

	void delete(Enseignant t) throws DaoException;
}
