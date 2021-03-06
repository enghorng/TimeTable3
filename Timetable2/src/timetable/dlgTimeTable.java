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

/**
 *
 * @author DELL
 */
public class dlgTimeTable extends javax.swing.JDialog {

    /**
     * Creates new form dlgTimeTable
     */
    public dlgTimeTable(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        clsCon.inti();
        
        getCboCourse();         
        showCourseIdToLabel();       
        showSemesterIdToLabel();
        showTeacherIdToLabel();      
        showClassIdToLabel();
        cboSemester.removeAllItems();
        cboSemester.addItem("--- Select ---");
        cboTeacher.removeAllItems();
        cboTeacher.addItem("--- Select ---");
        
//        chkMonday.setEnabled(false);
//        chkTuesday.setEnabled(false);
//        chkWednesday.setEnabled(false);
//        chkThursday.setEnabled(false);
//        chkFriday.setEnabled(false);
//        chkSaturday.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboSemester = new javax.swing.JComboBox<>();
        cboClass = new javax.swing.JComboBox<>();
        cboCourse = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        lblCourse = new javax.swing.JLabel();
        lblSemester = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cboTeacher = new javax.swing.JComboBox<>();
        lblTeacher = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblSubject = new javax.swing.JLabel();
        chkMonday = new javax.swing.JCheckBox();
        chkTuesday = new javax.swing.JCheckBox();
        chkWednesday = new javax.swing.JCheckBox();
        chkThursday = new javax.swing.JCheckBox();
        chkFriday = new javax.swing.JCheckBox();
        chkSaturday = new javax.swing.JCheckBox();
        lblClass = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(new java.awt.Color(0, 255, 255));

        jLabel1.setFont(new java.awt.Font("Charlemagne Std", 1, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setText("Course Timetabling");

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        btnNew.setBackground(new java.awt.Color(51, 153, 255));
        btnNew.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnNew.setForeground(new java.awt.Color(255, 255, 255));
        btnNew.setText("New");
        btnNew.setBorder(null);
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
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

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setText("Course");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setText("Semester");

        cboSemester.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        cboSemester.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cboSemesterFocusLost(evt);
            }
        });

        cboClass.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        cboCourse.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel5.setText("Class");

        lblCourse.setText("course");

        lblSemester.setText("Semester");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel6.setText("Subject");

        cboTeacher.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        lblTeacher.setText("teacher");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel7.setText("Teacher");

        lblSubject.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblSubject.setForeground(new java.awt.Color(0, 51, 255));
        lblSubject.setText("Subject");

        chkMonday.setBackground(new java.awt.Color(204, 255, 255));
        chkMonday.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        chkMonday.setText("Monday");

        chkTuesday.setBackground(new java.awt.Color(204, 255, 255));
        chkTuesday.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        chkTuesday.setText("Tuesday");

        chkWednesday.setBackground(new java.awt.Color(204, 255, 255));
        chkWednesday.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        chkWednesday.setText("Wednesday");

        chkThursday.setBackground(new java.awt.Color(204, 255, 255));
        chkThursday.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        chkThursday.setText("Thursday");

        chkFriday.setBackground(new java.awt.Color(204, 255, 255));
        chkFriday.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        chkFriday.setText("Friday");

        chkSaturday.setBackground(new java.awt.Color(204, 255, 255));
        chkSaturday.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        chkSaturday.setText("Saturday");

