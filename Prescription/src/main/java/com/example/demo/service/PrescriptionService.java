package com.example.demo.service;

import com.example.demo.model.Prescription;
import com.example.demo.repository.PrescriptionRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PrescriptionService {


    private final PrescriptionRepository prescriptionRepository;

    @Autowired
    public PrescriptionService(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }

    public void CreatePrescription(String medication, String doctor, String pacient, Date date){
        Prescription prescription=new Prescription();
        prescription.setDate(date);
        prescription.setDoctor(doctor);
        prescription.setPacient(pacient);
        prescription.setDoctor(doctor);
        prescription.setMedication(medication);
        prescriptionRepository.save(prescription);

    }


}
