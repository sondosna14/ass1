package com.example.helloworld.Model;

import androidx.appcompat.app.AppCompatActivity;

public class userinfo extends AppCompatActivity {
    private String username ;
    private String email;
    private String password;
    private String conpassword;



    public userinfo(String username, String email, String password, String conpassword) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.conpassword = conpassword;


    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConpassword() {
        return conpassword;
    }

    public void setConpassword(String conpassword) {
        this.conpassword = conpassword;
    }
}

