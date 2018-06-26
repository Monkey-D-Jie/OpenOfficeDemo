package com.jf.myDemo.common.utilities.string;

import java.util.Map;

/**
 *9527地址返回解析工具类
 * Created by wjie on 2017/8/22 0022.
 * 待审核：哪些字符算是特殊字符？
 */
public class UrlKit {

    /**
     * 解析9527返回字符串
     * @param urlData
     * @return 文件点击地址
     */
    public static String convertUrl(String urlData) {
        String httpUrl = null;
        if(urlData != null && !"".equals(urlData)){
            try {
                  /*解析字符串*/
                Map<String, Object> data = JsonXmlObjectKit.convertJsonObject(urlData,Map.class);
                if(data != null){
                    String msg = data.get("message") == null ? null : String.valueOf(data.get("message"));
                    if("成功！".equals(msg)){
                        Map<String, Object> httpData = (Map<String, Object>)data.get("data");
                        httpUrl = httpData.get("url") == null ? null : String.valueOf(httpData.get("url"));
                    }
                }
            }catch (NumberFormatException e){
                throw e;
            }
        }
        return httpUrl;
    }
}
