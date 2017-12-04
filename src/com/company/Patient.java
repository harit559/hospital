package com.company;

import java.util.ArrayList;
import java.util.Iterator;

public class Patient {
    private int hn;
    private String name;
    private String surname;
    private int day;
    private int month;
    private int year;
    private double height;
    private double weight;
    private String bloodType;
    private ArrayList<Record> records;

    private static int count = 0;

        count++;
        hn = count;
    public Patient(String name, String surname, int day, int month, int year, int height, double weight, String bloodType) {
        this.name = name;
        this.surname = surname;
        this.day = day;
        this.month = month;
        this.year = year;
        this.height = height;
        this.weight = weight;
        this.bloodType = bloodType;
    }

    public boolean addRecord(Record record) {
        return records.add(record);
    }

    public int getHn() {return hn;}

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public String getBloodType() {
        return bloodType;
    }

    public boolean updateName(String name) {
        this.name = name;
        return true;
    }

    public boolean updateSurname(String surname) {
        this.surname = surname;
        return true;
    }

    public boolean updateHeight(int height) {
        this.height = height;
        return true;
    }

    public boolean updateWeight(double weight) {
        this.weight = weight;
        return true;
    }

    public static Patient findPatient(ArrayList<Patient> patients, String hos_num) {
        Iterator patientIterator = patients.iterator();
        Patient ret = null;
        while(patientIterator.hasNext()) {
            Patient each = (Patient) patientIterator.next();
            if (Integer.parseInt(hos_num) == each.getHn()) {
                ret = each;
            }
        }

        return ret;
    }
}
