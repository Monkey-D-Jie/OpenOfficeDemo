package com.jf.myDemo.OpenOfficeDemo;

import com.jf.myDemo.converterUtils.MyOpenOfficeConverter;
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

    @Test
    public void fileTest1() throws DataFormatException, OfficeException {
        File resFile = new File("E:\\Users\\大型转码文件测试-300页测试-demo用.docx");
        File pdfFile = new File("E:\\Users\\libreOffice\\2codeHtml-page.html");
        MyOpenOfficeConverter.toHtmlFileV2(resFile);
    }
}