package com.space.exercises.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Tourist {
    @Id
    @GeneratedValue
    private long id;
    private String firstname;
    private String lastname;
    private char male;
    private String country;
    private List<String> notes;
    private LocalDate birthDate;
    @ManyToMany(mappedBy = "tourists")
    private List<Flight> flights;

    public Tourist(String firstname, String lastname, char male, String country, List<String> notes, LocalDate birthDate, List<Flight> flights) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.male = male;
        this.country = country;
        this.notes = notes;
        this.birthDate = birthDate;
        this.flights = flights;
    }
}
