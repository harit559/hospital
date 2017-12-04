package com.company;

public class Prognosis extends Record {
    private String prognosis;
    public Prognosis(String prognosis, Doctor doctor) {
        super(doctor);
        this.prognosis = prognosis;
    }

    public String getPrognosis() {
        return prognosis;
    }
}