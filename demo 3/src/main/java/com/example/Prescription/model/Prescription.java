package com.example.Prescription.model;

import jakarta.persistence.*;


@Table(name="prescription")


public class Prescription {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String doctorName;
    private String pacientName;
    private String medication;
    private int amount;


    protected Prescription() {}

    public Prescription(String doctorName,String pacientName, String medication,int amount) {
        this.doctorName=doctorName;
        this.pacientName=pacientName;
        this.medication=medication;
        this.amount=amount;
    }

    @Override
    public String toString() {
        return String.format(
                "Prescription[id=%d, doctorName='%s', pacientName='%s',medication='%d',amount='%d']",
                id, doctorName,pacientName,medication,amount);
    }


@Column(name="doctorName",nullable = false)
    public String getDoctorName(){
        return doctorName;
    }
    public void setDoctorName(String doctorName){
        this.doctorName=doctorName;

    }

    @Column(name="pacientName",nullable = false)
    public String getPacientName(){
        return pacientName;
    }
    public void setPacientName(String pacientName){
        this.pacientName=pacientName;

    }

    @Column(name="Me",nullable = false)
    public String getMedication(){
        return medication;
    }
    public void setMedication(String doctorName){
        this.medication=doctorName;

    }
    @Column(name="Amount",nullable = false)
    public int getAmount(){
        return amount;
    }
    public void setAmount(int amount){
        this.amount=amount;

    }

}
