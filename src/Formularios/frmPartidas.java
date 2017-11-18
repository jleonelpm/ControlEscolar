/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmPartidas.java
 *
 * Created on 08-dic-2011, 12:32:24
 */
package Formularios;

import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
import Controladores.ctrlPartidas;
import Entidades.Partidas;

/**
 *
 * @author Last Develop
 */
public class frmPartidas extends javax.swing.JDialog {
ctrlPartidas ctrlpartida=new ctrlPartidas();
ArrayList<Partidas> lista=null;
Partidas partidaPadre=null;
Partidas partidaHijo=null;
private int op=0;
    /** Creates new form frmPartidas */
    public frmPartidas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Updateform();
       this.itemAgregar.setText("Agregar");
       this.itemModificar.setText("Modificar");
       this.itemEliminar.setText("Eliminar");
        this.jPanel2.setVisible(false);
        this.treePartidas.setRootVisible(false);
        
    }
   private void Updateform()
{
        this.treePartidas.getSelectionModel().setSelectionMode(javax.swing.tree.TreeSelectionModel.SINGLE_TREE_SELECTION);
        lista=ctrlpartida.getGruposPartidas("0");
        this.treePartidas.setModel(ctrlpartida.getGrupos(lista));
        this.cmbGrupo.setModel(ctrlpartida.getModeloCombo(lista));
}
private void setPartidasToForm(Partidas objpar)
{
  if(objpar!=null)
  {
   this.txtGrupo.setText(objpar.getIdCuenta());
   this.txtDescripcion.setText(objpar.getDescripcion());
   this.txtMonto.setText(String.valueOf( objpar.getImporte()));
      
  }
}

private void setFormToPartidas()
{
  partidaHijo=new Partidas();
  
  this.partidaHijo.setIdCuenta(this.txtGrupo.getText());
  this.partidaHijo.setDescripcion(this.txtDescripcion.getText());
  this.partidaHijo.setImporte(this.txtMonto.getText());
  if(this.partidaPadre!=null)  
      this.partidaHijo.setIdGrupo(this.partidaPadre.getIdCuenta());
  else
      this.partidaHijo.setIdGrupo("0");
      

}
private void LimpiarForm(JPanel panel)
{
  this.txtDescripcion.setText("");
  this.txtMonto.setText("");
  this.txtGrupo.setText("");

}

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupArbol = new javax.swing.JPopupMenu();
        itemAgregar = new javax.swing.JMenuItem();
        itemModificar = new javax.swing.JMenuItem();
        itemEliminar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        treePartidas = new javax.swing.JTree();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        txtMonto = new javax.swing.JFormattedTextField();
        Grupo = new javax.swing.JLabel();
        txtGrupo = new javax.swing.JTextField();
        bntGuardar = new javax.swing.JButton();
        cmbGrupo = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();

        itemAgregar.setText("jMenuItem1");
        itemAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAgregarActionPerformed(evt);
            }
        });
        popupArbol.add(itemAgregar);

        itemModificar.setText("jMenuItem2");
        itemModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemModificarActionPerformed(evt);
            }
        });
        popupArbol.add(itemModificar);

        itemEliminar.setText("jMenuItem3");
        itemEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEliminarActionPerformed(evt);
            }
        });
        popupArbol.add(itemEliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Partidas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        treePartidas.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        treePartidas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                treePartidasMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                treePartidasMousePressed(evt);
            }
        });
        treePartidas.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                treePartidasValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(treePartidas);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de la Partida", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel1.setText("Partida:");

        jLabel2.setText("Monto:");

        Grupo.setText("Clave:");

        bntGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar.png"))); // NOI18N
        bntGuardar.setText("Guardar");
        bntGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntGuardarActionPerformed(evt);
            }
        });

        cmbGrupo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
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

        jLabel3.setText("Grupo:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bntGuardar)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Grupo)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Grupo)
                    .addComponent(txtGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(41, 41, 41)
                .addComponent(bntGuardar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void treePartidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_treePartidasMouseClicked
 // TODO add your handling code here:
    try{
    DefaultMutableTreeNode nodo=(DefaultMutableTreeNode) this.treePartidas.getLastSelectedPathComponent();
      this.partidaPadre=(Partidas) nodo.getUserObject();
      
      this.cmbGrupo.setSelectedItem(partidaPadre.getDescripcion());
    }
    catch(Exception ex)
    {
    System.out.println(ex.getMessage());
    }
}//GEN-LAST:event_treePartidasMouseClicked

private void treePartidasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_treePartidasMousePressed
 // TODO add your handling code here:
    
    if(evt.getButton()==MouseEvent.BUTTON3)
    {
     this.popupArbol.show(this.treePartidas,evt.getX(),evt.getY());
     
    }
}//GEN-LAST:event_treePartidasMousePressed

private void treePartidasValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_treePartidasValueChanged
 // TODO add your handling code here:
   /* try{
    DefaultMutableTreeNode nodo=(DefaultMutableTreeNode) this.treePartidas.getLastSelectedPathComponent();
      this.partidaPadre=(Partidas) nodo.getUserObject();
      
      //this.cmbGrupo.setSelectedItem(partidaPadre.getDescripcion());
    }
    catch(Exception ex)
    {
    //System.out.println(ex.getMessage());
    }*/
        
         
    
}//GEN-LAST:event_treePartidasValueChanged

