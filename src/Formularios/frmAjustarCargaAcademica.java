/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmAjustarCargaAcademica.java
 *
 * Created on 02-jul-2012, 9:28:38
 */
package Formularios;

import Controladores.ModeloEditarInscripcion;
import Controladores.ctrlInscripciones;
import Entidades.Alumnos;
import Entidades.Inscripciones;
import Entidades.Usuarios;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Last Develop
 */
public class frmAjustarCargaAcademica extends javax.swing.JDialog {
private Usuarios sesion=null;
private Alumnos alum=null;
    private frmAjustarCargaAcademica(JDialog jDialog, boolean b) {
        
    }



    public Usuarios getSesion() {
        return sesion;
    }

    public void setSesion(Usuarios sesion) {
        this.sesion = sesion;
    }
    
    

    /** Creates new form frmAjustarCargaAcademica */
    public frmAjustarCargaAcademica(java.awt.Dialog parent, boolean modal, Alumnos alumno) {
        
        super(parent, modal);
        try {
            initComponents();
            this.lblNombre.setText(alumno.getApePaterno() + " " + alumno.getApeMaterno() + " " + alumno.getNombre());
            this.lblMatricula.setText(alumno.getMatricula());
            this.lblCarrera.setVisible(false);
            this.lblGrupo.setVisible(false);
            this.lblSemestre.setVisible(false);
           this.jLabel7.setVisible(false);
           this.jLabel8.setVisible(false);
           this.jLabel9.setVisible(false);
           this.alum=alumno;
           ctrlInscripciones ctrlins=new ctrlInscripciones();
           ModeloEditarInscripcion m= ctrlins.getCargaACademica(alumno.getIdAlumno());
           this.jTable1.setModel(m);
        } catch (SQLException ex) {
            Logger.getLogger(frmAjustarCargaAcademica.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmAjustarCargaAcademica.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblMatricula = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblCarrera = new javax.swing.JLabel();
        lblSemestre = new javax.swing.JLabel();
        lblGrupo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ajuste de Carga Académica ");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Datos del Alumno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel3.setText("Matricula:");

        jLabel6.setText("Nombre:");

        lblMatricula.setText("lblMatricula");

        lblNombre.setText("jLabel8");

        jLabel7.setText("Carrera:");

        jLabel8.setText("Grupo:");

        jLabel9.setText("Semestre:");

        lblCarrera.setText("jLabel10");

        lblSemestre.setText("jLabel10");

        lblGrupo.setText("jLabel11");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMatricula))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNombre)))
                .addGap(212, 212, 212)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSemestre)
                        .addGap(56, 56, 56)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(lblGrupo))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblMatricula)
                    .addComponent(jLabel7)
                    .addComponent(lblCarrera))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblNombre)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(lblSemestre)
                    .addComponent(lblGrupo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Detalles de la Inscripción", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 10))); // NOI18N

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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 731, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/add.png"))); // NOI18N
        btnAgregar.setText("Agregar...");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(15, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnAgregar)
                    .addComponent(btnSalir))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
 // TODO add your handling code here:
    
     int fila=       this.jTable1.getSelectedRow();
     if(fila>-1)
     {
       ModeloEditarInscripcion m=(ModeloEditarInscripcion) this.jTable1.getModel();
      Inscripciones ins=  m.getElementoOfertaAcademica(fila);
      if(ins!=null)
      {
        int r=JOptionPane.showConfirmDialog(this, "¿Desea Eliminar el Registro Seleccionado?");
        if(r==JOptionPane.YES_OPTION)
        {
                    try {
                        ctrlInscripciones ctrlinscripcion=new ctrlInscripciones();
                        if(ctrlinscripcion.eliminarInscripcion(ins))
                        {
                             JOptionPane.showMessageDialog(this, "Los Cambios se Guardaron de Forma Exitosa","Aviso",JOptionPane.INFORMATION_MESSAGE);
                             m.removeRow(fila); //Quila la fila de la tabla en la vista
                                                    
                        }
                        else
                        {
                         JOptionPane.showMessageDialog(this, "La Operación NO se Realizó debido a un ERROR","Aviso",JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(frmAjustarCargaAcademica.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(frmAjustarCargaAcademica.class.getName()).log(Level.SEVERE, null, ex);
                    }
         
        }
      }
     }
     else
         JOptionPane.showMessageDialog(this, "Seleccione un Registro","Aviso",JOptionPane.WARNING_MESSAGE);
}//GEN-LAST:event_btnEliminarActionPerformed

private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
 // TODO add your handling code here:
    this.dispose();
}//GEN-LAST:event_btnSalirActionPerformed

private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        try {
            // TODO add your handling code here:
               dlgMasOfertaAcademica dlg=new dlgMasOfertaAcademica(this,true,alum );
               dlg.setLocationRelativeTo(this);
               dlg.setVisible(true);
               ctrlInscripciones ctrlins=new ctrlInscripciones();
               ModeloEditarInscripcion m= ctrlins.getCargaACademica(alum.getIdAlumno());
               this.jTable1.setModel(m);
        } catch (SQLException ex) {
            Logger.getLogger(frmAjustarCargaAcademica.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmAjustarCargaAcademica.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}//GEN-LAST:event_btnAgregarActionPerformed

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
            java.util.logging.Logger.getLogger(frmAjustarCargaAcademica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAjustarCargaAcademica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAjustarCargaAcademica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAjustarCargaAcademica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                frmAjustarCargaAcademica dialog = new frmAjustarCargaAcademica(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCarrera;
    private javax.swing.JLabel lblGrupo;
    private javax.swing.JLabel lblMatricula;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSemestre;
    // End of variables declaration//GEN-END:variables
}
