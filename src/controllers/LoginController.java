package controllers;

import application.Keys;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import application.AppRunner;

import java.io.File;


public class LoginController {
/*

    UserDatabase db=new UserDatabase();
    @FXML
    JFXTextField loginInput;
    @FXML
    JFXPasswordField passwordInput;

        public void initDb(UserDatabase db){
        this.db = db;
    }
*/
/*    public void goToRegisterView(){
//        try{
//            FXMLLoader loader = new FXMLLoader(
//                    getClass().getResource(
//                            "registerView.fxml"));
//            AnchorPane sceneMain = loader.load();
//            Scene scene = new Scene(sceneMain);
//
//            RegisterController controller = loader.<RegisterController>getController();
//            controller.initDb(db);
//
//            Main.stage.setScene(scene);
//        }catch(Exception e){}

        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("JavaFX Projects");
        File defaultDirectory = new File("c:/");
        chooser.setInitialDirectory(defaultDirectory);
        File selectedDirectory = chooser.showDialog();
    }*/

    public void login()
    {
                AppRunner.getInstance().setScene(Keys.Views.MAIN_MENU);
    }
}
