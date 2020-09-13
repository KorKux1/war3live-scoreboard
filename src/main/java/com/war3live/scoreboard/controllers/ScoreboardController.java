package com.war3live.scoreboard.controllers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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

    /**
     * Increase the Score of the player 1.
     * @param event: On action event.
     */
    @FXML
    public void increasePlayer1Score(ActionEvent event) {
        try {
            int score = Integer.parseInt(fieldPlayer1Score.getText());
            fieldPlayer1Score.setText(""+(score+1));
        }
        catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error Message");
            alert.setHeaderText("An error has occurred!");
            alert.setContentText("Please enter a valid number.");
        }

    }

    /**
     * Increase the score of the player 2.
     * @param event: On action event.
     */
    @FXML
    public void increasePlayer2Score(ActionEvent event) {
        int score = Integer.parseInt(fieldPlayer2Score.getText());
        fieldPlayer2Score.setText(""+(score+1));
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

    /**
     * Reset Players nicknames.
     * @param event: On action Event.
     */
    @FXML
    public void resetPlayers(ActionEvent event) {
        fieldPlayer1Nickname.setText("");
        fieldPlayer2Nickname.setText("");
    }

    /**
     * Reset score of the players.
     * @param event: On action Event.
     */
    @FXML
    public void resetScore(ActionEvent event) {
        fieldPlayer1Score.setText("0");
        fieldPlayer2Score.setText("0");
    }

    /**
     * Switch information of the users.
     * @param event: On action Event.
     */
    @FXML
    public void switchPlayers(ActionEvent event) {
        var player1Score = fieldPlayer1Score.getText();
        var player1Nick = fieldPlayer1Nickname.getText();

        fieldPlayer1Nickname.setText(fieldPlayer2Nickname.getText());
        fieldPlayer1Score.setText(fieldPlayer2Score.getText());

        fieldPlayer2Nickname.setText(player1Nick);
        fieldPlayer2Score.setText(player1Score);
    }

    /**
     * File generator for players information.
     * @param fileName: Name of the File. Ej: Player1.txt
     * @param value: Value into the File. Ej: KorKux
     */
    public void generateFile(String fileName, String value) {
        try {
            File file = new File(fileName);
            FileWriter filewriter = new FileWriter(file);
            filewriter.write(value);
            filewriter.close();

        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText("An error has occurred!");
            alert.setContentText("An error has occurred generating the files.\n" +
                                "Please retry.");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
