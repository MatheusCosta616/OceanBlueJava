package com.global.data;

import com.global.model.SensorModel;

public class Registro extends SensorModel {
    public Registro( String rioName, String sensorModelo, String sensorStatus, Float sensorLatitude, Float sensorLongitude) {
        super(rioName, sensorModelo, sensorStatus, sensorLatitude, sensorLongitude);
    }

    public static void main(String[] args) {
        Registro registro = new Registro("Amazonas", "Modelo 1", "SCANEANDO", 232323.323232F, 32323.323232F);
        System.out.println(registro.getRioId());
    }
}
