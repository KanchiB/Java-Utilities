package io.kanchi.collections;

public class Person {
	
	private Integer id;
	private String firstname;
	private String secondName;
	
	
	public Person(Integer id, String firstname, String secondName) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.secondName = secondName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	

}
