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
 * @author INVENIO122
 */
public class clsGestorEmpleado extends clsConexion {
    
    
    
    
      public ResultSet likenombre(String para) {
        String sql = "SELECT h.idHorario as ITEM , u.idusuario as Cedula , concat(u.nombre,' ',u.apellidos) as Empleado , j.tiempo as Turno , j.horainicio as Entrada , j.horasalida as Salida , "
                + "DATE_FORMAT(h.fechaInicio,'%d/%m/%Y') AS Inicio , DATE_FORMAT(h.fechaFinal,'%d/%m/%Y') AS Fin from tblhorarios h inner join tblusuarios u on h.idUsuario = u.idUsuario "
                + "inner join tbljornadas j on h.idJornada = j.idJornada "
                + "where u.idusuario = " + para + "";
        System.out.println(sql);
        try {
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
    }
      
      
      
      public ResultSet likeHorario(String para,String ps, String id) {
        String sql = "SELECT h.idHorario as ITEM , u.idusuario as Cedula , concat(u.nombre,' ',u.apellidos) as Empleado , j.tiempo as Turno , j.horainicio as Entrada , j.horasalida as Salida , "
                + "DATE_FORMAT(h.fechaInicio,'%d/%m/%Y') AS Inicio , DATE_FORMAT(h.fechaFinal,'%d/%m/%Y') AS Fin from tblhorarios h inner join tblusuarios u on h.idUsuario = u.idUsuario "
                + "inner join tbljornadas j on h.idJornada = j.idJornada "
                + "where " +ps+ " like '%" + para + "%' and u.idusuario = "+ id+ "";
        System.out.println(sql);
        try {
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
    }
    
}
