package com.daily.analysis.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {
    private static final Logger log = LoggerFactory.getLogger(PropertiesUtils.class);

    protected static final String DEFAULT_FILE_NAME = "conf/conf.properties";



    /**
     * 通过properties[文件名称：fileName],[属性名称：properyName]获取属性值
     * @param fileName
     * @param key
     * @return propertyValue
     */
    public static String getProperty(String fileName, String key){
        if(fileName == null || fileName.trim().isEmpty()){
            log.error("**********没有找到" + fileName + ".properties文件**********");
            return null;
        }

        if(key == null || key.trim().isEmpty()){
            log.error("**********没有找到" + key + "属性**********");
            return null;
        }

        Properties props = new Properties();
        String fieldValue = "";
        InputStream is = null;
        try {
            is = PropertiesUtils.class.getClassLoader().getResourceAsStream(fileName);
            props.load(is);
            if(!props.containsKey(key)){
                log.error("**********从" + fileName + ".properties文件获取"+ key + "失败**********");
                return fieldValue;
            }
            fieldValue = props.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("**********从" + fileName + ".properties文件获取"+ key + "失败**********");
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fieldValue;
    }

    public static String getProperty(String key) {
        return getProperty(DEFAULT_FILE_NAME,key);
    }

}
