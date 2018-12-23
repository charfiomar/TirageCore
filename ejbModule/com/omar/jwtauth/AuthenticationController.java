package com.omar.jwtauth;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.omar.daos.AgentDaoLocal;
import com.omar.daos.EnseignantDaoLocal;
import com.omar.entities.Agent;
import com.omar.entities.Enseignant;
import com.omar.utils.DigestUtils;

/**
 * Session Bean implementation class AuthenticationController
 */
@Stateless
@LocalBean
public class AuthenticationController implements AuthenticationControllerLocal {

	@EJB
	private AgentDaoLocal agentDao;

	@EJB
	private EnseignantDaoLocal enseignantDao;

	public AuthenticationController() {
	}

	public String authentication(String login, String password) {

		String passwordHashed = DigestUtils.digestSHA1(password);
				
		List<Agent> agents = agentDao.getAll();
		
		for (Agent agent : agents) {
			if (agent.getPassword().equals(passwordHashed) && agent.getLogin().equals(login)) {
				return "A" + agent.getId() + "/" + agent.getLogin();
			}
		}
		
		List<Enseignant> enseignants = enseignantDao.getAll();
		
		for (Enseignant enseignant : enseignants){
			if(enseignant.getPassword().equals(passwordHashed) && enseignant.getLogin().equals(login)){
				return "E" + enseignant.getId() + "/" + enseignant.getLogin();
			}
		}
		
		return null;
	}
	
}
