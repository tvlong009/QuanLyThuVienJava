package qltvs.FormQltv;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.qoppa.pdf.PDFException;
import com.qoppa.pdfProcess.PDFDocument;
import com.qoppa.pdfProcess.PDFPage;
import com.sun.java.swing.plaf.windows.WindowsBorders.DashedBorder;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import qltvs.LopQltv.Them_Sua_Xoa_Find_TV;
import qltvs.LopQltv.Sach_ThuVien;
import java.util.List;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import jdk.nashorn.internal.objects.NativeArray;
import org.krysalis.barcode4j.BarcodeDimension;
import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.output.java2d.Java2DCanvasProvider;
//import net.proteanit.sql.DbUtils;

public class Quan_Ly_Sach extends javax.swing.JFrame {

    DefaultTableModel tblsachTV;//tạo ra table không cột ,không dòng
    List<Sach_ThuVien> Sltv = new ArrayList<>();//lưu ds có trong sach_thuvien
    public static final String FONT = "font-times-new-roman.ttf";
    public static String CurrentUserRole;
    public Quan_Ly_Sach(String currentUserRole) {

        initComponents();
        CurrentUserRole = currentUserRole;
        if(CurrentUserRole.equals("user")){
        jPanel1.remove(jScrollPane1);
        jPanel1.remove(jTable1);
        jPanel1.remove(jLabel2);
        jPanel1.remove(jLabel3);
        jPanel1.remove(jLabel4);
        jPanel1.remove(jLabel2);
        jPanel1.remove(jLabel5);
        jPanel1.remove(ms);
        jPanel1.remove(ts);
        jPanel1.remove(nxb);
        jPanel1.remove(nnxb);
        jPanel1.remove(btnThem);
        jPanel1.remove(btnxoa);
        jPanel1.remove(btnsua);
        jPanel1.remove(btnThoat);
        jPanel1.remove(btnReset);
        jPanel1.remove(jLabel6);
        jPanel1.remove(jLabel7);
        jPanel1.remove(txtgia);
        jPanel1.remove(tacgia);
        jPanel1.remove(btnPrint1);
        //jScrollPane1.setVisible(false);
        //jTable1.setVisible(false);
        jLabel1.setVisible(true);
        jPanel1.setVisible(true);
        //jLabel2.setVisible(false);
        //jLabel3.setVisible(false);
        //jLabel4.setVisible(false);
        //jLabel5.setVisible(false);
        //ms.setVisible(false);
       // ts.setVisible(false);
        //nxb.setVisible(false);
       // nnxb.setVisible(false);
        //btnThem.setVisible(false);
       // btnxoa.setVisible(false);
       // btnsua.setVisible(false);
       
        jScrollPane2.setVisible(true);
        jTable2.setVisible(true);
       // btnThoat.setVisible(false);
       // btnReset.setVisible(false);
      //  jLabel6.setVisible(false);
       // jLabel7.setVisible(false);
        //txtgia.setVisible(false);
       // jcTinhtrang.setVisible(false);
        txtTk.setVisible(true);
       // btnPrint1.setVisible(false);
        btnTroLai.setVisible(true);
        jPanel1.setPreferredSize(new Dimension(480, 600));
        jTable1.setPreferredSize(new Dimension(480, 600));
        }
        tblsachTV = (DefaultTableModel) jTable2.getModel();
        ShowSachTv();
        ShowDuLieuSachTv();

    }

    private void ShowSachTv() {
        Sltv = Them_Sua_Xoa_Find_TV.findSachAll();
        tblsachTV.setRowCount(0);//xóa dữ liệu trong table
        for (Sach_ThuVien sachTv : Sltv) {
            tblsachTV.addRow(new Object[]{sachTv.getMASACH(), sachTv.getTENSACH(), sachTv.getSOLUONG(), sachTv.getNHAXB(), sachTv.getTHELOAI(), sachTv.getTACGIA()});
        }
    }

