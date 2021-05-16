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
public class Autor {
    
    private int id_autor;
    private String nombre;
    private String cargo;
    
    public Autor(){
        
    }

    public Autor(int id_autor, String nombre, String cargo) {
        this.id_autor = id_autor;
        this.nombre = nombre;
        this.cargo = cargo;
    }


    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "autor{" + "id_autor=" + id_autor + ", nombre=" + nombre + ", cargo=" + cargo + '}';
    }
    
    
    
    
    
}
