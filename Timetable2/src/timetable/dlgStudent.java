/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class dlgStudent extends javax.swing.JDialog {

    /**
     * Creates new form frmStudent
     */
    public dlgStudent(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        clsCon.inti();
        txtName.requestFocus();
        setLocationRelativeTo(null);
        btnDelete.setEnabled(false);
        btnUpdate.setEnabled(false);
        viewStu();
        getIdAuto();
        intiSemester();
        intiClass();
        intiCourse();
        getClassName();
        getSemesterName();
        getCourseName();
        jtblStu.setDefaultEditor(Object.class,null);
        lblAlert1.setVisible(false);
        lblClassID.setVisible(false);
        lblCourse.setVisible(false);
        lblSemesterID.setVisible(false);
    }
    int i=0;
    int  a=0;
    void getClassName(){
        cboClassID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
               String c=(String) cboClassID.getSelectedItem();
               try {
                    clsCon.setRs(clsCon.getStmt().executeQuery("Select ClassID from tblClass where ClassName='"+c+"'"));
                    clsCon.getRs().first();
                    lblClassID.setText(clsCon.getRs().getString("ClassID"));
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    void getSemesterName(){
        cboSemesterid.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
               String s=(String) cboSemesterid.getSelectedItem();
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
    void getCourseName(){
        cboCourse.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
               String s=(String) cboCourse.getSelectedItem();
               try {
                    clsCon.setRs(clsCon.getStmt().executeQuery("Select CourseID from tblCourse where CourseName='"+s+"'"));
                    clsCon.getRs().first();
                    lblCourse.setText(clsCon.getRs().getString("CourseID"));
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    void intiSemester(){        
        cboSemesterid.removeAllItems();
        try {    
                clsCon.setRs(clsCon.getStmt().executeQuery("select * from tblSemester"));
                clsCon.getRs().first();
                 lblSemesterID.setText(clsCon.getRs().getString("SemesterID"));
                if(clsCon.getRs().first())
                    do{
                        cboSemesterid.addItem(clsCon.getRs().getString("Semester"));
                    }while(clsCon.getRs().next());
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    void intiClass(){        
        cboClassID.removeAllItems();
        try {    
                clsCon.setRs(clsCon.getStmt().executeQuery("select * from tblClass"));
                clsCon.getRs().first();
                  lblClassID.setText(clsCon.getRs().getString("ClassID"));
                if(clsCon.getRs().first())
                    do{
                        cboClassID.addItem(clsCon.getRs().getString("ClassName"));
                    }while(clsCon.getRs().next());
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    void intiCourse(){        
        cboCourse.removeAllItems();
        try {    
                clsCon.setRs(clsCon.getStmt().executeQuery("select * from tblCourse"));
                clsCon.getRs().first();
                  lblCourse.setText(clsCon.getRs().getString("CourseID"));
                if(clsCon.getRs().first())
                    do{
                        cboCourse.addItem(clsCon.getRs().getString("CourseName"));
                    }while(clsCon.getRs().next());
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    } 
    
    public void clear(){
        clsCon.clear(txtID);
        clsCon.clear(txtName);
        clsCon.clear(txtAddress);
        clsCon.clear(txtPhone);
        clsCon.clear(txtDOB);} 
   
    public void viewStu(){
        DefaultTableModel modeTbl;
        modeTbl = (DefaultTableModel)jtblStu.getModel();
       
        try {
            clsCon.setRs(clsCon.getStmt().executeQuery("select * from qStu order by StuID ASC"));
            if(clsCon.getRs().first()){  
                do{
                    String id = clsCon.getRs().getString("StuID");
                    String name = clsCon.getRs().getString("StuName");
                    String gender = clsCon.getRs().getString("Gender");
                    String dob = clsCon.getRs().getString("DOB");
                    String address=clsCon.getRs().getString("Address");
                    String phone = clsCon.getRs().getString("Phone");
                    String course = clsCon.getRs().getString("CourseName");
                    String Class=clsCon.getRs().getString("ClassName");
                    String Semester=clsCon.getRs().getString("Semester");
                    String st[]={id,name,gender,dob,address,phone,course,Class,Semester};
                    modeTbl.addRow(st);
                }while(clsCon.getRs().next());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Cannot");
        }   
    }   
    void getIdAuto(){
        try {
            clsCon.setRs(clsCon.getStmt().executeQuery("select * from qMaxStu"));
            clsCon.getRs().first();
            i = clsCon.getRs().getInt(1)+1;
            String m="";
            if(i<10)
                m = "00"+i;
            else if(i<100)
                m = "0"+i;    
            txtID.setText("S"+m);
        } catch (Exception e) {
        }
    }
     void checkStuName(){
        lblAlert1.setVisible(false);
        lblAlert1.setText("Alert");        
        if(txtName.getText().equals("")){
                lblAlert1.setText("Please Fill");
                lblAlert1.setVisible(true);
            }
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
        jLabel7 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        cboGender = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDOB = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btndata = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cboSemesterid = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblStu = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        lblAlert1 = new javax.swing.JLabel();
        lblSemesterID = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cboCourse = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        lblCourse = new javax.swing.JLabel();
        cboClassID = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        lblClassID = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAutoRequestFocus(false);
        setFocusTraversalPolicyProvider(true);
        setMaximumSize(null);
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));
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
        jLabel1.setText("Student ' s Information");

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

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel7.setText("Phone");

        txtPhone.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        cboGender.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        cboGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setText("Student ID");

        txtID.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtID.setFocusable(false);
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setText("Student Name");

        txtName.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setText("Gender");

        txtDOB.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel5.setText("DOB");

        btndata.setText(".....");
        btndata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndataActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel10.setText("Semester ");

        cboSemesterid.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jtblStu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Student Name", "Gender", "DOB", "Address", "Phone", "Course", "Class Name", "Semester"
            }
        ));
        jtblStu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblStuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtblStu);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel8.setText("Address");

        txtAddress.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        lblAlert1.setForeground(new java.awt.Color(255, 0, 51));

        lblSemesterID.setText("Semester");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel11.setText("Course");

        cboCourse.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        cboCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCourseActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));

        lblCourse.setText("ClassName");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lblCourse)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 8, Short.MAX_VALUE)
                .addComponent(lblCourse))
        );

        cboClassID.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        cboClassID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboClassIDActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel9.setText("Class Name");

        lblClassID.setText("ClassName");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(71, 71, 71)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtDOB, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btndata))
                            .addComponent(cboGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblAlert1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtAddress, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                                .addComponent(txtPhone, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(cboCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboSemesterid, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboClassID, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSemesterID)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblClassID))
                        .addGap(6, 6, 6)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1060, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnAdd))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAlert1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cboGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(btndata))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPhone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(29, 29, 29)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(lblSemesterID)))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(cboCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cboSemesterid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboClassID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(lblClassID))
                        .addGap(27, 27, 27))
                    .addComponent(jScrollPane1))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(394, 394, 394)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
    
        clear();
           getIdAuto();
           btnAdd.setEnabled(true);
           btnUpdate.setEnabled(false);
           btnDelete.setEnabled(false);
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
    if(jtblStu.getSelectedRow() == -1)
        return;
        if(JOptionPane.showConfirmDialog(this, "Do you want to delete?","Comfire",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
            try{
                int index[] = jtblStu.getSelectedRows();
                clsCon.getStmt().execute("delete from tblStudent where StuID ='"+txtID.getText()+"'");
                JOptionPane.showMessageDialog(this, "Delete is successful.");
                clear();
                 getIdAuto();
                btnAdd.setEnabled(true);
                btnDelete.setEnabled(false);
                btnUpdate.setEnabled(false);             

                DefaultTableModel modtable = (DefaultTableModel)jtblStu.getModel();
                for(int i=0; i<index.length; i++)
                modtable.removeRow(index[i]-i);
            }catch(Exception e){
            }
        }
        
    }//GEN-LAST:event_btnDeleteActionPerformed
    
    public void CheckCLass(){
        try {
            clsCon.setRs(clsCon.getStmt().executeQuery("select * from qStuAmount where ClassID = '"+lblClassID.getText()+"' and SemesterID = '"+lblSemesterID.getText()+"' and CourseID="+lblCourse.getText()+""));
            clsCon.getRs().first();
            a=Integer.parseInt(clsCon.getRs().getString("Amount"));            
        }
         catch (SQLException ex) {}
    }
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        
        if(txtName.getText().equals("")||txtAddress.getText().equals("")||txtPhone.getText().equals("")||txtDOB.getText().equals(""))
        {
             JOptionPane.showMessageDialog(this, "Plase Input each field");
             return;
        }        
        CheckCLass();
        if(a>4){
            JOptionPane.showMessageDialog(this, "This class is full.\n Maximum is 5 students.");
            txtName.requestFocus();
            a=0;
            return;
            
        }
        String  sql="insert into tblStudent(StuID,StuName,Gender,DOB,Address,Phone,CourseID,ClassID,SemesterID,Auto) values('"+txtID.getText()+"','" + txtName.getText()+ "','"+cboGender.getSelectedItem()+"','"+txtDOB.getText()+"','"+txtAddress.getText()+"','"+txtPhone.getText()+"','"+lblCourse.getText()+"','"+lblClassID.getText()+"','"+lblSemesterID.getText()+"','"+i+"')";
        try {
            clsCon.getStmt().executeUpdate(sql);
            
             JOptionPane.showMessageDialog(this, "Add is successful");
             
           DefaultTableModel modeTbl = (DefaultTableModel)jtblStu.getModel();
              clsCon.setRs(clsCon.getStmt().executeQuery("select * from qStu where StuID='"+txtID.getText()+"'"));
              clsCon.getRs().first();
              
                    String id = clsCon.getRs().getString("StuID");
                    String name = clsCon.getRs().getString("StuName");
                    String gender = clsCon.getRs().getString("Gender");
                    String dob = clsCon.getRs().getString("DOB");
                    String address=clsCon.getRs().getString("Address");
                    String phone = clsCon.getRs().getString("Phone");
                    String course = clsCon.getRs().getString("CourseName");
                    String ClassID=clsCon.getRs().getString("ClassName");
                    String Semester=clsCon.getRs().getString("Semester");
                    String st[]={id,name,gender,dob,address,phone,course,ClassID,Semester};
                    modeTbl.addRow(st);
                    clear();
                    getIdAuto();                  

        } catch (SQLException ex) {
            ex.printStackTrace();
        }  
        a=0;
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void btndataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndataActionPerformed
        PanDate.PanDate p=new PanDate.PanDate(null,true);
        p.setLocation(txtDOB);
        p.setVisible(true);
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MMM/yyyy");
        txtDOB.setText(sdf.format(p.getDate()));        
    }//GEN-LAST:event_btndataActionPerformed

    private void cboClassIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboClassIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboClassIDActionPerformed

    private void jtblStuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblStuMouseClicked
      btnDelete.setEnabled(true);
      btnUpdate.setEnabled(true);
      int index = jtblStu.getSelectedRow();
        String ID = ""+jtblStu.getValueAt(index, 0); //EmpID
        String Name = ""+jtblStu.getValueAt(index, 1); //EmpName
        String Gender = ""+jtblStu.getValueAt(index, 2); //Gender
        String DOB = ""+jtblStu.getValueAt(index, 3); //DOB
        String Address=""+jtblStu.getValueAt(index, 4);//Address
        String phone = ""+jtblStu.getValueAt(index, 5); //Phone
        String Course=""+jtblStu.getValueAt(index,6);//Course
        String ClassName=""+jtblStu.getValueAt(index,7);//Class
        String Semester=""+jtblStu.getValueAt(index,8);//Semester
        txtID.setText(ID);
        txtName.setText(Name);
        cboGender.setSelectedItem(Gender);
        txtDOB.setText(DOB);
        txtAddress.setText(Address);
        txtPhone.setText(phone);
        cboCourse.setSelectedItem(Course);
        cboClassID.setSelectedItem(ClassName);
        cboSemesterid.setSelectedItem(Semester);
        btnAdd.setEnabled(false);
    }//GEN-LAST:event_jtblStuMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int index = jtblStu.getSelectedRow();
        if(index==-1)
            return;
        if(txtName.getText().equals("")||txtAddress.getText().equals("")||txtPhone.getText().equals("")||txtDOB.getText().equals(""))
        {
             JOptionPane.showMessageDialog(this, "Plase Input each field");
             txtID.requestFocus();
             return;
        }
        CheckCLass();
        if(a>4){
            JOptionPane.showMessageDialog(this, "This class is full.\n Maximum is 5 students.");
            txtName.requestFocus();
            a=0;
            return;
        }
        String  sql="update tblStudent set StuName='"+txtName.getText()+"', Gender='"+cboGender.getSelectedItem()+"', DOB='"+txtDOB.getText()+"',Address='"+txtAddress.getText()+"',Phone='"+txtPhone.getText()+"',CourseID='"+lblCourse.getText()+"',ClassID='"+lblClassID.getText()+"',SemesterID='"+lblSemesterID.getText()+"' where StuID='"+txtID.getText()+"'";
        try {
            clsCon.getStmt().executeUpdate(sql);
            JOptionPane.showMessageDialog(this, "Update is successful");
            jtblStu.setValueAt(txtName.getText(), index, 1);
            jtblStu.setValueAt(cboGender.getSelectedItem(), index, 2);
            jtblStu.setValueAt(txtDOB.getText(), index, 3);
            jtblStu.setValueAt(txtAddress.getText(), index, 4);
            jtblStu.setValueAt(txtPhone.getText(), index, 5);
            jtblStu.setValueAt(cboCourse.getSelectedItem(), index, 6);
            jtblStu.setValueAt(cboClassID.getSelectedItem(), index, 7);
            jtblStu.setValueAt(cboSemesterid.getSelectedItem(), index, 8);
                clear();
                getIdAuto();
                btnUpdate.setEnabled(false);
                btnDelete.setEnabled(false);
                btnAdd.setEnabled(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Cannot Update.");
        }
        a=0;
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void cboCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCourseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboCourseActionPerformed

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
            java.util.logging.Logger.getLogger(dlgStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlgStudent dialog = new dlgStudent(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btndata;
    private javax.swing.JComboBox<String> cboClassID;
    private javax.swing.JComboBox<String> cboCourse;
    private javax.swing.JComboBox<String> cboGender;
    private javax.swing.JComboBox<String> cboSemesterid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtblStu;
    private javax.swing.JLabel lblAlert1;
    private javax.swing.JLabel lblClassID;
    private javax.swing.JLabel lblCourse;
    private javax.swing.JLabel lblSemesterID;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtDOB;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
