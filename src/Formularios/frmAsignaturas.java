/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmAsignaturas.java
 *
 * Created on 5/02/2012, 02:48:16 PM
 */
package Formularios;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import Controladores.ctrlAreas;
import Controladores.ctrlAsignaturas;
import Controladores.ctrlCarreras;
import Controladores.ctrlPlanes;
import Controladores.ctrlModulos;
import Entidades.Areas;
import Entidades.Asignaturas;
import Entidades.Carreras;
import Entidades.Planes;
import Entidades.Modulos;

/**
 *
 * @author leonel
 */
public class frmAsignaturas extends javax.swing.JDialog {

    Asignaturas a = new Asignaturas();
    ctrlAsignaturas asignatura = new ctrlAsignaturas();
    ArrayList<Asignaturas> lstAsignaturas = new ArrayList<Asignaturas>();
    int id_carrera = 0;
    int id_plan = 0;
    int id_area = 0;
    int id_asignatura = 0;
    int id_modulo = 0;

    /** Creates new form frmAsignaturas */
    public frmAsignaturas(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        updateComboCarreras();
        updateComboPlanes();
        updateComboAreas();
        //updateComboModulos();
    }

    frmAsignaturas(java.awt.Dialog parent, boolean modal, Asignaturas varAsignatura) {
        super(parent, modal);
        initComponents();
        updateComboCarreras();
        updateComboPlanes();
        updateComboAreas();
        //updateComboModulos();
        a = varAsignatura;
        cargaDatos();

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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblClave = new javax.swing.JLabel();
        txtCreditos = new javax.swing.JTextField();
        cmbComponente = new javax.swing.JComboBox();
        txtClave = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cmbPlan = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        cmbArea = new javax.swing.JComboBox();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        txtHoras = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        chkOpcional = new javax.swing.JCheckBox();
        jLabel15 = new javax.swing.JLabel();
        chkEstado = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        cmbSemestre = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        cmbModulo = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        txtUnidades = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Datos de la Asignatura / Módulo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12))); // NOI18N

        jLabel3.setText("Carrera:");

        cmbCarrera.setEnabled(false);
        cmbCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCarreraActionPerformed(evt);
            }
        });

        jLabel5.setText("Creditos:");

        jLabel6.setText("Componente:");

        lblClave.setText("Clave de la Asignatura:");

        txtCreditos.setText("0");
        txtCreditos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCreditosActionPerformed(evt);
            }
        });
        txtCreditos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCreditosKeyTyped(evt);
            }
        });

        cmbComponente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecciona el Tipo de Componente", "Formación Básica", "Formación Propedéutica", "Formación Profesional" }));
        cmbComponente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbComponenteActionPerformed(evt);
            }
        });

        jLabel9.setText("Plan:");

        cmbPlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPlanActionPerformed(evt);
            }
        });

        jLabel10.setText("Area Propedéutica:");

        cmbArea.setEnabled(false);
        cmbArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAreaActionPerformed(evt);
            }
        });

        lblNombre.setText("Nombre de la Asignatura:");

        jLabel12.setText("Descripción:");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        jLabel13.setText("Horas:");

        txtHoras.setText("0");
        txtHoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHorasActionPerformed(evt);
            }
        });
        txtHoras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHorasKeyTyped(evt);
            }
        });

        jLabel14.setText("Módulo:");

        chkOpcional.setText("Si");
        chkOpcional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkOpcionalActionPerformed(evt);
            }
        });

        jLabel15.setText("Activo:");

        chkEstado.setSelected(true);
        chkEstado.setText("Si");
        chkEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkEstadoActionPerformed(evt);
            }
        });

        jLabel7.setText("Semestre:");

        cmbSemestre.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6" }));

        jLabel16.setText("Opcional:");

        cmbModulo.setEnabled(false);

        jLabel17.setText("Unidades de Aprendizaje:");

        txtUnidades.setText("0");
        txtUnidades.setEnabled(false);
        txtUnidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUnidadesActionPerformed(evt);
            }
        });
        txtUnidades.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUnidadesKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblClave)
                            .addComponent(lblNombre)
                            .addComponent(jLabel12)
                            .addComponent(jLabel7)
                            .addComponent(jLabel14)
                            .addComponent(jLabel17)
                            .addComponent(jLabel3)
                            .addComponent(jLabel10)
                            .addComponent(jLabel16))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbModulo, 0, 290, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cmbSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                        .addComponent(jLabel13)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                                    .addComponent(txtClave, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                                    .addComponent(cmbComponente, 0, 290, Short.MAX_VALUE)
                                    .addComponent(cmbPlan, 0, 290, Short.MAX_VALUE)
                                    .addComponent(cmbCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbArea, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(chkOpcional)
                                    .addComponent(chkEstado)))))
                    .addComponent(jLabel15))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cmbPlan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbComponente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblClave)
                    .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(cmbModulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkOpcional)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(chkEstado))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addGap(1, 1, 1)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnSalir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void cmbCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCarreraActionPerformed
