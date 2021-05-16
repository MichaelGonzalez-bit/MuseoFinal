/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author 57320
 */

public class FichaEjemplar {
    
    private int id_Ejemplar;
    private String nombre;
    private String filum;
    private String tamaño;
    private double peso;
    private String procedencia;
    private Date fechaIngreso;
    private int edadEjemplar;
    private String autor;
    
    public FichaEjemplar(){
        
    }

    public FichaEjemplar(int id_Ejemplar, String nombre, String filum, String tamaño, double peso, String procedencia, Date fechaIngreso, int edadEjemplar, String autor) {
        this.id_Ejemplar = id_Ejemplar;
        this.nombre = nombre;
        this.filum = filum;
        this.tamaño = tamaño;
        this.peso = peso;
        this.procedencia = procedencia;
        this.fechaIngreso = fechaIngreso;
        this.edadEjemplar = edadEjemplar;
        this.autor = autor;
    }

    public int getId_Ejemplar() {
        return id_Ejemplar;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFilum() {
        return filum;
    }

    public String getTamaño() {
        return tamaño;
    }

    public double getPeso() {
        return peso;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public int getEdadEjemplar() {
        return edadEjemplar;
    }

    public String getAutor() {
        return autor;
    }

    public void setId_Ejemplar(int id_Ejemplar) {
        this.id_Ejemplar = id_Ejemplar;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFilum(String filum) {
        this.filum = filum;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void setEdadEjemplar(int edadEjemplar) {
        this.edadEjemplar = edadEjemplar;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "FichaEjemplar{" + "id_Ejemplar=" + id_Ejemplar + ", nombre=" + nombre + ", filum=" + filum + ", tama\u00f1o=" + tamaño + ", peso=" + peso + ", procedencia=" + procedencia + ", fechaIngreso=" + fechaIngreso + ", edadEjemplar=" + edadEjemplar + ", autor=" + autor + '}';
    }

 
    

   
    
}
