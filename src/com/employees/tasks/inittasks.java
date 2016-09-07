/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.employees.tasks;

import com.employees.utils.NetConfig;
import com.employees.utils.WebClient;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;

/**
 *
 * @author Salim Said Hemed
 */
public class inittasks {
    StringProperty pingresponse = new SimpleStringProperty();
    
    static Task<String> pingtask = new Task<String>(){

        @Override
        protected String call() throws Exception {
            NetConfig nc = new NetConfig();
            if (isCancelled()){
            return null;
            }
            final String PING_URL = nc.getNetworkConfig();
            StringBuilder url = new StringBuilder();
            url.append(PING_URL);
            url.append("/employees/web/WebHandlers/ping.php");
            WebClient wc = new WebClient(url.toString());
            String response  = wc.sendGET();
            updateMessage(response);
            return response;
        }
    @Override
    protected void succeeded(){
    super.succeeded();
    }
    @Override
    protected void cancelled(){
    super.cancelled();
    updateMessage("Task Was Cancelled");
    }
    @Override
    protected void failed(){
    super.failed();
    updateMessage("Remote Host Did Not Respond");
    }
    @Override
    protected void done(){
    super.done();
    }
    };
    public static Task<String> pingServer(){
       
       return pingtask;
    
    }
     
    }

