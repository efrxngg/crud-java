package edu.proyecto.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Conexion {
	
	public Connection getConectionMySql(String nameDB) {
		Connection conexion = null;
		Properties dbSeason = new Properties();
		dbSeason.put("user", "root");
		dbSeason.put("password", "root1234");
		String url = String.format("jdbc:mysql://localhost:3307/%s", nameDB);
		
		try {
			conexion = DriverManager.getConnection(url, dbSeason);
		
		}catch(SQLException ex) {System.out.println(ex);}
		
		return conexion;
	}
	
	
	
	
}