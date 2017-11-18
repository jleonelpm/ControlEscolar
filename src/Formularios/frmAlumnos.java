/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmAlumnos.java
 *
 * Created on 08-dic-2011, 7:58:35
 */
package Formularios;

import java.awt.Image;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import Controladores.ctrlAlumnos;
import Entidades.Alumnos;
import Utilerias.ArchivoUtils;
import Utilerias.ImageUtils;

/**
 *
 * @author Last Develop
 */
public class frmAlumnos extends javax.swing.JDialog {
private ctrlAlumnos ctrlalumno=new ctrlAlumnos();

private ArchivoUtils objarchivo =new ArchivoUtils();
private Alumnos alumnoaux=null;
private Alumnos objAlumno;
private int cambioImagen=0; //no cambio iamgen 1, si
 private JFileChooser openfile=null;

 private String rutaorigen="";

    /** Creates new form frmAlumnos */
    public frmAlumnos(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.dtfechancto.setFormats("dd-MM-yyyy");
       this.dtBaja.setFormats("dd-MM-yyyy");
       this.dtEgreso.setFormats("dd-MM-yyyy");
       this.dtIngreso.setFormats("dd-MM-yyyy");
       objAlumno=new Alumnos();
       this.txtMatricula.setText(objAlumno.getCalcularMatricula());
       this.txtFotografia.setEditable(false);
       this.txtFotografia.setEnabled(false);
       this.lblidalumno.setVisible(false);
    }
public frmAlumnos(java.awt.Dialog parent, boolean modal, Alumnos alumno) {
        super(parent, modal);
        initComponents();
        this.dtfechancto.setFormats("dd-MM-yyyy");
       this.dtBaja.setFormats("dd-MM-yyyy");
       this.dtEgreso.setFormats("dd-MM-yyyy");
       this.dtIngreso.setFormats("dd-MM-yyyy");
       this.setAlumnosToForm(alumno);
       this.txtFotografia.setEditable(false);
       this.txtFotografia.setEnabled(false);
       this.lblidalumno.setVisible(false);
    }
private void setAlumnosToForm(Alumnos alumno) 
 {
  this.alumnoaux=alumno;
  this.txtMatricula.setText(alumno.getMatricula().substring(0, 10));
  this.txtNumConsecutivo.setText(alumno.getMatricula().substring(10, 14));
  this.txtNombre.setText(alumno.getNombre());
  this.txtPaterno.setText(alumno.getApePaterno());
  this.txtMaterno.setText(alumno.getApeMaterno());
  this.txtCurp.setText(alumno.getCurp());
  this.txtDireccion.setText(alumno.getDireccion());
  this.txtLugarNcto.setText(alumno.getLugarNcto());
  this.txtPromedioSecundaria.setText(String.valueOf(alumno.getPromedioSecundaria())); 
  this.cmbSecundaria.setSelectedItem(alumno.getSecundariaProcedencia());
  //this.txtSecundaria.setText(alumno.getSecundariaProcedencia()); /*Pendiente este camnio*/
  this.cmbBeca.setSelectedItem(alumno.getBeca());
  this.txtTelefono.setText(alumno.getTelefono());
  this.txtTutor.setText(alumno.getTutor());
  
  if(alumno.getSeleccionaSexo())
    this.rbtnMasculino.setSelected( true);
  else
    this.rbtnFemenino.setSelected(true);
 
  this.dtfechancto.getEditor().setText(alumno.getFechaToForm( alumno.getFechaNcto()));
  
  //this.dtBaja.getEditor().setText(alumno.getFechaToForm( alumno.getFechaBaja()));
  this.cmbEstado.setSelectedItem(alumno.getEstado());
 this.cmbEstadoCivil.setSelectedItem(alumno.getEstadoCivil());
 if(alumno.getFechaBaja()!=null)
 {
 this.dtBaja.getEditor().setText(alumno.getFechaToForm( alumno.getFechaBaja()));
 
 }
 if(alumno.getFechaIngreso()!=null)
 {
 this.dtIngreso.getEditor().setText(alumno.getFechaToForm( alumno.getFechaIngreso()));
 
 }
 if(alumno.getFechaEgreso()!=null)
 {
 this.dtEgreso.getEditor().setText(alumno.getFechaToForm( alumno.getFechaEgreso()));
 
 }
 this.txtFichaMedica.setText(alumno.getFichaMedica());
 
 if(alumno.getFotografia()!=null || alumno.getFotografia().length()>0)
 {
     if(!alumno.getFotografia().isEmpty())
     {
     //System.out.println(alumno.getUrlFoto());  
        Image im=ImageUtils.loadImage(alumno.getUrlFoto());
        this.imgFoto.setImage(im);
     }
 }
 }

private Alumnos setFormToAlumno()
{
    char tipo;
 Alumnos alumno=new Alumnos();
 if(this.alumnoaux==null)
 {
     alumno.setIdAlumno(0);
     
  tipo='G';
 }
 else
 {
     
     tipo='A';
     alumno.setIdAlumno(this.alumnoaux.getIdAlumno());
     
 }
 if(this.txtNumConsecutivo.getText().trim().length()==4)//Matricula de 14
     alumno.setMatricula(this.txtMatricula.getText()+this.txtNumConsecutivo.getText());
 
 alumno.setApePaterno(this.txtPaterno.getText());
 alumno.setApeMaterno(this.txtMaterno.getText());
 alumno.setNombre(this.txtNombre.getText());
 alumno.setDireccion(this.txtDireccion.getText());
 if(this.dtfechancto.getEditor().getText().length()>0)
 {
    alumno.setFechaNcto( this.dtfechancto.getEditor().getText());
 }
 if(this.rbtnMasculino.isSelected())
    alumno.setSexo('M');
 else
     alumno.setSexo('F');
 
 alumno.setCurp(this.txtCurp.getText());
 alumno.setLugarNcto(this.txtLugarNcto.getText());
 alumno.setTelefono(this.txtTelefono.getText());
 alumno.setFotografia(this.txtFotografia.getText());
 alumno.setTutor(this.txtTutor.getText());
 alumno.setBeca(this.cmbBeca.getSelectedItem().toString());
 alumno.setEstadoCivil(this.cmbEstadoCivil.getSelectedItem().toString());
 alumno.setEstado(this.cmbEstado.getSelectedItem().toString());
 alumno.setFichaMedica(this.txtFichaMedica.getText());
 //alumno.setSecundariaProcedencia(this.txtSecundaria.getText());
 alumno.setSecundariaProcedencia(this.cmbSecundaria.getSelectedItem().toString());
 alumno.setPromedioSecundaria(this.txtPromedioSecundaria.getText());
 
 if(this.dtBaja.getEditor().getText().length()>0)
 {
     //JOptionPane.showMessageDialog(this, this.dtBaja.getEditor().getText());
     alumno.setFechaBaja(this.dtBaja.getEditor().getText());
 }
 
 alumno.setMotivoBaja(this.txtMotivo.getText());
 if(this.dtIngreso.getEditor().getText().length()>0)
 {
    alumno.setFechaIngreso(this.dtIngreso.getEditor().getText());
 }
 if(this.dtEgreso.getEditor().getText().length()>0)
 {
 alumno.setFechaEgreso(this.dtEgreso.getEditor().getText());
 }
 if(this.chkRepetidor.isSelected())
        alumno.setRepetidor('S');
 else
         alumno.setRepetidor('N');
 alumno.setFolio_certificado(this.txtFolioCertificado.getText());
 
 if(this.chkTitulado.isSelected())
 {
 alumno.setTitulado('S');
 }
 else
     alumno.setTitulado('N');
     
 String auxModoIngreso=this.cmbModoIngreso.getSelectedItem().toString();
 if(auxModoIngreso.equals("INGRESO"))
     alumno.setModo_ingreso('1');
 if(auxModoIngreso.equals("CAMBIO DE PLANTEL"))
     alumno.setModo_ingreso('2');
 if(auxModoIngreso.equals("PORTABILIDAD"))
     alumno.setModo_ingreso('3');
 
 alumno.setFotografia(rutaorigen);
 /*if(tipo=='G')
 {
  if(txtFotografia.getText().trim().length()>0)
    {
       if(this.rutaorigen.length()>0)
       {
       BufferedImage bf= ImageUtils.loadImage(rutaorigen);
       int i= Calendar.MILLISECOND;
       String nombre=this.txtPaterno.getText()+this.txtMaterno.getText()+String.valueOf(i);
       Utilerias.Configuracion conf=new Utilerias.Configuracion();
       nombre=  conf.getPropiedad("servidor.host")+"\\"+nombre+".jpg";
         ImageUtils.saveImage(bf, nombre) ;
       }
        
     if(objarchivo.FileCopy(objarchivo.archivo,txtFotografia.getText() ))
     {
         
         alumno.setFotografia(this.txtFotografia.getText());
     }
     else
         alumno.setFotografia("");
    }
 }
 else
 {
   //Hay que trare el alumno
 if(txtFotografia.getText().trim().length()>0)
    {
     if(objarchivo.FileCopy(objarchivo.archivo,txtFotografia.getText() ))
         alumno.setFotografia(this.txtFotografia.getText());
     else
         alumno.setFotografia("");
    }
 }*/
 //alumno.toString();
 return alumno;
 

}
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtPaterno = new javax.swing.JTextField();
        txtMaterno = new javax.swing.JTextField();
        txtLugarNcto = new javax.swing.JTextField();
        dtfechancto = new org.jdesktop.swingx.JXDatePicker();
        txtCurp = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        rbtnMasculino = new javax.swing.JRadioButton();
        rbtnFemenino = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        txtTutor = new javax.swing.JTextField();
        imgFoto = new org.jdesktop.swingx.JXImagePanel();
        jLabel10 = new javax.swing.JLabel();
        cmbEstadoCivil = new javax.swing.JComboBox();
        jLabel22 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JFormattedTextField();
        txtFotografia = new javax.swing.JTextField();
        btnExaminar = new javax.swing.JButton();
        lblidalumno = new javax.swing.JLabel();
        txtNumConsecutivo = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cmbBeca = new javax.swing.JComboBox();
        cmbEstado = new javax.swing.JComboBox();
        txtPromedioSecundaria = new javax.swing.JTextField();
        txtMotivo = new javax.swing.JTextField();
        dtIngreso = new org.jdesktop.swingx.JXDatePicker();
        dtBaja = new org.jdesktop.swingx.JXDatePicker();
        dtEgreso = new org.jdesktop.swingx.JXDatePicker();
        jLabel20 = new javax.swing.JLabel();
        chkRepetidor = new javax.swing.JCheckBox();
        jLabel23 = new javax.swing.JLabel();
        txtFolioCertificado = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        cmbModoIngreso = new javax.swing.JComboBox();
        jLabel25 = new javax.swing.JLabel();
        chkTitulado = new javax.swing.JCheckBox();
        cmbSecundaria = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtFichaMedica = new javax.swing.JTextArea();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Matricula:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Ape. Paterno:");

