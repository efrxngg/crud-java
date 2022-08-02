package edu.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.proyecto.domains.User;
import edu.proyecto.interfaces.ICrudUser;

public class CrudUser implements ICrudUser{
	private Conexion cone = new Conexion();
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	
	@Override
	public Boolean createUser(String base, User obj) {
		Connection cursor = cone.getConectionMySql(base);
		String query = String.format("insert into user(name, last_name, email, password) values('%s', '%s', '%s', '%s')", 
		obj.getName(), obj.getLast_name()	, obj.getEmail(), obj.getPassword());
//		System.out.println(query);
		
		try {
			stmt = cursor.createStatement();
			if(stmt.execute(query)) {
			}
			else {
				System.out.println(String.format("[%s]Usuario Agregado", stmt.getUpdateCount()));
				return true;
			}
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}finally {releaseSource(rs, stmt, cursor);}
	
		return false;
	}
	
	
	@Override
	public List<User> getAllUsers(String base) {
		List<User> listUsers = new ArrayList<User>();
		Connection cursor = cone.getConectionMySql(base);
		
		try {
			stmt = cursor.createStatement();
			rs = stmt.executeQuery("select * from user");
			while(rs.next()) {
				listUsers.add(new User(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("last_name"),
						rs.getString("email"),
						rs.getString("password")
					));
			}
		}catch(SQLException ex) {System.out.println(ex.getMessage());
		}finally {releaseSource(rs, stmt, cursor);}
		
		return listUsers;
	}	
	
	
	@Override
	public User getOneUser(String base, Integer id) {
		Connection cursor = cone.getConectionMySql(base);
		String query = String.format("select * from user where id = %s", id);
	
		try {
			stmt = cursor.createStatement();
			rs = stmt.executeQuery(query);
			rs.next();
			return new User(
					rs.getInt("id"),
					rs.getString("name"),
					rs.getString("last_name"),
					rs.getString("email"),
					rs.getString("password")
				);
			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}finally {
			releaseSource(rs, stmt, cursor);
		}
		return null;
	}
	
	
	@Override
	public Boolean updateUser(String base, User newObj,Integer id) {
		
		Connection cursor = cone.getConectionMySql(base);
		String query = "update user set name=?, last_name=?, email=?, password=? where id=?";
		
		try {
			pstmt = cursor.prepareStatement(query);
			pstmt.setString(1, newObj.getName());
			pstmt.setString(2, newObj.getLast_name());
			pstmt.setString(3, newObj.getEmail());
			pstmt.setString(4, newObj.getPassword());
			pstmt.setInt(5, id);
			
			System.out.println(String.format("[%s]Registro Modificado", pstmt.executeUpdate()));
			return true;
		}catch(SQLException ex) {
			System.out.print(ex);
		}finally{releaseSource(rs, pstmt, cursor);}
		
		return false;
	}

	
	@Override
	public Boolean deleteUser(String base, Integer id) {
		Connection cursor = cone.getConectionMySql(base);
		try {
			pstmt = cursor.prepareStatement("delete from user where id=?");
			pstmt.setInt(1, id);
			System.out.println(String.format("[%s]Registro Modificado", pstmt.executeUpdate()));
			return true;
		
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}finally{releaseSource(rs, pstmt, cursor);}
		
		return false;
	}
	
	
	private void releaseSource(ResultSet rs, Statement stmt, Connection cone) {
		if(rs != null) {
			try {rs.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
			rs = null;
		}
		
		if(stmt != null) {
			try {stmt.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
			stmt = null;
		}
		
		if(cone != null) {
			try {cone.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
			cone = null;
		}
		
	}
	
	private void releaseSource(ResultSet rs, PreparedStatement pstmt, Connection cone) {
		if(rs != null) {
			try {rs.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
			rs = null;
		}
		
		if(stmt != null) {
			try {stmt.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
			pstmt = null;
		}
		
		if(cone != null) {
			try {cone.close();}catch(SQLException ex){System.out.println(ex.getMessage());}
			cone = null;
		}
		
	}


	
}
