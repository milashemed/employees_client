/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.employees.property;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Salim Said Hemed
 */
public class TextVal {
    StringProperty text = new SimpleStringProperty();
    public final String getText(){return text.get();}
    public final void setText(String text){this.text.set(text);}

    public StringProperty getTextProperty() {
        return text;
    }
    
    
}
