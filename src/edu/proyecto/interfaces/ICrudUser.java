package edu.proyecto.interfaces;

import java.util.List;

import edu.proyecto.domains.User;

public interface ICrudUser {
	Boolean createUser(String base, User obj);
	List<User> getAllUsers(String base);
	User getOneUser(String base, Integer id);
	Boolean updateUser(String base, User newObj, Integer id);
	Boolean deleteUser(String base, Integer id);
	
}
