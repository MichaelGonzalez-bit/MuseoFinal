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
public class MagnamentAutor {
    
    private ArrayList<Autor> autores;

    public MagnamentAutor() {
            autores=new ArrayList<>();
    }
    
    
    
    public boolean añadirAutor(int id_autor, String nombre, String cargo){  
        
        if (this.buscarAutor(id_autor) != null){
            return false;
        }else{
            autores.add(new Autor(id_autor, nombre, cargo));
            
            return true;      
        }
        
    }
    
    
     public Autor buscarAutor(int id){
               
        for(Autor autor:autores ){
            if(autor.getId_autor()==id){
                return autor;
            }
        }
        return null;   
    }
     
    public boolean buscadorAutor(int id){
               
        for(Autor autor:autores ){
            if(autor.getId_autor()==id){
                return true;
            }
        }
        return false;   
    } 
     
     
     
     
     public boolean eliminarAutor(int id){
         int i=0;
         
         for (Autor autor : autores) {
             i++;
             if(autor.getId_autor()==id){
                 autores.remove(i-1);
                 return true;
             }
         }
         return false;
     }
    
     public int contador(int id){
        
        int i=0;
        for (Autor autore : autores) {
            i++;
            if(autore.getId_autor()==id){
                return i;
            }
        }
        return i;   
    }
     
     public boolean modificarAutor(int id,String option, String valor){
         if(this.buscadorAutor(id)){
             switch(option){
                 case("nombre"):
                     
                     autores.get(this.contador(id)).setNombre(valor);
                     break;
                     
                 case ("cargo"):
                     autores.get(this.contador(id)).setCargo(valor);
                     break;
             }
             return true;
                  
         }
         return false;
     }

    public ArrayList<Autor> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<Autor> autores) {
        this.autores = autores;
    }
     
     
     
}
