package com.company;

import java.util.Date;

public class Admission extends Record{
    private Date discharge;

    public Admission(Doctor doctor, Date discharge) {
        super(doctor);
        this.discharge = discharge;
    }

    public Date getDischarge() {
        return discharge;
    }
}
