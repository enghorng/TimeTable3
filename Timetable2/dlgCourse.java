/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class dlgCourse extends javax.swing.JDialog {

    /**
     * Creates new form frmCourse
     */
    public dlgCourse(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        clsCon.inti();
        txtSubName.requestFocus();
        this.setLocationRelativeTo(null);     
        lblAlert1.setVisible(false);
        btnDelete.setEnabled(false);
        btnUpdate.setEnabled(false);
        getIdAuto();
        showdate();
        getCboCourse();
        ShowCourseIdTOLabel();
    }
      
    int index=0;
    int i=0;
    String c;
    DefaultListModel modeLst = new DefaultListModel();
    public void clear(){
        txtID.setText("");
        txtSubName.setText("");
        lblAlert1.setVisible(false);
    }
    void getIdAuto(){
        try {
            clsCon.setRs(clsCon.getStmt().executeQuery("select * from qMaxSubject"));
            clsCon.getRs().first();
            i = clsCon.getRs().getInt(1)+1;
            String m="";
            if(i<10)
                m = "00"+i;
            else if(i<100)
                m = "0"+i;    
            txtID.setText("Su"+m);
        } catch (Exception e) {
        }
    }
    public void getCboCourse(){
        cboCourse.addItem("--- Select ---");
        try {
            clsCon.setRs(clsCon.getStmt().executeQuery("select CourseName from tblCourse"));
            if(clsCon.getRs().first()){  
                do{
                    cboCourse.addItem(clsCon.getRs().getString("CourseName"));                                   
                }while(clsCon.getRs().next());
            }
            
        } catch (Exception e) {
        }
    }
    void ShowCourseIdTOLabel(){
        cboCourse.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
               c=(String) cboCourse.getSelectedItem();
               if(c == "--- Select ---")
                   return;
               try {
                    clsCon.setRs(clsCon.getStmt().executeQuery("Select * from tblCourse where CourseName='"+c+"'"));
                    clsCon.getRs().first();
                    lblCourseID.setText(clsCon.getRs().getString("CourseID"));
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    public void showdate(){               
        try {
            clsCon.setRs(clsCon.getStmt().executeQuery("select SubjectName from tblSubject"));
            if(clsCon.getRs().first()){  
                do{
                    String name = clsCon.getRs().getString("SubjectName"); 
                    lstCourse.setModel(modeLst);
                    modeLst.addElement(name);                    
                }while(clsCon.getRs().next());
            }
            
        } catch (Exception e) {
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnClear = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSubName = new javax.swing.JTextField();
        lblAlert1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstCourse = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        cboCourse = new javax.swing.JComboBox<>();
        lblCourseID = new javax.swing.JLabel();
        lblLst = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 255, 255));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setForeground(new java.awt.Color(0, 255, 255));

        jLabel2.setFont(new java.awt.Font("Charlemagne Std", 1, 40)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 255));
        jLabel2.setText("Subject Information");

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));

        btnClear.setBackground(new java.awt.Color(51, 153, 255));
        btnClear.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("New");
        btnClear.setBorder(null);
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(51, 153, 255));
        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update");
        btnUpdate.setBorder(null);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(51, 153, 255));
        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.setBorder(null);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(51, 153, 255));
        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Add");
        btnAdd.setBorder(null);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setText("Subject ID");

        txtID.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setText("Subject Name");

        txtSubName.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        lblAlert1.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        lblAlert1.setForeground(new java.awt.Color(255, 0, 51));
        lblAlert1.setText("Alert");

        lstCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstCourseMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lstCourse);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setText("Course");

        cboCourse.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        lblCourseID.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        lblCourseID.setForeground(new java.awt.Color(255, 0, 51));
        lblCourseID.setText("Alert");

        lblLst.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        lblLst.setForeground(new java.awt.Color(255, 0, 51));
        lblLst.setText("Alert");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtSubName, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(109, 109, 109)
                                .addComponent(cboCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAlert1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCourseID, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(lblLst, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(135, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnClear)
                            .addComponent(btnAdd)
                            .addComponent(btnUpdate)
                            .addComponent(btnDelete))
                        .addGap(59, 59, 59)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cboCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCourseID))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(lblLst))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtSubName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAlert1))))
                .addGap(80, 80, 80))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     
    
  
     
    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        btnAdd.setEnabled(true);
        btnDelete.setEnabled(false);
        btnUpdate.setEnabled(false);
        txtSubName.requestFocus();
        clear();
        getIdAuto();       
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int answer = JOptionPane.showConfirmDialog(this, "Do you want to delete?", "Delete", JOptionPane.YES_NO_OPTION);
        String sql = "delete from tblSubject where SubjectID='"+ txtID.getText() +"'";
        
        if(txtSubName.getText().equals("")){
                txtSubName.requestFocusInWindow();
                lblAlert1.setText("Please Fill");
                lblAlert1.setForeground(Color.red);
                return;
            }
        if(answer==JOptionPane.YES_OPTION)        
            try{    
                clsCon.getStmt().executeUpdate(sql);
                JOptionPane.showMessageDialog(this, "Delete is sueecssful");
                modeLst.removeElementAt(index);
                clear();      
           }
           catch(Exception e){
               JOptionPane.showMessageDialog(this, "This proccess is fail.");
           }     
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if(cboCourse.getSelectedItem().equals("--- Select ---"))
            return;    
        
        if(txtSubName.getText().equals("")){
            txtSubName.requestFocusInWindow();
            lblAlert1.setText("Please Fill");
            lblAlert1.setForeground(Color.red);
            lblAlert1.setVisible(true);
            return;
        }
        try{  
            String sql = "insert into tblSubject(SubjectID,SubjectName,Auto,CourseID) values('"+ txtID.getText() +"','"+ txtSubName.getText() +"','"+ i +"','"+ Byte.parseByte(lblCourseID.getText()) +"')";
        
            clsCon.getStmt().executeUpdate(sql);
            JOptionPane.showMessageDialog(this, "A new record was saved");
            lstCourse.setModel(modeLst);
            modeLst.addElement(txtSubName.getText());
            clear();  
            txtSubName.requestFocus();
            getIdAuto();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "This proccess is fail.");
        }  
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if(lstCourse.getSelectedIndex()<0)
            return;
        String sql = "update tblSubject set SubjectName='"+ txtSubName.getText() +"' where SubjectID='"+ txtID.getText() +"'";
        if(txtSubName.getText().equals("")){
                txtSubName.requestFocusInWindow();
                lblAlert1.setText("Please Fill");
                lblAlert1.setForeground(Color.red);
                return;
            }
         try{            
                clsCon.getStmt().executeUpdate(sql);
                JOptionPane.showMessageDialog(this, "Update is sueecssful");
                lstCourse.setModel(modeLst);
                modeLst.setElementAt(txtSubName.getText(),index);
                clear();      
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "This proccess is fail.");
        }  
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        try {
            clsCon.getCon().close(); 
        } catch (SQLException ex) {
            Logger.getLogger(dlgCourse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       try {
            clsCon.getCon().close(); 
        } catch (SQLException ex) {
            Logger.getLogger(dlgCourse.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_formWindowClosing

    private void lstCourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstCourseMouseClicked
        btnAdd.setEnabled(false);
        btnDelete.setEnabled(true);
        btnUpdate.setEnabled(true);

        index = lstCourse.getSelectedIndex();
        if(index == -1)
            cboCourse.setSelectedItem("--- Select ---");
        try {
            clsCon.setRs(clsCon.getStmt().executeQuery("select * from qCourseSubject where SubjectName='"+lstCourse.getSelectedValue()+"'"));
            clsCon.getRs().first(); 
            txtID.setText(clsCon.getRs().getString("SubjectID"));
            txtSubName.setText(lstCourse.getSelectedValue());
            cboCourse.setSelectedItem(clsCon.getRs().getString("CourseName"));            
            txtSubName.requestFocus();
            lblLst.setText(String.valueOf(lstCourse.getSelectedIndex()));
        }
        catch(Exception e){}
    }//GEN-LAST:event_lstCourseMouseClicked

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
            java.util.logging.Logger.getLogger(dlgCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlgCourse dialog = new dlgCourse(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                        try {
                            clsCon.getCon().close();
                        } catch (SQLException ex) {
                        }
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboCourse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAlert1;
    private javax.swing.JLabel lblCourseID;
    private javax.swing.JLabel lblLst;
    private javax.swing.JList<String> lstCourse;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtSubName;
    // End of variables declaration//GEN-END:variables
}
