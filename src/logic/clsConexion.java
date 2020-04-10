/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ing. Gloriana Peña Ramírez
 */
public class clsConexion {
    //ATRIBUTOS DE LA CLASE CLSCONEXION
    protected Connection conexion;//Para hacer la conexión
    protected CallableStatement obj_Procedimiento;//Utilizar los procedure
    protected Statement stmt;//Hacer sentencias SQL
    protected ResultSet rs;//Guardar los resultados de las sentencias SQL
    //MÉTODOS PÚBLICOS DE LA CLASE CONEXCIONBD
    //Constructor default
    public clsConexion() {
        conexion=null;
        obj_Procedimiento=null;
    }//=========================================================================
    //Establece conexion a Oracle con el usuario y clave establecidos
    public void conectarBD() {
                try {//Se debe agregar la librería odbcd14.jar para poder correrlo
                    Class.forName("com.mysql.jdbc.Driver");
                    conexion = DriverManager.getConnection("jdbc:mysql://localhost/bd_codigobarras","root","");
                    System.out.println("Conexion exitosa");
                } catch (SQLException ex) {
                    System.out.println("Error al conectar " + ex.getMessage());
                } catch (ClassNotFoundException ex) {
                    System.out.println("Error al conectar 1 " + ex.getMessage());
                }                
    }//=========================================================================
    //Desconecta la conexion con Oracle y el usuario establecidos anteriormente
    public void desconectarBD() {
        try {
            if(conexion != null){
                conexion.close();
            System.out.println("Desconexion Exitosa");
            }
        } catch (SQLException ex) {
            System.out.println("Error al desconectar " + ex.getMessage());
            Logger.getLogger(clsConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//=========================================================================
    //MÉTODO ESPECIAL QUE PERMITE IMPRIMIR LOS RESULTADOS ESTABLECIDOS EN LAS 
    //CONSULTAS SQL EN LOS JTABLES DE LOS FORMULARIOS, EN FORMA GENERAL PARA 
    //CUALQUIER JTABLE Y CUALQUIER CONSULTA
    public DefaultTableModel cargarEnTabla(ResultSet rs) {
        DefaultTableModel modelo = new DefaultTableModel();
        ResultSetMetaData metaDatos;
        Object[] etiquetas;

        int numeroColumnas;
        try {
            metaDatos = rs.getMetaData();
            numeroColumnas = metaDatos.getColumnCount();
            etiquetas = new Object[numeroColumnas];
            // Se obtiene cada una de las etiquetas para cada columna
            for (int i = 0; i < numeroColumnas; i++) {
                // Nuevamente, para ResultSetMetaData la primera columna es la 1.
                etiquetas[i] = metaDatos.getColumnLabel(i + 1);
            }
            modelo.setColumnIdentifiers(etiquetas);
            while (rs.next()) {
                // Se crea un array que será una de las filas de la tabla.
                Object[] fila = new Object[numeroColumnas]; // Hay tres columnas en la tabla

                // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
                for (int i = 0; i < numeroColumnas; i++) {
                    fila[i] = rs.getObject(i + 1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.
                }
                // Se añade al modelo la fila completa.
                modelo.addRow(fila);
            }
        } catch (SQLException ex) {
            Logger.getLogger(clsConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modelo;
    }
    
      public ResultSet seleccionar(String sql) {
        try {
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
    }
    
    
    
    //=========================================================================
    //Método que ejecuta cualquier consulta select pasada por parametro
    public ResultSet ejecutarSQLSelect(String sql) {
        try {
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
    }//=========================================================================
    //Método que ejecuta cualquier sentencia de actualización(update, delete, 
    //insert) pasada por parametro.
    public void ejecutarSQL(String sql) {
        try {
            stmt = conexion.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }//=========================================================================
}
