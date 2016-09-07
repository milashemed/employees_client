/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.employees.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Salim Said Hemed
 */
public class WebClient {
    private static final String USER_AGENT = "Mozilla/5.0";
    private URL url;
    private final String ENCODING = "UTF-8";
    HttpURLConnection conn;
    public WebClient(String url){
        try {
            this.url = new URL(url);
             conn = (HttpURLConnection)this.url.openConnection();
             conn.setRequestProperty("User-Agent", USER_AGENT);
             conn.setRequestProperty( "charset", "utf-8");

             conn.setDoOutput(true);
             
        } catch (MalformedURLException ex) {
            Logger.getLogger(WebClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WebClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String sendPOST(Map<String,String> params) throws ProtocolException, IOException{
        byte[] urlparams = processParams(params);
        conn.setRequestMethod("POST");
        conn.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded"); 
        conn.setRequestProperty( "Content-Length", Integer.toString( urlparams.length ));
        conn.connect();
        conn.getOutputStream().write(urlparams);
        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(),ENCODING));
        StringBuilder output = new StringBuilder();
        for (int c;(c=in.read())>=0;){
        output.append((char)c);
        }
        return output.toString();
    }
    public String sendGET() throws ProtocolException, IOException{
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", "text/plain"); 
        conn.setRequestProperty("charset", ENCODING);
        conn.connect();
        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(),ENCODING));
        StringBuilder output = new StringBuilder();
        for (int c;(c=in.read())>=0;){
        output.append((char)c);
        }
        return output.toString();
    }
    private byte[] processParams(Map<String,String> params){
    StringBuilder postdata = new StringBuilder();
   
       
    params.forEach((k,v)->{
        try {
        if (params.size()!=0)postdata.append("&");
        postdata.append(URLEncoder.encode(k, ENCODING));
        postdata.append("=");
        postdata.append(URLEncoder.encode(v, ENCODING));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(WebClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    });    
    
    
            return params.toString().getBytes();

    }
}
