package com.omar.daos;

import java.util.List;
import java.util.Optional;

import javax.ejb.Local;

import com.omar.entities.Agent;
import com.omar.exceptions.DaoException;

@Local
public interface AgentDaoLocal {

	Optional<Agent> get(Long id);

	List<Agent> getAll();

	void save(Agent t) throws DaoException;

	void update(Agent tOriginal, Agent tModified) throws DaoException;

	void delete(Agent t) throws DaoException;
}
