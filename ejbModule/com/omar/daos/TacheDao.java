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

import com.omar.entities.Tache;
import com.omar.exceptions.DaoException;

/**
 * Session Bean implementation class TacheDao
 */
@Singleton
@LocalBean
public class TacheDao implements Dao<Tache>, TacheDaoLocal {

	@PersistenceContext
	private EntityManager entityManager;

	public TacheDao() {
	}

	@Override
	public Optional<Tache> get(Long id) {
		return Optional.ofNullable(entityManager.find(Tache.class, id));
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Tache> getAll() {
		Query query = entityManager.createQuery("FROM tache", Tache.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public void save(Tache t) throws DaoException {
		entityManager.persist(t);
	}

	@Override
	@Transactional
	public void update(Tache tOriginal, Tache tModified) throws DaoException {
		try {

			tOriginal.setDateRecuperation(Objects.requireNonNull(tModified.getDateRecuperation()));
			tOriginal.setNbCopies(Objects.requireNonNull(tModified.getNbCopies()));
			tOriginal.setEnseignant(Objects.requireNonNull(tModified.getEnseignant()));
			tOriginal.setMatiere(Objects.requireNonNull(tModified.getMatiere()));
			tOriginal.setTerminee(Objects.requireNonNull(tModified.isTerminee()));

		} catch (NullPointerException e) {
			throw new DaoException(e);
		}

		entityManager.merge(tOriginal);

	}

	@Override
	@Transactional
	public void delete(Tache t) throws DaoException {

		entityManager.remove(t);

	}

}
