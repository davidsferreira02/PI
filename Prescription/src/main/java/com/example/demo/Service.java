package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    PrescriptionRepository prescriptionRepository;


    public  Prescription create(PrescriptionDTO PrescriptionDTO){
        Prescription Prescription=new Prescription(PrescriptionDTO.getDoctorName(), PrescriptionDTO.getPacientName(),PrescriptionDTO.getMedication(),PrescriptionDTO.getAmount());
        return prescriptionRepository.save(Prescription);
    }

    public void delete(Long id){

        Prescription Prescription = prescriptionRepository.findById(id).orElseThrow(() -> new NotfoundException("Prescription with id " + id + " not found"));
        prescriptionRepository.delete(Prescription);
    }




    public Prescription update(Long id,PrescriptionDTO PrescriptionDTO) {
        Prescription Prescription = prescriptionRepository.findById(id).orElseThrow(() -> new NotfoundException("Prescription with id " + id + " not found"));
        Prescription.setDoctorName(PrescriptionDTO.getDoctorName());
        Prescription.setPacientName(PrescriptionDTO.getPacientName());
        Prescription.setMedication(PrescriptionDTO.getMedication());
        Prescription.setAmount(PrescriptionDTO.getAmount());
        return prescriptionRepository.save(Prescription);
    }

    public Iterable<Prescription> allPrescriptions(){
        return prescriptionRepository.findAll();
    }
}
