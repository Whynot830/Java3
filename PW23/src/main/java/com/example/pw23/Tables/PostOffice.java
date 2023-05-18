package com.example.pw23.Tables;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
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