        jLabel4.setText("Ape. Materno:");

        jLabel5.setText("Fecha Ncto.:");

        jLabel6.setText("C.U.R.P:");

        jLabel11.setText("Sexo:");

        jLabel7.setText("Dirección:");

        jLabel8.setText("Lugar de Ncto.:");

        dtfechancto.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dtfechanctoPropertyChange(evt);
            }
        });

        buttonGroup1.add(rbtnMasculino);
        rbtnMasculino.setText("Masculino");

        buttonGroup1.add(rbtnFemenino);
        rbtnFemenino.setText("Femenino");

        jLabel9.setText("Tutor:");

        imgFoto.setBorder(javax.swing.BorderFactory.createTitledBorder("Foto"));

        javax.swing.GroupLayout imgFotoLayout = new javax.swing.GroupLayout(imgFoto);
        imgFoto.setLayout(imgFotoLayout);
        imgFotoLayout.setHorizontalGroup(
            imgFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 185, Short.MAX_VALUE)
        );
        imgFotoLayout.setVerticalGroup(
            imgFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 179, Short.MAX_VALUE)
        );

        jLabel10.setText("Estado Civil:");

        cmbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Soltero", "Casado", "Unión Libre" }));

        jLabel22.setText("Teléfono:");

        txtFotografia.setEditable(false);

        btnExaminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/picture.png"))); // NOI18N
        btnExaminar.setText("...");
        btnExaminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExaminarActionPerformed(evt);
            }
        });

        lblidalumno.setText("0");

        txtNumConsecutivo.setToolTipText("Consecutivo 4 digitos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(dtfechancto, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(9, 9, 9)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtNombre)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtNumConsecutivo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txtPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addComponent(jLabel11)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(rbtnMasculino)
                                        .addComponent(txtMaterno)
                                        .addComponent(rbtnFemenino))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtTutor)
                                .addComponent(txtCurp)
                                .addComponent(txtLugarNcto, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                                .addComponent(cmbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDireccion))
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(145, 145, 145)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblidalumno)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtFotografia, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnExaminar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(imgFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumConsecutivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbtnMasculino)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtnFemenino)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(dtfechancto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(imgFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtLugarNcto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFotografia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExaminar))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCurp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(lblidalumno))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81))
        );

        jTabbedPane1.addTab("Datos Personales", jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));

        jLabel12.setText("Beca:");

        jLabel13.setText("Estado:");

        jLabel14.setText("Secundaria Procedencia:");

        jLabel15.setText("Promedio Secundaria:");

        jLabel16.setText("Fecha de Baja:");

        jLabel17.setText("Motivo Baja:");

        jLabel18.setText("Fecha Egreso:");

        jLabel19.setText("Fecha Ingreso:");

        cmbBeca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NINGUNA", "PRONABES", "OPORTUNIDADES", "FEDERAL", "ESTATAL" }));

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ACTIVO", "BAJA TEMPORAL", "BAJA DEFINITIVA", "EGRESADO" }));

        jLabel20.setText("Repetidor:");

        chkRepetidor.setText("Si");

        jLabel23.setText("Folio Certificado:");

        txtFolioCertificado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFolioCertificadoActionPerformed(evt);
            }
        });

        jLabel24.setText("Modo Ingreso:");

        cmbModoIngreso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "INGRESO", "CAMBIO DE PLANTEL", "PORTABILIDAD" }));

        jLabel25.setText("Titulado:");

        chkTitulado.setText("Si");
        chkTitulado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkTituladoActionPerformed(evt);
            }
        });

        cmbSecundaria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01-SECUNDARIA TÉCNICA", "02-SECUNDARIA ESTATAL", "03-SECUNDARIA FEDERAL", "04-TELESECUNDARIA", "05-SECUNDARIA GENERAL (Antonio Mediz Bolio)", "06-SECUNDARIA ABIERTA", "07-SECUNDARIA PARTICULA", "08-INEA (INSTITUTO DE EDUCACIÓN PARA ADULTOS DEL ESTADO DE YUCATAN)" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel25)
                    .addComponent(jLabel16)
                    .addComponent(jLabel23)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(2, 2, 2))
                    .addComponent(jLabel18)
                    .addComponent(jLabel17)
                    .addComponent(jLabel24)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbSecundaria, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtFolioCertificado, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(dtEgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cmbEstado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbBeca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPromedioSecundaria, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dtIngreso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(dtBaja, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMotivo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(chkTitulado)
                            .addGap(585, 585, 585)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cmbModoIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(chkRepetidor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGap(360, 360, 360))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cmbBeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(cmbSecundaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtPromedioSecundaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(dtIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbModoIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(dtBaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(txtMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dtEgreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtFolioCertificado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(chkTitulado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkRepetidor)
                    .addComponent(jLabel20))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Datos Académicos", jPanel2);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, null));

        jLabel21.setText("Ficha Médica:");

        txtFichaMedica.setColumns(20);
        txtFichaMedica.setRows(5);
        jScrollPane1.setViewportView(txtFichaMedica);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(324, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addContainerGap(277, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Datos Médicos", jPanel3);

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nuevo.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btnNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGuardar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnExaminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExaminarActionPerformed
 // TODO add your handling code here:
    
     openfile=new JFileChooser();
    int seleccion=openfile.showOpenDialog(this);
    if (seleccion==JFileChooser.APPROVE_OPTION)
     {
         
         
         Image foto=ImageUtils.setImageinImagePanel(openfile.getSelectedFile().toString(),this.imgFoto.getHeight() , this.imgFoto.getWidth());
         rutaorigen=openfile.getSelectedFile().toString();
         objarchivo.archivo=openfile.getSelectedFile().toString();
         if(foto!=null)
         {
            this.imgFoto.setImage(foto);
            this.txtFotografia.setText(openfile.getSelectedFile().getName());
            this.cambioImagen=1;
         }
         else
             JOptionPane.showMessageDialog(null,"Error al cargar el archivo");
    }
}//GEN-LAST:event_btnExaminarActionPerformed

private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
 // TODO add your handling code here:
this.LimpiarForm();   
   
    
    
}//GEN-LAST:event_btnNuevoActionPerformed

private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            // TODO add your handling code here:
            if(this.txtNumConsecutivo.getText().length()==4 )
            {
             int r=  JOptionPane.showConfirmDialog(this,"¿Desea Guardar los Cambios?");
              if(r==JOptionPane.YES_OPTION)
              {
                  Alumnos al=setFormToAlumno();
                       int i=ctrlalumno.setAlumnos(al);
                  
               
             
               if(i>0)
               {
                   this.setAlumnosToForm(al);
                   this.LimpiarForm();
                JOptionPane.showMessageDialog(this, "Los Cambios Se Han Guardado Con Éxito","Aviso",JOptionPane.INFORMATION_MESSAGE,null);
               }
               else
               {
                   JOptionPane.showMessageDialog(this, "El Alumno No Pudo Guardarse debido a un Problema","Aviso",JOptionPane.INFORMATION_MESSAGE,null);
               }
                  
              }
        }
            else
            {
                JOptionPane.showMessageDialog(this, "El número consecutivo debe ser de 4 dígitos","Aviso",JOptionPane.INFORMATION_MESSAGE,null);
                
            }
        }//Fin del try
catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.toString());
            JOptionPane.showMessageDialog(this, "El Alumno No Pudo Guardarse Debido a un Problema ","Aviso",JOptionPane.ERROR_MESSAGE,null);
        } catch (ClassNotFoundException ex) {
           
        }

}//GEN-LAST:event_btnGuardarActionPerformed

private void txtFolioCertificadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFolioCertificadoActionPerformed
 // TODO add your handling code here:
}//GEN-LAST:event_txtFolioCertificadoActionPerformed

