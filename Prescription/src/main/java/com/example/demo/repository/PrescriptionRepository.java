package com.example.demo.repository;

import com.example.demo.model.Prescription;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

    Prescription findByPacientName(String name);
}
