package com.jf.myDemo.common.utilities.string;

import sun.misc.BASE64Decoder;

/**
 * Base64加密/解密处理工具类
 * @author Created  by wxl on 2018/1/23 0023.
 */
public class Base64Kit {
    /**
     * 将 BASE64 编码的字符串 s 进行解码
     *
     * @return String
     * @author wxl
     * @date
     */
    public static String decodeBase64(String s) {
        if (s == null) {
            return null;
        }
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            //将转码中的空格转换成+号
            s = s.replace(" ","+");
            byte[] b = decoder.decodeBuffer(s);
            return new String(b,"utf-8");
        } catch (Exception e) {
            return null;
        }
    }
}
