/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import java.util.ArrayList;
import java.util.Iterator;
import modelo.Usuario;
/**
 *
 * @author 57320
 */
public class usuarioControl {
    
    private Usuario usuario;
    private ArrayList<Usuario>usuarios;
    
    public boolean añadirUsuario(Usuario usuario){
        try{
            usuarios=new ArrayList<>();
            usuarios.add(usuario);
            return true;
        }catch(Exception e){
            System.out.println("No se pudo añadir el usuario"+e.getMessage());
            return false;
        }
    }
    
    public ArrayList<Usuario>mostrarUsuario(String nombre){
        if(usuario.getNombre().equalsIgnoreCase(nombre)){
            return usuarios;
        }else{
            System.out.println("No hay coincidencias");
            return null;
        }
    }
    
    public boolean modificarUsuario(String nombre,String apellido,String email,String contraseña){
        Iterator<Usuario>iterarUsuario;
        iterarUsuario = usuarios.iterator();
        if(usuario.getNombre().equalsIgnoreCase(nombre)){
            while(iterarUsuario.hasNext()){
                usuario.setNombre(nombre);
                usuario.setApellido(apellido);
                usuario.setEmail(email);
                usuario.setContraseña(contraseña);
            }
            
           return true; 
        }else{
            System.out.println("No hay coincidencias");
            return false;
        }
    }
    
    
    public boolean eliminarUsuario(String nombre){
        Iterator<Usuario>iterarUsuario;
        iterarUsuario = usuarios.iterator();
        if(usuario.getNombre().equalsIgnoreCase(nombre)){
            while (iterarUsuario.hasNext()) {                
                iterarUsuario.remove();
            }
            return true;
        }else{
            System.out.println("No se encontraron coincidencias");
            return false;
        }
    }
    
    
    
    
}
