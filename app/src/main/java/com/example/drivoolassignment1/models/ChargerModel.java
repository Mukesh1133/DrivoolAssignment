package com.example.drivoolassignment1.models;

import android.os.Parcelable;

import java.io.Serializable;

public class ChargerModel implements Serializable {
    String name;
    String typeOfCharger;
    String availability;

    public ChargerModel(String name, String typeOfCharger, String availability) {
        this.name = name;
        this.typeOfCharger = typeOfCharger;
        this.availability = availability;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeOfCharger() {
        return typeOfCharger;
    }

    public void setTypeOfCharger(String typeOfCharger) {
        this.typeOfCharger = typeOfCharger;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

}
