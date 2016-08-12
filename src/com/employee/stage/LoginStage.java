/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.employee.stage;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author salim
 */
public class LoginStage extends Stage{
    public LoginStage() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/com/employees/ui/LoginForm.fxml"));
        Scene scene = new Scene(root);
        setScene(scene);
        this.setResizable(false);
        this.setTitle("Employee Management System Admin Console Login");
        this.centerOnScreen();
        show();
    }
    
}
