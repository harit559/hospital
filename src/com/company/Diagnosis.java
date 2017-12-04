package com.company;

public class Diagnosis extends Record {
    private String diagnosis;
    public Diagnosis(String diagnosis, Doctor doctor) {
        super(doctor);
        this.diagnosis = diagnosis;
    }

    public String getDiagnosis() {
        return diagnosis;
    }
}
