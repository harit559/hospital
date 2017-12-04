package com.company;

import java.util.Date;

public class Record {
    protected Doctor doctor;
    protected Date date;

    public Record(Doctor doctor) {
        this.doctor = doctor;
        date = new Date();
    }
}
