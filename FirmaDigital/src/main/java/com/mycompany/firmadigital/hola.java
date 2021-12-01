/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.firmadigital;

import Modelo.Llaves;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author PRIDE OTTER
 */
@MultipartConfig
public class hola extends HttpServlet {
private static Cipher rsa;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, SignatureException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String nomb = request.getParameter("nombre");
            Part arch = request.getPart("archivo");
            InputStream is = arch.getInputStream(); 
            byte[] bytes = IOUtils.toByteArray(is);
            
            File f = new File("C:/Pruebas/"+nomb+".cifrado");
            File c = new File("C:/Pruebas/firma.txt");
            
            FileOutputStream ous = new FileOutputStream(f);
            FileOutputStream ous2 = new FileOutputStream(c);
            
            //generar las llaves de rsa
            KeyPairGenerator generadorRSA = KeyPairGenerator.getInstance("RSA");
            KeyPair llavesRSA = generadorRSA.generateKeyPair();
            //generamos publica y privada
            PublicKey llavePublica = llavesRSA.getPublic();
            PrivateKey llavePrivada = llavesRSA.getPrivate();
            
            Llaves hola = new Llaves();
            //los metodos para guardar y cargar las llaves .key
            hola.saveKey(llavePublica, "C:/Pruebas/publicKey.key");
            
            
            //los metodos para guardar y cargar las llaves .key
            hola.saveKey(llavePrivada, "C:/Pruebas/privateKey.key");
            
            rsa = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        
            
        
            rsa.init(Cipher.ENCRYPT_MODE, llavePublica);
        
            //doy forma al arreglo de bytes
            byte[] cifrado = rsa.doFinal(bytes);
            Signature firma = Signature.getInstance("MD5WithRSA");
        
        //inicializarla para la llave privada
        
        firma.initSign(llavePrivada);
        
        //actualizamos el documento
        
        firma.update(bytes);
        
        //vamos a firmar el documento
        
        byte[] firmadocumento = firma.sign();
        
        ous2.write(firmadocumento);
            //doy forma al arreglo de bytes
           
            
            
            //ya puedo escribir el archivo cifrado
           
            
            
            
            firma.initVerify(llavePublica);
        
        //vamos a actualizar el edo del documento
        
        firma.update(bytes);
        
      Signature firma2 = Signature.getInstance("MD5WithRSA");
      firma2.initVerify(llavePublica);
      firma2.update(bytes);
            //ya puedo escribir el archivo cifrado
            ous.write(cifrado);
            ous.close();
            is.close();
            ous2.close();
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet hola</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet hola at " + "¿El documento es veridico? " + firma2.verify(firmadocumento) + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    try {
        processRequest(request, response);
    } catch (NoSuchAlgorithmException ex) {
        Logger.getLogger(hola.class.getName()).log(Level.SEVERE, null, ex);
    } catch (InvalidKeyException ex) {
        Logger.getLogger(hola.class.getName()).log(Level.SEVERE, null, ex);
    } catch (NoSuchPaddingException ex) {
        Logger.getLogger(hola.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalBlockSizeException ex) {
        Logger.getLogger(hola.class.getName()).log(Level.SEVERE, null, ex);
    } catch (BadPaddingException ex) {
        Logger.getLogger(hola.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SignatureException ex) {
        Logger.getLogger(hola.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    try {
        processRequest(request, response);
    } catch (NoSuchAlgorithmException ex) {
        Logger.getLogger(hola.class.getName()).log(Level.SEVERE, null, ex);
    } catch (InvalidKeyException ex) {
        Logger.getLogger(hola.class.getName()).log(Level.SEVERE, null, ex);
    } catch (NoSuchPaddingException ex) {
        Logger.getLogger(hola.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalBlockSizeException ex) {
        Logger.getLogger(hola.class.getName()).log(Level.SEVERE, null, ex);
    } catch (BadPaddingException ex) {
        Logger.getLogger(hola.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SignatureException ex) {
        Logger.getLogger(hola.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