// TODO add your handling code here:
    Carreras ca = (Carreras) cmbCarrera.getSelectedItem();
    if (ca != null) {
        id_carrera = ca.getIdCarrera();
        updateComboModulos();
    }
}//GEN-LAST:event_cmbCarreraActionPerformed

private void txtCreditosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCreditosActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_txtCreditosActionPerformed

private void cmbPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPlanActionPerformed
// TODO add your handling code here:
    Planes p = (Planes) cmbPlan.getSelectedItem();
    if (p != null) {
        id_plan = p.getIdPlan();
    }
}//GEN-LAST:event_cmbPlanActionPerformed

private void cmbAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAreaActionPerformed
// TODO add your handling code here:
    Areas area = (Areas) cmbArea.getSelectedItem();
    if (area != null) {
        id_area = area.getIdArea();
    }
}//GEN-LAST:event_cmbAreaActionPerformed

private void txtHorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHorasActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_txtHorasActionPerformed

private void chkOpcionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkOpcionalActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_chkOpcionalActionPerformed

private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
// TODO add your handling code here:
    this.guardar();
}//GEN-LAST:event_btnGuardarActionPerformed

private void chkEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkEstadoActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_chkEstadoActionPerformed

private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
// TODO add your handling code here:
    this.setVisible(false);
    this.dispose();
}//GEN-LAST:event_btnSalirActionPerformed

private void txtUnidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUnidadesActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_txtUnidadesActionPerformed

private void cmbComponenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbComponenteActionPerformed
// TODO add your handling code here:

    int indice = this.cmbComponente.getSelectedIndex();

    if (indice == 0 || indice == 1) {
        this.cmbModulo.setEnabled(false);
        this.txtUnidades.setEnabled(false);
        this.cmbCarrera.setEnabled(false);
        this.cmbArea.setEnabled(false);
        this.lblClave.setText("Clave de la Asignatura:");
        this.lblNombre.setText("Nombre de la Asignatura:");                
    } else if (indice == 2) {
        this.cmbModulo.setEnabled(false);
        this.txtUnidades.setEnabled(false);
        this.cmbCarrera.setEnabled(false);
        this.cmbArea.setEnabled(true);
        this.lblClave.setText("Clave de la Asignatura:");
        this.lblNombre.setText("Nombre de la Asignatura:");                
    } else if (indice == 3) {
        this.cmbModulo.setEnabled(true);
        this.txtUnidades.setEnabled(true);
        this.cmbCarrera.setEnabled(true);
        this.cmbArea.setEnabled(false);
        this.lblClave.setText("Clave del Módulo:");
        this.lblNombre.setText("Nombre del Módulo:");        
    }
}//GEN-LAST:event_cmbComponenteActionPerformed

private void txtCreditosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCreditosKeyTyped
// TODO add your handling code here:
      char caracter = evt.getKeyChar();

      // Verificar si la tecla pulsada no es un digito
      if(((caracter < '0') ||
         (caracter > '9')) &&
         (caracter != '\b' /*corresponde a BACK_SPACE*/))
      {
         evt.consume();  // ignorar el evento de teclado
      }    
}//GEN-LAST:event_txtCreditosKeyTyped

private void txtHorasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHorasKeyTyped
// TODO add your handling code here:
      char caracter = evt.getKeyChar();

      // Verificar si la tecla pulsada no es un digito
      if(((caracter < '0') ||
         (caracter > '9')) &&
         (caracter != '\b' /*corresponde a BACK_SPACE*/))
      {
         evt.consume();  // ignorar el evento de teclado
      }    
    
}//GEN-LAST:event_txtHorasKeyTyped

