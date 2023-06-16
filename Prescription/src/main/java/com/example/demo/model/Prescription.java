package com.example.demo.model;

import jakarta.persistence.*;

import java.util.Date;

public class Prescription {




    private String medication;


    private String doctor;


    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getPacient() {
        return pacient;
    }

    public void setPacient(String pacient) {
        this.pacient = pacient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private String pacient;


    private Date date;
}
