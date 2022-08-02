package edu.proyecto.dao;

import java.util.List;

import edu.proyecto.domains.User;

public class Main {

	public static void main(String[] args) {
//		Conexion cone = new Conexion();
//		cone.conectar("proyecto");
		
		CrudUser objCU = new CrudUser();
		List<User>lista = objCU.getAllUsers("proyecto");
		lista.forEach(item -> System.out.println(item.getData()));
		
		
	}

}
