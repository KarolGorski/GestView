package controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.TilePane;
import model.data.filesComposite.Component;
import model.timer.TimeCounter;

public class DrawViewController {

    @FXML
    TilePane RefPhotoTilePane;

    TimeCounter timeCounter;

    public DrawViewController(TimeCounter timeCounter) {
        this.timeCounter = new TimeCounter(this, 2);
        System.err.println("Seconds setting is not implemented");
    }

    public void renderSthPlease(Component img){

    }
}
