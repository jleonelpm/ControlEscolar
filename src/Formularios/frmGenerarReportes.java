/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmGenerarReportes.java
 *
 * Created on 16-abr-2012, 19:41:18
 */
package Formularios;

import Reportes.RediDS;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Controladores.ctrlCarreras;
import Controladores.ctrlCicloEscolar;
import Controladores.ctrlEscuela;
import Entidades.Carreras;
import Entidades.CicloEscolar;
import Entidades.Escuelas;
import Entidades.GruposCiclo;


import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import Controladores.ctrlAlumnosGrupo;
import Controladores.ctrlConfiguracion;
import Controladores.ctrlGeneraciones;
import Controladores.ctrlPersonal;
import Controladores.ctrlPlanes;
import Entidades.Alumnos;
import Entidades.AlumnosGrupo;
import Entidades.Configuracion;
import Entidades.Generaciones;
import Entidades.Personal;

/**
 *
 * @author Last Develop
 */
public class frmGenerarReportes extends javax.swing.JDialog {

    /** Creates new form frmGenerarReportes */
    
    
    public frmGenerarReportes(java.awt.Frame parent, boolean modal) throws SQLException, ClassNotFoundException {
        super(parent, modal);
        initComponents();
       ctrlCicloEscolar ctrlcicloescolar=new ctrlCicloEscolar();
       ArrayList<CicloEscolar> listaCiclos=  ctrlcicloescolar.getCiclos(0);
      this.cmbCicloEscolar.setModel(ctrlcicloescolar.getComboCiclos(listaCiclos));
        
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
        cmbCarreras = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbCicloEscolar = new javax.swing.JComboBox();
        cmbGrupos = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        btnGenerar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Configuración del Reporte"));

        cmbCarreras.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCarrerasItemStateChanged(evt);
            }
        });

        jLabel1.setText("Carrera:");

        jLabel2.setText("Ciclo Escolar:");

        cmbCicloEscolar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCicloEscolarActionPerformed(evt);
            }
        });

        jLabel3.setText("Semestre-Grupo:");

        btnGenerar.setText("Generar");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(22, 22, 22))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGenerar)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cmbGrupos, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbCicloEscolar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbCarreras, 0, 161, Short.MAX_VALUE)))
                .addContainerGap(322, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCicloEscolar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCarreras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(btnGenerar)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void cmbCicloEscolarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCicloEscolarActionPerformed
        try {
            // TODO add your handling code here:
               ctrlCarreras ctrlcarreras=new ctrlCarreras();
               ArrayList<Carreras> listaCarreras=ctrlcarreras.getCarreras(0);
              this.cmbCarreras.setModel(ctrlcarreras.getComboCarreras(listaCarreras));
        } catch (SQLException ex) {
            Logger.getLogger(frmGenerarReportes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmGenerarReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}//GEN-LAST:event_cmbCicloEscolarActionPerformed

private void cmbCarrerasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCarrerasItemStateChanged
}//GEN-LAST:event_cmbCarrerasItemStateChanged

private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        try {
            // TODO add your handling code here:
               ctrlEscuela ctrlescuelas=new ctrlEscuela();
              Escuelas escuela=ctrlescuelas.getEscuelas();
              
              Carreras carrera=(Carreras) this.cmbCarreras.getSelectedItem();
              String ruta=System.getProperty("user.dir");
              String archivo="";//=ruta+"\\src\\Reportes\\formatoREDI.jrxml";
               
                
                CicloEscolar ciclo=(CicloEscolar) this.cmbCicloEscolar.getSelectedItem();
                
                //ctrlGruposCiclo ctrlgruposciclo=new ctrlGruposCiclo();
                GruposCiclo grupociclo=(GruposCiclo) this.cmbGrupos.getSelectedItem();
                
                /*EL TIPO DE REPORTE */
                if(grupociclo.getSemestre()==1)
                {
                archivo=ruta+"\\src\\Reportes\\formatoREDI.jrxml";
                }
                else
                {
                  archivo=ruta+"\\src\\Reportes\\formatoREDI.jrxml";
                }
                
                ctrlConfiguracion ctrlconfiguracion=new ctrlConfiguracion();
                Configuracion configurar=ctrlconfiguracion.getConfiguracion(grupociclo.getIdCiclo()) ;
                
                ctrlPersonal ctrlpersonal=new ctrlPersonal();
                Personal director=ctrlpersonal.getDatosReporte("DIRECTOR DEL PLANTEL");
                Personal jefedpto=ctrlpersonal.getDatosReporte("JEFE DEL DEPARTAMENTO DE SERVICIOS ESCOLARES");
                
                
               
                ctrlGeneraciones ctrlgeneracion=new ctrlGeneraciones();
                Generaciones generacion= ctrlgeneracion.getGeneracionReporte(grupociclo.getIdGrupoCiclo());
                
                 //System.out.println(configurar);
                 
                //System.out.println( carrera.getIdCarrera());
                ctrlCarreras ctrlcarreras=new ctrlCarreras();
                Carreras carreraseleccionada=ctrlcarreras.getCarreraReporte(carrera.getIdCarrera());
                
                Map pars = new HashMap();
                pars.put("clavect", escuela.getClaveCt());
                pars.put("plantel","C.B.T.a No 87, Valladolid,Yuc.");
                pars.put("carrera", carrera.getNombre());
                pars.put("semestre",String.valueOf( grupociclo.getSemestre()));
                pars.put("grupo",String.valueOf(grupociclo.getGrupo()));
                pars.put("periodoescolar", ciclo.getPeriodo());
                pars.put("oficioautorizacion",carreraseleccionada.getNooficio()); //Esta pendiente el NUMERO DE OFICIO
                pars.put("generacion", generacion.getNombre()); //esta pendiente
                pars.put("director", director.getNombrecompleto());
                pars.put("subdirector", configurar.getSubdirectorenlace());
                pars.put("jefeservicios",jefedpto.getNombrecompleto());
                pars.put("directortecnico",configurar.getDirectortecnico());
                pars.put("areapropedeutica", "");
                //String ruta_1="\\\\192.168.1.1\\compartido\\cbta.jpg";
                //pars.put("foto", ruta_1);
                
             
                //System.out.println(carrera.getClave() + carrera.getNooficio());
                
                //Generaciones Necesito la clase generaciones
                
                //ArrayList<OfertaAcademica> listaOferta=  ctrloferta.getOfertaCiclo(grupociclo.getIdGrupoCiclo());
                 
                 Alumnos al=new Alumnos();
                 ctrlAlumnosGrupo ctrlalumnosgrupo=new ctrlAlumnosGrupo();
                 AlumnosGrupo alumnosgrupo=new AlumnosGrupo();
                 
                 alumnosgrupo.setId_carrera(carrera.getIdCarrera());
                 alumnosgrupo.setId_ciclo(ciclo.getIdCiclo());
                 alumnosgrupo.setId_grupo_ciclo(grupociclo.getIdGrupoCiclo());
                 
                 
                 ArrayList<Alumnos> listaAlumnos=ctrlalumnosgrupo.getListaAlumnosGrupo(alumnosgrupo);
                 
                pars.put("total_hombres",ctrlalumnosgrupo.getTotalhombres());
                pars.put("total_mujeres",ctrlalumnosgrupo.getTotalmujeres());
                 
                 
            RediDS ds=new RediDS();
            for (int i=0;i<listaAlumnos.size();i++)
            {
            ds.addOfertaAcademica(listaAlumnos.get(i));
            
            }
                
                
              //JRResultSetDataSource jrs=new JRResultSetDataSource(rs); //Pasamos el ResultSet al JasperResultSet
                     JasperDesign jasperDesign = JRXmlLoader.load(archivo); //Cargamos el reporte jrxml para generar el jasper
                     JasperReport jasper=JasperCompileManager.compileReport(jasperDesign); //Compilamos para generar el jasper
                     JasperPrint jasperprint=JasperFillManager.fillReport(jasper, pars,ds);
                     if(jasperprint.getPages().size()>0) //Vemos si el reporte tiene hojas (registros) sino no tiene caso abrir el visor
                       {
                           JasperViewer.viewReport(jasperprint,false);
                           
                            
                            
                        }
                        else
                        {
                        JOptionPane.showMessageDialog(null, "NO HAY REGISTROS"); 
                        }
             


        } catch (SQLException ex) {
            Logger.getLogger(frmGenerarReportes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmGenerarReportes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(frmGenerarReportes.class.getName()).log(Level.SEVERE, null, ex);
        }

    
}//GEN-LAST:event_btnGenerarActionPerformed
        
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
            java.util.logging.Logger.getLogger(frmGenerarReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmGenerarReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmGenerarReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmGenerarReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    frmGenerarReportes dialog = new frmGenerarReportes(new javax.swing.JFrame(), true);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(frmGenerarReportes.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(frmGenerarReportes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerar;
    private javax.swing.JComboBox cmbCarreras;
    private javax.swing.JComboBox cmbCicloEscolar;
    private javax.swing.JComboBox cmbGrupos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
