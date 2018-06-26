package com.jf.myDemo.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2018-06-05 15:07
 * @Description: 获取到xxofficeHome的工具类
 * To change this template use File | Settings | File and Templates.
 */

public class OfficeHomeUtil {

    private static Logger logger = LogManager.getLogger(OfficeHomeUtil.class);

    /**
     * 打开libreOffice服务的方法
     *
     * @return
     */

    public static String getLibreOfficeHome() {
        String osName = System.getProperty("os.name");
        if (Pattern.matches("Linux.*", osName)) {
            //获取linux系统下libreoffice主程序的位置
            logger.info("获取Linux系统LibreOffice路径");
            return "/opt/libreoffice 5/program/soffice";
        } else if (Pattern.matches("Windows.*", osName)) {
            //获取windows系统下libreoffice主程序的位置
            logger.info("获取windows系统LibreOffice路径");
            return "D:/Software/LibreOffice";
        }
        return null;
    }
}
