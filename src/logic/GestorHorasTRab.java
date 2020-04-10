/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author invenio_110
 */
public class GestorHorasTRab extends clsConexion {
    
   public ResultSet likeEmpleado(String para) {
        String sql = "SELECT idusuario,nombre FROM tblusuarios "
                + "where nombre = '" + para + "'";
        System.out.println(sql);
        try {
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
    }  
   
   
   
   
    public ResultSet likeHorario(int id,String fecha1, String fecha2) {
        String sql = "select u.idUsuario,u.nombre,SEC_TO_TIME(SUM(TIME_TO_SEC(c.horastrab))/60) as TotalHoras from tblcontrol c INNER "
                + " JOIN tblusuarios u ON  u.idUsuario=c.idUsuario "
                + "where (DATE (fecha) BETWEEN STR_TO_DATE('"+ fecha1+"', '%Y-%m-%d')and STR_TO_DATE('"+fecha2+"', '%Y-%m-%d')) and c.idUsuario = "+id+" ";
               
        try {
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
    }
    
    
}
