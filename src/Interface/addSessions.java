/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;


import Code.DBConnect_2;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dilshan
 */
public class addSessions extends javax.swing.JFrame {

    /**
     * Creates new form addSessions
     */
    public addSessions() {
        initComponents();
        con = DBConnect_2.connect();
        selectLecturers();
        selectSubjects();
        selectGroups();
        selectTags(); 
    }
    
    Connection con;
    PreparedStatement pst;
    DefaultTableModel df;
    ResultSet rs;
    
    private void selectLecturers(){
        try{
            
            String sql = "select * from lecturers";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                String Lname = rs.getString("name");
                Lec1.addItem(Lname);
                Lec2.addItem(Lname);
                Lec3.addItem(Lname);
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    private void selectSubjects(){
        try{
            
            String sql = "select * from subjects";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                
                String SubName = rs.getString("subject_name");
                selectSubName.addItem(SubName);
                String SubCode = rs.getString("subject_code");
                selectSubCode.addItem(SubCode);
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    private void selectTags(){
        try{
            
            String sql = "select * from tag";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                
                String tag = rs.getString("relatedTag");
                selectTag.addItem(tag); 
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    private void selectGroups(){
        try{
            
            String sql = "select * from studentgroup";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                
                String group = rs.getString("SubGroupID");
                GroupID.addItem(group); 
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        home = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Lec1 = new javax.swing.JComboBox<>();
        Slecturers = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Lec2 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        Lec3 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtLec1Val = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        students = new javax.swing.JTextField();
        selectTag = new javax.swing.JComboBox<>();
        selectSubCode = new javax.swing.JComboBox<>();
        selectSubName = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        GroupID = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        duration = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtSubNameVal = new javax.swing.JLabel();
        txtSubCodeVal = new javax.swing.JLabel();
        txtTagVal = new javax.swing.JLabel();
        txtGroupIDVal = new javax.swing.JLabel();
        studentsVal = new javax.swing.JLabel();
        durationVal = new javax.swing.JLabel();
        submit = new javax.swing.JButton();
        back2 = new javax.swing.JButton();
        ManageSessions = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBackground(new java.awt.Color(15, 19, 52));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete_32px.png"))); // NOI18N
        jLabel13.setText("jLabel13");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(15, 19, 52));
        jLabel1.setText("ADD SESSIONS");

        home.setBackground(new java.awt.Color(15, 19, 52));
        home.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        home.setForeground(new java.awt.Color(255, 255, 255));
        home.setText("Home");
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });

        back.setBackground(new java.awt.Color(15, 19, 52));
        back.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jLabel2.setText("Select Lecturer 1");

        Lec1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        Lec1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Lec1MouseEntered(evt);
            }
        });

        Slecturers.setEditable(false);
        Slecturers.setBackground(new java.awt.Color(230, 230, 230));
        Slecturers.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Slecturers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SlecturersActionPerformed(evt);
            }
        });
        Slecturers.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SlecturersKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jLabel3.setText("Select Lecturer 2");

        Lec2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        Lec2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Lec2MouseEntered(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jLabel4.setText("Select Lecturer 3");

        Lec3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        Lec3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Lec3MouseEntered(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jLabel5.setText("Selected Lecturers");

        txtLec1Val.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(49, 49, 49)
                        .addComponent(Slecturers))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(63, 63, 63)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Lec2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Lec1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addComponent(jLabel4)
                        .addGap(49, 49, 49)
                        .addComponent(Lec3, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(txtLec1Val, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(txtLec1Val, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addComponent(Lec1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(Lec3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(Lec2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(Slecturers, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jLabel6.setText("Select Subject Name");

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jLabel7.setText("Select Subject Code");

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jLabel8.setText("Select Tag");

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jLabel9.setText("Number of Students");

        students.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentsActionPerformed(evt);
            }
        });
        students.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                studentsKeyReleased(evt);
            }
        });

        selectTag.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        selectTag.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                selectTagMouseEntered(evt);
            }
        });

        selectSubCode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        selectSubCode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                selectSubCodeMouseEntered(evt);
            }
        });

        selectSubName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        selectSubName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                selectSubNameMouseEntered(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jLabel10.setText("Select Group");

        GroupID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        GroupID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                GroupIDMouseEntered(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jLabel11.setText("Duration");

        duration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                durationActionPerformed(evt);
            }
        });
        duration.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                durationKeyReleased(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jLabel12.setText("Hrs");

        txtSubNameVal.setForeground(new java.awt.Color(255, 51, 51));

        txtSubCodeVal.setForeground(new java.awt.Color(255, 51, 51));

        txtTagVal.setForeground(new java.awt.Color(255, 51, 51));

        txtGroupIDVal.setForeground(new java.awt.Color(255, 51, 51));

        studentsVal.setForeground(new java.awt.Color(255, 51, 51));

        durationVal.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addGap(43, 43, 43)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(selectTag, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTagVal, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(selectSubName, 0, 304, Short.MAX_VALUE)
                            .addComponent(selectSubCode, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSubNameVal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSubCodeVal, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))))
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(49, 49, 49)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(students, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(GroupID, javax.swing.GroupLayout.Alignment.LEADING, 0, 256, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(duration, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtGroupIDVal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(studentsVal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(durationVal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(35, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(selectSubName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(GroupID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)
                                    .addComponent(txtGroupIDVal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtSubNameVal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSubCodeVal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7)
                            .addComponent(selectSubCode)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(students, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(studentsVal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(selectTag, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(duration, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11))
                            .addComponent(txtTagVal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(41, 41, 41))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(durationVal, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        submit.setBackground(new java.awt.Color(15, 19, 52));
        submit.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        submit.setForeground(new java.awt.Color(255, 255, 255));
        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        back2.setBackground(new java.awt.Color(15, 19, 52));
        back2.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        back2.setForeground(new java.awt.Color(255, 255, 255));
        back2.setText("Clear");
        back2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back2ActionPerformed(evt);
            }
        });

        ManageSessions.setBackground(new java.awt.Color(15, 19, 52));
        ManageSessions.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        ManageSessions.setForeground(new java.awt.Color(255, 255, 255));
        ManageSessions.setText("Manage Sessions");
        ManageSessions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManageSessionsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(back2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ManageSessions, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(68, 68, 68))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(back2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ManageSessions, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
        // TODO add your handling code here:
        Home home = new Home();
        home.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_homeActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        session m1 = new session();
        m1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backActionPerformed

    private void Lec1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Lec1MouseEntered

        String Lecturer1 = Lec1.getSelectedItem().toString();
        String Lecturer2 = Lec2.getSelectedItem().toString();
        String Lecturer3 = Lec3.getSelectedItem().toString();
        
        
        String SelectedLecturers = Lecturer1+"  "+Lecturer2+"  "+Lecturer3;
        Slecturers.setText(SelectedLecturers);
        
        
    }//GEN-LAST:event_Lec1MouseEntered

    private void SlecturersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SlecturersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SlecturersActionPerformed

    private void SlecturersKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SlecturersKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_SlecturersKeyReleased

    private void Lec2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Lec2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Lec2MouseEntered

    private void Lec3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Lec3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Lec3MouseEntered

    private void studentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentsActionPerformed

    private void studentsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_studentsKeyReleased
        
        String nStudentsPATTERN = "[0-9]{2,3}$";
            Pattern nStudentspatt = Pattern.compile(nStudentsPATTERN);
            Matcher nStudentsmatch = nStudentspatt.matcher(students.getText());
            if(nStudentsmatch.matches()){
            studentsVal.setText("");   
            }
    }//GEN-LAST:event_studentsKeyReleased

    private void selectTagMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectTagMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_selectTagMouseEntered

    private void selectSubCodeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectSubCodeMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_selectSubCodeMouseEntered

    private void selectSubNameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectSubNameMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_selectSubNameMouseEntered

    private void GroupIDMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GroupIDMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_GroupIDMouseEntered

    private void durationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_durationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_durationActionPerformed

    private void durationKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_durationKeyReleased
 
        String durationPATTERN = "[0-5]{1}$";
            Pattern durationpatt = Pattern.compile(durationPATTERN);
            Matcher durationmatch = durationpatt.matcher(duration.getText());
            if(durationmatch.matches()){
            durationVal.setText("");   
            }
    }//GEN-LAST:event_durationKeyReleased

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        if(Lec1.getSelectedIndex() == 0 && Lec2.getSelectedIndex() == 0 && Lec3.getSelectedIndex() == 0){
            txtLec1Val.setText("* Please Select !");
        }
        else
            txtLec1Val.setText("");
        
        if(selectSubName.getSelectedIndex() == 0){
            txtSubNameVal.setText("* Please Select !");
        }
        else
            txtSubNameVal.setText("");
        
        if(selectSubCode.getSelectedIndex() == 0){
            txtSubCodeVal.setText("* Please Select !");
        }
        else
            txtSubCodeVal.setText("");
        
        if(selectTag.getSelectedIndex() == 0){
            txtTagVal.setText("* Please Select !");
        }
        else
            txtTagVal.setText("");
        
        if(GroupID.getSelectedIndex() == 0){
            txtGroupIDVal.setText("* Please Select !");
        }
        else
            txtGroupIDVal.setText("");
        
        String nStudentsPATTERN = "[0-9]{2,3}$";
            Pattern nStudentspatt = Pattern.compile(nStudentsPATTERN);
            Matcher nStudentsmatch = nStudentspatt.matcher(students.getText());
            if(!nStudentsmatch.matches()){
            studentsVal.setText("* Invalid Number !");   
            }
            
            else
                studentsVal.setText("");  
        
        String durationPATTERN = "[0-5]{1}$";
            Pattern durationpatt = Pattern.compile(durationPATTERN);
            Matcher durationmatch = durationpatt.matcher(duration.getText());
            if(!durationmatch.matches()){
            durationVal.setText("* Invalid Duration !");   
            }
            
            else
                durationVal.setText("");
        
        if(Lec1.getSelectedIndex() == 0 && Lec2.getSelectedIndex() == 0 && Lec3.getSelectedIndex() == 0 || selectSubName.getSelectedIndex() == 0 || selectSubCode.getSelectedIndex() == 0 || 
           selectTag.getSelectedIndex() == 0 || GroupID.getSelectedIndex() == 0 || !nStudentsmatch.matches() || !durationmatch.matches()){
            Component frame = null;
            
            JOptionPane.showMessageDialog(frame, "Please fill in a valid value for all required fields");
        
        } 
        
        else{
        
        try {
            String Lecturer1 = Lec1.getSelectedItem().toString();
            String Lecturer2 = Lec2.getSelectedItem().toString();
            String Lecturer3 = Lec3.getSelectedItem().toString();
            String SubName = selectSubName.getSelectedItem().toString();
            String SubCode = selectSubCode.getSelectedItem().toString();
            String Tag = selectTag.getSelectedItem().toString();
            String StudentGroup = GroupID.getSelectedItem().toString();            
            String NoOfStudents = students.getText();        
            String Duration = duration.getText();
            String Session = Lecturer1+"   "+Lecturer2+"   "+Lecturer3+ " - " +SubCode+ " - " +SubName+ " - " +Tag+ " - " +StudentGroup+ " - " +NoOfStudents+ " - " +Duration;
            
            
            pst = con.prepareStatement("insert into sessions (Lecturer_1,Lecturer_2,Lecturer_3,Subject_Name,Subject_Code,Tag,Group_ID,Students,Duration,mSessions) values(?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1,Lecturer1);
            pst.setString(2,Lecturer2);
            pst.setString(3,Lecturer3);
            pst.setString(4,SubName);
            pst.setString(5,SubCode);
            pst.setString(6,Tag);
            pst.setString(7,StudentGroup);
            pst.setString(8,NoOfStudents);
            pst.setString(9,Duration);
            pst.setString(10,Session);
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(this, "New Session Added Successfully");
            
            Lec1.setSelectedIndex(0);
            Lec2.setSelectedIndex(0);
            Lec3.setSelectedIndex(0);
            selectSubName.setSelectedIndex(0);
            selectSubCode.setSelectedIndex(0);
            selectTag.setSelectedIndex(0);
            GroupID.setSelectedIndex(0);
            students.setText("");
            duration.setText("");
            Slecturers.setText("");
            
        } catch (SQLException ex) {
            Logger.getLogger(addSessions.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }
    }//GEN-LAST:event_submitActionPerformed

    private void back2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back2ActionPerformed
        
            Lec1.setSelectedIndex(0);
            Lec2.setSelectedIndex(0);
            Lec3.setSelectedIndex(0);
            selectSubName.setSelectedIndex(0);
            selectSubCode.setSelectedIndex(0);
            selectTag.setSelectedIndex(0);
            GroupID.setSelectedIndex(0);
            students.setText("");
            duration.setText("");
            Slecturers.setText("");
    }//GEN-LAST:event_back2ActionPerformed

    private void ManageSessionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageSessionsActionPerformed
        ManageSessions Msessions = new ManageSessions();
        Msessions.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_ManageSessionsActionPerformed

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        // TODO add your handling code here:
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }//GEN-LAST:event_jLabel13MouseClicked

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
            java.util.logging.Logger.getLogger(addSessions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addSessions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addSessions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addSessions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addSessions().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> GroupID;
    private javax.swing.JComboBox<String> Lec1;
    private javax.swing.JComboBox<String> Lec2;
    private javax.swing.JComboBox<String> Lec3;
    private javax.swing.JButton ManageSessions;
    private javax.swing.JTextField Slecturers;
    private javax.swing.JButton back;
    private javax.swing.JButton back2;
    private javax.swing.JTextField duration;
    private javax.swing.JLabel durationVal;
    private javax.swing.JButton home;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JComboBox<String> selectSubCode;
    private javax.swing.JComboBox<String> selectSubName;
    private javax.swing.JComboBox<String> selectTag;
    private javax.swing.JTextField students;
    private javax.swing.JLabel studentsVal;
    private javax.swing.JButton submit;
    private javax.swing.JLabel txtGroupIDVal;
    private javax.swing.JLabel txtLec1Val;
    private javax.swing.JLabel txtSubCodeVal;
    private javax.swing.JLabel txtSubNameVal;
    private javax.swing.JLabel txtTagVal;
    // End of variables declaration//GEN-END:variables
}
