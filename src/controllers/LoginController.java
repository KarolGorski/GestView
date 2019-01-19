package controllers;


import app.Keys;
import app.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

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
//            app.Main.stage.setScene(scene);
//        }catch(Exception e){}

        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("JavaFX Projects");
        File defaultDirectory = new File("c:/");
        chooser.setInitialDirectory(defaultDirectory);
        File selectedDirectory = chooser.showDialog();
    }*/

    public void login()
    {
               // AppRunner.getInstance().setScene(app.Keys.Views.MAIN_MENU);
        FXMLLoader loader = new FXMLLoader(LoginController.class.getResource(Keys.Views.MAIN_MENU));
        try{
            AnchorPane pane = loader.load();
            Scene scene = new Scene(pane);
            scene.getStylesheets().addAll(LoginController.class.getResource(Keys.Style.STYLE).toExternalForm());
            Main.stage.setScene(scene);
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}
