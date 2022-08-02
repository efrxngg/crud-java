package edu.proyecto.domains;

public abstract class Person {
//	Properties
	private String name;
	private String last_name;
	
//	Constructors
	public Person() {}
	public Person(String name, String last_name) {
		this.name = name;
		this.last_name = last_name;
	}
	
//	Setters and Getters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	public abstract String getData();
}
