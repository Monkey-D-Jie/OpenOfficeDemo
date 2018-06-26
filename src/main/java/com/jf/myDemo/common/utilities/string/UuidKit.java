package com.jf.myDemo.common.utilities.string;

import java.util.UUID;

/**
 * UUID工具类
 * Created by js on 2017/3/14.
 */
public class UuidKit {
    /**
     * 将原生UUID截取成32位UUID
     *
     * @return String UUID
     */
    public static String createUuid() {
        String uuidStr = String.valueOf(UUID.randomUUID()).toUpperCase();
        return uuidStr.substring(0, 8) + uuidStr.substring(9, 13) + uuidStr.substring(14, 18) + uuidStr.substring(19, 23) + uuidStr.substring(24);
    }

    public static String changeNum(int num) {
        String[] str = {"一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二", "十三", "十四", "十五", "十六", "十七", "十八", "十九"};
        if (0 <= num && num < 19) {
            return "第" + str[(num - 1)] + "节";
        } else {
            return "未知节次";
        }
    }
}