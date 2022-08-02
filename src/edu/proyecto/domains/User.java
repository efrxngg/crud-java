package edu.proyecto.domains;

public class User extends Person{
	private Integer id;
	private String password;
	private String email;
	
	public User() {}
	
	
	public User(Integer id, String name, String last_name, String password, String email) {
		super(name, last_name);
		this.id = id;
		this.password = password;
		this.email = email;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String getData() {
		// TODO Auto-generated method stub
		return getId()+" "+getName()+" "+getLast_name()+" "+getEmail()+" "+getPassword();
	}
	
}
