package com.omar.daos;

import java.util.List;
import java.util.Optional;

import com.omar.exceptions.DaoException;

public interface Dao<T> {

	Optional<T> get(Long id);

	List<T> getAll();

	void save(T t) throws DaoException;

	void update(T tOriginal, T tModified) throws DaoException;

	void delete(T t) throws DaoException;
}