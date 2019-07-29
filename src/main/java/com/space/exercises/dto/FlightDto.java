package com.space.exercises.dto;

import com.space.exercises.domain.Tourist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FlightDto {
    private long id;
    private LocalDateTime departues;
    private LocalDateTime arrival;
    private int seatsQuantity;
    private List<Tourist> tourists;
    private BigDecimal priceOfTicket;

    public FlightDto(long id,LocalDateTime departues, LocalDateTime arrival, int seatsQuantity, BigDecimal priceOfTicket) {
        this.id = id;
        this.departues = departues;
        this.arrival = arrival;
        this.seatsQuantity = seatsQuantity;
        this.priceOfTicket = priceOfTicket;
        this.tourists = new ArrayList<>();
    }
}
