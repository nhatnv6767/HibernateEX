package model;

import javax.persistence.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "tbl_PERSON")
public class Person {
    @Id
    @GeneratedValue
    @Column(name = "person_id")
    private long id;
    private String name;
    private Date dateOfBirth;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "spouse_id")
    private Person spouse;

    public Person() {
    }

    public Person(String name, Date dateOfBirth, Person spouse) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.spouse = spouse;
    }

    public Person(long id, String name, Date dateOfBirth, Person spouse) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.spouse = spouse;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Person getSpouse() {
        return spouse;
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    //    public String toString() {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        String formattedDateOfBirth = dateOfBirth.toLocalDate().format(formatter);
//        return "Person{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", dateOfBirth=" + formattedDateOfBirth +
//                ", spouse=" + spouse +
//                '}';
//    }
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDateOfBirth = dateOfBirth.toLocalDate().format(formatter);
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                (spouse != null ? ", spouseId=" + spouse.getId() : "") + // Print spouse ID only
                '}';
    }
}
