/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;


import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import logic.clsEmpleados;
import logic.clsGestorAdmin;
import logic.clsGestorHorarios;

/**
 *
 * @author Ivenio12
 */
public class infrmAgregar extends javax.swing.JInternalFrame {

      clsEmpleados empleados;
    clsGestorAdmin gestorAdmin;
    ResultSet rs;
    EditarUsuario editar;
     clsGestorHorarios gestorhora;
    public infrmAgregar() {
        initComponents();
        gestorhora = new clsGestorHorarios();
        gestorAdmin = new clsGestorAdmin();
        rs = null;
        editar = new EditarUsuario();
    }
 
    private String validarDatos() {
        String msg = "";

        if (tfID.getText().equals("")) {
            msg += "Por favor digite la identificacion del cliente\n";
        } else if (!IsNumero(tfID.getText())) {
            msg += "Por favor digite la identificacion del cliente solo con numeros\n";
        }
        if (tfNombre.getText().equals("")) {
            msg += "Por favor digite el nombre del usuario "+" "+""+tfID.getText()+"\n";
        }
         
        if (lbl.getText().equals("")) {
            msg += "Por favor seleccione el roll que va a desempeñar el usuario "+" "+""+tfNombre.getText()+"\n";
        }
        if (tfApellido.getText().equals("")) {
            msg += "Por favor digite los apellidos del usuario "+" "+""+tfNombre.getText()+"\n";
        }
        if (tfEmail.getText().equals("")) {
            msg += "Por favor digite el correo electronico del usuario "+" "+""+tfNombre.getText()+"\n";
        }else if (validateEmail(tfEmail.getText())==false) {
          msg += "Verifique el correo electronico ya que no coincide con el formato conocido \n";
        }
          
        if (tfTelefono.getText().equals("")) {
            msg += "Por favor digite el # de telefono del usuario "+" "+""+tfNombre.getText()+"\n";
        } else if (validateTelephone(tfTelefono.getText())==false) {
            msg += "Escriba el numero de telefono en el siguiente formato: xxxx-xxxx, no olvide el guión \n";
        }
        if (tfUser.getText().equals("")) {
            msg += "Por favor digite el nombre de la cuenta del usuario "+" "+""+tfNombre.getText()+"\n";
        }
        if (tfPass.getText().equals("")) {
            msg += "Por favor digite la contraseña del usuario "+" "+""+tfNombre.getText()+"\n";
        }
        return msg;
    }
//    private String ValorTipo(){
//    int valor = 0;
//    if (cboTipoUsuario == "Administrador"){
//    valor = 1;
//    }else{
//    valor = 2;
//    }
//    return valor;
//    }

    boolean IsNumero(String dato)
 {
        try {
            int num = Integer.parseInt(dato);
            return true;

        } catch (NumberFormatException ex) {
            return false;
        }
    }
    
    private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
 
 public static boolean validateEmail(String email) {
	try{
	    // Compiles the given regular expression into a pattern.
	    Pattern pattern = Pattern.compile(EMAIL_PATTERN);
	    // Match the given input against this pattern
	    Matcher matcher = pattern.matcher(email);
	    return matcher.matches();
	}catch(Exception e){
		e.printStackTrace();
	}
	return false;
}
     private static final String TELEPHONE_PATTERN = 
			"^([0-9]{4})*-"
             +          "[0-9]{4}$";
 
 public static boolean validateTelephone(String telephone) {
	try{
	    // Compiles the given regular expression into a pattern.
	    Pattern pattern = Pattern.compile(TELEPHONE_PATTERN);
	    // Match the given input against this pattern
	    Matcher matcher = pattern.matcher(telephone);
	    return matcher.matches();
	}catch(Exception e){
		e.printStackTrace();
	}
	return false;
}
 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuEdicion = new javax.swing.JPopupMenu();
        Editar = new javax.swing.JMenuItem();
        Eliminar = new javax.swing.JMenuItem();
        btnGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lbl = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        tvID = new javax.swing.JLabel();
        tfID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfApellido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cboTipoUsuario = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfTelefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfUser = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfPass = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        cboBuscar = new javax.swing.JComboBox();
        txtBuscar = new javax.swing.JTextField();

