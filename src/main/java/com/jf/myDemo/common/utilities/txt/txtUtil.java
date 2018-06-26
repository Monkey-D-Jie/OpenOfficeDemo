package com.jf.myDemo.common.utilities.txt;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2018-06-05 15:41
 * @Description: 这里是描述
 * To change this template use File | Settings | File and Templates.
 */

public class txtUtil {
    public static File TXTHandler(File file) {
        //或GBK
//        String code = "gb2312";
        String code = "GBK";
        byte[] head = new byte[3];
        try {
            InputStream inputStream = new FileInputStream(file);
            inputStream.read(head);
            if (head[0] == -1 && head[1] == -2) {
                code = "UTF-16";
            } else if (head[0] == -2 && head[1] == -1) {
                code = "Unicode";
            } else if (head[0] == -17 && head[1] == -69 && head[2] == -65) {
                code = "UTF-8";
            }
            inputStream.close();

            System.out.println(code);
            if (code.equals("UTF-8")) {
                return file;
            }
            String str = FileUtils.readFileToString(file, code);
            FileUtils.writeStringToFile(file, str, "UTF-8");
            System.out.println("转码结束---->统一成了utf-8的类型");
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        return file;
    }
}
