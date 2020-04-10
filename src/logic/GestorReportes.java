/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;

import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import javax.swing.JOptionPane;

/**
 *
 * @author INVENIO122
 */
public class GestorReportes extends clsConexion {
  
   public void cargarReporteporfecha(String fecha1, String fecha2,int id ) {

conectarBD();
JasperReport reporte;
JasperPrint reporte_view;
String alert = "";
try {
//direccion del archivo JASPER
URL in = this.getClass().getResource("/reportes/ReporteHorarios.jasper");
reporte = (JasperReport) JRLoader.loadObject(in);
String logotipo = "/Img/invenio.png";
//Se crea un objeto HashMap
Map parametros = new HashMap();
parametros.clear(); 
parametros.put("logo", this.getClass().getResourceAsStream(logotipo)); 
parametros.put("fecha1", fecha1); 
parametros.put("fecha2", fecha2);
parametros.put("cedula", id);
//-----------------------------------
reporte_view = JasperFillManager.fillReport(reporte, parametros, conexion);
JasperViewer.viewReport(reporte_view, false);

} catch (JRException ex) {
System.err.println(ex.toString());
JOptionPane.showMessageDialog(null,"Se ha producido un error, lo más problable es que el usuario no posee un horario establecido en ese rango de fecha ");
}

desconectarBD();
}
    
//  public void cargarReporteHorasTrabajadas(String fecha1, String fecha2,int id ) {
//
//conectarBD();
//JasperReport reporte;
//JasperPrint reporte_view;
//try {
////direccion del archivo JASPER
//URL in = this.getClass().getResource("/reportes/HorasTrabajadas.jasper");
//reporte = (JasperReport) JRLoader.loadObject(in);
//
//int extras = 0;
//String total="";
//String logotipo = "/Img/invenio.png";
//
////String tot = "jaja";
////String tota = tot.substring(0,1);
//
//rs = seleccionar("SELECT Left(SUM(horastrab),2) from tblcontrol where (DATE (fecha) BETWEEN STR_TO_DATE(' "+ fecha1 +" ' , '%Y-%m-%d')and STR_TO_DATE(' " +fecha2+ " ' , '%Y-%m-%d')) and idUsuario = "+id+"");
//    try {
//        if (rs.next()) {
//           total=rs.getString(1);
//        }
//    } catch (SQLException ex) {
//        Logger.getLogger(GestorReportes.class.getName()).log(Level.SEVERE, null, ex);
//    }
//           
//           if (Integer.parseInt(total) > 48){
//               
//           extras = Integer.parseInt(total) - 48;
//           total = Integer.toString(48);
//           }else { 
//               extras = 0;
//               
//           }
//   
////Se crea un objeto HashMap
//Map parametros = new HashMap();
//parametros.clear(); 
//parametros.put("logo", this.getClass().getResourceAsStream(logotipo)); 
//parametros.put("fecha1", fecha1); 
//parametros.put("fecha2", fecha2);
//parametros.put("cedula", id);
//parametros.put("total", total);
//parametros.put("extras", extras);
////-----------------------------------
//
//reporte_view = JasperFillManager.fillReport(reporte, parametros, conexion);
//JasperViewer.viewReport(reporte_view, false);
//
//} catch (JRException ex) {
//System.err.println(ex.toString());
//}
//desconectarBD();
//}   
    
    
    public void cargarReporteHoraTrabajada(String fecha1, String fecha2,int id ) {

conectarBD();
JasperReport reporte;
JasperPrint reporte_view;
try {
//direccion del archivo JASPER
URL in = this.getClass().getResource("/reportes/HorasTrabajadas.jasper");
reporte = (JasperReport) JRLoader.loadObject(in);

String extras = "";
String tota="";
String total = "";
String horas = "";
String minutos = "";
String logotipo = "/Img/invenio.png";
 

//String tot = "jaja";
//String tota = tot.substring(0,1);

rs = seleccionar("SELECT  SEC_TO_TIME(SUM(TIME_TO_SEC(horastrab))/ 60) from tblcontrol where (DATE (fecha) BETWEEN STR_TO_DATE(' "+ fecha1 +" ' , '%Y-%m-%d')and STR_TO_DATE(' " +fecha2+ " ' , '%Y-%m-%d')) and idUsuario = "+id+"");
    try {
        if (rs.next()) {
           tota=rs.getString(1);
            
           horas = tota.substring(3,5);
           minutos = tota.substring(6,8);
           total = horas + ":" + minutos;
//           JOptionPane.showInputDialog(horas);
//           JOptionPane.showInputDialog(minutos);
//            JOptionPane.showInputDialog(total);
        }
    } catch (SQLException ex) {
        Logger.getLogger(GestorReportes.class.getName()).log(Level.SEVERE, null, ex);
    }
           
           if (Integer.parseInt(horas) > 48){
               
           extras = Integer.parseInt(horas) - 48 + ":" + minutos;
//           horas = Integer.toString(48);
           total = "48" + ":" + "00";
           }else { 
               extras = "0";
               
           }
   
//Se crea un objeto HashMap
Map parametros = new HashMap();
parametros.clear(); 
parametros.put("logo", this.getClass().getResourceAsStream(logotipo)); 

parametros.put("fecha1", fecha1); 
parametros.put("fecha2", fecha2);
parametros.put("cedula", id);
parametros.put("total", total);
parametros.put("extras", extras);
//-----------------------------------

reporte_view = JasperFillManager.fillReport(reporte, parametros, conexion);
JasperViewer.viewReport(reporte_view, false);

} catch (JRException ex) {
    JOptionPane.showMessageDialog(null,"Se ha producido un error, lo más problable es que el empleado no posee horas acumuladas de trabajo en ese rango de fecha ");
System.err.println(ex.toString());
}
desconectarBD();

} 
    
    public void cargarReporte(String fecha1,String fecha2,int id) {
        String logo = "/Img/invenio.png";
        conectarBD();
        JasperReport reporte;
        JasperPrint reporte_view;
        try {
//direccion del archivo JASPER
            URL in = this.getClass().getResource("/reportes/rptReporte.jasper");
            reporte = (JasperReport) JRLoader.loadObject(in);

            
            
            
//Se crea un objeto HashMap
            Map parametros = new HashMap();
            parametros.clear();
            parametros.put("logo", this.getClass().getResourceAsStream(logo));
            parametros.put("fecha1", fecha1); 
parametros.put("fecha2", fecha2);
parametros.put("cedula", id);
//-----------------------------------
            reporte_view = JasperFillManager.fillReport(reporte, parametros, conexion);
            JasperViewer.viewReport(reporte_view, false);

        } catch (JRException ex) {
            System.err.println(ex.toString());
        }
        desconectarBD();
    }
    
    
    
}
