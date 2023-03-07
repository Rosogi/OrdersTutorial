package com.rosogisoft.loginverification.models;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LoginModel {
    @NotNull(message = "Username is required!")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20")
    private String username;
    @NotNull(message = "Password is required!")
    @Size(min = 8, max = 20, message = "Password must be between 8 and 20")
    private String password;

    public LoginModel() {
    }

    public LoginModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "loginModel{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
