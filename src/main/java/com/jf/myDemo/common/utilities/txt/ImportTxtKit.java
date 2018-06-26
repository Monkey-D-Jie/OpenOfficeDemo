package com.jf.myDemo.common.utilities.txt;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 读取txt数据工具类
 * Created by js on 2017/3/28.
 */
public class ImportTxtKit {
    /**
     * TXT文件处理工具类日志记录
     */
    private static Logger logger = LogManager.getLogger(ImportTxtKit.class.getName());
    /**
     * 编码方式
     */
    private final static String CODING = "UTF-8";

    /**
     * 将指定路径的TXT进行解析
     *
     * @param filePath 文件路径
     * @return List<String> 数据列表
     */
    public static List<String> readTxtFile(final String filePath) {
        List<String> list = null;
        try {
            File file = new File(filePath);
            /*判断文件是否存在*/
            if (file.isFile() && file.exists()) {
                list = ImportTxtKit.readTxtFile(new FileInputStream(file));
            } else {
                if (ImportTxtKit.logger.isInfoEnabled()) {
                    ImportTxtKit.logger.info("系统未找到指定路径的文件，文件路径是----->>" + filePath);
                }
            }
        } catch (FileNotFoundException e) {
            if (ImportTxtKit.logger.isErrorEnabled()) {
                ImportTxtKit.logger.error("将指定路径的TXT进行解析，错误日志是---->>" + e.getMessage(), e);
            }
        }
        return list;
    }

    /**
     * 将输入流的TXT进行解析
     *
     * @param inputStream 文件输入流
     * @return List<String> 数据列表
     */
    public static List<String> readTxtFile(FileInputStream inputStream) {
        BufferedReader bufferedReader = null;
        InputStreamReader read = null;
        List<String> list = null;
        String lineTxt;
        try {
            /*考虑到编码格式*/
            read = new InputStreamReader(inputStream, CODING);
            bufferedReader = new BufferedReader(read);
            list = new ArrayList<String>();
            while ((lineTxt = bufferedReader.readLine()) != null) {
                list.add(lineTxt);
            }
        } catch (UnsupportedEncodingException e) {
            if (ImportTxtKit.logger.isErrorEnabled()) {
                ImportTxtKit.logger.error("将输入流的TXT进行解析，错误是---->>" + e.getMessage(), e);
            }
        } catch (IOException e) {
            if (ImportTxtKit.logger.isErrorEnabled()) {
                ImportTxtKit.logger.error("将输入流的TXT进行解析，错误是---->>" + e.getMessage(), e);
            }
        } finally {
            if (read != null) {
                try {
                    read.close();
                } catch (IOException e) {
                    if (ImportTxtKit.logger.isErrorEnabled()) {
                        ImportTxtKit.logger.error("输入流的TXT进行解析，错误是---->>" + e.getMessage(), e);
                    }
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    if (ImportTxtKit.logger.isErrorEnabled()) {
                        ImportTxtKit.logger.error("关闭输入流的TXT进行解析，错误是---->>" + e.getMessage(), e);
                    }
                }
            }
        }
        return list;
    }
}