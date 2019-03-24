/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class dlgRoom extends javax.swing.JDialog {

    /**
     * Creates new form dlgRoom
     */
    public dlgRoom(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        clsCon.inti();
        showData();
        getIdAuto();
        setLocationRelativeTo(null);
        btnDelete.setEnabled(false);
        btnUpdate.setEnabled(false);
        jtblRoom.setDefaultEditor(Object.class,null);
        txtRoomNumber.requestFocus();
    }
 public void clear(){
        txtRoomID.setText("");
        txtRoomNumber.setText("");
        txtTable.setText("");
 }
  void showData(){
        DefaultTableModel modeTbl;
        modeTbl = (DefaultTableModel)jtblRoom.getModel();
       
        try {
            clsCon.setRs(clsCon.getStmt().executeQuery("select * from tblRoom "));
            if(clsCon.getRs().first()){  
                do{
                    String roomid = clsCon.getRs().getString("RoomID");
                    String roomName = clsCon.getRs().getString("RoomNumber");
                    String building = clsCon.getRs().getString("Building");
                    String table = String.valueOf(clsCon.getRs().getByte("Tables"));
                    String st[]={roomid,roomName,table,building};
                    
                    modeTbl.addRow(st);
                }while(clsCon.getRs().next());
            }
        } catch (Exception e) {
        }
    }
  int i=0;
   void getIdAuto(){
        try {
            clsCon.setRs(clsCon.getStmt().executeQuery("select * from qMaxRoom"));
            clsCon.getRs().first();
            i = clsCon.getRs().getInt(1)+1;
            String m="";
            if(i<10)
                m = "00"+i;
            else if(i<100)
                m = "0"+i;    
            txtRoomID.setText("Rm"+m);
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
        jLabel2 = new javax.swing.JLabel();
        txtRoomID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtRoomNumber = new javax.swing.JTextField();
        lblAlert1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblRoom = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        cboBuilding = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtTable = new javax.swing.JTextField();

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
        jLabel1.setText("            Room Information");

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
        jLabel2.setText("Room ID");

        txtRoomID.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtRoomID.setFocusable(false);
        txtRoomID.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtRoomIDCaretUpdate(evt);
            }
        });
        txtRoomID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRoomIDActionPerformed(evt);
            }
        });
        txtRoomID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRoomIDKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setText("Room Number");

        txtRoomNumber.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        lblAlert1.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblAlert1.setForeground(new java.awt.Color(255, 0, 0));

        jtblRoom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RoomID", "Room Number", "Tables", "Building"
            }
        ));
        jtblRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblRoomMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtblRoom);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setText("Building");

        cboBuilding.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        cboBuilding.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Select ---", "A", "B", "C", "D" }));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel5.setText("Tables Amount");

        txtTable.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtTable.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(lblAlert1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(49, 49, 49)
                                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtRoomID, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(cboBuilding, javax.swing.GroupLayout.Alignment.LEADING, 0, 308, Short.MAX_VALUE)
                                        .addComponent(txtRoomNumber, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtTable, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addGap(47, 47, 47)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNew)
                            .addComponent(btnAdd)
                            .addComponent(btnUpdate)
                            .addComponent(btnDelete))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtRoomID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtRoomNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAlert1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboBuilding, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addGap(103, 103, 103))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(216, 216, 216)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        btnAdd.setEnabled(true);
        btnDelete.setEnabled(false);
        btnUpdate.setEnabled(false);
        txtRoomNumber.requestFocus();
        cboBuilding.setSelectedIndex(0);
        clear();
       getIdAuto();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if(cboBuilding.getSelectedItem().equals("--- Select ---"))
            return;
        try {
            do{
                try {
                    if(txtRoomNumber.getText().equals(clsCon.getRs().getString("RoomNumber"))& cboBuilding.getSelectedItem().equals(clsCon.getRs().getString("Building")))
                    {
                        JOptionPane.showMessageDialog(this, "The Room has already in the building");
                        txtRoomNumber.requestFocus();
                        return;                       
                    }
                } catch (SQLException ex) {
                }
            }while (clsCon.getRs().next());
        } catch (SQLException ex) {
        }
        int index = jtblRoom.getSelectedRow();
        if(index==-1)
        return;
        String  sql="update tblRoom set RoomNumber='"+txtRoomNumber.getText()+"', Tables='"+ txtTable.getText() +"' , Building='"+cboBuilding.getSelectedItem()+"' where RoomID='"+txtRoomID.getText()+"'";
        try {
            clsCon.getStmt().executeUpdate(sql);
            JOptionPane.showMessageDialog(this, "Update is successful");

            jtblRoom.setValueAt(txtRoomNumber.getText(), index, 1);
            jtblRoom.setValueAt(txtTable.getText(), index, 2);
            jtblRoom.setValueAt(cboBuilding.getSelectedItem(), index, 3);
            clear();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Cannot Update.");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
          if(jtblRoom.getSelectedRow() == -1)
        return;
     
        if(JOptionPane.showConfirmDialog(this, "Do you want to delete?","Comfire",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
            try{
                int index[] = jtblRoom.getSelectedRows();
                clsCon.getStmt().execute("delete from tblRoom where RoomID ='"+txtRoomID.getText()+"'");
                JOptionPane.showMessageDialog(this, "Delete is successful.");
                clear();
                getIdAuto();
                DefaultTableModel modtable = (DefaultTableModel)jtblRoom.getModel();
                for(int i=0; i<index.length; i++)
                modtable.removeRow(index[i]-i);
                if(jtblRoom.getRowCount()==0){
                    btnAdd.setEnabled(true);
                    btnDelete.setEnabled(false);
                    btnUpdate.setEnabled(false);

                    cboBuilding.setSelectedIndex(0);
                    
                }
            }catch(Exception e){

            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    void checkRoom(){
       try {
            clsCon.setRs(clsCon.getStmt().executeQuery("select * from qroom"));
            clsCon.getRs().first();
        }
         catch (SQLException ex) {}
    }
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        checkRoom();
        if(cboBuilding.getSelectedItem().equals("--- Select ---"))
            return;
        try {
            do{
                try {
                    if(txtRoomNumber.getText().equals(clsCon.getRs().getString("RoomNumber"))& cboBuilding.getSelectedItem().equals(clsCon.getRs().getString("Building")))
                    {
                        JOptionPane.showMessageDialog(this, "The Room has already in the building");
                        txtRoomNumber.requestFocus();
                        return;                       
                    }
                } catch (SQLException ex) {
                }
            }while (clsCon.getRs().next());
        } catch (SQLException ex) {
        }
        if(txtRoomNumber.getText().equals("")){
             JOptionPane.showMessageDialog(this, "Please Input RoomNumber");
             txtRoomNumber.requestFocus();
             return;
        }
            
        String sql = "insert into tblRoom(RoomID,RoomNumber,Tables,Building,Auto) values('"+txtRoomID.getText()+"','"+txtRoomNumber.getText()+"','"+txtTable.getText()+"','"+cboBuilding.getSelectedItem()+"','"+i+"')";
        try {
            clsCon.getStmt().executeUpdate(sql);
            JOptionPane.showMessageDialog(this, "A new record was saved");
            

            DefaultTableModel modeTbl = (DefaultTableModel)jtblRoom.getModel();
            clsCon.setRs(clsCon.getStmt().executeQuery("select * from tblRoom where RoomID='"+txtRoomID.getText()+"'"));

            clsCon.getRs().first();
            String roomid = clsCon.getRs().getString("RoomID");
            String roomName = clsCon.getRs().getString("RoomNumber");
            String building = clsCon.getRs().getString("Building");
            String table = String.valueOf(clsCon.getRs().getByte("Tables"));
            String st[]={roomid,roomName,table,building};
            clear();
            modeTbl.addRow(st);
            getIdAuto();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtRoomIDCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtRoomIDCaretUpdate

    }//GEN-LAST:event_txtRoomIDCaretUpdate

    private void txtRoomIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRoomIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRoomIDActionPerformed

    private void txtRoomIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRoomIDKeyTyped

    }//GEN-LAST:event_txtRoomIDKeyTyped

    private void jtblRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblRoomMouseClicked
        btnAdd.setEnabled(false);
        btnDelete.setEnabled(true);
        btnUpdate.setEnabled(true);

        int index = jtblRoom.getSelectedRow();
        String roomid = ""+jtblRoom.getValueAt(index, 0); //RoomID
        String roomnumber = ""+jtblRoom.getValueAt(index, 1); //Roomnumber
        String table = ""+jtblRoom.getValueAt(index, 2); //Tables
        String building = ""+jtblRoom.getValueAt(index, 3); //building
        cboBuilding.setSelectedItem(building);
        txtRoomID.setText(roomid);
        txtRoomNumber.setText(roomnumber);
        txtTable.setText(table);
        
    }//GEN-LAST:event_jtblRoomMouseClicked

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
            java.util.logging.Logger.getLogger(dlgRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlgRoom dialog = new dlgRoom(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboBuilding;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtblRoom;
    private javax.swing.JLabel lblAlert1;
    private javax.swing.JTextField txtRoomID;
    private javax.swing.JTextField txtRoomNumber;
    private javax.swing.JTextField txtTable;
    // End of variables declaration//GEN-END:variables
}
