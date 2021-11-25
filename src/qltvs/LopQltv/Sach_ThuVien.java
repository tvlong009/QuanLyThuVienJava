package qltvs.LopQltv;





/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JOS LINH NGUYEN
 */
// 
public class Sach_ThuVien {
    String MASACH,TENSACH;
    int SOLUONG;
    String NHAXB;
    String THELOAI;
    String TACGIA;

    public Sach_ThuVien() {
    }

    public Sach_ThuVien(String MASACH, String TENSACH, int SOLUONG, String NHAXB, String THELOAI, String TACGIA) {
        this.MASACH = MASACH;
        this.TENSACH = TENSACH;
        this.SOLUONG = SOLUONG;
        this.NHAXB = NHAXB;
        this.THELOAI = THELOAI;
        this.TACGIA = TACGIA;
    }

    public String getMASACH() {
        return MASACH;
    }

    public void setMASACH(String MASACH) {
        this.MASACH = MASACH;
    }

    public String getTENSACH() {
        return TENSACH;
    }

    public void setTENSACH(String TENSACH) {
        this.TENSACH = TENSACH;
    }

    public int getSOLUONG() {
        return SOLUONG;
    }

    public void setSOLUONG(int SOLUONG) {
        this.SOLUONG = SOLUONG;
    }

    public String getNHAXB() {
        return NHAXB;
    }

    public void setNHAXB(String NHAXB) {
        this.NHAXB = NHAXB;
    }

    public String getTHELOAI() {
        return THELOAI;
    }

    public void setGIA(int GIA) {
        this.THELOAI = THELOAI;
    }

    public String getTACGIA() {
        return TACGIA;
    }

    public void setTACGIA(String TACGIA) {
        this.TACGIA = TACGIA;
    }

    
}
