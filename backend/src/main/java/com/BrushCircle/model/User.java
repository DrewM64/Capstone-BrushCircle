package com.BrushCircle.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName", nullable = false, length = 20)
    private String firstName;

    @Column(name = "lastName", nullable = false, length = 20)
    private String lastName;

    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(nullable = false, length = 64)
    private String password;

    private String phoneNumber;
    private String address;
    private String state;
    private String patreon;
    private String cashapp;
    private String title;

    private String profileImageName;
    private String biography;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @JsonIgnore
    private List<Product> products;
    @Column(nullable = false)
    private String role;

    public User(){}

    public User(String firstName, String lastName, String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String firstName, String lastName, String email, String password, String phoneNumber, String address, String state, String patreon, String cashapp, String title, String profileImageName, String biography) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.state = state;
        this.patreon = patreon;
        this.cashapp = cashapp;
        this.title = title;
        this.profileImageName = profileImageName;
        this.biography = biography;
    }

    public User(String firstName, String lastName, String email, String password, String phoneNumber, String address, String state, String patreon, String cashapp, String title, String profileImageName, String biography, List<Product> products) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.state = state;
        this.patreon = patreon;
        this.cashapp = cashapp;
        this.title = title;
        this.profileImageName = profileImageName;
        this.biography = biography;
        this.products = products;
    }

    public User(String firstName, String lastName, String email, String password, String phoneNumber, String address, String state, String patreon, String cashapp, String title, String profileImageName, String biography, List<Product> products, String role) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.state = state;
        this.patreon = patreon;
        this.cashapp = cashapp;
        this.title = title;
        this.profileImageName = profileImageName;
        this.biography = biography;
        this.products = products;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPatreon() {
        return patreon;
    }

    public void setPatreon(String patreon) {
        this.patreon = patreon;
    }

    public String getCashapp() {
        return cashapp;
    }

    public void setCashapp(String cashapp) {
        this.cashapp = cashapp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getProfileImageName() {
        return profileImageName;
    }

    public void setProfileImageName(String profileImageName) {
        this.profileImageName = profileImageName;
    }
}