package app;

import controllers.LoginController;
import displayKeys.Keys;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.data.filesComposite.Component;
import model.data.serialization.Deserializer;

import java.util.ArrayList;
import java.util.List;



public class Main extends Application {

    public static String serializationPath ="serializedData";
    public static Stage stage;
    public static Deserializer deserializer;
    public static List<Component> dataList = deserializer.deserializeAndGetContent(serializationPath);

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(LoginController.class.getResource(Keys.Views.LOGIN_VIEW));
        AnchorPane pane = loader.load();
        Scene scene = new Scene(pane);
        stage = primaryStage;
        //ustawiamy dodatkowe parametry
        stage.initStyle(StageStyle.DECORATED);
        stage.setTitle("Example 1");
        scene.getStylesheets().addAll(LoginController.class.getResource(Keys.Style.STYLE).toExternalForm());
        stage.setScene(scene);

        //wyswietlamy scene
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}


//Photo by Tirachard Kumtanom from Pexels