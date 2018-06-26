package com.jf.myDemo.common.utilities.date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Calendar;
import java.util.Date;

/**
 * Date计算方法工具类
 * Created by js on 2015/12/31.
 */
public class DateCalculateKit {
    /**
     * 记录日志信息
     */
    private static Logger logger = LogManager.getLogger(DateCalculateKit.class);

    /**
     * 时间加年计算，时间年增加
     *
     * @param date   待计算时间
     * @param number 改变数量
     * @return 计算后时间
     */
    public static Date addYear(Date date, final int number) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, +number);
        Date date1 = calendar.getTime();
        if (DateCalculateKit.logger.isDebugEnabled()) {
            DateCalculateKit.logger.debug("时间年增加调试日志-->>" + date1);
        }
        return date1;
    }

    /**
     * 时间减年计算，时间年减少
     *
     * @param date   待计算时间
     * @param number 改变数量
     * @return 计算后时间
     */
    public static Date reduceYear(Date date, final int number) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, -number);
        Date date1 = calendar.getTime();
        if (DateCalculateKit.logger.isDebugEnabled()) {
            DateCalculateKit.logger.debug("时间年减少调试日志-->>" + date1);
        }
        return date1;
    }

    /**
     * 时间加月计算，时间月增加
     *
     * @param date   待计算时间
     * @param number 改变数量
     * @return 计算后时间
     */
    public static Date addMonth(Date date, final int number) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, +number);
        Date date1 = calendar.getTime();
        if (DateCalculateKit.logger.isDebugEnabled()) {
            DateCalculateKit.logger.debug("时间月增加调试日志-->>" + date1);
        }
        return date1;
    }

    /**
     * 时间减月计算，时间月减少
     *
     * @param date   待计算时间
     * @param number 改变数量
     * @return 计算后时间
     */
    public static Date reduceMonth(Date date, final int number) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -number);
        Date date1 = calendar.getTime();
        if (DateCalculateKit.logger.isDebugEnabled()) {
            DateCalculateKit.logger.debug("时间月减少调试日志-->>" + date1);
        }
        return date1;
    }

    /**
     * 时间加日计算，时间日增加
     *
     * @param date   待计算时间
     * @param number 改变数量
     * @return 计算后时间
     */
    public static Date addDate(Date date, final int number) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, +number);
        Date date1 = calendar.getTime();
        if (DateCalculateKit.logger.isDebugEnabled()) {
            DateCalculateKit.logger.debug("时间日增加调试日志-->>" + date1);
        }
        return date1;
    }

    /**
     * 时间减日计算，时间日减少
     *
     * @param date   待计算时间
     * @param number 改变数量
     * @return 计算后时间
     */
    public static Date reduceDate(Date date, final int number) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -number);
        Date date1 = calendar.getTime();
        if (DateCalculateKit.logger.isDebugEnabled()) {
            DateCalculateKit.logger.debug("时间日减少调试日志-->>" + date1);
        }
        return date1;
    }

    /**
     * 时间加时计算，时间时增加
     *
     * @param date   待计算时间
     * @param number 改变数量
     * @return 计算后时间
     */
    public static Date addHour(Date date, final int number) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, +number);
        Date date1 = calendar.getTime();
        if (DateCalculateKit.logger.isDebugEnabled()) {
            DateCalculateKit.logger.debug("时间时增加调试日志-->>" + date1);
        }
        return date1;
    }

    /**
     * 时间减时计算，时间时减少
     *
     * @param date   待计算时间
     * @param number 改变数量
     * @return 计算后时间
     */
    public static Date reduceHour(Date date, final int number) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, -number);
        Date date1 = calendar.getTime();
        if (DateCalculateKit.logger.isDebugEnabled()) {
            DateCalculateKit.logger.debug("时间时减少调试日志-->>" + date1);
        }
        return date1;
    }

    /**
     * 时间加分计算，时间分增加
     *
     * @param date   待计算时间
     * @param number 改变数量
     * @return 计算后时间
     */
    public static Date addMinute(Date date, final int number) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, +number);
        Date date1 = calendar.getTime();
        if (DateCalculateKit.logger.isDebugEnabled()) {
            DateCalculateKit.logger.debug("时间分增加调试日志-->>" + date1);
        }
        return date1;
    }

    /**
     * 时间减分计算，时间分减少
     *
     * @param date   待计算时间
     * @param number 改变数量
     * @return 计算后时间
     */
    public static Date reduceMinute(Date date, final int number) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, -number);
        Date date1 = calendar.getTime();
        if (DateCalculateKit.logger.isDebugEnabled()) {
            DateCalculateKit.logger.debug("时间分减少调试日志-->>" + date1);
        }
        return date1;
    }

    /**
     * 时间加秒计算，时间秒增加
     *
     * @param date   待计算时间
     * @param number 改变数量
     * @return 计算后时间
     */
    public static Date addSecond(Date date, final int number) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, +number);
        Date date1 = calendar.getTime();
        if (DateCalculateKit.logger.isDebugEnabled()) {
            DateCalculateKit.logger.debug("时间秒增加调试日志-->>" + date1);
        }
        return date1;
    }

    /**
     * 时间减秒计算，时间秒减少
     *
     * @param date   待计算时间
     * @param number 改变数量
     * @return 计算后时间
     */
    public static Date reduceSecond(Date date, final int number) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, -number);
        Date date1 = calendar.getTime();
        if (DateCalculateKit.logger.isDebugEnabled()) {
            DateCalculateKit.logger.debug("时间秒减少调试日志-->>" + date1);
        }
        return date1;
    }

    /**
     * 根据输入日期，输出星期几
     *
     * @param dt 输入日期
     * @return int 星期
     */
    public static int getWeekdayOfDate(Date dt) {
        // String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"
        // };
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int weekday = cal.get(Calendar.DAY_OF_WEEK) - 1;
        // if (w < 0)
        // w = 0;
        return weekday;
    }


    /**
     * 计算两个时间之间的周数（从周一开始算）
     *
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return 得到的星期天数
     */
    public static int getStartDate2EndDateBetweenDays(Date startDate, Date endDate) {
        if (startDate == null || endDate == null) {
            return 0;
        }
        Calendar startCal = Calendar.getInstance();
        Calendar endCal = Calendar.getInstance();
        if (startDate.before(endDate)) {
            startCal.setTime(startDate);
            endCal.setTime(endDate);
        } else {
            startCal.setTime(endDate);
            endCal.setTime(startDate);
        }

        int startDayOfWeek = startCal.get(Calendar.DAY_OF_WEEK);
        if (startDayOfWeek == 1) {
            startDayOfWeek = 8;
        }
        // 设置日期为这周的周一
        startCal.add(Calendar.DATE, 2 - startDayOfWeek);
        int endDayOfWeek = endCal.get(Calendar.DAY_OF_WEEK);
        if (endDayOfWeek == 1) {
            endDayOfWeek = 8;
        }
        endCal.add(Calendar.DATE, 2 - endDayOfWeek);
        int weeks = (int) ((endCal.getTimeInMillis() - startCal
                .getTimeInMillis()) / (1000 * 3600 * 24 * 7));
        return ++weeks;
    }

}
