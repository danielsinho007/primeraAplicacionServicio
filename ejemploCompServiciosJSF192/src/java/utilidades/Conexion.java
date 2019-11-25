/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MEMA
 */
public class Conexion {

    Connection con;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    public Connection obtenerConexion() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca_jic?useSSL=false&allowPublicKeyRetrieval=true", "root", "administrador");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
            ex.printStackTrace();
        }
        return con;
    }

    public static void main(String[] args) {
        Conexion conection = new Conexion();
        try {
            ResultSet r = conection.obtenerConexion().prepareStatement("select * from persona ").executeQuery();
            if (r.next()) {
                System.out.println("id: " + r.getString(1) + " identificacion: " + r.getString(2));
                while (r.next()) {
                    System.out.println("codigo: " + r.getString(1) + "nombre: " + r.getString("nombres"));
                }
            } else {
                System.out.println("NO HAY DATOS");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("#Excepcion: "+e.getMessage());
        }finally{
            try{
             conection.con.close();
            }catch(Exception eo){
            
            }
        }
    }
}