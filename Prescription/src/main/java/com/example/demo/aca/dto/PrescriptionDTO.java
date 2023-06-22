package com.example.demo.aca.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
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
public class PrescriptionDTO {
    private Long id;

    @NotEmpty
    private String title;

    @NotEmpty(message = "You aren´t this doctor")
    private String doctorName;

   @NotEmpty(message = "Name of patient doesn't exist")
    private String patientName;

    @NotEmpty
    private String medication;


    private LocalDate expiredAt;


    private LocalDate createdAt;

    @NotEmpty
    private String dosage;


}
