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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dilshan
 */
public class ManageSessions extends javax.swing.JFrame {

    /**
     * Creates new form ManageSessions
     */
    public ManageSessions() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        con = DBConnect_2.connect();
        load();
        selectLecturers();
        selectSubjects();
        selectGroups();
        selectTags();
        searchTags();
    }
    
    Connection con;
    PreparedStatement pst;
    DefaultTableModel df;
    ResultSet rs;

    private void selectLecturers(){
        
        try{
            
            String sql = "select * from lecturers ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                String name = rs.getString("name");
                Lec1.addItem(name);
                Lec2.addItem(name);
                Lec3.addItem(name);
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
                
                String Sname = rs.getString("subject_name");
                selectSubName.addItem(Sname);
                String Scode = rs.getString("subject_code");
                selectSubCode.addItem(Scode);
            
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
                
                String Tag = rs.getString("relatedTag");
                selectTag.addItem(Tag); 
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
    
    private void searchTags(){
        
        try{
            
            String sql = "select * from tag";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                
                String Tag = rs.getString("relatedTag");
                searchTag.addItem(Tag); 
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }
    
    public void load()
    {
       int a;
        try {
            pst = con.prepareStatement("select * from sessions");
            ResultSet rs = pst.executeQuery();
            
            ResultSetMetaData rd = rs.getMetaData();
            a = rd.getColumnCount();
            df = (DefaultTableModel)SessionsTable.getModel();
            df.setRowCount(0);
            
           while(rs.next())
            {
                Vector v2 = new Vector();
                
                for(int i=1; i <= a; i++)
                {
                    v2.add(rs.getString("ID"));
                    v2.add(rs.getString("Lecturer_1"));
                    v2.add(rs.getString("Lecturer_2"));
                    v2.add(rs.getString("Lecturer_3"));
                    v2.add(rs.getString("Subject_Name"));
                    v2.add(rs.getString("Subject_Code"));
                    v2.add(rs.getString("Tag"));
                    v2.add(rs.getString("Group_ID"));
                    v2.add(rs.getString("Students"));
                    v2.add(rs.getString("Duration"));
                    v2.add(rs.getString("mSessions"));

                }

                df.addRow(v2);
            }
      
        } catch (SQLException ex) {
            Logger.getLogger(ManageSessions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        searchTag = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        home = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        SessionsTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        selectSubName = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        selectSubCode = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        GroupID = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        selectTag = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Lec3 = new javax.swing.JComboBox<>();
        Lec2 = new javax.swing.JComboBox<>();
        Lec1 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        students = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        duration = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        add = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        search = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        searchTag.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jPanel2.setBackground(new java.awt.Color(15, 19, 52));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete_32px.png"))); // NOI18N
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
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(15, 19, 52));
        jLabel1.setText("MANAGE SESSIONS");

        home.setBackground(new java.awt.Color(15, 19, 52));
        home.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        home.setForeground(new java.awt.Color(255, 255, 255));
        home.setText("Home");
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        SessionsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Lecturer 1", "Lecturer 2", "Lecturer 3", "Subject Name", "Subject Code", "Tag", "Group ID", "Number of Students", "Duration", "Sessions"
            }
        ));
        SessionsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SessionsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(SessionsTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jLabel6.setText("Select Subject Name");

        selectSubName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        selectSubName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                selectSubNameMouseEntered(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jLabel7.setText("Select Subject Code");

        selectSubCode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        selectSubCode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                selectSubCodeMouseEntered(evt);
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

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jLabel8.setText("Select Tag");

        selectTag.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        selectTag.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                selectTagMouseEntered(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jLabel2.setText("Select Lecturer 1");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jLabel3.setText("Select Lecturer 2");

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jLabel4.setText("Select Lecturer 3");

        Lec3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        Lec3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Lec3MouseEntered(evt);
            }
        });

        Lec2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        Lec2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Lec2MouseEntered(evt);
            }
        });

        Lec1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        Lec1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Lec1MouseEntered(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addGap(43, 43, 43)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(selectSubName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(selectSubCode, 0, 304, Short.MAX_VALUE)
                    .addComponent(selectTag, 0, 304, Short.MAX_VALUE)
                    .addComponent(GroupID, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(students, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 256, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel11))
                .addGap(49, 49, 49)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(duration, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(Lec2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Lec1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Lec3, javax.swing.GroupLayout.PREFERRED_SIZE, 739, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(59, 59, 59))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(selectSubName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2)
                    .addComponent(Lec1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(selectSubCode, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(Lec2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(selectTag, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4)
                    .addComponent(Lec3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(GroupID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(students, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addComponent(jLabel11)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(duration, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel12)))))
                .addGap(28, 28, 28))
        );

        update.setBackground(new java.awt.Color(15, 19, 52));
        update.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(15, 19, 52));
        delete.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        clear.setBackground(new java.awt.Color(15, 19, 52));
        clear.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        clear.setForeground(new java.awt.Color(255, 255, 255));
        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        add.setBackground(new java.awt.Color(15, 19, 52));
        add.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setText("Add Sessions");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        search.setBackground(new java.awt.Color(15, 19, 52));
        search.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        search.setForeground(new java.awt.Color(255, 255, 255));
        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchTag, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(82, 82, 82))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchTag, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
        // TODO add your handling code here:
        Home home = new Home();
        home.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_homeActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
         if(Lec1.getSelectedIndex() == 0 && Lec2.getSelectedIndex() == 0 && Lec3.getSelectedIndex() == 0){
            
        }
        
        if(selectSubName.getSelectedIndex() == 0){
            
        }
        
        if(selectSubCode.getSelectedIndex() == 0){
            
        }
        
        if(selectTag.getSelectedIndex() == 0){
            
        }
        
        
        if(GroupID.getSelectedIndex() == 0){
            
        }
        
        if(students.getText().trim().isEmpty()){
            
        }
        
        if(duration.getText().trim().isEmpty()){
            
        }
        
        if(Lec1.getSelectedIndex() == 0 && Lec2.getSelectedIndex() == 0 && Lec3.getSelectedIndex() == 0 || selectSubName.getSelectedIndex() == 0 || selectSubCode.getSelectedIndex() == 0 || 
           selectTag.getSelectedIndex() == 0 || GroupID.getSelectedIndex() == 0 || students.getText().trim().isEmpty() || duration.getText().trim().isEmpty() ){
            Component frame = null;
            
            JOptionPane.showMessageDialog(frame, "Please fill in a valid value for all required fields");
            
        } 
        
        else {
        
        
        df = (DefaultTableModel) SessionsTable.getModel();
        
            int selected = SessionsTable.getSelectedRow();
            int id = Integer.parseInt(df.getValueAt(selected, 0).toString());
        
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
            
            int x = JOptionPane.showConfirmDialog(null, "Are you want to update Session?", "Update", JOptionPane.YES_NO_OPTION);
            
        if(x == 0)
        {
            try {
               
                pst = con.prepareStatement("update sessions set Lecturer_1 =?, Lecturer_2 =?, Lecturer_3 =?, Subject_Name =?, Subject_Code =?, Tag =?, Group_ID =?, Students =?, Duration =?, mSessions =? where ID =?");
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
                pst.setInt(11,id);

                pst.executeUpdate();
            
                JOptionPane.showMessageDialog(this, "Session Updated Successfully");
                
                Lec1.setSelectedIndex(0);
                Lec2.setSelectedIndex(0);
                Lec3.setSelectedIndex(0);
                selectSubName.setSelectedIndex(0);
                selectSubCode.setSelectedIndex(0);
                selectTag.setSelectedIndex(0);
                GroupID.setSelectedIndex(0);
                students.setText("");
                duration.setText("");
                
                
                load();
            } catch (SQLException ex) {
                Logger.getLogger(ManageSessions.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
           
        }
           
    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        
        df = (DefaultTableModel)SessionsTable.getModel();

        int selected = SessionsTable.getSelectedRow();
        int id = Integer.parseInt(df.getValueAt(selected, 0).toString());

        int x = JOptionPane.showConfirmDialog(null, "Are you want to delete the Session?", "Delete", JOptionPane.YES_NO_OPTION);

        if(x == 0)
        {
            try {
                pst = con.prepareStatement("delete from sessions where ID = ?");
                pst.setInt(1,id);
                pst.executeUpdate();

                JOptionPane.showMessageDialog(this,"Session Deleted Successfully");

                Lec1.setSelectedIndex(0);
                Lec2.setSelectedIndex(0);
                Lec3.setSelectedIndex(0);
                selectSubName.setSelectedIndex(0);
                selectSubCode.setSelectedIndex(0);
                selectTag.setSelectedIndex(0);
                GroupID.setSelectedIndex(0);
                students.setText("");
                duration.setText("");

                load();

            } catch (SQLException ex) {
                Logger.getLogger(ManageSessions.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_deleteActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        
                Lec1.setSelectedIndex(0);
                Lec2.setSelectedIndex(0);
                Lec3.setSelectedIndex(0);
                selectSubName.setSelectedIndex(0);
                selectSubCode.setSelectedIndex(0);
                selectTag.setSelectedIndex(0);
                GroupID.setSelectedIndex(0);
                students.setText("");
                duration.setText("");
        
    }//GEN-LAST:event_clearActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        
        addSessions Asessions = new addSessions();
        Asessions.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_addActionPerformed

    private void selectSubNameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectSubNameMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_selectSubNameMouseEntered

    private void selectSubCodeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectSubCodeMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_selectSubCodeMouseEntered

    private void GroupIDMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GroupIDMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_GroupIDMouseEntered

    private void selectTagMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectTagMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_selectTagMouseEntered

    private void Lec3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Lec3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Lec3MouseEntered

    private void Lec2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Lec2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Lec2MouseEntered

    private void Lec1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Lec1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Lec1MouseEntered

    private void studentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentsActionPerformed

    private void studentsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_studentsKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_studentsKeyReleased

    private void durationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_durationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_durationActionPerformed

    private void durationKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_durationKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_durationKeyReleased

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        // TODO add your handling code here:
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }//GEN-LAST:event_jLabel13MouseClicked

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        df.setRowCount(0);
        searchTag.setSelectedIndex(0);
        Lec1.setSelectedIndex(0);
        Lec2.setSelectedIndex(0);
        Lec3.setSelectedIndex(0);
        selectSubName.setSelectedIndex(0);
        selectSubCode.setSelectedIndex(0);
        selectTag.setSelectedIndex(0);
        GroupID.setSelectedIndex(0);
        students.setText("");
        duration.setText("");
        load();
        
    }//GEN-LAST:event_txtSearchKeyReleased

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        String val1 = txtSearch.getText().toString();
        String val2 = searchTag.getSelectedItem().toString();
        
        int a;
        
        try {

            pst  = con.prepareStatement("select * from sessions where mSessions like '%"+val1+"%' AND Tag = '"+val2+"'");
            ResultSet rs = pst.executeQuery();
            
            ResultSetMetaData rd = rs.getMetaData();
            a= rd.getColumnCount();
            df = (DefaultTableModel)SessionsTable.getModel();
            df.setRowCount(0);
            
            while(rs.next()){       
                
                Vector v2 = new Vector();
                for(int i =1; i<=a; i++){
                    v2.add(rs.getString("ID"));
                    v2.add(rs.getString("Lecturer_1"));
                    v2.add(rs.getString("Lecturer_2"));
                    v2.add(rs.getString("Lecturer_3"));
                    v2.add(rs.getString("Subject_Name"));
                    v2.add(rs.getString("Subject_Code"));
                    v2.add(rs.getString("Tag"));
                    v2.add(rs.getString("Group_ID"));
                    v2.add(rs.getString("Students"));
                    v2.add(rs.getString("Duration"));
                    v2.add(rs.getString("mSessions"));
                }
                df.addRow(v2);
            }   
        } catch (SQLException ex) {
            Logger.getLogger(ManageSessions.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_searchActionPerformed

    private void SessionsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SessionsTableMouseClicked
        
        df = (DefaultTableModel)SessionsTable.getModel();

        int selected = SessionsTable.getSelectedRow();
        int id = Integer.parseInt(df.getValueAt(selected, 0).toString());
        
        String Lecturer1 = SessionsTable.getValueAt(selected, 1).toString();
            for(int i=0; i<Lec1.getItemCount();i++) {
		if(Lec1.getItemAt(i).toString().equalsIgnoreCase(Lecturer1)) {
			Lec1.setSelectedIndex(i);
                    }
		}
                                
	String Lecturer2 = SessionsTable.getValueAt(selected, 2).toString();
            for(int i=0; i<Lec2.getItemCount();i++) {
		if(Lec2.getItemAt(i).toString().equalsIgnoreCase(Lecturer2)) {
                    Lec2.setSelectedIndex(i);
                    }
		}
            
        String Lecturer3 = SessionsTable.getValueAt(selected, 3).toString();
            for(int i=0; i<Lec3.getItemCount();i++) {
		if(Lec3.getItemAt(i).toString().equalsIgnoreCase(Lecturer3)) {
                    Lec3.setSelectedIndex(i);
                    }
		}
            
            String SubjectName = SessionsTable.getValueAt(selected, 4).toString();
            for(int i=0; i<selectSubName.getItemCount();i++) {
		if(selectSubName.getItemAt(i).toString().equalsIgnoreCase(SubjectName)) {
                    selectSubName.setSelectedIndex(i);
                    }
		}
							
	String SubjectCode = SessionsTable.getValueAt(selected, 5).toString();
            for(int i=0; i<selectSubCode.getItemCount();i++) {
		if(selectSubCode.getItemAt(i).toString().equalsIgnoreCase(SubjectCode)) {
                    selectSubCode.setSelectedIndex(i);
                    }
		}
				
				
	String Tag =SessionsTable.getValueAt(selected, 6).toString();
            for(int i=0; i<selectTag.getItemCount();i++) {
                if(selectTag.getItemAt(i).toString().equalsIgnoreCase(Tag)) {
                    selectTag.setSelectedIndex(i);
                    }
		}
            
        String StudentGroup = SessionsTable.getValueAt(selected, 7).toString();
            for(int i=0; i<GroupID.getItemCount();i++) {
		if(GroupID.getItemAt(i).toString().equalsIgnoreCase(StudentGroup)) {
                    GroupID.setSelectedIndex(i);
                    }
		}
            
        students.setText(df.getValueAt(selected, 8).toString());
        duration.setText(df.getValueAt(selected, 9).toString());
        
    }//GEN-LAST:event_SessionsTableMouseClicked

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
            java.util.logging.Logger.getLogger(ManageSessions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageSessions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageSessions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageSessions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageSessions().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> GroupID;
    private javax.swing.JComboBox<String> Lec1;
    private javax.swing.JComboBox<String> Lec2;
    private javax.swing.JComboBox<String> Lec3;
    private javax.swing.JTable SessionsTable;
    private javax.swing.JButton add;
    private javax.swing.JButton clear;
    private javax.swing.JButton delete;
    private javax.swing.JTextField duration;
    private javax.swing.JButton home;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton search;
    private javax.swing.JComboBox<String> searchTag;
    private javax.swing.JComboBox<String> selectSubCode;
    private javax.swing.JComboBox<String> selectSubName;
    private javax.swing.JComboBox<String> selectTag;
    private javax.swing.JTextField students;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
