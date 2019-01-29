package controllers;


import displayKeys.Keys;
import app.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class LoginController {

    public void login()
    {

        FXMLLoader loader = new FXMLLoader(LoginController.class.getResource(Keys.Views.MAIN_MENU));
        try{
            AnchorPane pane = loader.load();
            Scene scene = new Scene(pane);
            MainMenuController controller = loader.<MainMenuController>getController();
            controller.initData();
            scene.getStylesheets().addAll(LoginController.class.getResource(Keys.Style.STYLE).toExternalForm());
            Main.stage.setScene(scene);
            Main.stage.setFullScreen(true);
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}
