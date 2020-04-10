/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Luis Salas
 */
public class clsGestorLogin extends logic.clsConexion {
    
    
    
    
    public ResultSet loginadmin(String  usuario, String pass)
    { 
        String sql = "SELECT * FROM tblUsuarios "+
                "where usuario= '" +usuario+ "' and password ='"+pass+"'" ;
        try {
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
    }
     public ResultSet loginempleado(String  usuario, String pass)
    { 
        String sql = "SELECT * FROM tblUsuarios "+
                "where usuario= '" +usuario+ "' and password ='"+pass+"'" ;
        try {
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
    }
    
    
    
    
}
