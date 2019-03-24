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
public class dlgTeacher extends javax.swing.JDialog {

    /**
     * Creates new form dlgTeacher
     */
    public dlgTeacher(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        clsCon.inti();
        getCboCourse();
        getCourseID();
        viewTescher();
        this.setLocationRelativeTo(null);
        btnDelete.setEnabled(false);
        btnUpdate.setEnabled(false);
        getIdAuto();
        jtblTescher.setDefaultEditor(Object.class,null);
        lblSubject.setVisible(false);
        lblCourseID.setVisible(false);
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
                if(cboCourse.getSelectedItem().equals("--- Select ---")){
                    cboSubject.removeAllItems();
                    cboSubject.addItem("--- Select ---");
                    return;
                }
                String c=(String) cboCourse.getSelectedItem();
                try {
                    clsCon.setRs(clsCon.getStmt().executeQuery("Select SubjectName,CourseID from qCourseSubject where CourseName='"+c+"'"));
                    clsCon.getRs().first();
                    lblCourseID.setText(clsCon.getRs().getString("CourseID"));
                    cboSubject.removeAllItems();
                    cboSubject.addItem("--- Select ---");
                    if(clsCon.getRs().getString("SubjectName").equals("")||clsCon.getRs().getString("SubjectName").isEmpty())
                        return;
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
        if(cboSubject.getSelectedItem().equals("--- Select ---"))
            return;
        String c=(String) cboSubject.getSelectedItem();
        try {
            clsCon.setRs(clsCon.getStmt().executeQuery("Select SubjectID from qCourseSubject where SubjectName='"+c+"'"));
            clsCon.getRs().first();
            lblSubject.setText(clsCon.getRs().getString("SubjectID"));            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
     void viewTescher(){
        DefaultTableModel modeTbl;
        modeTbl = (DefaultTableModel)jtblTescher.getModel();
       
        try {
            clsCon.setRs(clsCon.getStmt().executeQuery("select * from qTeacher order by TeacherID ASC"));
            if(clsCon.getRs().first()){  
                do{
                    String id = clsCon.getRs().getString("TeacherID");
                    String name = clsCon.getRs().getString("Name");
                    String gender = clsCon.getRs().getString("Gender");
                    String phone = clsCon.getRs().getString("Phone");
                    String Course=clsCon.getRs().getString("CourseName");
                    String Subject=clsCon.getRs().getString("SubjectName");
                    String st[]={id,name,gender,phone,Course,Subject};
                    
                    modeTbl.addRow(st);
                }while(clsCon.getRs().next());
            }
        } catch (Exception e) {
        }
    }
    void clear(){
        clsCon.clear(txtName);      
        clsCon.clear(txtPhone);
        cboGender.setSelectedItem(0);
        txtName.requestFocus();  
        cboCourse.setSelectedItem("--- Select ---");
        
    } 
    int i=0;
    void getIdAuto(){
        try {
            clsCon.setRs(clsCon.getStmt().executeQuery("select * from qMaxTeacher"));
            clsCon.getRs().first();
            i = clsCon.getRs().getInt(1)+1;
            String m="";
            if(i<10)
                m = "00"+i;
            else if(i<100)
                m = "0"+i;    
            txtID.setText("Te"+m);
        } catch (Exception e) {
        }
    }
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
        txtID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblTescher = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        cboCourse = new javax.swing.JComboBox<>();
        lblCourseID = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cboSubject = new javax.swing.JComboBox<>();
        lblSubject = new javax.swing.JLabel();

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
        jLabel1.setText("Teacher Information");

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

        txtID.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtID.setFocusable(false);
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setText("Teacher Name");

        txtName.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setText("Gender");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel6.setText("Teacher ID");

        jtblTescher.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Teacher ID", "Teacher Name", "Gender", "Phone", "Course", "Subject"
            }
        ));
        jtblTescher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblTescherMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtblTescher);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel11.setText("Course");

        cboCourse.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        lblCourseID.setText("ClassName");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel12.setText("Subject");

        cboSubject.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        lblSubject.setText("Subject");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cboCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(lblCourseID))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cboSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(lblSubject)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNew)
                            .addComponent(btnUpdate)
                            .addComponent(btnDelete)
                            .addComponent(btnAdd))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cboGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(cboCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCourseID))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(cboSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSubject))
                        .addGap(0, 20, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
         btnAdd.setEnabled(true);
        btnDelete.setEnabled(false);
        btnUpdate.setEnabled(false);

        getIdAuto();
        clear();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        getSubjectID();
        int index = jtblTescher.getSelectedRow();
        if(index==-1 || cboCourse.getSelectedItem().equals("--- Select ---")||cboSubject.getSelectedItem().equals("--- Select ---"))
            return;
        
        String  sql="update tblTeacher set Name='"+txtName.getText()+"', Gender='"+cboGender.getSelectedItem()+"',Phone='"+txtPhone.getText()+"',CourseID='"+lblCourseID.getText()+"',SubjectID='"+lblSubject.getText()+"' where TeacherID='"+txtID.getText()+"'";
        try {
            clsCon.getStmt().executeUpdate(sql);
            JOptionPane.showMessageDialog(this, "Update is successful");
            jtblTescher.setValueAt(txtName.getText(), index, 1);
            jtblTescher.setValueAt(cboGender.getSelectedItem(), index, 2);
            jtblTescher.setValueAt(txtPhone.getText(), index, 3);
            jtblTescher.setValueAt(cboCourse.getSelectedItem(), index, 4);
            jtblTescher.setValueAt(cboSubject.getSelectedItem(), index, 5);
            //            clear();
            //            txtID.setText("");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Cannot Update.");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if(jtblTescher.getSelectedRow() == -1)
        return;
        if(JOptionPane.showConfirmDialog(this, "Do you want to delete?","Comfire",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
            try{
                int index[] = jtblTescher.getSelectedRows();
                clsCon.getStmt().execute("delete from tblTeacher where TeacherID ='"+txtID.getText()+"'");
                JOptionPane.showMessageDialog(this, "Delete is successful.");
                clear();
                txtID.setText("");                

                DefaultTableModel modtable = (DefaultTableModel)jtblTescher.getModel();
                for(int i=0; i<index.length; i++)
                modtable.removeRow(index[i]-i);
                
                if(jtblTescher.getRowCount()==0){
                    btnAdd.setEnabled(true);
                    btnDelete.setEnabled(false);
                    btnUpdate.setEnabled(false);
                    getIdAuto();
                }
            }catch(Exception e){

            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        getSubjectID();
        if(cboCourse.getSelectedItem().equals("--- Select ---")||cboSubject.getSelectedItem().equals("--- Select ---"))
            return;
        if(txtName.getText().equals("")||txtPhone.getText().equals(""))
        {
             JOptionPane.showMessageDialog(this, "Plase Input each field");
             txtName.requestFocus();
             return;
        }    
        String  sql="insert into tblTeacher(TeacherID,Name,Gender,Phone,CourseID,SubjectID,Auto) values('"+txtID.getText()+"','" + txtName.getText()+ "','"+cboGender.getSelectedItem()+"','"+txtPhone.getText()+"','"+lblCourseID.getText()+"','"+ lblSubject.getText()+"','"+i+"')";
        try {
            clsCon.getStmt().executeUpdate(sql);
            JOptionPane.showMessageDialog(this, "A new record was saved");
         

            DefaultTableModel modeTbl = (DefaultTableModel)jtblTescher.getModel();
            clsCon.setRs(clsCon.getStmt().executeQuery("select * from qTeacher where TeacherID='"+txtID.getText()+"'"));

            clsCon.getRs().first();
            String id = clsCon.getRs().getString("TeacherID");
            String name = clsCon.getRs().getString("Name");
            String gender = clsCon.getRs().getString("Gender");
            String phone = clsCon.getRs().getString("Phone");
            String Course=clsCon.getRs().getString("CourseName");
            String Subject=clsCon.getRs().getString("SubjectName");
            String st[]={id,name,gender,phone,Course,Subject};

            modeTbl.addRow(st);
            getIdAuto();
               clear();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void jtblTescherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblTescherMouseClicked
         btnAdd.setEnabled(false);
        btnDelete.setEnabled(true);
        btnUpdate.setEnabled(true);

        int index = jtblTescher.getSelectedRow();
        String ID = ""+jtblTescher.getValueAt(index, 0); //EmpID
        String Name = ""+jtblTescher.getValueAt(index, 1); //EmpName
        String Gender = ""+jtblTescher.getValueAt(index, 2); //Gender
        String phone = ""+jtblTescher.getValueAt(index, 3); //Phone
        String Course=""+jtblTescher.getValueAt(index, 4);//Course
        String Subject=""+jtblTescher.getValueAt(index, 5);//Subject
        txtID.setText(ID);
        txtName.setText(Name);
        cboGender.setSelectedItem(Gender);
        txtPhone.setText(phone);
        cboCourse.setSelectedItem(Course);
        cboSubject.setSelectedItem(Subject);
    }//GEN-LAST:event_jtblTescherMouseClicked

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
            java.util.logging.Logger.getLogger(dlgTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlgTeacher dialog = new dlgTeacher(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> cboCourse;
    private javax.swing.JComboBox<String> cboGender;
    private javax.swing.JComboBox<String> cboSubject;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtblTescher;
    private javax.swing.JLabel lblCourseID;
    private javax.swing.JLabel lblSubject;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
