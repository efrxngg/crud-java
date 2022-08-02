package edu.proyecto.domains;

import edu.proyecto.dao.CrudUser;

public class Main {

	public static void main(String[] args) {
		
		CrudUser objCU = new CrudUser();
		
//		User objU = new User();
//		objU.setName("Luber");
//		objU.setLast_name("Noc");
//		objU.setEmail("luber@gmail.com");
//		objU.setPassword("1234");
//		
//		objCU.createUser("proyecto", objU);
		
//		objCU.getAllUsers("proyecto").forEach((user)->{System.out.println(user.getData());});;
		
//		User user = objCU.getOneUser("proyecto", 1);
//		System.out.println(user.getData());
		
//		objCU.updateUser("proyecto", objU, 2);
		
		objCU.deleteUser("proyecto", 6);
	}

}
