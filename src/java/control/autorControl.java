/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import java.util.ArrayList;
import java.util.Iterator;
import modelo.Autor;
/**
 *
 * @author 57320
 */
public class autorControl {
    
    private Autor autor;
    private ArrayList<Autor> autores;
    
    public boolean añadirAutor(Autor autor){
        try{
            autores=new ArrayList<>();
            autores.add(autor);
            return true;
        }catch(Exception e){
            System.out.println("No se pudo crear correctamente/n"+e.getMessage());
            return false;
        }
    }
    
    public ArrayList<Autor> mostrarAutor(String nombre){
        if(autor.getNombre().equalsIgnoreCase(nombre)){
            return autores;
        }else{
            System.out.println("No se encontraron coincidencias");
            return null;
        }
    }
    
    
    public boolean modificarAutor(String nombre,String cargo){
        Iterator<Autor>iterarautor;
        iterarautor = autores.iterator();
        if(autor.getNombre().equalsIgnoreCase(nombre)){
            while(iterarautor.hasNext()){
                autor.setNombre(nombre);
                autor.setCargo(cargo);
            }
            
           return true; 
        }else{
            System.out.println("No hay coincidencias");
            return false;
        }
    }
    
    
    public boolean eliminarAutor(String nombre){
        Iterator<Autor>iterarautor;
        iterarautor = autores.iterator();
        if(autor.getNombre().equalsIgnoreCase(nombre)){
            while (iterarautor.hasNext()) {                
                iterarautor.remove();
            }
            return true;
        }else{
            System.out.println("No se encontraron coincidencias");
            return false;
        }
    }
    
}
