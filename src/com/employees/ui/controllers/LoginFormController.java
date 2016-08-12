/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.employees.ui.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author salim
 */
public class LoginFormController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    Button btnlogin;
    @FXML
    TitledPane panelogin;
    @FXML
    TitledPane panesettings;
    @FXML
    TitledPane panehelp;
    @FXML
    private void loginHandler(ActionEvent event){
        UiUtils.closeStage(event);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image im = new Image(getClass().getResourceAsStream("/com/employees/images/account-login-3x.png"));
        btnlogin.setGraphic(new ImageView(im));
        Image imlogin = new Image(getClass().getResourceAsStream("/com/employees/images/lock-locked-3x.png"));
        Image imsettings = new Image(getClass().getResourceAsStream("/com/employees/images/wrench-3x.png"));
        Image imhelp = new Image(getClass().getResourceAsStream("/com/employees/images/question-mark-3x.png"));
        panesettings.setGraphic(new ImageView(imsettings));
        panehelp.setGraphic(new ImageView(imhelp));
        panelogin.setGraphic(new ImageView(imlogin));
        // TODO
    }    
    
}
