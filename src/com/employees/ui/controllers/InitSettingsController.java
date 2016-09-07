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
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

/**
 * FXML Controller class
 *
 * @author Salim Said Hemed
 */
public class InitSettingsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    Button btnsave;
    @FXML
    Label lblstat;
    @FXML
    ProgressIndicator progstat;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        HBox.setHgrow(btnsave, Priority.ALWAYS);
        btnsave.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(progstat, Priority.ALWAYS);
        progstat.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(lblstat, Priority.ALWAYS);
        lblstat.setMaxWidth(Double.MAX_VALUE);
         Image im = new Image(getClass().getResourceAsStream("/com/employees/images/cog-3x.png"));
        btnsave.setGraphic(new ImageView(im));
    }    
    
}
