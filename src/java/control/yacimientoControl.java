/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import java.util.ArrayList;
import java.util.Iterator;
import modelo.Yacimiento;
/**
 *
 * @author 57320
 */
public class yacimientoControl {
    
    private Yacimiento yacimiento;
    private ArrayList<Yacimiento>yacimientos;
    
    public boolean añadirYacimiento(Yacimiento yacimiento){
        try{
            yacimientos=new ArrayList<>();
            yacimientos.add(yacimiento);
            return true;
        }catch(Exception e){
            System.out.println("No se pudo añadir el yacimiento"+e.getMessage());
            return false;
        }
    }
    
    public ArrayList<Yacimiento>mostrarYacimiento(String nombre){
        if(yacimiento.getNombre().equalsIgnoreCase(nombre)){
            return yacimientos;
        }else{
            System.out.println("No hay coincidencias");
            return null;
        }
    }
    
    public boolean modificarYacimiento(String nombre,double longitud,double latitud){
        Iterator<Yacimiento>iterarYacimiento;
        iterarYacimiento = yacimientos.iterator();
        if(yacimiento.getNombre().equalsIgnoreCase(nombre)){
            while(iterarYacimiento.hasNext()){
                yacimiento.setNombre(nombre);
                yacimiento.setLongitud(longitud);
                yacimiento.setLatitud(latitud);
            }
            
           return true; 
        }else{
            System.out.println("No hay coincidencias");
            return false;
        }
    }
    
    
    public boolean eliminarYacimiento(String nombre){
        Iterator<Yacimiento>iterarYacimiento;
        iterarYacimiento = yacimientos.iterator();
        if(yacimiento.getNombre().equalsIgnoreCase(nombre)){
            while (iterarYacimiento.hasNext()) {                
                iterarYacimiento.remove();
            }
            return true;
        }else{
            System.out.println("No se encontraron coincidencias");
            return false;
        }
    }
    
    
}
