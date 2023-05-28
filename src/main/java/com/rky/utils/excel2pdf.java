package com.rky.utils;



import com.aspose.cells.License;
import com.aspose.cells.PdfSaveOptions;
import com.aspose.cells.Workbook;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class excel2pdf {



    /**
     * 获取license 去除水印
     * @return
     */
/*    public static boolean getLicense() {
        boolean result = false;
        try {
            InputStream is = excel2pdf.class.getClassLoader().getResourceAsStream("\\license.xml");
            License aposeLic = new License();
            aposeLic.setLicense(is);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }*/


  /*  public static void excel2pdf(InputStream inputStream, String desFilePathd ){
        // 验证License 若不验证则转化出的pdf文档会有水印产生
        if (!getLicense()) {
            return;
        }
        try {
            Workbook wb = new Workbook(inputStream);// 原始excel路径

            FileOutputStream fileOS = new FileOutputStream(desFilePathd);
            PdfSaveOptions pdfSaveOptions = new PdfSaveOptions();
            pdfSaveOptions.setOnePagePerSheet(true);


            int[] autoDrawSheets={3};
            //当excel中对应的sheet页宽度太大时，在PDF中会拆断并分页。此处等比缩放。
//            autoDraw(wb,autoDrawSheets);

            int[] showSheets={0};
            //隐藏workbook中不需要的sheet页。
            printSheetPage(wb,showSheets);
            wb.save(fileOS, pdfSaveOptions);
            fileOS.flush();
            fileOS.close();
            //System.out.println("完毕");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    *//**
     * 设置打印的sheet 自动拉伸比例
     * @param wb
     * @param page 自动拉伸的页的sheet数组
     *//*
    public static void autoDraw(Workbook wb,int[] page){
        if(null!=page&&page.length>0){
            for (int i = 0; i < page.length; i++) {
                wb.getWorksheets().get(i).getHorizontalPageBreaks().clear();
                wb.getWorksheets().get(i).getVerticalPageBreaks().clear();
            }
        }
    }


    *//**
     * 隐藏workbook中不需要的sheet页。
     * @param wb
     * @param page 显示页的sheet数组
     *//*
    public static void printSheetPage(Workbook wb,int[] page){
        for (int i= 1; i < wb.getWorksheets().getCount(); i++)  {
            wb.getWorksheets().get(i).setVisible(false);
        }
        if(null==page||page.length==0){
            wb.getWorksheets().get(0).setVisible(true);
        }else{
            for (int i = 0; i < page.length; i++) {
                wb.getWorksheets().get(i).setVisible(true);
            }
        }
    }*/


    public static void excel2pdf(InputStream inputStream, String savePath ){

        try {
            Workbook wb = new Workbook(inputStream);// 原始excel路径

            FileOutputStream fileOS = new FileOutputStream(savePath);
            PdfSaveOptions pdfSaveOptions = new PdfSaveOptions();
            pdfSaveOptions.setOnePagePerSheet(true);


            int[] autoDrawSheets={3};

            wb.save(fileOS, pdfSaveOptions);
            fileOS.flush();
            fileOS.close();
            //System.out.println("完毕");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
