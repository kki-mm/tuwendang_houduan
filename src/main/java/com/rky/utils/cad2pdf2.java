package com.rky.utils;
import com.aspose.cad.Color;
import com.aspose.cad.Image;
import com.aspose.cad.imageoptions.CadRasterizationOptions;
import com.aspose.cad.imageoptions.PdfOptions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author lcq
 */
@Slf4j
@Component
public class cad2pdf2 {

    public static void Dwg2Pdf(InputStream inputStream,String savePath)  {

        log.info("************");
        //FileInputStream fileInputStream;

        //fileInputStream = new FileInputStream(dwgFile);//直接输入

        Image objImage = Image.load(inputStream);

        CadRasterizationOptions rasterizationOptions = new  CadRasterizationOptions();

        //设置颜色
        rasterizationOptions.setBackgroundColor(Color.getBlack());
        rasterizationOptions.setPageWidth(1400);
        rasterizationOptions.setPageHeight(650);
        rasterizationOptions.setAutomaticLayoutsScaling(true);
        rasterizationOptions.setNoScaling (false);
        rasterizationOptions.setDrawType(1);

        PdfOptions pdfOptions = new PdfOptions();
        pdfOptions.setVectorRasterizationOptions(rasterizationOptions);

        //输出文件  重新写
        File outputFile = new File(savePath);
        //存放地址
        objImage.save(outputFile.getPath(), pdfOptions);
       // log.info(dwgFile.getName()+"文件转换成功");
       // fileInputStream.close();
       // return outputFile;
    }

}
