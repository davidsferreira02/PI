package com.example.Prescription.service;

import com.example.Prescription.Repository.PrescriptionRepository;
import com.example.Prescription.Schema.Schema;
import com.example.Prescription.aca.Aca_helper;
import com.example.Prescription.dto.PrescriptionDTO;
import com.example.Prescription.dto.SchemaDTO;
import com.example.Prescription.exception.NotfoundException;
import com.example.Prescription.model.Prescription;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    PrescriptionRepository prescriptionRepository;
    Aca_helper aca_helper;


    public Prescription create(PrescriptionDTO prescriptionDTO){
        Prescription Prescription=new Prescription(prescriptionDTO.getDoctorName(), prescriptionDTO.getPacientName(),prescriptionDTO.getMedication(),prescriptionDTO.getAmount());
        return prescriptionRepository.save(Prescription);
    }

    public Schema createSchema(SchemaDTO schemaDTO){
        Schema schema=new Schema(schemaDTO.getSchema_name(),schemaDTO.getAttributes(),schemaDTO.getSchema_version());
        return prescriptionRepository.save(schema);

    }

    public void delete(Long id){

        Prescription Prescription = prescriptionRepository.findById(id).orElseThrow(() -> new NotfoundException("Prescription with id " + id + " not found"));
        prescriptionRepository.delete(Prescription);
    }

    public void deleteSchema(Long id){

        Schema schema = prescriptionRepository.findById(id).orElseThrow(() -> new NotfoundException("Prescription with id " + id + " not found"));
        prescriptionRepository.delete(schema);
    }



    public Prescription update(Long id,PrescriptionDTO prescriptionDTO) {
        Prescription Prescription = prescriptionRepository.findById(id).orElseThrow(() -> new NotfoundException("Prescription with id " + id + " not found"));
        Prescription.setDoctorName(prescriptionDTO.getDoctorName());
        Prescription.setPacientName(prescriptionDTO.getPacientName());
        Prescription.setMedication(prescriptionDTO.getMedication());
        Prescription.setAmount(prescriptionDTO.getAmount());
        return prescriptionRepository.save(Prescription);
    }

    public Schema updateSchema(Long id,SchemaDTO schemaDTO) {
        Schema schema = prescriptionRepository.findById(id).orElseThrow(() -> new NotfoundException("Schema with id " + id + " not found"));
        schema.setSchema_name(schemaDTO.getSchema_name());
        schema.setAttributes(schemaDTO.getAttributes());
        schema.setSchema_version(schemaDTO.getSchema_version());
        return prescriptionRepository.save(schema);
    }

    public Iterable<Prescription> allPrescriptions(){
        return prescriptionRepository.findAll();
    }

    public Iterable<Prescription> allSchemas(){
        return prescriptionRepository.findAll();
    }
}
}