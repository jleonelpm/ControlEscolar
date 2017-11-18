/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmUsuarios.java
 *
 * Created on 5/02/2012, 02:58:42 PM
 */
package Formularios;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import Controladores.ctrlPersonal;
import Controladores.ctrlUsuarios;
import Entidades.Personal;
import Entidades.Usuarios;
import javax.swing.table.TableColumn;

/**
 *
 * @author leonel
 */
public class frmUsuarios extends javax.swing.JDialog {

    Usuarios usuario = new Usuarios();
    ctrlUsuarios cusuarios = new ctrlUsuarios();
    ArrayList<Usuarios> lstUsuarios = new ArrayList<Usuarios>();
    DefaultTableModel modelo;
    ctrlPersonal cpersonal = new ctrlPersonal();
    ArrayList<Personal> lstPersonal = new ArrayList<Personal>();
    private ctrlPersonal ctrlpersonal = new ctrlPersonal();
    int id_personal;
    int fila = -1;

    /** Creates new form frmUsuarios */
    public frmUsuarios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblIdUsuario = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        cmbPersonal = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 12));
        jLabel1.setText("Listado de Planes de Carrera");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Datos del Plan de Carrera", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12))); // NOI18N

        jLabel2.setText("Personal:");

        jLabel5.setText("Clave:");

        lblIdUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setText("Usuario:");

        cmbPersonal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPersonalActionPerformed(evt);
            }
        });

        jLabel4.setText("Contraseña:");

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 2, 11));
        jLabel6.setText("Permite relacionar a un usuario con un personal, la selección de este campo es opcional");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbPersonal, 0, 341, Short.MAX_VALUE)
                            .addComponent(txtPassword)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE))))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(lblIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(cmbPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nuevo.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        btnModificar.setText("Permisos");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir.png"))); // NOI18N
        btnSalir.setText("Salir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnModificar)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar)
                    .addComponent(btnSalir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
// TODO add your handling code here:
    int id_personal;
    fila = tabla.rowAtPoint(evt.getPoint());
    if (fila > -1) {

        lblIdUsuario.setText(String.valueOf(tabla.getValueAt(fila, 0)));
        txtUsuario.setText(String.valueOf(tabla.getValueAt(fila, 1)));
        id_personal = Integer.parseInt(String.valueOf(tabla.getValueAt(fila, 2)));
        Personal p = new Personal();
        p.setIdPersonal(id_personal);
        p.setNombre("hola");
        cmbPersonal.setSelectedItem(p);




        //id_personal = String.valueOf(tabla.getValueAt(fila, 2));
        //updateComboPersonal(p);
        //txtPassword.setText(String.valueOf(tabla.getValueAt(fila, 4)));

        //txtClave.setText(String.valueOf(tabla.getValueAt(fila, 1)));             


    }
}//GEN-LAST:event_tablaMouseClicked

private void cmbPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPersonalActionPerformed
// TODO add your handling code here:
    //if (p != null) {
    //    nombre.setText(String.valueOf(p.getIdPersona()));
    //}
}//GEN-LAST:event_cmbPersonalActionPerformed

private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
// TODO add your handling code here:
    this.limpiar();
}//GEN-LAST:event_btnNuevoActionPerformed

private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
// TODO add your handling code here:
    guardar();
}//GEN-LAST:event_btnGuardarActionPerformed

private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
// TODO add your handling code here:
    //eliminar();
    //int id_personal;
    fila = tabla.getSelectedRow();
    if (fila > -1) {

        Usuarios user = new Usuarios();
        user.setId_usuario(Integer.parseInt(String.valueOf(tabla.getValueAt(fila, 0))));
        user.setUsuario(String.valueOf(tabla.getValueAt(fila, 1)));
        //frmPermisosUsuario frmpermisos = new frmPermisosUsuario(this,true,user);


}//GEN-LAST:event_btnEliminarActionPerformed
    }
private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    try {
        // TODO add your handling code here:
        updateTabla();

        Personal personal = new Personal();
        personal.setIdPersonal(0);
        ArrayList<Personal> listapersonal = ctrlpersonal.getPersonal(personal);

        this.cmbPersonal.setModel(ctrlpersonal.getModeloCombo(listapersonal));


    } catch (ClassNotFoundException ex) {
        Logger.getLogger(frmUsuarios.class.getName()).log(Level.SEVERE, null, ex);
    }

}//GEN-LAST:event_formWindowOpened

