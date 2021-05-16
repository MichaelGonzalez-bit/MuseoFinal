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
public class Usuario {
    
    private String id;
    private String nombre;
    private String apellido;
    private String email;
    private String contraseña;
    
    public Usuario(){
        
    }

    public Usuario(String id, String nombre, String apellido, String email, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contraseña = contraseña;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    

    @Override
    public String toString() {
        return "usuario{" + "id_usuario=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", contrase\u00f1a=" + contraseña + '}';
    }
    
    
    
    
    
}
