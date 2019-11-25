/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.Persona;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import persistencia.PersonasDAO;

/**
 *
 * @author willy
 */
public class PersonasNegocio {   
    PersonasDAO pDAO = new PersonasDAO();

    public List<Persona> listarPersonas(){
        return pDAO.listarPersonas();
    }
    
     public List<Persona> buscarPersonas(Persona pp){
        return pDAO.buscarPersonas(pp);
    }
    
     public boolean editar(Persona p){
        return pDAO.editar(p);
     
     }
     
     public boolean registrar(Persona p){
         try{
            int ed = Integer.parseInt(p.getEdad());  
            
         }
         catch(NumberFormatException e){
         
                 return false;         
         }
          Date fecha = new Date();
            java.sql.Date fechNacimiento = new java.sql.Date(fecha.getDate());
            Calendar ca = Calendar.getInstance();
            p.setFechaNacimiento(fechNacimiento);
         
        return pDAO.guardar(p);
     
     }
}
