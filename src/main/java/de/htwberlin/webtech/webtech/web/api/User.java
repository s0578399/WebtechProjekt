package de.htwberlin.webtech.webtech.web.api;

public class Person {
    public long id;
    public String firstName;
    public String lastName;
    public String adresse;

    public Person(long id, String firstName, String lastName, String adresse) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.adresse = adresse;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
