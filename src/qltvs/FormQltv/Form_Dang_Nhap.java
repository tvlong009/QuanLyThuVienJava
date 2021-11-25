package qltvs.FormQltv;

import java.awt.FlowLayout;
import java.security.MessageDigest;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.PreparedStatement;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.objects.NativeString.substring;
//import net.proteanit.sql.DbUtils;
import qltvs.LopQltv.Them_Sua_Xoa_Find_TV;
import qltvs.LopQltv.Users;

public class Form_Dang_Nhap extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
   public String currentUserRole;

    public String getCurrentUserRole() {
        return currentUserRole;
    }

    public void setCurrentUserRole(String currentUserRole) {
        this.currentUserRole = currentUserRole;
    }
   
   
   
    public Form_Dang_Nhap() {
        initComponents();
    }
    String  driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url = "jdbc:sqlserver://localhost:1433;databaseName=DANGNHAP"; 
    String user = "admin";
    String password = "admin";
    Statement st;
    ResultSet rs;
    
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtusername = new javax.swing.JTextField();
        btndangnhap = new javax.swing.JButton();
        jfpwd = new javax.swing.JPasswordField();
        btnThemTk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel1.setBackground(new java.awt.Color(51, 51, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon("E:\\New Folder (2)\\BaiTapCuoiKi\\QLTV\\src\\Icon\\icons8-male-user-48.png")); // NOI18N
        jLabel1.setText("Đăng Nhập");

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon("E:\\New Folder (2)\\BaiTapCuoiKi\\QLTV\\src\\Icon\\icons8-add-user-male-48.png")); // NOI18N
        jLabel2.setText("UserName:");

        jLabel3.setBackground(new java.awt.Color(102, 102, 102));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon("E:\\New Folder (2)\\BaiTapCuoiKi\\QLTV\\src\\Icon\\icons8-keepass-50.png")); // NOI18N
        jLabel3.setText("Password:");

        txtusername.setBackground(new java.awt.Color(204, 204, 204));

        btndangnhap.setBackground(new java.awt.Color(0, 153, 153));
        btndangnhap.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btndangnhap.setForeground(new java.awt.Color(0, 51, 51));
        btndangnhap.setIcon(new javax.swing.ImageIcon("E:\\New Folder (2)\\BaiTapCuoiKi\\QLTV\\src\\Icon\\icons8-login-24.png")); // NOI18N
        btndangnhap.setText("Đăng Nhập");
        btndangnhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndangnhapActionPerformed(evt);
            }
        });

        jfpwd.setBackground(new java.awt.Color(204, 204, 204));

        btnThemTk.setBackground(new java.awt.Color(0, 153, 153));
        btnThemTk.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnThemTk.setForeground(new java.awt.Color(0, 51, 51));
        btnThemTk.setIcon(new javax.swing.ImageIcon("E:\\New Folder (2)\\BaiTapCuoiKi\\QLTV\\src\\Icon\\icons8-add-user-group-man-man-24.png")); // NOI18N
        btnThemTk.setText("Thêm Account");
        btnThemTk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemTkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnThemTk)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btndangnhap))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jfpwd, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jfpwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemTk)
                    .addComponent(btndangnhap))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public Users findUser(String username, String password, Connection con) {// lấy ra ds các sinh viên 
        Users User = null;//quản lý dữ liệu đầu ra
        //Connection con = null;
        Statement st = null;//lấy dữ liệu từ database đổ ra
        PreparedStatement ps;
        try {
            //con= DriverManager.getConnection(url, user, password);

            String sql = "select * from ACCOUNT WHERE USERNAME=? and PASS=?";
            ps = con.prepareCall(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            //ResultSet rs = st.executeQuery(sql);//rs(con trỏ)//lấy dữ liệu trả về
            while (rs.next()) {//cho phép chuyển từng bản ghi trên dữ liệu đầu ra
                User = new Users(rs.getString("USERNAME"), rs.getString("PASS"), rs.getString("ROLE"));
                //SSlist.add(std);
            }
        } catch (Exception ex) {
            Logger.getLogger(Them_Sua_Xoa_Find_TV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return User;//trả về ds các sv lấy ra từ database
    }
    private void btndangnhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndangnhapActionPerformed
        // TODO add your handling code here:
        
        try
        {
            Connection con= DriverManager.getConnection(url, user, password);
            String sql = "select * from ACCOUNT where USERNAME=? and PASS=? ";
            PreparedStatement ps=con.prepareStatement(sql);
           
            ps.setString(1,txtusername.getText());
            ps.setString(2,jfpwd.getText());
            rs=ps.executeQuery();
           if(txtusername.getText().equals("")||jfpwd.getText().equals("")){
                JOptionPane.showMessageDialog(this,"Bạn chưa nhập Username và Password");
            }
           else if(rs.next()){//nếu có dữ liệu
             Users User = findUser(txtusername.getText(), jfpwd.getText(),con);
             currentUserRole = User.getRole();
             
             QUAN_LY_THU_VIEN_SACH ql = new QUAN_LY_THU_VIEN_SACH(currentUserRole);
             ql.setVisible(true);
             this.dispose();
             JOptionPane.showMessageDialog(this, "Đăng nhập thành công"); 
            }
            else{
              JOptionPane.showMessageDialog(this, "Đăng nhập thất bại");     
                    
            }
        }
        catch (Exception e)
        {
           JOptionPane.showMessageDialog(this, e.getMessage());
        }
          
        
    }//GEN-LAST:event_btndangnhapActionPerformed

    private void btnThemTkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemTkActionPerformed
        // TODO add your handling code here:
        int m=JOptionPane.showConfirmDialog(this,"Bạn có muốn thêm tài khoản","Confirm",JOptionPane.YES_NO_OPTION);
         if(m!=JOptionPane.YES_OPTION){
           return;
       }
        Them_Tai_Khoan ttk=new Them_Tai_Khoan();
        ttk.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnThemTkActionPerformed

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
            java.util.logging.Logger.getLogger(Form_Dang_Nhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Dang_Nhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Dang_Nhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Dang_Nhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Dang_Nhap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThemTk;
    private javax.swing.JButton btndangnhap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jfpwd;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
