package application;

import controllers.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AppRunner extends Application {

    private static Stage stage;
    private static AppRunner instance = new AppRunner();

    private AppRunner(){}

    public static AppRunner getInstance(){
        return instance;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(LoginController.class.getResource(Keys.Views.LOGIN_VIEW));
        AnchorPane pane = loader.load();
        Scene scene = new Scene(pane);
        stage = primaryStage;
        //ustawiamy dodatkowe parametry
        stage.initStyle(StageStyle.DECORATED);
        stage.setTitle("Example 1");
        scene.getStylesheets().addAll(LoginController.class.getResource("style.css").toExternalForm());
        stage.setScene(scene);

        //wyswietlamy scene
        stage.show();
    }

    public boolean setScene(String viewName){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource(viewName));
            AnchorPane sceneMain = loader.load();
            Scene scene = new Scene(sceneMain);
            //CalcController controller = loader.<CalcController>getController();
            this.stage.setScene(scene);
        }
        catch(Exception e){
            return false;
        }
        return true;
    }

    public Stage getStage(){
        return stage;
    }
}
