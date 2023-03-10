package com.example.Prescription.Repository;



import com.example.Prescription.Schema.Schema;
import com.example.Prescription.model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepository extends JpaRepository<Schema, Long>  {


}
