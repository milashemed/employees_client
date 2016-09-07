/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.employees.ui.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

/**
 * FXML Controller class
 *
 * @author Salim Said Hemed
 */
public class InitUserController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    Button btnsave;
    @FXML
    Hyperlink lnwho;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        HBox.setHgrow(btnsave, Priority.ALWAYS);
        btnsave.setMaxWidth(Double.MAX_VALUE);
    }    
    
}
