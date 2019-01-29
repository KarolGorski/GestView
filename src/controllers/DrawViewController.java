package controllers;

import app.Main;
import displayKeys.Keys;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import model.data.filesComposite.Component;
import model.timer.TimeCounter;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class DrawViewController {

  //  @FXML
   // TilePane RefPhotoTilePane;
    @FXML
    Label timeLeftLabel;
    @FXML
    ImageView imageViewToFill;
    Image image;

    TimeCounter timeCounter;
    ArrayList<Component> imgArray;

    int currentIndex;

    public void init(ArrayList<Component> imgArray, TimeCounter timeCounter){
        Collections.shuffle(imgArray);
        this.imgArray=imgArray;
        this.timeCounter = timeCounter;
        this.currentIndex = 0;
        startClass();
    }

    public void startClass(){
        image = new Image(
                new File(imgArray.get(currentIndex).getPath()).toURI().toString());
        imageViewToFill.setImage(image);
        imageViewToFill.preserveRatioProperty();
        imageViewToFill.setFitHeight(imageViewToFill.getFitHeight());

        currentIndex++;
    }

    public void changeTimeLabel(String value){
        timeLeftLabel.setText(value);
    }


    public void changeImage(int val){
        currentIndex+=val;
        if(currentIndex<0)
            currentIndex = imgArray.size()-1;
        else if(currentIndex>=imgArray.size())
            currentIndex = 0;

        image = new Image(
                new File(imgArray.get(currentIndex).getPath()).toURI().toString());
        imageViewToFill.setImage(image);
        imageViewToFill.preserveRatioProperty();
        imageViewToFill.setFitHeight(imageViewToFill.getFitHeight());

        currentIndex++;
    }

    public void finishClass(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Good Job! You did what you wanted. \n But maybe, you want to continue?", ButtonType.YES, ButtonType.NO);
        alert.showAndWait();

        if(alert.getResult() == ButtonType.NO)
            getToTheMain();
    }

    public void getToTheMain(){
        //Main.stage.setMaximized(false);
        //Main.stage.setAlwaysOnTop(false);
        FXMLLoader loader = new FXMLLoader(LoginController.class.getResource(Keys.Views.MAIN_MENU));
        try{
            AnchorPane pane = loader.load();
            Scene scene = new Scene(pane);
            MainMenuController controller = loader.<MainMenuController>getController();
            controller.initData();
            scene.getStylesheets().addAll(LoginController.class.getResource(Keys.Style.STYLE).toExternalForm());
            Main.stage.setScene(scene);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }





}
