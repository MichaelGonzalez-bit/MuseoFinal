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
public class Yacimiento {
    
    private int id_yacimiento;
    private String nombre;
    private double latitud;
    private double longitud;
    
    public Yacimiento(){
        
    }

    public Yacimiento(int id_yacimiento, String nombre, double latitud, double longitud) {
        this.id_yacimiento = id_yacimiento;
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
    }
 
    
    public int getId_yacimiento() {
        return id_yacimiento;
    }

    public void setId_yacimiento(int id_yacimiento) {
        this.id_yacimiento = id_yacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return "yacimiento{" + "id_yacimiento=" + id_yacimiento + ", nombre=" + nombre + ", latitud=" + latitud + ", longitud=" + longitud + '}';
    }
    
    
    
    
    
    
}
