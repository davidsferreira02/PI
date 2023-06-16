package com.example.demo.repository;

import com.example.demo.model.Prescription;
import com.example.demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

    Prescription findAllPrescriptionByPacient(int id);
    Prescription findAllPrescriptionByDoctor(int id);


}
