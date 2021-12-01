/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Controlador.API;
import org.json.JSONObject;

/**
 *
 * @author PRIDE OTTER
 */
public class usuario {
    
    public usuario(){
        
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPas() {
        return pas;
    }

    public void setPas(String pas) {
        this.pas = pas;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }
    private int id, salario;
    
    private String nombre,  pas;
    
    public static int registrar(String name, String pas ){
        int estado = 0;
        try{
            JSONObject peticion = new JSONObject();
            int id1=0;
            peticion.put("id", id1);
            peticion.put("name", name);
            peticion.put("pas", pas);
            String urlPeticion = "/";
            JSONObject Respuesta = API.peticionPostJSONObject(urlPeticion, peticion);
            String status = Respuesta.getString("status");
            if(status.equals("Employeed Saved")){
                estado = 1;
            }else{
                estado = 0;
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            
        }
        return estado;
    }
     public static usuario login (String name, String pas) throws Exception{
        usuario user = new usuario();
        
        
            try{
            JSONObject peticion = new JSONObject();
            System.out.println(name);
            System.out.println(pas);
            peticion.put("name", name);
            peticion.put("pas", pas);
            String urlPeticion = "/Inicio";
            JSONObject Respuesta = API.peticionPostJSONObject(urlPeticion, peticion);
            String status = Respuesta.getString("status");
            if(status.equals("no encontrado")){
                user.setNombre("no encontrado");
            }else{
                
                JSONObject datos = Respuesta.getJSONObject("usuario");
                user.setId(datos.getInt("id_usu"));
                user.setNombre(datos.getString("Nom_usu"));
                user.setPas("Contraseña_usu");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            user.setNombre("no encontrado");
        }
        
        return user;
}
}
        
