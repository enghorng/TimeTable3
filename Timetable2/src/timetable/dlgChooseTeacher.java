/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;

import java.awt.Checkbox;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class dlgChooseTeacher extends javax.swing.JDialog {

    /**
     * Creates new form dlgChooseTeacher
     */
    public dlgChooseTeacher(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        clsCon.inti();
        getCboTeacher();
        ShowTeacherTOLabel();
        setLocationRelativeTo(null);
        lblCourse.setVisible(false);
        lblSubject.setVisible(false);
        lblTeacherName.setVisible(false);
        lblTeacherID.setVisible(false);
      
            chkbxMorning.setEnabled(false);
            chkbxAfternoon.setEnabled(false);
            chkbxEvening.setEnabled(false);
        
            chkbxmMonday.setEnabled(false);
            chkbxmTuesday.setEnabled(false);
            chkbxmWednesday.setEnabled(false);
            chkbxmThursday.setEnabled(false);
            chkbxmFriday.setEnabled(false);
            chkbxmSaturday.setEnabled(false);
      
            chkbxaMonday.setEnabled(false);
            chkbxaTuesday.setEnabled(false);
            chkbxaWednesday.setEnabled(false);
            chkbxaThursday.setEnabled(false);
            chkbxaFriday.setEnabled(false);
            chkbxaSaturday.setEnabled(false);
            
            chkbxeMonday.setEnabled(false);
            chkbxeTuesday.setEnabled(false);
            chkbxeWednesday.setEnabled(false);
            chkbxeThursday.setEnabled(false);
            chkbxeFriday.setEnabled(false);
            chkbxeSaturday.setEnabled(false);
            cheMorAll.setEnabled(false);
            cheEveAll.setEnabled(false);
            cheAftAll.setEnabled(false);
      
    }
    @SuppressWarnings("empty-statement")
//    void EnableCheckBox(){
//        Checkbox chk = new Checkbox();
//        chk[] = {};
//        String[] chk1={"chkbxeSaturday"};
//        chk.setEnabled(false);
//    }
    String shift1,shift2,shift3;
    String day1,day2,day3,day4,day5,day6,day7;
    void clear(){
        chkbxAfternoon.setSelected(false);
        chkbxMorning.setSelected(false);
        chkbxEvening.setSelected(false);
        
        chkbxmMonday.setSelected(false);
        chkbxmTuesday.setSelected(false);
        chkbxmWednesday.setSelected(false);
        chkbxmThursday.setSelected(false);
        chkbxmFriday.setSelected(false);
        chkbxmSaturday.setSelected(false);

        chkbxaMonday.setSelected(false);
        chkbxaTuesday.setSelected(false);
        chkbxaWednesday.setSelected(false);
        chkbxaThursday.setSelected(false);
        chkbxaFriday.setSelected(false);
        chkbxaSaturday.setSelected(false);

        chkbxeMonday.setSelected(false);
        chkbxeTuesday.setSelected(false);
        chkbxeWednesday.setSelected(false);
        chkbxeThursday.setSelected(false);
        chkbxeFriday.setSelected(false);
        chkbxeSaturday.setSelected(false);
        
        cheMorAll.setSelected(false);
        cheEveAll.setSelected(false);
        cheAftAll.setSelected(false);
        
        chkbxmMonday.setEnabled(false);
        chkbxmTuesday.setEnabled(false);
        chkbxmWednesday.setEnabled(false);
        chkbxmThursday.setEnabled(false);
        chkbxmFriday.setEnabled(false);
        chkbxmSaturday.setEnabled(false);

        chkbxaMonday.setEnabled(false);
        chkbxaTuesday.setEnabled(false);
        chkbxaWednesday.setEnabled(false);
        chkbxaThursday.setEnabled(false);
        chkbxaFriday.setEnabled(false);
        chkbxaSaturday.setEnabled(false);

        chkbxeMonday.setEnabled(false);
        chkbxeTuesday.setEnabled(false);
        chkbxeWednesday.setEnabled(false);
        chkbxeThursday.setEnabled(false);
        chkbxeFriday.setEnabled(false);
        chkbxeSaturday.setEnabled(false);
        cheMorAll.setEnabled(false);
        cheEveAll.setEnabled(false);
        cheAftAll.setEnabled(false);
    }
    void getCboTeacher(){        
        cboTeacherName.removeAllItems();
        cboTeacherName.addItem("--- Select ---");
        try {    
                clsCon.setRs(clsCon.getStmt().executeQuery("select * from qTeacher"));
                clsCon.getRs().first();
                 lblTeacherID.setText(clsCon.getRs().getString("TeacherID"));
                 lblTeacherName.setText(clsCon.getRs().getString("Name"));
                 lblCourse.setText(clsCon.getRs().getString("CourseName"));
                 lblSubject.setText(clsCon.getRs().getString("SubjectName"));
                if(clsCon.getRs().first())
                    do{
                        cboTeacherName.addItem(clsCon.getRs().getString("Name"));                       
                    }while(clsCon.getRs().next());
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    void ShowTeacherTOLabel(){
        cboTeacherName.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                clear();
                if(cboTeacherName.getSelectedItem().equals("--- Select ---")){
                    lblCourse.setVisible(false);
                    lblSubject.setVisible(false);
                    lblTeacherName.setVisible(false);
                    
                    chkbxMorning.setEnabled(false);
                    chkbxAfternoon.setEnabled(false);
                    chkbxEvening.setEnabled(false);
                    return;
                }
                else {
                    lblCourse.setVisible(true);
                    lblSubject.setVisible(true);
                    lblTeacherName.setVisible(true);
                    
                    chkbxMorning.setEnabled(true);
                    chkbxAfternoon.setEnabled(true);
                    chkbxEvening.setEnabled(true);
                }
                
               String c=(String) cboTeacherName.getSelectedItem();
               try {
                    clsCon.setRs(clsCon.getStmt().executeQuery("Select * from qTeacher where Name='"+c+"'"));
                    clsCon.getRs().first();
                    lblTeacherID.setText(clsCon.getRs().getString("TeacherID"));
                    lblTeacherName.setText(clsCon.getRs().getString("Name"));
                    lblCourse.setText(clsCon.getRs().getString("CourseName"));
                    lblSubject.setText(clsCon.getRs().getString("SubjectName"));
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
               
            String name=(String) cboTeacherName.getSelectedItem();
               try {
                    clsCon.setRs(clsCon.getStmt().executeQuery("Select * from qTeacherTime where Name='"+name+"' and Active=1"));
                    clsCon.getRs().first();
                    if(clsCon.getRs().first())
                    
                    do{                  
                        /////////////////////////// Morning ////////////////////////
                        if(clsCon.getRs().getString("ShiftName").equals("Morning")){
                            chkbxMorning.setSelected(true);     cheMorAll.setEnabled(true);
                            chkbxmMonday.setEnabled(true);      chkbxmTuesday.setEnabled(true);     
                            chkbxmWednesday.setEnabled(true);   chkbxmThursday.setEnabled(true);    
                            chkbxmFriday.setEnabled(true);      chkbxmSaturday.setEnabled(true);
                            if(clsCon.getRs().getString("Day").equals("Monday"))    chkbxmMonday.setSelected(true);
                            if(clsCon.getRs().getString("Day").equals("Tuesday"))   chkbxmTuesday.setSelected(true); 
                            if(clsCon.getRs().getString("Day").equals("Wednesday")) chkbxmWednesday.setSelected(true); 
                            if(clsCon.getRs().getString("Day").equals("Thursday"))  chkbxmThursday.setSelected(true);
                            if(clsCon.getRs().getString("Day").equals("Friday"))    chkbxmFriday.setSelected(true); 
                            if(clsCon.getRs().getString("Day").equals("Saturday"))  chkbxmSaturday.setSelected(true); 
                        }
                        /////////////////////////// Afternoon ////////////////////////
                        if(clsCon.getRs().getString("ShiftName").equals("Afternoon")){
                            chkbxAfternoon.setSelected(true);   cheAftAll.setEnabled(true);  
                            chkbxaMonday.setEnabled(true);      chkbxaTuesday.setEnabled(true);     
                            chkbxaWednesday.setEnabled(true);   chkbxaThursday.setEnabled(true);    
                            chkbxaFriday.setEnabled(true);      chkbxaSaturday.setEnabled(true);
                            if(clsCon.getRs().getString("Day").equals("Monday"))    chkbxaMonday.setSelected(true); 
                            if(clsCon.getRs().getString("Day").equals("Tuesday"))   chkbxaTuesday.setSelected(true);
                            if(clsCon.getRs().getString("Day").equals("Wednesday")) chkbxaWednesday.setSelected(true);
                            if(clsCon.getRs().getString("Day").equals("Thursday"))  chkbxaThursday.setSelected(true); 
                            if(clsCon.getRs().getString("Day").equals("Friday"))    chkbxaFriday.setSelected(true);
                            if(clsCon.getRs().getString("Day").equals("Saturday"))  chkbxaSaturday.setSelected(true);                       
                        } 
                        /////////////////////////// Evening ////////////////////////
                        if(clsCon.getRs().getString("ShiftName").equals("Evening")){
                            chkbxEvening.setSelected(true);     cheEveAll.setEnabled(true);
                            chkbxeMonday.setEnabled(true);      chkbxeTuesday.setEnabled(true);     
                            chkbxeWednesday.setEnabled(true);   chkbxeThursday.setEnabled(true);    
                            chkbxeFriday.setEnabled(true);      chkbxeSaturday.setEnabled(true);
                            if(clsCon.getRs().getString("Day").equals("Monday"))    chkbxeMonday.setSelected(true);
                            if(clsCon.getRs().getString("Day").equals("Tuesday"))   chkbxeTuesday.setSelected(true); 
                            if(clsCon.getRs().getString("Day").equals("Wednesday")) chkbxeWednesday.setSelected(true); 
                            if(clsCon.getRs().getString("Day").equals("Thursday"))  chkbxeThursday.setSelected(true); 
                            if(clsCon.getRs().getString("Day").equals("Friday"))    chkbxeFriday.setSelected(true);
                            if(clsCon.getRs().getString("Day").equals("Saturday"))  chkbxeSaturday.setSelected(true);
                        }
                    }while(clsCon.getRs().next());
                    
                } catch (SQLException ex) {
                }
            }
        });
    }
    void getDayID(){
        if(chkbxmMonday.isSelected()||chkbxaMonday.isSelected()||chkbxeMonday.isSelected())
            day1 = "Da001";
        else
            day1 = null;
        if(chkbxmTuesday.isSelected()||chkbxaTuesday.isSelected()||chkbxeTuesday.isSelected())
            day2 = "Da002";
        else
            day2 = null;
        if(chkbxmMonday.isSelected()||chkbxaMonday.isSelected()||chkbxeMonday.isSelected())
            day3 = "Da003";
        else
            day3 = null;
        if(chkbxmThursday.isSelected()||chkbxaThursday.isSelected()||chkbxeThursday.isSelected())
            day4 = "Da004";
        else
            day4 = null;
        if(chkbxmFriday.isSelected()||chkbxaFriday.isSelected()||chkbxeFriday.isSelected())
            day5 = "Da005";
        else
            day5 = null;
        if(chkbxmSaturday.isSelected()||chkbxaSaturday.isSelected()||chkbxeSaturday.isSelected())
            day6 = "Da006";
        else
            day6 = null;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        cboTeacherName = new javax.swing.JComboBox<>();
        lblTeacherID = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblTeacherName = new javax.swing.JLabel();
        lblCourse = new javax.swing.JLabel();
        lblSubject = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        chkbxMorning = new javax.swing.JCheckBox();
        chkbxAfternoon = new javax.swing.JCheckBox();
        chkbxEvening = new javax.swing.JCheckBox();
        plMoring = new javax.swing.JPanel();
        chkbxmMonday = new javax.swing.JCheckBox();
        chkbxmTuesday = new javax.swing.JCheckBox();
        chkbxmWednesday = new javax.swing.JCheckBox();
        chkbxmThursday = new javax.swing.JCheckBox();
        chkbxmFriday = new javax.swing.JCheckBox();
        chkbxmSaturday = new javax.swing.JCheckBox();
        cheMorAll = new javax.swing.JCheckBox();
        plAfternon = new javax.swing.JPanel();
        chkbxaMonday = new javax.swing.JCheckBox();
        chkbxaTuesday = new javax.swing.JCheckBox();
        chkbxaWednesday = new javax.swing.JCheckBox();
        chkbxaThursday = new javax.swing.JCheckBox();
        chkbxaFriday = new javax.swing.JCheckBox();
        chkbxaSaturday = new javax.swing.JCheckBox();
        cheAftAll = new javax.swing.JCheckBox();
        plEvening = new javax.swing.JPanel();
        chkbxeMonday = new javax.swing.JCheckBox();
        chkbxeTuesday = new javax.swing.JCheckBox();
        chkbxeWednesday = new javax.swing.JCheckBox();
        chkbxeThursday = new javax.swing.JCheckBox();
        chkbxeFriday = new javax.swing.JCheckBox();
        chkbxeSaturday = new javax.swing.JCheckBox();
        cheEveAll = new javax.swing.JCheckBox();
        btnNew = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();

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
        jLabel1.setText("Time OF Teacher");

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1291, 705));

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search Teacher", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("AKbalthom Freehand", 0, 20), new java.awt.Color(255, 0, 51))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel9.setText("Search Name");

        cboTeacherName.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        cboTeacherName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTeacherNameActionPerformed(evt);
            }
        });

        lblTeacherID.setText("TeacherName");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setText("Teacher Name : ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setText("Course            :");

        lblTeacherName.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblTeacherName.setForeground(new java.awt.Color(0, 0, 255));
        lblTeacherName.setText("Name");

        lblCourse.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblCourse.setForeground(new java.awt.Color(0, 0, 255));
        lblCourse.setText("Name");

        lblSubject.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblSubject.setForeground(new java.awt.Color(0, 0, 255));
        lblSubject.setText("Name");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setText("Subject           :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboTeacherName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTeacherName, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                    .addComponent(lblCourse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSubject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(lblTeacherID)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboTeacherName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTeacherID))
                    .addComponent(jLabel9))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblTeacherName))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblCourse))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblSubject))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Shift", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("AKbalthom Freehand", 0, 20), new java.awt.Color(255, 0, 51))); // NOI18N

        chkbxMorning.setBackground(new java.awt.Color(204, 255, 255));
        chkbxMorning.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        chkbxMorning.setText("Morning");
        chkbxMorning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkbxMorningActionPerformed(evt);
            }
        });

        chkbxAfternoon.setBackground(new java.awt.Color(204, 255, 255));
        chkbxAfternoon.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        chkbxAfternoon.setText("Afternoon");
        chkbxAfternoon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkbxAfternoonActionPerformed(evt);
            }
        });

        chkbxEvening.setBackground(new java.awt.Color(204, 255, 255));
        chkbxEvening.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        chkbxEvening.setText("Evening");
        chkbxEvening.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkbxEveningActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkbxMorning, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkbxEvening)
                    .addComponent(chkbxAfternoon))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(chkbxMorning)
                .addGap(20, 20, 20)
                .addComponent(chkbxAfternoon)
                .addGap(18, 18, 18)
                .addComponent(chkbxEvening)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        plMoring.setBackground(new java.awt.Color(204, 255, 255));
        plMoring.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Morning", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("AKbalthom Freehand", 0, 20), new java.awt.Color(255, 0, 51))); // NOI18N

        chkbxmMonday.setBackground(new java.awt.Color(204, 255, 255));
        chkbxmMonday.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        chkbxmMonday.setText("Monday");

        chkbxmTuesday.setBackground(new java.awt.Color(204, 255, 255));
        chkbxmTuesday.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        chkbxmTuesday.setText("Tuesday");

        chkbxmWednesday.setBackground(new java.awt.Color(204, 255, 255));
        chkbxmWednesday.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        chkbxmWednesday.setText("Wednesday");

        chkbxmThursday.setBackground(new java.awt.Color(204, 255, 255));
        chkbxmThursday.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        chkbxmThursday.setText("Thursday");

        chkbxmFriday.setBackground(new java.awt.Color(204, 255, 255));
        chkbxmFriday.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        chkbxmFriday.setText("Friday");

        chkbxmSaturday.setBackground(new java.awt.Color(204, 255, 255));
        chkbxmSaturday.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        chkbxmSaturday.setText("Saturday");

        cheMorAll.setBackground(new java.awt.Color(204, 255, 255));
        cheMorAll.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        cheMorAll.setText("All");
        cheMorAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cheMorAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout plMoringLayout = new javax.swing.GroupLayout(plMoring);
        plMoring.setLayout(plMoringLayout);
        plMoringLayout.setHorizontalGroup(
            plMoringLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plMoringLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(plMoringLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cheMorAll)
                    .addComponent(chkbxmSaturday)
                    .addComponent(chkbxmFriday)
                    .addComponent(chkbxmThursday)
                    .addComponent(chkbxmWednesday)
                    .addComponent(chkbxmTuesday)
                    .addComponent(chkbxmMonday))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        plMoringLayout.setVerticalGroup(
            plMoringLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plMoringLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(cheMorAll)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkbxmMonday)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkbxmTuesday)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkbxmWednesday)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkbxmThursday)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkbxmFriday)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkbxmSaturday)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        plAfternon.setBackground(new java.awt.Color(204, 255, 255));
        plAfternon.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Afternoon", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("AKbalthom Freehand", 0, 20), new java.awt.Color(255, 0, 51))); // NOI18N

        chkbxaMonday.setBackground(new java.awt.Color(204, 255, 255));
        chkbxaMonday.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        chkbxaMonday.setText("Monday");

        chkbxaTuesday.setBackground(new java.awt.Color(204, 255, 255));
        chkbxaTuesday.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        chkbxaTuesday.setText("Tuesday");

        chkbxaWednesday.setBackground(new java.awt.Color(204, 255, 255));
        chkbxaWednesday.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        chkbxaWednesday.setText("Wednesday");

        chkbxaThursday.setBackground(new java.awt.Color(204, 255, 255));
        chkbxaThursday.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        chkbxaThursday.setText("Thursday");

        chkbxaFriday.setBackground(new java.awt.Color(204, 255, 255));
        chkbxaFriday.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        chkbxaFriday.setText("Friday");

        chkbxaSaturday.setBackground(new java.awt.Color(204, 255, 255));
        chkbxaSaturday.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        chkbxaSaturday.setText("Saturday");

        cheAftAll.setBackground(new java.awt.Color(204, 255, 255));
        cheAftAll.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        cheAftAll.setText("All");

        javax.swing.GroupLayout plAfternonLayout = new javax.swing.GroupLayout(plAfternon);
        plAfternon.setLayout(plAfternonLayout);
        plAfternonLayout.setHorizontalGroup(
            plAfternonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plAfternonLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(plAfternonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cheAftAll)
                    .addComponent(chkbxaSaturday)
                    .addComponent(chkbxaFriday)
                    .addComponent(chkbxaThursday)
                    .addComponent(chkbxaWednesday)
                    .addComponent(chkbxaTuesday)
                    .addComponent(chkbxaMonday))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        plAfternonLayout.setVerticalGroup(
            plAfternonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plAfternonLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(cheAftAll)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkbxaMonday)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkbxaTuesday)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkbxaWednesday)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkbxaThursday)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkbxaFriday)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkbxaSaturday)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        plEvening.setBackground(new java.awt.Color(204, 255, 255));
        plEvening.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Evening", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("AKbalthom Freehand", 0, 20), new java.awt.Color(255, 0, 51))); // NOI18N

        chkbxeMonday.setBackground(new java.awt.Color(204, 255, 255));
        chkbxeMonday.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        chkbxeMonday.setText("Monday");

        chkbxeTuesday.setBackground(new java.awt.Color(204, 255, 255));
        chkbxeTuesday.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        chkbxeTuesday.setText("Tuesday");

        chkbxeWednesday.setBackground(new java.awt.Color(204, 255, 255));
        chkbxeWednesday.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        chkbxeWednesday.setText("Wednesday");

        chkbxeThursday.setBackground(new java.awt.Color(204, 255, 255));
        chkbxeThursday.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        chkbxeThursday.setText("Thursday");

        chkbxeFriday.setBackground(new java.awt.Color(204, 255, 255));
        chkbxeFriday.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        chkbxeFriday.setText("Friday");

        chkbxeSaturday.setBackground(new java.awt.Color(204, 255, 255));
        chkbxeSaturday.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        chkbxeSaturday.setText("Saturday");

        cheEveAll.setBackground(new java.awt.Color(204, 255, 255));
        cheEveAll.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        cheEveAll.setText("All");

        javax.swing.GroupLayout plEveningLayout = new javax.swing.GroupLayout(plEvening);
        plEvening.setLayout(plEveningLayout);
        plEveningLayout.setHorizontalGroup(
            plEveningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plEveningLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(plEveningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkbxeSaturday)
                    .addComponent(chkbxeFriday)
                    .addComponent(chkbxeThursday)
                    .addComponent(chkbxeWednesday)
                    .addComponent(chkbxeTuesday)
                    .addComponent(chkbxeMonday)
                    .addComponent(cheEveAll))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        plEveningLayout.setVerticalGroup(
            plEveningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plEveningLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(cheEveAll)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkbxeMonday)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkbxeTuesday)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkbxeWednesday)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkbxeThursday)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkbxeFriday)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkbxeSaturday)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        btnNew.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(plMoring, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76)
                                .addComponent(plAfternon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(plEvening, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(173, 173, 173)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew)
                    .addComponent(btnAdd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(plEvening, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(plMoring, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(plAfternon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 908, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboTeacherNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTeacherNameActionPerformed
   
    }//GEN-LAST:event_cboTeacherNameActionPerformed

    private void chkbxMorningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkbxMorningActionPerformed
        //Morning shift
        if(chkbxMorning.isSelected())
        {
            cheMorAll.setEnabled(true);
            chkbxmMonday.setEnabled(true);
            chkbxmTuesday.setEnabled(true);
            chkbxmWednesday.setEnabled(true);
            chkbxmThursday.setEnabled(true);
            chkbxmFriday.setEnabled(true);
            chkbxmSaturday.setEnabled(true);
        }else{
            shift1 = null;
            cheMorAll.setEnabled(false);
            chkbxmMonday.setEnabled(false);
            chkbxmTuesday.setEnabled(false);
            chkbxmWednesday.setEnabled(false);
            chkbxmThursday.setEnabled(false);
            chkbxmFriday.setEnabled(false);
            chkbxmSaturday.setEnabled(false);
            cheMorAll.setSelected(false);
            chkbxmMonday.setSelected(false);
            chkbxmTuesday.setSelected(false);
            chkbxmWednesday.setSelected(false);
            chkbxmThursday.setSelected(false);
            chkbxmFriday.setSelected(false);
            chkbxmSaturday.setSelected(false);
        }
    }//GEN-LAST:event_chkbxMorningActionPerformed

    private void chkbxAfternoonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkbxAfternoonActionPerformed
        
        //Afternoon shift
        if(chkbxAfternoon.isSelected())
        {
            cheAftAll.setEnabled(true);
            chkbxaMonday.setEnabled(true);
            chkbxaTuesday.setEnabled(true);
            chkbxaWednesday.setEnabled(true);
            chkbxaThursday.setEnabled(true);
            chkbxaFriday.setEnabled(true);
            chkbxaSaturday.setEnabled(true);
        }else
        {
            cheAftAll.setEnabled(false);
            chkbxaMonday.setEnabled(false);
            chkbxaTuesday.setEnabled(false);
            chkbxaWednesday.setEnabled(false);
            chkbxaThursday.setEnabled(false);
            chkbxaFriday.setEnabled(false);
            chkbxaSaturday.setEnabled(false);
            cheAftAll.setSelected(false);
            chkbxaMonday.setSelected(false);
            chkbxaTuesday.setSelected(false);
            chkbxaWednesday.setSelected(false);
            chkbxaThursday.setSelected(false);
            chkbxaFriday.setSelected(false);
            chkbxaSaturday.setSelected(false);
        }
    }//GEN-LAST:event_chkbxAfternoonActionPerformed

    private void chkbxEveningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkbxEveningActionPerformed
        
        //Evening Shift
        if(chkbxEvening.isSelected())
        {
            cheEveAll.setEnabled(true);
            chkbxeMonday.setEnabled(true);
            chkbxeTuesday.setEnabled(true);
            chkbxeWednesday.setEnabled(true);
            chkbxeThursday.setEnabled(true);
            chkbxeFriday.setEnabled(true);
            chkbxeSaturday.setEnabled(true);
        }else
        {
            cheEveAll.setEnabled(false);
            chkbxeMonday.setEnabled(false);
            chkbxeTuesday.setEnabled(false);
            chkbxeWednesday.setEnabled(false);
            chkbxeThursday.setEnabled(false);
            chkbxeFriday.setEnabled(false);
            chkbxeSaturday.setEnabled(false);
            cheEveAll.setSelected(false);
            chkbxeMonday.setSelected(false);
            chkbxeTuesday.setSelected(false);
            chkbxeWednesday.setSelected(false);
            chkbxeThursday.setSelected(false);
            chkbxeFriday.setSelected(false);
            chkbxeSaturday.setSelected(false);
        }
    }//GEN-LAST:event_chkbxEveningActionPerformed

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
            Logger.getLogger(dlgCourse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if(cboTeacherName.getSelectedItem().equals("--- Select ---"))
            return;
        //////////////////////////////// Add Morning ////////////////////////////
        if(chkbxMorning.isSelected()){
            if(chkbxmMonday.isSelected()){
                try {
                    String sql = "Insert into tblTeacherTime values('"+lblTeacherID.getText()+"','Sh001','Da001',1)";
                    clsCon.getStmt().executeUpdate(sql);
                } catch (Exception e) {
                }
            }
            if(chkbxmTuesday.isSelected()){
                try {
                    String sql = "Insert into tblTeacherTime values('"+lblTeacherID.getText()+"','Sh001','Da002',1)";
                    clsCon.getStmt().executeUpdate(sql);
                } catch (Exception e) {
                }
            }
            if(chkbxmWednesday.isSelected()){
                try {
                    String sql = "Insert into tblTeacherTime values('"+lblTeacherID.getText()+"','Sh001','Da003',1)";
                    clsCon.getStmt().executeUpdate(sql);
                } catch (Exception e) {
                }
            }
            if(chkbxmThursday.isSelected()){
                try {
                    String sql = "Insert into tblTeacherTime values('"+lblTeacherID.getText()+"','Sh001','Da004',1)";
                    clsCon.getStmt().executeUpdate(sql);
                } catch (Exception e) {
                }
            }
            if(chkbxmFriday.isSelected()){
                try {
                    String sql = "Insert into tblTeacherTime values('"+lblTeacherID.getText()+"','Sh001','Da005',1)";
                    clsCon.getStmt().executeUpdate(sql);
                } catch (Exception e) {
                }
            }
            if(chkbxmSaturday.isSelected()){
                try {
                    String sql = "Insert into tblTeacherTime values('"+lblTeacherID.getText()+"','Sh001','Da006',1)";
                    clsCon.getStmt().executeUpdate(sql);
                } catch (Exception e) {
                }
            }
        }
        //////////////////////////////// Add Afternoon ////////////////////////////
        if(chkbxAfternoon.isSelected()){
            if(chkbxaMonday.isSelected()){
                try {
                    String sql = "Insert into tblTeacherTime values('"+lblTeacherID.getText()+"','Sh002','Da001',1)";
                    clsCon.getStmt().executeUpdate(sql);
                } catch (Exception e) {
                }
            }
            if(chkbxaTuesday.isSelected()){
                try {
                    String sql = "Insert into tblTeacherTime values('"+lblTeacherID.getText()+"','Sh002','Da002',1)";
                    clsCon.getStmt().executeUpdate(sql);
                } catch (Exception e) {
                }
            }
            if(chkbxaWednesday.isSelected()){
                try {
                    String sql = "Insert into tblTeacherTime values('"+lblTeacherID.getText()+"','Sh002','Da003',1)";
                    clsCon.getStmt().executeUpdate(sql);
                } catch (Exception e) {
                }
            }
            if(chkbxaThursday.isSelected()){
                try {
                    String sql = "Insert into tblTeacherTime values('"+lblTeacherID.getText()+"','Sh002','Da004',1)";
                    clsCon.getStmt().executeUpdate(sql);
                } catch (Exception e) {
                }
            }
            if(chkbxaFriday.isSelected()){
                try {
                    String sql = "Insert into tblTeacherTime values('"+lblTeacherID.getText()+"','Sh002','Da005',1)";
                    clsCon.getStmt().executeUpdate(sql);
                } catch (Exception e) {
                }
            }
            if(chkbxaSaturday.isSelected()){
                try {
                    String sql = "Insert into tblTeacherTime values('"+lblTeacherID.getText()+"','Sh002','Da006',1)";
                    clsCon.getStmt().executeUpdate(sql);
                } catch (Exception e) {
                }
            }
        }
        //////////////////////////////// Add Evening ////////////////////////////
        if(chkbxEvening.isSelected()){
            if(chkbxeMonday.isSelected()){
                try {
                    String sql = "Insert into tblTeacherTime values('"+lblTeacherID.getText()+"','Sh003','Da001',1)";
                    clsCon.getStmt().executeUpdate(sql);
                } catch (Exception e) {
                }
            }
            if(chkbxeTuesday.isSelected()){
                try {
                    String sql = "Insert into tblTeacherTime values('"+lblTeacherID.getText()+"','Sh003','Da002',1)";
                    clsCon.getStmt().executeUpdate(sql);
                } catch (Exception e) {
                }
            }
            if(chkbxeWednesday.isSelected()){
                try {
                    String sql = "Insert into tblTeacherTime values('"+lblTeacherID.getText()+"','Sh003','Da003',1)";
                    clsCon.getStmt().executeUpdate(sql);
                } catch (Exception e) {                    
                }
            }
            if(chkbxeThursday.isSelected()){
                try {
                    String sql = "Insert into tblTeacherTime values('"+lblTeacherID.getText()+"','Sh003','Da004',1)";
                    clsCon.getStmt().executeUpdate(sql);
                } catch (Exception e) {
                }
            }
            if(chkbxeFriday.isSelected()){
                try {
                    String sql = "Insert into tblTeacherTime values('"+lblTeacherID.getText()+"','Sh003','Da005',1)";
                    clsCon.getStmt().executeUpdate(sql);                    
                } catch (Exception e) {
                }
            }
            if(chkbxeSaturday.isSelected()){
                try {
                    String sql = "Insert into tblTeacherTime values('"+lblTeacherID.getText()+"','Sh003','Da006',1)";
                    clsCon.getStmt().executeUpdate(sql);                    
                } catch (Exception e) {
                }
            }
        }  
        ///////////////////////////////// Update Morning to Hide /////////////////////////////////////// 
        if(chkbxmMonday.isSelected() != true){ 
            try {
                String sql = "update tblTeacherTime set Active=0 where TeacherID='"+lblTeacherID.getText()+"' and ShiftID='Sh001' and DayID='Da001'";
                clsCon.getStmt().executeUpdate(sql);
            } catch (Exception e) {
            }
        }
        if(chkbxmTuesday.isSelected() != true){ 
            try {
                String sql = "update tblTeacherTime set Active=0 where TeacherID='"+lblTeacherID.getText()+"' and ShiftID='Sh001' and DayID='Da002'";
                clsCon.getStmt().executeUpdate(sql);
            } catch (Exception e) {
            }
        }
        if(chkbxmWednesday.isSelected() != true){ 
            try {
                String sql = "update tblTeacherTime set Active=0 where TeacherID='"+lblTeacherID.getText()+"' and ShiftID='Sh001' and DayID='Da003'";
                clsCon.getStmt().executeUpdate(sql);
            } catch (Exception e) {
            }
        }
        if(chkbxmThursday.isSelected() != true){ 
            try {
                String sql = "update tblTeacherTime set Active=0 where TeacherID='"+lblTeacherID.getText()+"' and ShiftID='Sh001' and DayID='Da004'";
                clsCon.getStmt().executeUpdate(sql);
            } catch (Exception e) {
            }
        }
        if(chkbxmFriday.isSelected() != true){ 
            try {
                String sql = "update tblTeacherTime set Active=0 where TeacherID='"+lblTeacherID.getText()+"' and ShiftID='Sh001' and DayID='Da005'";
                clsCon.getStmt().executeUpdate(sql);
            } catch (Exception e) {
            }
        }
        if(chkbxmSaturday.isSelected() != true){ 
            try {
                String sql = "update tblTeacherTime set Active=0 where TeacherID='"+lblTeacherID.getText()+"' and ShiftID='Sh001' and DayID='Da006'";
                clsCon.getStmt().executeUpdate(sql);
            } catch (Exception e) {
            }
        }
        ///////////////////////////////// Update Afternoon to Hide /////////////////////////////////////// 
        if(chkbxaMonday.isSelected() != true){ 
            try {
                String sql = "update tblTeacherTime set Active=0 where TeacherID='"+lblTeacherID.getText()+"' and ShiftID='Sh002' and DayID='Da001'";
                clsCon.getStmt().executeUpdate(sql);
            } catch (Exception e) {
            }
        }
        if(chkbxaTuesday.isSelected() != true){ 
            try {
                String sql = "update tblTeacherTime set Active=0 where TeacherID='"+lblTeacherID.getText()+"' and ShiftID='Sh002' and DayID='Da002'";
                clsCon.getStmt().executeUpdate(sql);
            } catch (Exception e) {
            }
        }
        if(chkbxaWednesday.isSelected() != true){ 
            try {
                String sql = "update tblTeacherTime set Active=0 where TeacherID='"+lblTeacherID.getText()+"' and ShiftID='Sh002' and DayID='Da003'";
                clsCon.getStmt().executeUpdate(sql);
            } catch (Exception e) {
            }
        }
        if(chkbxaThursday.isSelected() != true){ 
            try {
                String sql = "update tblTeacherTime set Active=0 where TeacherID='"+lblTeacherID.getText()+"' and ShiftID='Sh002' and DayID='Da004'";
                clsCon.getStmt().executeUpdate(sql);
            } catch (Exception e) {
            }
        }
        if(chkbxaFriday.isSelected() != true){ 
            try {
                String sql = "update tblTeacherTime set Active=0 where TeacherID='"+lblTeacherID.getText()+"' and ShiftID='Sh002' and DayID='Da005'";
                clsCon.getStmt().executeUpdate(sql);
            } catch (Exception e) {
            }
        }
        if(chkbxaSaturday.isSelected() != true){ 
            try {
                String sql = "update tblTeacherTime set Active=0 where TeacherID='"+lblTeacherID.getText()+"' and ShiftID='Sh002' and DayID='Da006'";
                clsCon.getStmt().executeUpdate(sql);
            } catch (Exception e) {
            }
        }
        ///////////////////////////////// Update Evening to Hide /////////////////////////////////////// 
        if(chkbxeMonday.isSelected() != true){ 
            try {
                String sql = "update tblTeacherTime set Active=0 where TeacherID='"+lblTeacherID.getText()+"' and ShiftID='Sh003' and DayID='Da001'";
                clsCon.getStmt().executeUpdate(sql);
            } catch (Exception e) {
            }
        }
        if(chkbxeTuesday.isSelected() != true){ 
            try {
                String sql = "update tblTeacherTime set Active=0 where TeacherID='"+lblTeacherID.getText()+"' and ShiftID='Sh003' and DayID='Da002'";
                clsCon.getStmt().executeUpdate(sql);
            } catch (Exception e) {
            }
        }
        if(chkbxeWednesday.isSelected() != true){ 
            try {
                String sql = "update tblTeacherTime set Active=0 where TeacherID='"+lblTeacherID.getText()+"' and ShiftID='Sh003' and DayID='Da003'";
                clsCon.getStmt().executeUpdate(sql);
            } catch (Exception e) {
            }
        }
        if(chkbxeThursday.isSelected() != true){ 
            try {
                String sql = "update tblTeacherTime set Active=0 where TeacherID='"+lblTeacherID.getText()+"' and ShiftID='Sh003' and DayID='Da004'";
                clsCon.getStmt().executeUpdate(sql);
            } catch (Exception e) {
            }
        }
        if(chkbxeFriday.isSelected() != true){ 
            try {
                String sql = "update tblTeacherTime set Active=0 where TeacherID='"+lblTeacherID.getText()+"' and ShiftID='Sh003' and DayID='Da005'";
                clsCon.getStmt().executeUpdate(sql);
            } catch (Exception e) {
            }
        }
        if(chkbxeSaturday.isSelected() != true){ 
            try {
                String sql = "update tblTeacherTime set Active=0 where TeacherID='"+lblTeacherID.getText()+"' and ShiftID='Sh003' and DayID='Da006'";
                clsCon.getStmt().executeUpdate(sql);
            } catch (Exception e) {
            }
        }
        //////////////////////////////////// Update Morning from Hide to Active ///////////////////////  
        if(chkbxmMonday.isSelected()){ 
            try {
                String sql = "update tblTeacherTime set Active=1 where TeacherID='"+lblTeacherID.getText()+"' and ShiftID='Sh001' and DayID='Da001'";
                clsCon.getStmt().executeUpdate(sql);
            } catch (Exception e) {
            }
        }
        if(chkbxmTuesday.isSelected()){ 
            try {
                String sql = "update tblTeacherTime set Active=1 where TeacherID='"+lblTeacherID.getText()+"' and ShiftID='Sh001' and DayID='Da002'";
                clsCon.getStmt().executeUpdate(sql);
            } catch (Exception e) {
            }
        }
        if(chkbxmWednesday.isSelected()){ 
            try {
                String sql = "update tblTeacherTime set Active=1 where TeacherID='"+lblTeacherID.getText()+"' and ShiftID='Sh001' and DayID='Da003'";
                clsCon.getStmt().executeUpdate(sql);
            } catch (Exception e) {
            }
        }
        if(chkbxmThursday.isSelected()){ 
            try {
                String sql = "update tblTeacherTime set Active=1 where TeacherID='"+lblTeacherID.getText()+"' and ShiftID='Sh001' and DayID='Da004'";
                clsCon.getStmt().executeUpdate(sql);
            } catch (Exception e) {
            }
        }
        if(chkbxmFriday.isSelected()){ 
            try {
                String sql = "update tblTeacherTime set Active=1 where TeacherID='"+lblTeacherID.getText()+"' and ShiftID='Sh001' and DayID='Da005'";
                clsCon.getStmt().executeUpdate(sql);
            } catch (Exception e) {
            }
        }
        if(chkbxmSaturday.isSelected()){ 
            try {
                String sql = "update tblTeacherTime set Active=1 where TeacherID='"+lblTeacherID.getText()+"' and ShiftID='Sh001' and DayID='Da006'";
                clsCon.getStmt().executeUpdate(sql);
            } catch (Exception e) {
            }
        }
        ///////////////////////////////// Update Afternoon from Hide to Active /////////////////////////////////////// 
        if(chkbxaMonday.isSelected()){ 
            try {
                String sql = "update tblTeacherTime set Active=1 where TeacherID='"+lblTeacherID.getText()+"' and ShiftID='Sh002' and DayID='Da001'";
                clsCon.getStmt().executeUpdate(sql);
            } catch (Exception e) {
            }
        }
        if(chkbxaTuesday.isSelected()){ 
            try {
                String sql = "update tblTeacherTime set Active=1 where TeacherID='"+lblTeacherID.getText()+"' and ShiftID='Sh002' and DayID='Da002'";
                clsCon.getStmt().executeUpdate(sql);
            } catch (Exception e) {
            }
        }
        if(chkbxaWednesday.isSelected()){ 
            try {
                String sql = "update tblTeacherTime set Active=1 where TeacherID='"+lblTeacherID.getText()+"' and ShiftID='Sh002' and DayID='Da003'";
                clsCon.getStmt().executeUpdate(sql);
            } catch (Exception e) {
            }
        }
        if(chkbxaThursday.isSelected()){ 
            try {
                String sql = "update tblTeacherTime set Active=1 where TeacherID='"+lblTeacherID.getText()+"' and ShiftID='Sh002' and DayID='Da004'";
                clsCon.getStmt().executeUpdate(sql);
            } catch (Exception e) {
            }
        }
        if(chkbxaFriday.isSelected()){ 
            try {
                String sql = "update tblTeacherTime set Active=1 where TeacherID='"+lblTeacherID.getText()+"' and ShiftID='Sh002' and DayID='Da005'";
                clsCon.getStmt().executeUpdate(sql);
            } catch (Exception e) {
            }
        }
        if(chkbxaSaturday.isSelected()){ 
            try {
                String sql = "update tblTeacherTime set Active=1 where TeacherID='"+lblTeacherID.getText()+"' and ShiftID='Sh002' and DayID='Da006'";
                clsCon.getStmt().executeUpdate(sql);
            } catch (Exception e) {
            }
        }
        ///////////////////////////////// Update Evening from Hide to Active /////////////////////////////////////// 
        if(chkbxeMonday.isSelected()){ 
            try {
                String sql = "update tblTeacherTime set Active=1 where TeacherID='"+lblTeacherID.getText()+"' and ShiftID='Sh003' and DayID='Da001'";
                clsCon.getStmt().executeUpdate(sql);
            } catch (Exception e) {
            }
        }
        if(chkbxeTuesday.isSelected()){ 
            try {
                String sql = "update tblTeacherTime set Active=1 where TeacherID='"+lblTeacherID.getText()+"' and ShiftID='Sh003' and DayID='Da002'";
                clsCon.getStmt().executeUpdate(sql);
            } catch (Exception e) {
            }
        }
        if(chkbxeWednesday.isSelected()){ 
            try {
                String sql = "update tblTeacherTime set Active=1 where TeacherID='"+lblTeacherID.getText()+"' and ShiftID='Sh003' and DayID='Da003'";
                clsCon.getStmt().executeUpdate(sql);
            } catch (Exception e) {
            }
        }
        if(chkbxeThursday.isSelected()){ 
            try {
                String sql = "update tblTeacherTime set Active=1 where TeacherID='"+lblTeacherID.getText()+"' and ShiftID='Sh003' and DayID='Da004'";
                clsCon.getStmt().executeUpdate(sql);
            } catch (Exception e) {
            }
        }
        if(chkbxeFriday.isSelected()){ 
            try {
                String sql = "update tblTeacherTime set Active=1 where TeacherID='"+lblTeacherID.getText()+"' and ShiftID='Sh003' and DayID='Da005'";
                clsCon.getStmt().executeUpdate(sql);
            } catch (Exception e) {
            }
        }
        if(chkbxeSaturday.isSelected()){ 
            try {
                String sql = "update tblTeacherTime set Active=1 where TeacherID='"+lblTeacherID.getText()+"' and ShiftID='Sh003' and DayID='Da006'";
                clsCon.getStmt().executeUpdate(sql);
            } catch (Exception e) {
            }
        }
        
        JOptionPane.showMessageDialog(this, "This record was saved");
        clear();       
        
        cboTeacherName.setSelectedItem("--- Select ---");
        lblCourse.setVisible(false);
        lblSubject.setVisible(false);
        lblTeacherName.setVisible(false);
        lblTeacherID.setVisible(false);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        clear();   
        
        cboTeacherName.setSelectedItem("--- Select ---");
        lblCourse.setVisible(false);
        lblSubject.setVisible(false);
        lblTeacherName.setVisible(false);
        lblTeacherID.setVisible(false);
    }//GEN-LAST:event_btnNewActionPerformed

    private void cheMorAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cheMorAllActionPerformed
        //Morning shift
        if(cheMorAll.isSelected())
        {
            chkbxmMonday.setEnabled(false);
            chkbxmTuesday.setEnabled(false);
            chkbxmWednesday.setEnabled(false);
            chkbxmThursday.setEnabled(false);
            chkbxmFriday.setEnabled(false);
            chkbxmSaturday.setEnabled(false);
            
            chkbxmMonday.setSelected(true);
            chkbxmTuesday.setSelected(true);
            chkbxmWednesday.setSelected(true);
            chkbxmThursday.setSelected(true);
            chkbxmFriday.setSelected(true);
            chkbxmSaturday.setSelected(true);
        }else{
            chkbxmMonday.setEnabled(true);
            chkbxmTuesday.setEnabled(true);
            chkbxmWednesday.setEnabled(true);
            chkbxmThursday.setEnabled(true);
            chkbxmFriday.setEnabled(true);
            chkbxmSaturday.setEnabled(true);
            
            chkbxmMonday.setSelected(false);
            chkbxmTuesday.setSelected(false);
            chkbxmWednesday.setSelected(false);
            chkbxmThursday.setSelected(false);
            chkbxmFriday.setSelected(false);
            chkbxmSaturday.setSelected(false);
        }
    }//GEN-LAST:event_cheMorAllActionPerformed

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
            java.util.logging.Logger.getLogger(dlgChooseTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgChooseTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgChooseTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgChooseTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlgChooseTeacher dialog = new dlgChooseTeacher(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnNew;
    private javax.swing.JComboBox<String> cboTeacherName;
    private javax.swing.JCheckBox cheAftAll;
    private javax.swing.JCheckBox cheEveAll;
    private javax.swing.JCheckBox cheMorAll;
    private javax.swing.JCheckBox chkbxAfternoon;
    private javax.swing.JCheckBox chkbxEvening;
    private javax.swing.JCheckBox chkbxMorning;
    private javax.swing.JCheckBox chkbxaFriday;
    private javax.swing.JCheckBox chkbxaMonday;
    private javax.swing.JCheckBox chkbxaSaturday;
    private javax.swing.JCheckBox chkbxaThursday;
    private javax.swing.JCheckBox chkbxaTuesday;
    private javax.swing.JCheckBox chkbxaWednesday;
    private javax.swing.JCheckBox chkbxeFriday;
    private javax.swing.JCheckBox chkbxeMonday;
    private javax.swing.JCheckBox chkbxeSaturday;
    private javax.swing.JCheckBox chkbxeThursday;
    private javax.swing.JCheckBox chkbxeTuesday;
    private javax.swing.JCheckBox chkbxeWednesday;
    private javax.swing.JCheckBox chkbxmFriday;
    private javax.swing.JCheckBox chkbxmMonday;
    private javax.swing.JCheckBox chkbxmSaturday;
    private javax.swing.JCheckBox chkbxmThursday;
    private javax.swing.JCheckBox chkbxmTuesday;
    private javax.swing.JCheckBox chkbxmWednesday;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblCourse;
    private javax.swing.JLabel lblSubject;
    private javax.swing.JLabel lblTeacherID;
    private javax.swing.JLabel lblTeacherName;
    private javax.swing.JPanel plAfternon;
    private javax.swing.JPanel plEvening;
    private javax.swing.JPanel plMoring;
    // End of variables declaration//GEN-END:variables
}
