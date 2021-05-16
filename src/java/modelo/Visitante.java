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
public class Visitante extends Usuario{
    
    private ArrayList<Visitante>visitantes;
    
    public Visitante(){
        
    }
    
    public Visitante(String id_usuario, String nombre, String apellido, String email, String contraseña) {
        super(id_usuario, nombre, apellido, email, contraseña);
        visitantes=new ArrayList<>();
    }

    
    public boolean crearVisitante(String id,String nombre,String apellido,String email,String contraseña){
            if(buscarVisitante(id)!=null){
                return false;
            }else{
                visitantes.add(new Visitante(id, nombre, apellido, email, contraseña));
                return true;
            }
    }
    
    public Visitante buscarVisitante(String id){
        for (Visitante visitante : visitantes) {
            if(visitante.getId().equals(id)){
                return visitante;
            }
        }
        return null;
    }
    
    public boolean buscadorVisitante(String id){
        for (Visitante visitante : visitantes) {
            if(visitante.getId().equals(id)){
                return true;
            }
        }
        return false;
    }
    
    public int contador(String id){
        
        int i=0;
        for (Visitante visitante : visitantes) {
            i++;
            if(visitante.getId().equals(id)){
                return i;
            }
        }
        return i;   
    }
    
    public boolean eliminarVisitante(String id){
        int i=0;
        for (Visitante visitante : visitantes) {
            i++;
            if(visitante.getId().equals(id)){
                visitantes.remove(i-1);
                return true;
            }
            
        }
        return false;
    }
    
    public boolean verificaContraseña(String id,String contraseña){
        for (Visitante visitante : visitantes) {
            if(visitante.getContraseña().equals(contraseña) && visitante.getId().equals(id)){
                return true;
            }
        }
        return false;
    }
    
    
    public boolean modificarVisitante(String id,String option,String valor){
        
        if(this.buscadorVisitante(id)){
            switch(option){
                case("nombre"):
                    visitantes.get(this.contador(id)).setNombre(valor);
                    break;
                case("apellido"):
                    visitantes.get(this.contador(id)).setApellido(valor);
                    break;
                case("email"):
                    visitantes.get(this.contador(id)).setEmail(valor);
                    break;
            }
            return true;
            
        }
        return false;
        
    }
    
    
    public boolean modificarContrase(String id,String actual,String nueva){
        if(this.buscadorVisitante(id)){
            if(this.verificaContraseña(id, actual)){
                visitantes.get(this.contador(id)).setContraseña(nueva);
                return true;
            }
        }
        return false;
    }
    
    
    public ArrayList<Visitante> getVisitantes() {
        return visitantes;
    }

    public void setVisitantes(ArrayList<Visitante> visitantes) {
        this.visitantes = visitantes;
    }
    
    
    
    
}
