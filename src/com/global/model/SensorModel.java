package com.global.model;

import java.util.Random;

/*
    Classe SensorModel
    Esta classe representa um modelo genérico de sensor. Ela contém propriedades comuns a muitos sensores, como identificação, modelo e status.

    Nesta versão, adicionamos propriedades para simular dados que podem ser usados na detecção de poluição da água, como nível de pH, nível de oxigênio dissolvido e turbidez.
*/

public class SensorModel extends RioModel {
    private int sensorId;
    private String sensorModelo;
    private String sensorStatus;
    private Float sensorLatitude;
    private Float sensorLongitude;
    private float phLevel;
    private float dissolvedOxygenLevel;
    private float turbidityLevel;

    public SensorModel(String rioName, String sensorModelo, String sensorStatus, Float sensorLatitude, Float sensorLongitude,
                       float phLevel, float dissolvedOxygenLevel, float turbidityLevel) {
        super(rioName);
        Random random = new Random();
        this.sensorId = random.nextInt(1000);
        this.sensorModelo = sensorModelo;
        this.sensorStatus = sensorStatus;
        this.sensorLatitude = sensorLatitude;
        this.sensorLongitude = sensorLongitude;
        this.phLevel = phLevel;
        this.dissolvedOxygenLevel = dissolvedOxygenLevel;
        this.turbidityLevel = turbidityLevel;
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

    public float getPhLevel() {
        return phLevel;
    }

    public void setPhLevel(float phLevel) {
        this.phLevel = phLevel;
    }

    public float getDissolvedOxygenLevel() {
        return dissolvedOxygenLevel;
    }

    public void setDissolvedOxygenLevel(float dissolvedOxygenLevel) {
        this.dissolvedOxygenLevel = dissolvedOxygenLevel;
    }

    public float getTurbidityLevel() {
        return turbidityLevel;
    }

    public void setTurbidityLevel(float turbidityLevel) {
        this.turbidityLevel = turbidityLevel;
    }
}
