package com.omar.daos;

import java.util.List;
import java.util.Optional;

import javax.ejb.Local;

import com.omar.entities.Tache;
import com.omar.exceptions.DaoException;

@Local
public interface TacheDaoLocal {
	Optional<Tache> get(Long id);

	List<Tache> getAll();

	void save(Tache t) throws DaoException;

	void update(Tache tOriginal, Tache tModified) throws DaoException;

	void delete(Tache t) throws DaoException;
}
