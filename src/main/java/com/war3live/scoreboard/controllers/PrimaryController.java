package com.war3live.scoreboard.controllers;

import java.io.IOException;

import com.war3live.scoreboard.main.App;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
