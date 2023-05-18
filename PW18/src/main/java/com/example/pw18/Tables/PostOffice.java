package com.example.pw18.Tables;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@Table(name = "postofficesR")
@NoArgsConstructor
public class PostOffice {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "officeName")
    private String officeName;
    @Column(name = "cityName")
    private String cityName;
    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "postOffice", cascade = CascadeType.ALL)
    private List<Departure> departures;
}
