package de.htwberlin.webtech.webtech.web.api;

import de.htwberlin.webtech.webtech.persistence.BucketEntity;
import de.htwberlin.webtech.webtech.persistence.RoleEntity;

public class User {
    public long id;
    public String login;
    public String password;
    public String firstName;
    public String lastName;
    public String adresse;
    public RoleEntity role;
    public BucketEntity bucket;

    public User(long id, String login, String password, String firstName, String lastName, String adresse, RoleEntity role, BucketEntity bucket) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.adresse = adresse;
        this.role = role;
        this.bucket = bucket;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }

    public BucketEntity getBucket() {
        return bucket;
    }

    public void setBucket(BucketEntity bucket) {
        this.bucket = bucket;
    }
}
