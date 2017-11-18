/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmEscuela.java
 *
 * Created on 08-dic-2011, 12:25:41
 */
package Formularios;
import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import Controladores.ctrlEntidades;
import Controladores.ctrlEscuela;
import Controladores.ctrlPersonal;
import Controladores.ctrlTipoPlantel;
import Entidades.Entidades;
import Entidades.Escuelas;
import Entidades.Personal;
import Entidades.TipoPlantel;
import Utilerias.ArchivoUtils;
import Utilerias.ImageUtils;
/**
 *
 * @author Last Develop
 */
public class frmEscuela extends javax.swing.JDialog {
private ctrlTipoPlantel ctrltipo=new ctrlTipoPlantel();
private Escuelas escuela=null;
private ctrlEscuela ctrlescuelas=new ctrlEscuela();
private int cambio=0;
private ArchivoUtils objarchivo =new ArchivoUtils();

private ctrlPersonal ctrlpersonal=new ctrlPersonal();


private String auxclavect="";
/** Creates new form frmEscuela */
    public frmEscuela(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        ArrayList<TipoPlantel> lista=ctrltipo.getTipoPlantel();
        this.cmbTipoplantel.setModel(this.ctrltipo.getModeloCombo(lista)); 
        
        ctrlEntidades ctrlentidades=new ctrlEntidades();
        ArrayList<Entidades> listaen= ctrlentidades.getListaEntidades();
         this.cmbEntidades.setModel(ctrlentidades.getModeloCombo(listaen));
         Personal personal=new Personal();
         personal.setIdPersonal(0);
         ArrayList<Personal> listapersonal=ctrlpersonal.getPersonal(personal);
         
         this.cmbDirector.setModel(ctrlpersonal.getModeloCombo(listapersonal));
        
        escuela=ctrlescuelas.getEscuelas();
        if(escuela!=null)
        {
         this.setEscuelaToForm(escuela);
           
            
        }
    }
private void setEscuelaToForm(Escuelas escuela)
{

    Entidades c=new Entidades();
    TipoPlantel t=new TipoPlantel();  
    Personal director=new Personal();
 this.txtClavect.setText(escuela.getClaveCt());
            this.txtNombre.setText(escuela.getNombre());
            this.txtNumero.setText(escuela.getNumero());
            this.txtClavect.setText(escuela.getClaveCt());
            this.txtDireccion.setText(escuela.getDireccion());
            this.txtLogotipo.setText(escuela.getLogotipo());
            
            this.txtTelefono.setText(escuela.getTelefono());
            this.txtCorreo.setText(escuela.getCorreo());
            t=escuela.getTipoPlantel();
            
            c=escuela.getLugarEntidad();
            
            director=escuela.getDirector();
            
            //System.out.println( director.getNombre());
            
            this.cmbTipoplantel.setSelectedItem(t);
            this.cmbEntidades.setSelectedItem(c);
            this.cmbDirector.setSelectedItem(director);
            if(this.txtLogotipo.getText().length()>0)
            {
            
                String url= escuela.getUrlLogotipo();
              //  System.out.println(url);
                this.imgLogotipo.setImage(  ImageUtils.setImageinImagePanel(url,this.imgLogotipo.getHeight(),this.imgLogotipo.getWidth()));
            }
}

private Escuelas setFormToEscuela(Escuelas obj)
{
    int bandera=0;
    Escuelas objetoEscuela=new Escuelas();
    if(obj==null)
    {
     objetoEscuela.setIdEscuela(0);
     
    }
    else
    {    bandera=1;
            objetoEscuela.setIdEscuela(obj.getIdEscuela());
    }
    
    
     
     objetoEscuela.setNombre(this.txtNombre.getText());
     objetoEscuela.setNumero(this.txtNumero.getText());
     objetoEscuela.setClaveCt(this.txtClavect.getText());
     objetoEscuela.setDireccion(this.txtDireccion.getText());
     Entidades ent=(Entidades) this.cmbEntidades.getSelectedItem();
     TipoPlantel tipo=(TipoPlantel) this.cmbTipoplantel.getSelectedItem();
     Personal director=(Personal) this.cmbDirector.getSelectedItem();
     
     //System.out.println("Datos de la entidad" + ent.getClave() + ent.getEntidad());
     objetoEscuela.setLugarEntidad(ent);
     objetoEscuela.setTipoPlantel(tipo);
     objetoEscuela.setTelefono(this.txtTelefono.getText());
     objetoEscuela.setCorreo(this.txtCorreo.getText());
     objetoEscuela.setDirector(director);
     
        if(bandera==0)  //Esta cargando un nuevo registro
        {
         if(txtLogotipo.getText().trim().length()>0)
           {
            if(objarchivo.FileCopy(objarchivo.archivo,txtLogotipo.getText() ))
                objetoEscuela.setLogotipo(this.txtLogotipo.getText());
            else
            objetoEscuela.setLogotipo("");
            }
        }
        else //Esta actualizando;
        {
         if(cambio==1) //Cambio la imagen
         {
         if(txtLogotipo.getText().trim().length()>0)
           {
            if(objarchivo.FileCopy(objarchivo.archivo,txtLogotipo.getText() ))
            {
                objetoEscuela.setLogotipo(this.txtLogotipo.getText());
                //Falta ver que elimine
                cambio=0;
            }
           }
         }
         else //Sino cambio la imagen
              
         
         {
          objetoEscuela.setLogotipo(this.escuela.getLogotipo());
         }
        }
        return objetoEscuela;
            
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        txtClavect = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JFormattedTextField();
        txtCorreo = new javax.swing.JFormattedTextField();
        cmbTipoplantel = new javax.swing.JComboBox();
        txtLogotipo = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cmbEntidades = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        cmbDirector = new javax.swing.JComboBox();
        btnGuardar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        imgLogotipo = new org.jdesktop.swingx.JXImagePanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Plantel", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), java.awt.Color.black)); // NOI18N

        jLabel1.setText("Nombre:");

        jLabel2.setText("Dirección:");

        jLabel3.setText("Clave C.T:");

        jLabel4.setText("Teléfono:");

        jLabel5.setText("Correo:");

        jLabel6.setText("Logotipo:");

        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreFocusLost(evt);
            }
        });

        jLabel7.setText("Tipo de Plantel:");

        txtClavect.setEditable(false);

        cmbTipoplantel.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTipoplantelItemStateChanged(evt);
            }
        });

        txtLogotipo.setEditable(false);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/picture.png"))); // NOI18N
        btnBuscar.setText("...");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel8.setText("Número:");

        txtNumero.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNumeroFocusLost(evt);
            }
        });

        jLabel9.setText("Entidad:");

        cmbEntidades.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEntidadesItemStateChanged(evt);
            }
        });

        jLabel10.setText("Director:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel10)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                        .addComponent(cmbDirector, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNombre)
                        .addComponent(txtCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtClavect, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbTipoplantel, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbEntidades, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtLogotipo, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(btnBuscar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbEntidades)
                    .addComponent(jLabel9))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTipoplantel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtClavect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cmbDirector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtLogotipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addComponent(btnBuscar))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        imgLogotipo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout imgLogotipoLayout = new javax.swing.GroupLayout(imgLogotipo);
        imgLogotipo.setLayout(imgLogotipoLayout);
        imgLogotipoLayout.setHorizontalGroup(
            imgLogotipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 182, Short.MAX_VALUE)
        );
        imgLogotipoLayout.setVerticalGroup(
            imgLogotipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 176, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgLogotipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgLogotipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(201, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(btnGuardar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void cmbTipoplantelItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTipoplantelItemStateChanged
 // TODO add your handling code here:
  
   // this.txtClavect.setText( tipo.getAbreviatura());
 
    
    
}//GEN-LAST:event_cmbTipoplantelItemStateChanged

private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
 // TODO add your handling code here:
     JFileChooser openfile=new JFileChooser();
    int seleccion=openfile.showOpenDialog(this);
    if (seleccion==JFileChooser.APPROVE_OPTION)
     {
         
         Image foto=ImageUtils.setImageinImagePanel(openfile.getSelectedFile().toString(),this.imgLogotipo.getHeight() , this.imgLogotipo.getWidth());
         objarchivo.archivo=openfile.getSelectedFile().toString();
         if(foto!=null)
         {
             
            this.imgLogotipo.setImage(foto);
            this.txtLogotipo.setText(openfile.getSelectedFile().getName());
            cambio=1;
            
         }
         else
             JOptionPane.showMessageDialog(null,"Error al cargar el archivo");
    }
    
}//GEN-LAST:event_btnBuscarActionPerformed

private void cmbEntidadesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEntidadesItemStateChanged
 // TODO add your handling code here:
 
            
    
    
}//GEN-LAST:event_cmbEntidadesItemStateChanged

