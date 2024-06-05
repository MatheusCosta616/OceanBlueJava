package com.global.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

public class AssinaturaModel {
    private int assinaturaId;
    private String tipoDeAssinatura;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    Random random = new Random();

    public AssinaturaModel(String tipoDeAssinatura) {
        this.assinaturaId = random.nextInt(1000);
        this.tipoDeAssinatura = tipoDeAssinatura;
        this.dataInicio = LocalDate.now();
        this.dataFim = dataInicio.plusYears(1);
    }


    public int getAssinaturaId() {
        return assinaturaId;
    }

    public void setAssinaturaId(int assinaturaId) {
        this.assinaturaId = assinaturaId;
    }

    public String getTipoDeAssinatura() {
        return tipoDeAssinatura;
    }

    public void setTipoDeAssinatura(String tipoDeAssinatura) {
        this.tipoDeAssinatura = tipoDeAssinatura;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }
}
