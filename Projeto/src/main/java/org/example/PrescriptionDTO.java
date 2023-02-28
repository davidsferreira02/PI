package org.example;

public class PrescriptionDTO {




        private String doctorName;
        private String pacientName;

        private int amount;
        private String medication;

        public PrescriptionDTO() {

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
        return medication;
    }
    public void setMedication(String medication){
        this.medication=medication;

    }
    public int getAmount(){
        return amount;
    }
    public void setAmount(int amount){
        this.amount=amount;

    }
    }
