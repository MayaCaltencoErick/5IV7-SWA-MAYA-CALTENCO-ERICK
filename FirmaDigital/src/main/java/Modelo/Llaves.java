/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 *
 * @author PRIDE OTTER
 */
public class Llaves {
    
    
    public static void saveKey(Key key, String archivo) throws FileNotFoundException, IOException {
        byte[] llavesPubPriv = key.getEncoded();
        //genero mi archivo
        FileOutputStream fos = new FileOutputStream(archivo);
        fos.write(llavesPubPriv);
        fos.close();
    }
    public static PrivateKey loadPrivateKey(InputStream fis) throws FileNotFoundException, IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        
        int numbytes = fis.available();
        byte[] bytes = new byte[numbytes];
        fis.read(bytes);
        fis.close();
        
        KeyFactory fabricallaves = KeyFactory.getInstance("RSA");
        KeySpec keyspecprivada = new PKCS8EncodedKeySpec(bytes);
        PrivateKey llavedelarchivopriv = fabricallaves.generatePrivate(keyspecprivada);
        return llavedelarchivopriv;
    }
    
    public static PublicKey loadPublicKey(InputStream fis) throws FileNotFoundException, IOException, NoSuchAlgorithmException, InvalidKeySpecException {
       
        int numbytes = fis.available();
        byte[] bytes = new byte[numbytes];
        fis.read(bytes);
        fis.close();
        
        //hay que verificar esa llave
        KeyFactory fabricallaves = KeyFactory.getInstance("RSA");
        //voy a generar la comparacion de las llaves del archivo vs la llave del programa
        KeySpec keyspec = new X509EncodedKeySpec(bytes);
        PublicKey llavedelarchivo = fabricallaves.generatePublic(keyspec);
        return llavedelarchivo;
    }
}
