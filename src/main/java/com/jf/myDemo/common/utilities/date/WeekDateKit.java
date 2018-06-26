package com.jf.myDemo.common.utilities.date;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class WeekDateKit {

    private static final int WEEK = 7;
    private static final long MILLISECONDS_PER_DAY = 24L * 3600 * 1000;

    /**
     * 由学期开始时间，周次，星期几获取到星期数对应的日期
     * Created by wjie on 2017/9/15 0015.
     */
    public static String getWeekDate(Date sbeginDate, int weekday, int weeks, String dateFormat) {
        String date = "";
        if (sbeginDate != null && weekday != 0 && weeks != 0) {
            Map<String, Object> weekMap = new HashMap<String, Object>();
            Calendar cal = Calendar.getInstance();
            cal.setTime(sbeginDate);
            /*判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了*/
            int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
            if (1 == dayWeek) {
                cal.add(Calendar.DAY_OF_MONTH, -1);
            }
            /*设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一*/
            cal.setFirstDayOfWeek(Calendar.MONDAY);
            /*获得当前日期是一个星期的第几天*/
            int day = cal.get(Calendar.DAY_OF_WEEK);
            /*根据日历的规则，给当前日期减去星期几与一个星期第一天的差值*/
            cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
            /*获取到传入日期所在周的周一*/
            long time = cal.getTime().getTime()+(weeks-1)*WEEK*MILLISECONDS_PER_DAY;
            Date mondayDate = new Date(time);
            for (int i = 1; i <= WEEK; i++) {
                String weekDay = DateFormatKit.convert(dateFormat,DateCalculateKit.addDate(mondayDate,i-1));
                weekMap.put("week"+i, weekDay);
            }
            date = String.valueOf(weekMap.get("week" + weekday));
        }
        return date;
    }
}
