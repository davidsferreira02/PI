package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;
@Entity
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String medication;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public int getDoctor() {
        return doctor;
    }

    public void setDoctor(int doctor) {
        this.doctor = doctor;
    }

    public int getPacient() {
        return pacient;
    }

    public void setPacient(int pacient) {
        this.pacient = pacient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private int doctor;
    private int pacient;
    private Date date;
}
