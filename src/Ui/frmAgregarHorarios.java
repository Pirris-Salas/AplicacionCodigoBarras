/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ui;


//import static Ui.frmHorarios.tblHorarios;
import static Ui.frmHorarios.tblHorarios;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logic.clsGestorHorarios;
import logic.clsHorarios;

/**
 *
 * @author INVENIO122
 */
public class frmAgregarHorarios extends javax.swing.JFrame {
    clsGestorHorarios gestor;
     ResultSet rs;
     clsHorarios horarios;
     clsGestorHorarios gestorhora;
    /**
     * Creates new form frmAgregarHorarios
     */
    public frmAgregarHorarios() {
        initComponents();
        gestor = new clsGestorHorarios();
        horarios = new clsHorarios();
        gestorhora = new clsGestorHorarios();
        cargarEmpleados();
        cargarJornadas();
        rs = null;
         this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        dtpFecha = new com.toedter.calendar.JDateChooser();
        lblSalida = new javax.swing.JLabel();
        lblEntrada = new javax.swing.JLabel();
        lblEntrada1 = new javax.swing.JLabel();
        lblJornada = new javax.swing.JLabel();
        lblCedula = new javax.swing.JLabel();
        lblEmpleado1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        dtpFechaFinal = new com.toedter.calendar.JDateChooser();
        btnGuardar = new javax.swing.JButton();
        lblID = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cboJornada = new javax.swing.JComboBox();
        cboEmpleado = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestion de Horarios");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowDeactivated(java.awt.event.WindowEvent evt) {
                formWindowDeactivated(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " GESTION DE HORARIOS ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, null, new java.awt.Color(0, 255, 0)));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel1.setText("Cedula");

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel2.setText("Empleado");

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel3.setText("Jornada");

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel4.setText("Entrada");

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel6.setText("Salida");

        jLabel11.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel11.setText("Fecha Inicio");

        lblSalida.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N

        lblEntrada.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N

        lblEntrada1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N

        lblJornada.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N

        lblCedula.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N

        lblEmpleado1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel12.setText("Fecha Final");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(83, 83, 83)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEmpleado1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblJornada, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                                    .addComponent(lblEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(38, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblSalida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dtpFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dtpFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(139, 139, 139)
                    .addComponent(lblEntrada1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(318, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(lblCedula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmpleado1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(lblJornada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(dtpFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(dtpFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(137, 137, 137)
                    .addComponent(lblEntrada1)
                    .addContainerGap(176, Short.MAX_VALUE)))
        );

        btnGuardar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnGuardar.setText("Guardar Horario");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        lblID.setFont(new java.awt.Font("Tahoma", 0, 3)); // NOI18N
        lblID.setForeground(new java.awt.Color(51, 51, 51));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Seleccione el empleado y el turno deseados ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, null, new java.awt.Color(0, 255, 0)));

        cboJornada.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        cboJornada.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboJornadaItemStateChanged(evt);
            }
        });

        cboEmpleado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        cboEmpleado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboEmpleadoItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboJornada, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(cboEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(cboJornada, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblID)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGuardar))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addComponent(lblID))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboEmpleadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboEmpleadoItemStateChanged
    String selected;
       
        selected = cboEmpleado.getSelectedItem().toString();
       
        gestor.conectarBD();
         

