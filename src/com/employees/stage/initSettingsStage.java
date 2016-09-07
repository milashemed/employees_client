/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.employees.stage;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Salim Said Hemed
 */
public class initSettingsStage extends Stage {
    public initSettingsStage() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/com/employees/ui/initSettings.fxml"));
        Scene scene = new Scene(root);
        setScene(scene);
        this.setResizable(false);
        this.setTitle("Enter Server Settings");
        this.centerOnScreen();
        show();
    }
}