    public void ShowDuLieuSachTv() {
        try {
            jTable2.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if(CurrentUserRole.equals("user")){
                        int th = JOptionPane.showConfirmDialog(null, "Bạn có muốn xem mục lục của sách " + jTable2.getValueAt(jTable2.getSelectedRow(), 1) + "", "Confirm", JOptionPane.YES_NO_OPTION);
                        if (th == JOptionPane.YES_OPTION) {
                            //---------------------------
                            
                            String tempMS = jTable2.getValueAt(jTable2.getSelectedRow(), 0) + "";
                            
                            
                            File theDir = new File("ebooks");
                            if (!theDir.exists()){
                                theDir.mkdirs();
                            }
                            
                            
                            File pdfFile = new File("ebooks/"+ tempMS.replaceAll("\\s", "") + ".pdf");
                            if (pdfFile.exists()) {

                                if (Desktop.isDesktopSupported()) {
                                    try {
                                        Desktop.getDesktop().open(pdfFile);
                                    } catch (IOException ex) {
                                        Logger.getLogger(Quan_Ly_Sach.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                } else {
                                        System.out.println("Awt Desktop is not supported!");
                                }

                                } else {
                                         JOptionPane.showMessageDialog(null, "Sách chưa có mục lục");
                                }
                            
                            //---------------------------
                        } else{
                            return;
                        }

                    } else {
                    
                    if (jTable2.getSelectedRow() >= 0) {
                        ms.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 0) + "");
                        ts.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 1) + "");
                        nxb.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 2) + "");
                        nnxb.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 3) + "");
                        txtgia.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 4) + "");
                        tacgia.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 5) + "");

                    }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ms = new javax.swing.JTextField();
        ts = new javax.swing.JTextField();
        nxb = new javax.swing.JTextField();
        nnxb = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        btntk = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btnThoat = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtgia = new javax.swing.JTextField();
        txtTk = new javax.swing.JTextField();
        btnPrint1 = new javax.swing.JButton();
        tacgia = new javax.swing.JTextField();
        btnTroLai = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản Lý Sách Thư Viện");

        jLabel1.setBackground(new java.awt.Color(0, 102, 102));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ SÁCH");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Mã Sách :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Tên Sách :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Số Lượng :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Nhà Xuất Bản :");

        ms.setBackground(new java.awt.Color(204, 204, 204));

        ts.setBackground(new java.awt.Color(204, 204, 204));

        nxb.setBackground(new java.awt.Color(204, 204, 204));

        nnxb.setBackground(new java.awt.Color(204, 204, 204));

        btnThem.setBackground(new java.awt.Color(153, 153, 153));
        btnThem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnThem.setForeground(new java.awt.Color(0, 51, 51));
        btnThem.setText("Thêm Sách");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnxoa.setBackground(new java.awt.Color(153, 153, 153));
        btnxoa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnxoa.setForeground(new java.awt.Color(0, 51, 51));
        btnxoa.setText("Xóa Sách");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        btnsua.setBackground(new java.awt.Color(153, 153, 153));
        btnsua.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnsua.setForeground(new java.awt.Color(0, 51, 51));
        btnsua.setText("Sửa Sách");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        btntk.setBackground(new java.awt.Color(153, 153, 153));
        btntk.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btntk.setForeground(new java.awt.Color(0, 51, 51));
        btntk.setText("Tìm Kiếm Mã Sách");
        btntk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntkActionPerformed(evt);
            }
        });

        jTable2.setBackground(new java.awt.Color(153, 153, 153));
        jTable2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTable2.setForeground(new java.awt.Color(51, 51, 51));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Sách", "Tên Sách", "Số Lượng", "Nhà Xuất Bản", "Thể Loại", "Tác Giả"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        btnThoat.setBackground(new java.awt.Color(153, 153, 153));
        btnThoat.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnThoat.setForeground(new java.awt.Color(0, 51, 51));
        btnThoat.setText("Thêm Sách Bằng Excel");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(153, 153, 153));
        btnReset.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnReset.setForeground(new java.awt.Color(0, 51, 51));
        btnReset.setText("Xóa Text");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Thể Loại :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Tác Giả :");

        txtgia.setBackground(new java.awt.Color(204, 204, 204));

        txtTk.setBackground(new java.awt.Color(204, 204, 204));
        txtTk.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtTk.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnPrint1.setBackground(new java.awt.Color(153, 153, 153));
        btnPrint1.setForeground(new java.awt.Color(0, 51, 51));
        btnPrint1.setText("In Mã Sách");
        btnPrint1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrint1ActionPerformed(evt);
            }
        });

        tacgia.setBackground(new java.awt.Color(204, 204, 204));
        tacgia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tacgiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnThem)
                                .addGap(42, 42, 42)
                                .addComponent(btnxoa))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(ms, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ts)
                                        .addComponent(txtgia)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnsua)
                                        .addComponent(jLabel7)))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tacgia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nnxb, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nxb, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnReset)
                                        .addGap(31, 31, 31)
                                        .addComponent(btnPrint1))
                                    .addComponent(btnThoat, javax.swing.GroupLayout.Alignment.TRAILING)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(165, 166, Short.MAX_VALUE)
                        .addComponent(txtTk, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(155, 155, 155))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btntk)
                        .addGap(259, 259, 259)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nxb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nnxb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(tacgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnxoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsua, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrint1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                .addGap(14, 14, 14)
                .addComponent(txtTk, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btntk, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnTroLai.setBackground(new java.awt.Color(153, 153, 153));
        btnTroLai.setForeground(new java.awt.Color(0, 102, 102));
        btnTroLai.setText("Trở Về");
        btnTroLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTroLaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnTroLai)
                .addGap(38, 38, 38)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTroLai, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private static void addFontBarcode(PDFDocument pdf, Graphics2D pageG2, String barcodeMSG, int posX, int posY) throws PDFException, FontFormatException, IOException
	{
		// Embed the font
		Font code39Font = pdf.embedFont("free3of9.ttf", Font.TRUETYPE_FONT);
		pageG2.setFont(code39Font.deriveFont(64f));
		pageG2.drawString(barcodeMSG, posX, posY);
	}
	
	private static void addImageBarcode(Graphics2D pageG2, String barcodeMSG, int posX, int posY) throws PDFException
	{
		// This code creates a barcode image using Barcode39 and then adds the image to the page
		Code39Bean code39 = new Code39Bean();
		code39.setModuleWidth(2);
		code39.setBarHeight(50);
		code39.setWideFactor(2);
		BarcodeDimension dim = code39.calcDimensions(barcodeMSG);

		BufferedImage barcodeImage = new BufferedImage((int)dim.getWidth(), (int)dim.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D imageG2 = barcodeImage.createGraphics();
		imageG2.setColor(Color.white);
		imageG2.fillRect(0, 0, barcodeImage.getWidth(), barcodeImage.getHeight());
		imageG2.setColor(Color.black);
		code39.generateBarcode(new Java2DCanvasProvider(imageG2, 0), barcodeMSG);
		
		// Add the image to the page
		pageG2.drawImage(barcodeImage, posX, posY, null);
	}
    
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        int th = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm", "Confirm", JOptionPane.YES_NO_OPTION);
        if (th != JOptionPane.YES_OPTION) {
            return;
        }

        String masach = ms.getText();
        String tenssach = ts.getText();
        int soluong = Integer.parseInt(nxb.getText());
        String nhaxb = nnxb.getText();
        String theloai = txtgia.getText();
        String tg = tacgia.getText();
        
        Sach_ThuVien std = new Sach_ThuVien(masach, tenssach, soluong, nhaxb, theloai, tg);
        Them_Sua_Xoa_Find_TV.insert(std);
        JOptionPane.showMessageDialog(this, "Thêm thành công");
        ShowSachTv();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        // TODO add your handling code here:
        int select = jTable2.getSelectedRow();//lấy ra vị trí đc chọn
        if (select >= 0) {
            Sach_ThuVien stv = Sltv.get(select);//lấy ra dữ liệu đc chọn
            int xoa = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa");
            System.out.println(":" + xoa);//yes=0,no=1,cancel=2
            if (xoa == 0) {
                Them_Sua_Xoa_Find_TV.DeleteSach(stv.getMASACH());
                JOptionPane.showMessageDialog(this, "Xóa thành công");
                ShowSachTv();
            }
        }
    }//GEN-LAST:event_btnxoaActionPerformed


    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        // TODO add your handling code here:
        int sua = JOptionPane.showConfirmDialog(this, "Bạn có muốn Sửa", "Confirm", JOptionPane.YES_NO_OPTION);
        if (sua != JOptionPane.YES_OPTION) {
            return;
        }
        String masach = ms.getText();
        String tenssach = ts.getText();
        int soluong = Integer.parseInt(nxb.getText());
        String nhaxb = nnxb.getText();
        String theloai = txtgia.getText();
        String tg = tacgia.getText();
        
        Sach_ThuVien std = new Sach_ThuVien(masach, tenssach, soluong, nhaxb, theloai, tg);
        Them_Sua_Xoa_Find_TV.Update(std);
        JOptionPane.showMessageDialog(this, "Sửa thành công");
        tblsachTV.setRowCount(0);
        ShowSachTv();
    }//GEN-LAST:event_btnsuaActionPerformed


    private void btntkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntkActionPerformed
        // TODO add your handling code here:
        String Search = txtTk.getText();
        if(!txtTk.getText().equals("")){
           if (Search.length() > 0) {//độ dài>0 mới thực hiện
            Sltv = Them_Sua_Xoa_Find_TV.findmasach(Search);
            tblsachTV.setRowCount(0);
            for (Sach_ThuVien sachTv : Sltv) {
                tblsachTV.addRow(new Object[]{sachTv.getMASACH(), sachTv.getTENSACH(), sachTv.getSOLUONG(), sachTv.getNHAXB(), sachTv.getTHELOAI(), sachTv.getTACGIA()});

            }
            }
        } else {
           ShowSachTv();
        }
    }//GEN-LAST:event_btntkActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here
        JFileChooser fileChooser = new JFileChooser();
        //fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            try {
                int resultExcel = Them_Sua_Xoa_Find_TV.themSachTuExcel(selectedFile.getAbsolutePath());
                
                if(resultExcel == 1){
                    JOptionPane.showMessageDialog(this, "Thêm Sách Từ Excel Thành Công");
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm Sách Từ Excel Thất Bại");
                }
            } catch (IOException ex) {
                Logger.getLogger(Quan_Ly_Sach.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Quan_Ly_Sach.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        
//        if (JOptionPane.showConfirmDialog(this, "Bạn có chắn muốn thoát không?", "Thông báo",
//                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
//            System.exit(0);
//        }
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        ms.setText("");
        ts.setText("");
        nxb.setText("");
        nnxb.setText("");
        txtgia.setText("");
        txtTk.setText("");
        tacgia.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnTroLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTroLaiActionPerformed
        // TODO add your handling code here:
        int Exit = JOptionPane.showConfirmDialog(this, "Bạn có muốn rời khỏi trang?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (Exit != JOptionPane.YES_OPTION) {
            return;
        }
        QUAN_LY_THU_VIEN_SACH tvs = new QUAN_LY_THU_VIEN_SACH(CurrentUserRole);
        tvs.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTroLaiActionPerformed

    private void btnPrint1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrint1ActionPerformed
        // TODO add your handling code here:
      //  JFileChooser fc = new JFileChooser();//JFileChooser trong java là một đối tượng hiển thị khung cho phép bạn mở hoặc lưu file
     //   fc.setDialogTitle("Lưu Tệp");//tên tiêu đề
     //   int userSelection = fc.showSaveDialog(this);
      
      ArrayList<String> barcodeMSG = new ArrayList<String>();
      List<Sach_ThuVien> arraySachTemp = new ArrayList<>();
        if (ms.getText().equals("")) {
           // File filetosave = fc.getSelectedFile();
         
             //   FileWriter fw = new FileWriter(filetosave);//Lớp FileWriter được sử dụng để ghi các dữ liệu theo định dạng ký tự vào một file
              //  BufferedWriter bw = new BufferedWriter(fw);//Lớp BufferedWriter được sử dụng để cung cấp bộ đệm cho các các thể hiện của lớp Writer
       
            arraySachTemp = Them_Sua_Xoa_Find_TV.findSachAll();
            //tblsachTV.setRowCount(0);//xóa dữ liệu trong table
            for (Sach_ThuVien sachTv : arraySachTemp) {
               // tblsachTV.addRow(new Object[]{sachTv.getMASACH(), sachTv.getTENSACH(), sachTv.getNAMXB(), sachTv.getNHAXB(), sachTv.getGIA(), sachTv.getTINHTRANG()});
               barcodeMSG.add(sachTv.getMASACH());
            }
              
        } else {
            barcodeMSG.add(ms.getText());
        }
       
        int maxCol = 4;
        Document document = null;
      
        document = new Document(new Rectangle(360, 852));
       
         // Step-2: Create PdfWriter object for the document
        PdfWriter writer = null;
          try {
              writer = PdfWriter.getInstance(document, new FileOutputStream("MaSach_Output.pdf"));
          } catch (DocumentException ex) {
              Logger.getLogger(Quan_Ly_Sach.class.getName()).log(Level.SEVERE, null, ex);
          } catch (FileNotFoundException ex) {
              Logger.getLogger(Quan_Ly_Sach.class.getName()).log(Level.SEVERE, null, ex);
          }
         // Step -3: Open document for editing
        document.open();
        
        PdfContentByte cb = writer.getDirectContent();
        PdfPTable table;
     
        if(barcodeMSG.size() >= 4){
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
        BaseFont bf;
          try {
              bf = BaseFont.createFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
              com.itextpdf.text.Font f = new com.itextpdf.text.Font(bf, 12);
               Paragraph p = new Paragraph("Thư Viện MTG TL", f);
               p.setAlignment(Element.ALIGN_CENTER);
                cell.addElement(p);
          } catch (DocumentException ex) {
              Logger.getLogger(Quan_Ly_Sach.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) {
              Logger.getLogger(Quan_Ly_Sach.class.getName()).log(Level.SEVERE, null, ex);
          }
    
       
        Chunk linebreak2 = new Chunk(new LineSeparator());
        cell.addElement(linebreak2); 
        String[] arryS = barcode.split(" ");
        //cell = new PdfPCell();
        for (String arr : arryS){
           
            Paragraph temp = new Paragraph(arr);
           // temp.setAlignment(Element.ALIGN_CENTER);
            temp.setAlignment(Element.ALIGN_CENTER);
            cell.addElement(temp);   
        }
       
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
        //Step-8: Close the PDF document
        /////////////////
        File pdfFile = new File("MaSach_Output.pdf");
                            if (pdfFile.exists()) {

                                if (Desktop.isDesktopSupported()) {
                                    try {
                                        Desktop.getDesktop().open(pdfFile);
                                    } catch (IOException ex) {
                                        Logger.getLogger(Quan_Ly_Sach.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            }
        
        
        
        
        //////////////
        
       document.close();
    }//GEN-LAST:event_btnPrint1ActionPerformed

    private void tacgiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tacgiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tacgiaActionPerformed

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
            java.util.logging.Logger.getLogger(Quan_Ly_Sach.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Quan_Ly_Sach.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Quan_Ly_Sach.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Quan_Ly_Sach.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Quan_Ly_Sach(CurrentUserRole).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrint1;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnTroLai;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btntk;
    private javax.swing.JButton btnxoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField ms;
    private javax.swing.JTextField nnxb;
    private javax.swing.JTextField nxb;
    private javax.swing.JTextField tacgia;
    private javax.swing.JTextField ts;
    private javax.swing.JTextField txtTk;
    private javax.swing.JTextField txtgia;
    // End of variables declaration//GEN-END:variables
}
