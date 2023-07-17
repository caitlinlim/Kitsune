package com.example.kitsune;

public class Trainer {
    private String name;
    private String location;
    private int profileImageResId;

    public Trainer(String name, String location, int profileImageResId) {
        this.name = name;
        this.location = location;
        this.profileImageResId = profileImageResId;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getProfileImageResId() {
        return profileImageResId;
    }
}

