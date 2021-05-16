/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import java.util.ArrayList;
import java.util.Iterator;
import modelo.Area;

/**
 *
 * @author 57320
 */
public class areaControl {
    
    private Area area;
    private ArrayList<Area>areas;
    
    public boolean añadirArea(Area area){
        try{
            areas=new ArrayList<>();
            areas.add(area);
            return true;
        }catch(Exception e){
            System.out.println("No se pudo añadir el area"+e.getMessage());
            return false;
        }
    }
    
    public ArrayList<Area>mostrarArea(String nombre){
        if(area.getNombre().equalsIgnoreCase(nombre)){
            return areas;
        }else{
            System.out.println("No hay coincidencias");
            return null;
        }
    }
    
    public boolean modificarArea(String nombre){
        Iterator<Area>iterarArea;
        iterarArea = areas.iterator();
        if(area.getNombre().equalsIgnoreCase(nombre)){
            while(iterarArea.hasNext()){
                area.setNombre(nombre);
            }
            
           return true; 
        }else{
            System.out.println("No hay coincidencias");
            return false;
        }
    }
    
    
    public boolean eliminarArea(String nombre){
        Iterator<Area>iterarArea;
        iterarArea = areas.iterator();
        if(area.getNombre().equalsIgnoreCase(nombre)){
            while (iterarArea.hasNext()) {                
                iterarArea.remove();
            }
            return true;
        }else{
            System.out.println("No se encontraron coincidencias");
            return false;
        }
    }
    
    
}
