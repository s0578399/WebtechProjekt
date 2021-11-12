package de.htwberlin.webtech.webtech.web.api;

public class UserManipulationRequest {

    public String firstName;
    public String lastName;
    public String adresse;

    public UserManipulationRequest(String firstName, String lastName, String adresse) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.adresse = adresse;
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
