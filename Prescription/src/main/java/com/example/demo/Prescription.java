

package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
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



 public String getDoctorName(){
        return doctorName;
 }
 public void setDoctorName(String doctorName){
        this.doctorName=doctorName;

 }
    public String getPacientName(){
        return pacientName;
    }
    public void setPacientName(String pacientName){
        this.pacientName=pacientName;

    }
    public String getMedication(){
        return doctorName;
    }
    public void setMedication(String doctorName){
        this.doctorName=doctorName;

    }
    public int getAmount(){
        return amount;
    }
    public void setAmount(int amount){
        this.amount=amount;

    }

}
