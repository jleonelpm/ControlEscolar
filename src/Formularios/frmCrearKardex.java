/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmCrearKardex.java
 *
 * Created on 08-abr-2012, 1:52:33
 */
package Formularios;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Controladores.ModeloTablaKardex;
import Controladores.ctrlCicloEscolar;
import Controladores.ctrlGruposHistorialAcademico;
import Controladores.ctrlKardex;
import Controladores.ctrlOfertaAcademicaHistorial;
import Entidades.Alumnos;
import Entidades.Carreras;
import Entidades.CicloEscolar;
import Entidades.Grupos;
import Entidades.GruposCiclo;
import Entidades.Kardex;




/**
 *
 * @author Last Develop
 */
public class frmCrearKardex extends javax.swing.JDialog {
private Alumnos alumno;
 Carreras carrera=null;
 GruposCiclo grupo=null;

 
 
 
    public Alumnos getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumnos alumno) throws SQLException {
        try {
            this.alumno = alumno;
            System.out.println(this.alumno.getIdAlumno());
            this.lblMatricula.setText( this.alumno.getMatricula());
            this.lblNombre.setText(this.alumno.getApePaterno()+" " + this.alumno.getApeMaterno()+  " " + this.alumno.getNombre());
            ctrlKardex ctrlkardex=new ctrlKardex();
            if(ctrlkardex.getExisteKardex(alumno.getIdAlumno()))
            {
                int datos=ctrlkardex.getUltimoSemestreCursado(alumno.getIdAlumno());
                
                int semestre=datos;
                this.lblSemestre.setText(String.valueOf(semestre));
                
              //  ctrlGruposCiclo ctrlgrupos=new ctrlGruposCiclo();
                //carrera =new Carreras();
                if(semestre>1)
                {
                Carreras ca=ctrlkardex.getCarreraAlumno(semestre);
                this.lblCarrera.setText(ca.getNombre());
                }
                else
                {
                 this.lblCarrera.setText("BACHILLERATO TECNOLÓGICO");
                }
                 this.lblGrupo.setText(null);
            
            }
            else
            {
                this.lblCarrera.setText(null);
                this.lblGrupo.setText(null);
                this.lblSemestre.setText(null);
            }
                
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmCrearKardex.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }

    /** Creates new form frmCrearKardex */
    public frmCrearKardex(java.awt.Dialog parent, boolean modal) {
         super(parent, modal);
       // parent.setVisible(false);
        parent.dispose();
        initComponents();
        
      
        try {
           
            ctrlCicloEscolar ctrlciclo=new ctrlCicloEscolar();
            ArrayList<CicloEscolar> ciclos=ctrlciclo.getCiclos(0);
            this.cmbCicloEscolar.setModel(ctrlciclo.getComboCiclos(ciclos));
            
        } catch (SQLException ex) {
            Logger.getLogger(frmCrearKardex.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmCrearKardex.class.getName()).log(Level.SEVERE, null, ex);
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
        cmbCicloEscolar = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cmbGrupo = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableasignaturas = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
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
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Datos del Historial Académico", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        cmbCicloEscolar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCicloEscolarItemStateChanged(evt);
            }
        });

        jLabel4.setText("Ciclo Escolar:");

        jLabel10.setText("Grupos-Semestre-Carrera:");

        cmbGrupo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbGrupoItemStateChanged(evt);
            }
        });
        cmbGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbGrupoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbGrupo, 0, 280, Short.MAX_VALUE)
                    .addComponent(cmbCicloEscolar, 0, 280, Short.MAX_VALUE))
                .addGap(378, 378, 378))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbCicloEscolar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cmbGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Asignaturas Disponibles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 10))); // NOI18N

        jtableasignaturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtableasignaturas);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

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
                .addContainerGap(178, Short.MAX_VALUE))
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

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir.png"))); // NOI18N
        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel11.setText("1.-REGULAR, 2.-EXTRAORDINARIO,3.-INTERSEMESTRAL,4.-RECURSAMIENTO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(btnGuardar)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            /*VALIDAR LOS DATOS*/

               
               if(this.jtableasignaturas.getRowCount()>0)
               {
                ModeloTablaKardex modelo=(ModeloTablaKardex) this.jtableasignaturas.getModel();
                ctrlKardex ctrlkardex=new ctrlKardex();
                if(modelo.getListaKardex().size()>0)
                {
                    
                    int resp= JOptionPane.showConfirmDialog(this, "¿Desea Guardar los Cambios?");
                    if(resp==JOptionPane.YES_OPTION)
                    {
                        boolean r=ctrlkardex.setAsignaturasKardex(this.updateListaKardex());
            
                    if(r)
                    {
                        JOptionPane.showMessageDialog(this, "Los Cambios se Guardaron de Forma Exitosa");
                        this.dispose();
                    }
                    else
                        JOptionPane.showMessageDialog(this, "Los Cambios NO se Realizaron debido a un ERROR ");
                    }
                    
                }
               }
            else
                JOptionPane.showMessageDialog(this, "No hay datos por insertar");
                
            
        } catch (SQLException ex) {
            Logger.getLogger(frmCrearKardex.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,ex.getMessage());
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this,ex.getMessage());
            Logger.getLogger(frmCrearKardex.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,ex.getMessage());
            Logger.getLogger(frmCrearKardex.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
}//GEN-LAST:event_btnGuardarActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 // TODO add your handling code here:
      
                this.dispose();
}//GEN-LAST:event_jButton1ActionPerformed

