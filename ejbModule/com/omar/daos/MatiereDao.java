package com.omar.daos;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.omar.entities.Matiere;
import com.omar.exceptions.DaoException;

/**
 * Session Bean implementation class MatiereDao
 */
@Singleton
@LocalBean
public class MatiereDao implements Dao<Matiere>, MatiereDaoLocal {

	@PersistenceContext
	private EntityManager entityManager;

	public MatiereDao() {
	}

	@Override
	public Optional<Matiere> get(Long id) {
		return Optional.ofNullable(entityManager.find(Matiere.class, id));
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Matiere> getAll() {
		Query query = entityManager.createQuery("FROM matiere", Matiere.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public void save(Matiere t) throws DaoException {
		entityManager.persist(t);
	}

	@Override
	@Transactional
	public void update(Matiere tOriginal, Matiere tModified) throws DaoException {
		try {

			tOriginal.setLibelle(Objects.requireNonNull(tModified.getLibelle()));

		} catch (NullPointerException e) {
			throw new DaoException(e);
		}

		entityManager.merge(tOriginal);

	}

	@Override
	@Transactional
	public void delete(Matiere t) throws DaoException {
		entityManager.remove(t);
	}

}
