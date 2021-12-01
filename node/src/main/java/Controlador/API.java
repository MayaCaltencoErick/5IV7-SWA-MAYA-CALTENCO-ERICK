/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONObject;

/**
 *
 * @author PRIDE OTTER
 */
public class API {
    public static final String url = "http://localhost:4000";
    
    public static JSONObject peticionPostJSONObject(String urll, JSONObject data)throws Exception{
        String charset = "UTF-8"; 
        StringBuilder resultado = new StringBuilder();
        URLConnection connection = new URL(url + urll).openConnection();
        connection.setDoOutput(true); // Triggers POST.
        connection.setRequestProperty("Accept-Charset", charset);
        connection.setRequestProperty("Content-Type", "application/json;charset=" + charset);
        try (OutputStream output = connection.getOutputStream()) {
          output.write(data.toString().getBytes(charset));
        }
        BufferedReader rd = new BufferedReader(new InputStreamReader (connection.getInputStream()));
        String linea;
        while ((linea = rd.readLine()) != null) {
                resultado.append(linea);
        }
        rd.close();
        
        return new JSONObject(resultado.toString());
    }
}
