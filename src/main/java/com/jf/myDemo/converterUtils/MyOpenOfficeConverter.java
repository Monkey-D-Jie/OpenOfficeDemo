package com.jf.myDemo.converterUtils;

import com.jf.myDemo.converfileter.PageCounterFilter;
import org.jodconverter.LocalConverter;
import org.jodconverter.filter.text.PageSelectorFilter;
import org.jodconverter.office.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.DataFormatException;

/**
 * Created with IntelliJ IDEA.
 * User: wjie
 * Date: 2018/1/9 0009
 * Time: 10:22
 * To change this template use File | Settings | File and Templates.
 */
public class MyOpenOfficeConverter {

    private static String officeHome = "D:/OpenOffice/of4";
    //    将转码工具变成LibreOffice，方法沿用原来的---》并不能沿用
//    private static String officeHome = "D:/Software/LibreOffice";


    public static void office2Pdf(File inputFile, File pdfFile) throws DataFormatException {
        // Create an office manager using the default configuration.
        // The default port is 2002. Note that when an office manager
        // is installed, it will be the one used by default when
        // a converter is created.
        try {
            /*创建一个openOfficeManager对象*/
            /*方法①*/
            //LocalOfficeManager.builder().portNumbers(8100).officeHome(officeHome).install().build().start();
            /*方法②*/
            OfficeManager officeManager = LocalOfficeManager.builder().officeHome(officeHome).install().build();
            officeManager.start();
            /*搁gitHub官网上整下来的*/
            // Convert
           /* JodConverter
                    .convert(inputFile)
                    .to(pdfFile)
                    .execute();*/

            /*分页转换-1*/
            /*Map<String, Object> filterData = new HashMap<String,Object>();
            filterData.put("PageRange", "3");
            Map<String, Object> customProperties = new HashMap<String,Object>();
            customProperties.put("FilterData", filterData);
            LocalConverter
                    .builder()
                    .storeProperties(customProperties)
                    .build()
                    .convert(inputFile)
                    .to(pdfFile)
                    .execute();*/
            /*分页转换-2*/
            /**
             * @author: wjie
             * @date: 2018/2/28 0028 14:53
            测试结果：没看到有什么不一样嘚。。。。mmp
             */
            PageSelectorFilter selectorFilter;
//            System.out.println("由pageCounter获取的到页值数为："+pageCount);
            PageCounterFilter pageCounterFilter = new PageCounterFilter();
            //将辅助文件放在内存中，用后即删
            File countFile = new File("temp.html");
            /*选择要转换的 页码范围*/
            LocalConverter
                    .builder()
                    .filterChain(pageCounterFilter)
                    .build()
                    .convert(inputFile)
                    .to(countFile)
                    .execute();
            if (countFile.exists()) {
                countFile.delete();
            }
            for (int i = 1; i <= pageCounterFilter.getPageCount(); i++) {
                /*指定转换的页数*/
                selectorFilter = new PageSelectorFilter(i);
                File resultFile = new File("E:\\Users\\openOffice\\2Html\\2codeHtml-page-" + i + ".html");
                /*选择要转换的 页码范围*/
                LocalConverter
                        .builder()
//                        .filterChain(pageCounterFilter,selectorFilter)
                        //未添加pageCountFilter的情况，测试结果--》
                        .filterChain(selectorFilter)
                        .build()
                        .convert(inputFile)
                        .to(resultFile)
                        .execute();
            }
//            System.out.println("由pageCounter获取的到页值数为："+pageCounterFilter.getPageCount());
            officeManager.stop();
        } catch (OfficeException e) {
            e.printStackTrace();
        }
       /* finally {
            // Stop the office process
            if(officeManager != null){
                LocalOfficeUtils.stopQuietly(officeManager);
            }
        }*/
    }

    public static void toHtmlFile(File convertFile) throws OfficeException {
        OfficeManager officeManager = LocalOfficeManager.builder().officeHome(officeHome).install().build();
        officeManager.start();
        Map<String, Object> filterData = new HashMap<>(8);
            /*这个才是设置 页面范围 的吧？？？？？有待测试*/
        filterData.put("PageRange", 5);
        Map<String, Object> customProperties = new HashMap<>(8);
        customProperties.put("FilterData", filterData);
        /**
         * @author: wjie
         * @date: 2018/3/6 0006 15:02
         * 自定义分页属性测试
         * 测试结果：
         * ①:转html--》没用，直接转过去的
         * ②:转pdf--》似乎也是没用额
         */
        OfficeUrl officeUrl = new OfficeUrl(8100);
        PageCounterFilter pageCounterFilter = new PageCounterFilter();
        File resHtmlFile = new File("E:\\Users\\openOffice\\2Pdf\\2codePdf.pdf");
        LocalConverter
                .builder()
                .filterChain(pageCounterFilter)
//                .storeProperties(customProperties)
                .build()
                .convert(convertFile)
                .to(resHtmlFile)
                .execute();
    }

    public static void toHtmlFileV2(File convertFile) throws OfficeException {
        /**
         * @author: wjie
         * @date: 2018/3/7 0007 10:46
         * 新思路：
         * ①：首先由第一次转换时，直接生成第一个文件，这样就不用删除了，而且也能获得pageCount的值；
         * ②：用循环，次数为pageCount-1，再生成后面的文件;
         * ③:相比之下的话，就是少了删除文件的处理；生成的也能直接用
         * 测试结果：能行，但还是得多调用一次转化过程
         */
        OfficeManager officeManager = LocalOfficeManager.builder().officeHome(officeHome).install().build();
        officeManager.start();
        PageCounterFilter pageCounterFilter = new PageCounterFilter();
        PageSelectorFilter firstSelectorFilter = new PageSelectorFilter(1);
        File firstFile = new File("E:\\Users\\libreOffice\\2Html\\2codeHtml-page-1.html");
        LocalConverter
                .builder()
//                        .filterChain(pageCounterFilter,selectorFilter)
                //未添加pageCountFilter的情况，测试结果--》
                .filterChain(pageCounterFilter, firstSelectorFilter)
                .build()
                .convert(convertFile)
                .to(firstFile)
                .execute();
        for (int i = 2; i <= pageCounterFilter.getPageCount(); i++) {
                /*指定转换的页数*/
            PageSelectorFilter selectorFilter = new PageSelectorFilter(i);
            File resultFile = new File("E:\\Users\\libreOffice\\2Html\\2codeHtml-page-" + i + ".html");
                /*选择要转换的 页码范围*/
            LocalConverter
                    .builder()
                    //还是要加上‘页数’过滤器才行
                    .filterChain(pageCounterFilter, selectorFilter)
                    //未添加pageCountFilter的情况，测试结果--》有问题，最后几页重复了
//                    .filterChain(selectorFilter)
                    .build()
                    .convert(convertFile)
                    .to(resultFile)
                    .execute();
        }
    }

}