private void txtUnidadesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUnidadesKeyTyped
// TODO add your handling code here:
      char caracter = evt.getKeyChar();

      // Verificar si la tecla pulsada no es un digito
      if(((caracter < '0') ||
         (caracter > '9')) &&
         (caracter != '\b' /*corresponde a BACK_SPACE*/))
      {
         evt.consume();  // ignorar el evento de teclado
      }    
    
}//GEN-LAST:event_txtUnidadesKeyTyped

    private void cargaDatos() {

        id_asignatura = a.getIdAsignatura(); //Permite modificar los datos

        //Cargamos la carrera en el combo
        Carreras carrera = new Carreras();
        carrera.setIdCarrera(a.getIdCarrera());
        this.cmbCarrera.setSelectedItem(carrera);

        //Cargamos el plan en el combo
        Planes plan = new Planes();
        plan.setIdPlan(a.getIdPlan());
        this.cmbPlan.setSelectedItem(plan);

        //Cargamos el Area en el combo
        Areas area = new Areas();
        area.setIdArea(a.getIdArea());
        this.cmbArea.setSelectedItem(area);

        this.txtClave.setText(a.getClave());
        this.cmbSemestre.setSelectedIndex(a.getSemestre() - 1);
        this.txtNombre.setText(a.getNombre());
        this.txtDescripcion.setText(a.getDescripcion());
        this.txtCreditos.setText(a.getCreditos().toString());
        this.txtHoras.setText(a.getHoras().toString());
        this.cmbComponente.setSelectedIndex(a.getComponente());

        //Cargamos el Area en el combo
        Modulos modulo = new Modulos();
        modulo.setIdModulo(a.getIdModulo());
        this.cmbModulo.setSelectedItem(modulo);


        if ("S".equals(a.getOpcional())) {
            chkOpcional.setSelected(true);
        } else {
            chkOpcional.setSelected(false);
        }

        if ("A".equals(a.getEstado())) {
            chkEstado.setSelected(true);
        } else {  //X Cancelado
            chkEstado.setSelected(false);
        }

        this.txtUnidades.setText(a.getCantidadUnidades().toString());

    }

    private void guardar() {
        try {
            if (validar()) {

                if (JOptionPane.showConfirmDialog(this, "¿Deseas guardar los cambios?") == JOptionPane.YES_OPTION) {

                    if (id_asignatura == 0) {
                        a.setIdAsignatura(0);
                    } else {
                        a.setIdAsignatura(id_asignatura);
                    }

                    a.setIdPlan(id_plan);
                    a.setClave(txtClave.getText());
                    a.setSemestre((short) (cmbSemestre.getSelectedIndex() + 1));
                    //System.out.println(cmbSemestre.getSelectedIndex()+1);
                    a.setNombre(txtNombre.getText());
                    a.setDescripcion(txtDescripcion.getText());

                    if ("".equals(txtCreditos.getText())) 
                        a.setCreditos((short)0);                                                                    
                    else
                        a.setCreditos(Short.parseShort(txtCreditos.getText()));                        

                    if ("".equals(txtHoras.getText()))
                        a.setHoras((short)0);                        
                    else
                        a.setHoras(Short.parseShort(txtHoras.getText()));                        
                    
                    if ("".equals(txtHoras.getText()))
                        a.setComponente((short)0);
                    else
                        a.setComponente((short)cmbComponente.getSelectedIndex());
                    
                    a.setIdModulo(id_modulo);
                    if (cmbComponente.getSelectedIndex() == 3) {
                        a.setModulo("S");
                        a.setCantidadUnidades(Short.parseShort(txtUnidades.getText()));                       
                        
                    } else {
                        a.setModulo("N");
                        a.setCantidadUnidades((short) 0);
                    }

                    a.setCoeficientePonderacion((float)0.0);

                    a.setIdCarrera(id_carrera);
                    a.setIdArea(id_area);


                    //Si la asignatura es optativa
                    if (chkOpcional.isSelected() == true) {
                        a.setOpcional("S");
                    } else {
                        a.setOpcional("N");
                    }

                    if (chkEstado.isSelected() == true) {
                        a.setEstado("A");
                    } else {
                        a.setEstado("X");
                    }

                    int result = asignatura.setAsignatura(a);
                    if (result > 0) {
                        JOptionPane.showMessageDialog(this, "Los cambios fueron realizados con éxito");
                        this.setVisible(false);
                        //this.show(false);              
                    } else {
                        JOptionPane.showMessageDialog(this, "La asignatura no pudo agregarse debido a un problema");
                    }// fin de if (result > 0)     
                } //fin de ¿Guardar los cambios?
            } //fin de validar
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "error" + e.getMessage());
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

    private void updateComboPlanes() {
        ctrlPlanes plan = new ctrlPlanes();
        ArrayList<Planes> lstPlanes = new ArrayList<Planes>();
        try {
            lstPlanes = plan.getPlanes(0);

            DefaultComboBoxModel modeloCombo;
            modeloCombo = new DefaultComboBoxModel();
            modeloCombo.removeAllElements();
            modeloCombo = plan.getComboPlanes(lstPlanes);
            cmbPlan.setModel(modeloCombo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "error" + e.getMessage());
        }
    }

    private void updateComboAreas() {
        ctrlAreas area = new ctrlAreas();
        ArrayList<Areas> lstAreas = new ArrayList<Areas>();
        try {
            lstAreas = area.getAreas(0);
            DefaultComboBoxModel modeloCombo;
            modeloCombo = new DefaultComboBoxModel();
            modeloCombo.removeAllElements();
            modeloCombo = area.getComboAreas(lstAreas);
            cmbArea.setModel(modeloCombo);
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

    private boolean validar() {
        boolean result = false;


        Carreras carrera = (Carreras) cmbCarrera.getSelectedItem();
        if (carrera != null) {
            id_carrera = carrera.getIdCarrera();
        }

        Planes plan = (Planes) cmbPlan.getSelectedItem();
        if (plan != null) {
            id_plan = plan.getIdPlan();
        }

        Areas area = (Areas) cmbArea.getSelectedItem();
        if (area != null) {
            id_area = area.getIdArea();
        }

        Modulos modulo = (Modulos) cmbModulo.getSelectedItem();
        if (modulo != null) {
            id_modulo = modulo.getIdModulo();
        }

        if (id_plan == 0) {
            JOptionPane.showMessageDialog(this, "Selecciona un plan de estudios");
        } else if (cmbComponente.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Selecciona un componente");
        } else if ("".equals(txtClave.getText())) {
            JOptionPane.showMessageDialog(this, "Escribe la clave de la asignatura");
        } else if ("".equals(txtNombre.getText())) {
            JOptionPane.showMessageDialog(this, "Escribe el nombre de la asignatura");
        } else if (cmbComponente.getSelectedIndex() == 2 && id_area == 0) {
            JOptionPane.showMessageDialog(this, "Selecciona un área");
        } else if (cmbComponente.getSelectedIndex() == 3 && id_modulo == 0) {
            JOptionPane.showMessageDialog(this, "Selecciona un módulo");
        } else if (cmbComponente.getSelectedIndex() == 3 && "".equals(this.txtUnidades.getText())) {
            JOptionPane.showMessageDialog(this, "Escribe la cantidad de unidades de aprendizaje");
        } else if (cmbComponente.getSelectedIndex() == 3 && id_carrera == 0) {
            JOptionPane.showMessageDialog(this, "Selecciona una carrera");
        } else {
            result = true;
        }
                
        return result;

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
            java.util.logging.Logger.getLogger(frmAsignaturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAsignaturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAsignaturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAsignaturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                frmAsignaturas dialog = new frmAsignaturas(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton btnSalir;
    private javax.swing.JCheckBox chkEstado;
    private javax.swing.JCheckBox chkOpcional;
    private javax.swing.JComboBox cmbArea;
    private javax.swing.JComboBox cmbCarrera;
    private javax.swing.JComboBox cmbComponente;
    private javax.swing.JComboBox cmbModulo;
    private javax.swing.JComboBox cmbPlan;
    private javax.swing.JComboBox cmbSemestre;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblClave;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtCreditos;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtHoras;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtUnidades;
    // End of variables declaration//GEN-END:variables
}
