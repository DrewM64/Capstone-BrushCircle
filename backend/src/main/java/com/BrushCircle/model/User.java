package com.BrushCircle.model;

//import org.springframework.boot.autoconfigure.domain.EntityScan;

public class User {
    
    private long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String title;
    private String email;

    public User(String email) {
		super();
		this.email = email;
	}

	public User() {
		super();
	}

    public User(long id, String userName, String password, String firstName, String lastName, String title, String email){
        this.id = id;
        this.username = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.email = email;
    }

    public User(String firstName, String lastName, String title, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password 
        + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email 
        + ", title=" + title + "]";
	}
}