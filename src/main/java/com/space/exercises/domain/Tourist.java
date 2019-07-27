package com.space.exercises.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class Tourist {
    @Id
    @GeneratedValue
    private long id;
    private String firstname;
    private String lastname;
    private char male;
    private String country;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "tourist")
    private List<Note> notes;
    private LocalDate birthDate;
    @ManyToMany(mappedBy = "tourists",cascade = CascadeType.ALL)
    private List<Flight> flights;

    public Tourist(String firstname, String lastname, char male, String country, LocalDate birthDate) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.male = male;
        this.country = country;
        this.birthDate = birthDate;
        this.notes = new ArrayList<>();
        this.flights = new ArrayList<>();
    }

    public Tourist(long id,String firstname, String lastname, char male, String country, LocalDate birthDate) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.male = male;
        this.country = country;
        this.birthDate = birthDate;
        this.notes = new ArrayList<>();
        this.flights = new ArrayList<>();
    }


}