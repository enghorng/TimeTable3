/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class dlgCourseSemester extends javax.swing.JDialog {

    /**
     * Creates new form dlgCourseSemester
     */
    public dlgCourseSemester(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        clsCon.inti();
        getCboCourse();
        getCboSemester();
        getSubjectFromCboCourse();
       // getSubjectID();
        getCourseID();
        getSemesterID();
        showData();
        this.setSize(1030,490);
        this.setLocationRelativeTo(null);
       // lblCourseID.setVisible(false);
        //lblSemesterID.setVisible(false);
        btnDelete2.setEnabled(false);
         jtblCS.setDefaultEditor(Object.class,null);
        
    }
      void getCboSemester(){  
       
        cboSemester.addItem("--- Select ---");
        try {    
                clsCon.setRs(clsCon.getStmt().executeQuery("select * from tblSemester"));
                clsCon.getRs().first();
                 lblSemesterID.setText(clsCon.getRs().getString("SemesterID"));
                if(clsCon.getRs().first())
                    do{
                        cboSemester.addItem(clsCon.getRs().getString("Semester"));
                    }while(clsCon.getRs().next());
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
     void getCboCourse(){ 
         
        cboCourse.addItem("--- Select ---");
        try {    
                clsCon.setRs(clsCon.getStmt().executeQuery("select * from tblCourse"));
                clsCon.getRs().first();
                  lblCourseID.setText(clsCon.getRs().getString("CourseID"));
                if(clsCon.getRs().first())
                    do{
                        cboCourse.addItem(clsCon.getRs().getString("CourseName"));
                    }while(clsCon.getRs().next());
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
      void getCourseID(){ // get CourseID from combobox coursename;
        cboCourse.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                if(cboCourse.getSelectedItem().equals("--- Select ---"))
                    return;
               String c=(String) cboCourse.getSelectedItem();               
               try {
                    clsCon.setRs(clsCon.getStmt().executeQuery("Select CourseID from tblCourse where CourseName='"+c+"'"));
                    clsCon.getRs().first();
                    lblCourseID.setText(clsCon.getRs().getString("CourseID"));
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    void getSubjectFromCboCourse(){
        cboCourse.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                String c=(String) cboCourse.getSelectedItem();
               try {
                    clsCon.setRs(clsCon.getStmt().executeQuery("Select SubjectName from qCourseSubject where CourseName='"+c+"'"));
                    cboSubject.removeAllItems();
                    if(clsCon.getRs().first())
                    do{
                        cboSubject.addItem(clsCon.getRs().getString("SubjectName"));
                    }while(clsCon.getRs().next());
                     
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } 
             }
        });
    }
    void getSubjectID(){
        cboSubject.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
               String s=(String) cboSubject.getSelectedItem();
               try {
                    clsCon.setRs(clsCon.getStmt().executeQuery("Select SubjectID from tblSubject where SubjectName='"+s+"'"));
                    clsCon.getRs().first();
                    lblSubjectID.setText(clsCon.getRs().getString("SubjectID"));
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    void getSemesterID(){//get SemesterID from combobox Semester;
        cboSemester.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
               String s=(String) cboSemester.getSelectedItem();
               if(cboSemester.getSelectedItem().equals("--- Select ---"))
                    return;
               try {
                    clsCon.setRs(clsCon.getStmt().executeQuery("Select SemesterID from tblSemester where Semester='"+s+"'"));
                    clsCon.getRs().first();
                    lblSemesterID.setText(clsCon.getRs().getString("SemesterID"));
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
     void showData(){
        DefaultTableModel modeTbl;
        modeTbl = (DefaultTableModel)jtblCS.getModel();
       
        try {
            clsCon.setRs(clsCon.getStmt().executeQuery("select * from qSubjectCourse"));
            if(clsCon.getRs().first()){  
                do{
                    String name = clsCon.getRs().getString("CourseName");
                    String sub = clsCon.getRs().getString("SubjectName");
                    String sem = clsCon.getRs().getString("Semester");
                    String st[]={name,sub,sem};
                    
                    modeTbl.addRow(st);
                }while(clsCon.getRs().next());
            }
        } catch (Exception e) {
        }
    }
    void clear(){       
        cboCourse.setSelectedIndex(0);
        cboSemester.setSelectedIndex(0);       
    } 
    void getCourseIDToLabel(){
        try{
            clsCon.setRs(clsCon.getStmt().executeQuery("select * from tblCourse where CourseName='"+(String) cboCourse.getSelectedItem()+"'"));
            clsCon.getRs().first();
            lblCourseID.setText(clsCon.getRs().getString("CourseID"));
        }
        catch(Exception e){}
    }
    void getSemesterIDToLabel(){
        try{
            clsCon.setRs(clsCon.getStmt().executeQuery("select * from tblSemester where Semester='"+(String) cboSemester.getSelectedItem()+"'"));
            clsCon.getRs().first();
            lblSemesterID.setText(clsCon.getRs().getString("SemesterID"));
        }
        catch(Exception e){}
    }
    void getSujectIDToLabel(){
        try{
            clsCon.setRs(clsCon.getStmt().executeQuery("select * from tblSubject where SubjectName='"+(String) cboSubject.getSelectedItem()+"'"));
            clsCon.getRs().first();
            lblSubjectID.setText(clsCon.getRs().getString("SubjectID"));
        }
        catch(Exception e){}
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        btnNew2 = new javax.swing.JButton();
        btnDelete2 = new javax.swing.JButton();
        btnAdd2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblAlert3 = new javax.swing.JLabel();
        cboCourse = new javax.swing.JComboBox<>();
        cboSemester = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtblCS = new javax.swing.JTable();
        lblCourseID = new javax.swing.JLabel();
        lblSemesterID = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cboSubject = new javax.swing.JComboBox<>();
        lblSubjectID = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(102, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(0, 255, 255));
        jPanel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel7.setForeground(new java.awt.Color(0, 255, 255));

        jLabel7.setFont(new java.awt.Font("Charlemagne Std", 1, 40)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 255));
        jLabel7.setText("Set up Subject");

        jPanel8.setBackground(new java.awt.Color(204, 255, 255));

        btnNew2.setBackground(new java.awt.Color(51, 153, 255));
        btnNew2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnNew2.setForeground(new java.awt.Color(255, 255, 255));
        btnNew2.setText("New");
        btnNew2.setBorder(null);
        btnNew2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNew2ActionPerformed(evt);
            }
        });

        btnDelete2.setBackground(new java.awt.Color(51, 153, 255));
        btnDelete2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnDelete2.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete2.setText("Delete");
        btnDelete2.setBorder(null);
        btnDelete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete2ActionPerformed(evt);
            }
        });

        btnAdd2.setBackground(new java.awt.Color(51, 153, 255));
        btnAdd2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnAdd2.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd2.setText("Add");
        btnAdd2.setBorder(null);
        btnAdd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd2ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel8.setText("Course ");
        jLabel8.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jLabel8ComponentHidden(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel9.setText("Semester");

        lblAlert3.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblAlert3.setForeground(new java.awt.Color(255, 0, 0));

        cboCourse.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        cboSemester.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jtblCS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course", "Subject", "Semester"
            }
        ));
        jtblCS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblCSMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jtblCS);

        lblCourseID.setText("Couse");

        lblSemesterID.setText("Semester");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel10.setText("Subject");

        cboSubject.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        lblSubjectID.setText("Subject");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNew2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(50, 50, 50)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(cboSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(lblSemesterID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAlert3, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cboSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addComponent(btnAdd2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnDelete2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(cboCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(lblCourseID))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(lblSubjectID)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNew2)
                            .addComponent(btnDelete2)
                            .addComponent(btnAdd2))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cboCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCourseID))
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cboSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)
                                    .addComponent(lblSubjectID))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cboSemester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAlert3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblSemesterID, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(303, 303, 303)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNew2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNew2ActionPerformed
        btnAdd2.setEnabled(true);
        btnDelete2.setEnabled(false);

        cboCourse.setSelectedIndex(0);
        cboSemester.setSelectedIndex(0);
        clear();
    }//GEN-LAST:event_btnNew2ActionPerformed

    private void btnDelete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete2ActionPerformed
        if(jtblCS.getSelectedRow() == -1)
        return;
        getCourseIDToLabel();
        getSemesterIDToLabel();
         getSubjectID();
        getSujectIDToLabel();
        if(JOptionPane.showConfirmDialog(this, "Do you want to delete?","Comfire",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
            try{
                int index[] = jtblCS.getSelectedRows();
                clsCon.getStmt().execute("delete from tblSubjectSemester where CourseID='"+lblCourseID.getText()+"' and SubjectID='"+lblSubjectID.getText()+"' and SemesterID='"+lblSemesterID.getText()+"'");
                JOptionPane.showMessageDialog(this, "Delete is successful.");
                clear();

                DefaultTableModel modtable = (DefaultTableModel)jtblCS.getModel();
                for(int i=0; i<index.length; i++)
                modtable.removeRow(index[i]-i);
                if(jtblCS.getRowCount()==0){
                    btnAdd2.setEnabled(true);
                    btnDelete2.setEnabled(false);

                   // clear();
                }
            }catch(Exception e){

            }
        }    
    }//GEN-LAST:event_btnDelete2ActionPerformed

    private void btnAdd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd2ActionPerformed
        getCourseIDToLabel();
        getSemesterIDToLabel();
        getSubjectID();
        getSujectIDToLabel();
               String sql = "insert into tblSubjectSemester(CourseID,SubjectID,SemesterID) values('"+Integer.parseInt(lblCourseID.getText())+"','"+lblSubjectID.getText()+"','"+lblSemesterID.getText()+"')";
        try {
            clsCon.getStmt().executeUpdate(sql);
            JOptionPane.showMessageDialog(this, "A new record was saved");

            DefaultTableModel modeTbl = (DefaultTableModel)jtblCS.getModel();
            clsCon.setRs(clsCon.getStmt().executeQuery("select * from qSubjectCourse where CourseID="+lblCourseID.getText()+" and SubjectID='"+lblSubjectID.getText()+"' and SemesterID='"+lblSemesterID.getText()+"'"));
            clsCon.getRs().first();
            
            String Course = clsCon.getRs().getString("CourseName");
            String Sub = clsCon.getRs().getString("SubjectName");
            String Semester = clsCon.getRs().getString("Semester");
            String st[]={Course,Sub,Semester};
            modeTbl.addRow(st);
           
            clear();
        } catch (SQLException ex) {
           //JOptionPane.showMessageDialog(this, "Has Already");
           //clear();
           return;
        }
    }//GEN-LAST:event_btnAdd2ActionPerformed

    private void jtblCSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblCSMouseClicked
        btnAdd2.setEnabled(false);
        btnDelete2.setEnabled(true);

        int index = jtblCS.getSelectedRow();
        String Course = ""+jtblCS.getValueAt(index, 0); //CousrName
        String Sub = ""+jtblCS.getValueAt(index, 1);//Sunject
        String Semester = ""+jtblCS.getValueAt(index, 2); //Semester
        cboCourse.setSelectedItem(Course);
        cboSemester.setSelectedItem(Semester);   
        cboSubject.setSelectedItem(Sub);
    }//GEN-LAST:event_jtblCSMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        try {
                clsCon.getCon().close();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
                clsCon.getCon().close();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_formWindowClosing

    private void jLabel8ComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jLabel8ComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8ComponentHidden

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
            java.util.logging.Logger.getLogger(dlgCourseSemester.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgCourseSemester.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgCourseSemester.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgCourseSemester.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlgCourseSemester dialog = new dlgCourseSemester(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAdd2;
    private javax.swing.JButton btnDelete2;
    private javax.swing.JButton btnNew2;
    private javax.swing.JComboBox<String> cboCourse;
    private javax.swing.JComboBox<String> cboSemester;
    private javax.swing.JComboBox<String> cboSubject;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jtblCS;
    private javax.swing.JLabel lblAlert3;
    private javax.swing.JLabel lblCourseID;
    private javax.swing.JLabel lblSemesterID;
    private javax.swing.JLabel lblSubjectID;
    // End of variables declaration//GEN-END:variables
}
