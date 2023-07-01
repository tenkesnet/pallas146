package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController2 {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Sziasztok!");
    }
}