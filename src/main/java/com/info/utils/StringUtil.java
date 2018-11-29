package com.info.utils;

import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 王勇 on 2018/6/28 0028.
 */
public class StringUtil extends StringUtils {

    private static final String CHARSET_NAME = "UTF-8";

    /**
     * 转换为字节数组
     * @param str
     * @return
     */
    public static byte[] getBytes(String str){
        if (str != null){
            try {
                return str.getBytes(CHARSET_NAME);
            } catch (UnsupportedEncodingException e) {
                return null;
            }
        }else{
            return null;
        }
    }

    /**
     * 转换为字符串
     * @param bytes
     * @return
     */
    public static String toString(byte[] bytes){
        try {
            return new String(bytes, CHARSET_NAME);
        } catch (UnsupportedEncodingException e) {
            return EMPTY;
        }
    }

    public static Map getMap(String str){
        String[] strs = str.split("\\|");
        Map<String,String> map = new HashMap<String,String>(strs.length);
        for (String field : strs){
            String[] split = field.split("\\:");
            for (int i = 0; i < split.length-1; i++) {
                map.put(split[i],split[i+1]);
            }

        }
        return map;
    }
    public static Map conventMap(String str){
        String[] strs = str.split("\\|");
        Map<String,String> map = new HashMap<String,String>(strs.length);
        for (String field : strs){
            String[] split = field.split("\\:");
            for (int i = 0; i < split.length-1; i++) {
                map.put(split[i+1],split[i]);
            }

        }
        return map;
    }
}
