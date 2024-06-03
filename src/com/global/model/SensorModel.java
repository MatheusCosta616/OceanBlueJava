package com.global.model;

import java.util.Random;

public class SensorModel extends RioModel {
    private int sensorId;
    private String sensorModelo;
    private String sensorStatus;
    private Float sensorLatitude;
    private Float sensorLongitude;

    public SensorModel(String rioName, String sensorModelo, String sensorStatus, Float sensorLatitude, Float sensorLongitude) {
        super(rioName);
        Random random = new Random();
        this.sensorId = random.nextInt(1000);
        this.sensorModelo = sensorModelo;
        this.sensorStatus = sensorStatus;
        this.sensorLatitude = sensorLatitude;
        this.sensorLongitude = sensorLongitude;
    }

    public int getSensorId() {
        return sensorId;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }

    public String getSensorModelo() {
        return sensorModelo;
    }

    public void setSensorModelo(String sensorModelo) {
        this.sensorModelo = sensorModelo;
    }

    public String getSensorStatus() {
        return sensorStatus;
    }

    public void setSensorStatus(String sensorStatus) {
        this.sensorStatus = sensorStatus;
    }

    public Float getSensorLatitude() {
        return sensorLatitude;
    }

    public void setSensorLatitude(Float sensorLatitude) {
        this.sensorLatitude = sensorLatitude;
    }

    public Float getSensorLongitude() {
        return sensorLongitude;
    }

    public void setSensorLongitude(Float sensorLongitude) {
        this.sensorLongitude = sensorLongitude;
    }
}
