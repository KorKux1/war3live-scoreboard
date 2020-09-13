package com.war3live.scoreboard.controllers;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;

/**
 * Scoreboard Controller
 * @author KorKux
 */
public class ScoreboardController {

    @FXML
    private AnchorPane root;

    @FXML
    private TextField fieldFolderPath;

    @FXML
    private Button btnFolderPath;

    @FXML
    private TextField fieldPlayer1Nickname;

    @FXML
    private TextField fieldPlayer1Score;

    @FXML
    private Button btnIncreasePlayer1Score;

    @FXML
    private Button btnReducePlayer1Score;

    @FXML
    private CheckBox checkAutoSave;

    @FXML
    private Button btnSwitchPlayers;

    @FXML
    private Button btnResetPlayers;

    @FXML
    private Button btnResetScore;

    @FXML
    private TextField fieldPlayer2Nickname;

    @FXML
    private TextField fieldPlayer2Score;

    @FXML
    private Button btnIncreasePlayer2Score;

    @FXML
    private Button btnReducePlayer2Score;

    @FXML
    private TextField fieldMapName;

    @FXML
    private TextField fieldGameLabel;

    @FXML
    private Button btnSave;

    /**
     * Returns the path of the selected directory and maps it to the directory field
     * @param event: onAction Event
     */
    @FXML
    public void chooseFolder(ActionEvent event) {
        try{
            DirectoryChooser directoryChooser = new DirectoryChooser();
            directoryChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
            File selectedFolder = directoryChooser.showDialog(null);
            fieldFolderPath.setText(selectedFolder.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void generateFiles(ActionEvent event) {

    }

    @FXML
    void increasePlayer1Score(ActionEvent event) {

    }

    @FXML
    void increasePlayer2Score(ActionEvent event) {

    }

    @FXML
    void mapSuggestion(KeyEvent event) {

    }

    @FXML
    void reducePlayer1Score(ActionEvent event) {

    }

    @FXML
    void reducePlayer2Score(ActionEvent event) {

    }

    @FXML
    void resetPlayers(ActionEvent event) {

    }

    @FXML
    void resetScore(ActionEvent event) {

    }

    @FXML
    void switchPlayers(ActionEvent event) {

    }






}
