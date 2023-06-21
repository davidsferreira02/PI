package com.example.demo.service;


import com.example.demo.aca.dto.PrescriptionDTO;
import com.example.demo.aca.dto.UserDTO;
import com.example.demo.model.Prescription;
import com.example.demo.model.User;
import com.example.demo.repository.PrescriptionRepository;
import com.example.demo.repository.UserRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {


    private PrescriptionRepository prescriptionRepository;


    public PrescriptionServiceImpl(PrescriptionRepository prescriptionRepository ) {
        this.prescriptionRepository = prescriptionRepository;


    }

    @Override
    public void savePrescription(PrescriptionDTO prescriptionDTO) {
        Prescription prescription = new Prescription();
        prescription.setMedication(prescriptionDTO.getMedication());
        prescription.setTitle(prescriptionDTO.getTitle());
        prescription.setPatientName(prescriptionDTO.getPatientName());
        prescription.setDoctorName(prescriptionDTO.getDoctorName());
        prescription.setDosage(prescriptionDTO.getDosage());
        prescription.setExpiredAt(LocalDate.now().plusDays(30));

        prescription.setCreatedAt(LocalDate.now());


        prescriptionRepository.save(prescription);
    }





    @Override
    public List<PrescriptionDTO> findAllPrescriptionByPacientName(String PacientName) {
        List<Prescription> prescriptions = prescriptionRepository.findAll();
        if(prescriptions.isEmpty()){
            return Collections.emptyList();
        }
        int i = 0;
        for (Prescription prescriptionDTO : prescriptions) {

            if (prescriptionDTO.getPatientName().equals(PacientName)) {

            } else {
                prescriptions.remove(i);
            }
            i++;
        }
        return prescriptions.stream()
                .map((prescription) -> mapToPrescriptionDTO(prescription))
                .collect(Collectors.toList());
    }





    private PrescriptionDTO mapToPrescriptionDTO(Prescription prescription) {
        PrescriptionDTO prescriptionDTO = new PrescriptionDTO();

        prescriptionDTO.setDoctorName(prescription.getDoctorName());
        prescriptionDTO.setTitle(prescription.getTitle());
        prescriptionDTO.setMedication(prescription.getMedication());
        prescriptionDTO.setPatientName(prescription.getPatientName());
        prescriptionDTO.setDosage(prescription.getDosage());
        prescriptionDTO.setCreatedAt(LocalDate.now());
        prescriptionDTO.setExpiredAt(LocalDate.now().plusDays(30));

        return prescriptionDTO;
    }




}