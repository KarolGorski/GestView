package controllers;

import app.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;

import java.io.File;

public class MainMenuController {

    @FXML
    Button pickPathButton;
    @FXML
    TextField pickedPathTextField;

    public void pickPathButtonAction(){
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Images directory");
        File defaultDirectory = new File("./");
        chooser.setInitialDirectory(defaultDirectory);
        File selectedDirectory = chooser.showDialog(Main.stage);
        System.out.println("STH WORKS?");

        pickedPathTextField.setText(selectedDirectory.getAbsolutePath());
    }

}
