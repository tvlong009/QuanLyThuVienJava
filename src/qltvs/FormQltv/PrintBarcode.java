/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qltvs.FormQltv;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.io.File;

/**
 *
 * @author Romy_Nguyen
 */
public class PrintBarcode implements Printable {

    String orderNo = "";
    int flag = 0;
    File file = null;
    File file1 = null;
    BufferedImage src = null;
    BufferedImage src1 = null;
    String[] humanReadableArray;
    String humanReadable;

    public PrintBarcode(String orderNo, int flag) {
        this.orderNo = orderNo;
        this.flag = flag;
    }

    public PrintBarcode(String barcode, String humanReadable, int flag) {
        this.orderNo = barcode;
        this.humanReadable = humanReadable;
        this.flag = flag;
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
