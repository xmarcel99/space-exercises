package com.space.exercises.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Flight {
    @Id
    @GeneratedValue
    private long id;
    private LocalDateTime departues;
    private LocalDateTime arrival;
    private int seatsQuantity;
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "tourist_and_their_flight",
//            joinColumns = @JoinColumn(name = "flight_id",referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "tourist_id",referencedColumnName = "id")
//    )
    private List<Tourist> tourists;
    private BigDecimal priceOfTicket;

    public Flight(LocalDateTime departues, LocalDateTime arrival, int seatsQuantity, List<Tourist> tourists, BigDecimal priceOfTicket) {
        this.departues = departues;
        this.arrival = arrival;
        this.seatsQuantity = seatsQuantity;
        this.tourists = tourists;
        this.priceOfTicket = priceOfTicket;
    }
}