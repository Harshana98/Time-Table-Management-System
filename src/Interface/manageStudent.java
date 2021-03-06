/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

import Code.DBconect;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Kasun Deeptha
 */
public class manageStudent extends javax.swing.JFrame {

    /** Creates new form manageStudent */
    
    private static Statement st;
    Connection conn = null;
    ResultSet rs = null;
    
    
    public manageStudent() {
        initComponents();
        st= DBconect.connect();
        tableload();
    }

    public void tableload(){
    
        try {
            String sql = "SELECT id AS ID,AcademicYearSemester AS 'ACADEMIC YEAR AND SEMESTER',Programme AS PROGRAMME,GroupNumber AS 'GROUP NUMBER',SubGroupNumber AS 'SUB GROUP NUMBER',GroupID AS 'GROUP ID',SubGroupID AS 'SUB GROUP ID' FROM studentgroup";
            rs = st.executeQuery(sql);
            studentGroupTable.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public void tabledata() {
    
        int r = studentGroupTable.getSelectedRow();
        
        String yearAndSem = studentGroupTable.getValueAt(r, 1).toString();
        String programme = studentGroupTable.getValueAt(r, 2).toString();
        int groupNumber = (int) studentGroupTable.getValueAt(r,3);
        int subGroupNumber = (int) studentGroupTable.getValueAt(r,4);
        String groupId = studentGroupTable.getValueAt(r,5).toString();
        String SubgroupId = studentGroupTable.getValueAt(r,6).toString();
        
        YearSemBox.setSelectedItem(yearAndSem);
        ProgrammeBox.setSelectedItem(programme);
        gNumberBox.setValue(groupNumber);
        SubGNumberBox.setValue(subGroupNumber);
        gIdBox.setText(groupId);
        SubGIdBox.setText(SubgroupId);
        
    }
    
    public void clear() {
    
        YearSemBox.setSelectedIndex(0);
        ProgrammeBox.setSelectedIndex(0);
        gNumberBox.setValue(0);
        SubGNumberBox.setValue(0);
        gIdBox.setText("");
        SubGIdBox.setText("");
        
    }
     
    public void update() {
    
        int r = studentGroupTable.getSelectedRow();
        int value = (int) (studentGroupTable.getModel().getValueAt(r, 0));
        
        String yearAndSem = YearSemBox.getSelectedItem().toString();
        String programme = ProgrammeBox.getSelectedItem().toString();
        int groupNumber = (int)gNumberBox.getValue();
        int subGroupNumber = (int)SubGNumberBox.getValue();
        String groupId = gIdBox.getText();
        String SubgroupId = SubGIdBox.getText();
        
        try {
            String sql = "UPDATE studentgroup SET AcademicYearSemester='"+yearAndSem+"',Programme='"+programme+"',"
                    + "GroupNumber='"+groupNumber+"',SubGroupNumber='"+subGroupNumber+"',GroupID='"+groupId+"',SubGroupID='"+SubgroupId+"'"
                    + "WHERE id='"+value+"'";
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Group updated successfully");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null,e);
        }
     
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
        jScrollPane1 = new javax.swing.JScrollPane();
        studentGroupTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        YearSemBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        ProgrammeBox = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        gNumberBox = new com.toedter.components.JSpinField();
        jLabel5 = new javax.swing.JLabel();
        SubGNumberBox = new com.toedter.components.JSpinField();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        generateBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        gIdBox = new javax.swing.JLabel();
        SubGIdBox = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1370, 700));
        setMinimumSize(new java.awt.Dimension(1370, 700));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(710, 383));
        jPanel1.setMinimumSize(new java.awt.Dimension(710, 383));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        studentGroupTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        studentGroupTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        studentGroupTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentGroupTableMouseClicked(evt);
            }
        });
        studentGroupTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                studentGroupTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(studentGroupTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 1340, 110));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Academic year semester");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, -1, -1));

        YearSemBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        YearSemBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Y1.S1", "Y1.S2", "Y2.S1", "Y2.S2", "Y3.S1", "Y3.S2", "Y4.S1", "Y4.S2" }));
        YearSemBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YearSemBoxActionPerformed(evt);
            }
        });
        jPanel1.add(YearSemBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 300, 80, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Programme");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, -1, -1));

        ProgrammeBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ProgrammeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IT", "IM", "SE", "DS", "CS" }));
        jPanel1.add(ProgrammeBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 380, 80, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Group number");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 460, -1, -1));

        gNumberBox.setMinimum(0);
        jPanel1.add(gNumberBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 460, 80, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Sub group number");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 530, -1, -1));

        SubGNumberBox.setMinimum(0);
        jPanel1.add(SubGNumberBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 530, 80, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Group ID ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 310, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Sub group ID");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 390, -1, -1));

        generateBtn.setBackground(new java.awt.Color(15, 19, 52));
        generateBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        generateBtn.setForeground(new java.awt.Color(255, 255, 255));
        generateBtn.setText("GENERATE ID's");
        generateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateBtnActionPerformed(evt);
            }
        });
        jPanel1.add(generateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 480, -1, -1));

        clearBtn.setBackground(new java.awt.Color(15, 19, 52));
        clearBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        clearBtn.setForeground(new java.awt.Color(255, 255, 255));
        clearBtn.setText("CLEAR");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });
        jPanel1.add(clearBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 620, -1, -1));

        deleteBtn.setBackground(new java.awt.Color(15, 19, 52));
        deleteBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteBtn.setText("DELETE");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });
        jPanel1.add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 620, -1, -1));

        updateBtn.setBackground(new java.awt.Color(15, 19, 52));
        updateBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        updateBtn.setForeground(new java.awt.Color(255, 255, 255));
        updateBtn.setText("UPDATE");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });
        jPanel1.add(updateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 620, -1, -1));

        gIdBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        gIdBox.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(gIdBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 300, 100, 20));

        SubGIdBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SubGIdBox.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(SubGIdBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 380, 100, 20));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Manage Student Group");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, 430, 50));

        jButton1.setForeground(new java.awt.Color(15, 19, 52));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/home_24px.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 40, 40));

        jButton2.setForeground(new java.awt.Color(15, 19, 52));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/back_to_30px.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 40, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1370, 750));

        jPanel2.setBackground(new java.awt.Color(15, 19, 52));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete_32px.png"))); // NOI18N
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1326, 0, 40, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -2, 1370, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void YearSemBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YearSemBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_YearSemBoxActionPerformed

    private void generateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateBtnActionPerformed

        String yearAndSem = YearSemBox.getSelectedItem().toString();
        String programme = ProgrammeBox.getSelectedItem().toString();
        int groupID = gNumberBox.getValue();
        int subGroupID = SubGNumberBox.getValue();

        gIdBox.setText(yearAndSem+"."+programme+"."+groupID);
        SubGIdBox.setText(yearAndSem+"."+programme+"."+groupID+"."+subGroupID);
    }//GEN-LAST:event_generateBtnActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_clearBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:

        int check = JOptionPane.showConfirmDialog(null, "Do you want to delete?");
        int r = studentGroupTable.getSelectedRow();
        int value = (int) (studentGroupTable.getModel().getValueAt(r, 0));
        
        if(check == 0){
        
            try {
                String sql = "DELETE FROM studentgroup WHERE id='"+value+"'";
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Group deleted successfully");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            
            tableload();
        
        }
  
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        update();
        tableload();
    }//GEN-LAST:event_updateBtnActionPerformed

    private void studentGroupTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentGroupTableMouseClicked
        // TODO add your handling code here:
        tabledata();
    }//GEN-LAST:event_studentGroupTableMouseClicked

    private void studentGroupTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_studentGroupTableKeyReleased
        // TODO add your handling code here:
        tabledata();
    }//GEN-LAST:event_studentGroupTableKeyReleased

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Home h = new Home();
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        studentManagement h = new studentManagement();
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(manageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(manageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(manageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(manageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new manageStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ProgrammeBox;
    private javax.swing.JLabel SubGIdBox;
    private com.toedter.components.JSpinField SubGNumberBox;
    private javax.swing.JComboBox<String> YearSemBox;
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel gIdBox;
    private com.toedter.components.JSpinField gNumberBox;
    private javax.swing.JButton generateBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable studentGroupTable;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables

}
