package ch.bbw.personenverwaltung;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Person {
    private String firstname;
    private String lastname;
    @Temporal(TemporalType.DATE)
    private LocalDate birthdate;
    private String email;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String gender;


    public Person(String firstname, String lastname, LocalDate birthdate, String email, String gender) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.email = email;
        this.gender = gender;
    }

    public Person() {

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public long getId() {
        return id;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
}