        lblClass.setText("Class");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addGap(56, 56, 56)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(227, 227, 227)
                                .addComponent(lblCourse))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cboTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(lblTeacher)
                                    .addGap(45, 45, 45)))
                            .addComponent(cboCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(216, 216, 216)
                                .addComponent(lblSemester)))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkThursday)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chkMonday)
                                    .addComponent(jLabel5))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(60, 60, 60)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(lblClass)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(chkTuesday)
                                                    .addComponent(chkFriday))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(chkSaturday)
                                                    .addComponent(chkWednesday))
                                                .addGap(57, 57, 57))))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(cboClass, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNew)
                            .addComponent(btnAdd)
                            .addComponent(btnUpdate)
                            .addComponent(btnDelete))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cboCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5)
                                .addComponent(cboClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2))
                        .addGap(1, 1, 1)
                        .addComponent(lblCourse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboSemester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(1, 1, 1)
                        .addComponent(lblSemester)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblClass)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chkMonday)
                            .addComponent(chkTuesday)
                            .addComponent(chkWednesday))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chkThursday)
                            .addComponent(chkFriday)
                            .addComponent(chkSaturday))
                        .addGap(1, 1, 1)))
                .addGap(1, 1, 1)
                .addComponent(lblTeacher)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblSubject))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /////////////////////// Cambobox Course ////////////////////
    void getCboCourse(){        
        cboCourse.removeAllItems();
        cboCourse.addItem("--- Select ---");
        try {    
                clsCon.setRs(clsCon.getStmt().executeQuery("select * from tblCourse"));
                clsCon.getRs().first();
                if(clsCon.getRs().first())
                    do{
                        cboCourse.addItem(clsCon.getRs().getString("CourseName"));
                    }while(clsCon.getRs().next());
        }
        catch(Exception ex){
        }
    }
    void showCourseIdToLabel(){ 
        cboCourse.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                lblCourse.setText("");
                if(cboCourse.getSelectedItem().equals("--- Select ---"))
                    return;
               String c=(String) cboCourse.getSelectedItem();
               try {
                    clsCon.setRs(clsCon.getStmt().executeQuery("Select CourseID from tblCourse where CourseName='"+c+"'"));
                    clsCon.getRs().first();
                    lblCourse.setText(clsCon.getRs().getString("CourseID"));
                    getCboTeacher();
                    getCboSemester();
                } catch (SQLException ex) {
                }
            }
        });
    }
    /////////////////////// Cambobox Semester ////////////////////
    void getCboSemester(){   
        cboSemester.removeAllItems();
        cboSemester.addItem("--- Select ---");
        try {    
                clsCon.setRs(clsCon.getStmt().executeQuery("select Semester,SemesterID from qSubjectCourse Where CourseID = "+lblCourse.getText()+" group by Semester,SemesterID"));
                clsCon.getRs().first();
                if(clsCon.getRs().first())
                    do{
                        cboSemester.addItem(clsCon.getRs().getString("Semester"));
                    }while(clsCon.getRs().next());
        }
        catch(Exception ex){
        }
        
    }
    void showSemesterIdToLabel(){ 
        cboSemester.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                lblSemester.setText("Semester");
                int i = cboSemester.getSelectedIndex();
                if(i == 0)
                    return;
                String c=(String) cboSemester.getSelectedItem();
                try {
                    clsCon.setRs(clsCon.getStmt().executeQuery("Select SemesterID from tblSemester where Semester='"+c+"'"));
                    clsCon.getRs().first();
                    lblSemester.setText(clsCon.getRs().getString("SemesterID"));
                    getCboTeacher();
                    getCboClass();
                } catch (SQLException ex) {
                }
                
            }
        });
    }
    /////////////////////// Cambobox Teacher ////////////////////
    void getCboTeacher(){        
        cboTeacher.removeAllItems();
        cboTeacher.addItem("--- Select ---");
        try {    
                clsCon.setRs(clsCon.getStmt().executeQuery("Select * from qSubjectSemester Where CourseID = '"+lblCourse.getText()+"' and SemesterID = '"+lblSemester.getText()+"'"));
                clsCon.getRs().first();
                lblTeacher.setText(clsCon.getRs().getString("TeacherID"));
                if(clsCon.getRs().first())
                    do{
                        cboTeacher.addItem(clsCon.getRs().getString("Name"));
                    }while(clsCon.getRs().next());
        }
        catch(Exception ex){
        }
    }
    void showTeacherIdToLabel(){ 
        cboTeacher.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                String c=(String) cboTeacher.getSelectedItem();
                try {
                    clsCon.setRs(clsCon.getStmt().executeQuery("Select * from qTeacher where Name='"+c+"'"));
                    clsCon.getRs().first();
                    lblTeacher.setText(clsCon.getRs().getString("TeacherID"));
                    lblSubject.setText(clsCon.getRs().getString("SubjectName"));
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    /////////////////////// Cambobox Class ////////////////////
    void getCboClass(){        
        cboClass.removeAllItems();
        cboClass.addItem("--- Select ---");
        try {    
                clsCon.setRs(clsCon.getStmt().executeQuery("Select ClassName,ClassID from qStu Where CourseName = '"+(String) cboCourse.getSelectedItem()+"' and SemesterID = '"+lblSemester.getText()+"' Group By ClassName,ClassID"));
                clsCon.getRs().first();
                lblClass.setText(clsCon.getRs().getString("ClassID"));
                if(clsCon.getRs().first())
                    do{
                        cboClass.addItem(clsCon.getRs().getString("ClassName"));
                    }while(clsCon.getRs().next());
        }
        catch(Exception ex){
        }
    }
    void showClassIdToLabel(){ 
        cboClass.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
//                if(cboClass.getSelectedItem().equals("--- Select ---"))
//                    return;
                String c=(String) cboClass.getSelectedItem();
                try {
                    clsCon.setRs(clsCon.getStmt().executeQuery("Select ClassID from tblClass where ClassName='"+c+"'"));
                    clsCon.getRs().first();
                    lblClass.setText(clsCon.getRs().getString("ClassID"));
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        cboCourse.setSelectedIndex(0);
        cboSemester.setSelectedIndex(0);
        cboClass.setSelectedIndex(0);
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

    }//GEN-LAST:event_btnAddActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
       try {
            clsCon.getCon().close(); 
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            clsCon.getCon().close(); 
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_formWindowClosing

    private void cboSemesterFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cboSemesterFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_cboSemesterFocusLost

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
            java.util.logging.Logger.getLogger(dlgTimeTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgTimeTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgTimeTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgTimeTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlgTimeTable dialog = new dlgTimeTable(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboClass;
    private javax.swing.JComboBox<String> cboCourse;
    private javax.swing.JComboBox<String> cboSemester;
    private javax.swing.JComboBox<String> cboTeacher;
    private javax.swing.JCheckBox chkFriday;
    private javax.swing.JCheckBox chkMonday;
    private javax.swing.JCheckBox chkSaturday;
    private javax.swing.JCheckBox chkThursday;
    private javax.swing.JCheckBox chkTuesday;
    private javax.swing.JCheckBox chkWednesday;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblClass;
    private javax.swing.JLabel lblCourse;
    private javax.swing.JLabel lblSemester;
    private javax.swing.JLabel lblSubject;
    private javax.swing.JLabel lblTeacher;
    // End of variables declaration//GEN-END:variables
}
