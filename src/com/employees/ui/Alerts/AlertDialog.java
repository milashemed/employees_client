/**
 * @author Salim Said Hemed
 * @version 0.1
 * This Class Defines Convenience Methods for dealing with JavaFX Dialogs.
 * The Following Methods are Defined :-
 * <ol>
 * <li><i>showDialog : </i> Main Method that Invokes Other Method Dialog Types </li>
 * <li><i>showConfirmation : </i> Displays a Confirmation Dialog Type</li>
 * <li><i>showExceptionDialog : </i> Displays an Exception Dialog Type </li>
 * </ol>
 * 
 * 
 */
package com.employees.ui.Alerts;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

/**
 *
 * @author Salim Said Hemed
 */
public class AlertDialog {
    String title;
    String message;
    String header;
    
    /**
     *
     * @param type
     * @param header
     * @param title
     * @param message
     */
    public  void showDialog(AlertTypes.Types type,String header,String title,String message){
        this.title = title;
        this.header = header;
        this.message = message;
       switch (type){
           case INFORMATION: this.showInfo();break;
           case ERROR: this.showError();break;
           case WARNING: this.showWarning();break;
       } 
    }
   private void showInfo(){
       Alert alert = new Alert(AlertType.INFORMATION);
       alert.setTitle(title);
       alert.setHeaderText(header);
       alert.setContentText(message);
       alert.showAndWait();
   }
   private void showWarning(){
    Alert alert = new Alert(AlertType.WARNING);
       alert.setTitle(title);
       alert.setHeaderText(header);
       alert.setContentText(message);
       alert.showAndWait();
   }
   private void showError(){
    Alert alert = new Alert(AlertType.ERROR);
       alert.setTitle(title);
       alert.setHeaderText(header);
       alert.setContentText(message);
       alert.showAndWait();
   }
   
    /**
     *<h1>USAGE</h1>
     * <i> Optional<ButtonType> result = AlertDialog().showConfirmation(message,title,header);
     * if (result.get() == ButtonType.OK){} else {}
     * </i>
     * @param message
     * @param title
     * @param header
     * @return
     */
    public static Optional<ButtonType> showConfirmation(String message,String title, String header){
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);
        
    return alert.showAndWait();
    }

    /**
     *
     * @param exception
     * @param title
     * @param message
     * @param header
     */
    public void showExceptionDialog(Exception exception,String title, String message, String header){
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle(title);
    alert.setContentText(message);
    alert.setHeaderText(header);
    StringWriter writer = new StringWriter();
    PrintWriter pw = new PrintWriter(writer);
    exception.printStackTrace(pw);
    String exceptionText = writer.toString();
    Label label = new Label("The Exception StackTrace was : ");
    TextArea area = new TextArea(exceptionText);
    area.setEditable(false);
    area.setWrapText(true);
    area.setMaxWidth(Double.MAX_VALUE);
    area.setMaxHeight(Double.MAX_VALUE);
    GridPane gridcontent = new GridPane();
    GridPane.setHgrow(area, Priority.ALWAYS);
    GridPane.setVgrow(area, Priority.ALWAYS);
    gridcontent.setMaxWidth(Double.MAX_VALUE);
    gridcontent.add(label, 0, 0);
    gridcontent.add(area, 0, 1);
    alert.getDialogPane().setExpandableContent(gridcontent);
    alert.showAndWait();
    
    }

    /**
     *<h1>USAGE</h1>
     * <i> Optional<String> result = AlertDialog().showTextDialog(title,message,header);
     * if (result.isPresent){}
     * using Lambda Expressions result.isPresent((text)->{})
     * </i>
     * @param title
     * @param message
     * @param header
     * @return
     */
    public static Optional<String> showTextDialog(String title,String message,String header){
    TextInputDialog dialog = new TextInputDialog();
    dialog.setTitle(title);
    dialog.setHeaderText(header);
    dialog.setContentText(message);
    return dialog.showAndWait();
    }
}