private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
// TODO add your handling code here:

    if (!"".equals(lblIdUsuario.getText())) {
        Usuarios user = new Usuarios();
        user.setId_usuario(Integer.parseInt(this.lblIdUsuario.getText()));
        user.setUsuario(this.txtUsuario.getText());

        frmPermisos frmpermisos = new frmPermisos(this, true, user);
        frmpermisos.setLocationRelativeTo(this);
        frmpermisos.setVisible(true);
    }
}//GEN-LAST:event_btnModificarActionPerformed

private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_txtPasswordActionPerformed

    private void guardar() {
        try {
            if (validar()) {

                if (JOptionPane.showConfirmDialog(this, "¿Deseas guardar los cambios?") == JOptionPane.YES_OPTION) {

                    if ("".equals(lblIdUsuario.getText())) {
                        usuario.setId_usuario(0);
                    } else {
                        usuario.setId_usuario(Integer.parseInt(lblIdUsuario.getText()));
                    }

                    usuario.setUsuario(txtUsuario.getText());
                    String pass = new String(this.txtPassword.getPassword());
                    usuario.setPassword(pass);
                    usuario.setActivo("A");

                    Personal c = (Personal) cmbPersonal.getSelectedItem();
                    usuario.setPersonal(c);


                    int result = cusuarios.setUsuario(usuario);

                    if (result > 0) {
                        updateTabla();
                        limpiar();
                        JOptionPane.showMessageDialog(this, "Los cambios fueron realizados con éxito");
                    } else {
                        JOptionPane.showMessageDialog(this, "La cpersonal no pudo agregarse debido a un problema");
                    }// fin de if (result > 0)     
                } //fin de ¿Guardar los cambios?
            } //fin de validar
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "error" + e.getMessage());
        }
    }

    private void updateTabla() throws ClassNotFoundException {

        try {

            modelo = new DefaultTableModel();
            modelo = cusuarios.getUsuarios(cusuarios.getUsuarios(0));
            tabla.setModel(modelo);

            TableColumn columna;
            columna = tabla.getColumn("id_usuario");
            columna.setPreferredWidth(0);
            columna.setMinWidth(0);
            columna.setMaxWidth(0);
            columna = tabla.getColumn("id_personal");
            columna.setPreferredWidth(0);
            columna.setMinWidth(0);
            columna.setMaxWidth(0);

            columna = tabla.getColumn("Activo");
            columna.setPreferredWidth(50);
            columna.setMinWidth(50);
            columna.setMaxWidth(50);


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "error" + e.getMessage());
        }
    }

    private void updateComboPersonal(Personal p) {
        try {

            DefaultComboBoxModel modeloCombo;
            modeloCombo = new DefaultComboBoxModel();
            //modeloCombo.removeAllElements();
            modeloCombo = cpersonal.getModeloCombo(lstPersonal);
            cmbPersonal.setModel(modeloCombo);

            //this.cmbPersonal.setSelectedItem(p);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "error" + e.getMessage());
        }
    }

    private void limpiar() {
        lblIdUsuario.setText("");
        //updateComboPersonal(0);
        txtUsuario.setText("");
        txtPassword.setText("");
    }

    private boolean validar() {
        boolean result = false;



        if ("".equals(txtUsuario.getText())) {
            result = false;
            JOptionPane.showMessageDialog(this, "Escribe el nombre del usuario");
        } else {
            result = true;
        }

        if (txtUsuario.getText().contains(" ")) {
            result = false;
            JOptionPane.showMessageDialog(this, "El nombre del usuario no puede contener espacios en blanco");

        } else {
            result = true;
        }

        String pass = new String(this.txtPassword.getPassword());

        if ("".equals(lblIdUsuario.getText()) && "".equals(pass)) {
            result = false;
            JOptionPane.showMessageDialog(this, "Escribe la contraseña del usuario");
        } else {
            result = true;
        }


        return result;

    }

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
            java.util.logging.Logger.getLogger(frmUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                frmUsuarios dialog = new frmUsuarios(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cmbPersonal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIdUsuario;
    private javax.swing.JTable tabla;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}