private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            // TODO add your handling code here:
               
               
           ctrlEscuela ctrl=new ctrlEscuela();   
           Escuelas ob=this.setFormToEscuela(escuela);
            int i=ctrl.setEscuela(ob);
               if(i>0)
               {
               JOptionPane.showMessageDialog(this, "Exito");
               }
               
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "ERROR: " + ex.getMessage());
            //Logger.getLogger(frmEscuela.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "ERROR: " + ex.getMessage());
            //Logger.getLogger(frmEscuela.class.getName()).log(Level.SEVERE, null, ex);
        }
    
   
    
}//GEN-LAST:event_btnGuardarActionPerformed

private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
 // TODO add your handling code here:
     
}//GEN-LAST:event_txtNombreFocusLost

private void txtNumeroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumeroFocusLost
 // TODO add your handling code here:
      Entidades entidad=(Entidades) this.cmbEntidades.getSelectedItem();
    this.auxclavect+=entidad.getClave();
    //System.out.println("entidad"+auxclavect);
      TipoPlantel tipo=(TipoPlantel) this.cmbTipoplantel.getSelectedItem();
       this.auxclavect+=tipo.getAbreviatura();
    //System.out.println("Abreviarura"+auxclavect);
    this.auxclavect+= this.txtNumero.getText();
    
    //System.out.println("Clave"+auxclavect);
    this.txtClavect.setText(this.auxclavect);
    this.auxclavect="";
}//GEN-LAST:event_txtNumeroFocusLost

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
            java.util.logging.Logger.getLogger(frmEscuela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmEscuela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmEscuela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmEscuela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                frmEscuela dialog = new frmEscuela(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox cmbDirector;
    private javax.swing.JComboBox cmbEntidades;
    private javax.swing.JComboBox cmbTipoplantel;
    private org.jdesktop.swingx.JXImagePanel imgLogotipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtClavect;
    private javax.swing.JFormattedTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtLogotipo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JFormattedTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
