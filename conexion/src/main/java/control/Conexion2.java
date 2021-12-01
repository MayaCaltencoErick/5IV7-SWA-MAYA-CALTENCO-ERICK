package control;


import java.sql.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PRIDE OTTER
 */
public class Conexion2 {
   
public static Connection getConnection(){
        String url, userName, password;
        
        url = "jdbc:mysql://localhost:3307/mesegdb";
        userName = "root";
        password = "nAruto.04S";
        
        Connection con = null;
        
        try{
           Class.forName("com.mysql.jdbc");
            
            con = DriverManager.getConnection(url, userName, password);
            
            System.out.println("Conexion Exitosa con la BD");
        
        }catch(Exception e){
            System.out.println("Error al conectar la BD");
            System.out.println(e.getMessage());
        
        }
        return con;
    }
}