private ArrayList<Kardex> updateListaKardex()
{
    ArrayList<Kardex> listakardex=new ArrayList<Kardex>();
  ModeloTablaKardex modelo=(ModeloTablaKardex) this.jtableasignaturas.getModel();
      ArrayList<Kardex> lista=modelo.getListaKardex();
      for (int i=0;i<lista.size();i++)
      {
          if(lista.get(i).isSeleccionado())
          {  
              lista.get(i).setId_alumno(alumno.getIdAlumno());
              if(lista.get(i).getPromedio()>6)
              {
                  lista.get(i).setAcreditado("S");
              }
              else
              {
                lista.get(i).setAcreditado("N");
              }
              if(lista.get(i).getId_oferta_academica()==null)
                  lista.get(i).setId_oferta_academica(0);
              
              listakardex.add(lista.get(i));
                //System.out.println(lista.get(i).toString());
          }
          
     
      }
      return listakardex;
}
private void cmbGrupoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbGrupoItemStateChanged
        try {
            // TODO add your handling code here:
                   CicloEscolar ciclo=(CicloEscolar) this.cmbCicloEscolar.getSelectedItem();
                   Grupos grupos=(Grupos) this.cmbGrupo.getSelectedItem();
                   ctrlOfertaAcademicaHistorial ctrlofehist=new ctrlOfertaAcademicaHistorial();
                   ArrayList<Kardex> listakardex= ctrlofehist.getOfertaCicloGrupo(grupos, ciclo);
                   if(listakardex!=null)
                   {
                       if(listakardex.size()>0)
                       {
                        ModeloTablaKardex m=ctrlofehist.getModeloOfertaHistorial(listakardex);
                        this.jtableasignaturas.setModel(m);
                       }
                   }
        
        } catch (SQLException ex) {
            Logger.getLogger(frmCrearKardex.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmCrearKardex.class.getName()).log(Level.SEVERE, null, ex);
        }
        
   
    
    
}//GEN-LAST:event_cmbGrupoItemStateChanged

private void cmbCicloEscolarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCicloEscolarItemStateChanged
        try {
            // TODO add your handling code here:
               
                CicloEscolar ciclo=(CicloEscolar) this.cmbCicloEscolar.getSelectedItem();
               //System.out.println("En CmbGrupo desde frmcrearkardex" + ciclo.getIdCiclo());
                ctrlGruposHistorialAcademico ctrlgrupos=new ctrlGruposHistorialAcademico();
                 ArrayList<Grupos> listagrupos= ctrlgrupos.getGruposporCiclo(ciclo.getIdCiclo());
                 this.cmbGrupo.setModel(   ctrlgrupos.getComboGruposInscripciones(listagrupos));
        } catch (SQLException ex) {
            Logger.getLogger(frmCrearKardex.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmCrearKardex.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}//GEN-LAST:event_cmbCicloEscolarItemStateChanged

private void cmbGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGrupoActionPerformed
 // TODO add your handling code here:
}//GEN-LAST:event_cmbGrupoActionPerformed
/*VALIDACIONES DE LOS DATOS **/



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
            java.util.logging.Logger.getLogger(frmCrearKardex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCrearKardex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCrearKardex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCrearKardex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                frmCrearKardex dialog = new frmCrearKardex(new javax.swing.JDialog(), true);
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
    private javax.swing.JComboBox cmbCicloEscolar;
    private javax.swing.JComboBox cmbGrupo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtableasignaturas;
    private javax.swing.JLabel lblCarrera;
    private javax.swing.JLabel lblGrupo;
    private javax.swing.JLabel lblMatricula;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSemestre;
    // End of variables declaration//GEN-END:variables
}