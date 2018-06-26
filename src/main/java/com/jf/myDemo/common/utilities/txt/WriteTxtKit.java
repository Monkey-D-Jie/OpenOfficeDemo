package com.jf.myDemo.common.utilities.txt;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

/**
 * 写入文件工具类
 * Created by xdj on 2017/9/6.
 */
public class WriteTxtKit {

    private static Logger logger = LogManager.getLogger(WriteTxtKit.class);

    /**
     * 编码方式
     */
    private final static String CODING = "UTF-8";

    /**
     * 新建或追加内容到一个文件
     *
     * @param path     文件目录
     * @param fileName 文件名
     * @param content  内容
     * @param append   是否追加写入文件
     * @return 是否写入成功
     */
    public static boolean writeFile(String path, String fileName, String content, boolean append) {
        File dir = new File(path);
        if (dir.exists() || dir.mkdirs()) {
            Writer writer = null;
            try {
                OutputStream os = new FileOutputStream(path + File.separator + fileName, append);
                writer = new OutputStreamWriter(os, CODING);
                writer.write(content);
                writer.flush();
            } catch (IOException e) {
                if (logger.isErrorEnabled()) {
                    logger.error("写入文件错误", e);
                }
                return false;
            } finally {
                if (writer != null) {
                    try {
                        writer.close();
                    } catch (IOException e) {
                        if (logger.isErrorEnabled()) {
                            logger.error("写入文件关闭流异常", e);
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    /**
     * 以指定编码方式读取文件，返回文件内容
     *
     * @param file
     *            要转换的文件
     * @param fromCharsetName
     *            源文件的编码
     * @return
     * @throws Exception
     */
    public static String getFileContentFromCharset(File file,
                                             String fromCharsetName) throws Exception {
        if (!Charset.isSupported(fromCharsetName)) {
            throw new UnsupportedCharsetException(fromCharsetName);
        }
        InputStream inputStream = new FileInputStream(file);
        InputStreamReader reader = new InputStreamReader(inputStream,
                fromCharsetName);
        char[] chs = new char[(int) file.length()];
        reader.read(chs);
        String str = new String(chs).trim();
        reader.close();
        return str;
    }

    /**
     * 以指定编码方式写文本文件，存在会覆盖
     *
     * @param file
     *            要写入的文件
     * @param toCharsetName
     *            要转换的编码
     * @param content
     *            文件内容
     * @throws Exception
     */
    public static void saveFile2Charset(File file, String toCharsetName,
                                  String content) throws Exception {
        if (!Charset.isSupported(toCharsetName)) {
            throw new UnsupportedCharsetException(toCharsetName);
        }
        OutputStream outputStream = new FileOutputStream(file);
        OutputStreamWriter outWrite = new OutputStreamWriter(outputStream,
                toCharsetName);
        outWrite.write(content);
        outWrite.close();
    }
}
