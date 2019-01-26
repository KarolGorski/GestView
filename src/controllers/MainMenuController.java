package controllers;

import app.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import model.data.PathParser;
import model.data.Tag;

import java.io.File;
import java.util.ArrayList;

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

    public void addPathButtonAction(){
        System.err.println("Tag list is not implemented yet!");
        Main.dataRoot.addToList(PathParser.parse(pickedPathTextField.getText(),new ArrayList<Tag>()));
    }

}