        Editar.setText("Editar");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });
        MenuEdicion.add(Editar);

        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        MenuEdicion.add(Eliminar);

        setClosable(true);
        setMaximizable(true);
        setTitle("Gestionar Usuarios");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.setComponentPopupMenu(MenuEdicion);
        jScrollPane1.setViewportView(jTable1);

        lbl.setFont(new java.awt.Font("Tahoma", 0, 3)); // NOI18N
        lbl.setText("");

        tvID.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        tvID.setText("Cedula:");

        tfID.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        tfID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIDActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel1.setText("Nombre:");

        tfNombre.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel2.setText("Apellido:");

        tfApellido.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel3.setText("Tipo de Usuario:");

        cboTipoUsuario.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        cboTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "  ","Administrador", "Empleado" }));
        cboTipoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTipoUsuarioActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel4.setText("Correo:");

        tfEmail.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel6.setText("Telefono:");

        tfTelefono.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel5.setText("Usuario:");

        tfUser.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel7.setText("Contraseña:");

        tfPass.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        tfPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(tvID)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfPass)
                    .addComponent(tfUser)
                    .addComponent(tfTelefono)
                    .addComponent(tfEmail)
                    .addComponent(tfNombre)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cboTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(tfApellido)
                    .addComponent(tfID)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(tvID))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cboTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel8.setText("Filtrar todos los(as) ");

        cboBuscar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Cedula", "Nombre", "Correo", "Telefono" }));

        txtBuscar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(cboBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 987, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbl))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(cboBuscar)
                            .addGap(1, 1, 1)))
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnGuardar)
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (validarDatos().equals("")) {
            empleados = new clsEmpleados();
            empleados.setIdUsuario(Integer.parseInt(tfID.getText()));
            empleados.setNombre(tfNombre.getText());
            empleados.setApellido(tfApellido.getText());
            empleados.setTipo(Integer.parseInt(lbl.getText()));
            empleados.setEmail(tfEmail.getText());
            empleados.setTelefono(tfTelefono.getText());
            empleados.setUsuario(tfUser.getText());
            empleados.setPassword(tfPass.getText());
            gestorAdmin.conectarBD();
            rs = gestorAdmin.buscarUsuario(Integer.parseInt(tfID.getText()));
            try {
                if (!rs.next()) {
                    gestorAdmin.guardarUsuario(empleados);
                    JOptionPane.showMessageDialog(rootPane, empleados.getNombre() + " ha sido almacenado.");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Identificación de usuario ya ingresado");
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        cargarDatos();
            gestorAdmin.desconectarBD();
        } else {
            JOptionPane.showMessageDialog(rootPane, validarDatos());
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
   cargarDatos();
   
    }//GEN-LAST:event_formInternalFrameOpened

    private void cboTipoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTipoUsuarioActionPerformed
        if (cboTipoUsuario.getSelectedItem() == "Administrador"){
        lbl.setText("1");
        }else{
        lbl.setText("2");
        }
    }//GEN-LAST:event_cboTipoUsuarioActionPerformed

    private void tfIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIDActionPerformed

    private void tfPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPassActionPerformed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        
         int selected = jTable1.getSelectedRow();
        boolean id1;
        String ids;
        int iden;
        boolean ss;
        id1 = editar.isShowing();
        if (id1==false) {
            if (jTable1.getSelectedRow()>-1) {

                ids=jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
                gestorAdmin.conectarBD();
                iden = Integer.parseInt(ids);
                rs = gestorAdmin.buscarporid(iden);
                try {
                    if (rs.next()) {
                        EditarUsuario.tfID.setText(ids);
                        editar.setVisible(true);
                       
                    } else{
                        JOptionPane.showMessageDialog(rootPane, "Por favor seleccione la cédula del usuario que desea editar en la tabla");
                    }

                } catch (HeadlessException | SQLException e) {
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Por favor seleccione la cédula del usuario que desea editar en la tabla");
            }

        }
        else {
            id1 = true;
        }
        
        
        
        
        
        
    }//GEN-LAST:event_EditarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
    
             if (jTable1.getSelectedRow()>-1){
    String id = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
    System.out.println(id);
            int resp = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro de eliminar el usuario "+id+ "?",
                "¡¡¡ADVERTENCIA!!!",JOptionPane.YES_NO_OPTION);
        if(resp == JOptionPane.YES_OPTION){
            
        
    
    gestorAdmin.eliminarUsuario(Integer.parseInt(id));
        cargarDatos();}
}
        
        
        
    }//GEN-LAST:event_EliminarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        
        
        String selected;
        String ps = "";
        selected = cboBuscar.getSelectedItem().toString();
        if (validarBuscador().equals("")) {
        if (selected == "Cedula"){
            ps= "idusuario";
        }
        if (selected == "Nombre"){
            ps= "nombre";
        }
        if (selected == "Correo"){
            ps= "email";
        }
         if (selected == "Telefono"){
            ps= "telefono";
        }
      
      
        gestorAdmin.conectarBD();
        String buscar;
        buscar = txtBuscar.getText();
        if (ps=="idusuario"){

            rs = gestorAdmin.likeTurno(buscar, ps);
        }
        if (ps=="nombre"){

            rs = gestorAdmin.likeTurno(buscar, ps);
        }
        if (ps=="email"){

            rs = gestorAdmin.likeTurno(buscar, ps);
        }
        if (ps=="telefono"){

            rs = gestorAdmin.likeTurno(buscar, ps);
        }

        jTable1.setModel(gestorAdmin.cargarEnTabla(rs));
        }else {
            JOptionPane.showMessageDialog(rootPane,validarBuscador());
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Editar;
    private javax.swing.JMenuItem Eliminar;
    private javax.swing.JPopupMenu MenuEdicion;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox cboBuscar;
    private javax.swing.JComboBox cboTipoUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1;
    private javax.swing.JLabel lbl;
    private javax.swing.JTextField tfApellido;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfID;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfPass;
    private javax.swing.JTextField tfTelefono;
    private javax.swing.JTextField tfUser;
    private javax.swing.JLabel tvID;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

    private void cargarDatos() {
          gestorAdmin.conectarBD();
        ResultSet rs = gestorAdmin.TodosUsuarios();
        if (rs != null) {
            jTable1.setModel(gestorAdmin.cargarEnTabla(rs));

        }

        gestorAdmin.desconectarBD();
    }
    
private String validarBuscador(){
String alert = "";

if (cboBuscar.getSelectedItem().toString().equals("")) {
            alert += "Por favor seleccione el criterio de busqueda \n";
        }


return alert;}

}
