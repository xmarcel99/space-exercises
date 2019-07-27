package com.space.exercises.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Note {
    @Id
    @GeneratedValue
    private long id;
    private String note;
    @ManyToOne
    @JoinColumn(name = "tourist_id")
    private Tourist tourist;

    public Note(String note) {
        this.note = note;
    }
}
