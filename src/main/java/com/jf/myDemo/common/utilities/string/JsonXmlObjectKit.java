package com.jf.myDemo.common.utilities.string;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * JSON,XML,OBJECT转换处理工具类
 * Created by js on 2017/3/23.
 */
public class JsonXmlObjectKit {
    /**
     * JSON,XML,OBJECT转换处理工具类日志记录
     */
    private static Logger logger = LogManager.getLogger(JsonXmlObjectKit.class);
    /**
     * 用于处理json字符串的静态对象
     */
    private static ObjectMapper objectMapper = new ObjectMapper();
    /**
     * 编码方式
     */
    private final static String CODING = "UTF-8";

    /**
     * 将OBJECT对象转化成XML字符串
     * 出现异常返回NULL
     *
     * @param object 对象
     * @return String 字符串
     */
    public static String convertObjectXml(Object object) {
        String result = null;
        try {
            if (object != null) {
                JAXBContext context = JAXBContext.newInstance(object.getClass());
                Marshaller marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                marshaller.setProperty(Marshaller.JAXB_ENCODING, JsonXmlObjectKit.CODING);
                StringWriter writer = new StringWriter();
                marshaller.marshal(object, writer);
                result = writer.toString();
            }
        } catch (JAXBException e) {
            if (JsonXmlObjectKit.logger.isErrorEnabled()) {
                JsonXmlObjectKit.logger.error("将OBJECT对象转化成XML字符串，错误是---->>" + e.getMessage(), e);
            }
        }
        return result;
    }

    /**
     * 将XML字符串转化成指定对象
     * 出现异常返回NULL
     *
     * @param xml   字符串
     * @param <T>   泛型
     * @param clazz 字节码
     * @return <T> T 对象
     */
    public static <T> T convertXmlObject(final String xml, Class<T> clazz) {
        T t = null;
        try {
            if (xml != null) {
                JAXBContext context = JAXBContext.newInstance(clazz);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                t = (T) unmarshaller.unmarshal(new StringReader(xml));
            }
        } catch (JAXBException e) {
            if (JsonXmlObjectKit.logger.isErrorEnabled()) {
                JsonXmlObjectKit.logger.error("将XML字符串转化成指定对象，错误是---->>" + e.getMessage(), e);
            }
        }
        return t;
    }

    /**
     * 将OBJECT对象转化成JSON字符串
     * 出现异常返回NULL
     *
     * @param object 对象
     * @return String 字符串
     */
    public static String convertObjectJson(Object object) {
        Writer writer = null;
        String json = null;
        try {
            if (object != null) {
                writer = new StringWriter();
                JsonXmlObjectKit.objectMapper.writeValue(writer, object);
                json = writer.toString();
            }
        } catch (IOException e) {
            if (JsonXmlObjectKit.logger.isErrorEnabled()) {
                JsonXmlObjectKit.logger.error("将OBJECT对象转化成JSON字符串，错误是---->>" + e.getMessage(), e);
            }
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                if (JsonXmlObjectKit.logger.isErrorEnabled()) {
                    JsonXmlObjectKit.logger.error("将OBJECT对象转化成JSON字符串，错误是---->>" + e.getMessage(), e);
                }
            }
        }
        return json;
    }

    /**
     * 将JSON字符串转化成指定对象
     * 出现异常返回NULL
     *
     * @param json  字符串
     * @param <T>   泛型
     * @param clazz 字节码
     * @return <T> T 对象
     */
    public static <T> T convertJsonObject(final String json, Class<T> clazz) {
        T t = null;
        try {
            if (json != null) {
                JsonXmlObjectKit.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                t = JsonXmlObjectKit.objectMapper.readValue(json, clazz);
            }
        } catch (IOException e) {
            if (JsonXmlObjectKit.logger.isErrorEnabled()) {
                JsonXmlObjectKit.logger.error("将JSON字符串转化成指定对象，错误是---->>" + e.getMessage(), e);
            }
        }
        return t;
    }

    /**
     * 将JSON字符串转化成指定集合
     * 出现异常返回NULL
     *
     * @param json            字符串
     * @param collectionClass 集合
     * @param valueType       元素类
     * @return <T> T 集合
     */
    public static <T> T convertJsonCollection(final String json, Class<?> collectionClass, Class<?>... valueType) {
        T t = null;
        try {
            if (json != null) {
                JavaType javaType = JsonXmlObjectKit.objectMapper.getTypeFactory().constructParametricType(collectionClass, valueType);
                t = JsonXmlObjectKit.objectMapper.readValue(json, javaType);
            }
        } catch (IOException e) {
            if (JsonXmlObjectKit.logger.isErrorEnabled()) {
                JsonXmlObjectKit.logger.error("将JSON字符串转化成指定集合，错误是---->>" + e.getMessage(), e);
            }
        }
        return t;
    }

    /**
     * 将JSON字符串转化成指定集合
     * 出现异常返回NULL
     *
     * @param json 字符串
     * @return <T> T 集合
     */
    public static <T> T convertJsonCollection(final String json) {
        T t = null;
        try {
            if (json != null) {
                t = JsonXmlObjectKit.objectMapper.readValue(json, new TypeReference<T>() {
                });
            }
        } catch (IOException e) {
            if (JsonXmlObjectKit.logger.isErrorEnabled()) {
                JsonXmlObjectKit.logger.error("将JSON字符串转化成指定集合，错误是---->>" + e.getMessage(), e);
            }
        }
        return t;
    }

    /**
     * 将map对象转化成xml字符串
     *
     * @param map 集合
     * @return String 字符串
     */
    public static String convertMapXml(Map<String, Object> map) {
        StringBuilder xml = new StringBuilder();
        xml.append("<?xml version=\"1.0\" encoding=\"utf-8\"?><file>");
        if (!map.isEmpty()) {
            JsonXmlObjectKit.getMapXml(xml, map);
        }
        xml.append("</file>");
        return xml.toString();
    }

    /**
     * 将list集合转化成xml字符串
     *
     * @param list 集合
     * @return String 字符串
     */
    public static String convertListXml(List<Map<String, Object>> list, final String name) {
        StringBuilder xml = new StringBuilder();
        xml.append("<?xml version=\"1.0\" encoding=\"utf-8\"?><file>");
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                Map<String, Object> map = list.get(i);
                if (!map.isEmpty()) {
                    xml.append("<");
                    xml.append(name);
                    xml.append(">");
                    JsonXmlObjectKit.getMapXml(xml, map);
                    xml.append("</");
                    xml.append(name);
                    xml.append(">");
                }
            }
            xml.append("</file>");
        }
        return xml.toString();
    }

    /**
     * 集合转化成xml字符串
     *
     * @param xml xml
     * @param map 集合
     */
    private static void getMapXml(StringBuilder xml, Map<String, Object> map) {
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            String key = String.valueOf(entry.getKey());
            String value = String.valueOf(entry.getValue());
            xml.append("<");
            xml.append(key);
            xml.append(">");
            xml.append(value);
            xml.append("</");
            xml.append(key);
            xml.append(">");
        }
    }
}