            rs = gestor.likeEmpleado(selected);
         try {
            if (rs.next()) { //Si lo encuentra
                
                lblCedula.setText("" + rs.getInt("idusuario"));
                lblEmpleado1.setText(rs.getString("concat(nombre,' ',apellidos)"));
                
            } else {

                JOptionPane.showMessageDialog(rootPane, "El empleado no ha sido encontrado en el sistema.");
             
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        gestor.desconectarBD();
    }//GEN-LAST:event_cboEmpleadoItemStateChanged

    private void cboJornadaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboJornadaItemStateChanged
         String selected;
       
        selected = cboJornada.getSelectedItem().toString();
       
        gestor.conectarBD();
         

            rs = gestor.likeJornada(selected);
         try {
            if (rs.next()) { //Si lo encuentra
                
                lblJornada.setText(rs.getString("tiempo"));
                lblEntrada.setText(rs.getString("horainicio"));
                lblSalida.setText(rs.getString("horasalida"));
                lblID.setText(rs.getString("idjornada"));
                
            } else {

                JOptionPane.showMessageDialog(rootPane, "La jornada no se ha encontrado.");
             
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        gestor.desconectarBD();
    }//GEN-LAST:event_cboJornadaItemStateChanged

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
         
        
        if (validarBuscador().equals("")){
        java.sql.Date sqlDate = new java.sql.Date(dtpFecha.getDate().getTime());
         java.sql.Date sqlDates = new java.sql.Date(dtpFechaFinal.getDate().getTime());
          
         

          
        
        horarios = new clsHorarios();
horarios.setIdUusuario(Integer.parseInt(lblCedula.getText()));
horarios.setIdJornada(Integer.parseInt(lblID.getText()));
   horarios.setDate(sqlDate);
    horarios.setFechaFinal(sqlDates);
if (gestor.agregarhorario(horarios)) {
    
//  
//JOptionPane.showMessageDialog(rootPane,horarios.getDate());
JOptionPane.showMessageDialog(rootPane, "Datos guardados exitosamente");


} else {
JOptionPane.showMessageDialog(rootPane, "Error al intentar guardar, verifique que todos los campos estén llenos");
}

this.dispose();
 
        }else{
        JOptionPane.showMessageDialog(rootPane, validarBuscador());
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void formWindowDeactivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeactivated
        
           gestorhora.conectarBD();
        ResultSet sr = gestorhora.cargarHorarios();
        if (sr != null) {
            tblHorarios.setModel(gestorhora.cargarEnTabla(sr));

        }

        gestor.desconectarBD();
        
        
        
    }//GEN-LAST:event_formWindowDeactivated

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmAgregarHorarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAgregarHorarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAgregarHorarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAgregarHorarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAgregarHorarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox cboEmpleado;
    private javax.swing.JComboBox cboJornada;
    private com.toedter.calendar.JDateChooser dtpFecha;
    private com.toedter.calendar.JDateChooser dtpFechaFinal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblEmpleado1;
    private javax.swing.JLabel lblEntrada;
    private javax.swing.JLabel lblEntrada1;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblJornada;
    private javax.swing.JLabel lblSalida;
    // End of variables declaration//GEN-END:variables


 private void cargarEmpleados() {
        
        gestor.conectarBD();
       ResultSet rs = gestor.seleccionar("SELECT concat(nombre,' ',apellidos) FROM tblusuarios where idtipousuario = 2 ");
       
       if(rs!=null){
           try {
               while (rs.next()) {
                   cboEmpleado.addItem(rs.getString(1).toString());
               }
           } catch (SQLException ex) {
               gestor.desconectarBD();
               Logger.getLogger(frmAgregarHorarios.class.getName()).log(Level.SEVERE, null, ex);
           }
           
       }
       
       gestor.desconectarBD();
    }

private void cargarJornadas() {
        
        gestor.conectarBD();
       ResultSet rs = gestor.seleccionar("SELECT tiempo  FROM tbljornadas ");
       
       if(rs!=null){
           try {
               while (rs.next()) {
                   cboJornada.addItem(rs.getString(1).toString());
               }
           } catch (SQLException ex) {
               gestor.desconectarBD();
               Logger.getLogger(frmAgregarHorarios.class.getName()).log(Level.SEVERE, null, ex);
           }
           
       }
       
       gestor.desconectarBD();
    }


private String validarBuscador(){
String alert = "";

if (lblCedula.getText().equals("")) {
            alert += "Por favor seleccione al empleado que se le va asignar un nuevo horario \n";
        }
if (lblID.getText().equals("")){

alert += "Por favor seleccione el turno que desea asignarle al empleado "+" "+""+lblEmpleado1.getText()+"";
}

return alert;}
}