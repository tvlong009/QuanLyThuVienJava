package qltvs.FormQltv;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import qltvs.LopQltv.Them_Sua_Xoa_Find_TV;
import qltvs.LopQltv.MuonTra_ThuVien;
import qltvs.LopQltv.Sach_ThuVien;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.lang3.ObjectUtils;
//import sun.nio.ch.IOUtil;
import qltvs.LopQltv.Them_Sua_Xoa_Find_TV;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author JOS LINH NGUYEN
 */
public class Quan_Ly_Muon_Tra extends javax.swing.JFrame {

    DefaultTableModel tbMuontra;
    List<MuonTra_ThuVien> slmt = new ArrayList<>();
    Sach_ThuVien Sltv = new Sach_ThuVien();
    public static String CurrentUserRole;
    public Quan_Ly_Muon_Tra(String currentUserRole) {
        initComponents();
        CurrentUserRole = currentUserRole;
        tbMuontra = (DefaultTableModel) tabMuontra.getModel();
        ShowMuonTraSach();
        ShowDuLieuSachMuon();
    }

    private void ShowMuonTraSach() {
        slmt = Them_Sua_Xoa_Find_TV.HienThiAllMuonTra();
        tbMuontra.setRowCount(0);
        for (MuonTra_ThuVien muonTra_ThuVien : slmt) {
            tbMuontra.addRow(new Object[]{muonTra_ThuVien.getMSV(), muonTra_ThuVien.getMASACH(), muonTra_ThuVien.getNGAYMUON(), muonTra_ThuVien.getNGAYTRA(), muonTra_ThuVien.getSOLUONG(), muonTra_ThuVien.getQLTHUVIEN()});
        }
    }

