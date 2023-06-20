package com.example.demo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "prescriptions")
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;


    private String doctorName;

    private String pacientName;

    @Column(nullable = false)
    private String medication;

    @Column(nullable = false)
    private String dosage;

    @Column()

    private LocalDate expiredAt;

    @Column()
    private LocalDate createdAt;


}
