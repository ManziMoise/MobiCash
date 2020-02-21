package com.example.mobicash;

public class UserModel {

    public int id;
    public String names, passwords;

    public UserModel(int id, String names, String passwords) {
        this.id = id;
        this.names = names;
        this.passwords = passwords;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }
}
