import application.Keys;
import controllers.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    public static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
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


    public static void main(String[] args) {
        launch(args);
    }
}


//Photo by Tirachard Kumtanom from Pexels