/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmPersonal.java
 *
 * Created on 08-dic-2011, 11:07:33
 */
package Formularios;
import java.awt.Dialog;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import Controladores.ctrlNivelesAcademico;
import Controladores.ctrlPersonal;
import Controladores.ctrlPuestos;
import Entidades.NivelesAcademico;
import Entidades.Personal;
import Entidades.Puestos;
import Utilerias.ArchivoUtils;
import Utilerias.ImageUtils;

/**
 *
 * @author Last Develop
 */
public class frmPersonal extends javax.swing.JDialog {
private ctrlNivelesAcademico ctrlnivel=new ctrlNivelesAcademico();
private ctrlPuestos ctrlpuesto=new ctrlPuestos();
private ArrayList<NivelesAcademico> listaniveles=null;
private ArrayList<Puestos> listapuestos=null;
private ArchivoUtils objarchivo =new ArchivoUtils();
private Personal personaaux=null;
private  int cambioImagen=0; //0 no cambio 1 si cambio

private String urlOrigen="";

    /** Creates new form frmPersonal */
    public frmPersonal(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
         this.NivelestoCombo();
        this.PuestostoCombo();
        this.dtFechancto.setFormats("dd-MM-yyyy");
    }

    public frmPersonal(Dialog owner, boolean modal, Personal objpersona) {
        super(owner, modal);
        initComponents();
        this.NivelestoCombo();
        this.PuestostoCombo();
        this.dtFechancto.setFormats("dd-MM-yyyy");
         this.setPersonal(objpersona);
    }
private boolean setPersonal(Personal objpersona)
    {
        boolean ispersona=false;
     if(objpersona!=null)
     {
         this.personaaux=objpersona;
       this.setPersonaToForm(objpersona);
       
       ispersona=true;
     }
     return ispersona;
    }
    