private void chkTituladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkTituladoActionPerformed
 // TODO add your handling code here:
}//GEN-LAST:event_chkTituladoActionPerformed

private void dtfechanctoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dtfechanctoPropertyChange
 // TODO add your handling code here:
    
}//GEN-LAST:event_dtfechanctoPropertyChange

private void LimpiarForm()
{
this.lblidalumno.setText("0");
this.txtNombre.setText("");
this.txtNumConsecutivo.setText("");
this.txtPaterno.setText("");
this.txtMaterno.setText("");
this.txtMatricula.setText("");
this.txtDireccion.setText("");
this.txtFichaMedica.setText("");
this.txtMotivo.setText("");
this.txtPromedioSecundaria.setText("");
this.cmbSecundaria.setSelectedIndex(0);
this.dtBaja.getEditor().setText("");
this.dtIngreso.getEditor().setText("");
this.dtEgreso.getEditor().setText("");
this.dtfechancto.getEditor().setText("");
this.chkRepetidor.setSelected(false);
this.chkTitulado.setSelected(false);
this.rbtnFemenino.setSelected(false);
this.rbtnMasculino.setSelected(false);
this.txtTelefono.setText("");
this.txtTutor.setText("");
this.imgFoto.setImage(null);

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
            java.util.logging.Logger.getLogger(frmAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                frmAlumnos dialog = new frmAlumnos(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton btnExaminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox chkRepetidor;
    private javax.swing.JCheckBox chkTitulado;
    private javax.swing.JComboBox cmbBeca;
    private javax.swing.JComboBox cmbEstado;
    private javax.swing.JComboBox cmbEstadoCivil;
    private javax.swing.JComboBox cmbModoIngreso;
    private javax.swing.JComboBox cmbSecundaria;
    private org.jdesktop.swingx.JXDatePicker dtBaja;
    private org.jdesktop.swingx.JXDatePicker dtEgreso;
    private org.jdesktop.swingx.JXDatePicker dtIngreso;
    private org.jdesktop.swingx.JXDatePicker dtfechancto;
    private org.jdesktop.swingx.JXImagePanel imgFoto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblidalumno;
    private javax.swing.JRadioButton rbtnFemenino;
    private javax.swing.JRadioButton rbtnMasculino;
    private javax.swing.JTextField txtCurp;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextArea txtFichaMedica;
    private javax.swing.JTextField txtFolioCertificado;
    private javax.swing.JTextField txtFotografia;
    private javax.swing.JTextField txtLugarNcto;
    private javax.swing.JTextField txtMaterno;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtMotivo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumConsecutivo;
    private javax.swing.JTextField txtPaterno;
    private javax.swing.JTextField txtPromedioSecundaria;
    private javax.swing.JFormattedTextField txtTelefono;
    private javax.swing.JTextField txtTutor;
    // End of variables declaration//GEN-END:variables
}
