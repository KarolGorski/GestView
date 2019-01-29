package controllers;

import app.Main;
import com.jfoenix.controls.JFXTextField;
import com.sun.rowset.internal.Row;
import displayKeys.Keys;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import model.data.PathParser;
import model.data.Tag;
import model.data.filesComposite.Component;
import model.data.filesComposite.CompositeStructureRoot;
import model.data.filesComposite.Directory;
import model.timer.TimeCounter;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.io.File;
import java.util.ArrayList;

public class MainMenuController {

    @FXML
    TilePane imagesDisplayTilePane;
    @FXML
    TableView<Component> pathsTable;
    @FXML
    TableColumn<Component, String> nameColumn;
    @FXML
    TableColumn<Component, String> pathColumn;
    @FXML
    JFXTextField timeField;
    @FXML
    JFXTextField numberOfPhotosField;

    Component observedValue;

    CompositeStructureRoot observableCompositeRoot;
    ObservableList<Component> observableList;

    private static final int colN = 3;
    private double elementSize;
    private static final int gapSize = 10;

    public void initData(){
        this.observableCompositeRoot = Main.dataRoot;
        observableList = observableCompositeRoot.getObservableList();
        pathsTable.setItems(observableList);
        nameColumn.setCellValueFactory( new PropertyValueFactory("name"));
        pathColumn.setCellValueFactory(new PropertyValueFactory("path"));

        pathsTable.getSelectionModel().selectedItemProperty().addListener(
                ((observable, oldValue, newValue) -> displayImagesFromAddedDirectory(newValue))
        );
        pathsTable.getSelectionModel().selectedItemProperty().addListener(
                ((observable, oldValue, newValue) ->  observedValue= newValue)
        );

    }


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
        Component dir = PathParser.parse(path,new ArrayList<String>());
        Main.dataRoot.addToList(dir);
        pathsTable.setItems(observableCompositeRoot.getObservableList());

    }

    private void displayImagesFromAddedDirectory(Component dir){

        elementSize = 200;
        imagesDisplayTilePane.setPrefColumns(3);
        imagesDisplayTilePane.setHgap(gapSize);
        imagesDisplayTilePane.setVgap(gapSize);

        imagesDisplayTilePane.getChildren().clear();
        ImageView imageView;

        try {
            for (Component c : ((Directory) dir).getListOfComponents()) {
                imageView = new ImageView(new Image(
                        new File(c.getPath()).toURI().toString()));
                imagesDisplayTilePane.getChildren().add(createVBoxWithImage(imageView));
            }
        }catch (NullPointerException e){

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

        observableCompositeRoot.removeFromList(observedValue);
        observableList = observableCompositeRoot.getObservableList();
        pathsTable.setItems(observableList);
    }

    public void startDrawingButtonAction(){
        if(observableList.size()==0){
            showAlert("You don't have anything in your directories...");
            return;
        }

        FXMLLoader loader = new FXMLLoader(LoginController.class.getResource(Keys.Views.DRAW_VIEW));
        try{
            AnchorPane pane = loader.load();
            Scene scene = new Scene(pane);
            DrawViewController controller = loader.<DrawViewController>getController();

            ArrayList<Component> arrayList = new ArrayList<Component>();
            for(Component c : observableList)
            {
                arrayList.addAll(((Directory)c).getListOfComponents());
            }


            controller.init(arrayList, new TimeCounter(controller,
                    Integer.parseInt(timeField.getText()),
                    Integer.parseInt(numberOfPhotosField.getText())));

            scene.getStylesheets().addAll(LoginController.class.getResource(Keys.Style.STYLE).toExternalForm());
            Main.stage.setScene(scene);
            Main.stage.setFullScreen(true);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void showAlert(String warning){
        Alert alert = new Alert(Alert.AlertType.WARNING, warning, ButtonType.OK);
        alert.showAndWait();
    }




}
