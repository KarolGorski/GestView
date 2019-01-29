package app;

import controllers.LoginController;
import displayKeys.Keys;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.data.filesComposite.CompositeStructureRoot;
import model.data.serialization.DataSerialization;


public class Main extends Application {


    public static Stage stage;
    public static CompositeStructureRoot dataRoot;
    public static DataSerialization dataSerialization;

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(LoginController.class.getResource(Keys.Views.LOGIN_VIEW));
        AnchorPane pane = loader.load();
        Scene scene = new Scene(pane);
        stage = primaryStage;
        //ustawiamy dodatkowe parametry
        stage.initStyle(StageStyle.DECORATED);
        stage.setTitle("GestView");
        scene.getStylesheets().addAll(LoginController.class.getResource(Keys.Style.STYLE).toExternalForm());
        stage.setScene(scene);

        stage.setOnCloseRequest(event -> {
            //do all your processing here
            dataSerialization.saveContent(dataRoot);
        });

        //wyswietlamy scene
        stage.show();

    }


     public static void initData(){
        dataSerialization = new DataSerialization(Keys.Paths.SERIALIZED_DATA_PATH);;
        dataRoot = dataSerialization.getDataOrCreateNew();
     }


    public static void main(String[] args) {
        initData();
        launch(args);
    }
}


//Photo by Tirachard Kumtanom from Pexels