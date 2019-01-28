package controllers;

import app.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import model.data.PathParser;
import model.data.Tag;
import model.data.filesComposite.Component;
import model.data.filesComposite.Directory;

import java.io.File;
import java.util.ArrayList;

public class MainMenuController {

    @FXML
    TilePane imagesDisplayTilePane;
    @FXML
    TableView pathsTable;

    private static final int colN = 3;
    private double elementSize;
    private static final int gapSize = 10;

    private String directoryChoose(){
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Images directory");
        File defaultDirectory = new File("./");
        chooser.setInitialDirectory(defaultDirectory);
        File selectedDirectory = chooser.showDialog(Main.stage);
        System.out.println("STH WORKS? :3");

        return selectedDirectory==null?null:selectedDirectory.getAbsolutePath();
    }

    public void addPathButtonAction(){
        System.err.println("Tag list is not implemented yet!");
        String path = directoryChoose();
        if(path==null) return;
        Component dir =PathParser.parse(path,new ArrayList<String>());
        Main.dataRoot.addToList(dir);
        displayImagesFromAddedDirectory_Test(dir);
    }



    private void displayImagesFromAddedDirectory_Test(Component dir){

        elementSize = 200;
        imagesDisplayTilePane.setPrefColumns(3);
        imagesDisplayTilePane.setHgap(gapSize);
        imagesDisplayTilePane.setVgap(gapSize);

        imagesDisplayTilePane.getChildren().clear();
        ImageView imageView;

        for(Component c : ((Directory) dir).getListOfComponents()){
            imageView = new ImageView(new Image(
                    new File(c.getPath()).toURI().toString()));
            imagesDisplayTilePane.getChildren().add(createVBoxWithImage(imageView));
        }

    }


    private VBox createVBoxWithImage(ImageView imageView){
        imageView.setPreserveRatio(true);
//        imageView.setFitWidth(elementSize);
        if(imageView.getImage().getWidth()>imageView.getImage().getHeight())
            imageView.setFitWidth(elementSize);
        else
            imageView.setFitHeight(elementSize);


        VBox box = new VBox();
        box.getChildren().add(imageView);
        box.setStyle("-fx-border-color: white;");
        //box.setStyle("-fx-background-color: grey");
        box.setAlignment(Pos.CENTER);
        return box;
    }

    public void removePathButtonAction(){
        System.err.println("Removing from list is not implemented yet");
    }

}
