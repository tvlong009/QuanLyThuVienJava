package qltvs.LopQltv;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.io.FileInputStream;
import qltvs.LopQltv.MuonTra_ThuVien;
import qltvs.LopQltv.Sach_ThuVien;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JOS LINH NGUYEN
 */

public class Them_Sua_Xoa_Find_TV extends Sach_ThuVien{
    public static List<Sach_ThuVien> findSachAll() {// lấy ra ds các sinh viên 
        List<Sach_ThuVien> SSlist = new ArrayList<>();//quản lý dữ liệu đầu ra
        Connection con = null;
        Statement st = null;//lấy dữ liệu từ database đổ ra
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLTV", "admin", "admin");

            String sql = "select*from SACH";
            st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);//rs(con trỏ)//lấy dữ liệu trả về
            while (rs.next()) {//cho phép chuyển từng bản ghi trên dữ liệu đầu ra
                Sach_ThuVien std = new Sach_ThuVien(rs.getString("MASACH"), rs.getString("TENSACH"), rs.getInt("SOLUONG"),rs.getString("NHAXB"),rs.getString("THELOAI"),rs.getString("TACGIA"));
                SSlist.add(std);
            }
        } catch (Exception ex) {
            Logger.getLogger(Them_Sua_Xoa_Find_TV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SSlist;//trả về ds các sv lấy ra từ database
    }
    
      public static Sach_ThuVien findSach(String ms) {// lấy ra ds các sinh viên 
        Sach_ThuVien SSlist = new Sach_ThuVien();//quản lý dữ liệu đầu ra
        Connection con = null;
        Statement st = null;//lấy dữ liệu từ database đổ ra
        PreparedStatement ps;
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLTV", "admin", "admin");

            String sql = "select * from SACH WHERE MASACH=?";
            ps = con.prepareCall(sql);
            ps.setString(1, ms);
            ResultSet rs = ps.executeQuery();

            //ResultSet rs = st.executeQuery(sql);//rs(con trỏ)//lấy dữ liệu trả về
            while (rs.next()) {//cho phép chuyển từng bản ghi trên dữ liệu đầu ra
                SSlist = new Sach_ThuVien(rs.getString("MASACH"), rs.getString("TENSACH"), rs.getInt("SOLUONG"),rs.getString("NHAXB"),rs.getString("THELOAI"),rs.getString("TACGIA"));
                //SSlist.add(std);
            }
        } catch (Exception ex) {
            Logger.getLogger(Them_Sua_Xoa_Find_TV.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return SSlist;//trả về ds các sv lấy ra từ database
    }
      
      public static int themSachTuExcel(String filePath) throws FileNotFoundException, IOException, SQLException {
        Connection con ;
        PreparedStatement ps;
        
            
        try {
            
        //    FileInputStream inputStream = new FileInputStream(filePath);
            Workbook  workbook = WorkbookFactory.create(new File(filePath));
            // workbook = null;
            //workbook  = new XSSFWorkbook(inputStream);
              
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = firstSheet.iterator();
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLTV", "admin", "admin");
            con.setAutoCommit(false);

            
            int count = 0;
            long start = System.currentTimeMillis();
            //int batchSize = 20;
            rowIterator.next(); // skip the header row
             
            while (rowIterator.hasNext()) {
                Row nextRow = rowIterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();
                
                String sql = "insert into SACH (MASACH,TENSACH,SOLUONG,NHAXB,THELOAI,TACGIA) values (?,?,?,?,?,?) ";
                ps = con.prepareCall(sql);//truyền dữ liệu vào
                
                Sach_ThuVien SachTemp = null;
                while (cellIterator.hasNext()) {
                    Cell nextCell = cellIterator.next();
 
                    int columnIndex = nextCell.getColumnIndex();
                     
                      
                    switch (columnIndex) {
                    case 0:
                        String ms = nextCell.getStringCellValue();
                        
                        
                        PreparedStatement psTemp;
                        String sqlFindSach = "Select * from SACH WHERE MASACH=?";
                        psTemp = con.prepareCall(sqlFindSach);
                        psTemp.setString(1, ms);
                        ResultSet rs = psTemp.executeQuery();

                    
                    while (rs.next()) {//cho phép chuyển từng bản ghi trên dữ liệu đầu ra
                        SachTemp = new Sach_ThuVien(rs.getString("MASACH"), rs.getString("TENSACH"), rs.getInt("SOLUONG"),rs.getString("NHAXB"),rs.getString("THELOAI"),rs.getString("TACGIA"));
                    }
                    
                    if(ObjectUtils.isEmpty(SachTemp)){
                        ps.setString(1, ms);
                    } else { 
                         sql = "UPDATE SACH SET TENSACH=?, SOLUONG=?, NHAXB=?, THELOAI=?, TACGIA=? WHERE MASACH=? ";
                         ps = con.prepareCall(sql);//truyền dữ liệu vào
                         ps.setString(6, ms);
                    }
                        
                        break;
                    case 1:
                         if(ObjectUtils.isEmpty(SachTemp)){
                            ps.setString(2, nextCell.getStringCellValue());
                         } else {
                            ps.setString(1, nextCell.getStringCellValue());
                         }
                        
                        break;
                    case 2:
                        if(ObjectUtils.isEmpty(SachTemp)){
                            ps.setInt(3, (int) nextCell.getNumericCellValue());
                        } else {
                           ps.setInt(2, (int) nextCell.getNumericCellValue());
                        }
                        break;
                    case 3:
                        if(ObjectUtils.isEmpty(SachTemp)){
                            ps.setString(4, nextCell.getStringCellValue());
                        } else {
                            ps.setString(3, nextCell.getStringCellValue());
                        }
                        break;
                    case 4:
                        if(ObjectUtils.isEmpty(SachTemp)){
                            ps.setString(5, nextCell.getStringCellValue());
                        } else {
                            ps.setString(4, nextCell.getStringCellValue());
                        }
                        break;
                    case 5:
                        if(ObjectUtils.isEmpty(SachTemp)){
                            ps.setString(6, nextCell.getStringCellValue());
                        } else {
                            ps.setString(5, nextCell.getStringCellValue());
                        }
                        break;
                    }
                }
                ps.addBatch();
                ps.executeBatch();  
                count++;
            }
           
           
             workbook.close();
             con.commit();
             con.close();
             
            long end = System.currentTimeMillis();
            System.out.printf("Import done in %d ms\n", (end - start));
            System.out.printf("Imported " + count + " rows"); 
             return 1;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }
      
      public static void UpdateSoluongSach(Sach_ThuVien stv)  {
        Connection con = null;
       PreparedStatement ps = null;
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLTV", "admin", "admin");

            String sql = "update SACH set SOLUONG=? WHERE MASACH=?";
            ps = con.prepareCall(sql);
            ps.setInt(1, stv.getSOLUONG());
            ps.setString(2, stv.getMASACH());
            ps.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
       
        }     
    }


    public static void insert(Sach_ThuVien stv) {
        Connection con ;
        PreparedStatement ps;
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLTV", "admin", "admin");

            String sql = "insert into SACH (MASACH,TENSACH,SOLUONG,NHAXB,THELOAI,TACGIA) values (?,?,?,?,?,?) ";
            ps = con.prepareCall(sql);//truyền dữ liệu vào

            ps.setString(1, stv.getMASACH());
            ps.setString(2, stv.getTENSACH());
            ps.setInt(3, stv.getSOLUONG());
            ps.setString(4, stv.getNHAXB());
            ps.setString(5, stv.getTHELOAI());
            ps.setString(6, stv.getTACGIA());

            ps.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void Update(Sach_ThuVien stv)  {
        Connection con = null;
       PreparedStatement ps = null;
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLTV", "admin", "admin");

            String sql = "update SACH set TENSACH=?,SOLUONG=?,NHAXB=?,THELOAI=?,TACGIA=? where MASACH=?";
            ps = con.prepareCall(sql);
            
            ps.setString(6, stv.getMASACH());
            ps.setString(1, stv.getTENSACH());
            ps.setInt(2, stv.getSOLUONG());
            ps.setString(3, stv.getNHAXB());
            ps.setString(4, stv.getTHELOAI());
            ps.setString(5, stv.getTACGIA());
           

            ps.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
       
        }     
    }
    public static void DeleteSach(String MASACH)  {
       Connection con = null;
       PreparedStatement ps = null;
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLTV", "admin", "admin");

            String sql = "delete from SACH where MASACH=?";
            ps = con.prepareCall(sql);
            ps.setString(1,MASACH);
            ps.execute();
            
        } catch (Exception ex) {
            ex.printStackTrace();
       
        }
            
    }

    public static List<Sach_ThuVien> findmasach(String MASACH) {
        List<Sach_ThuVien> SSlist = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLTV", "admin", "admin");

            String sql = "select * from SACH where MASACH like ? or THELOAI like ? or TACGIA like ? or TENSACH like ?";
            ps = con.prepareCall(sql);
            ps.setString(1,"%"+MASACH+"%");
            ps.setString(2,"%"+MASACH+"%");
            ps.setString(3,"%"+MASACH+"%");
            ps.setString(4,"%"+MASACH+"%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Sach_ThuVien std = new Sach_ThuVien(rs.getString("MASACH"), rs.getString("TENSACH"), rs.getInt("SOLUONG"), rs.getString("NHAXB"),rs.getString("THELOAI"),rs.getString("TACGIA"));
                SSlist.add(std);
            }
        } catch (Exception ex) {
                Logger.getLogger(Them_Sua_Xoa_Find_TV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SSlist;
    }
    
    
    
   ////////QUẢN LÍ MƯỢN TRẢ SÁCH THƯ VIỆN 
    
    public static List<MuonTra_ThuVien> HienThiAllMuonTra(){
        
        List<MuonTra_ThuVien> SSlist = new ArrayList<>();
        Connection con = null;
        Statement st = null;
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLTV", "admin", "admin");

            String sql = "select*from MUONTRA";
            st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                MuonTra_ThuVien std = new MuonTra_ThuVien(rs.getString("MASV"),rs.getString("MASACH"),rs.getString("NGAYMUON"),rs.getString("NGAYTRA"),rs.getInt("SOLUONG"),rs.getString("QLTHUVIEN"));
                SSlist.add(std);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return SSlist;
    }
    
    
    public static void InsertMuonTra(MuonTra_ThuVien stv){
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLTV", "admin", "admin");

            String sql = "insert into MUONTRA(MASV,MASACH,NGAYMUON,NGAYTRA,SOLUONG,QLTHUVIEN) values (?,?,?,?,?,?) ";
            ps = con.prepareCall(sql);

            ps.setString(1, stv.getMSV());
            ps.setString(2,stv.getMASACH());
            ps.setString(3, stv.getNGAYMUON());
            ps.setString(4, stv.getNGAYTRA());
            ps.setInt(5, stv.getSOLUONG());
            ps.setString(6,stv.getQLTHUVIEN());

            ps.execute();
        } catch (Exception ex) {
            Logger.getLogger(Them_Sua_Xoa_Find_TV.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public static void DeleteMuontra(String MASV)  {
       Connection con = null;
       PreparedStatement ps = null;
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLTV", "admin", "admin");

            String sql = "delete from MUONTRA where MASV=?";
            ps = con.prepareCall(sql);
            ps.setString(1,MASV);
            ps.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
       
        }
            
    }
    public static List<MuonTra_ThuVien> findQLMT(String MASV) {
        List<MuonTra_ThuVien> Slist = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLTV", "admin", "admin");

            String sql = "select*from MUONTRA where MASV like ?";
            ps = con.prepareCall(sql);
            ps.setString(1,"%"+MASV+"%");
       
  
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MuonTra_ThuVien std = new MuonTra_ThuVien(rs.getString("MASV"), rs.getString("MASACH"), rs.getString("NGAYMUON"), rs.getString("NGAYTRA"),rs.getInt("SOLUONG"),rs.getString("QLTHUVIEN"));
                Slist.add(std);
            }
        } catch (Exception ex) {
                Logger.getLogger(Them_Sua_Xoa_Find_TV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Slist;
    }
}



