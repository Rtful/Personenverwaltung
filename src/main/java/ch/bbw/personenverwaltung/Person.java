package ch.bbw.personenverwaltung;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "Person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "firstname")
    @NotNull
    @NotEmpty
    @Size(max = 20)
    private String firstname;

    @Column(name = "lastname")
    @NotNull
    @NotEmpty
    @Size(max = 20)
    private String lastname;

    @Column(name = "birthdate")
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotEmpty
    private LocalDate birthdate;

    @Column(name = "email")
    @NotNull
    @NotEmpty
    @Email
    private String email;

    @Column(name = "gender")
    @NotNull
    @NotEmpty
    @Size(max = 20)
    private String gender;

    public Person(String firstname, String lastname, LocalDate birthdate, String email, String gender) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.email = email;
        this.gender = gender;
    }

    public Person() {
        //
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
