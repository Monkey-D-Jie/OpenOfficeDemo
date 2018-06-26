package com.jf.myDemo.common.utilities.date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Data与字符串转化工具类
 * Created by js on 2015/12/31.
 */
public class DateFormatKit {
    /**
     * 记录日志信息
     */
    private static Logger logger = LogManager.getLogger(DateFormatKit.class.getName());
    /**
     * 格式化字符串，年月日时分秒
     */
    public final static String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /**
     * 格式化字符串，年月日
     */
    public final static String DATE_FORMAT_ONE = "yyyy-MM-dd";
    /**
     * 格式化字符串，时分秒
     */
    public final static String DATE_FORMAT_TWO = "HH:mm:ss";
    /**
     * 格式化字符串，月日
     */
    public final static String DATE_FORMAT_THREE = "MM-dd";

    /**
     * 时间转化成字符串，并且格式化，本类中提供三种格式化字符串
     *
     * @param dateFormat 格式化字符串
     * @param date       待格式化时间
     * @return 格式化后字符串
     */
    public static String convert(final String dateFormat, final Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        String time = formatter.format(date);
        if (DateFormatKit.logger.isDebugEnabled()) {
            DateFormatKit.logger.debug("时间转化成字符串调试日志---->>" + time);
        }
        return time;
    }

    /**
     * 字符串转化成时间，并且格式化，本类中提供三种格式化字符串
     * 出现异常返回NULL
     *
     * @param dateFormat 格式化字符串
     * @param time       待格式化字符串
     * @return 格式化后时间
     */
    public static Date convert(final String dateFormat, final String time) {
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        Date date = null;
        try {
            date = formatter.parse(time);
            if (DateFormatKit.logger.isDebugEnabled()) {
                DateFormatKit.logger.debug("字符串转化成时间调试日志---->>" + date);
            }
        } catch (ParseException e) {
            if (DateFormatKit.logger.isErrorEnabled()) {
                DateFormatKit.logger.error("字符串转化成时间错误日志---->>" + e.getMessage(), e);
            }
        }
        return date;
    }
}
