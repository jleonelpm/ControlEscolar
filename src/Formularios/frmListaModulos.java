/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmListaGrupos.java
 *
 * Crea ted on 5/02/2012, 01:07:28 PM
 */
package Formularios;

import Controladores.MyTableModel;
import Controladores.ctrlAsignaturas;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import Controladores.ctrlCarreras;
import Controladores.ctrlModulos;
import Entidades.Asignaturas;
import Entidades.Carreras;
import Entidades.Modulos;
import javax.swing.table.TableColumn;

/**
 *
 * @author leonel
 */
public class frmListaModulos extends javax.swing.JDialog {

    Asignaturas sm = new Asignaturas();
    ctrlAsignaturas submodulo = new ctrlAsignaturas();
    ArrayList<Asignaturas> lstSubmodulos = new ArrayList<Asignaturas>();
    DefaultTableModel modelo;
    int fila = -1;
    int id_carrera = 0;
    int id_modulo = 0;    
    int opcion = 0;

    /** Creates new form frmListaGrupos */
    public frmListaModulos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        updateComboCarreras();
        updateComboModulos();

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cmbCarrera = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        cmbModulo = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();
        btnOfertaAcademica = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Búsqueda por", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12))); // NOI18N

        jLabel3.setText("Carrera:");

        cmbCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCarreraActionPerformed(evt);
            }
        });

        jLabel14.setText("Módulo:");

        cmbModulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbModuloActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel3))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbModulo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbCarrera, 0, 243, Short.MAX_VALUE))
                .addContainerGap(443, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(cmbModulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 12));
        jLabel1.setText("Listado de Módulos y Submódulos");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir.png"))); // NOI18N
        btnSalir.setText("Salir");

        btnOfertaAcademica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ver_kardex.png"))); // NOI18N
        btnOfertaAcademica.setText("Unidades de Aprendizaje");
        btnOfertaAcademica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOfertaAcademicaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnOfertaAcademica)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnOfertaAcademica, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
// TODO add your handling code here:
        unidadesAprendizaje();
}//GEN-LAST:event_tablaMouseClicked

private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        this.updateTabla();
}//GEN-LAST:event_formWindowOpened

private void btnOfertaAcademicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOfertaAcademicaActionPerformed
// TODO add your handling code here:
    unidadesAprendizaje();
}//GEN-LAST:event_btnOfertaAcademicaActionPerformed

private void cmbCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCarreraActionPerformed
// TODO add your handling code here:
    filtrar();
}//GEN-LAST:event_cmbCarreraActionPerformed

private void cmbModuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbModuloActionPerformed
// TODO add your handling code here:
    filtrar();
}//GEN-LAST:event_cmbModuloActionPerformed

    private void updateTabla(){
        try {
            String[] titulos = {"id_asignatura","Carrera","Modulo", "Submódulo","Total U.A."};  
            // se utiliza la funcion
            ctrlModulos submodulo = new ctrlModulos();
            MyTableModel datos = new MyTableModel(submodulo.getSubModulos(id_modulo, id_carrera, opcion),titulos);
            tabla.setModel(datos);
            TableColumn columna;
            columna = tabla.getColumn("id_asignatura");                    
            columna.setPreferredWidth(0);
            columna.setMinWidth(0);
            columna.setMaxWidth(0);            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(frmCargaAcademicaDocentes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmCargaAcademicaDocentes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateComboCarreras() {
        ctrlCarreras carrera = new ctrlCarreras();
        ArrayList<Carreras> lstCarreras = new ArrayList<Carreras>();
        try {
            lstCarreras = carrera.getCarreras(0);
            DefaultComboBoxModel modeloCombo;
            modeloCombo = new DefaultComboBoxModel();
            modeloCombo.removeAllElements();
            modeloCombo = carrera.getComboCarreras(lstCarreras);
            cmbCarrera.setModel(modeloCombo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "error" + e.getMessage());
        }
    }
        
    private void updateComboModulos() {
        ctrlModulos modulo = new ctrlModulos();
        ArrayList<Modulos> lstModulos = new ArrayList<Modulos>();
        try {
            lstModulos = modulo.getModulos(0,id_carrera);
            DefaultComboBoxModel modeloCombo;
            modeloCombo = new DefaultComboBoxModel();
            modeloCombo.removeAllElements();
            modeloCombo = modulo.getComboModulos(lstModulos);
            cmbModulo.setModel(modeloCombo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "error" + e.getMessage());
        }
    }

    private void filtrar() {
        
        Carreras ca = (Carreras) cmbCarrera.getSelectedItem();
        if (ca != null) {
            id_carrera = ca.getIdCarrera();
        }
        
        Modulos mo = (Modulos) cmbModulo.getSelectedItem();
        if (mo != null) {
            id_modulo = mo.getIdModulo();
        }
        
        if (id_carrera == 0 && id_modulo == 0) {
            opcion = 0; //Todos los grupos            
        } else if (id_carrera != 0 && id_modulo == 0) {
            opcion = 1; //Los grupos de una generacion
        } else if (id_carrera != 0 && id_modulo != 0) {
            opcion = 2; //Los grupos de una generacion y carrera            
        }


        updateTabla();
    }

    private void unidadesAprendizaje() {
        fila = tabla.getSelectedRow();
        int id_submodulo;
        if (fila > -1) {
            try {
                id_submodulo = Integer.parseInt(String.valueOf(tabla.getValueAt(fila, 0)));
                //Obteniendo el objeto grupo con el ID seleccionado
                lstSubmodulos = submodulo.getAsignaturas(id_submodulo, 0, 0, 0, 9);
                sm = lstSubmodulos.get(0);

                //JOptionPane.showMessageDialog(this, sm.getNombre());
                
                frmUnidadesAprendizaje frmunidades = new frmUnidadesAprendizaje(this, true, sm);
                frmunidades.setLocationRelativeTo(this);
                frmunidades.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(frmListaModulos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(frmListaModulos.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

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
            java.util.logging.Logger.getLogger(frmListaModulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmListaModulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmListaModulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmListaModulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                frmListaModulos dialog = new frmListaModulos(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnOfertaAcademica;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cmbCarrera;
    private javax.swing.JComboBox cmbModulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}