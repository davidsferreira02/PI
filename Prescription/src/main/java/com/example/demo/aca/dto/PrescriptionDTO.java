package com.example.demo.aca.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

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




/*@NonNull
    private LocalDate createdAt;
@NonNull
    private LocalDate expiredAt;*/

    @NotEmpty
    private String dosage;


}
