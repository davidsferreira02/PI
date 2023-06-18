package com.example.demo.service;


import com.example.demo.aca.dto.PrescriptionDTO;
import com.example.demo.aca.dto.UserDTO;
import com.example.demo.model.Prescription;
import com.example.demo.model.User;
import com.example.demo.repository.PrescriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {


    private  PrescriptionRepository prescriptionRepository;

    public PrescriptionServiceImpl(PrescriptionRepository prescriptionRepository){
        this.prescriptionRepository=prescriptionRepository;

    }

    @Override
    public void savePrescription(PrescriptionDTO prescriptionDTO) {
        Prescription prescription = new Prescription();
        prescription.setMedication(prescriptionDTO.getMedication());
        prescription.setTitle(prescriptionDTO.getTitle());
        prescription.setDoctorName(prescriptionDTO.getDoctorName());
        prescription.setPacientName(prescriptionDTO.getPatientName());
        prescription.setSubmissionDate(prescriptionDTO.getSubmissionDate());



        prescriptionRepository.save(prescription);
    }

    @Override
    public Prescription findByPacientName(String name) {
        return prescriptionRepository.findByPacientName(name);
    }

    @Override
    public List<PrescriptionDTO> findAllPrescription(String name) {
        List<Prescription> prescriptions = prescriptionRepository.findAll();
        int i=0;
        for(Prescription prescriptionDTO:prescriptions){

            if(prescriptionDTO.getPacientName().equals(name)){

            }
            else{
                prescriptions.remove(i);
            }
            i++;
        }
        return prescriptions.stream()
                .map((user) -> mapToUserDTO(user))
                .collect(Collectors.toList());
    }




    private PrescriptionDTO mapToUserDTO(Prescription prescription){
        PrescriptionDTO prescriptionDTO = new PrescriptionDTO();
        prescriptionDTO.setDoctorName(prescription.getDoctorName());
        prescriptionDTO.setTitle(prescription.getTitle());
        prescriptionDTO.setMedication(prescription.getMedication());
        prescriptionDTO.setPatientName(prescription.getPacientName());

        return prescriptionDTO;
    }


}