package com.example.pw15.Tables;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "departures")
@NoArgsConstructor
public class Departure {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "departureType")
    private String departureType;
    @Column(name = "departureDate")
    private String departureDate;

}
