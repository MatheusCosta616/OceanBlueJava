package com.global.model;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class UserModel {

    private int userId;
    private String userName;
    private String userEmail;
    private int userPassword;
    private LocalDate userDate;
    private AssinaturaModel assinatura;

    Random random = new Random();

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userNome) {
        this.userName = userNome;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(int userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserDate(LocalDate userDate) {
        this.userDate = userDate;
    }

    public AssinaturaModel getAssinatura() {
        return assinatura;
    }

    public void setAssinatura(AssinaturaModel assinatura) {
        this.assinatura = assinatura;
    }

    public String getUserDateAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return userDate.format(formatter);
    }

    public UserModel(String userNome, String userEmail, int userPassword, AssinaturaModel assinatura) {
        this.userId = random.nextInt(1000);
        this.userName = userNome;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userDate = LocalDate.now();
        this.assinatura = assinatura;
    }
}
