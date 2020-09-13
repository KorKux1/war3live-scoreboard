package com.war3live.scoreboard.controllers;

import java.io.IOException;

import com.war3live.scoreboard.main.App;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}