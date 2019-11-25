/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utilidades.Conexion;

/**
 *
 * @author willy
 */
public class PersonasDAO {
    
    public List<Persona> listarPersonas(){
        List<Persona> result = new ArrayList();
        Connection cone = null;
       try{
           Conexion con = new Conexion();
           cone = con.obtenerConexion();
           PreparedStatement ps = cone.prepareStatement("Select documento,nombre, apellido,direccion,telefono,celular from persona ");
           ResultSet rs = ps.executeQuery();
           Persona p;
           while(rs.next()){
               p = new Persona();
               p.setNombres(rs.getString(2));
               p.setCedula(rs.getString(1));
               p.setApellidos(rs.getString(3));               
               p.setDireccion(rs.getString(4));
               p.setTelefono(rs.getString(5));
               result.add(p);
           }
       }catch(Exception eo){
           eo.printStackTrace();
       }finally{
           try{
                cone.close();
           }catch(Exception cerrar){
               
           }
       }
        
        return result;    
    }
    
        public boolean guardar(Persona p){
        boolean result = true;
        Conexion c = new Conexion();
          Connection cn = c.obtenerConexion();
          try{              
              PreparedStatement pr;
              String sql = " insert into persona(identificacion,nombres,apellidos,telefono,direccion,email,fecha_nacimiento,tipo_persona) values(?,?,?,?,?,?,?,?)";
              pr = cn.prepareStatement(sql);
              pr.setString(1, p.getCedula());
              pr.setString(2, p.getNombres());
              pr.setString(3, p.getApellidos());
              pr.setString(4, p.getTelefono());
              pr.setString(5, p.getDireccion());
              pr.setString(6, p.getEmail());
              pr.setDate(7, p.getFechaNacimiento());
              pr.setInt(8,1);
             pr.execute();
          }catch(Exception e){
              result = false;
            e.printStackTrace();
          }finally{
            try{
            cn.close();
            }catch(Exception eo){            
            }          
          } 
        return result;
    
    }
    
    public List<Persona> buscarPersonas(Persona pp){
          List<Persona> result = new ArrayList<Persona>();
          Conexion c = new Conexion();
          Connection cn = c.obtenerConexion();
          try{              
              PreparedStatement pr;
              String sql = " select identificacion, nombres, apellidos, telefono, direccion,email from persona where ";
              if(pp.getCedula() != null){
                sql = sql + " identificacion = '"+pp.getCedula()+"' ";
                if(pp.getApellidos() != null){
                     sql = sql + " and apellidos like '%"+pp.getApellidos()+"%' ";
                }
              }else{
                if(pp.getApellidos() != null){
                     sql = sql + " apellidos like '%"+pp.getApellidos()+"%' ";
                }
              }
              
              pr = cn.prepareStatement(sql);
              ResultSet r = pr.executeQuery();
              while(r.next()){
                Persona p = new Persona();
                p.setCedula(r.getString(1));
                p.setNombres(r.getString(2));
                p.setApellidos(r.getString(3));
                p.setTelefono(r.getString(4));
                p.setDireccion(r.getString(5));
                p.setEmail(r.getString(6));
                result.add(p);              
              }             
          
          }catch(Exception e){
            e.printStackTrace();
          }finally{
            try{
            cn.close();
            }catch(Exception eo){            
            }          
          }  
          return result;    
    }
    
    public boolean editar(Persona p){
        boolean result = true;
        Conexion c = new Conexion();
          Connection cn = c.obtenerConexion();
          try{              
              PreparedStatement pr;
              String sql = " update persona set nombre=?,apellidos=?,telefono=?,direccion=? where cedula = ? ";
              pr = cn.prepareStatement(sql);
              pr.setString(5, p.getCedula());
              pr.setString(1, p.getNombres());
              pr.setString(2, p.getApellidos());
              pr.setString(3, p.getTelefono());
              pr.setString(4, p.getDireccion());
             
             pr.execute();
          }catch(Exception e){
              result = false;
            e.printStackTrace();
          }finally{
            try{
            cn.close();
            }catch(Exception eo){            
            }          
          } 
        return result;
    
    }
    
}
