package com.jf.myDemo.common.utilities.math;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.DecimalFormat;

/**
 * 数字工具类
 * Created by Administrator on 2017/9/19 0019.
 */
public class MathKit {
    /**
     * 数字截取工具类日志记录
     */
    private static Logger logger = LogManager.getLogger(MathKit.class);

    /**
     * 将小于1024k的数据直接返回，大于1024k的返回M
     *
     * @param k 要转换的kb数据大小
     * @param index 要保留的小数位数
     * @return String 字符串
     */
    public static String transitionForM(int k,int index) {
        if(k < 1024){
            return k+"KB";
        }else {
            StringBuilder buf = new StringBuilder("#.");
            for(int i = 0;i < index ; i++){
                buf.append("#");
            }
            String pattern = buf.toString();
            DecimalFormat df=new DecimalFormat(pattern);
            double size = k/1024.0;
            return df.format(size) + "M";
        }
    }


    /**
     * 传入总数据量，一页数据条数，返回数据页数
     *
     * @param totalRows 总数据量
     * @param pageSize 一页数据条数
     * @return int 数据页数
     */
    public static int transitionForTotal(int totalRows,int pageSize) {
       return totalRows/pageSize + (totalRows%pageSize == 0 ? 0 :1);
    }
}
