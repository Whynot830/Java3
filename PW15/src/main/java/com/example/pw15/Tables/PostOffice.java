package com.example.pw15.Tables;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "postoffices")
@NoArgsConstructor
public class PostOffice {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "officeName")
    private String officeName;
    @Column(name = "cityName")
    private String cityName;


}
