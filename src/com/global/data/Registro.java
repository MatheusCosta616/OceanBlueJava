package com.global.data;

import com.global.model.SensorModel;

import java.util.Random;

public class Registro extends SensorModel {
    private int registerId;
    Random random = new Random();

    public int getRegisterId() {
        return registerId;
    }

    public void setRegisterId(int registerId) {
        this.registerId = registerId;
    }

    public Registro(String rioName, String sensorModelo, String sensorStatus, Float sensorLatitude, Float sensorLongitude,
                    float phLevel, float dissolvedOxygenLevel, float turbidityLevel) {
        super(rioName, sensorModelo, sensorStatus, sensorLatitude, sensorLongitude, phLevel, dissolvedOxygenLevel, turbidityLevel);
        this.registerId = random.nextInt(1000);
    }
}
