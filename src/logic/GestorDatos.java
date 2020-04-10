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
public class GestorDatos extends clsConexion{

    public clsInfo buscarDato(int codigo){
         clsInfo info = null;
        try {
//Nos conectamos 
            conectarBD();
//Busca los datos del profesor
            String call = "{CALL buscadato(?)}";
//Preparamos la sentecia
            obj_Procedimiento = conexion.prepareCall(call);
//Identificacion
            obj_Procedimiento.setInt(1, codigo);
            rs = obj_Procedimiento.executeQuery();
            if (rs.next()) { //Si lo encontro
                info = new clsInfo();
                info.setCodigo(rs.getInt(1));
                info.setNombre(rs.getString(2));
                info.setApellidos(rs.getString(8));
            }
            desconectarBD();
        } catch (SQLException ex) {
            desconectarBD();
        }
        return info;
    }

    public boolean guardarDato(clsDatos dato) {
         boolean rpta = false;
        try {
//Nos conectamos 
            conectarBD();
//Indica cual procedimiento almacenado
            String call = "{CALL INSERT_HORA(?,?,?,?,?)}";
//Preparamos la sentecia
            obj_Procedimiento = conexion.prepareCall(call);
//Envio uno por uno los parametros
             obj_Procedimiento.setString(1, dato.getFecha());
            obj_Procedimiento.setInt(2, dato.getCodigo());
            
           
            rpta = obj_Procedimiento.executeUpdate() == 1 ? true : false;

        } catch (SQLException ex) {
            desconectarBD();

        } catch (Exception ex) {
            desconectarBD();
        }

        desconectarBD();
        return rpta;
    }
   
    
    
//     public ResultSet validacionEntrada(int id) {
//        String sql = "SELECT MAX(HORA) FROM tblcontrol WHERE HORAFIN IS NULL AND idUsuario = "+id+"";
//        System.out.println(sql);
//        try {
//            stmt = conexion.createStatement();
//            rs = stmt.executeQuery(sql);
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return rs;
//    }  
    
      public clsValidacionEntrada validacion(int codigo){
         clsValidacionEntrada vali = null;
        try {
//Nos conectamos 
            conectarBD();
//Busca los datos del profesor
            String call = "{CALL validacionEntrada(?)}";
//Preparamos la sentecia
            obj_Procedimiento = conexion.prepareCall(call);
//Identificacion
            obj_Procedimiento.setInt(1, codigo);
            rs = obj_Procedimiento.executeQuery();
            if (rs.next()) { //Si lo encontro
                vali = new clsValidacionEntrada();
                vali.setHora(rs.getString(1));
               
            }
            desconectarBD();
        } catch (SQLException ex) {
            desconectarBD();
        }
        return vali;
    }
}
