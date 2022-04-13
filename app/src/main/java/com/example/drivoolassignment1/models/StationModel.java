package com.example.drivoolassignment1.models;

import java.io.Serializable;
import java.util.ArrayList;

public class StationModel implements Serializable {
    String stationName;
    String address;

    public ArrayList<ChargerModel> chargerModelList;

    public StationModel(String stationName, String address, ArrayList<ChargerModel> chargerModelList) {
        this.stationName = stationName;
        this.address = address;
        this.chargerModelList = chargerModelList;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<ChargerModel> getChargersList() {
        return chargerModelList;
    }

    public void setChargersList(ArrayList<ChargerModel> chargerModelList) {
        this.chargerModelList = chargerModelList;
    }
}
