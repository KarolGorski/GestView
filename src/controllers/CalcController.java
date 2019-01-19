package controllers;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import models.database.User;
import models.math.mathOperations;


public class CalcController {

    @FXML
    JFXTextField valueA;
    @FXML
    JFXTextField valueB;
    @FXML
    Label outputLabel;
    @FXML
    Label helloLabel;

    mathOperations mathModel=new mathOperations();

    public void initData(User user){
        helloLabel.setText("Hello "+
                user.getName()+
                " "+
                user.getSurname());
    }
    public void additionButtonAction(){
        outputLabel.setText(
                mathModel.addition(
                        Double.parseDouble(valueA.getText()),
                        Double.parseDouble(valueB.getText()))
                        .toString());
    }
    public void substractionButtonAction(){
        outputLabel.setText(
                mathModel.substraction(
                        Double.parseDouble(valueA.getText()),
                        Double.parseDouble(valueB.getText()))
                        .toString());
    }
    public void multiplicationButtonAction(){
        outputLabel.setText(
                mathModel.multiplication(
                        Double.parseDouble(valueA.getText()),
                        Double.parseDouble(valueB.getText()))
                        .toString());
    }
    public void divisionButtonAction(){
        outputLabel.setText(
                mathModel.division(
                        Double.parseDouble(valueA.getText()),
                        Double.parseDouble(valueB.getText()))
                        .toString());
    }
    public void minButtonAction(){
        outputLabel.setText(
                mathModel.min(
                        Double.parseDouble(valueA.getText()),
                        Double.parseDouble(valueB.getText()))
                        .toString());
    }
    public void maxButtonAction(){
        outputLabel.setText(
                mathModel.max(
                        Double.parseDouble(valueA.getText()),
                        Double.parseDouble(valueB.getText()))
                        .toString());
    }

}