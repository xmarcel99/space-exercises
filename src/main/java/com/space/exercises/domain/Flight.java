
package com.space.exercises.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@NamedQuery(
        name = "Flight.findFlightWithFreeSeats",
        query = "from Flight where seatsQuantity > 0"
)
public class Flight {
    @Id
    @GeneratedValue
    private long id;
    private LocalDateTime departues;
    private LocalDateTime arrival;
    @Setter
    private int seatsQuantity;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "tourist_and_their_flight",
            joinColumns = @JoinColumn(name = "flight_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tourist_id", referencedColumnName = "id")
    )
    private List<Tourist> tourists;
    private BigDecimal priceOfTicket;

    public Flight(LocalDateTime departues, LocalDateTime arrival, int seatsQuantity, BigDecimal priceOfTicket) {
        this.departues = departues;
        this.arrival = arrival;
        this.seatsQuantity = seatsQuantity;
        this.priceOfTicket = priceOfTicket;
        this.tourists = new ArrayList<>();
    }

    public Flight(long id,LocalDateTime departues, LocalDateTime arrival, int seatsQuantity, BigDecimal priceOfTicket) {
        this.id = id;
        this.departues = departues;
        this.arrival = arrival;
        this.seatsQuantity = seatsQuantity;
        this.priceOfTicket = priceOfTicket;
        this.tourists = new ArrayList<>();
    }
}