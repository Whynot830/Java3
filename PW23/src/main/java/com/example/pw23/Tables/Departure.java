package com.example.pw23.Tables;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "departuresR")
public class Departure {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String departureType;
    @Column
    private String departureDate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinColumn(name = "postOfficeId", insertable = false, updatable = false)
    private PostOffice postOffice;
    @Column
    private Integer postOfficeId;
}