    private void setPersonaToForm(Personal objpersona)
    {
     this.lblidpersonal.setText(String.valueOf(objpersona.getIdPersonal()));
       this.lblidpersonal.setVisible(false);
       this.txtNombre.setText(objpersona.getNombre());
       
       this.txtFolio.setText(objpersona.getFolio());
       this.txtApepaterno.setText(objpersona.getApePaterno());
       this.txtApematerno.setText(objpersona.getApeMaterno());
       this.txtCedula.setText(objpersona.getCedulaPro());
       this.txtCorreo.setText(objpersona.getEmail());
       this.txtCelular.setText(objpersona.getCelular());
       this.dtFechancto.getEditor().setText(objpersona.getFechaToForm( objpersona.getFechaNcto()));
       this.txtTelefono.setText(objpersona.getTelefono());
       this.txtCurp.setText(objpersona.getCurp());
       this.txtEspecialidad.setText(objpersona.getEspecialidad());
       this.txtPerfil.setText(objpersona.getPerfil());
       this.txtInstitucion.setText(objpersona.getInstitucion());
       this.txtRfc.setText(objpersona.getRfc());
       this.txtCarrera.setText(objpersona.getCarrera());
       this.rbtnMasculino.setSelected(this.setSelecciona( objpersona.getSexo()));
       this.rbtnFemenino.setSelected(!this.setSelecciona( objpersona.getSexo()));
       this.chkActivo.setSelected(objpersona.getEstado());
       this.chkFrentegrupo.setSelected(objpersona.esFrenteGrupo());
       this.cmbNivel.setSelectedItem(objpersona.getNivelesAcademico().getDescripcion());
       this.cmbPuesto.setSelectedItem(objpersona.getPuestos().getDescripcion());
       if(objpersona.getFoto()!=null)
       {
       //this.txtFoto.setText(objpersona.getFoto());
       Image img=ImageUtils.setImageinImagePanel(objpersona.getUrlImagen(), this.jXImagePanel1.getHeight(),this.jXImagePanel1.getWidth() );
       
       if(img!=null)
       {
           this.jXImagePanel1.setImage(img);
       }
       }
       
    }
 private Personal setFormToPersonal()
{
    int opcion=0;
    Personal objpersonal=new Personal();
    int i=Integer.parseInt( this.lblidpersonal.getText());
    if(i==0)
        opcion=0;
    else
        opcion=1;
    
        objpersonal.setIdPersonal(i);
        
    objpersonal.setFolio(this.txtFolio.getText());
    objpersonal.setApePaterno(this.txtApepaterno.getText());
    objpersonal.setApeMaterno(this.txtApematerno.getText());
    objpersonal.setNombre(this.txtNombre.getText());
    objpersonal.setCurp(this.txtCurp.getText());
    objpersonal.setRfc(this.txtRfc.getText());
    objpersonal.setSexo(this.rbtnMasculino.isSelected());
    
    
    
    objpersonal.setFechaNcto(this.dtFechancto.getEditor().getText());
    objpersonal.setEmail(this.txtCorreo.getText());
    objpersonal.setCelular(this.txtCedula.getText());
    objpersonal.setTelefono(this.txtTelefono.getText()); 
    objpersonal.setCarrera(this.txtCarrera.getText());
    objpersonal.setEspecialidad(this.txtEspecialidad.getText());
    objpersonal.setPerfil(this.txtPerfil.getText());
    objpersonal.setCedulaPro(this.txtCedula.getText());
    objpersonal.setFrenteGrupo(this.chkFrentegrupo.isSelected());
    objpersonal.setEstado(this.chkActivo.isSelected());
    objpersonal.setInstitucion(this.txtInstitucion.getText());
    String dato=   this.cmbNivel.getSelectedItem().toString();
    NivelesAcademico objnivel=new NivelesAcademico();
    objnivel.setDescripcion(dato);
    dato=this.cmbPuesto.getSelectedItem().toString();
    Puestos objpuesto=new Puestos();
    objpuesto.setDescripcion(dato);
    
    objpersonal.setNivelesAcademico(this.ctrlnivel.getNivelAcademico(listaniveles, objnivel));
    objpersonal.setPuestos(this.ctrlpuesto.getPuestos(listapuestos, objpuesto));
    objpersonal.setUrlFotoOrigen(urlOrigen);
    objpersonal.setFoto(urlOrigen);
    
    /*
    if(opcion==1)
    {
        if(txtFoto.getText().trim().length()>0)
           {
            if(objarchivo.FileCopy(objarchivo.archivo,txtFoto.getText() ))
                objpersonal.setFoto(this.txtFoto.getText());
            else
            objpersonal.setFoto("");
            }
    }
    else
    {
    if(txtFoto.getText().trim().length()>0)
           {
            if(objarchivo.FileCopy(objarchivo.archivo,txtFoto.getText() ))
            {
                objpersonal.setFoto(this.txtFoto.getText());
                if(cambioImagen==1)
                {
                    if(opcion==1)
                    {
                        if(personaaux.getFoto()!=null && personaaux.getFoto().trim().length()>0)
                        {
                            ArchivoUtils obj=new ArchivoUtils();
                            //System.out.println( obj.eliminarArchivo(personaaux.getFoto()));
                            this.cambioImagen=0;
                        }
                    }
                }
            }
            else
            objpersonal.setFoto("");
            }
    
    }*/
   return objpersonal;  
}   
private void NivelestoCombo()
{ 
NivelesAcademico objnivel;
listaniveles=ctrlnivel.getNivelesAcademico();
    if(listaniveles!=null)
    {   
             
        this.cmbNivel.setModel(ctrlnivel.getComboModelo(listaniveles));
     }
}
private void PuestostoCombo()
{
Puestos objpuesto;
listapuestos=ctrlpuesto.getPuestos();
    if(listapuestos!=null)
    {
        
        
        
        for(int i=0;i<listapuestos.size();i++)
        {
          
          objpuesto=listapuestos.get(i);
          this.cmbPuesto.addItem(objpuesto.getDescripcion());
        }
     }
}

private boolean setSelecciona(char c)
{
 if (c=='M')
     return true;
 else
     return false;
}

private boolean esActivo(char a)
{
if(a=='A') return true;
else return false;
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
        tbdatos = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        rbtnMasculino = new javax.swing.JRadioButton();
        rbtnFemenino = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtFolio = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApepaterno = new javax.swing.JTextField();
        txtApematerno = new javax.swing.JTextField();
        txtCurp = new javax.swing.JTextField();
        txtRfc = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JFormattedTextField();
        txtTelefono = new javax.swing.JFormattedTextField();
        txtCelular = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        dtFechancto = new org.jdesktop.swingx.JXDatePicker();
        jLabel12 = new javax.swing.JLabel();
        txtFoto = new javax.swing.JTextField();
        btnFoto = new javax.swing.JButton();
        jXImagePanel1 = new org.jdesktop.swingx.JXImagePanel();
        lblidpersonal = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        chkFrentegrupo = new javax.swing.JCheckBox();
        jLabel19 = new javax.swing.JLabel();
        chkActivo = new javax.swing.JCheckBox();
        cmbPuesto = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtCarrera = new javax.swing.JTextField();
        txtEspecialidad = new javax.swing.JTextField();
        txtPerfil = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        txtInstitucion = new javax.swing.JTextField();
        cmbNivel = new javax.swing.JComboBox();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Folio:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Ape. Paterno:");

        jLabel4.setText("Ape. Materno:");

        jLabel5.setText("CURP:");

        jLabel6.setText("RFC:");

        jLabel7.setText("Correo:");

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        buttonGroup1.add(rbtnMasculino);
        rbtnMasculino.setSelected(true);
        rbtnMasculino.setText("Masculino");

        buttonGroup1.add(rbtnFemenino);
        rbtnFemenino.setText("Femenino");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbtnMasculino)
                    .addComponent(rbtnFemenino))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(rbtnMasculino)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtnFemenino, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.setText("Teléfono:");

        jLabel9.setText("Celular:");

        jLabel10.setText("Fecha Nacimiento:");

        txtFolio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFolioKeyReleased(evt);
            }
        });

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });

        txtApepaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtApepaternoKeyReleased(evt);
            }
        });

        txtApematerno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtApematernoKeyReleased(evt);
            }
        });

        txtCurp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCurpActionPerformed(evt);
            }
        });
        txtCurp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCurpKeyReleased(evt);
            }
        });

        jLabel11.setText("Sexo:");

        jLabel12.setText("Foto:");

        txtFoto.setEditable(false);

        btnFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/picture.png"))); // NOI18N
        btnFoto.setText("...");
        btnFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFotoActionPerformed(evt);
            }
        });

        jXImagePanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Foto", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        javax.swing.GroupLayout jXImagePanel1Layout = new javax.swing.GroupLayout(jXImagePanel1);
        jXImagePanel1.setLayout(jXImagePanel1Layout);
        jXImagePanel1Layout.setHorizontalGroup(
            jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 166, Short.MAX_VALUE)
        );
        jXImagePanel1Layout.setVerticalGroup(
            jXImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 179, Short.MAX_VALUE)
        );

        lblidpersonal.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel6))
                        .addGap(340, 340, 340))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGap(30, 30, 30)
                                                    .addComponent(jLabel12))
                                                .addComponent(jLabel10))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addGap(17, 17, 17)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel8))
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                            .addComponent(txtFoto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                            .addComponent(txtCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                            .addComponent(txtCelular, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnFoto))
                                    .addComponent(dtFechancto, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel1))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtFolio, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                                            .addComponent(txtNombre)
                                            .addComponent(txtApepaterno)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel4))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtApematerno)
                                            .addComponent(txtCurp)
                                            .addComponent(txtRfc, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)))
                        .addGap(59, 59, 59)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jXImagePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(lblidpersonal)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(71, 71, 71))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtApepaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtApematerno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtCurp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtRfc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(dtFechancto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFoto)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jXImagePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblidpersonal)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        tbdatos.addTab("Datos Personales", jPanel1);

        jLabel13.setText("Carrera:");

        jLabel14.setText("Especialidad:");

        jLabel15.setText("Perfil:");

        jLabel16.setText("Cédula Profesional:");

        jLabel17.setText("Institución:");

        jLabel18.setText("Frente a Grupo:");

        chkFrentegrupo.setSelected(true);
        chkFrentegrupo.setText("Si");

        jLabel19.setText("Activo:");

        chkActivo.setSelected(true);
        chkActivo.setText("Si");

        jLabel20.setText("Puesto:");

        jLabel21.setText("Nivel Académico:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21)
                    .addComponent(jLabel13)
                    .addComponent(jLabel17)
                    .addComponent(jLabel16)
                    .addComponent(jLabel18)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkFrentegrupo)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtInstitucion)
                        .addComponent(txtCedula)
                        .addComponent(txtPerfil)
                        .addComponent(chkActivo)
                        .addComponent(txtCarrera, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                        .addComponent(txtEspecialidad))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cmbNivel, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbPuesto, javax.swing.GroupLayout.Alignment.LEADING, 0, 174, Short.MAX_VALUE)))
                .addGap(381, 381, 381))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtInstitucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(chkFrentegrupo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(chkActivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(cmbPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(cmbNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(141, Short.MAX_VALUE))
        );

        tbdatos.addTab("Datos Académicos", jPanel2);

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nuevo.png"))); // NOI18N
        btnNuevo.setText("Nuevo");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar)
                .addContainerGap(407, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(tbdatos, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(23, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(476, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(tbdatos, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(46, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void txtFolioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFolioKeyReleased
 // TODO add your handling code here:
     int codigo=evt.getKeyCode();
     if(codigo>=KeyEvent.VK_0 && codigo<=KeyEvent.VK_9 )
     {
         evt.consume();
     }
    
         
     if(codigo>=KeyEvent.VK_A && codigo<=KeyEvent.VK_Z)
         evt.consume();
    
    if(evt.getKeyCode()==KeyEvent.VK_ENTER)
    {
     this.txtNombre.requestFocus();
     this.txtNombre.selectAll();
    }
    
}//GEN-LAST:event_txtFolioKeyReleased

private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
 // TODO add your handling code here:
    if(evt.getKeyCode()==KeyEvent.VK_ENTER)
    {
     this.txtApepaterno.requestFocus();
     
    }
}//GEN-LAST:event_txtNombreKeyReleased

private void txtApepaternoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApepaternoKeyReleased
 // TODO add your handling code here:
    if(evt.getKeyCode()==KeyEvent.VK_ENTER)
    {
     this.txtApematerno.requestFocus();
     
    }
}//GEN-LAST:event_txtApepaternoKeyReleased

private void txtApematernoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApematernoKeyReleased
 // TODO add your handling code here:
    if(evt.getKeyCode()==KeyEvent.VK_ENTER)
    {
     this.txtCurp.requestFocus();
     
    }
}//GEN-LAST:event_txtApematernoKeyReleased

private void txtCurpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCurpActionPerformed
 // TODO add your handling code here:
    
}//GEN-LAST:event_txtCurpActionPerformed

private void txtCurpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCurpKeyReleased
 // TODO add your handling code here:
    if(evt.getKeyCode()==KeyEvent.VK_ENTER)
    {
     this.txtRfc.requestFocus();
     
    }
}//GEN-LAST:event_txtCurpKeyReleased

private void btnFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFotoActionPerformed
 // TODO add your handling code here:
    JFileChooser openfile=new JFileChooser();
    int seleccion=openfile.showOpenDialog(this);
    if (seleccion==JFileChooser.APPROVE_OPTION)
     {
         
         Image foto=ImageUtils.setImageinImagePanel(openfile.getSelectedFile().toString(),this.jXImagePanel1.getHeight() , this.jXImagePanel1.getWidth());
         this.urlOrigen=openfile.getSelectedFile().toString();
         objarchivo.archivo=openfile.getSelectedFile().toString();
         if(foto!=null)
         {
             
            this.jXImagePanel1.setImage(foto);
            this.txtFoto.setText(openfile.getSelectedFile().getName());
            cambioImagen=1;
            
         }
         else
             JOptionPane.showMessageDialog(null,"Error al cargar el archivo","Aviso",JOptionPane.ERROR_MESSAGE,null);
    }
    
        
}//GEN-LAST:event_btnFotoActionPerformed

