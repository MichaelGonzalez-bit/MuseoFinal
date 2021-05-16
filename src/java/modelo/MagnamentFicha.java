/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author Duvan Felipe
 */

public class MagnamentFicha {
    
    private ArrayList<FichaEjemplar> fichas;
    private MagnamentAutor MagAutor;


    public MagnamentFicha() {
        MagAutor = new MagnamentAutor();
        fichas=new ArrayList<>(); 

    }

    public boolean añadirFicha(int idEjemplar,String nombre,String filum, String tamaño, double peso,int idYacimiento, String nombreYacimineto, double latitud,double longitud, Date fechaIngreso, int edadEjemplar,int idautor){
        
        Autor autor = MagAutor.buscarAutor(idautor);
        String autorid= new String()+autor.getId_autor();
        String idYA=String.valueOf(idYacimiento);
        
        if(autor != null){
            
            if (this.buscarFicha(idEjemplar)) {
                return false;
            }else{
                fichas.add(new FichaEjemplar(idEjemplar,nombre,filum,tamaño,peso,idYA,fechaIngreso,edadEjemplar,autorid ));
                return true;
            } 
               
        }
        
        return false;
        
    }

    public boolean buscarFicha(int id){
               
        for(FichaEjemplar ficha:fichas ){
            if(ficha.getId_Ejemplar()==id){
                return true;
            }
        }
        return false;   
    }
    
    public int contador(int id){
        
        int i=0;
        for(FichaEjemplar ficha:fichas ){
            i++;
            if(ficha.getId_Ejemplar()==id){
                return i;
            }
        }
        return i;   
    }
    
    public ArrayList<FichaEjemplar> mostrarFicha(String nombre){
        
        ArrayList<FichaEjemplar> aux = new ArrayList<>();  
                
        for(FichaEjemplar ficha:fichas ){
            if(ficha.getNombre().equals(nombre)){
                aux.add(ficha);
            }
        }
        return aux;   
    }

    
    public boolean modificarFicha(int id,String option, String valor) throws ParseException{
        
        if(this.buscarFicha(id)){
            
            switch(option){
            
            case("nombre"):
                fichas.get(this.contador(id)).setNombre(valor);
                break;
            case("filum"):
                fichas.get(this.contador(id)).setFilum(valor);
                break;
            case("tamaño"):
                fichas.get(this.contador(id)).setTamaño(valor);
                break;
            case("peso"):
                fichas.get(this.contador(id)).setPeso(Double.parseDouble(valor));
                break;
       /*     case("nombreyaci"):
                fichas.get(this.contador(id)).getProcedencia().setNombre(valor);
                break;
            case("latitud"):
                fichas.get(this.contador(id)).getProcedencia().setLatitud(Double.parseDouble(valor));
                break;
            case("longitud"):
                fichas.get(this.contador(id)).getProcedencia().setLongitud(Double.parseDouble(valor));
                break;  */
            case("fechaIngreso"):
                DateFormat format=new SimpleDateFormat("DD/MM/YYYY");
                Date fecha=format.parse(valor);
                fichas.get(this.contador(id)).setFechaIngreso(fecha);
                
                break;
            case("edadejemplar"):
                fichas.get(this.contador(id)).setEdadEjemplar(Integer.parseInt(valor));
                
                break;
            case("autor"):
                
                fichas.get(this.contador(id)).setAutor(String.valueOf(MagAutor.buscarAutor(id).getId_autor()));
                
                break;
                
            } 
            return true;
        }
        return false;
        
      
    }
    
    
    public boolean eliminarFicha(int id){
        int i= 0;
        
        for(FichaEjemplar ficha:fichas ){
            i++;
            if(ficha.getId_Ejemplar()==id){
                fichas.remove(i-1);
                return true;
            }
        }
        return false;   
    }

    public ArrayList<FichaEjemplar> getFichas() {
        return fichas;
    }

    public void setFichas(ArrayList<FichaEjemplar> fichas) {
        this.fichas = fichas;
    }

    public MagnamentAutor getMagAutor() {
        return MagAutor;
    }

    public void setMagAutor(MagnamentAutor MagAutor) {
        this.MagAutor = MagAutor;
    }
    
    
    
}
