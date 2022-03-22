package com.BrushCircle.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Artist {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long artistid;
    private String firstname, lastname, name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="artist")
    @JsonIgnore
    private List<Product> products;

    public Artist() {}

    public Artist(String firstname, String lastname) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
        this.name = firstname + " " + lastname;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public long getArtistid() {
        return artistid;
    }

    public void setArtistid(long artistid) {
        this.artistid = artistid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName(){return name;}

    public void setName(String firstname, String lastname) { this.name = name;}


}
