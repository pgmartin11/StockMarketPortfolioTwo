package edu.uml.project90308.presentation;

import java.io.Serializable;

public class LoginBean implements Serializable {

    private String name = "No name specified.";

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
