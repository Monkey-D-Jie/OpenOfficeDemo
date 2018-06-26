package com.jf.myDemo.common.utilities.string;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密处理工具类
 * Created by js on 2017/3/27.
 */
public class Md5Kit {
    /**
     * MD5加密处理工具类日志记录
     */
    private static Logger logger = LogManager.getLogger(Md5Kit.class);
    /**
     * 编码方式
     */
    private final static String CODING = "UTF-8";

    /**
     * 将字符串进行MD5加密计算
     * 出现异常返回NULL
     *
     * @param str 待加密字符串
     * @return String　加密后字符串
     */
    public static String encodeMD5(final String str) {
        /*密钥*/
        final String KEY = "MD5";
        String newStr = null;
        try {
            /*MD5加密计算*/
            MessageDigest md5 = MessageDigest.getInstance(KEY);
            /*UTF-8编码字节*/
            byte[] md5Bytes = md5.digest(str.getBytes(Md5Kit.CODING));
            StringBuilder hexValue = new StringBuilder();
            /*遍历转化成32位*/
            for (int i = 0; i < md5Bytes.length; i++) {
                int val = ((int) md5Bytes[i]) & 0xff;
                if (val < 16) {
                    hexValue.append("0");
                }
                hexValue.append(Integer.toHexString(val));
            }
            /*转换成字符串*/
            newStr = hexValue.toString().toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            if (Md5Kit.logger.isErrorEnabled()) {
                Md5Kit.logger.error("将字符串进行MD5加密计算，错误是---->>" + e.getMessage(), e);
            }
        } catch (UnsupportedEncodingException e) {
            if (Md5Kit.logger.isErrorEnabled()) {
                Md5Kit.logger.error("将字符串进行MD5加密计算，错误是---->>" + e.getMessage(), e);
            }
        }
        return newStr;
    }
}