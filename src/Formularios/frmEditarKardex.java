/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmEditarKardex.java
 *
 * Created on 17-abr-2012, 14:48:45
 */
package Formularios;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Controladores.ModeloEditarKardex;
import Controladores.ModeloTablaKardex;
import Controladores.ctrlKardex;
import Controladores.ctrlOfertaAcademicaHistorial;
import Entidades.Alumnos;
import Entidades.Carreras;
import Entidades.GruposCiclo;
import Entidades.Kardex;
import java.util.ArrayList;
import javax.swing.table.TableColumn;

/**
 *
 * @author Last Develop
 */
public class frmEditarKardex extends javax.swing.JDialog {
private Alumnos alumno;
private Carreras carrera=null;
private GruposCiclo grupo=null;

    /** Creates new form frmEditarKardex */
    public frmEditarKardex(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
 public void setAlumno(Alumnos al) throws SQLException, ClassNotFoundException
 {
 this.alumno=al;
 this.lblMatricula.setText(this.alumno.getMatricula());
 this.lblNombre.setText(this.alumno.getApeMaterno() + " " + this.alumno.getApeMaterno()+" " + this.alumno.getNombre());
 this.lblStatus.setText(this.alumno.getEstado());
 ctrlKardex ctrlka=new ctrlKardex();
 int maxsemestre=ctrlka.getUltimoSemestreCursado(this.alumno.getIdAlumno());
 this.cmbSemestre.addItem("Seleccione un Semestre");
 if(maxsemestre>1)
 {
    for(int i=0;i<=maxsemestre;i++)
    {
    this.cmbSemestre.addItem(i);
    }
    
    Carreras ca=ctrlka.getCarreraAlumno(maxsemestre);
    
    this.lblsemestre.setText(String.valueOf(maxsemestre));
    if(ca!=null)
        this.lblCarrera.setText(ca.getNombre());
 }
 else
 {   this.lblsemestre.setText(String.valueOf(maxsemestre));
     this.lblCarrera.setText("BACHILLERATO TECNOLÓGICO");
     this.cmbSemestre.addItem(1);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblMatricula = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblCarrera = new javax.swing.JLabel();
        cmbSemestre = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        lblsemestre = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Datos del Alumno"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Matricula:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLabel2.setText("Nombre:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel4.setText("Status:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        lblMatricula.setText("jLabel5");
        jPanel1.add(lblMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 150, -1));

        lblNombre.setText("jLabel6");
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 180, -1));

        lblStatus.setText("jLabel7");
        jPanel1.add(lblStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 190, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Datos Académicos"));

        jLabel3.setText("Carrera:");

        jLabel5.setText("Semestre:");

        lblCarrera.setText("jLabel7");

        cmbSemestre.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbSemestreItemStateChanged(evt);
            }
        });

        jLabel6.setText("Semestre Cursado:");

        lblsemestre.setText("jLabel7");

        jLabel7.setText("0: Todos los semestres cursados");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblsemestre))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(lblCarrera))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lblCarrera))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lblsemestre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cmbSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addContainerGap())))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("HISTORIAL DE ASIGNATURAS CURSADAS"));

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 902, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir.png"))); // NOI18N
        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setText("1.-REGULAR, 2.-EXTRAORDINARIO,3.-INTERSEMESTRAL,4.-RECURSAMIENTO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(208, 208, 208)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(btnGuardar)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            // TODO add your handling code here:
            if(this.jTable1.getRowCount()>0)
            {
            int res=JOptionPane.showConfirmDialog(this, "¿Desea Guardar los Cambios?");
            if(res==JOptionPane.YES_OPTION)
            {
              ModeloEditarKardex modelo=(ModeloEditarKardex) this.jTable1.getModel();
              ctrlKardex ctrlkardex=new ctrlKardex();
              boolean r=ctrlkardex.setAsignaturasKardex(modelo.getListaKardex());
              if(r)
              {
               JOptionPane.showMessageDialog(this,"Los Cambios se Guardaron de Forma Exitosa ");
               this.dispose();

              }
              else
              {
               JOptionPane.showMessageDialog(this,"NO se Pudieron Realizar Los Cambios Debido un ERROR","Aviso",JOptionPane.ERROR_MESSAGE);
              }
            }
            }
            else
            {
              JOptionPane.showMessageDialog(this,"NO Existen Datos por Agregar","Aviso",JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,ex.getMessage(),"Aviso",JOptionPane.ERROR_MESSAGE);
            //Logger.getLogger(frmEditarKardex.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this,ex.getMessage(),"Aviso",JOptionPane.ERROR_MESSAGE);
            //Logger.getLogger(frmEditarKardex.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_btnGuardarActionPerformed

private void cmbSemestreItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbSemestreItemStateChanged
 // TODO add your handling code here:
    if(this.cmbSemestre.getSelectedIndex()>0)
    {
            try {
                ctrlKardex ctrlkardex =new ctrlKardex();
                int semestre= Integer.parseInt( cmbSemestre.getSelectedItem().toString());
               
                ArrayList<Kardex> listaHistorial=new ArrayList<Kardex> ();
                
                
                
                listaHistorial=ctrlkardex.getHistorialKardex(this.alumno.getIdAlumno(), semestre);
                
                
                ModeloEditarKardex modelo=ctrlkardex.getModeloTablaHistorial(listaHistorial);
                if(modelo!=null){
                    
                    this.jTable1.setModel(modelo);
                    this.AnchoColumnas();
                    
                }
               
                
                
            } catch (SQLException ex) {
                Logger.getLogger(frmEditarKardex.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(frmEditarKardex.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
}//GEN-LAST:event_cmbSemestreItemStateChanged

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 // TODO add your handling code here:
this.dispose();
//this.LimpiarJTable();
   
}//GEN-LAST:event_jButton1ActionPerformed
private void AnchoColumnas()
{
 //this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
 this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(300);
 this.jTable1.getColumnModel().getColumn(1).setPreferredWidth(40);
 this.jTable1.getColumnModel().getColumn(2).setPreferredWidth(40);
 this.jTable1.getColumnModel().getColumn(3).setPreferredWidth(60);
}

void LimpiarJTable(){
    int a=this.jTable1.getModel().getRowCount()-1;
   ModeloEditarKardex m=(ModeloEditarKardex) this.jTable1.getModel();
   System.out.println("Tabla "+a);
   for(int i=0; i<a;i++){
      System.out.println("i "+i);
      m.removeRow(i );
      
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
            java.util.logging.Logger.getLogger(frmEditarKardex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmEditarKardex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmEditarKardex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmEditarKardex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                frmEditarKardex dialog = new frmEditarKardex(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox cmbSemestre;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCarrera;
    private javax.swing.JLabel lblMatricula;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblsemestre;
    // End of variables declaration//GEN-END:variables
}