    public void ShowDuLieuSachMuon() {
        try {
            tabMuontra.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (tabMuontra.getSelectedRow() >= 0) {
                        txtMsv.setText(tabMuontra.getValueAt(tabMuontra.getSelectedRow(), 0) + "");
                        txtms.setText(tabMuontra.getValueAt(tabMuontra.getSelectedRow(), 1) + "");
                        txtNm.setText(tabMuontra.getValueAt(tabMuontra.getSelectedRow(), 2) + "");
                        txtNt.setText(tabMuontra.getValueAt(tabMuontra.getSelectedRow(), 3) + "");
                        txtSl.setText(tabMuontra.getValueAt(tabMuontra.getSelectedRow(), 4) + "");
                        txtQltv.setText(tabMuontra.getValueAt(tabMuontra.getSelectedRow(), 5) + "");

                    }
                }
            });
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMsv = new javax.swing.JTextField();
        txtSl = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtQltv = new javax.swing.JTextField();
        txtNm = new javax.swing.JTextField();
        txtNt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtms = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnMuonmoi = new javax.swing.JButton();
        btnChomuon = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        btnTrasach = new javax.swing.JButton();
        txtTkiem = new javax.swing.JTextField();
        btnTk = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabMuontra = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnthoat1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnPint = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        jButton4.setText("jButton4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ MƯỢN , TRẢ SÁCH");

        jPanel1.setBackground(new java.awt.Color(153, 255, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setAutoscrolls(true);
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setName(""); // NOI18N

        jLabel3.setBackground(new java.awt.Color(0, 153, 153));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Mã NMS");

        jLabel4.setBackground(new java.awt.Color(0, 153, 153));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Ngày Mượn");

        jLabel5.setBackground(new java.awt.Color(0, 153, 153));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Ngày Trả");

        jLabel6.setBackground(new java.awt.Color(0, 153, 153));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Số Lượng Mượn");

        txtMsv.setBackground(new java.awt.Color(204, 204, 204));

        txtSl.setBackground(new java.awt.Color(204, 204, 204));
        txtSl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSlActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(0, 153, 153));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Quản Lý TV");

        txtQltv.setBackground(new java.awt.Color(204, 204, 204));

        txtNm.setBackground(new java.awt.Color(204, 204, 204));

        txtNt.setBackground(new java.awt.Color(204, 204, 204));

        jLabel9.setBackground(new java.awt.Color(0, 153, 153));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Mã Sách");

        txtms.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNt, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNm, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtms, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtMsv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtQltv, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSl, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 46, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMsv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtQltv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        jPanel2.setBackground(new java.awt.Color(51, 102, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnMuonmoi.setBackground(new java.awt.Color(0, 102, 102));
        btnMuonmoi.setText("Mượn Mới");
        btnMuonmoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMuonmoiActionPerformed(evt);
            }
        });

        btnChomuon.setBackground(new java.awt.Color(0, 102, 102));
        btnChomuon.setForeground(new java.awt.Color(0, 51, 51));
        btnChomuon.setText("Cho Mượn");
        btnChomuon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChomuonActionPerformed(evt);
            }
        });

        btnThoat.setBackground(new java.awt.Color(0, 102, 102));
        btnThoat.setForeground(new java.awt.Color(0, 51, 51));
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        btnTrasach.setBackground(new java.awt.Color(0, 102, 102));
        btnTrasach.setForeground(new java.awt.Color(0, 51, 51));
        btnTrasach.setText("Trả Sách");
        btnTrasach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrasachActionPerformed(evt);
            }
        });

        txtTkiem.setBackground(new java.awt.Color(204, 204, 204));

        btnTk.setBackground(new java.awt.Color(0, 102, 102));
        btnTk.setForeground(new java.awt.Color(0, 51, 51));
        btnTk.setText("Tìm MSV");
        btnTk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMuonmoi)
                    .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnChomuon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTrasach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTk))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMuonmoi)
                    .addComponent(btnChomuon))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThoat)
                    .addComponent(btnTrasach)))
        );

        tabMuontra.setBackground(new java.awt.Color(204, 204, 204));
        tabMuontra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabMuontra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã NMS", "Mã Sách", "Ngày Mượn", "Ngày Trả", "SL Mượn", "QL Thư Viện"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabMuontra);

        jLabel2.setBackground(new java.awt.Color(204, 102, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Thực Hiện Mượn ,Trả Sách");

        jLabel7.setBackground(new java.awt.Color(0, 102, 102));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Xử Lý ");

        btnthoat1.setText("Trở Lại");
        btnthoat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthoat1ActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(0, 153, 153));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setPreferredSize(new java.awt.Dimension(600, 457));

        btnPint.setBackground(new java.awt.Color(0, 102, 102));
        btnPint.setForeground(new java.awt.Color(0, 51, 51));
        btnPint.setText("Print");
        btnPint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPint, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnthoat1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnthoat1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPint, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(112, 112, 112))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSlActionPerformed

    private void btnChomuonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChomuonActionPerformed
        int th = JOptionPane.showConfirmDialog(this, "Bạn có muốn mượn", "Confirm", JOptionPane.YES_NO_OPTION);
        if (th != JOptionPane.YES_OPTION) {
            return;
        }
        Sltv = null;
        Sltv = Them_Sua_Xoa_Find_TV.findSach(txtms.getText());
        //tblsachTV.setRowCount(0);//xóa dữ liệu trong table
