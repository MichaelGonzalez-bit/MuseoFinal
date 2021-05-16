
package modelo;

import com.sun.javafx.image.impl.IntArgb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Duvan Felipe
 */
public class FichaDAO {
    
    PreparedStatement ps;
    ResultSet rs;
    Conexion c=new Conexion();
    Connection con;
    
    public List listar(){
        List<FichaEjemplar>lista = new ArrayList<>();
        String sql="select * from fichaEjemplar";
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                
                FichaEjemplar ficha=new FichaEjemplar();
                
                
                
                
                ficha.setId_Ejemplar(Integer.parseInt(rs.getString(1)));
                ficha.setNombre(rs.getString(2));
                ficha.setFilum(rs.getString(3));
                ficha.setTamaño(rs.getString(4));
                ficha.setPeso(Double.parseDouble(rs.getString(5)));
                ficha.setProcedencia(rs.getString(6));
                String[] date= rs.getString(7).split("/");
                int day=Integer.parseInt(date[0]);
                int mes=Integer.parseInt(date[1])-1;
                int año=Integer.parseInt(date[2]);
                DateFormat format=new SimpleDateFormat("DD/MM/YYYY");
                Date fecha=format.parse(day+"/"+mes+"/"+año);
                
                ficha.setFechaIngreso(fecha);
                ficha.setEdadEjemplar(Integer.parseInt(rs.getString(8)));
                ficha.setAutor(rs.getString(9));
                
                lista.add(ficha);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
    public int agregar(FichaEjemplar ficha){
        int r=0;
        String sql="insert into fichaEjemplar(id,nombre,filum,tamaño,peso,procedencia,fechaingreso,edadEjemplar,autor) values(?,?,?,?,?,?,?,?,?)";
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            
            ps.setString(1, String.valueOf(ficha.getId_Ejemplar()));
            ps.setString(2,ficha.getNombre());
            ps.setString(3, ficha.getFilum());
            ps.setString(4,ficha.getFilum());
            ps.setString(5,ficha.getTamaño());
            ps.setString(6,String.valueOf(ficha.getPeso()));
            ps.setString(7,ficha.getProcedencia());
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            String fechaComoCadena = sdf.format(ficha.getFechaIngreso());
            ps.setString(8,fechaComoCadena);
            ps.setString(9,String.valueOf(ficha.getEdadEjemplar()));
            ps.setString(10,ficha.getAutor());
            
            r=ps.executeUpdate();
            if (r==1) {
                r=1;
            }else{
                r=0;
            }
        } catch (Exception e) {
        }
        return r;
    }
    
    
    public List listarID(String id){
        List<FichaEjemplar>lista = new ArrayList<>();
        String sql="select * from fichaEjemplar where id="+id;
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                FichaEjemplar ficha=new FichaEjemplar();
                ficha.setId_Ejemplar(Integer.parseInt(rs.getString(1)));
                ficha.setNombre(rs.getString(2));
                ficha.setFilum(rs.getString(3));
                ficha.setTamaño(rs.getString(4));
                ficha.setPeso(Double.parseDouble(rs.getString(5)));
                ficha.setProcedencia(rs.getString(6));
                String[] date= rs.getString(7).split("/");
                int day=Integer.parseInt(date[0]);
                int mes=Integer.parseInt(date[1])-1;
                int año=Integer.parseInt(date[2]);
                DateFormat format=new SimpleDateFormat("DD/MM/YYYY");
                Date fecha=format.parse(day+"/"+mes+"/"+año);
                
                ficha.setFechaIngreso(fecha);
                ficha.setEdadEjemplar(Integer.parseInt(rs.getString(8)));
                ficha.setAutor(rs.getString(9));
       
                
            }
        } catch (Exception e) {
        }
        return lista;
    } 
    
    
    public int actualizar(FichaEjemplar ficha){
        int r=0;
        String sql="update fichaEjemplar set nombre=?, set filum=?,set tamaño=?,set peso=?,set procedencia=?,set fechaingreso=?,set edadEjemplar=?,set autor=? where id=?";
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            
            ps.setString(1,ficha.getNombre());
            ps.setString(2, ficha.getFilum());
            ps.setString(3,ficha.getFilum());
            ps.setString(4,ficha.getTamaño());
            ps.setString(5,String.valueOf(ficha.getPeso()));
            ps.setString(6,ficha.getProcedencia());
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            String fechaComoCadena = sdf.format(ficha.getFechaIngreso());
            ps.setString(7,fechaComoCadena);
            ps.setString(8,String.valueOf(ficha.getEdadEjemplar()));
            ps.setString(9,ficha.getAutor());
            
            
            
            
            r=ps.executeUpdate();
            if(r==1){
                r=1;
            }else{
                r=0;
            }
        } catch (Exception e) {
        }
        return r;
    }
    
    public void delete(String id){
        String sql="delete from fichaEjemplar where id="+id;
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    
    
}
