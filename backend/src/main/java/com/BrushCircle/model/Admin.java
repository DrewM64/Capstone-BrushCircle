package com.BrushCircle.model;

import lombok.Data;
import lombok.ToString;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

//@Data
//@ToString(exclude = "password")
//@Entity
public class Admin {
//
//	public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
//
//	private @Id
//	@GeneratedValue
//	Long id;
//
//	private String name;
//
//	private @JsonIgnore
//	String password;
//
//	private String[] roles;
//
//	public void setPassword(String password) {
//		this.password = PASSWORD_ENCODER.encode(password);
//	}
//
//	protected Admin() {}
//
//	public Admin(String name, String password, String... roles) {
//
//		this.name = name;
//		this.setPassword(password);
//		this.roles = roles;
//	}

}
