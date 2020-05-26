package com.persona.persons.domain;

import javax.persistence.*;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String mobilnumber;
    @Column(nullable = false)
    private String husdjur;

    public Person() {

    }

    public Person (String firstName, String lastName, String email,String mobilnumber,String husdjur){
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.mobilnumber=mobilnumber;
        this.husdjur=husdjur;
    }

    public String getHusdjur() {
        return husdjur;
    }

    public void setHusdjur(String husdjur) {
        this.husdjur = husdjur;
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

    public String getMobilnumber() {
        return mobilnumber;
    }

    public void setMobilnumber(String mobilnumber) {
        this.mobilnumber = mobilnumber;
    }
}
