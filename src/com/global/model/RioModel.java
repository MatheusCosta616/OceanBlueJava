package com.global.model;

import java.util.Random;

public class RioModel {
    private int rioId;
    private String rioName;

    public int getRioId() {
        return rioId;
    }

    public void setRioId(int rioId) {
        this.rioId = rioId;
    }

    public String getRioName() {
        return rioName;
    }

    public void setRioName(String rioName) {
        this.rioName = rioName;
    }

    public RioModel(String rioName) {
        Random random = new Random();
        this.rioId = random.nextInt(1000);
        this.rioName = rioName;
    }
}
