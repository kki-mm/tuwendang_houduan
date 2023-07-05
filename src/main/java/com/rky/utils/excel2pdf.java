package com.rky.utils;



import com.aspose.cells.License;
import com.aspose.cells.PdfSaveOptions;
import com.aspose.cells.Workbook;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class excel2pdf {


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
