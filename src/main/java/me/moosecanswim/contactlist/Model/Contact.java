package me.moosecanswim.contactlist.Model;

import org.hibernate.validator.constraints.Email;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Contact {
    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @NotNull(message="you need a first name")
    private String firstName;
    private String lastName;
    @Email(message="Enter a valid Email Address")
    private String email;
    //validation for phone phoneNumber
    private String phoneNumber;

    public void setId(Long id) {
        this.id = id;
    }


    public long getId() {
        return id;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
