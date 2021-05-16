/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import modelo.FichaEjemplar;
import modelo.Yacimiento;
/**
 *
 * @author 57320
 */

public class fichaejemplarControl {
    
    private FichaEjemplar ficha ;
    private ArrayList<FichaEjemplar> fichas;
    
    public boolean añadirFicha(FichaEjemplar ficha){
        try{
            fichas = new ArrayList<>();
            fichas.add(ficha);
            System.out.println(fichas);
            System.out.println("Creado Correctamente");
            return true;
        }catch(Exception e){
            System.out.println("No se creo correctamente la ficha/n"+e.getMessage());
            return false;
        }
        
    }
    
    
    public ArrayList<FichaEjemplar> mostrarFicha(String Nombreficha){
        
        if(ficha.getNombre().equalsIgnoreCase(Nombreficha)){
            return fichas;
        }else{
            System.out.println("Ningun resultado");
            return null;
        }
        
    }
    
    
    public boolean modificarFicha(String nombre,double peso,Yacimiento procedencia,String tamaño,int edad,Date fechaIngreso,String filum){
        Iterator<FichaEjemplar>iteficha=fichas.iterator();
        if(ficha.getNombre().equalsIgnoreCase(nombre)){
            while(iteficha.hasNext()){
                ficha=iteficha.next();
                ficha.setNombre(nombre);
                ficha.setPeso(peso);
              //  ficha.setProcedencia(procedencia);
                ficha.setTamaño(tamaño);
                ficha.setEdadEjemplar(edad);
                ficha.setFechaIngreso(fechaIngreso);
                ficha.setFilum(filum);
            }
            return true;
        }else{
            System.out.println("No se encontraron coincidencias");
            return false;
        }
      
    }
    
    
    public boolean eliminarFicha(String nombre){
        Iterator<FichaEjemplar>iteficha=fichas.iterator();
        if(ficha.getNombre().equalsIgnoreCase(nombre)){
            while(iteficha.hasNext()){
                iteficha.remove();
            }
            return true;
        }else{
            System.out.println("No hay coincidencias");
            return false;
        }
    }
    
    
    
    
}
