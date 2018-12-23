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

import com.omar.entities.Enseignant;
import com.omar.exceptions.DaoException;
import com.omar.utils.DigestUtils;

@Singleton
@LocalBean
public class EnseignantDao implements Dao<Enseignant>, EnseignantDaoLocal {

	@PersistenceContext
	private EntityManager entityManager;

	public EnseignantDao() {
	}

	@Override
	public Optional<Enseignant> get(Long id) {
		return Optional.ofNullable(entityManager.find(Enseignant.class, id));
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Enseignant> getAll() {
		Query query = entityManager.createQuery("FROM enseignant", Enseignant.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public void save(Enseignant t) throws DaoException {

		t.setPassword(DigestUtils.digestSHA1(t.getPassword()));
		entityManager.persist(t);
	}

	@Override
	@Transactional
	public void update(Enseignant tOriginal, Enseignant tModified) throws DaoException {

		try {

			tOriginal.setPassword(Objects.requireNonNull(tModified.getPassword()));
			tOriginal.setNomComplet(Objects.requireNonNull(tModified.getNomComplet()));

		} catch (NullPointerException e) {
			throw new DaoException(e);
		}

		entityManager.merge(tOriginal);
	}

	@Override
	@Transactional
	public void delete(Enseignant t) throws DaoException {
		
		entityManager.remove(t);
	}

}
