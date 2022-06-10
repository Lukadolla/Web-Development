package app;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="person")

public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String firstname;

    @Column
    private String surname;

    public List<Phone> getPhone() {
        return phone;
    }

    @OneToMany(mappedBy = "person")
    private List<Phone> phone;

    public int getId() { return id; }

    public String getFirstname() { return firstname; }

    public String getSurname() { return surname; }

    public void setId(int id) { this.id = id;}

    public void setFirstname(String firstname) { this.firstname = firstname; }

    public void setSurname(String surname) { this.surname = surname; }
    
}
