/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class clsGestorAdmin extends clsConexion {

    public ResultSet buscarUsuario(int idUsuario) {
        String sql = "SELECT idUsuario "
                + "FROM tblusuarios "
                + "WHERE idUsuario = " + idUsuario;
        try {
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
    }

    public ResultSet TodosUsuarios() {
        
        
        try {
//Llama al procedure buscarTodasPersona
            String call = "{CALL TodosUsuarios}";
//Preparamos la sentecia
            obj_Procedimiento = conexion.prepareCall(call);
            rs = obj_Procedimiento.executeQuery();

        } catch (SQLException ex) {
            desconectarBD();
        }
        return rs;
    }

    public boolean guardarUsuario(clsEmpleados users) {
        boolean rpta = false;
        try {
//Nos conectamos 
            conectarBD();
//Indica cual procedimiento almacenado
            String call = "{CALL agregarUsuario(?,?,?,?,?,?,?,?)}";
//Preparamos la sentecia
            obj_Procedimiento = conexion.prepareCall(call);
//Envio uno por uno los parametros
            obj_Procedimiento.setInt(1, users.getIdUsuario());
            obj_Procedimiento.setString(2, users.getNombre());
            obj_Procedimiento.setString(3, users.getUsuario());
            obj_Procedimiento.setString(4, users.getPassword());
            obj_Procedimiento.setInt(5, users.getTipo());
            obj_Procedimiento.setString(6, users.getEmail());
            obj_Procedimiento.setString(7, users.getTelefono());
            obj_Procedimiento.setString(8, users.getApellido());
            rpta = obj_Procedimiento.executeUpdate() == 1 ? true : false;

        } catch (SQLException ex) {
            desconectarBD();

        } catch (Exception ex) {
            desconectarBD();
        }

        desconectarBD();
        return rpta;
    }

    public boolean editarUsuario(clsEmpleados users) {
        boolean rpta = false;
        try {
//Nos conectamos 
            conectarBD();
//Indica cual procedimiento almacenado
            String call = "{CALL editarUsuario(?,?,?,?,?,?,?,?)}";
//Preparamos la sentecia
            obj_Procedimiento = conexion.prepareCall(call);
//Envio uno por uno los parametros
            obj_Procedimiento.setInt(1, users.getIdUsuario());
            obj_Procedimiento.setString(2, users.getNombre());
            obj_Procedimiento.setString(3, users.getUsuario());
            obj_Procedimiento.setString(4, users.getPassword());
            obj_Procedimiento.setInt(5, users.getTipo());
            obj_Procedimiento.setString(6, users.getEmail());
            obj_Procedimiento.setString(7, users.getTelefono());
            obj_Procedimiento.setString(8, users.getApellido());
            rpta = obj_Procedimiento.executeUpdate() == 1 ? true : false;

        } catch (SQLException ex) {
            desconectarBD();

        } catch (Exception ex) {
            desconectarBD();
        }

        desconectarBD();
        return rpta;
    }

    public boolean eliminarUsuario(int idUsuario) {
        boolean rpta = false;
        try {
//Nos conectamos 
            conectarBD();
//Indica cual procedimiento almacenado
            String call = "{CALL eliminarUsuarios(?)}";
//Preparamos la sentecia
            obj_Procedimiento = conexion.prepareCall(call);
//Envio uno por uno los parametros
            obj_Procedimiento.setInt(1, idUsuario);
            rpta = obj_Procedimiento.executeUpdate() == 1 ? true : false;

        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Imposible eliminar usuario, primero elimine los horarios que posea este usuario en el sistema ");
            desconectarBD();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Imposible eliminar usuario, primero elimine los horarios que posea este usuario en el sistema ");
            desconectarBD();
        }

        desconectarBD();
        return rpta;
    }
     public ResultSet buscarporid(int cedula)
    { 
       
      String sql = "SELECT * FROM tblusuarios "+
                "where idusuario = " +cedula+ "" ;
      System.out.println(sql);
        try {
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
    }
    
             public ResultSet likeTurno(String para, String name) {
       String sql = "SELECT u.idUsuario as Cedula,concat (u.nombre,' ',u.apellidos) as Nombre, u.usuario as Usuario, u.password as Contraseña, "+
               "t.tipo as TipoUsuario, u.email as Correo, telefono as Telefono FROM tblusuarios u inner join tbltipousuario t "
               +"on u.idtipousuario = t.idtipousuario "
               + "where   " +name+ " like '%"+para+"%'"  ;
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
