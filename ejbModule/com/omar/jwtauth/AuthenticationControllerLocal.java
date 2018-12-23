package com.omar.jwtauth;

import javax.ejb.Local;

@Local
public interface AuthenticationControllerLocal {

	String authentication(String login, String password);
}
