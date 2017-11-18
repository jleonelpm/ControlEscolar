/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.table.TableColumn;
import Controladores.ctrlPagos;
import Entidades.Pagos;

/**
 *
 * @author leonel
 */
public class frmListaPagos extends java.awt.Dialog {

    Pagos p = new Pagos();
    ctrlPagos pago = new ctrlPagos();
    ArrayList<Pagos> lstPagos = new ArrayList<Pagos>();
    DefaultTableModel modelo;
    int fila = -1;
    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
    Date fechaInicial = new Date();
    Date fechaFinal = new Date();
    public static String comentarios;

    /**
     * Creates new form frmListaPagos
     */
    public frmListaPagos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        try {
            initComponents();
            this.dpFechaInicio.setFormats("dd-MM-yyyy");
            this.updateTabla();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmListaPagos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        dpFechaInicio = new org.jdesktop.swingx.JXDatePicker();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 12));
        jLabel1.setText("Listado de Pagos");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Datos del Ciclo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12))); // NOI18N

        jLabel3.setText("Fecha:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(25, 25, 25)
                .addComponent(dpFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(630, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(dpFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

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
        jScrollPane1.setViewportView(tabla);

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nuevo.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir.png"))); // NOI18N
        btnSalir.setText("Salir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 725, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnCancelar)
                    .addComponent(btnNuevo))
                .addContainerGap())
        );

        jPanel1.getAccessibleContext().setAccessibleName("Criterios de Búsqueda");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
// TODO add your handling code here:
        //this.limpiar();
        frmPagos pagos = new frmPagos(this, true);
        pagos.setLocationRelativeTo(null);
        pagos.setVisible(true);
        try {
            updateTabla();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmListaPagos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
// TODO add your handling code here:
        //eliminar();
        cancelarPago();
    }//GEN-LAST:event_btnCancelarActionPerformed

    public void updateTabla() throws ClassNotFoundException {

        try {

            modelo = new DefaultTableModel();
            modelo = pago.getPagos(pago.getPagos(0));
            tabla.setModel(modelo);


            //tabla.setModel(m);
            tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla.getColumnModel().getColumn(0).setMinWidth(0);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(0);

            TableColumn columna;

            columna = tabla.getColumn("Fecha");
            columna.setPreferredWidth(100);
            columna.setMinWidth(100);
            columna.setMaxWidth(100);

            columna = tabla.getColumn("id_alumno");
            columna.setPreferredWidth(0);
            columna.setMinWidth(0);
            columna.setMaxWidth(0);

            columna = tabla.getColumn("Importe");
            columna.setPreferredWidth(100);
            columna.setMinWidth(100);
            columna.setMaxWidth(100);

            columna = tabla.getColumn("id_personal");
            columna.setPreferredWidth(0);
            columna.setMinWidth(0);
            columna.setMaxWidth(0);

            columna = tabla.getColumn("status");
            columna.setPreferredWidth(70);
            columna.setMinWidth(70);
            columna.setMaxWidth(70);


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "error" + e.getMessage());
        }
    }

    public void cancelarPago() {
        int id_pago;
        fila = tabla.getSelectedRow();

        //No se puede cancelar una factura ya cancelada
        String status = String.valueOf(tabla.getValueAt(fila, 7));

        if (fila > -1 && !"X".equals(status)) {
            try {
                if (JOptionPane.showConfirmDialog(this, "¿Deseas cancelar el pago seleccionado?") == JOptionPane.YES_OPTION) {
                    frmComentarios frmcomentarios = new frmComentarios(this, true);
                    frmcomentarios.setLocationRelativeTo(this);
                    frmcomentarios.setVisible(true);

                    id_pago = Integer.parseInt(String.valueOf(tabla.getValueAt(fila, 0)));
                    int result = pago.cancelarPago(id_pago, comentarios);

                    if (result > 0) {
                        JOptionPane.showMessageDialog(this, "Los cambios fueron realizados exitosamente");
                        this.updateTabla();
                        comentarios = "";
                    } else {
                        JOptionPane.showMessageDialog(this, "El pago no pudo agregarse debido a un problema");
                    }

                }
            } catch (SQLException ex) {
                Logger.getLogger(frmListaPagos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(frmListaPagos.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                frmListaPagos dialog = new frmListaPagos(new java.awt.Frame(), true);
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
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private org.jdesktop.swingx.JXDatePicker dpFechaInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
