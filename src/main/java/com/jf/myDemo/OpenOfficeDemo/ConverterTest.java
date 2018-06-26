package com.jf.myDemo.OpenOfficeDemo;

import com.jf.myDemo.converterUtils.MyOpenOfficeConverter;
import com.jf.myDemo.converterUtils.Pdf2Html.Pdf2htmlEXUtil;
import org.jodconverter.office.OfficeException;
import org.junit.Test;

import java.io.File;
import java.util.zip.DataFormatException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: wjie
 * @date: 2018/1/9 0009
 * @time: 10:40
 * To change this template use File | Settings | File and Templates.
 * 来自：https://github.com/sbraconnier/jodconverter/wiki/Using-Filters
 *
 */

public class ConverterTest {

//    private String libreHtmlDir = "E:\\Users\\libreOffice\\2Html\\";
    private String libreHtmlDir = "E:\\Users\\libreOffice\\2Html";
    //    private String openHtmlDir = "E:\\Users\\openOffice\\2Html\\";
    private String openHtmlDir = "E:\\Users\\openOffice\\2Html";
    private String librePdfDir = "E:\\Users\\libreOffice\\2Pdf\\";
    private String openPdfDir = "E:\\Users\\openOffice\\2Pdf\\";



    @Test
    public void fileTest() throws DataFormatException, OfficeException {
        File resFile = new File("E:\\Users\\WordFiles\\test-docx.docx");
        File pdfFile = new File(libreHtmlDir+"testDocx-pdf.pdf");
//        File pdfFile = new File(openHtmlDir+"testDocx-pdf.pdf");

        MyOpenOfficeConverter.convertFile(resFile,pdfFile);
//        MyLibreOfficeConverter.convertFile(resFile,pdfFile);
        Pdf2htmlEXUtil.pdf2html("D:\\Temp\\pdf2html\\pdf2htmlEX.exe",openHtmlDir+"testDocx-pdf.pdf",libreHtmlDir,"testDocx-pdf.html");
    }
}
