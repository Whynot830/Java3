package com.example.pw21.Tables;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "departuresR")
@NoArgsConstructor
public class Departure {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "departureType")
    private String departureType;
    @Column(name = "departureDate")
    private String departureDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "postOfficeId", insertable = false, updatable = false)
    private PostOffice postOffice;

    @Column(name = "postOfficeId")
    private Integer postOfficeId;
}
