package com.example.pw24.Tables;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@Table(name = "postofficesR")
public class PostOffice {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String officeName;
    @Column
    private String cityName;
    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "postOffice", cascade = CascadeType.REMOVE)
    private List<Departure> departures;
}
