/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author 57320
 */
public class Area {
    
    private int id_area;
    private String nombre;
    
    public Area(){
        
    }

    public Area(int id_area, String nombre) {
        this.id_area = id_area;
        this.nombre = nombre;
    }

   
    public int getId_area() {
        return id_area;
    }

    public void setId_area(int id_area) {
        this.id_area = id_area;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "area{" + "id_area=" + id_area + ", nombre=" + nombre + '}';
    }
    
    
    
    
}
