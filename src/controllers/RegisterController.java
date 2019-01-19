package controllers;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import models.database.User;
import models.database.UserDatabase;


public class RegisterController {

    UserDatabase db;
    @FXML
    JFXTextField rLoginInput;
    @FXML
    JFXPasswordField rPasswordInput;
    @FXML
    JFXTextField rNameInput;
    @FXML
    JFXTextField rSurnameInput;
    @FXML
    Label rLabel;

    public void initDb(UserDatabase db){
        this.db = db;
    }

    public void register()
    {

        String login = rLoginInput.getText();
        String pswd = rPasswordInput.getText();
        String name = rNameInput.getText();
        String surname = rNameInput.getText();
        if(login.isEmpty() || pswd.isEmpty() || name.isEmpty() || surname.isEmpty())
            rLabel.setText("Incomplete input");
        else{
            if(!db.CheckUser(login,pswd)) {
                db.addUser(new User(name, surname, login, pswd));
                try {
                    FXMLLoader loader = new FXMLLoader(
                            getClass().getResource(
                                    "loginView.fxml"));
                    AnchorPane sceneMain = loader.load();

                    LoginController controller = loader.<LoginController>getController();
                    //controller.initDb(db);

                    Scene scene = new Scene(sceneMain);

                    //Main.stage.setScene(scene);

                } catch (Exception e) {
                }
            }
            else rLabel.setText("User already exists in db");
        }


    }
}