private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            // TODO add your handling code here:
               int r=JOptionPane.showConfirmDialog(this, "¿Desea Guardar los Cambios?");
               if(r==JOptionPane.YES_OPTION)
               {
               ctrlPersonal ctrlpersonal=new ctrlPersonal();
              Personal objpersona=this.setFormToPersonal();
               int i= ctrlpersonal.setPersonal(objpersona);
               
                if(i>0)
                {
                  this.setPersonal(objpersona);  
                  JOptionPane.showMessageDialog(this, "Los Cambios Se Han Guardado Con Éxito","Aviso",JOptionPane.INFORMATION_MESSAGE,null);
                  this.dispose();
                  
                }
              else 
                    JOptionPane.showMessageDialog(this, "El Personal no Pudo Guardarse debido a un Error","Aviso",JOptionPane.ERROR_MESSAGE,null);
               }
        } catch (SQLException ex) {
            //Logger.getLogger(frmPersonal.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "ERROR: "+ ex.getMessage(),"Aviso",JOptionPane.ERROR_MESSAGE,null );
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(frmPersonal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR: "+ ex.getMessage(),"Aviso",JOptionPane.ERROR_MESSAGE,null );
        }

       

}//GEN-LAST:event_btnGuardarActionPerformed

private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
 // TODO add your handling code here:
    if(this.personaaux!=null)
{
        ctrlPersonal ctrlpersona=new ctrlPersonal();
        int i=ctrlpersona.deletePersonal(personaaux);
        if(i>0)
       JOptionPane.showMessageDialog(this, "operación éxitosa");
   else
       JOptionPane.showMessageDialog(this, "operación érrónea");
}
}//GEN-LAST:event_btnEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(frmPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                frmPersonal dialog = new frmPersonal(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton btnFoto;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox chkActivo;
    private javax.swing.JCheckBox chkFrentegrupo;
    private javax.swing.JComboBox cmbNivel;
    private javax.swing.JComboBox cmbPuesto;
    private org.jdesktop.swingx.JXDatePicker dtFechancto;
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
    private org.jdesktop.swingx.JXImagePanel jXImagePanel1;
    private javax.swing.JLabel lblidpersonal;
    private javax.swing.JRadioButton rbtnFemenino;
    private javax.swing.JRadioButton rbtnMasculino;
    private javax.swing.JTabbedPane tbdatos;
    private javax.swing.JTextField txtApematerno;
    private javax.swing.JTextField txtApepaterno;
    private javax.swing.JTextField txtCarrera;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JFormattedTextField txtCelular;
    private javax.swing.JFormattedTextField txtCorreo;
    private javax.swing.JTextField txtCurp;
    private javax.swing.JTextField txtEspecialidad;
    private javax.swing.JTextField txtFolio;
    private javax.swing.JTextField txtFoto;
    private javax.swing.JTextField txtInstitucion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPerfil;
    private javax.swing.JTextField txtRfc;
    private javax.swing.JFormattedTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