//        for (Sach_ThuVien sachTv : Sltv) {
//          Sltv.add(sachTv);
//        }
        //Sach_ThuVien sach = new Sach_ThuVien();
        if(ObjectUtils.isEmpty(Sltv)){
           // sach = Sltv.get(0);
            if(Sltv.getSOLUONG() > 0 && (Sltv.getSOLUONG() - Integer.parseInt(txtSl.getText()) >= 0)) {
                String msv = txtMsv.getText();
            String ms = txtms.getText();
            String ngaymuon = txtNm.getText();
            String ngaytra = txtNt.getText();
            int soluong = Integer.parseInt(txtSl.getText());
            String qltv = txtQltv.getText();
            MuonTra_ThuVien std = new MuonTra_ThuVien(msv, ms, ngaymuon, ngaytra, soluong, qltv);
            
            Them_Sua_Xoa_Find_TV.InsertMuonTra(std);
            JOptionPane.showMessageDialog(this, "Mượn thành công");
            
            Sltv.setSOLUONG(Sltv.getSOLUONG() - soluong);
            Them_Sua_Xoa_Find_TV.Update(Sltv);
            
            } else {
                JOptionPane.showMessageDialog(this, "Sách này không đủ để mượn. Hoặc Mã ");
            }
  
            ShowMuonTraSach();
        } else {
            JOptionPane.showMessageDialog(this, "Mã Sách Sai");
        }
        //Them_Sua_Xoa_Find_TV.findSach(txtms.getText());
        
    
     
    }//GEN-LAST:event_btnChomuonActionPerformed

    private void btnMuonmoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuonmoiActionPerformed
        // TODO add your handling code here:
        txtMsv.setText("");
        txtms.setText("");
        txtNm.setText("");
        txtNt.setText("");
        txtSl.setText("");
        txtQltv.setText("");
    }//GEN-LAST:event_btnMuonmoiActionPerformed

    private void btnTrasachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrasachActionPerformed
        // TODO add your handling code here:
        int chon = tabMuontra.getSelectedRow();
        if (chon >= 0) {
            MuonTra_ThuVien stv = slmt.get(chon);
            int Xoa = JOptionPane.showConfirmDialog(this, "Bạn có muốn Trả Sách");
            System.out.println(":" + Xoa);
            if (Xoa == 0) {
                Them_Sua_Xoa_Find_TV.DeleteMuontra(stv.getMSV());
                Sltv = Them_Sua_Xoa_Find_TV.findSach(stv.getMASACH());
                
                Sltv.setSOLUONG(Sltv.getSOLUONG() + stv.getSOLUONG());
                Them_Sua_Xoa_Find_TV.Update(Sltv);
                
                JOptionPane.showMessageDialog(this, "Trả thành công");
                ShowMuonTraSach();
            }
        }
    }//GEN-LAST:event_btnTrasachActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(this, "Bạn có chắn muốn thoát không", "Thông báo",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnTkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTkActionPerformed
        // TODO add your handling code here:
        String Search = txtTkiem.getText();
        if (Search.length() > 0) {
            slmt = Them_Sua_Xoa_Find_TV.findQLMT(Search);
            tbMuontra.setRowCount(0);
            for (MuonTra_ThuVien mt : slmt) {
                tbMuontra.addRow(new Object[]{mt.getMSV(), mt.getMASACH(), mt.getNGAYMUON(), mt.getNGAYTRA(), mt.getSOLUONG(), mt.getQLTHUVIEN()});

            }
        }
    }//GEN-LAST:event_btnTkActionPerformed

    private void btnthoat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthoat1ActionPerformed
        // TODO add your handling code here:
        int Exit = JOptionPane.showConfirmDialog(this, "Bạn có muốn rời khỏi trang ?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (Exit != JOptionPane.YES_OPTION) {
            return;
        }
        QUAN_LY_THU_VIEN_SACH tvs = new QUAN_LY_THU_VIEN_SACH(CurrentUserRole);
        tvs.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnthoat1ActionPerformed

    private void btnPintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPintActionPerformed
       ArrayList<String> barcodeMSG = new ArrayList<String>();
      List<MuonTra_ThuVien> arrayMSVTemp = new ArrayList<>();
        if (txtMsv.getText().equals("")) {
           // File filetosave = fc.getSelectedFile();
         
             //   FileWriter fw = new FileWriter(filetosave);//Lớp FileWriter được sử dụng để ghi các dữ liệu theo định dạng ký tự vào một file
              //  BufferedWriter bw = new BufferedWriter(fw);//Lớp BufferedWriter được sử dụng để cung cấp bộ đệm cho các các thể hiện của lớp Writer
            arrayMSVTemp = Them_Sua_Xoa_Find_TV.HienThiAllMuonTra();
            //tblsachTV.setRowCount(0);//xóa dữ liệu trong table
            for (MuonTra_ThuVien muonTra_ThuVien : arrayMSVTemp) {
               // tblsachTV.addRow(new Object[]{sachTv.getMASACH(), sachTv.getTENSACH(), sachTv.getNAMXB(), sachTv.getNHAXB(), sachTv.getGIA(), sachTv.getTINHTRANG()});
               barcodeMSG.add(muonTra_ThuVien.getMSV());
            }
              
        } else {
            barcodeMSG.add(txtMsv.getText());
        }
       
        int maxCol = 2;
        Document document = null;
       
        document = new Document(new Rectangle(360, 852));
       
      
         // Step-2: Create PdfWriter object for the document
        PdfWriter writer = null;
          try {
              writer = PdfWriter.getInstance(document, new FileOutputStream("MaNMS_Output.pdf"));
          } catch (DocumentException ex) {
              Logger.getLogger(Quan_Ly_Sach.class.getName()).log(Level.SEVERE, null, ex);
          } catch (FileNotFoundException ex) {
              Logger.getLogger(Quan_Ly_Sach.class.getName()).log(Level.SEVERE, null, ex);
          }
         // Step -3: Open document for editing
        document.open();
        
        PdfContentByte cb = writer.getDirectContent();
        PdfPTable table;
     
        if(barcodeMSG.size() >= maxCol){
             table = new PdfPTable(maxCol);
        } else {
             table = new PdfPTable(barcodeMSG.size());
        }
        table.setWidthPercentage(80);
      
        

      for (String barcode : barcodeMSG){
        Chunk linebreak = Chunk.NEWLINE;
      //Step-5: Create QR Code by using BarcodeQRCode Class
        BarcodeQRCode my_code = new BarcodeQRCode(barcode, 1, 1, null);
        //Step-6: Get Image corresponding to the input string
        Image qr_image = null;
            try {
                qr_image = my_code.getImage();
            } catch (BadElementException ex) {
                Logger.getLogger(Quan_Ly_Sach.class.getName()).log(Level.SEVERE, null, ex);
            }
        //Step-7: Stamp the QR image into the PDF document
        //document.add(qr_image);
        PdfPCell cell;
        //Border b1 = new DashedBorder(Color.BLACK, 1);
       
        cell = new PdfPCell(qr_image);
        cell.addElement(linebreak);
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell.addElement(qr_image);
         //Step-4: Create New paragraph for QR Summary
         
        String[] arryS = barcode.split(" ");
        //cell = new PdfPCell();
        for (String arr : arryS){
           
            Paragraph temp = new Paragraph(arr);
           // temp.setAlignment(Element.ALIGN_CENTER);
            temp.setAlignment(Element.ALIGN_CENTER);
            cell.addElement(temp);   
        }
        Paragraph temp = new Paragraph("");
       // Chunk linebreak = new Chunk(new DottedLineSeparator());
        cell.addElement(linebreak); 
        table.addCell(cell);
      }
      table.completeRow();
         try {
                document.add(table);
            } catch (DocumentException ex) {
                Logger.getLogger(Quan_Ly_Sach.class.getName()).log(Level.SEVERE, null, ex);
            }
      //////////////
        File pdfFile = new File("MaNMS_Output.pdf");
                            if (pdfFile.exists()) {

                                if (Desktop.isDesktopSupported()) {
                                    try {
                                        Desktop.getDesktop().open(pdfFile);
                                    } catch (IOException ex) {
                                        Logger.getLogger(Quan_Ly_Sach.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            }
      
      //////
        //Step-8: Close the PDF document
       document.close();
    }//GEN-LAST:event_btnPintActionPerformed

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
            java.util.logging.Logger.getLogger(Quan_Ly_Muon_Tra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Quan_Ly_Muon_Tra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Quan_Ly_Muon_Tra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Quan_Ly_Muon_Tra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Quan_Ly_Muon_Tra(CurrentUserRole).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChomuon;
    private javax.swing.JButton btnMuonmoi;
    private javax.swing.JButton btnPint;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnTk;
    private javax.swing.JButton btnTrasach;
    private javax.swing.JButton btnthoat1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabMuontra;
    private javax.swing.JTextField txtMsv;
    private javax.swing.JTextField txtNm;
    private javax.swing.JTextField txtNt;
    private javax.swing.JTextField txtQltv;
    private javax.swing.JTextField txtSl;
    private javax.swing.JTextField txtTkiem;
    private javax.swing.JTextField txtms;
    // End of variables declaration//GEN-END:variables
}
