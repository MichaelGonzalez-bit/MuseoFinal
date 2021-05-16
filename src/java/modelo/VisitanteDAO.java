package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 57320
 */

public class VisitanteDAO {
    
    PreparedStatement ps;
    ResultSet rs;
    Conexion c=new Conexion();
    Connection con;
    
    public Visitante validar(String nombre,String contraseña){
        Visitante vi=new  Visitante();
        String sql="select * from visitante where nombre=? and contraseña=?";
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1,nombre);
            ps.setString(2, contraseña);
            rs=ps.executeQuery();
            while (rs.next()) {                
                vi.setId(rs.getString("id"));
                vi.setNombre(rs.getString("nombre"));
                vi.setContraseña(rs.getString("contraseña"));
            }
        } catch (SQLException e) {
        }
        return vi;
    }
    
    
    
    
    
    public List listar(){
        List<Visitante>lista = new ArrayList<>();
        String sql="select * from visitante";
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                Visitante visitante=new Visitante();
                visitante.setId(rs.getString(1));
                visitante.setNombre(rs.getString(2));
                visitante.setApellido(rs.getString(3));
                visitante.setEmail(rs.getString(4));
                visitante.setContraseña(rs.getString(5));
                lista.add(visitante);
            }
        } catch (SQLException e) {
        }
        return lista;
    } 
    
    public int agregar(Visitante visitante){
        int r=0;
        String sql="insert into visitante(id,nombre,apellido,email,contraseña) values(?,?,?,?,?)";
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1,visitante.getId());
            ps.setString(2,visitante.getNombre());
            ps.setString(3,visitante.getApellido());
            ps.setString(4,visitante.getEmail());
            ps.setString(5,visitante.getContraseña());
            r=ps.executeUpdate();
            if (r==1) {
                r=1;
            }else{
                r=0;
            }
        } catch (SQLException e) {
        }
        return r;
    }
    
    
    public Visitante listarId(String id){
        String sql="select * from visitante where id="+id;
        Visitante visitante=new Visitante();
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                visitante.setId(rs.getString(1));
                visitante.setNombre(rs.getString(2));
                visitante.setApellido(rs.getString(3));
                visitante.setEmail(rs.getString(4));
                visitante.setContraseña(rs.getString(5));
            }
        } catch (SQLException e) {
        }
        return visitante;
    }
    
    public int actualizar(Visitante visitante){
        int r=0;
        String sql="update visitante set nombres=?,apellido=?,email=?,contraseña=? where id=?";
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1,visitante.getNombre());
            ps.setString(2,visitante.getApellido());
            ps.setString(3,visitante.getEmail());
            ps.setString(4,visitante.getContraseña());
            r=ps.executeUpdate();
            if(r==1){
                r=1;
            }else{
                r=0;
            }
        } catch (SQLException e) {
        }
        return r;
    }
    
    public void delete(String id){
        String sql="delete from visitante where id="+id;
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
}
