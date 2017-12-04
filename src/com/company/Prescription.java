package com.company;

import java.util.ArrayList;

public class Prescription extends Record{

    private ArrayList<String> medicine = new ArrayList<String>();

    public Prescription(Doctor doctor, ArrayList<String> medicine) {
        super(doctor);
        this.medicine = medicine;
    }

    public ArrayList<String> getMedicine() {
        return medicine;
    }
}
