package com.hackoverflow.signinanddatabase.signinanddatabase;

public class User {
    public String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    User(String username){
        this.setUsername(username);
    }
}
