package com.example.demo.aca.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrescriptionDTO {
    private Long id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String doctorName;

    @NotEmpty
    private String patientName;

    @NotEmpty
    private String medication;



    // Getters and setters
}
