package com.jf.myDemo.common.utilities.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *字符串合法性判断工具类
 * Created by wjie on 2017/8/22 0022.
 * 待审核：哪些字符算是特殊字符？
 */
public class CharacterKit {

    /**
     * 判断是否含有特殊字符
     * @param str
     * @return true为包含，false为不包含
     */
    public static boolean isSpecialChar(String str) {
        String regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.find();
    }
}
