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
public class GestorClave extends clsConexion {
  
    
      public void cambiarClave(clsClave clave) {
        try {
            //Llamar al procedimiento
            obj_Procedimiento = conexion.prepareCall("{call cambiarClave(?)}");
            //Definir la Entradas o parametros (?) del Procedimiento Almacenado
          
            obj_Procedimiento.setString(1, clave.getCodigo());
           
            
            obj_Procedimiento.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
   public ResultSet cargarClave() {
try {
//Llama al procedure buscarTodasPersona
String call = "{CALL cargarClave}";
//Preparamos la sentecia
obj_Procedimiento = conexion.prepareCall(call);
rs = obj_Procedimiento.executeQuery();

} catch (SQLException ex) {
desconectarBD();
}
return rs;
} 
}
