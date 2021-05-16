/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author 57320
 */
public class Administrador extends Usuario{
    
    private ArrayList<Administrador> admins;
    private String clave;
    
    public Administrador(){
        
    }
    
    
    
    public Administrador(String id, String nombre, String apellido, String email, String contraseña,String clave) {
        super(id, nombre, apellido, email, contraseña);
        admins=new ArrayList<>();
    }
 
    
    public boolean crearAdmin(String id,String nombre,String apellido,String email,String contraseña,String clave){
        if(clave.equals("xfC9p6Kf0n")){
            if(buscarAdmin(id)!=null){
                return false;
            }else{
                admins.add(new Administrador(id, nombre, apellido, email, contraseña,clave));
                return true;
            }
        }
        return false;
    }
    
    public Administrador buscarAdmin(String id){
        for (Administrador admin : admins) {
            if(admin.getId().equals(id)){
                return admin;
            }
        }
        return null;
    }
    
    public boolean buscadorAdmin(String id){
        for (Administrador admin : admins) {
            if(admin.getId().equals(id)){
                return true;
            }
        }
        return false;
    }
    
    public int contador(String id){
        int i=0;
        for (Administrador admin : admins) {
            i++;
            if(admin.getId().equals(id)){
                return i;
            }
        }
        return i;   
    }
    
    public boolean eliminarAdmin(String id){
        int i=0;
        for (Administrador admin : admins) {
            i++;
            if(admin.getId().equals(id)){
                admins.remove(i-1);
                return true;
            }
            
        }
        return false;
    }
    
    public boolean verificaContraseña(String id,String contraseña){
        for (Administrador admin : admins) {
            if(admin.getContraseña().equals(contraseña) && admin.getId().equals(id)){
                return true;
            }
        }
        return false;
    }
    
    
    public boolean modificarAdmin(String id,String option,String valor){
        
        if(this.buscadorAdmin(id)){
            switch(option){
                case("nombre"):
                    admins.get(this.contador(id)).setNombre(valor);
                    break;
                case("apellido"):
                    admins.get(this.contador(id)).setApellido(valor);
                    break;
                case("email"):
                    admins.get(this.contador(id)).setEmail(valor);
                    break;
            }
            return true;
            
        }
        return false;
        
    }
    
    
    public boolean modificarContrase(String id,String actual,String nueva){
        if(this.buscadorAdmin(id)){
            if(this.verificaContraseña(id, actual)){
                admins.get(this.contador(id)).setContraseña(nueva);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Administrador> getAdmins() {
        return admins;
    }

    public void setAdmins(ArrayList<Administrador> admins) {
        this.admins = admins;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    
    
    
}
