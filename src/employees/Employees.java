/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employees;

import com.employees.stage.initSettingsStage;
import com.employees.tasks.inittasks;
import com.employees.ui.Alerts.AlertDialog;
import com.employees.ui.Alerts.AlertTypes;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import org.json.JSONObject;

/**
 *
 * @author salim
 */
public class Employees extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("MainUI.fxml"));
//        
//        Scene scene = new Scene(root);
//        
//        stage.setScene(scene);
//        stage.show();
//new LoginStage();
Task<String> inittask = inittasks.pingServer();
StringProperty pingResponse = new SimpleStringProperty();
StringProperty messages = new SimpleStringProperty();
pingResponse.bind(inittask.valueProperty());
messages.bind(inittask.messageProperty());
inittask.stateProperty().addListener((workerState,oldState,newState)->{
if (newState == Worker.State.SUCCEEDED){
String response  = pingResponse.get();
JSONObject obj = new JSONObject(response);
String Status = obj.getString("Status");
if (Status.equals("OK")){
AlertDialog ad = new AlertDialog();
ad.showDialog(AlertTypes.Types.INFORMATION, "Successfull", "PING OK", "Connection Successfull");
}
}
else if (newState == Worker.State.CANCELLED){
AlertDialog ad = new AlertDialog();
ad.showDialog(AlertTypes.Types.WARNING, "Operation Aborted", "Operation Aborted", "Task Was Cancelled,The System Will Now Exit");
System.exit(0);
}
else if (newState == Worker.State.FAILED){
StringBuilder errstr = new StringBuilder();
errstr.append("An Error Has Occured While Connecting to The Server, A Description of the Error is Shown Below : \n");
errstr.append(messages.toString());
AlertDialog ad = new AlertDialog();
ad.showDialog(AlertTypes.Types.ERROR, "An Error Occurred While Connecting to The Server", "Error", messages.get());
Optional<ButtonType> response = AlertDialog.showConfirmation("Unable to Connect to The Server: Would you Like To Review Your Network Settings?", "Connection Settings Review", "Review Connection Settings?");
if (response.get() == ButtonType.OK){
    try {
        new initSettingsStage();
    } catch (IOException ex) {
        Logger.getLogger(Employees.class.getName()).log(Level.SEVERE, null, ex);
    }
}
}
});
new Thread(inittask).start();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