private void bntGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntGuardarActionPerformed
 // TODO add your handling code here:
    this.setFormToPartidas();
    if(this.partidaHijo!=null)
    {
    int res=JOptionPane.showConfirmDialog(this, "¿Desea Guardar los Cambios?");
    if(res==JOptionPane.YES_OPTION)
    {
                try {
                    int i= this.ctrlpartida.setPartidas(partidaHijo,op);
                        if(i>0)
                            {
                                JOptionPane.showMessageDialog(this,"Los Cambios se han Guardado con Éxito","Aviso",JOptionPane.INFORMATION_MESSAGE);
                                Updateform();
                              
                              this.LimpiarForm(jPanel2);
                              this.jPanel2.setVisible(false);
                             }
                        else
                            JOptionPane.showMessageDialog(this,"No se pudo Guardar los Cambios Debido a un Error:","Aviso",JOptionPane.INFORMATION_MESSAGE);
                       
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this,"No se pudo Guardar los Cambios Debido a un Error: "+ex.getMessage(),"Aviso",JOptionPane.INFORMATION_MESSAGE);
                    //Logger.getLogger(frmPartidas.class.getName()).log(Level.SEVERE, null, ex);
                    
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(this,"No se pudo Guardar los Cambios Debido a un Error: "+ex.getMessage(),"Aviso",JOptionPane.INFORMATION_MESSAGE);
                    //Logger.getLogger(frmPartidas.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
   }
    
}//GEN-LAST:event_bntGuardarActionPerformed

private void cmbGrupoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbGrupoItemStateChanged
 // TODO add your handling code here:
    
    
    
    
}//GEN-LAST:event_cmbGrupoItemStateChanged

private void cmbGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGrupoActionPerformed
 // TODO add your handling code here:
}//GEN-LAST:event_cmbGrupoActionPerformed

private void itemAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAgregarActionPerformed
 // TODO add your handling code here:
     this.jPanel2.setVisible(true);
    this.LimpiarForm(jPanel2);
    Updateform();
    this.op=0;
}//GEN-LAST:event_itemAgregarActionPerformed

private void itemModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemModificarActionPerformed
 // TODO add your handling code here:
     this.setPartidasToForm(partidaPadre);
     this.txtGrupo.setEditable(false);
    this.jPanel2.setVisible(true);
    Updateform();
    this.op=1;
}//GEN-LAST:event_itemModificarActionPerformed

private void itemEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEliminarActionPerformed
 // TODO add your handling code here:
    DefaultMutableTreeNode nodo=(DefaultMutableTreeNode) this.treePartidas.getLastSelectedPathComponent();
    if(nodo.isLeaf())
    {
     Partidas partida= (Partidas) nodo.getUserObject();
     if(ctrlpartida.deletePartidas(partida)>0)
     {
         this.Updateform();
     JOptionPane.showMessageDialog(this, "Eliminado", "Aviso",JOptionPane.WARNING_MESSAGE);
     }
     else
     {
     JOptionPane.showMessageDialog(this, "No se puede eliminar", "Aviso",JOptionPane.WARNING_MESSAGE);
     }
     
    }
    else
    {
    JOptionPane.showMessageDialog(this, "Es una categoria. No se puede eliminar", "Aviso",JOptionPane.WARNING_MESSAGE);
    }
}//GEN-LAST:event_itemEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(frmPartidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPartidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPartidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPartidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                frmPartidas dialog = new frmPartidas(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel Grupo;
    private javax.swing.JButton bntGuardar;
    private javax.swing.JComboBox cmbGrupo;
    private javax.swing.JMenuItem itemAgregar;
    private javax.swing.JMenuItem itemEliminar;
    private javax.swing.JMenuItem itemModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu popupArbol;
    private javax.swing.JTree treePartidas;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtGrupo;
    private javax.swing.JFormattedTextField txtMonto;
    // End of variables declaration//GEN-END:variables
}