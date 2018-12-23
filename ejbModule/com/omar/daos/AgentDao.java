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

import com.omar.entities.Agent;
import com.omar.exceptions.DaoException;
import com.omar.utils.DigestUtils;

/**
 * Session Bean implementation class AgentDao
 */
@Singleton
@LocalBean
public class AgentDao implements Dao<Agent>, AgentDaoLocal {

	@PersistenceContext
	private EntityManager entityManager;

	public AgentDao() {
	}

	@Override
	public Optional<Agent> get(Long id) {
		return Optional.ofNullable(entityManager.find(Agent.class, id));
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Agent> getAll() {
		Query query = entityManager.createQuery("from agent", Agent.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public void save(Agent t) throws DaoException {
		
		t.setPassword(DigestUtils.digestSHA1(t.getPassword()));
		entityManager.persist(t);
	}

	@Override
	@Transactional
	public void update(Agent tOriginal, Agent tModified) throws DaoException {
		try {
			tOriginal.setPassword(Objects.requireNonNull(tModified.getPassword()));

		} catch (NullPointerException e) {
			throw new DaoException(e);
		}

		entityManager.merge(tOriginal);

	}

	@Override
	@Transactional
	public void delete(Agent t) throws DaoException {
		entityManager.remove(t);
	}

}
