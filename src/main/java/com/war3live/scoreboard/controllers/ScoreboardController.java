package com.war3live.scoreboard.controllers;

import com.war3live.scoreboard.model.AutocompletionlTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Scoreboard Controller
 * @author KorKux
 */
public class ScoreboardController implements Initializable {

    @FXML
    private TextField fieldFolderPath;

    @FXML
    private TextField fieldPlayer1Nickname;

    @FXML
    private TextField fieldPlayer1Score;

    @FXML
    private TextField fieldPlayer2Nickname;

    @FXML
    private TextField fieldPlayer2Score;


    @FXML
    private AutocompletionlTextField fieldMapName;

    @FXML
    private TextField fieldGameLabel;


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

    /**
     * Generate Files with the data
     * @param event: On action Event
     */
    @FXML
    public void generateFiles(ActionEvent event) {
        String path = fieldFolderPath.getText();
        if (path == null) {
            path = System.getProperty("user.dir");
        }

        generateFile(path+"/player1.txt", fieldPlayer1Nickname.getText());
        generateFile(path+"/player2.txt", fieldPlayer2Nickname.getText());
        generateFile(path+"/player1Score.txt", fieldPlayer1Score.getText());
        generateFile(path+"/player2Score.txt", fieldPlayer2Score.getText());
        generateFile(path+"/map.txt", fieldMapName.getText());
        generateFile(path+"/gameLabel.txt", fieldGameLabel.getText());

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
            showAlertMessageNumberFormatError();
        }
    }

    /**
     * Increase the score of the player 2.
     * @param event: On action event.
     */
    @FXML
    public void increasePlayer2Score(ActionEvent event) {
        try {
            int score = Integer.parseInt(fieldPlayer2Score.getText());
            fieldPlayer2Score.setText(""+(score+1));
        }
        catch (NumberFormatException e){
            showAlertMessageNumberFormatError();
        }
    }

    /**
     * Reduce the score of the player 1.
     * @param event: On action event.
     */
    @FXML
    public void reducePlayer1Score(ActionEvent event) {
        try {
            int score = Integer.parseInt(fieldPlayer1Score.getText());
            fieldPlayer1Score.setText(""+(score-1));
        }
        catch (NumberFormatException e) {
            showAlertMessageNumberFormatError();
        }
    }

    /**
     * Reduce the score of the player 2.
     * @param event: On action event.
     */
    @FXML
    public void reducePlayer2Score(ActionEvent event) {
        try {
            int score = Integer.parseInt(fieldPlayer2Score.getText());
            fieldPlayer2Score.setText(""+(score-1));
        } catch (NumberFormatException e) {
            showAlertMessageNumberFormatError();
        }
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

    /**
     * Show an alert for Formant Number Error.
     */
    public void showAlertMessageNumberFormatError(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Error Message");
        alert.setHeaderText("An error has occurred!");
        alert.setContentText("Please enter a valid number.");
    }

    /**
     * initialize main application with autocomplete
     * @param location:
     * @param resources:
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        String[] mapsArray =  {"Echo Isles","Melting Valley", "Road to Stratholme", "Secret Valley",
                "Terenas Stand", "Tirisfal Glades", "Broken Shard", "Centaur Grove","Lost Temple","Tidewater Glades",
                "Turtle Rock", "Twisted Meadows", "Goldshire", "Amazonia", "Concealed Hill" + "Last Refuge", "Northern Isles"
        };

        List<String> maps = new ArrayList<String>(Arrays.asList(mapsArray));

        fieldMapName.getEntries().addAll(maps);
    }
}
