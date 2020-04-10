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
public class clsGestorHorarios extends clsConexion {
    
public ResultSet cargarHorarios() {
try {
//Llama al procedure buscarTodasPersona
String call = "{CALL Cargarhorarios}";
//Preparamos la sentecia
obj_Procedimiento = conexion.prepareCall(call);
rs = obj_Procedimiento.executeQuery();

} catch (SQLException ex) {
desconectarBD();
}
return rs;
}
    
      
       public ResultSet likeEmpleado(String para) {
        String sql = "SELECT `idusuario`, concat(nombre,' ',apellidos) FROM tblusuarios "
                + "where concat(nombre,' ',apellidos) like '%" + para + "%'";
        System.out.println(sql);
        try {
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
    }  
       
          public ResultSet likeJornada(String para) {
        String sql = "SELECT `idJornada`, `tiempo`, `horainicio`, `horasalida` FROM tbljornadas "
                + "where tiempo like '%" + para + "%'";
        System.out.println(sql);
        try {
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
    } 
    
           public boolean agregarhorario(clsHorarios horario) {
        
         boolean rpta = false;
        try {
//Nos conectamos 
            conectarBD();
//Indica cual procedimiento almacenado
            String call = "{CALL Registrarhorarios(?,?,?,?)}";
//Preparamos la sentecia
            obj_Procedimiento = conexion.prepareCall(call);
//Envio uno por uno los parametros
            obj_Procedimiento.setInt(1, horario.getIdUusuario());
            
            obj_Procedimiento.setInt(2, horario.getIdJornada());
            obj_Procedimiento.setDate(3, horario.getDate());
             obj_Procedimiento.setDate(4, horario.getFechaFinal());
            
            rpta = obj_Procedimiento.executeUpdate() == 1 ? true : false;

        } catch (SQLException ex) {
            desconectarBD();

        } catch (Exception ex) {
            desconectarBD();
        }

        desconectarBD();
        return rpta;
    }



public boolean eliminar(int idHorario) {
boolean rpta = false;
try {
//Nos conectamos 
conectarBD();
//Indica cual procedimiento almacenado
String call = "{CALL Eliminarhorarios(?)}";
//Preparamos la sentecia
obj_Procedimiento = conexion.prepareCall(call);
//Envio uno por uno los parametros
obj_Procedimiento.setInt(1, idHorario);
rpta = obj_Procedimiento.executeUpdate() == 1 ? true : false;

} catch (SQLException ex) {
desconectarBD();

} catch (Exception ex) {
desconectarBD();
}

desconectarBD();
return rpta;
}


   public ResultSet likeHorario(String ps,String para) {
        String sql = "SELECT h.idHorario as ITEM , u.idusuario as Cedula , concat(u.nombre,' ',u.apellidos) as Empleado , j.tiempo as Turno , j.horainicio as Entrada , j.horasalida as Salida , "
                + "DATE_FORMAT(h.fechaInicio,'%d/%m/%Y') AS Inicio , DATE_FORMAT(h.fechaFinal,'%d/%m/%Y') AS Fin from tblhorarios h inner join tblusuarios u on h.idUsuario = u.idUsuario "
                + "inner join tbljornadas j on h.idJornada = j.idJornada "
                + "where " +ps+ " like '%" + para + "%'";
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
