/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Timer;
/**
 *
 * @author INVENIO122
 */
public class clsGestorJornada extends clsConexion {
    
    
     public boolean agregarjornada(clsJornadas jornada) {
        
         boolean rpta = false;
        try {
//Nos conectamos 
            conectarBD();
//Indica cual procedimiento almacenado
            String call = "{CALL guardarJornada(?,?,?)}";
//Preparamos la sentecia
            obj_Procedimiento = conexion.prepareCall(call);
//Envio uno por uno los parametros
            obj_Procedimiento.setString(1, jornada.getTiempo());
            
            obj_Procedimiento.setString(2, jornada.getHoraInicio());
            obj_Procedimiento.setString(3, jornada.getHoraSalida());
            
            rpta = obj_Procedimiento.executeUpdate() == 1 ? true : false;

        } catch (SQLException ex) {
            desconectarBD();

        } catch (Exception ex) {
            desconectarBD();
        }

        desconectarBD();
        return rpta;
    }
    
    
     
         public ResultSet cargarJornadas() {
try {
//Llama al procedure buscarTodasPersona
String call = "{CALL buscarJornadaTodo}";
//Preparamos la sentecia
obj_Procedimiento = conexion.prepareCall(call);
rs = obj_Procedimiento.executeQuery();

} catch (SQLException ex) {
desconectarBD();
}
return rs;
}
     
            public clsJornadas buscar(int idJornada) {
clsJornadas Tipo = null;
try {
//Nos conectamos 
conectarBD();
//Busca los datos del profesor
String call = "{CALL buscartipovehiculo(?)}";
//Preparamos la sentecia
obj_Procedimiento = conexion.prepareCall(call);
//Identificacion
obj_Procedimiento.setInt(1, idJornada);
rs = obj_Procedimiento.executeQuery();
if (rs.next()) { //Si lo encontro
Tipo = new clsJornadas();
Tipo.setIdJornada(rs.getInt(1));
Tipo.setTiempo(rs.getString(2));
Tipo.setHoraInicio(rs.getString(3));
Tipo.setHoraSalida(rs.getString(4));

}
desconectarBD();
} catch (SQLException ex) {
desconectarBD();
}
return Tipo;
}
         
     public ResultSet likeHoraInicio(int para, String name) {
       String sql = "SELECT  `idJornada` as ID, `tiempo` as TURNO, `horaInicio` as INICIO, `horaSalida` as SALIDA FROM tbljornadas "+
                "where  " +name+ "  = '"+para+"'"  ;
       System.out.println(sql);
        try {
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
    }
            
           public ResultSet likeHoraSalida(int para, String name) {
       String sql = "SELECT `idJornada` as ID, `tiempo` as TURNO, `horaInicio` as INICIO, `horaSalida` as SALIDA FROM tbljornadas "+
                "where  " +name+ "  = '"+para+"'"  ;
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
       String sql = "SELECT `idJornada` as ID, `tiempo` as TURNO, `horaInicio` as INICIO, `horaSalida` as SALIDA FROM tbljornadas "+
                "where   " +name+ " like '%"+para+"%'"  ;
       System.out.println(sql);
        try {
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
    }
               
 public boolean eliminar(int idJornada) {
boolean rpta = false;
try {
//Nos conectamos 
conectarBD();
//Indica cual procedimiento almacenado
String call = "{CALL eliminarJornada(?)}";
//Preparamos la sentecia
obj_Procedimiento = conexion.prepareCall(call);
//Envio uno por uno los parametros
obj_Procedimiento.setInt(1, idJornada);
rpta = obj_Procedimiento.executeUpdate() == 1 ? true : false;

} catch (SQLException ex) {
desconectarBD();

} catch (Exception ex) {
desconectarBD();
}

desconectarBD();
return rpta;
}
 
 public ResultSet buscarporid(int  idjornada)
    { 
       
      String sql = "SELECT * FROM tbljornadas "+
                "where idjornada= '" +idjornada+ "'" ;
      System.out.println(sql);
        try {
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
    }
 
     public void editarJornada(clsJornadas jornada) {
        try {
            //Llamar al procedimiento
            obj_Procedimiento = conexion.prepareCall("{call editarJornada(?,?,?,?)}");
            //Definir la Entradas o parametros (?) del Procedimiento Almacenado
          obj_Procedimiento.setInt (1, jornada.getIdJornada());
            obj_Procedimiento.setString(2, jornada.getTiempo());
            obj_Procedimiento.setString(3, jornada.getHoraInicio());
            obj_Procedimiento.setString(4, jornada.getHoraSalida());
            
            obj_Procedimiento.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
 
}
