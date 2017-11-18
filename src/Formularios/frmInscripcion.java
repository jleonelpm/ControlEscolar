/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmInscripcion.java
 *
 * Created on 18-jun-2012, 9:51:37
 */
package Formularios;

import Controladores.ModeloOfertaAsignaturas;
import Controladores.ctrlCicloEscolar;
import Controladores.ctrlGrupos;
import Controladores.ctrlInscripciones;
import Controladores.ctrlKardex;
import Controladores.ctrlOfertaAcademica;
import Entidades.Alumnos;
import Entidades.CicloEscolar;
import Entidades.DatosAcademicosReinscripcion;
import Entidades.Grupos;
import Entidades.OfertaAcademica;
import Entidades.Usuarios;
import Utilerias.ImageUtils;
import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Last Develop
 */
public class frmInscripcion extends javax.swing.JDialog {
private CicloEscolar cicloactivo=null;
private ctrlCicloEscolar ctrlcicloescolar=null;
private ctrlGrupos ctrlgrupos=null;
private ArrayList<Grupos> listagrupos=null;
private ctrlKardex ctrlkardex=new ctrlKardex();

private boolean esInscripcion=false;

private int modulos_reprobadas;
private int asignaturas_reprobadas;

private ctrlOfertaAcademica ctrlofertaacademica=null;
private Alumnos alumno;
private Usuarios usuario;


private int opcion; //Se utiliza para determinar si es inscripcion 1 o reinscripcion 2
 private DatosAcademicosReinscripcion dai=null;
 
    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
       // System.out.println(usuario.getId_usuario());
    }
    /** Creates new form frmInscripcion */
    public frmInscripcion(java.awt.Dialog parent, boolean modal) throws SQLException, ClassNotFoundException {
        
        
        super(parent, modal);
        initComponents();
        
      //setAlumno(Alumnos);
        this.jpasignaturas.setVisible(false);//Ocultamos las asignaturas
        
    }
 public void setAlumno(Alumnos al)   
 {
  if(al!=null)
  {
   this.alumno=al;
   //System.out.println(al.getIdAlumno() +  al.getNombre() + al.getMatricula());
   this.lblmatricula.setText(this.alumno.getMatricula());
   this.lblnombres.setText(this.alumno.getApePaterno() + " "+ this.alumno.getApeMaterno()+ " "+ this.alumno.getNombre());
   this.lblstatus.setText(this.alumno.getEstado());
  // Image imagen= new Image( this.alumno.getUrlFoto());
   if(alumno.getFotografia()!=null || alumno.getFotografia().length()>0)
 {
     if(!alumno.getFotografia().isEmpty())
     {
     //System.out.println(alumno.getUrlFoto());  
        Image im=ImageUtils.loadImage(alumno.getUrlFoto());
        this.jXImagePanel1.setImage(im);
     }
 }
   
    this.setInicializarControles();
  }
  else
      this.alumno=null;
 }
 /*
private void setDatosAlumno()
{
this.lblmatricula.setText(this.alumno.getMatricula());
this.lblnombres.setText(this.alumno.getApePaterno() + " "+ this.alumno.getApeMaterno()+ " "+ this.alumno.getNombre());

}*/

    private void setInicializarControles()
    {
        this.lblidgrupo.setVisible(false);
        try {
             esInscripcion=ctrlkardex.getExisteKardex(this.alumno.getIdAlumno()) ;
            //si es incripcion se ocultan los datos académicos
                //System.out.println(esInscripcion);
             this.lblmensaje.setVisible(false); //Ocultar el lbl para mensajer de error;
            if(this.esInscripcion==false)
            {
                this.jpacademicos.setVisible(false);
                opcion=1;/*para saber si trae grupos de primer semestre exclusivamente*/
                //this.setDatosAlumno();
            }
            else //Es reincripcion
            {
                opcion=2; //para saber si trae grupos superiores
                this.jpacademicos.setVisible(true);
               dai=ctrlkardex.getDatosAcademicos(alumno.getIdAlumno());
                if(dai!=null)
                {
                this.lblcarrera.setText(dai.getCarrera());
                this.lblsemestre.setText(String.valueOf( dai.getSemestre()));
                }
                else
                {
                    
                     
                    dai=new DatosAcademicosReinscripcion();
                dai.setCarrera("BACHILLERATO TECNOLÓGICO");
                dai.setSemestre(1);
                this.lblcarrera.setText("BACHILLERATO TECNOLÓGICO");
                this.lblsemestre.setText(String.valueOf(dai.getSemestre()));
                }
                this.modulos_reprobadas=ctrlkardex.getCantidadAsignaturasReprobados(alumno.getIdAlumno(), 1); //Modulos reprobados
                this.asignaturas_reprobadas=ctrlkardex.getCantidadAsignaturasReprobados(alumno.getIdAlumno(), 2); //Asignaturas reprobados
                
                this.lblmodulosreprobados.setText(String.valueOf(modulos_reprobadas));
                this.lblasignaturasreprobadas.setText(String.valueOf(asignaturas_reprobadas));
                
                
                //this.modulos_reprobadas=ctrlkardex.getCantidadReprobadas();
                
                
              
            }
            int semest= ctrlkardex.getUltimoSemestreCursado(alumno.getIdAlumno());
            this.lblsemestre.setText(String.valueOf(semest));
            ctrlcicloescolar=new ctrlCicloEscolar();
            cicloactivo=ctrlcicloescolar.getCicloActivo();
            ctrlgrupos=new ctrlGrupos();
            listagrupos= ctrlgrupos.getGruposInscripciones(opcion);
            
             this.cmbgrupo.setModel(ctrlgrupos.getComboGruposInscripciones(listagrupos));
            
        } catch (SQLException ex) {
            Logger.getLogger(frmInscripcion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmInscripcion.class.getName()).log(Level.SEVERE, null, ex);
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
        jXImagePanel1 = new org.jdesktop.swingx.JXImagePanel();
        jLabel1 = new javax.swing.JLabel();
        lblmatricula = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblnombres = new javax.swing.JLabel();
        jpacademicos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblsemestre = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblcarrera = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblmodulosreprobados = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblasignaturasreprobadas = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblstatus = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cmbgrupo = new javax.swing.JComboBox();
        jpasignaturas = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblasignaturas = new javax.swing.JTable();
        chkpagado = new javax.swing.JCheckBox();
        lblidgrupo = new javax.swing.JLabel();
        lblmensaje = new javax.swing.JLabel();
        btnguardar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inscripciones/Reinscripiones");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Datos del Alumno", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jXImagePanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Fotografia"));

        javax.swing.GroupLayout jXImagePanel1Layout = new javax.swing.GroupLayout(jXImagePanel1);
        jXImagePanel1.setLayout(jXImagePanel1Layout);
        jXImagePanel1Layout.setHorizontalGroup(
            jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 113, Short.MAX_VALUE)
        );
        jXImagePanel1Layout.setVerticalGroup(
            jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 109, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setText("Matricula:");

        lblmatricula.setText("123456789101112");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel3.setText("Nombre:");

        lblnombres.setText("nombres");

        jpacademicos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Datos Académicos", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setText("Semestre:");

        lblsemestre.setText("lblsemestre");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel4.setText("Carrera:");

        lblcarrera.setText("lblcarrera");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel5.setText("Módulos Reprobados:");

        lblmodulosreprobados.setText("jLabel6");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel6.setText("Asignaturas Reprobadas:");

        lblasignaturasreprobadas.setText("lblasignaturas");

        javax.swing.GroupLayout jpacademicosLayout = new javax.swing.GroupLayout(jpacademicos);
        jpacademicos.setLayout(jpacademicosLayout);
        jpacademicosLayout.setHorizontalGroup(
            jpacademicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpacademicosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpacademicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpacademicosLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblcarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblsemestre)
                        .addContainerGap(233, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpacademicosLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblmodulosreprobados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblasignaturasreprobadas)
                        .addGap(136, 136, 136))))
        );
        jpacademicosLayout.setVerticalGroup(
            jpacademicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpacademicosLayout.createSequentialGroup()
                .addGroup(jpacademicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblcarrera)
                    .addComponent(lblsemestre)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpacademicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblasignaturasreprobadas)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(lblmodulosreprobados))
                .addGap(20, 20, 20))
        );

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel9.setText("Status:");

        lblstatus.setText("status");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXImagePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jpacademicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblmatricula)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblnombres))
                            .addComponent(lblstatus))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jXImagePanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lblmatricula)
                            .addComponent(jLabel3)
                            .addComponent(lblnombres))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblstatus)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jpacademicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Datos de la Inscripción", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12)))); // NOI18N

        jLabel7.setText("Semestre-Grupo:");

        cmbgrupo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbgrupoItemStateChanged(evt);
            }
        });

        jpasignaturas.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Asignaturas Ofertadas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        tblasignaturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblasignaturas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblasignaturasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblasignaturas);

        javax.swing.GroupLayout jpasignaturasLayout = new javax.swing.GroupLayout(jpasignaturas);
        jpasignaturas.setLayout(jpasignaturasLayout);
        jpasignaturasLayout.setHorizontalGroup(
            jpasignaturasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpasignaturasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpasignaturasLayout.setVerticalGroup(
            jpasignaturasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpasignaturasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
        );

        chkpagado.setText("Presento Ficha de Pago");

        lblidgrupo.setText("jLabel8");

        lblmensaje.setFont(new java.awt.Font("Tahoma", 0, 10));
        lblmensaje.setForeground(new java.awt.Color(255, 153, 0));
        lblmensaje.setText("Mensaje");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbgrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblmensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(chkpagado))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jpasignaturas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(lblidgrupo)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbgrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblmensaje))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpasignaturas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(lblidgrupo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkpagado))
        );

        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar.png"))); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir.png"))); // NOI18N
        btncancelar.setText("Salir");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(btnguardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btncancelar)
                .addContainerGap(490, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnguardar)
                    .addComponent(btncancelar))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void cmbgrupoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbgrupoItemStateChanged
 // TODO add your handling code here:
    int tipo=0;
    Grupos grupo=(Grupos) this.cmbgrupo.getSelectedItem();
    //ctrlGrupos ctrlgrupos=new ctrlGrupos();
    //System.out.println(grupo.getIdGrupo() + "Se" + grupo.getSemestre());
    
    //this.lblidgrupo.setText(grupo.getIdGrupo().toString());
    if(grupo.getIdGrupo()!=null)
    {
      if(grupo.getIdGrupo()>0) //Verificamos que haya seleccionado un grupo
      {
          if(opcion==2) //Si es reinscripcion necesitamos verificar que se puede reinscribir
          {
              for (int i=0;i<listagrupos.size();i++)
              {
               if(listagrupos.get(i).getIdGrupo()==grupo.getIdGrupo())
               {
                grupo=listagrupos.get(i);
                break;
               }
              }
              tipo=this.getTipoReinscripcion(grupo.getSemestre());
             
              switch(tipo)    
              {
                  case -1: 
                      //JOptionPane.showMessageDialog(this, "No puede reinscribirse al siguiente semestre");
                      this.lblmensaje.setText("ERROR: No puede reinscribirse al siguiente semestre");
                      this.lblmensaje.setVisible(true);
                      this.btnguardar.setEnabled(false);
                      //this.tblasignaturas.setModel(null);
                      break;
                  case 0: 
                      //JOptionPane.showMessageDialog(this, "Error en los datos seleccionados");
                      this.lblmensaje.setText("ERROR: El semestre seleccionado no es el correcto");
                      this.lblmensaje.setVisible(true);
                      this.btnguardar.setEnabled(false);
                      //this.tblasignaturas.setModel(null);
                      break;
                  case 1:
                    //JOptionPane.showMessageDialog(this, "Se puede reinscribir al siguiente semestre");
                      this.lblmensaje.setVisible(false);
                      this.btnguardar.setEnabled(true);
                      getOfertaToTable( grupo,this.alumno.getIdAlumno(),this.modulos_reprobadas,this.asignaturas_reprobadas);
                      break;
                  case 2:
                      this.lblmensaje.setVisible(false);
                      this.btnguardar.setEnabled(true);
                      getOfertaToTable( grupo,  this.alumno.getIdAlumno(),this.modulos_reprobadas,this.asignaturas_reprobadas);
                      //JOptionPane.showMessageDialog(this, "Se puede reinscribir con Carga de recursamiento");
                      break;
                      
              }
             
                  
          }//fin de la opcion reinscripcion
          else // Es inscripcion no hay pex,,,,,
          {
              this.btnguardar.setEnabled(true);
              this.lblmensaje.setVisible(false);
          this.getOfertaToTable(grupo);
          }
                
      }
    }
}//GEN-LAST:event_cmbgrupoItemStateChanged
/*Para inscripcion y reinscripcion sin recursamiento*/
private void getOfertaToTable(Grupos grupo)
{
 try {
                    this.jpasignaturas.setVisible(true);
                    ctrlofertaacademica=new ctrlOfertaAcademica();
                  ArrayList<OfertaAcademica>listaOferta=  ctrlofertaacademica.getOfertaAcademica(grupo.getIdGrupo(),1); //Traemos la oferta del grupo opcion 1
                  //Debemos crear el modelo de AsignaturasInscripcion para enviarle la lista
                  ModeloOfertaAsignaturas modelo=ctrlofertaacademica.getOfertaInscripcion(listaOferta);
                  this.tblasignaturas.setModel(modelo);
                  this.lblidgrupo.setText(grupo.getIdGrupo().toString());
                  
                } catch (SQLException ex) {
                    Logger.getLogger(frmInscripcion.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(frmInscripcion.class.getName()).log(Level.SEVERE, null, ex);
                }

}
/*Para reinscripcion con Recursamiento*/
private void getOfertaToTable(Grupos grupo, int id_alumno, int _modulos_reprobadas,int _asignaturas_reprobadas)
{
 try {
                    this.jpasignaturas.setVisible(true);
                    ctrlofertaacademica=new ctrlOfertaAcademica();
                  ArrayList<OfertaAcademica>listaOferta=  ctrlofertaacademica.getOfertaAcademica(grupo, id_alumno, asignaturas_reprobadas, modulos_reprobadas); //Traemos la oferta del grupo opcion 1
                  //Debemos crear el modelo de AsignaturasInscripcion para enviarle la lista
                  ModeloOfertaAsignaturas modelo=ctrlofertaacademica.getOfertaInscripcion(listaOferta);
                  this.tblasignaturas.setModel(modelo);
                  this.lblidgrupo.setText(grupo.getIdGrupo().toString());
                  
                } catch (SQLException ex) {
                    Logger.getLogger(frmInscripcion.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(frmInscripcion.class.getName()).log(Level.SEVERE, null, ex);
                }

}

private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        try {
            // TODO add your handling code here:
              int r=  JOptionPane.showConfirmDialog(this,"¿Desea Guardar los Cambios?");
              if(r==JOptionPane.YES_OPTION)
              {
               ctrlInscripciones ctrlinscripciones=new ctrlInscripciones();
               ModeloOfertaAsignaturas modelo=(ModeloOfertaAsignaturas) this.tblasignaturas.getModel();
               Grupos grupo=(Grupos) this.cmbgrupo.getSelectedItem();
               boolean pagado=this.chkpagado.isSelected();
               boolean b=false;
               if(esInscripcion==false) //Llamamos al procedimiento de Inscripcion
               {    
                   b= ctrlinscripciones.setInscripciones(alumno, modelo,grupo,cicloactivo,usuario,pagado );
               
               }
               else
               {
                   /*ES REINSCRIPCION*/
                     b= ctrlinscripciones.setInscripciones(alumno, modelo,grupo,cicloactivo,usuario,pagado );
               }
               if(b)
               {
                   JOptionPane.showMessageDialog(this, "Los Cambios se Realizarón de Forma Exitosa");
                   this.dispose();
               }
               else
                   JOptionPane.showMessageDialog(this, "Los Cambios NO se Realizarón Debido a un ERROR");
              }
        } catch (SQLException ex) {
           // Logger.getLogger(frmInscripcion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            //Logger.getLogger(frmInscripcion.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_btnguardarActionPerformed

private void tblasignaturasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblasignaturasMouseClicked
 // TODO add your handling code here:
   ModeloOfertaAsignaturas m= (ModeloOfertaAsignaturas)  this.tblasignaturas.getModel();
OfertaAcademica o=    m.getElementoOfertaAcademica(1);
//System.out.println(o.getAsignatura().getModulo());
                
    
}//GEN-LAST:event_tblasignaturasMouseClicked

private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
 // TODO add your handling code here:
    this.dispose();
}//GEN-LAST:event_btncancelarActionPerformed
/**int tipo 1 reinscripcion con status activo, tipo 2 reinscripcion de una baja temporal, 
 * tipo -1 no puede reinscribirse al siguiente semestre
 */
private int getTipoReinscripcion(int semestre)
{
    int tipo=0;
    boolean puedeReinscribirse=false;
    ctrlInscripciones ctrlinscripcion=new ctrlInscripciones();
 if(alumno.getEstado().equals("ACTIVO"))
 {
     int semestremax=Integer.parseInt(this.lblsemestre.getText());
  if(semestre==(semestremax+1))
  {
    //Se va a reinscribir al siguiente semestre
      
      puedeReinscribirse=ctrlinscripcion.getSepuedeInscribir(this.asignaturas_reprobadas, this.modulos_reprobadas);
      if(puedeReinscribirse)
      {
            tipo=1; //Es al siguiente semestre y si puede reinscribirse
            
      }
      else
          tipo=-1; //No puede reinscribirse por que no cumple con los criterios de reinscripcion, debe ser de baja temporal
  }
  else
  {
      tipo=0; //Error en la seleccion de los datos debe ser al semestre siguiente
  }
 }
 else
 {
  if(alumno.getEstado().equals("BAJA TEMPORAL"))
  {
     if(semestre<=dai.getSemestre())
     {
      tipo=2;
     }
     else
     {
      tipo=0;//Error en la seleccion de los datos debe ser al semestre menor o igual al maximo cursado
     }
  }
 }
 return tipo;
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
            java.util.logging.Logger.getLogger(frmInscripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmInscripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmInscripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmInscripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    frmInscripcion dialog = new frmInscripcion(new javax.swing.JDialog(), true);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(frmInscripcion.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(frmInscripcion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JCheckBox chkpagado;
    private javax.swing.JComboBox cmbgrupo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXImagePanel jXImagePanel1;
    private javax.swing.JPanel jpacademicos;
    private javax.swing.JPanel jpasignaturas;
    private javax.swing.JLabel lblasignaturasreprobadas;
    private javax.swing.JLabel lblcarrera;
    private javax.swing.JLabel lblidgrupo;
    private javax.swing.JLabel lblmatricula;
    private javax.swing.JLabel lblmensaje;
    private javax.swing.JLabel lblmodulosreprobados;
    private javax.swing.JLabel lblnombres;
    private javax.swing.JLabel lblsemestre;
    private javax.swing.JLabel lblstatus;
    private javax.swing.JTable tblasignaturas;
    // End of variables declaration//GEN-END:variables
}
