/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.employees.utils;

import java.util.prefs.Preferences;

/**
 *
 * @author Salim Said Hemed
 */
public class NetConfig {
    private String host;
    private int port;
    private Preferences PREFERENCES;
    final  String HOST = "HOST";
    final String PORT = "PORT";
    public NetConfig(){
    this.PREFERENCES = Preferences.userRoot().node(this.getClass().getName());
    }
    public String getNetworkConfig(){
        StringBuilder Address = new StringBuilder();
        Address.append("http://");
        Address.append(PREFERENCES.get(HOST, "127.0.0.1"));
        Address.append(":");
        Address.append(PREFERENCES.get(PORT, "80"));
    return Address.toString();
    }
    public void setNetWorkConfig(String host,int port){
    this.PREFERENCES.put(HOST, host);
    this.PREFERENCES.putInt(PORT, port);
    }
    
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
    
}
