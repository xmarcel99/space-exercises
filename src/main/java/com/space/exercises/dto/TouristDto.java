package com.space.exercises.dto;

import com.space.exercises.domain.Flight;
import com.space.exercises.domain.Note;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TouristDto {
    private long id;
    private String firstname;
    private String lastname;
    private char male;
    private String country;
    private List<Note> notes;
    private LocalDate birthDate;
    private List<Flight> flights;

    public TouristDto(long id,String firstname, String lastname, char male, String country, LocalDate birthDate) {
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
